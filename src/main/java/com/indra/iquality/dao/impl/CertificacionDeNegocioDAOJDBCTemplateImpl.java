package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.CertificacionDeNegocioDAO;
import com.indra.iquality.model.CertificacionDeNegocio;

public class CertificacionDeNegocioDAOJDBCTemplateImpl extends DAOJDBCTemplateImpl implements CertificacionDeNegocioDAO {

	@Override
	public List<CertificacionDeNegocio> getAll() {

		String query = "SELECT"
				+ " AG.ID_MES,"
				+ " AG.ID_METRICA,"
				+ " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha,"  
				+ " SECC.DE_SECCION AS SECCION,"
				+ " SUBSECC.DE_SUBSECCION AS SUBSECCION,"
				+ " TAB.DE_TABLA AS ENTIDAD,"
				+ " COMP.DE_NOMBRE AS METRICA,"
				+ " ERR.DE_ERROR AS CERTIFICACION,"
				+ " CERT.DE_CERTIFICACION,"
				+ " max(cond.ID_ERROR),"
				+ " CASE"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'"
				+ " END AS OKKO"
				+ " from AG_MET_IQ_CERTIF_FUNCIONAL AG,"
				+ " LK_MET_IQ_TABLA TAB,"
				+ " LK_MET_FI_SECCION SECC,"
				+ " LK_MET_FI_SUBSECCION SUBSECC,"
				+ " LK_MET_IQ_METRICA METR,"
				+ " LK_MET_IQ_CONDICION COND,"
				+ " LK_MET_IQ_ERROR ERR,"
				+ " LK_MET_FI_CERTIFICACION CERT,"
				+ " LK_MET_FI_COMPONENTE COMP"
				+ " where"
				+ " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ? AND"
				+ " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND"
				+ " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND"
				+ " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND"
				+ " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND"
				+ " SUBSECC.ID_SECCION = SECC.ID_SECCION AND"
				+ " CERT.ID_TABLA_HIJO = TAB.ID_TABLA and"
				+ " ? = TAB.ID_SISTEMA and"
				+ " AG.ID_METRICA = METR.ID_METRICA and"
				+ " AG.ID_TABLA_HC = METR.ID_TABLA_HC and"
				+ " AG.ID_SISTEMA_HC = METR.ID_SISTEMA_HC AND"
				+ " METR.ID_SISTEMA_HC = CERT.ID_SISTEMA AND"
				+ " COND.ID_ERROR = CERT.ID_IQ_CERTIFICACION and"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND"
				+ " CERT.ID_SISTEMA = COMP.ID_SISTEMA AND"
				+ " CERT.ID_SOFTWARE = COMP.ID_SOFTWARE AND"
				+ " CERT.ID_COMPONENTE_HIJO = COMP.ID_COMPONENTE AND"
				+ " COND.ID_ERROR = ERR.ID_ERROR"
				+ " GROUP BY AG.ID_MES,"
				+ " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION,"
				+ " TAB.DE_TABLA,"
				+ " COMP.DE_NOMBRE,"
				+ " ERR.DE_ERROR,CERT.DE_CERTIFICACION,"
				+ " AG.ID_METRICA"
				+ " union all"
				+ " SELECT"
				+ " AG.ID_MES,"
				+ " AG.ID_METRICA,"
				+ " substr(AG.ID_MES,1,4)||'-'||substr(AG.ID_MES,5,2) AS Fecha," 
				+ " SECC.DE_SECCION AS SECCION,"
				+ " SUBSECC.DE_SUBSECCION AS SUBSECCION,"
				+ " TAB.DE_TABLA AS ENTIDAD,"
				+ " COMP.DE_NOMBRE AS METRICA,"
				+ " ERR.DE_ERROR AS CERTIFICACION,CERT.DE_CERTIFICACION,"
				+ " max(COND.ID_ERROR),"
				+ " CASE"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) > 0 THEN 'KO'"
				+ " WHEN MAX(AG.ID_SN_ERROR_WARNING) = 0 THEN 'OK'"
				+ " END AS OKKO"
				+ " FROM AG_MET_IQ_CERTIF_HISTORIA AG,"
				+ " LK_MET_IQ_TABLA TAB,"
				+ " LK_MET_IQ_ERROR ERR,"
				+ " LK_MET_FI_SECCION SECC,"
				+ " LK_MET_FI_SUBSECCION SUBSECC,"
				+ " LK_MET_FI_CERTIFICACION CERT,"
				+ " LK_MET_FI_COMPONENTE COMP,"
				+ " LK_MET_IQ_METRICA METR,"
				+ " LK_MET_IQ_CONDICION COND"
				+ " WHERE"
				+ " SECC.ID_SISTEMA = ? AND SECC.ID_SOFTWARE = ? AND"
				+ " TAB.ID_SISTEMA = SUBSECC.ID_SISTEMA AND"
				+ " TAB.ID_SUBSECCION = SUBSECC.ID_SUBSECCION AND"
				+ " SUBSECC.ID_SISTEMA = SECC.ID_SISTEMA AND"
				+ " SUBSECC.ID_SOFTWARE = SECC.ID_SOFTWARE AND"
				+ " SUBSECC.ID_SECCION = SECC.ID_SECCION AND"
				+ " AG.ID_TABLA_HC = TAB.ID_TABLA AND"
				+ " AG.ID_SISTEMA_HC = TAB.ID_SISTEMA AND"
				+ " AG.ID_METRICA = METR.ID_METRICA AND"
				+ " AG.ID_TABLA_HC = METR.ID_TABLA_HC AND"
				+ " AG.ID_SISTEMA_HC = METR.ID_SISTEMA_HC AND"
				+ " COND.DE_CONDICION LIKE '%' || METR.ID_METRICA || '%' AND"
				+ " COND.ID_ERROR = ERR.ID_ERROR AND"
				+ " AG.ID_SISTEMA_HC = CERT.ID_SISTEMA AND"
				+ " COND.ID_ERROR = CERT.ID_IQ_CERTIFICACION AND"
				+ " CERT.ID_SISTEMA = COMP.ID_SISTEMA AND"
				+ " CERT.ID_SOFTWARE = COMP.ID_SOFTWARE AND"
				+ " CERT.ID_COMPONENTE_HIJO = COMP.ID_COMPONENTE"
				+ " GROUP BY AG.ID_MES,"
				+ " SECC.DE_SECCION,"
				+ " SUBSECC.DE_SUBSECCION,"
				+ " TAB.DE_TABLA,"
				+ " COMP.DE_NOMBRE,"
				+ " ERR.DE_ERROR,CERT.DE_CERTIFICACION,"
				+ " AG.ID_METRICA";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CertificacionDeNegocio> certDeNegocioList = new ArrayList<CertificacionDeNegocio>();
		
