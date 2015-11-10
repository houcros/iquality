package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DescripcionComponenteDAO;
import com.indra.iquality.model.DescripcionComponente;
import com.indra.iquality.singleton.Sistema;

public class DescripcionComponenteDAOJDBCTemplateImpl implements DescripcionComponenteDAO{

	private DataSource dataSource;
	Sistema sistema = Sistema.getInstance();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public DescripcionComponente getById(String compRowID, String ctRowID) {

		String query = "SELECT * "
					+ "FROM VS_MET_FI_COMPONENTE_TABLA "
					+ "WHERE COMP_ROWID = ? AND CT_ROWID = ? "
					+ "AND ID_SISTEMA = ? AND ID_SOFTWARE = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionComponente dc = jdbcTemplate.queryForObject(query, 
				new Object[]{compRowID, ctRowID, sistema.getIdSistema(), sistema.getIdSoftware()}, new RowMapper<DescripcionComponente>(){

					@Override
					public DescripcionComponente mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						DescripcionComponente dc = new DescripcionComponente();
						
						dc.setNombre(rs.getString("de_nombre"));
						dc.setFormato(rs.getString("de_formato"));
						dc.setResponsable(rs.getString("de_comentario"));
						dc.setDefinicion(rs.getString("de_definicion"));
						dc.setComentarios(rs.getString("de_comentario"));
						dc.setHistoricoEnt(rs.getString("de_historico"));
						dc.setOrigenEnt(rs.getString("id_sistema"));
						dc.setCaracteristicasActualizacionEnt(rs.getString("id_periodo_act") + rs.getString("id_tipo_actualizacion"));
						dc.setMetodoObtencion(rs.getString("de_formula_usuario"));
						
						return dc;
					}
		});
		
		return dc;
	}

}
