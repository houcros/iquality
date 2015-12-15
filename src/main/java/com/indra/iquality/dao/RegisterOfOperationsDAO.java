/*
 * 
 */
package com.indra.iquality.dao;

import java.text.ParseException;
import java.util.List;

import com.indra.iquality.model.RegisterOfOperation;

/**
 * The Interface to interact with the persistent representations of the register
 * of operations of jobs.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Interface RegisterOfOperationsDAO.
 */
public interface RegisterOfOperationsDAO {

	/**
	 * Gets all the register of operations of a job from an execution, given a
	 * system with a software version.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution of the job
	 * @param idJob
	 *            the identifier of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the register of operations of a job
	 * @throws ParseException
	 *             if a date is bad formatted
	 */
	public List<RegisterOfOperation> getAll(int idEjecucion, String idJob, String sistema, int software)
			throws ParseException;

}
