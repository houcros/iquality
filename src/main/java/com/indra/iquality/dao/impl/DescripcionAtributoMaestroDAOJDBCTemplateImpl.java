package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DescripcionAtributoMaestroDAO;
import com.indra.iquality.model.DescripcionAtributoMaestro;
import com.indra.iquality.singleton.Sistema;

public class DescripcionAtributoMaestroDAOJDBCTemplateImpl extends DescripcionAtributoDAOJDBCTemplateImpl implements DescripcionAtributoMaestroDAO{

	Sistema sistema = Sistema.getInstance();

	@Override
	public DescripcionAtributoMaestro getById(String compRowID, String ctRowID){
		
		// Preparo un maestro para retornar
		// Lo creo con los campos que ya sé de DescripcionAtributo (super)
		DescripcionAtributoMaestro dam = new DescripcionAtributoMaestro(super.getById(compRowID, ctRowID));
		
		// Obtengo los campos propios del maestro, que un atributo normal no tiene
		String queryAtributosDelMaestro = "SELECT"
				+ " VSMT.de_historico_lk as historico_maestro, PERACT.de_periodo_act as periodo_act_maestro,"
				+ " TIPACT.de_tipo_actualizacion as tipo_act_maestro, VSMT.de_formula_usuario_lk as mtd_obtencion_maestro"
				+ " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA VSMT, LK_MET_FI_PERIODO_ACT PERACT,"
				+ " LK_MET_FI_TIPO_ACTUALIZACION TIPACT"
				+ " WHERE"
				+ " VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ? AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = PERACT.id_software AND VSMT.id_sistema = PERACT.id_sistema"
				+ " AND VSMT.id_periodo_act_lk = PERACT.id_periodo_act AND VSMT.id_software = TIPACT.id_software"
				+ " AND VSMT.id_sistema = TIPACT.id_sistema AND VSMT.id_tipo_actualizacion_lk = TIPACT.id_tipo_actualizacion";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionAtributoMaestro auxdam = jdbcTemplate.queryForObject(queryAtributosDelMaestro, 
				new Object[]{compRowID, ctRowID, sistema.getIdSistema(), sistema.getIdSoftware()}, new RowMapper<DescripcionAtributoMaestro>(){

			@Override
			public DescripcionAtributoMaestro mapRow(ResultSet rs, int rowNum) throws SQLException {

				DescripcionAtributoMaestro dam = new DescripcionAtributoMaestro();

				dam.setHistoricoMaestro(rs.getString("historico_maestro"));
				dam.setPeriodoActualizacionMaestro(rs.getString("periodo_act_maestro"));
				dam.setTipoActualizacionMaestro(rs.getString("tipo_act_maestro"));
				dam.setMetodoObtencionMaestro(rs.getString("mtd_obtencion_maestro"));

				return dam;
			}
		});
		
		// Agrego los campos obtenidos al atributo maestro que me había preparado
		dam.setHistoricoMaestro(auxdam.getHistoricoMaestro());
		dam.setPeriodoActualizacionMaestro(auxdam.getPeriodoActualizacionMaestro());
		dam.setTipoActualizacionMaestro(auxdam.getTipoActualizacionMaestro());
		dam.setMetodoObtencionMaestro(auxdam.getMetodoObtencionMaestro());
		
		return dam;
		
	}
}
