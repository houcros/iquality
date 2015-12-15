/*
 * 
 */
package com.indra.iquality.dao;

import java.text.ParseException;
import java.util.List;

import com.indra.iquality.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface to interact with the persistent representations of atomic parts
 * of an ETL executions, a.k.a, jobs.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Interface JobDAO.
 */
public interface JobDAO {

	/**
	 * Gets an job given its unique identifier and its execution identifier for
	 * a system and software version.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution of the job
	 * @param idJob
	 *            the identifier of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the job
	 */
	public Job getById(int idEjecucion, String idJob, String sistema, int software);

	/**
	 * Update the persistent representation of a job.
	 *
	 * @param job
	 *            the new representation of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean update(Job job, String sistema, int software);

	/**
	 * Delete a job with a given identifier and execution.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution of the job
	 * @param idJob
	 *            the identifier of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean deleteById(int idEjecucion, String idJob, String sistema, int software);

	/**
	 * Gets all the jobs of in system with a software version.
	 *
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the jobs
	 * @throws ParseException
	 *             if a date is bad formatted
	 */
	public List<Job> getAll(String sistema, int software) throws ParseException;

	/**
	 * Gets all the jobs of an execution in a system with a software version.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution of the job
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the jobs of an execution
	 * @throws ParseException
	 *             if a date is bad formatted
	 */
	public List<Job> getAllOfExecution(int idEjecucion, String sistema, int software) throws ParseException;
}
