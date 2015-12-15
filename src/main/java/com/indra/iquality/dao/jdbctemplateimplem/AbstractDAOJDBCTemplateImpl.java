package com.indra.iquality.dao.jdbctemplateimplem;

import javax.sql.DataSource;

import com.indra.iquality.helper.CustomHelper;

public abstract class AbstractDAOJDBCTemplateImpl {

	protected DataSource dataSource;
	protected CustomHelper helper = new CustomHelper();

	public AbstractDAOJDBCTemplateImpl() {
		super();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}