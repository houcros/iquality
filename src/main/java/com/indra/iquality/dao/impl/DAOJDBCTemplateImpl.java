package com.indra.iquality.dao.impl;

import javax.sql.DataSource;

import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.singleton.Entorno;

public class DAOJDBCTemplateImpl {

	protected DataSource dataSource;
	protected Entorno sistema = Entorno.getInstance();
	protected CustomHelper helper = new CustomHelper();

	public DAOJDBCTemplateImpl() {
		super();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}