package com.indra.iquality.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE;

public class LK_MET_PLA_CTRL_PASEDAOJDBCTemplateImpl implements LK_MET_PLA_CTRL_PASEDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase) {
		String query = "insert into LK_MET_PLA_CTRL_PASE (id_sistema, id_ejecucion, id_software, id_pase, de_pase, "
				+ "id_fecha_inicio, id_fecha_inicio_real, id_fecha_fin_real, id_estado, id_sn_habilitado, "
				+ "id_anyo, id_mes, id_escenario, id_fecha_creacion, id_fecha_modificacion, id_pid) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {lk_met_pla_ctrl_pase.getId_sistema(), lk_met_pla_ctrl_pase.getId_ejecucion(), 
				lk_met_pla_ctrl_pase.getId_software(), lk_met_pla_ctrl_pase.getId_pase(), lk_met_pla_ctrl_pase.getDe_pase(), 
				lk_met_pla_ctrl_pase.getId_fecha_inicio(), lk_met_pla_ctrl_pase.getId_fecha_inicio_real(), 
				lk_met_pla_ctrl_pase.getId_fecha_fin_real(), lk_met_pla_ctrl_pase.getId_estado(), lk_met_pla_ctrl_pase.getId_sn_habilitado(),
				lk_met_pla_ctrl_pase.getId_anyo(), lk_met_pla_ctrl_pase.getId_mes(), lk_met_pla_ctrl_pase.getId_escenario(), 
				lk_met_pla_ctrl_pase.getId_fecha_creacion(), lk_met_pla_ctrl_pase.getId_fecha_modificacion(), lk_met_pla_ctrl_pase.getId_pid()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE saved with id="+lk_met_pla_ctrl_pase.getId());
		}else System.out.println("LK_MET_PLA_CTRL_PASE save failed with id="+lk_met_pla_ctrl_pase.getId());
	}

	@Override
	public LK_MET_PLA_CTRL_PASE getById(int id) {
		// id = id_ejecucion
		String query = "select id_sistema, id_ejecucion, id_software, id_pase, de_pase, id_fecha_inicio, "
				+ "id_fecha_inicio_real, id_fecha_fin_real, id_estado, id_sn_habilitado, id_anyo, id_mes, "
				+ "id_escenario, id_fecha_creacion, id_fecha_modificacion, id_pid "
				+ "from LK_MET_PLA_CTRL_PASE "
				+ "where id_ejecucion = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<LK_MET_PLA_CTRL_PASE>(){

			@Override
			public LK_MET_PLA_CTRL_PASE mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase = new LK_MET_PLA_CTRL_PASE();
				lk_met_pla_ctrl_pase.setId_sistema(rs.getString("id_sistema"));
				lk_met_pla_ctrl_pase.setId_ejecucion(rs.getInt("id_ejecucion"));
				lk_met_pla_ctrl_pase.setId_software(rs.getInt("id_software"));
				lk_met_pla_ctrl_pase.setId_pase(rs.getInt("id_pase"));
				lk_met_pla_ctrl_pase.setDe_pase(rs.getString("de_pase"));
				lk_met_pla_ctrl_pase.setId_fecha_inicio(rs.getDate("id_fecha_inicio"));
				lk_met_pla_ctrl_pase.setId_fecha_inicio_real(rs.getDate("id_fecha_inicio_real"));
				lk_met_pla_ctrl_pase.setId_fecha_fin_real(rs.getDate("id_fecha_fin_real"));
				lk_met_pla_ctrl_pase.setId_estado(rs.getString("id_estado"));
				lk_met_pla_ctrl_pase.setId_sn_habilitado(rs.getString("id_sn_habilitado"));
				lk_met_pla_ctrl_pase.setId_anyo(rs.getInt("id_anyo"));
				lk_met_pla_ctrl_pase.setId_mes(rs.getInt("id_mes"));
				lk_met_pla_ctrl_pase.setId_escenario(rs.getInt("id_escenario"));
				lk_met_pla_ctrl_pase.setId_fecha_creacion(rs.getDate("id_fecha_creacion"));
				lk_met_pla_ctrl_pase.setId_fecha_modificacion(rs.getDate("id_fecha_modificacion"));
				lk_met_pla_ctrl_pase.setId_pid(rs.getInt("id_pid"));
				return lk_met_pla_ctrl_pase;
			}});
		
		return lk_met_pla_ctrl_pase;
	}

	@Override
	public void update(LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase) {
		String query = "update LK_MET_PLA_CTRL_PASE "
				+ "set id_sistema=?, id_software=?, id_pase=?, de_pase=?, id_fecha_inicio=?, "
				+ "id_fecha_inicio_real=?, id_fecha_fin_real=?, id_estado=?, id_sn_habilitado=?, "
				+ "id_anyo=?, id_mes=?, id_escenario=?, id_fecha_creacion=?, id_fecha_modificacion=?, id_pid=? "
				+ "where id_ejecucion=?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {lk_met_pla_ctrl_pase.getId_sistema(), 
				lk_met_pla_ctrl_pase.getId_software(), lk_met_pla_ctrl_pase.getId_pase(), lk_met_pla_ctrl_pase.getDe_pase(), 
				lk_met_pla_ctrl_pase.getId_fecha_inicio(), lk_met_pla_ctrl_pase.getId_fecha_inicio_real(), 
				lk_met_pla_ctrl_pase.getId_fecha_fin_real(), lk_met_pla_ctrl_pase.getId_estado(), lk_met_pla_ctrl_pase.getId_sn_habilitado(),
				lk_met_pla_ctrl_pase.getId_anyo(), lk_met_pla_ctrl_pase.getId_mes(), lk_met_pla_ctrl_pase.getId_escenario(), 
				lk_met_pla_ctrl_pase.getId_fecha_creacion(), lk_met_pla_ctrl_pase.getId_fecha_modificacion(), lk_met_pla_ctrl_pase.getId_pid(),
				lk_met_pla_ctrl_pase.getId_ejecucion()}; /* El ID va al final para encajar con la query*/
				// lk_met_pla_ctrl_pase.getId()};
	
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE updated with id="+lk_met_pla_ctrl_pase.getId());
		}else System.out.println("No LK_MET_PLA_CTRL_PASE found with id="+lk_met_pla_ctrl_pase.getId());
	}

	@Override
	public void deleteById(int id) {
		// id = id_ejecucion
		
		String query = "delete from LK_MET_PLA_CTRL_PASE where id_ejecucion=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE deleted with id="+id);
		}else System.out.println("No LK_MET_PLA_CTRL_PASE found with id="+id);
	}

	@Override
	public List<LK_MET_PLA_CTRL_PASE> getAll() {
		String query = "select id_sistema, id_ejecucion, id_software, id_pase, de_pase, id_fecha_inicio, "
				+ "id_fecha_inicio_real, id_fecha_fin_real, id_estado, id_sn_habilitado, "
				+ "id_anyo, id_mes, id_escenario, id_fecha_creacion, id_fecha_modificacion, id_pid "
				+ "from LK_MET_PLA_CTRL_PASE";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<LK_MET_PLA_CTRL_PASE> lk_met_pla_ctrl_paseList = new ArrayList<LK_MET_PLA_CTRL_PASE>();

		List<Map<String,Object>> lk_met_pla_ctrl_paseRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> lk_met_pla_ctrl_paseRow : lk_met_pla_ctrl_paseRows){
			
			LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase = new LK_MET_PLA_CTRL_PASE();
			
			lk_met_pla_ctrl_pase.setId_sistema(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_sistema")));
			lk_met_pla_ctrl_pase.setId_ejecucion(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_ejecucion"))));
			lk_met_pla_ctrl_pase.setId_software(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_software"))));
			lk_met_pla_ctrl_pase.setId_pase(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_pase"))));
			lk_met_pla_ctrl_pase.setDe_pase(String.valueOf(lk_met_pla_ctrl_paseRow.get("de_pase")));
			lk_met_pla_ctrl_pase.setId_fecha_inicio(Date.valueOf(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_fecha_inicio"))));
			lk_met_pla_ctrl_pase.setId_fecha_inicio_real(Date.valueOf(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_fecha_inicio_real"))));
			lk_met_pla_ctrl_pase.setId_fecha_fin_real(Date.valueOf(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_fecha_fin_real"))));
			lk_met_pla_ctrl_pase.setId_estado(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_estado")));
			lk_met_pla_ctrl_pase.setId_sn_habilitado(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_sn_habilitado")));
			lk_met_pla_ctrl_pase.setId_anyo(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_anyo"))));
			lk_met_pla_ctrl_pase.setId_mes(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_mes"))));
			lk_met_pla_ctrl_pase.setId_escenario(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_escenario"))));
			lk_met_pla_ctrl_pase.setId_fecha_creacion(Date.valueOf(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_fecha_creacion"))));
			lk_met_pla_ctrl_pase.setId_fecha_modificacion(Date.valueOf(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_fecha_modificacion"))));
			lk_met_pla_ctrl_pase.setId_pid(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_paseRow.get("id_pid"))));

			lk_met_pla_ctrl_paseList.add(lk_met_pla_ctrl_pase);
		}
		return lk_met_pla_ctrl_paseList;
	}

}