		List<Map<String, Object>> certDeNegocioRows = jdbcTemplate.queryForList(query, new Object[]{
				sistema.getIdSistema(), sistema.getIdSoftware(), sistema.getIdSistema(), 
				sistema.getIdSistema(), sistema.getIdSoftware()});
		for(Map<String, Object> certDeNegocioRow : certDeNegocioRows){
			
			CertificacionDeNegocio certDeNegocio = new CertificacionDeNegocio();
			
			certDeNegocio.setFecha(helper.filterNullString(String.valueOf(certDeNegocioRow.get("fecha"))));
			certDeNegocio.setSeccion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("seccion"))));
			certDeNegocio.setSubseccion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("subseccion"))));
			certDeNegocio.setEntidad(helper.filterNullString(String.valueOf(certDeNegocioRow.get("entidad"))));
			certDeNegocio.setCertificacion(helper.filterNullString(String.valueOf(certDeNegocioRow.get("de_certificacion"))));
			//La query me devuelve ID_ERROR pero de momento creo que no lo necesito
			certDeNegocio.setEstado(helper.filterNullString(String.valueOf(certDeNegocioRow.get("okko"))));
			certDeNegocio.setIndicador(helper.filterNullString(String.valueOf(certDeNegocioRow.get("metrica"))));

			certDeNegocioList.add(certDeNegocio);
		}
		
		return certDeNegocioList;
	}

}
