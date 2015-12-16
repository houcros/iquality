package com.indra.iquality.dao.jdbctemplateimplem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.BusinessCertificateDAO;
import com.indra.iquality.model.BusinessCertificate;
import com.indra.iquality.model.BusinessCertificateDetail;
import com.indra.iquality.singleton.Environment;

public class CertificacionDeNegocioDAOJDBCTemplateImplTest {

	private static final Environment environment = Environment.getInstance();

	@Ignore
	@Test
	public void testGetAll() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("businessCertificateDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<BusinessCertificate> cdnList = cdnDAO.getAll(environment.getSystem(), environment.getCurrentSoftware());
		ctx.close();

		BusinessCertificate cdn = new BusinessCertificate();

		assertEquals(cdnList.size(), 7);

		cdn.setDate("2013-12");
		cdn.setSection("Sección de Motores de Cálculo");
		cdn.setSubsection("Motor Balance y Fondos Propios");
		cdn.setEntity("Entidad Balance de Solvencia I y II formato QRT");
		cdn.setCertificateDescription("Other technical provisions");
		cdn.setStatus("OK");
		cdn.setIndicator("Importe Solvencia II");
		cdn.setIdMetrica("METR_CERT_RBA_OTH_TECH_PROV");
		cdn.setMonth("201312");
		assertEquals(cdnList.get(0), cdn);

		cdn.setDate("2014-11");
		cdn.setSection("Sección Base");
		cdn.setSubsection("Modelo Contable");
		cdn.setEntity("Entidad contable");
		cdn.setCertificateDescription("Validación para saldo final de mes por empresa y periodo");
		cdn.setIndicator("Saldo final mes");
		cdn.setIdMetrica("METR_CERT_CNT_SALDO_ACTUAL");
		cdn.setMonth("201411");
		assertEquals(cdnList.get(3), cdn);
	}

	@Ignore
	@Test
	public void testGetHeadersDetalles() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("businessCertificateDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<String> headerList = cdnDAO.getDetailHeaders("METR_CERT_CNT_SALDO_ACTUAL", environment.getSystem(),
				environment.getCurrentSoftware());
		ctx.close();

		assertEquals(headerList.size(), 2);

		List<String> testList = new ArrayList<String>();
		testList.add("Mes");
		testList.add("Descripción de empresa");
		assertEquals(headerList, testList);

	}

	@Ignore
	@Test
	public void testGetDetallesDeCertificacion() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		BusinessCertificateDAO cdnDAO = ctx.getBean("businessCertificateDAOJDBCTemplate", BusinessCertificateDAO.class);
		List<BusinessCertificateDetail> detallesList = cdnDAO.getCertificateDetails("201306", "METR_CERT_CNT_SALDO_ACTUAL", 2,
				environment.getSystem(), environment.getCurrentSoftware());
		ctx.close();

		assertEquals(detallesList.size(), 6);
		System.out.println(detallesList.get(2).toString());
	}
}
