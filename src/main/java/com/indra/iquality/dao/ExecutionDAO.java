/*
 * 
 */
package com.indra.iquality.dao;

import java.text.ParseException;
import java.util.List;

import com.indra.iquality.model.Execution;

/**
 * The Interface to interact with the persistent representations of ETL
 * executions.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Interface ExecutionDAO.
 */
public interface ExecutionDAO {

	/**
	 * Saves a persistent representation of an execution.
	 *
	 * @param execution
	 *            the execution to save
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean save(Execution execution, String sistema, int software);

	/**
	 * Gets an execution given its unique identifier for a system and software
	 * version.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the execution
	 */
	public Execution getById(int idEjecucion, String sistema, int software);

	/**
	 * Update the persistent representation of an execution.
	 *
	 * @param execution
	 *            the new representation of the execution
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean update(Execution execution, String sistema, int software);

	/**
	 * Delete an execution with a given identifier.
	 *
	 * @param idEjecucion
	 *            the id of the execution to delete
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean deleteById(int idEjecucion, String sistema, int software);

	/**
	 * Gets all the executions of a system with a software version.
	 *
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the ETL executions
	 * @throws ParseException
	 *             if a date is bad formatted
	 */
	public List<Execution> getAll(String sistema, int software) throws ParseException;

}
