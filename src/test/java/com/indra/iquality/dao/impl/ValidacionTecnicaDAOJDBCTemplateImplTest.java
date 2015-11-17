package com.indra.iquality.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.ValidacionTecnica;

public class ValidacionTecnicaDAOJDBCTemplateImplTest {

	@Test
	public void testGetAll() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
		List<ValidacionTecnica> vtList= vtDAO.getAll();
		ctx.close();
		
		ValidacionTecnica vt = new ValidacionTecnica();
		
		vt.setFecha("2013-04");
		vt.setSeccion("Sección Base");
		vt.setSubseccion("Modelo Contable");
		vt.setEntidad("Maestro de Cuentas Contables");
		vt.setDeCertificacion("Validación de Empresa a no existente");
		vt.setNumRegistros(0);
		vt.setEstado("OK");
		assertEquals(vtList.get(0), vt);
		
		vt.setFecha("2013-06");
		vt.setEntidad("Maestro de Agrupación de Importes");
		vt.setDeCertificacion("Validación de Empresa a no informado");
		assertEquals(vtList.get(9), vt);
		
	}

}
