/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.FlowDAO;
import com.indra.iquality.model.Flow;
import com.indra.iquality.singleton.Environment;

/**
 * The Class FlowDAOJDBCTemplateImpl.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class FlowDAOJDBCTemplateImpl.
 */
public class FlowDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements FlowDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FlowDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.FlowDAO#getAll(java.lang.String, int)
	 */
	@Override
	public List<Flow> getAll(String system, int software) {

		logger.info("[getAll] : INIT");

		String query = "SELECT"
				+ " VS.ID_PASE, VS.DE_PASE, DECODE(VS.ID_SN_PASE_ATIPICO,'N','No','S','Sí') AS ID_SN_PASE_ATIPICO"
				+ " FROM VS_MET_PLA_DEF_PASE VS , LK_MET_IQ_SOFTWARE S WHERE VS.ID_SISTEMA = ? AND"
				+ " VS.ID_SOFTWARE = ?";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Flow> paseList = new ArrayList<Flow>();
		List<Map<String, Object>> paseDefRows = jdbcTemplate.queryForList(query, new Object[] { system, software });

		// Mapeo los resultados a una lista
		for (Map<String, Object> paseDefRow : paseDefRows) {

			Flow pase = new Flow();

			pase.setId(helper.filterNullInt(Integer.parseInt(String.valueOf(paseDefRow.get("ID_PASE")))));
			pase.setNombre(helper.filterNullString(String.valueOf(paseDefRow.get("DE_PASE"))));
			pase.setEsAtipico(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SN_PASE_ATIPICO"))));
			pase.setSistema(system);
			pase.setSoftware(Environment.getInstance().getSoftwareDescription());

			paseList.add(pase);
		}

		logger.debug("[getAll] : found {} flows", paseList.size());
		logger.info("[getAll] : RETURN");
		return paseList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.FlowDAO#save(com.indra.iquality.model.Flow,
	 * java.lang.String, int)
	 */
	@Override
	public boolean save(Flow pase, String system, int software) {

		logger.info("[save] : INIT");

		// Por el diseño actual de la BD son necesarias 4 queries
		// 1. Para insertar los datos básicos del pase
		String queryInsertDatosBasicos = "insert into VS_MET_PLA_DEF_PASE (id_sistema, id_software, de_pase, id_sn_pase_atipico)"
				+ " values (?, ?, ?, ?)";
		// 2. Para insertar los jobs asociados al pase
		String queryInsertJobs = "insert into VS_MET_PLA_DEF_PASE_JOB (id_sistema, id_software, id_pase, id_job, id_sn_punto_control)"
				+ " values (?, ?, ?, ?, ?)";
		// 3. Para insertar las dependencias entre los jobs del pase
		String queryInsertDependencias = "insert into VS_MET_PLA_DEF_PASE_JOB_REL (id_sistema, id_software, id_pase, id_job_padre, id_job_hijo)"
				+ " values (?, ?, ?, ?, ?)";
		// 4. Para saber cuál es el próximo identificador de pase
		// TODO arquitectura -> Sería mejor controlar esto desde la aplicación?
		String queryIdPase = "select max(id_pase) from VS_MET_PLA_DEF_PASE";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params;
		int out;

		// Query 1: inserto datos básicos del pase
		try {
			params = new Object[] { system, software, pase.getNombre(), pase.getEsAtipico() };
			out = jdbcTemplate.update(queryInsertDatosBasicos, params);
			if (out == 0) {
				logger.warn("No se insertó el pase");
				return false;
			}
		} catch (DataIntegrityViolationException e) {
			logger.error("[save] : El pase ya existe <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			logger.error("[save] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return false;
		}
		logger.debug("[save] : insertado pase");

		// Query 2: pregunto a la BD qué id le toca al pase
		int idPase = jdbcTemplate.queryForObject(queryIdPase, Integer.class);
		params = new Object[] { system, software, idPase, "_STUB_nombre", "N" };
		// TODO desharcodear el default checkpoint = "N"
		logger.debug("[save] : id asignado al pase: {}", idPase);

		// Query 3: inserto jobs del pase
		for (int i = 0; i < pase.getJobs().length; ++i) {
			params[3] = pase.getJobs()[i];
			out = jdbcTemplate.update(queryInsertJobs, params);
			if (out == 0) {
				logger.warn("No se insertó un job");
			}
		}
		logger.debug("[save] : insertados {} jobs", pase.getJobs().length);

		// NOTA: en principio se podrían hacer el insert anterior y este en dos
		// loops anidados (en vez de dos anidados más uno), pero un trigger en
		// la BD no permite hacer el insert de las dependencias si los dos jobs
		// involucrados no han sido insertados en VS_MET_PLA_DEF_PASE_JOB

		// Query 4: inserto dependencias de los jobs del pase
		params = new Object[] { system, software, idPase, "_STUB_id_job_padre", "__STUB_id_job_hijo" };
		for (int i = 0; i < pase.getJobs().length; ++i) {
			params[3] = pase.getJobs()[i];
			for (int j = 0; j < pase.getDependencias().get(pase.getJobs()[i]).length; ++j) {
				params[4] = pase.getDependencias().get(pase.getJobs()[i])[j];
				out = jdbcTemplate.update(queryInsertDependencias, params);
				if (out == 0) {
					logger.warn("No se insertó una dependencia de un job");
				}
			}
			logger.debug("[save] : insertados {} dependencias del job {} ",
					pase.getDependencias().get(pase.getJobs()[i]).length, pase.getJobs()[i]);

		}

		logger.info("[save] : RETURN");
		return true;
	}

}