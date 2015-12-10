package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.Pase;
import com.indra.iquality.singleton.Sistema;

public class PaseDAOJDBCTemplateImpl implements PaseDAO {

	private DataSource dataSource;
	private final CustomHelper helper = new CustomHelper();
	private Sistema sistema = Sistema.getInstance();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Pase> getAllDefs() {

		// Podría prescindir de algunos campos que no se muestran
		String query = "SELECT" + " VS.ID_SISTEMA, VS.ID_SOFTWARE, VS.ID_PASE, VS.DE_PASE,"
				+ " DECODE(VS.ID_SN_PASE_ATIPICO,'N','No','S','Sí') AS ID_SN_PASE_ATIPICO,"
				+ " VS.DEFPASE_ROWID,VS.ID_FECHA_CREACION,S.DE_SOFTWARE"
				+ " FROM VS_MET_PLA_DEF_PASE VS , LK_MET_IQ_SOFTWARE S" + " WHERE" + " VS.ID_SISTEMA = ? AND"
				+ " VS.ID_SOFTWARE = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pase> paseDefList = new ArrayList<Pase>();

		List<Map<String, Object>> paseDefRows = jdbcTemplate.queryForList(query,
				new Object[] { sistema.getIdSistema(), sistema.getIdSoftware() });
		for (Map<String, Object> paseDefRow : paseDefRows) {

			Pase paseDef = new Pase();

			paseDef.setId(helper.filterNullInt(Integer.parseInt(String.valueOf(paseDefRow.get("ID_PASE")))));
			paseDef.setNombre(helper.filterNullString(String.valueOf(paseDefRow.get("DE_PASE"))));
			paseDef.setEsAtipico(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SN_PASE_ATIPICO"))));
			paseDef.setSistema(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SISTEMA"))));
			paseDef.setSoftware(helper.filterNullString(String.valueOf(paseDefRow.get("DE_SOFTWARE"))));

			paseDefList.add(paseDef);
		}
		return paseDefList;
	}

	@Override
	public void newPaseDef(Pase pd, String[] jobs, Map<String, String[]> dependencias) {

		String queryInsertDatosBasicos = "insert into VS_MET_PLA_DEF_PASE (id_sistema, id_software, de_pase, id_sn_pase_atipico)"
				+ " values (?, ?, ?, ?)";
		String queryInsertJobs = "insert into VS_MET_PLA_DEF_PASE_JOB (id_sistema, id_software, id_pase, id_job, id_sn_punto_control)"
				+ " values (?, ?, ?, ?, ?)";
		String queryInsertDependencias = "insert into VS_MET_PLA_DEF_PASE_JOB_REL (id_sistema, id_software, id_pase, id_job_padre, id_job_hijo)"
				+ " values (?, ?, ?, ?, ?)";
		String queryIdPase = "select max(id_pase) from VS_MET_PLA_DEF_PASE";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Inserto datos básicos del pase
		Object[] params = new Object[] { sistema.getIdSistema(), sistema.getIdSoftware(), pd.getNombre(),
				pd.getEsAtipico() };
		int out = jdbcTemplate.update(queryInsertDatosBasicos, params);
		if (out != 0)
			System.out.println("Datos básicos guardados; out = " + String.valueOf(out));
		else
			System.out.println("Error al insertar datos básicos!");

		// Inserto jobs del pase
		int idPase = jdbcTemplate.queryForObject(queryIdPase, Integer.class);
		params = new Object[] { sistema.getIdSistema(), sistema.getIdSoftware(), idPase, "_STUB_nombre", "N" // TODO
																												// desharcodear
																												// el
																												// default
																												// checkpoint
																												// =
																												// "N"
		};
		for (int i = 0; i < jobs.length; ++i) {
			params[3] = jobs[i];
			out = jdbcTemplate.update(queryInsertJobs, params);
			if (out != 0)
				System.out.println("Job " + jobs[i] + " guardado; out = " + String.valueOf(out));
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
		params = new Object[] { sistema.getIdSistema(), sistema.getIdSoftware(), idPase, "_STUB_id_job_padre",
				"__STUB_id_job_hijo" };
		for (int i = 0; i < jobs.length; ++i) {
			params[3] = jobs[i];
			for (int j = 0; j < dependencias.get(jobs[i]).length; ++j) {
				params[4] = dependencias.get(jobs[i])[j];
				out = jdbcTemplate.update(queryInsertDependencias, params);
				if (out != 0)
					System.out.println("Dependencia de job " + jobs[i] + " guardada; out = " + String.valueOf(out));
				else
					System.out.println("Error al insertar dependencia de un job!");
			}

		}
	}

}