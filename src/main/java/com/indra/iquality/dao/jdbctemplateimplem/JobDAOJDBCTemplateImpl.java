/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.JobDAO;
import com.indra.iquality.model.Job;

/**
 * Implementation of {@link com.indra.iquality.dao.JobDAO} using JDBC to connect
 * to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class JobDAOJDBCTemplateImpl.
 */
public class JobDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements JobDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(JobDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.JobDAO#getById(int, java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public Job getById(int id_ejecucion, String id_job, String sistema, int software) {
		// TODO Auto-generated method stub
		logger.debug("[getById] : UNIMPLEMENTED");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.JobDAO#update(com.indra.iquality.model.Job,
	 * java.lang.String, int)
	 */
	@Override
	public boolean update(Job job, String sistema, int software) {
		// TODO Auto-generated method stub
		logger.debug("[update] : UNIMPLEMENTED");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.JobDAO#deleteById(int, java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public boolean deleteById(int idEjecucion, String idJob, String sistema, int software) {
		// TODO Auto-generated method stub
		logger.debug("[deleteById] : UNIMPLEMENTED");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.JobDAO#getAll(java.lang.String, int)
	 */
	@Override
	public List<Job> getAll(String sistema, int software) throws ParseException {

		logger.info("[getAll] : INIT");

		String query = "SELECT" + " JOB.ROWID,  JOB.ID_JOB, JOB.ID_SOFTWARE, JOB.ID_SISTEMA, JOB.ID_BLOQUE,"
				+ " SOFT.DE_SOFTWARE, BLOQ.DE_BLOQUE" + " FROM"
				+ " LK_MET_IQ_JOB JOB, LK_MET_IQ_SOFTWARE SOFT, LK_MET_IQ_BLOQUE BLOQ" + " WHERE"
				+ " JOB.ID_SISTEMA = SOFT.ID_SISTEMA AND" + " JOB.ID_SOFTWARE = SOFT.ID_SOFTWARE AND"
				+ " JOB.ID_SOFTWARE = ? AND" + " JOB.ID_SISTEMA = ? AND" + " JOB.ID_SISTEMA = BLOQ.ID_SISTEMA AND"
				+ " JOB.ID_BLOQUE = BLOQ.ID_BLOQUE" + " ORDER BY JOB.ID_JOB ASC";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Job> jobList = new ArrayList<Job>();
		List<Map<String, Object>> jobRows = jdbcTemplate.queryForList(query, new Object[] { software, sistema });

		// Mapeo a una lista
		for (Map<String, Object> jobRow : jobRows) {

			Job job = new Job();

			job.setIdJob(helper.filterNullString(String.valueOf(jobRow.get("ID_JOB"))));
			job.setSistema(helper.filterNullString(String.valueOf(jobRow.get("ID_SISTEMA"))));
			job.setIdBloque(helper.filterNullString(String.valueOf(jobRow.get("ID_BLOQUE"))));
			job.setBloque(helper.filterNullString(String.valueOf(jobRow.get("DE_BLOQUE"))));

			jobList.add(job);
		}

		logger.info("[getAll] : RETURN");
		return jobList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.JobDAO#getAll(int) Obtiene todos los jobs de
	 * un pase identificado por @Param idEjecucion
	 */
	@Override
	public List<Job> getAllOfExecution(int idEjecucion, String sistema, int software) throws ParseException {

		logger.info("[getAllOfExecution] : INIT");

		String query = "select " + "ROWID AS PASEJOB_ROWID, " + "ID_EJECUCION, " + "ID_JOB, " + "ID_SISTEMA, "
				+ "ID_SOFTWARE, " + "ID_PASE, " + "ID_PID, " + "ID_FECHA_INICIO, " + "ID_FECHA_FIN, " + "ID_ESTADO, "
				+ "ID_FECHA_CREACION, " + "ID_FECHA_MODIFICACION, "
				+ "DECODE(ID_SN_PUNTO_CONTROL,'N','No','S','Sí') AS ID_SN_PUNTO_CONTROL,	ID_FECHA_OK_PUNTO_CONTROL, "
				+ "TO_CHAR(TRUNC(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60)/3600),'FM9900') || ':' || "
				+ "TO_CHAR(TRUNC(MOD(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60),3600)/60),'FM00') || ':' || "
				+ "TO_CHAR(MOD(((ID_FECHA_FIN - ID_FECHA_INICIO)*24*60*60),60),'FM00') " + "AS DURACION "
				+ "from LK_MET_PLA_CTRL_PASE_JOB " + "WHERE " + "ID_EJECUCION = ? AND " + "ID_SOFTWARE = ? AND "
				+ "ID_SISTEMA = ? ";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Job> jobList = new ArrayList<Job>();
		List<Map<String, Object>> jobRows = jdbcTemplate.queryForList(query,
				new Object[] { idEjecucion, software, sistema });

		// Mapeo a una lista
		for (Map<String, Object> jobRow : jobRows) {

			Job job = new Job();

			job.setIdJob(helper.filterNullString((String.valueOf(jobRow.get("id_job")))));
			job.setIdEjecucion(helper.filterNullString((String.valueOf(jobRow.get("id_ejecucion")))));
			job.setEstado(helper.filterNullString((String.valueOf(jobRow.get("id_estado")))));
			job.setFechaInicio((helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_inicio")))));
			job.setFechaFin((helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_fin")))));
			job.setPuntoDeControl(helper.filterNullString((String.valueOf(jobRow.get("id_sn_punto_control")))));
			job.setFechaOKPuntoDeControl(
					(helper.auxStringToSqlDate(String.valueOf(jobRow.get("id_fecha_ok_punto_control")))));
			job.setDuracion(helper.filterNullString((String.valueOf(jobRow.get("duracion")))));
			job.setSoftware(helper.filterNullInt((Integer.valueOf(String.valueOf(jobRow.get("id_software"))))));
			job.setSistema(helper.filterNullString((String.valueOf(jobRow.get("id_sistema")))));

			jobList.add(job);
		}

		logger.info("[getAllOfExecution] : RETURN");
		return jobList;
	}

}