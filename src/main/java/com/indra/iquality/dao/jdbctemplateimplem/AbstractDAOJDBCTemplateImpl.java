/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import javax.sql.DataSource;

import com.indra.iquality.helper.CustomHelper;

/**
 * The Abstract Class AbstractDAOJDBCTemplateImpl. Encapsulates the common parts
 * of all the JDCBTemplate implementations of the DAO to keep the code DRY.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Abstract Class AbstractDAOJDBCTemplateImpl.
 */
public abstract class AbstractDAOJDBCTemplateImpl {

	/** The source of the data (the DB). */
	protected DataSource dataSource;

	/** The helper with common utilities. */
	protected CustomHelper helper = new CustomHelper();

	/**
	 * Sets the data source of the DAO.
	 *
	 * @param dataSource
	 *            the new data source
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}