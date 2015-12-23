/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

/**
 * The Interface EnvironmentDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Interface EnvironmentDAO.
 */
public interface EnvironmentDAO {

	/**
	 * Gets the current software version of the environment system.
	 *
	 * @param sistema
	 *            the system
	 * @return a pair where the first value is the identifier of the software
	 *         version and the second value is its description
	 */
	public Pair<Integer, String> getCurrentSoftware(String sistema);

	/**
	 * Gets all the systems available.
	 *
	 * @return all systems in the form of pairs where the first value is the
	 *         identifier of the system and the second value is the description
	 *         of the system.
	 */
	public List<Pair<String, String>> getAllSystems();

	/**
	 * Gets the all tables defined in the environment system.
	 *
	 * @param sistema
	 *            the system
	 * @return all the tables in the system, given in the form of pairs where
	 *         the first value is the identifier of the table and the second
	 *         value is the descriptive name of the table.
	 */
	public List<Pair<String, String>> getAllTables(String sistema);
}
