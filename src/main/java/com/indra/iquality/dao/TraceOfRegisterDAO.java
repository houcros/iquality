/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.OperationTrace;

/**
 * The Interface to interact with the persistent representations of register
 * traces of operations.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Interface TraceOfRegisterDAO.
 */
public interface TraceOfRegisterDAO {

	/**
	 * Gets all the register traces of an operation for a given system and
	 * software version.
	 *
	 * @param idOperacion
	 *            the identifier of the operation
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the all
	 * @throws Exception
	 *             all the register traces of the operation
	 */
	public List<OperationTrace> getAll(int idOperacion, String sistema, int software) throws Exception;
}
