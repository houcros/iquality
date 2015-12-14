/*
 * 
 */
package com.indra.iquality.dao;

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
	 * Save a persistent representation of an execution.
	 *
	 * @param execution
	 *            the execution to save
	 */
	public void save(Execution execution);

	/**
	 * Gets an execution given its unique identifier for a given system and
	 * software version.
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
	 */
	public void update(Execution execution);

	/**
	 * Delete an execution with a given identifier.
	 *
	 * @param idEjecucion
	 *            the id of the execution to delete
	 */
	public void deleteById(int idEjecucion);

	/**
	 * Gets the all executions of a system with a software version.
	 *
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the all executions
	 */
	public List<Execution> getAllEjecuciones(String sistema, int software);

}
