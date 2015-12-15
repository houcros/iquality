package com.indra.iquality.dao.jdbctemplateimplem;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.TechnicalCertificateDAO;
import com.indra.iquality.model.TechnicalCertificate;
import com.indra.iquality.singleton.Environment;

public class ValidacionTecnicaDAOJDBCTemplateImplTest {

	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(ValidacionTecnicaDAOJDBCTemplateImplTest.class);
	private static final Environment environment = Environment.getInstance();

	@Ignore
	@Test
	public void testGetAll() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TechnicalCertificateDAO vtDAO = ctx.getBean("technicalCertificateDAOJDBCTemplate",
				TechnicalCertificateDAO.class);
		List<TechnicalCertificate> vtList = vtDAO.getAll(environment.getIdSistema(), environment.getIdSoftware());
		ctx.close();

		TechnicalCertificate vt = new TechnicalCertificate();

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

}
