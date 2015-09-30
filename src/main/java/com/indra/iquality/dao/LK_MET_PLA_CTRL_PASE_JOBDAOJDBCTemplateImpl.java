package com.indra.iquality.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE_JOB;

public class LK_MET_PLA_CTRL_PASE_JOBDAOJDBCTemplateImpl implements LK_MET_PLA_CTRL_PASE_JOBDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job) {
		String query = "insert into LK_MET_PLA_CTRL_PASE_JOB (id_sistema, id_ejecucion, id_software, id_pase, id_job, "
				+ "id_pid, id_fecha_inicio, id_fecha_fin, id_estado, id_fecha_creacion, "
				+ "id_fecha_modificacion, id_sn_punto_control, id_fecha_ok_punto_control) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {
				lk_met_pla_ctrl_pase_job.getId_sistema(), lk_met_pla_ctrl_pase_job.getId_ejecucion(), 
				lk_met_pla_ctrl_pase_job.getId_software(), lk_met_pla_ctrl_pase_job.getId_pase(), lk_met_pla_ctrl_pase_job.getId_job(), 
				lk_met_pla_ctrl_pase_job.getId_pid(), lk_met_pla_ctrl_pase_job.getId_fecha_inicio(), lk_met_pla_ctrl_pase_job.getId_fecha_fin(),
				lk_met_pla_ctrl_pase_job.getId_estado(), lk_met_pla_ctrl_pase_job.getId_fecha_creacion(), lk_met_pla_ctrl_pase_job.getId_fecha_modificacion(),
				lk_met_pla_ctrl_pase_job.getId_sn_punto_control(), lk_met_pla_ctrl_pase_job.getId_fecha_ok_punto_control()
		};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE_JOB saved with id="+lk_met_pla_ctrl_pase_job.getId());
		}else System.out.println("LK_MET_PLA_CTRL_PASE_JOB save failed with id="+lk_met_pla_ctrl_pase_job.getId());
	}

	@Override
	public LK_MET_PLA_CTRL_PASE_JOB getById(int id_ejecucion, String id_job) {
		// PK = id_ejecucion, id_job
		String query = "select id_sistema, id_ejecucion, id_software, id_pase, id_job, "
				+ "id_pid, id_fecha_inicio, id_fecha_fin, id_estado, id_fecha_creacion, "
				+ "id_fecha_modificacion, id_sn_punto_control, id_fecha_ok_punto_control "
				+ "from LK_MET_PLA_CTRL_PASE_JOB "
				+ "where id_ejecucion=? AND id_job=?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
			//using RowMapper anonymous class, we can create a separate RowMapper for reuse
			LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job = jdbcTemplate.queryForObject(query, new Object[]{id_ejecucion, id_job}, new RowMapper<LK_MET_PLA_CTRL_PASE_JOB>(){

				@Override
				public LK_MET_PLA_CTRL_PASE_JOB mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job = new LK_MET_PLA_CTRL_PASE_JOB();
					lk_met_pla_ctrl_pase_job.setId_sistema(rs.getString("id_sistema"));
					lk_met_pla_ctrl_pase_job.setId_ejecucion(rs.getInt("id_ejecucion"));
					lk_met_pla_ctrl_pase_job.setId_software(rs.getInt("id_software"));
					lk_met_pla_ctrl_pase_job.setId_pase(rs.getInt("id_pase"));
					lk_met_pla_ctrl_pase_job.setId_job(rs.getString("id_job"));
					lk_met_pla_ctrl_pase_job.setId_pid(rs.getInt("id_pid"));
					lk_met_pla_ctrl_pase_job.setId_fecha_inicio(rs.getDate("id_fecha_inicio"));
					lk_met_pla_ctrl_pase_job.setId_fecha_fin(rs.getDate("id_fecha_fin"));
					lk_met_pla_ctrl_pase_job.setId_estado(rs.getString("id_estado"));
					lk_met_pla_ctrl_pase_job.setId_fecha_creacion(rs.getDate("id_fecha_creacion"));
					lk_met_pla_ctrl_pase_job.setId_fecha_modificacion(rs.getDate("id_fecha_modificacion"));
					lk_met_pla_ctrl_pase_job.setId_sn_punto_control(rs.getString("id_sn_punto_control"));
					lk_met_pla_ctrl_pase_job.setId_fecha_ok_punto_control(rs.getDate("id_fecha_ok_punto_control"));
					return lk_met_pla_ctrl_pase_job;
				}});
			
			return lk_met_pla_ctrl_pase_job;
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public void update(LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job) {
		String query = "update LK_MET_PLA_CTRL_PASE_JOB "
				+ "set id_sistema=?, id_software=?, id_pase=?, id_pid=?, id_fecha_inicio=?, "
				+ "id_fecha_fin=?, id_estado=?, id_fecha_creacion=?, id_fecha_modificacion=?, "
				+ "id_sn_punto_control=?, id_fecha_ok_punto_control=? "
				+ "where id_ejecucion=? AND id_job=?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {
				lk_met_pla_ctrl_pase_job.getId_sistema(), lk_met_pla_ctrl_pase_job.getId_software(), 
				lk_met_pla_ctrl_pase_job.getId_pase(), lk_met_pla_ctrl_pase_job.getId_pid(), 
				lk_met_pla_ctrl_pase_job.getId_fecha_inicio(), lk_met_pla_ctrl_pase_job.getId_fecha_fin(), 
				lk_met_pla_ctrl_pase_job.getId_estado(), lk_met_pla_ctrl_pase_job.getId_fecha_creacion(), 
				lk_met_pla_ctrl_pase_job.getId_fecha_modificacion(), lk_met_pla_ctrl_pase_job.getId_sn_punto_control(),
				lk_met_pla_ctrl_pase_job.getId_fecha_ok_punto_control(),
				lk_met_pla_ctrl_pase_job.getId_ejecucion(), lk_met_pla_ctrl_pase_job.getId_job()}; /* La PK va al final para encajar con la query*/
	
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE_JOB updated with id="+lk_met_pla_ctrl_pase_job.getId());
		}else System.out.println("No LK_MET_PLA_CTRL_PASE_JOB found with id="+lk_met_pla_ctrl_pase_job.getId());
	}

	@Override
	public void deleteById(int id_ejecucion, String id_job) {
		// id = id_ejecucion
		
		String query = "delete from LK_MET_PLA_CTRL_PASE_JOB where id_ejecucion=? AND id_job=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {
				id_ejecucion, id_job
		};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("LK_MET_PLA_CTRL_PASE_JOB deleted with id="+String.valueOf(id_ejecucion)+id_job);
		}else System.out.println("No LK_MET_PLA_CTRL_PASE_JOB found with id="+String.valueOf(id_ejecucion)+id_job);
	}

	@Override
	public List<LK_MET_PLA_CTRL_PASE_JOB> getAll() {
		String query = "select id_sistema, id_ejecucion, id_software, id_pase, id_job, "
				+ "id_pid, id_fecha_inicio, id_fecha_fin, id_estado, id_fecha_creacion, "
				+ "id_fecha_modificacion, id_sn_punto_control, id_fecha_ok_punto_control "
				+ "from LK_MET_PLA_CTRL_PASE_JOB";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<LK_MET_PLA_CTRL_PASE_JOB> lk_met_pla_ctrl_pase_jobList = new ArrayList<LK_MET_PLA_CTRL_PASE_JOB>();

		List<Map<String,Object>> lk_met_pla_ctrl_pase_jobRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> lk_met_pla_ctrl_pase_jobRow : lk_met_pla_ctrl_pase_jobRows){
			
			LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job = new LK_MET_PLA_CTRL_PASE_JOB();
			
			lk_met_pla_ctrl_pase_job.setId_sistema(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_sistema")));
			lk_met_pla_ctrl_pase_job.setId_ejecucion(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_ejecucion"))));
			lk_met_pla_ctrl_pase_job.setId_software(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_software"))));
			lk_met_pla_ctrl_pase_job.setId_pase(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_pase"))));
			lk_met_pla_ctrl_pase_job.setId_job(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_job")));
			lk_met_pla_ctrl_pase_job.setId_pid(Integer.parseInt(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_pid"))));
			lk_met_pla_ctrl_pase_job.setId_fecha_inicio(Date.valueOf(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_fecha_inicio"))));
			lk_met_pla_ctrl_pase_job.setId_fecha_fin(Date.valueOf(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_fecha_fin"))));
			lk_met_pla_ctrl_pase_job.setId_estado(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_estado")));
			lk_met_pla_ctrl_pase_job.setId_fecha_creacion(Date.valueOf(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_fecha_creacion"))));
			lk_met_pla_ctrl_pase_job.setId_fecha_modificacion(Date.valueOf(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_fecha_modificacion"))));
			lk_met_pla_ctrl_pase_job.setId_sn_punto_control(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_sn_punto_control")));
			lk_met_pla_ctrl_pase_job.setId_fecha_ok_punto_control(Date.valueOf(String.valueOf(lk_met_pla_ctrl_pase_jobRow.get("id_fecha_ok_punto_control"))));

			lk_met_pla_ctrl_pase_jobList.add(lk_met_pla_ctrl_pase_job);
		}
		return lk_met_pla_ctrl_pase_jobList;
	}

}
