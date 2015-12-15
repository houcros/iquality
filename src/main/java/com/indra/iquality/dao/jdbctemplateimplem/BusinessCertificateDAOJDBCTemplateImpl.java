/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.BusinessCertificateDAO;
import com.indra.iquality.model.BusinessCertificate;
import com.indra.iquality.model.DetailOfCertificate;

/**
 * Implementation of {@link com.indra.iquality.dao.BusinessCertificateDAO} using
 * JDBC to connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class BusinessCertificateDAOJDBCTemplateImpl.
 */
public class BusinessCertificateDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl
		implements BusinessCertificateDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(BusinessCertificateDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.BusinessCertificateDAO#getAll(java.lang.String,
	 * int)
	 */
	@Override
	public List<BusinessCertificate> getAll(String sistema, int software) {

		logger.info("[getAll] : INIT");

		String query = "SELECT" + " AG.ID_MES," + " AG.ID_METRICA,"
				+ " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha," + " SECC.DE_SECCION AS SECCION,"
				+ " SUBSECC.DE_SUBSECCION AS SUBSECCION," + " TAB.DE_TABLA AS ENTIDAD," + " COMP.DE_NOMBRE AS METRICA,"
				+ " ERR.DE_ERROR AS CERTIFICACION," + " CERT.DE_CERTIFICACION," + " max(cond.ID_ERROR)," + " CASE"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'" + " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'"
				+ " END AS OKKO" + " from AG_MET_IQ_CERTIF_FUNCIONAL AG," + " LK_MET_IQ_TABLA TAB,"
				+ " LK_MET_FI_SECCION SECC," + " LK_MET_FI_SUBSECCION SUBSECC," + " LK_MET_IQ_METRICA METR,"
				+ " LK_MET_IQ_CONDICION COND," + " LK_MET_IQ_ERROR ERR," + " LK_MET_FI_CERTIFICACION CERT,"
				+ " LK_MET_FI_COMPONENTE COMP" + " where" + " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ? AND"
				+ " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND" + " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND"
				+ " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND" + " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND"
				+ " SUBSECC.ID_SECCION = SECC.ID_SECCION AND" + " CERT.ID_TABLA_HIJO = TAB.ID_TABLA and"
				+ " ? = TAB.ID_SISTEMA and" + " AG.ID_METRICA = METR.ID_METRICA and"
				+ " AG.ID_TABLA_HC = METR.ID_TABLA_HC and" + " AG.ID_SISTEMA_HC = METR.ID_SISTEMA_HC AND"
				+ " METR.ID_SISTEMA_HC = CERT.ID_SISTEMA AND" + " COND.ID_ERROR = CERT.ID_IQ_CERTIFICACION and"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND" + " CERT.ID_SISTEMA = COMP.ID_SISTEMA AND"
				+ " CERT.ID_SOFTWARE = COMP.ID_SOFTWARE AND" + " CERT.ID_COMPONENTE_HIJO = COMP.ID_COMPONENTE AND"
				+ " COND.ID_ERROR = ERR.ID_ERROR" + " GROUP BY AG.ID_MES," + " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION," + " TAB.DE_TABLA," + " COMP.DE_NOMBRE,"
				+ " ERR.DE_ERROR,CERT.DE_CERTIFICACION," + " AG.ID_METRICA" + " union all" + " SELECT" + " AG.ID_MES,"
				+ " AG.ID_METRICA," + " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha,"
				+ " SECC.DE_SECCION AS SECCION," + " SUBSECC.DE_SUBSECCION AS SUBSECCION," + " TAB.DE_TABLA AS ENTIDAD,"
				+ " COMP.DE_NOMBRE AS METRICA," + " ERR.DE_ERROR AS CERTIFICACION,CERT.DE_CERTIFICACION,"
				+ " max(COND.ID_ERROR)," + " CASE" + " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'" + " END AS OKKO"
				+ " FROM AG_MET_IQ_CERTIF_HISTORIA AG," + " LK_MET_IQ_TABLA TAB," + " LK_MET_IQ_ERROR ERR,"
				+ " LK_MET_FI_SECCION SECC," + " LK_MET_FI_SUBSECCION SUBSECC," + " LK_MET_FI_CERTIFICACION CERT,"
				+ " LK_MET_FI_COMPONENTE COMP," + " LK_MET_IQ_METRICA METR," + " LK_MET_IQ_CONDICION COND" + " WHERE"
				+ " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ? AND" + " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND"
				+ " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND" + " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND"
				+ " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND" + " SUBSECC.ID_SECCION = SECC.ID_SECCION AND"
				+ " AG.ID_TABLA_HC = TAB.ID_TABLA AND" + " AG.ID_SISTEMA_HC = TAB.ID_SISTEMA AND"
				+ " AG.ID_METRICA = METR.ID_METRICA AND" + " AG.ID_TABLA_HC = METR.ID_TABLA_HC AND"
				+ " AG.ID_SISTEMA_HC = METR.ID_SISTEMA_HC AND"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND" + " COND.ID_ERROR = ERR.ID_ERROR AND"
				+ " AG.ID_SISTEMA_HC = CERT.ID_SISTEMA AND" + " COND.ID_ERROR = CERT.ID_IQ_CERTIFICACION AND"
				+ " CERT.ID_SISTEMA = COMP.ID_SISTEMA AND" + " CERT.ID_SOFTWARE = COMP.ID_SOFTWARE AND"
				+ " CERT.ID_COMPONENTE_HIJO = COMP.ID_COMPONENTE" + " GROUP BY AG.ID_MES," + " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION," + " TAB.DE_TABLA," + " COMP.DE_NOMBRE,"
				+ " ERR.DE_ERROR,CERT.DE_CERTIFICACION," + " AG.ID_METRICA";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<BusinessCertificate> certDeNegocioList = new ArrayList<BusinessCertificate>();
		List<Map<String, Object>> certDeNegocioRows = jdbcTemplate.queryForList(query,
				new Object[] { sistema, software, sistema, sistema, software });

		// Mapeo los resultados a una lista
		for (Map<String, Object> certDeNegocioRow : certDeNegocioRows) {

			BusinessCertificate certDeNegocio = new BusinessCertificate();

			// Lo necesito para obtener los headers con getHeadersDetalles()
			certDeNegocio.setIdMetrica(String.valueOf(certDeNegocioRow.get("ID_METRICA")));
			certDeNegocio.setIdMes(helper.filterNullString(String.valueOf(certDeNegocioRow.get("ID_MES"))));

			certDeNegocio.setFecha(helper.filterNullString(String.valueOf(certDeNegocioRow.get("fecha"))));
			certDeNegocio.setSeccion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("seccion"))));
			certDeNegocio.setSubseccion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("subseccion"))));
			certDeNegocio.setEntidad(helper.filterNullString(String.valueOf(certDeNegocioRow.get("entidad"))));
			certDeNegocio
					.setCertificacion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("certificacion"))));
			certDeNegocio.setDeCertificacion(
					helper.filterNullString(String.valueOf(certDeNegocioRow.get("de_certificacion"))));
			certDeNegocio.setEstado(helper.filterNullString(String.valueOf(certDeNegocioRow.get("okko"))));
			certDeNegocio.setIndicador(helper.filterNullString(String.valueOf(certDeNegocioRow.get("metrica"))));

			certDeNegocioList.add(certDeNegocio);
		}

		logger.debug("[getAll] : found {} business certificates", certDeNegocioList.size());
		logger.info("[getAll] : RETURN");
		return certDeNegocioList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.BusinessCertificateDAO#getDetailHeaders(java.lang.
	 * String, java.lang.String, int)
	 */
	@Override
	public List<String> getDetailHeaders(String idMetrica, String sistema, int software) {

		// TODO usar sistema y software
		logger.info("[getDetailHeaders] : INIT");

		String query = "select distinct dimensionX.id_dimension ,c1.de_nombre as header" + " from"
				+ " lk_met_iq_metrica_dimension dimensionX," + " lk_met_iq_tabla_campo tb1,"
				+ " lk_met_fi_componente c1" + " where" + " dimensionX.id_tabla_lk = tb1.id_tabla"
				+ " and dimensionX.id_campo_nom_lk = tb1.id_campo" + " and tb1.id_componente = c1.id_componente"
				+ " and tb1.id_software = c1.id_software" + " and dimensionX.id_metrica = ?"
				+ " order by dimensionX.id_dimension";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> headersList = new ArrayList<String>();
		List<Map<String, Object>> headerRows = jdbcTemplate.queryForList(query, new Object[] { idMetrica });

		// Mapeo los resultados a una lista
		for (Map<String, Object> headerRow : headerRows) {
			headersList.add(String.valueOf(headerRow.get("header")));
		}

		logger.debug("[getDetailHeaders] : found {} business certificates detail headers", headersList.size());
		logger.info("[getDetailHeaders] : RETURN");
		return headersList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.BusinessCertificateDAO#getCertificateDetails(java.
	 * lang.String, java.lang.String, int, java.lang.String, int)
	 */
	@Override
	public List<DetailOfCertificate> getCertificateDetails(String idMes, String idMetrica, int qttHeaders,
			String sistema, int software) {

		// TODO usar sistema y software
		logger.info("[getCertificateDetails] : INIT");

		String query = "SELECT" + " substr(ID_MES,1,4)||'-'||substr(ID_MES,5,2) AS Fecha,"
				+ " DECODE(VAL_DIMENSION_1,'NO_APLICA',' ',VAL_DIMENSION_1) as VAL_DIMENSION_1,"
				+ " DECODE(VAL_DIMENSION_2 ,'NO_APLICA',' ',VAL_DIMENSION_2) as VAL_DIMENSION_2,"
				+ " DECODE(VAL_DIMENSION_3 ,'NO_APLICA',' ',VAL_DIMENSION_3) as VAL_DIMENSION_3,"
				+ " DECODE(VAL_DIMENSION_4 ,'NO_APLICA',' ',VAL_DIMENSION_4) as VAL_DIMENSION_4,"
				+ " DECODE(VAL_DIMENSION_5 ,'NO_APLICA',' ',VAL_DIMENSION_5) as VAL_DIMENSION_5,"
				+ " DECODE(VAL_DIMENSION_6 ,'NO_APLICA',' ',VAL_DIMENSION_6) as VAL_DIMENSION_6,"
				+ " HC_VALOR_METRICA_ACT," + " CASE" + " WHEN MAX(ID_SN_ERROR_WARNING) > 0 THEN 'KO'"
				+ " WHEN MAX(ID_SN_ERROR_WARNING) = 0 THEN 'OK'" + " END AS OKKO" + " FROM AG_MET_IQ_CERTIF_FUNCIONAL"
				+ " WHERE" + " ID_MES = ? AND" + " ID_METRICA = ?" + " GROUP BY ID_MES," + " VAL_DIMENSION_1,"
				+ " VAL_DIMENSION_2," + " VAL_DIMENSION_3," + " VAL_DIMENSION_4," + " VAL_DIMENSION_5,"
				+ " VAL_DIMENSION_6," + " HC_VALOR_METRICA_ACT";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<DetailOfCertificate> detallesList = new ArrayList<DetailOfCertificate>();
		List<Map<String, Object>> detallesRows = jdbcTemplate.queryForList(query, new Object[] { idMes, idMetrica });

		// Mapeo los resultados a una lista
		for (Map<String, Object> detallesRow : detallesRows) {

			DetailOfCertificate detalle = new DetailOfCertificate();

			// Campos siempre necesarios
			detalle.setFecha(String.valueOf(detallesRow.get("fecha")));
			detalle.setHcValMetricaAct(String.valueOf(detallesRow.get("HC_VALOR_METRICA_ACT")));
			detalle.setEstado(String.valueOf(detallesRow.get("okko")));

			// Esto depende de cuántas dimensiones (i.e., headers) voy a mostrar
			// TODO es necesario filtrar strings aquí?
			switch (qttHeaders) {
			case 6:
				detalle.setValDimension6(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_6"))));
			case 5:
				detalle.setValDimension5(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_5"))));
			case 4:
				detalle.setValDimension4(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_4"))));
			case 3:
				detalle.setValDimension3(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_3"))));
			case 2:
				detalle.setValDimension2(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_2"))));
			case 1:
				detalle.setValDimension1(helper.filterNullString(String.valueOf(detallesRow.get("VAL_DIMENSION_1"))));
			}

			detallesList.add(detalle);
		}

		logger.debug("[getCertificateDetails] : found {} business certificates details", detallesList.size());
		logger.info("[getCertificateDetails] : RETURN");
		return detallesList;
	}
}
