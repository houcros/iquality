package com.indra.iquality.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.controller.BaseController;
import com.indra.iquality.dao.JobDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.Job;
import com.indra.iquality.singleton.Sistema;

public class JobDAOJDBCTemplateImpl implements JobDAO {

	private DataSource dataSource;
	private Sistema sistema = Sistema.getInstance();
	
	// Debugging
//	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
//	private int contadorDebugger = 0;
	
	private final CustomHelper helper = new CustomHelper();
	
	private final static String DEFAULT_NULL_STRING = "";
	private final static int DEFAULT_NULL_INT = -1;
	private final static Date DEFAULT_NULL_DATE = new Date(1);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job getById(int id_ejecucion, String id_job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id_ejecucion, String id_job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Job> getAll() throws Exception {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.indra.iquality.dao.JobDAO#getAll(int)
	 * Obtiene todos los jobs de un pase identificado por @Param idEjecucion
	 */
	@Override
	public List<Job> getAll(int idEjecucion) throws Exception {
		
		/* 
		 * Es la query tal como la saqué del APEX
		 * Hay varios atributos que no uso y probablemente se pueden eliminar
		 */
		String query = "select "	 
			    + "ROWID AS PASEJOB_ROWID, "
			    + "ID_EJECUCION, "
			    + "ID_JOB, "
				+ "ID_SISTEMA, "
				+ "ID_SOFTWARE, "
				+ "ID_PASE, "
				+ "ID_PID, "
				+ "ID_FECHA_INICIO, "
				+ "ID_FECHA_FIN, "
				+ "ID_ESTADO, "
				+ "ID_FECHA_CREACION, "
				+ "ID_FECHA_MODIFICACION, "
				+ "DECODE(ID_SN_PUNTO_CONTROL,'N','No','S','Sí') AS ID_SN_PUNTO_CONTROL,	ID_FECHA_OK_PUNTO_CONTROL, "
			    + "TO_CHAR(TRUNC(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60)/3600),'FM9900') || ':' || "
			    + "TO_CHAR(TRUNC(MOD(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60),3600)/60),'FM00') || ':' || "
			    + "TO_CHAR(MOD(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60),60),'FM00') "
			    + "AS DURACION "
			    + "from LK_MET_PLA_CTRL_PASE_JOB "
			    + "WHERE "
			    + "ID_EJECUCION = ? AND "
			    + "ID_SOFTWARE = ? AND "
			    + "ID_SISTEMA = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Job> jobList = new ArrayList<Job>();

		List<Map<String,Object>> jobRows = jdbcTemplate.queryForList(query, new Object[]{idEjecucion, sistema.getIdSoftware(), sistema.getIdSistema()});
		
		for(Map<String,Object> jobRow : jobRows){
			
//			++contadorDebugger;
			
			Job job = new Job();
			
			if (jobRow.get("id_job") != null)
				job.setIdJob((String.valueOf(jobRow.get("id_job"))));
			else job.setIdJob(DEFAULT_NULL_STRING);
			
			if (jobRow.get("id_ejecucion") != null)
				job.setIdEjecucion((String.valueOf(jobRow.get("id_ejecucion"))));
			else job.setIdEjecucion(DEFAULT_NULL_STRING);
			
			if (jobRow.get("id_estado") != null)
				job.setEstado((String.valueOf(jobRow.get("id_estado"))));
			else job.setEstado(DEFAULT_NULL_STRING);
			
			if (jobRow.get("id_fecha_inicio") != null)
				job.setFechaInicio((helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_inicio")))));
			else job.setFechaInicio(DEFAULT_NULL_DATE);
			
			if (jobRow.get("id_fecha_fin") != null)
				job.setFechaFin((helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_fin")))));
			else job.setFechaFin(DEFAULT_NULL_DATE);
			
			if (jobRow.get("id_sn_punto_control") != null)
				job.setPuntoDeControl((String.valueOf(jobRow.get("id_sn_punto_control"))));
			else job.setPuntoDeControl(DEFAULT_NULL_STRING);
			
			if (jobRow.get("id_fecha_ok_punto_control") != null)
				job.setFechaOKPuntoDeControl((helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_ok_punto_control")))));
			else job.setFechaOKPuntoDeControl(DEFAULT_NULL_DATE);
			
			if (jobRow.get("duracion") != null)
				job.setDuracion((String.valueOf(jobRow.get("duracion"))));
			else job.setDuracion(DEFAULT_NULL_STRING);
			
			if (jobRow.get("id_software") != null)
				job.setSoftware((Integer.valueOf(String.valueOf(jobRow.get("id_software")))));
			else job.setSoftware(DEFAULT_NULL_INT);
			
			if (jobRow.get("id_sistema") != null)
				job.setSistema((String.valueOf(jobRow.get("id_sistema"))));
			else job.setSistema(DEFAULT_NULL_STRING);
			
			jobList.add(job);
		}
		return jobList;
	}
	
}