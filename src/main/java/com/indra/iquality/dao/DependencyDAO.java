/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Dependency;

/**
 * The Interface to interact with the persistent representations of job
 * dependencies.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Interface DependencyDAO.
 */
public interface DependencyDAO {

	/**
	 * Gets the all the records of dependencies for a given job for a given
	 * system and software version.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution where the job takes part
	 * @param idJob
	 *            the identifier of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the all
	 */
	public List<Dependency> getAll(int idEjecucion, String idJob, String sistema, int software);
}
