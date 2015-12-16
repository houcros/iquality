package com.indra.iquality.dao.jdbctemplateimplem;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indra.iquality.dao.EnvironmentDAO;
import com.indra.iquality.singleton.Environment;

public class EnvironmentDAOJDBCTemplateImplTest {

	private static final Environment environment = Environment.getInstance();

	@Test
	public void testGetCurrentSoftware() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EnvironmentDAO envDAO = ctx.getBean("environmentDAOJDBCTemplate", EnvironmentDAO.class);
		ctx.close();

		Pair<Integer, String> currentSoftware = envDAO.getCurrentSoftware(environment.getIdSistema());
		assertEquals(1, (int) currentSoftware.getLeft());
		assertEquals("Versión inicial", currentSoftware.getRight());
	}

}
