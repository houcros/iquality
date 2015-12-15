/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.indra.iquality.dao.TechnicalCertificateDAO;
import com.indra.iquality.model.DetailOfValidation;
import com.indra.iquality.model.TechnicalCertificate;
import com.indra.iquality.singleton.Environment;

/**
 * Implementation of {@link com.indra.iquality.dao.TechnicalCertificateDAO}
 * using JDBC to connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class TechnicalCertificateDAOJDBCTemplateImpl.
 */
public class TechnicalCertificateDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl
		implements TechnicalCertificateDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(TechnicalCertificateDAOJDBCTemplateImpl.class);

	/**
	 * The description of the headers of the detailed view of the last
	 * certificate consulted.
	 */
	private int lastNumCols = 0;

	/**
	 * The description of the headers of the detailed view of the last
	 * certificate consulted.
	 */
	private List<String> headers = new ArrayList<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.TechnicalCertificateDAO#getAll(java.lang.String,
	 * int)
	 */
	@Override
	public List<TechnicalCertificate> getAll(String sistema, int software) {

		logger.info("[getAll] : INIT");

		String query = "SELECT" + " AG.ID_MES," + " AG.ID_METRICA,"
				+ " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha," + " SECC.DE_SECCION AS SECCION,"
				+ " SUBSECC.DE_SUBSECCION AS SUBSECCION," + " TAB.DE_TABLA AS ENTIDAD,"
				+ " ERR.DE_ERROR AS CERTIFICACION," + " AG.ID_ERROR,"
				+ " sum(AG.HC_VALOR_METRICA_ACT) as NUM_REGISTROS," + " CASE"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'" + " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'"
				+ " END AS OKKO" + " FROM" + " AG_MET_IQ_CERTIF_FUNCIONAL AG," + " LK_MET_IQ_ERROR ERR,"
				+ " LK_MET_IQ_TABLA TAB," + " LK_MET_FI_SECCION SECC," + " LK_MET_FI_SUBSECCION SUBSECC,"
				+ " LK_MET_IQ_METRICA METR," + " LK_MET_IQ_CONDICION COND" + " WHERE"
				+ " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND" + " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND"
				+ " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND" + " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND"
				+ " SUBSECC.ID_SECCION = SECC.ID_SECCION AND" + " AG.ID_TABLA_HC = TAB.ID_TABLA AND"
				+ " AG.ID_SISTEMA_HC = TAB.ID_SISTEMA AND" + " AG.ID_METRICA = METR.ID_METRICA AND"
				+ " METR.ID_SN_CERTIFICACION_VALID = 'S' AND"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND" + " COND.ID_ERROR = ERR.ID_ERROR AND"
				+ " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ?" + " GROUP BY AG.ID_MES," + " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION," + " TAB.DE_TABLA," + " ERR.DE_ERROR,"
				+ " AG.ID_ERROR, AG.ID_METRICA, TAB.ID_SOFTWARE, TAB.ID_TABLA";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<TechnicalCertificate> validacionList = new ArrayList<TechnicalCertificate>();
		List<Map<String, Object>> validacionRows = jdbcTemplate.queryForList(query, new Object[] { sistema, software });

		// Mapeo a una lista
		for (Map<String, Object> validacionRow : validacionRows) {

			TechnicalCertificate validacion = new TechnicalCertificate();

			validacion.setIdMetrica(helper.filterNullString(String.valueOf(validacionRow.get("id_metrica"))));
			validacion.setIdMes(helper.filterNullString(String.valueOf(validacionRow.get("id_mes"))));
			validacion.setFecha(helper.filterNullString(String.valueOf(validacionRow.get("fecha"))));
			validacion.setSeccion(helper.filterNullString(String.valueOf(validacionRow.get("seccion"))));
			validacion.setSubseccion(helper.filterNullString(String.valueOf(validacionRow.get("subseccion"))));
			validacion.setEntidad(helper.filterNullString(String.valueOf(validacionRow.get("entidad"))));
			validacion.setCertificacion(helper.filterNullString(String.valueOf(validacionRow.get("certificacion"))));
			validacion.setNumRegistros(
					helper.filterNullInt(Integer.valueOf(String.valueOf(validacionRow.get("num_registros")))));
			validacion.setEstado(helper.filterNullString(String.valueOf(validacionRow.get("okko"))));

			validacionList.add(validacion);
		}

		logger.info("[getAll] : RETURN");
		return validacionList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.TechnicalCertificateDAO#getCertificateDetails(java
	 * .lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<DetailOfValidation> getCertificateDetails(String idMetrica, String idMes, String sistema,
			int software) {
		// TODO usar sistema y software?

		logger.info("[getDetallesDeValidacion] : INIT");

		// Obtengo la query con el método auxiliar
		String query = getQuery(idMetrica, idMes, sistema, software);
		if (query == null || query.equals("")) {
			logger.error("[getDetallesDeValidacion] : Has intentado ejecutar una query nula o vacía");
			return new ArrayList<DetailOfValidation>();
		}

		// Hago la query
		List<DetailOfValidation> ddvList = new ArrayList<DetailOfValidation>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> anonymousRows = jdbcTemplate.queryForList(query);

		// Tomo el número de columnas que tendrá
		lastNumCols = anonymousRows.isEmpty() ? 0 : anonymousRows.get(0).size();
		// Tomo los headers; importante vaciar antes
		headers.clear();
		if (anonymousRows.size() > 0) {
			for (Map.Entry<String, Object> entry : anonymousRows.get(0).entrySet())
				headers.add(entry.getKey());
		}
		// Agrego stubs a los headers que sobran (aunque no hace falta)
		while (headers.size() < DetailOfValidation.MAX_DIMENSIONES)
			headers.add("_STUB");

		logger.debug("[getDetallesDeValidacion] : Obtenidos headers.");

		// Mapeo
		for (Map<String, Object> anonymousRow : anonymousRows) {

			List<String> strs = new ArrayList<String>();
			for (Map.Entry<String, Object> entry : anonymousRow.entrySet()) {
				strs.add(String.valueOf(entry.getValue()));
			}
			while (strs.size() < DetailOfValidation.MAX_DIMENSIONES) {
				strs.add(Environment.DEFAULT_NULL_STRING);
			}

			ddvList.add(new DetailOfValidation(strs));
		}

		logger.info("[getDetallesDeValidacion] : RETURN");
		return ddvList;
	}

	/**
	 * Auxiliary method to get the query needed to get the details of a
	 * technical certificate.
	 *
	 * @param idMetrica
	 *            the identifier of the metric of the certificate
	 * @param idMes
	 *            the month of execution of the certificate
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the query to get the details
	 */
	private String getQuery(String idMetrica, String idMes, String sistema, int software) {
		// TODO usar sistema y software?

		logger.info("[getQuery] : INIT");

		// Query para obtener la query xD
		String query = "SELECT" + " DE_QUERY FROM BS_MET_IQ_VALIDACION" + " WHERE ID_METRICA = ? AND ID_MES = ?";

		// Hago la query y mapeo a un String
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String resultQuery = jdbcTemplate.query(query, new Object[] { idMetrica, idMes },
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs) throws SQLException, DataAccessException {
						return rs.next() ? rs.getString("de_query") : null;
					}
				});

		logger.info("[getQuery] : RETURN");
		return resultQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.TechnicalCertificateDAO#getLastNumCols()
	 */
	@Override
	public int getLastNumCols() {
		return lastNumCols;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.TechnicalCertificateDAO#getHeaders()
	 */
	@Override
	public List<String> getHeaders() {
		return headers;
	}
}
