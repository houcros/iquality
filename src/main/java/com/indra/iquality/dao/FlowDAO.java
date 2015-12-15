/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Flow;

/**
 * The Interface to interact with the persistent representations of ETL flow
 * definitions.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 10-dic-2015
 * 
 *          The Interface FlowDAO.
 */
public interface FlowDAO {

	/**
	 * Gets all the records of ETL flows stored in the underlying DB for the
	 * current version of the system.
	 *
	 * @param system
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the flows
	 */
	public List<Flow> getAll(String system, int software);

	/**
	 * Insert a new flow into the underlying DB for the current version of the
	 * system. Idempotent method.
	 *
	 * @param flow
	 *            the flow to insert
	 * @param system
	 *            the system
	 * @param software
	 *            the software version
	 * @return true, if successful
	 */
	public boolean save(Flow flow, String system, int software);
}
