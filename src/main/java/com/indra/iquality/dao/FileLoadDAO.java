/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

/**
 * The Interface to import and export Excel files from and to the data base.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 20-ene-2016
 * 
 *          The Interface FileLoadDAO.
 */
public interface FileLoadDAO {

	/**
	 * Gets the the name of all the tables that we can export as an Excel, or to
	 * which we can import data through an Excel file.
	 *
	 * @param system
	 *            the system environment
	 * @param software
	 *            the current software version
	 * @return the descriptive name of all the tables
	 */
	public List<String> getAllTables(String system, int software);

	public boolean saveToTempTable(Object[] columns, String tableName, String system, int software);
}
