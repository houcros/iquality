/*
 * 
 */
package com.indra.iquality.dao;

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
}
