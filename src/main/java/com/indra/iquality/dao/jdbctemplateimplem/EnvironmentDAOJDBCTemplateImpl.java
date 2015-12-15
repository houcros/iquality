/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.controller.APIController;
import com.indra.iquality.dao.EnvironmentDAO;

/**
 * The Class EnvironmentDAOJDBCTemplateImpl.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class EnvironmentDAOJDBCTemplateImpl.
 */
public class EnvironmentDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements EnvironmentDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(APIController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.EnvironmentDAO#getCurrentSoftware(java.lang.
	 * String)
	 */
	@Override
	public Pair<Integer, String> getCurrentSoftware(String sistema) {

		logger.info("[getCurrentSoftware] : INIT");

		String query = "select ID_SOFTWARE, DE_SOFTWARE from lk_met_iq_software"
				+ " where ID_SISTEMA = ? and ID_SN_SOFTWARE_ACTUAL = 'S'";

		Map<String, Object> currentSoftwareRow = null;

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			currentSoftwareRow = jdbcTemplate.queryForMap(query, new Object[] { sistema });
		} catch (Exception e) {
			// Espero sólo una fila de la versión actual
			logger.error("[getCurrentEnvironment] : Excepción <{}> | Ayuda: {} (¿hay más de una versión actual?)",
					e.getClass(), e.getMessage());
			e.printStackTrace();
		}

		// Mapeo al resultado
		Pair<Integer, String> currentSoftware = new MutablePair<Integer, String>(
				Integer.valueOf(String.valueOf(currentSoftwareRow.get("ID_SOFTWARE"))),
				String.valueOf(currentSoftwareRow.get("DE_SOFTWARE")));

		logger.info("[getCurrentSoftware] : RETURN");
		return currentSoftware;

	}

}
