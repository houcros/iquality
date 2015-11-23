package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.DetalleDeValidacion;
import com.indra.iquality.model.ValidacionTecnica;
import com.indra.iquality.singleton.Sistema;

public class ValidacionTecnicaDAOJDBCTemplateImpl extends DAOJDBCTemplateImpl implements ValidacionTecnicaDAO {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ValidacionTecnicaDAOJDBCTemplateImpl.class);
	private int lastNumCols = 0;
	private List<String> headers = new ArrayList<String>();
	
	@Override
	public List<ValidacionTecnica> getAll() {

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

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ValidacionTecnica> validacionList = new ArrayList<ValidacionTecnica>();

		List<Map<String, Object>> validacionRows = jdbcTemplate.queryForList(query,
				new Object[] { sistema.getIdSistema(), sistema.getIdSoftware() });
		for (Map<String, Object> validacionRow : validacionRows) {

			ValidacionTecnica validacion = new ValidacionTecnica();

			validacion.setIdMetrica(helper.filterNullString(String.valueOf(validacionRow.get("id_metrica"))));
			validacion.setIdMes(helper.filterNullString(String.valueOf(validacionRow.get("id_mes"))));

			validacion.setFecha(helper.filterNullString(String.valueOf(validacionRow.get("fecha"))));
			validacion.setSeccion(helper.filterNullString(String.valueOf(validacionRow.get("seccion"))));
			validacion.setSubseccion(helper.filterNullString(String.valueOf(validacionRow.get("subseccion"))));
			validacion.setEntidad(helper.filterNullString(String.valueOf(validacionRow.get("entidad"))));
			validacion.setCertificacion(helper.filterNullString(String.valueOf(validacionRow.get("certificacion"))));
			// validacion.setDeCertificacion(helper.filterNullString(String.valueOf(validacionRow.get("de_certificacion"))));
			// La query me devuelve ID_ERROR pero de momento creo que no lo
			// necesito
			validacion.setNumRegistros(
					helper.filterNullInt(Integer.valueOf(String.valueOf(validacionRow.get("num_registros")))));
			validacion.setEstado(helper.filterNullString(String.valueOf(validacionRow.get("okko"))));

			validacionList.add(validacion);
		}

		return validacionList;
	}

	@Override
	public List<DetalleDeValidacion> getDetallesDeValidacion(String idMetrica, String idMes){
		
		String query = getQuery(idMetrica, idMes);
		if (query == null || query.equals("")){
			logger.warn("Has intentado ejecutar una query nula o vacía");
			System.out.println("Has intentado ejecutar una query nula o vacía");
			return new ArrayList<DetalleDeValidacion>();
		}
		
		logger.info(query);
		System.out.println(query);
		
		List<DetalleDeValidacion> ddvList = new ArrayList<DetalleDeValidacion>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> anonymousRows = jdbcTemplate.queryForList(query);
		
		lastNumCols = anonymousRows.isEmpty() ? 0 : anonymousRows.get(0).size();
		headers.clear();
		for (Map.Entry<String, Object> entry : anonymousRows.get(0).entrySet())
			headers.add(entry.getKey());
		while(headers.size() < DetalleDeValidacion.MAX_DIMENSIONES)
			headers.add("_STUB");
		
		int debugCont = 0;
		for (Map<String, Object> anonymousRow : anonymousRows){
			
			List<String> strs = new ArrayList<String>();
			for (Map.Entry<String, Object> entry : anonymousRow.entrySet()){
//				System.out.println("Poniendo valor " + entry.getValue());
				strs.add(String.valueOf(entry.getValue()));
			}
			while(strs.size() < DetalleDeValidacion.MAX_DIMENSIONES){
				strs.add(Sistema.DEFAULT_NULL_STRING);
			}
			
			ddvList.add(new DetalleDeValidacion(strs));
//			System.out.println("Agregado detalle de validación " + String.valueOf(++debugCont));
		}
		
		return ddvList;
	}

	// En un futuro hacerla privada (auxiliar), pero tengo que mirar cómo unitest entonces
	public String getQuery(String idMetrica, String idMes) {

		String query = "SELECT" + " DE_QUERY FROM BS_MET_IQ_VALIDACION" + " WHERE ID_METRICA = ? AND ID_MES = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String resultQuery = jdbcTemplate.query(query, new Object[] { idMetrica, idMes },
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs) throws SQLException, DataAccessException {
						return rs.next() ? rs.getString("de_query") : null;
					}
				});
		
		return resultQuery;
	}
	
	public int getLastNumCols(){
		return lastNumCols;
	}
	
	public List<String> getHeaders(){
		return headers;
	}
}
