package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DescripcionAtributoDAO;
import com.indra.iquality.model.DescripcionAtributo;
import com.indra.iquality.singleton.Sistema;

public class DescripcionAtributoDAOJDBCTemplateImpl implements DescripcionAtributoDAO {

	private DataSource dataSource;
	Sistema sistema = Sistema.getInstance();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public DescripcionAtributo getById(String compRowID, String ctRowID) {

		String queryBasicosYEntidad = "SELECT"
				+ " VSMT.id_componente, VSMT.de_nombre as nombre, RESP.de_area as responsable,"
				+ " VSMT.de_definicion as definicion, VSMT.de_comentario as comentario, VSMT.de_historico as historico,"
				+ " VSMT.de_formula_usuario as mtd_obtencion, VSMT.de_formato as formato,"
				+ " PERACT.de_periodo_act as periodo_act, TIPACT.de_tipo_actualizacion as tipo_act"
				+ " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA VSMT, lk_met_fi_area RESP,"
				+ " lk_met_fi_periodo_act PERACT, lk_met_fi_tipo_actualizacion TIPACT"
				+ " WHERE"
				+ " VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ?"
				+ " AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = RESP.id_software and VSMT.id_sistema = RESP.id_sistema"
				+ " AND VSMT.id_area = RESP.id_area AND VSMT.id_software = PERACT.id_software"
				+ " AND VSMT.id_sistema = PERACT.id_sistema and VSMT.id_periodo_act = PERACT.id_periodo_act"
				+ " AND VSMT.id_software = TIPACT.id_software and VSMT.id_sistema = TIPACT.id_sistema"
				+ " AND VSMT.id_tipo_actualizacion = TIPACT.id_tipo_actualizacion";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionAtributo da = jdbcTemplate.queryForObject(queryBasicosYEntidad, 
				new Object[]{compRowID, ctRowID, sistema.getIdSistema(), sistema.getIdSoftware()}, new RowMapper<DescripcionAtributo>(){

			@Override
			public DescripcionAtributo mapRow(ResultSet rs, int rowNum) throws SQLException {

				DescripcionAtributo da = new DescripcionAtributo();

				da.setId(rs.getInt("id_componente"));
				da.setNombre(rs.getString("nombre"));
				da.setResponsable(rs.getString("responsable"));
				da.setDefinicion(rs.getString("definicion"));
				da.setComentarios(rs.getString("comentario"));
				da.setHistorico(rs.getString("historico"));
				da.setMetodoObtencion(rs.getString("mtd_obtencion"));
				da.setFormato(rs.getString("formato"));
				da.setPeriodoActualizacion(rs.getString("periodo_act"));
				da.setTipoActualizacion(rs.getString("tipo_act"));

				return da;
			}
		});

		return da;
	}
}
