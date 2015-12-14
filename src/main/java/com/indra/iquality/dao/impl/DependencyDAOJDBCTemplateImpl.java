/*
 * 
 */
package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.DependencyDAO;
import com.indra.iquality.model.Dependency;

// TODO: Auto-generated Javadoc
/**
 * Implementation of {@link com.indra.iquality.dao.DependencyDAO} using JDBC to
 * connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class DependencyDAOJDBCTemplateImpl.
 */
public class DependencyDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements DependencyDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DependencyDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.DependencyDAO#getAll(int, java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public List<Dependency> getAll(int idEjecucion, String idJob, String sistema, int software) {

		// TODO Puedo simplificar la query?
		logger.info("[getAll] : INIT");

		String query = "SELECT " + "JOBREL.ID_SISTEMA, " + "JOBREL.ID_EJECUCION, " + "JOBREL.ID_SOFTWARE, "
				+ "JOBREL.ID_PASE, " + "JOBREL.ID_JOB_PADRE, " + "JOBREL.ID_JOB_HIJO, " + "JOBREL.ID_SN_HABILITADA, "
				+ "PASEJOB.ID_ESTADO " + "FROM LK_MET_PLA_CTRL_PASE_JOB_REL JOBREL, LK_MET_PLA_CTRL_PASE_JOB PASEJOB "
				+ "WHERE " + "JOBREL.ID_JOB_HIJO = ? AND " + "JOBREL.ID_EJECUCION = ? AND "
				+ "JOBREL.ID_SISTEMA = ? AND " + "JOBREL.ID_SOFTWARE = ? AND "
				+ "PASEJOB.ID_SISTEMA = JOBREL.ID_SISTEMA AND " + "PASEJOB.ID_SOFTWARE = JOBREL.ID_SOFTWARE AND "
				+ "PASEJOB.ID_EJECUCION = JOBREL.ID_EJECUCION AND " + "PASEJOB.ID_JOB = JOBREL.ID_JOB_PADRE ";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Dependency> dependenciaList = new ArrayList<Dependency>();
		List<Map<String, Object>> dependenciaRows = jdbcTemplate.queryForList(query,
				new Object[] { idJob, idEjecucion, sistema, software });

		// Mapeo los resultados a una lista
		for (Map<String, Object> dependenciaRow : dependenciaRows) {

			Dependency dependencia = new Dependency();

			dependencia.setIdEjecucion(
					helper.filterNullInt(Integer.valueOf(String.valueOf(dependenciaRow.get("id_ejecucion")))));
			dependencia.setSistema(helper.filterString(String.valueOf(dependenciaRow.get("id_sistema"))));
			dependencia.setSoftware(
					helper.filterNullInt(Integer.valueOf(String.valueOf(dependenciaRow.get("id_software")))));
			dependencia.setIdPase(helper.filterNullInt(Integer.valueOf(String.valueOf(dependenciaRow.get("id_pase")))));
			dependencia.setIdJobPadre(helper.filterString(String.valueOf(dependenciaRow.get("id_job_padre"))));
			dependencia.setIdJobHijo(helper.filterString(String.valueOf(dependenciaRow.get("id_job_hijo"))));
			dependencia.setSnHabilitada(helper.filterString(String.valueOf(dependenciaRow.get("id_sn_habilitada"))));
			dependencia.setEstado(helper.filterString(String.valueOf(dependenciaRow.get("id_estado"))));

			dependenciaList.add(dependencia);
		}

		logger.info("[getAll] : RETURN");
		return dependenciaList;
	}

}
