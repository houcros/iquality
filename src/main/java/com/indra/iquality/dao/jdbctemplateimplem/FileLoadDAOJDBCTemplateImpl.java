/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.FileLoadDAO;

/**
 * Implementation of {@link com.indra.iquality.dao.FileLoadDAO} using JDBC to
 * connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 20-ene-2016
 * 
 *          The Class FileLoadDAOJDBCTemplateImpl.
 */
public class FileLoadDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements FileLoadDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DependencyDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.FileLoadDAO#getAllTables(java.lang.String,
	 * int)
	 */
	@Override
	public List<String> getAllTables(String system, int software) {

		logger.info("[getAllTables] : INIT");

		String query = "select * from lk_met_iq_excel where id_sistema = ? and id_software = ?";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> tablesList = new ArrayList<String>();
		List<Map<String, Object>> tablesRows = jdbcTemplate.queryForList(query, new Object[] { system, software });

		// Mapeo los resultados a una lista
		for (Map<String, Object> tableRow : tablesRows) {
			String tableName = helper.filterNullString(String.valueOf(tableRow.get("de_excel"))) + " "
					+ helper.filterNullString(String.valueOf(tableRow.get("id_fichero_csv")));
			tablesList.add(tableName);
		}

		logger.debug("[getAllTables] : found {} tables", tablesList.size());
		logger.info("[getAllTables] : RETURN");
		return tablesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.FileLoadDAO#saveToTempTable(java.lang.String[],
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean saveToTempTable(Object[] columns, String tableName, String system, int software) {

		logger.info("[saveToTempTable] : INIT");

		if (columns.length < 1) {
			logger.error("[saveToTempTable] : Se necesita al menos una columna para insertar.");
			return false;
		}

		String query = "insert into " + tableName + " values (?";
		// Añado un parámetro por cada columna (el primero ya está)
		for (int i = 0; i < columns.length - 1; ++i)
			query += ", ?";
		query += ")";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int out;

		try {
			logger.debug("[saveToTempTable] : hay {} columnas", columns.length);
			for (Object column : columns)
				logger.debug("[saveToTempTable] : columna {}", column.toString());

			out = jdbcTemplate.update(query, columns);
			if (out == 0) {
				logger.warn("[saveToTempTable] : No se insertó el pase");
				return false;
			}
		} catch (DataIntegrityViolationException e) {
			logger.error("[saveToTempTable] : El record ya existe <{}> | Ayuda: {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			logger.error("[saveToTempTable] : Excepción <{}> | Ayuda: {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return false;
		}
		logger.debug("[saveToTempTable] : insertado record");

		logger.info("[saveToTempTable] : RETURN");
		return true;
	}

}
