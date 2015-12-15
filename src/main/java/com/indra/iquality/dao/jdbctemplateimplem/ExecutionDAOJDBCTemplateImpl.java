/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.ExecutionDAO;
import com.indra.iquality.model.Execution;

/**
 * Implementation of {@link com.indra.iquality.dao.ExecutionDAO} using JDBC to
 * connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class ExecutionDAOJDBCTemplateImpl.
 */
public class ExecutionDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements ExecutionDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExecutionDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.ExecutionDAO#save(com.indra.iquality.model.
	 * Execution)
	 */
	@Override
	public void save(Execution pase) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.ExecutionDAO#getById(int)
	 */
	@Override
	public Execution getById(int idEjecucion, String sistema, int software) {
		// TODO usar el sistema y software
		logger.info("[getById] : INIT");

		// TODO hay muchos atributos que realmente sobran
		String query = "select " + "PASE.ROWID as EJEC_ROWID, " + "PASE.ID_EJECUCION, " + "PASE.ID_SISTEMA, "
				+ "SOFT.DE_SOFTWARE, " + "PASE.ID_SOFTWARE, " + "PASE.ID_PASE, " + "PASE.DE_PASE, "
				+ "PASE.ID_FECHA_INICIO, " + "PASEJOB.ID_FECHA_INICIO_REAL, " + "PASE.ID_FECHA_FIN_REAL, "
				+ "PASE.ID_ESTADO, " + "DECODE(PASE.ID_SN_HABILITADO,'N','No','S','Sí') AS ID_SN_HABILITADO, "
				+ "PASE.ID_ANYO, " + "PASE.ID_MES, " + "PASE.ID_ESCENARIO, " + "PASE.ID_FECHA_CREACION, "
				+ "PASE.ID_FECHA_MODIFICACION, " + "PASE.ID_PID, " + "ESC.DE_ESCENARIO, "
				+ "TO_CHAR(TRUNC(PASEJOB.DURACION_JOBS/3600),'FM9900') || ':' || "
				+ "TO_CHAR(TRUNC(MOD(PASEJOB.DURACION_JOBS,3600)/60),'FM00') || ':' || "
				+ "TO_CHAR(MOD(PASEJOB.DURACION_JOBS,60),'FM00') " + "AS DURACION "
				+ "from LK_MET_PLA_CTRL_PASE PASE, LK_MET_IQ_ESCENARIO ESC, LK_MET_IQ_SOFTWARE SOFT, "
				+ "(SELECT PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE, MIN(PASJOB.ID_FECHA_INICIO) AS ID_FECHA_INICIO_REAL, "
				+ "SUM((PASJOB.ID_FECHA_FIN - PASJOB.ID_FECHA_INICIO)*24*60*60) AS DURACION_JOBS " + "FROM "
				+ "LK_MET_PLA_CTRL_PASE PAS, " + "LK_MET_PLA_CTRL_PASE_JOB PASJOB " + "WHERE "
				+ "PAS.ID_SISTEMA = PASJOB.ID_SISTEMA AND " + "PAS.ID_EJECUCION = PASJOB.ID_EJECUCION AND "
				+ "PAS.ID_SOFTWARE = PASJOB.ID_SOFTWARE AND " + "PAS.ID_PASE = PASJOB.ID_PASE "
				+ "GROUP BY PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE) PASEJOB "
				+ "where " + "PASE.ID_SISTEMA = PASEJOB.ID_SISTEMA AND "
				+ "PASE.ID_EJECUCION = PASEJOB.ID_EJECUCION AND " + "PASE.ID_SOFTWARE = PASEJOB.ID_SOFTWARE AND "
				+ "PASE.ID_PASE = PASEJOB.ID_PASE AND " + "PASE.ID_SOFTWARE = SOFT.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = SOFT.ID_SISTEMA AND " + "PASE.ID_SOFTWARE = ESC.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = ESC.ID_SISTEMA AND " + "PASE.ID_ESCENARIO = ESC.ID_ESCENARIO AND "
				+ "PASE.ID_EJECUCION = ? ";

		// Hago la query y mapeo a un objeto directamente
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Execution pase = jdbcTemplate.queryForObject(query, new Object[] { idEjecucion }, new RowMapper<Execution>() {

			@Override
			public Execution mapRow(ResultSet rs, int rowNum) throws SQLException {

				Execution pase = new Execution();

				pase.setIdEjecucion(rs.getInt("id_ejecucion"));
				pase.setPase(rs.getString("de_pase"));
				pase.setEstado(rs.getString("id_estado"));
				pase.setFechaDatos(rs.getString("id_anyo") + rs.getString("id_mes"));
				pase.setEscenario(rs.getString("id_escenario"));
				pase.setFechaInicio(rs.getDate("id_fecha_inicio_real"));
				pase.setFechaFin(rs.getDate("id_fecha_fin_real"));
				pase.setFechaPlanificada(rs.getDate("id_fecha_inicio"));
				pase.setSoftware(rs.getString("de_software"));
				pase.setDuracion(rs.getString("duracion"));

				return pase;
			}

		});

		logger.info("[getById] : RETURN");
		return pase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.ExecutionDAO#update(com.indra.iquality.model.
	 * Execution)
	 */
	@Override
	public void update(Execution pase) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.ExecutionDAO#deleteById(int)
	 */
	@Override
	public void deleteById(int id_ejecucion) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.PaseDAO#getAll()
	 */
	@Override
	public List<Execution> getAllEjecuciones(String sistema, int software) {
		// TODO usar el sistema y software
		logger.info("[getAllEjecuciones] : INIT");

		// TODO hay muchos atributos que realmente sobran
		String query = "select " + "PASE.ROWID as EJEC_ROWID, " + "PASE.ID_EJECUCION, " + "PASE.ID_SISTEMA, "
				+ "SOFT.DE_SOFTWARE, " + "PASE.ID_SOFTWARE, " + "PASE.ID_PASE, " + "PASE.DE_PASE, "
				+ "PASE.ID_FECHA_INICIO, " + "PASEJOB.ID_FECHA_INICIO_REAL, " + "PASE.ID_FECHA_FIN_REAL, "
				+ "PASE.ID_ESTADO, " + "DECODE(PASE.ID_SN_HABILITADO,'N','No','S','Sí') AS ID_SN_HABILITADO, "
				+ "PASE.ID_ANYO, " + "PASE.ID_MES, " + "PASE.ID_ESCENARIO, " + "PASE.ID_FECHA_CREACION, "
				+ "PASE.ID_FECHA_MODIFICACION, " + "PASE.ID_PID, " + "ESC.DE_ESCENARIO, "
				+ "TO_CHAR(TRUNC(PASEJOB.DURACION_JOBS/3600),'FM9900') || ':' || "
				+ "TO_CHAR(TRUNC(MOD(PASEJOB.DURACION_JOBS,3600)/60),'FM00') || ':' || "
				+ "TO_CHAR(MOD(PASEJOB.DURACION_JOBS,60),'FM00') " + "AS DURACION "
				+ "from LK_MET_PLA_CTRL_PASE PASE, LK_MET_IQ_ESCENARIO ESC, LK_MET_IQ_SOFTWARE SOFT, "
				+ "(SELECT PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE, MIN(PASJOB.ID_FECHA_INICIO) AS ID_FECHA_INICIO_REAL, "
				+ "SUM((PASJOB.ID_FECHA_FIN - PASJOB.ID_FECHA_INICIO)*24*60*60) AS DURACION_JOBS " + "FROM "
				+ "LK_MET_PLA_CTRL_PASE PAS, " + "LK_MET_PLA_CTRL_PASE_JOB PASJOB " + "WHERE "
				+ "PAS.ID_SISTEMA = PASJOB.ID_SISTEMA AND " + "PAS.ID_EJECUCION = PASJOB.ID_EJECUCION AND "
				+ "PAS.ID_SOFTWARE = PASJOB.ID_SOFTWARE AND " + "PAS.ID_PASE = PASJOB.ID_PASE "
				+ "GROUP BY PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE) PASEJOB "
				+ "where " + "PASE.ID_SISTEMA = PASEJOB.ID_SISTEMA AND "
				+ "PASE.ID_EJECUCION = PASEJOB.ID_EJECUCION AND " + "PASE.ID_SOFTWARE = PASEJOB.ID_SOFTWARE AND "
				+ "PASE.ID_PASE = PASEJOB.ID_PASE AND " + "PASE.ID_SOFTWARE = SOFT.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = SOFT.ID_SISTEMA AND " + "PASE.ID_SOFTWARE = ESC.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = ESC.ID_SISTEMA AND " + "PASE.ID_ESCENARIO = ESC.ID_ESCENARIO";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Execution> paseList = new ArrayList<Execution>();
		List<Map<String, Object>> paseRows = jdbcTemplate.queryForList(query);

		// Mapeo a una lista
		for (Map<String, Object> paseRow : paseRows) {

			Execution pase = new Execution();

			pase.setIdEjecucion(helper.filterNullInt(Integer.parseInt(String.valueOf(paseRow.get("id_ejecucion")))));
			pase.setPase(helper.filterString(String.valueOf(paseRow.get("de_pase"))));
			pase.setEstado(helper.filterString(String.valueOf(paseRow.get("id_estado"))));
			pase.setFechaDatos(helper.filterString(String.valueOf(paseRow.get("id_anyo")))
					+ helper.filterString(String.valueOf(paseRow.get("id_mes"))));
			pase.setEscenario(helper.filterString(String.valueOf(paseRow.get("id_escenario"))));
			try {
				pase.setFechaInicio(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_inicio_real"))));
				pase.setFechaFin(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_fin_real"))));
				pase.setFechaPlanificada(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_inicio"))));
			} catch (ParseException e) {
				logger.error("[getAllEjecuciones] : Error al parsear las fechas <{}> | Ayuda: {}  \n {}", e.getClass(),
						e.getMessage(), e.getStackTrace());
				e.printStackTrace();
			}
			pase.setSoftware(helper.filterString(String.valueOf(paseRow.get("de_software"))));
			pase.setDuracion(helper.filterString(String.valueOf(paseRow.get("duracion"))));

			paseList.add(pase);
		}

		logger.info("[getAllEjecuciones] : RETURN");
		return paseList;
	}

}