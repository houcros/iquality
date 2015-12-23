/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
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
 * @version 0.5, 23-dic-2015
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

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Map<String, Object> currentSoftwareRow = jdbcTemplate.queryForMap(query, new Object[] { sistema });

		// Mapeo al resultado
		Pair<Integer, String> currentSoftware = new MutablePair<Integer, String>(
				Integer.valueOf(String.valueOf(currentSoftwareRow.get("ID_SOFTWARE"))),
				String.valueOf(currentSoftwareRow.get("DE_SOFTWARE")));

		logger.info("[getCurrentSoftware] : RETURN");
		return currentSoftware;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.EnvironmentDAO#getAllSystems()
	 */
	@Override
	public List<Pair<String, String>> getAllSystems() {

		logger.info("[getAllSystems] : INIT");

		String query = "select id_sistema, de_sistema from LK_MET_IQ_SISTEMA" + " where id_sistema != 'PLA' order by 1";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pair<String, String>> systemList = new ArrayList<Pair<String, String>>();
		List<Map<String, Object>> systemRows = jdbcTemplate.queryForList(query);

		// Mapeo al resultado
		for (Map<String, Object> systemRow : systemRows) {
			systemList.add(new MutablePair<String, String>(String.valueOf(systemRow.get("id_sistema")),
					String.valueOf(systemRow.get("de_sistema"))));
		}

		logger.info("[getAllSystems] : RETURN");
		return systemList;

	}

	@Override
	public List<Pair<String, String>> getAllTables(String sistema) {

		logger.info("[getAllTables] : INIT");

		String query = "select distinct id_tabla as display, id_tabla from LK_MET_IQ_TABLA T, LK_MET_IQ_SOFTWARE S"
				+ " where T.id_sistema = ? AND S.ID_SISTEMA = ?"
				+ " AND S.ID_SN_SOFTWARE_ACTUAL = 'S' AND T.ID_SOFTWARE = S.ID_SOFTWARE order by 1";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pair<String, String>> systemList = new ArrayList<Pair<String, String>>();
		List<Map<String, Object>> systemRows = jdbcTemplate.queryForList(query, new Object[] { sistema, sistema });

		// Mapeo al resultado
		for (Map<String, Object> systemRow : systemRows) {
			systemList.add(new MutablePair<String, String>(String.valueOf(systemRow.get("id_tabla")),
					String.valueOf(systemRow.get("display"))));
		}

		logger.info("[getAllTables] : RETURN");
		return systemList;

	}

}
