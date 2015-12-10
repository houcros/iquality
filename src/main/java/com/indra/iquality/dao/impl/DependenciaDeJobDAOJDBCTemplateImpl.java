package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.DependenciaDeJobDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.Dependencia;
import com.indra.iquality.model.Job;
import com.indra.iquality.singleton.Entorno;

public class DependenciaDeJobDAOJDBCTemplateImpl implements DependenciaDeJobDAO {

	private DataSource dataSource;
	private Entorno sistema = Entorno.getInstance();
	
	// Debugging
//	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
//	private int contadorDebugger = 0;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Dependencia> getAll(int idEjecucion, String idJob) {
		
		// TODO Puedo simplificar la query?
		// O devolver una List<Job> y quedarme con los atributos que quiero
		String query = "SELECT "
					+ "JOBREL.ID_SISTEMA, "
					+ "JOBREL.ID_EJECUCION, "
					+ "JOBREL.ID_SOFTWARE, "
					+ "JOBREL.ID_PASE, "
					+ "JOBREL.ID_JOB_PADRE, "
					+ "JOBREL.ID_JOB_HIJO, " 
					+ "JOBREL.ID_SN_HABILITADA, "
					+ "PASEJOB.ID_ESTADO "
					+ "FROM LK_MET_PLA_CTRL_PASE_JOB_REL JOBREL, LK_MET_PLA_CTRL_PASE_JOB PASEJOB "
					+ "WHERE "
					+ "JOBREL.ID_JOB_HIJO = ? AND "
					+ "JOBREL.ID_EJECUCION = ? AND "
					+ "JOBREL.ID_SISTEMA = ? AND "
					+ "JOBREL.ID_SOFTWARE = ? AND "
					+ "PASEJOB.ID_SISTEMA = JOBREL.ID_SISTEMA AND "
					+ "PASEJOB.ID_SOFTWARE = JOBREL.ID_SOFTWARE AND "
					+ "PASEJOB.ID_EJECUCION = JOBREL.ID_EJECUCION AND "
					+ "PASEJOB.ID_JOB = JOBREL.ID_JOB_PADRE ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Dependencia> dependenciaList = new ArrayList<Dependencia>();

		List<Map<String,Object>> dependenciaRows = jdbcTemplate.queryForList(query, new Object[]{idJob, idEjecucion, sistema.getIdSistema(), sistema.getIdSoftware()});
		
		for(Map<String,Object> dependenciaRow : dependenciaRows){
			
//			++contadorDebugger;
			
			Dependencia dependencia = new Dependencia();
			
			if (dependenciaRow.get("id_ejecucion") != null)
				dependencia.setIdEjecucion((Integer.valueOf(String.valueOf(dependenciaRow.get("id_ejecucion")))));
			else dependencia.setIdEjecucion(Entorno.DEFAULT_NULL_INT);
			
			if (dependenciaRow.get("id_sistema") != null)
				dependencia.setSistema((String.valueOf(dependenciaRow.get("id_sistema"))));
			else dependencia.setSistema(Entorno.DEFAULT_NULL_STRING);
			
			if (dependenciaRow.get("id_software") != null)
				dependencia.setSoftware((Integer.valueOf(String.valueOf(dependenciaRow.get("id_software")))));
			else dependencia.setSoftware(Entorno.DEFAULT_NULL_INT);
			
			if (dependenciaRow.get("id_pase") != null)
				dependencia.setIdPase((Integer.valueOf(String.valueOf(dependenciaRow.get("id_pase")))));
			else dependencia.setIdPase(Entorno.DEFAULT_NULL_INT);
			
			if (dependenciaRow.get("id_job_padre") != null)
				dependencia.setIdJobPadre((String.valueOf(dependenciaRow.get("id_job_padre"))));
			else dependencia.setIdJobPadre(Entorno.DEFAULT_NULL_STRING);
		
			if (dependenciaRow.get("id_job_hijo") != null)
				dependencia.setIdJobHijo((String.valueOf(dependenciaRow.get("id_job_hijo"))));
			else dependencia.setIdJobHijo(Entorno.DEFAULT_NULL_STRING);
			
			if (dependenciaRow.get("id_sn_habilitada") != null)
				dependencia.setSnHabilitada((String.valueOf(dependenciaRow.get("id_sn_habilitada"))));
			else dependencia.setSnHabilitada(Entorno.DEFAULT_NULL_STRING);
			
			if (dependenciaRow.get("id_estado") != null)
				dependencia.setEstado((String.valueOf(dependenciaRow.get("id_estado"))));
			else dependencia.setEstado(Entorno.DEFAULT_NULL_STRING);
			
			dependenciaList.add(dependencia);
		}
		
		return dependenciaList;
	}

}
