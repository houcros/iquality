package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.Pase;
import com.indra.iquality.singleton.Entorno;

public class PaseDAOJDBCTemplateImpl implements PaseDAO {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PaseDAOJDBCTemplateImpl.class);
	private DataSource dataSource;
	private final CustomHelper helper = new CustomHelper();
	private Entorno entorno = Entorno.getInstance();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Pase> getAllPases() {

		// TODO arquitectura -> La query original tambien seleccionaba
		// VS.DEFPASE_ROWID y VS.ID_FECHA_CREACION pero no se muestran. Se
		// quieren mostrar?
		String query = "SELECT"
				+ " VS.ID_PASE, VS.DE_PASE, DECODE(VS.ID_SN_PASE_ATIPICO,'N','No','S','Sí') AS ID_SN_PASE_ATIPICO"
				+ " FROM VS_MET_PLA_DEF_PASE VS , LK_MET_IQ_SOFTWARE S WHERE VS.ID_SISTEMA = ? AND"
				+ " VS.ID_SOFTWARE = ?";

		// Inicializo la conexión a la BD e inicializo la lista que voy a
		// retornar
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pase> paseList = new ArrayList<Pase>();
		// Lanzo la query
		List<Map<String, Object>> paseDefRows = jdbcTemplate.queryForList(query,
				new Object[] { entorno.getIdSistema(), entorno.getIdSoftware() });

		// Itero sobre el resultado de la query y mapeo cada record a un pase
		for (Map<String, Object> paseDefRow : paseDefRows) {

			Pase pase = new Pase();

			pase.setId(helper.filterNullInt(Integer.parseInt(String.valueOf(paseDefRow.get("ID_PASE")))));
			pase.setNombre(helper.filterNullString(String.valueOf(paseDefRow.get("DE_PASE"))));
			pase.setEsAtipico(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SN_PASE_ATIPICO"))));
			pase.setSistema(entorno.getIdSistema());
			pase.setSoftware(entorno.getDescripcionSoftware());

			paseList.add(pase);
			logger.debug("[getAllPases] : pase {}", pase);
		}
		return paseList;
	}

	@Override
	public void insertPase(Pase pase) {

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
			params = new Object[] { entorno.getIdSistema(), entorno.getIdSoftware(), pase.getNombre(),
					pase.getEsAtipico() };
			out = jdbcTemplate.update(queryInsertDatosBasicos, params);
			if (out != 0)
				System.out.println("Datos básicos guardados; out = " + String.valueOf(out));
			else
				System.out.println("Error al insertar datos básicos!");
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				// TODO
			}
		}
		// Inserto jobs del pase
		int idPase = jdbcTemplate.queryForObject(queryIdPase, Integer.class);
		params = new Object[] { entorno.getIdSistema(), entorno.getIdSoftware(), idPase, "_STUB_nombre", "N" // TODO
																												// desharcodear
																												// el
																												// default
																												// checkpoint
																												// =
																												// "N"
		};
		for (int i = 0; i < pase.getJobs().length; ++i) {
			params[3] = pase.getJobs()[i];
			out = jdbcTemplate.update(queryInsertJobs, params);
			if (out != 0)
				System.out.println("Job " + pase.getJobs()[i] + " guardado; out = " + String.valueOf(out));
			else
				System.out.println("Error al insertar un job!");
		}

		// NOTA: en principio se podrían hacer el insert anterior y este en dos
		// loops
		// anidados (en vez de dos anidados más uno), pero un trigger en la BD
		// no
		// permite hacer el insert de las dependencias si los dos jobs
		// involucrados
		// no han sido insertados en VS_MET_PLA_DEF_PASE_JOB

		// Inserto dependencias de los jobs del pase
		params = new Object[] { entorno.getIdSistema(), entorno.getIdSoftware(), idPase, "_STUB_id_job_padre",
				"__STUB_id_job_hijo" };
		for (int i = 0; i < pase.getJobs().length; ++i) {
			params[3] = pase.getJobs()[i];
			for (int j = 0; j < pase.getDependencias().get(pase.getJobs()[i]).length; ++j) {
				params[4] = pase.getDependencias().get(pase.getJobs()[i])[j];
				out = jdbcTemplate.update(queryInsertDependencias, params);
				if (out != 0)
					System.out.println(
							"Dependencia de job " + pase.getJobs()[i] + " guardada; out = " + String.valueOf(out));
				else
					System.out.println("Error al insertar dependencia de un job!");
			}

		}
	}

}