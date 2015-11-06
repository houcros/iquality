package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DescripcionComponenteDAO;
import com.indra.iquality.model.DescripcionComponente;

public class DescripcionComponenteDAOJDBCTemplateImpl implements DescripcionComponenteDAO{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public DescripcionComponente getById(String compRowID, String ctRowID) {

		String query = "SELECT * "
					+ "FROM VS_MET_FI_COMPONENTE_TABLA "
					+ "WHERE CT_ROWID = ? AND COMP_ROWID = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionComponente dc = jdbcTemplate.queryForObject(query, 
				new Object[]{compRowID, ctRowID}, new RowMapper<DescripcionComponente>(){

					@Override
					public DescripcionComponente mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						DescripcionComponente dc = new DescripcionComponente();
						
						dc.setNombre(rs.getString("nombre"));
						dc.setFormato(rs.getString("de_formato"));
						dc.setResponsable(rs.getString("de_comentario"));
						dc.setDefinicion(rs.getString("de_definicion"));
						dc.setComentarios(rs.getString("de_comentario"));
						
						return dc;
					}
		});
		
		return dc;
	}

}
