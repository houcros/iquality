package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Flow;

/**
 * The Interface PaseDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 10-dic-2015
 * 
 *          The Interface PaseDAO.
 */
public interface FlowDAO {

	/**
	 * Gets all the records of ETL flows present in the underlying DB.
	 *
	 * @return all the flows
	 */
	public List<Flow> getAllPases();

	/**
	 * Insert a new flow into the underlying DB. Idempotent method.
	 *
	 * @param pase
	 *            the flow to insert
	 */
	public void insertPase(Flow pase);
}
