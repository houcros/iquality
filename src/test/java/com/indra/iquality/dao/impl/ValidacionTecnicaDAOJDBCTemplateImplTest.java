package com.indra.iquality.dao.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.ValidacionTecnica;

public class ValidacionTecnicaDAOJDBCTemplateImplTest {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ValidacionTecnicaDAOJDBCTemplateImplTest.class);
	
	@Test
	public void testGetAll() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
		List<ValidacionTecnica> vtList= vtDAO.getAll();
		ctx.close();
		
		ValidacionTecnica vt = new ValidacionTecnica();
		
		vt.setIdMetrica("METR_VAL_CNT_CUENTAS_CONTABLES_NO_EXISTENTE_EMPR");
		vt.setIdMes("201304");
		vt.setFecha("2013-04");
		vt.setSeccion("Sección Base");
		vt.setSubseccion("Modelo Contable");
		vt.setEntidad("Maestro de Cuentas Contables");
		vt.setCertificacion("Validación de Empresa a no existente");
		vt.setNumRegistros(0);
		vt.setEstado("OK");
		assertEquals(vtList.get(0), vt);
		
		vt.setIdMetrica("METR_VAL_CNT_COLUMNAS_NO_INFORMADO_EMPR");
		vt.setIdMes("201306");
		vt.setFecha("2013-06");
		vt.setEntidad("Maestro de Agrupación de Importes");
		vt.setCertificacion("Validación de Empresa a no informado");
		assertEquals(vtList.get(9), vt);
		
	}

	@Test
	public void testGetQuery(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
		String query1 = ((ValidacionTecnicaDAOJDBCTemplateImpl) vtDAO).getQuery("METR_VAL_CNT_CUENTAS_CONTABLES_NO_EXISTENTE_EMPR", "201306");
		String query2 = ((ValidacionTecnicaDAOJDBCTemplateImpl) vtDAO).getQuery("METR_VAL_CNT_COLUMNAS_NO_EXISTENTE_EMPR", "201312");
		String query3 = ((ValidacionTecnicaDAOJDBCTemplateImpl) vtDAO).getQuery("METR_VAL_CNT_COLUMNAS_NO_EXISTENTE_EMPR", "201411");
		ctx.close();
		
		String query1Check = "SELECT *   FROM LK_DMS_CNT_CUENTAS_CONTABLES TH  WHERE TH.ID_MES = 201306 AND TH.ID_APLICACION_CONTABLE NOT IN ('-9','-8') AND TH.ID_CUENTASUBCUENTA NOT IN ('-9','-8') AND DECODE(TH.ID_EMPRESA,'-8',1,0) > 0  AND ROWNUM < 1001 ";
		assertEquals(query1Check, query1);
		
		String query2Check = "SELECT *   FROM LK_DMS_CNT_AGRUPIMPORTES TH  WHERE TH.ID_MES = 201312 AND TH.ID_AGRUPACION_IMP <> '-9'  AND TH.ID_AGRUPACION_IMP <> '-8'  AND DECODE(TH.ID_EMPRESA,'-8',1,0) > 0  AND ROWNUM < 1001 ";
		assertEquals(query2Check, query2);
		
		String query3Check = null;
		assertEquals(query3Check, query3);
		
	}
	
	@Test
	public void testGetDetallesDeValidacion(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
		List<Map<String, Object>> anonymousRows = vtDAO.getDetallesDeValidacion("METR_VAL_CNT_CUENTAS_CONTABLES_NO_EXISTENTE_EMPR", "201306");
		ctx.close();
		
		if (anonymousRows.size() == 0){ System.out.println("0 filas retornadas."); return; }
		
		int numCols = anonymousRows.get(0).size();
		for (Map.Entry<String, Object> entry : anonymousRows.get(0).entrySet()){
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
	}
}
