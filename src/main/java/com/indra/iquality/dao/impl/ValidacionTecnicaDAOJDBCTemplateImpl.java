package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.ValidacionTecnica;

public class ValidacionTecnicaDAOJDBCTemplateImpl extends DAOJDBCTemplateImpl implements ValidacionTecnicaDAO {

	@Override
	public List<ValidacionTecnica> getAll() {

		String query = "SELECT"
				+ " AG.ID_MES,"
				+ " AG.ID_METRICA,"
				+ " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha,"  
				+ " SECC.DE_SECCION AS SECCION,"
				+ " SUBSECC.DE_SUBSECCION AS SUBSECCION,"
				+ " TAB.DE_TABLA AS ENTIDAD,"
				+ " ERR.DE_ERROR AS CERTIFICACION,"
				+ " AG.ID_ERROR,"
				+ " sum(AG.HC_VALOR_METRICA_ACT) as NUM_REGISTROS,"
				+ " CASE"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'"
				+ " END AS OKKO"
				+ " FROM"
				+ " AG_MET_IQ_CERTIF_FUNCIONAL AG,"
				+ " LK_MET_IQ_ERROR ERR,"
				+ " LK_MET_IQ_TABLA TAB,"
				+ " LK_MET_FI_SECCION SECC,"
				+ " LK_MET_FI_SUBSECCION SUBSECC,"
				+ " LK_MET_IQ_METRICA METR,"
				+ " LK_MET_IQ_CONDICION COND"
				+ " WHERE" 
				+ " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND"
				+ " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND"
				+ " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND"
				+ " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND"
				+ " SUBSECC.ID_SECCION = SECC.ID_SECCION AND"
				+ " AG.ID_TABLA_HC = TAB.ID_TABLA AND"
				+ " AG.ID_SISTEMA_HC = TAB.ID_SISTEMA AND" 
				+ " AG.ID_METRICA = METR.ID_METRICA AND"
				+ " METR.ID_SN_CERTIFICACION_VALID = 'S' AND"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND"
				+ " COND.ID_ERROR = ERR.ID_ERROR AND"
				+ " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ?"
				+ " GROUP BY AG.ID_MES,"
				+ " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION,"
				+ " TAB.DE_TABLA,"
				+ " ERR.DE_ERROR,"
				+ " AG.ID_ERROR, AG.ID_METRICA, TAB.ID_SOFTWARE, TAB.ID_TABLA";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ValidacionTecnica> validacionList = new ArrayList<ValidacionTecnica>();
		
		List<Map<String, Object>> validacionRows = jdbcTemplate.queryForList(query, new Object[]{sistema.getIdSistema(), sistema.getIdSoftware()});
		for(Map<String, Object> validacionRow : validacionRows){
			
			ValidacionTecnica validacion = new ValidacionTecnica();
			
			validacion.setFecha(helper.filterNullString(String.valueOf(validacionRow.get("fecha"))));
			validacion.setSeccion(helper.filterNullString(String.valueOf(validacionRow.get("seccion"))));
			validacion.setSubseccion(helper.filterNullString(String.valueOf(validacionRow.get("subseccion"))));
			validacion.setEntidad(helper.filterNullString(String.valueOf(validacionRow.get("entidad"))));
			validacion.setCertificacion(helper.filterNullString(String.valueOf(validacionRow.get("certificacion"))));
//			validacion.setDeCertificacion(helper.filterNullString(String.valueOf(validacionRow.get("de_certificacion"))));
			//La query me devuelve ID_ERROR pero de momento creo que no lo necesito
			validacion.setNumRegistros(helper.filterNullInt(Integer.valueOf(String.valueOf(validacionRow.get("num_registros")))));
			validacion.setEstado(helper.filterNullString(String.valueOf(validacionRow.get("okko"))));
			
			validacionList.add(validacion);
		}
		
		return validacionList;
	}

}
