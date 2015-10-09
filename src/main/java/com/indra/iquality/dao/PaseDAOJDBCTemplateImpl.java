package com.indra.iquality.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.controller.BaseController;
import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE;
import com.indra.iquality.model.Pase;

public class PaseDAOJDBCTemplateImpl implements PaseDAO {

	private DataSource dataSource;
	
	// Debugging
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	private int contadorDebugger = 0;
	
	private final static String DEFAULT_NULL_STRING = "";
	private final static int DEFAULT_NULL_INT = -1;
	private final static Date DEFAULT_NULL_DATE = new Date(1);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Pase pase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pase getById(int id_ejecucion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pase pase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id_ejecucion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pase> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}