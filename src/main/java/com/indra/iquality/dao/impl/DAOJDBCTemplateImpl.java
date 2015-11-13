package com.indra.iquality.dao.impl;

import javax.sql.DataSource;

import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.singleton.Sistema;

public class DAOJDBCTemplateImpl {

	protected DataSource dataSource;
	protected Sistema sistema = Sistema.getInstance();
	protected CustomHelper helper = new CustomHelper();

	public DAOJDBCTemplateImpl() {
		super();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}