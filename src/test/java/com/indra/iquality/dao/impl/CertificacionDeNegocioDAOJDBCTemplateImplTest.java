package com.indra.iquality.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.BusinessCertificateDAO;
import com.indra.iquality.model.BusinessCertificate;
import com.indra.iquality.model.DetailOfCertificate;

public class CertificacionDeNegocioDAOJDBCTemplateImplTest {

	@Ignore
	@Test
	public void testGetAll() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<BusinessCertificate> cdnList= cdnDAO.getAll();
		ctx.close();
		
		BusinessCertificate cdn = new BusinessCertificate();
		
		assertEquals(cdnList.size(), 7);
		
		cdn.setFecha("2013-12");
		cdn.setSeccion("Sección de Motores de Cálculo");
		cdn.setSubseccion("Motor Balance y Fondos Propios");
		cdn.setEntidad("Entidad Balance de Solvencia I y II formato QRT");
		cdn.setDeCertificacion("Other technical provisions");
		cdn.setEstado("OK");
		cdn.setIndicador("Importe Solvencia II");
		cdn.setIdMetrica("METR_CERT_RBA_OTH_TECH_PROV");
		cdn.setIdMes("201312");
		assertEquals(cdnList.get(0), cdn);
		
		cdn.setFecha("2014-11");
		cdn.setSeccion("Sección Base");
		cdn.setSubseccion("Modelo Contable");
		cdn.setEntidad("Entidad contable");
		cdn.setDeCertificacion("Validación para saldo final de mes por empresa y periodo");
		cdn.setIndicador("Saldo final mes");
		cdn.setIdMetrica("METR_CERT_CNT_SALDO_ACTUAL");
		cdn.setIdMes("201411");
		assertEquals(cdnList.get(3), cdn);
	}
	
	@Ignore
	@Test
	public void testGetHeadersDetalles(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<String> headerList= cdnDAO.getDetailHeaders("METR_CERT_CNT_SALDO_ACTUAL");
		ctx.close();
		
		assertEquals(headerList.size(), 2);
		
		List<String> testList = new ArrayList<String>();
		testList.add("Mes");
		testList.add("Descripción de empresa");
		assertEquals(headerList, testList);

	}

	@Ignore
	@Test
	public void testGetDetallesDeCertificacion(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<DetailOfCertificate> detallesList= cdnDAO.getCertificateDetails("201306", "METR_CERT_CNT_SALDO_ACTUAL", 2);
		ctx.close();
		
		assertEquals(detallesList.size(), 6);
		System.out.println(detallesList.get(2).toString());
	}
}
