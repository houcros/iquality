package com.indra.iquality.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.controller.BaseController;
import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.Pase;
import com.indra.iquality.model.PaseDef;
import com.indra.iquality.singleton.Sistema;

public class PaseDAOJDBCTemplateImpl implements PaseDAO {

	private DataSource dataSource;
	
	// Debugging
//	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
//	private int contadorDebugger = 0;
	
	private final CustomHelper helper = new CustomHelper();
	private Sistema sistema = Sistema.getInstance();
	
	private final static String DEFAULT_NULL_STRING = "";
	private final static int DEFAULT_NULL_INT = -1;
	private final static Date DEFAULT_NULL_DATE = new Date(1);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Pase pase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pase getById(int idEjecucion) {
		
		String query = "select "
				+ "PASE.ROWID as EJEC_ROWID, " 
				+ "PASE.ID_EJECUCION, "
				+ "PASE.ID_SISTEMA, "
				+ "SOFT.DE_SOFTWARE, "
				+ "PASE.ID_SOFTWARE, "
				+ "PASE.ID_PASE, "
				+ "PASE.DE_PASE, "
				+ "PASE.ID_FECHA_INICIO, "
				+ "PASEJOB.ID_FECHA_INICIO_REAL, "
				+ "PASE.ID_FECHA_FIN_REAL, "
				+ "PASE.ID_ESTADO, "
				+ "DECODE(PASE.ID_SN_HABILITADO,'N','No','S','Sí') AS ID_SN_HABILITADO, "
				+ "PASE.ID_ANYO, "
				+ "PASE.ID_MES, "
				+ "PASE.ID_ESCENARIO, "
				+ "PASE.ID_FECHA_CREACION, "
				+ "PASE.ID_FECHA_MODIFICACION, "
				+ "PASE.ID_PID, "
				+ "ESC.DE_ESCENARIO, "
				+ "TO_CHAR(TRUNC(PASEJOB.DURACION_JOBS/3600),'FM9900') || ':' || "
				+ "TO_CHAR(TRUNC(MOD(PASEJOB.DURACION_JOBS,3600)/60),'FM00') || ':' || "
				+ "TO_CHAR(MOD(PASEJOB.DURACION_JOBS,60),'FM00') "
				+ "AS DURACION "
				+ "from LK_MET_PLA_CTRL_PASE PASE, LK_MET_IQ_ESCENARIO ESC, LK_MET_IQ_SOFTWARE SOFT, "
				+ "(SELECT PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE, MIN(PASJOB.ID_FECHA_INICIO) AS ID_FECHA_INICIO_REAL, "
				+ "SUM((PASJOB.ID_FECHA_FIN - PASJOB.ID_FECHA_INICIO)*24*60*60) AS DURACION_JOBS "
				+ "FROM " 
				+ "LK_MET_PLA_CTRL_PASE PAS, "
				+ "LK_MET_PLA_CTRL_PASE_JOB PASJOB "
				+ "WHERE " 
				+ "PAS.ID_SISTEMA = PASJOB.ID_SISTEMA AND "
				+ "PAS.ID_EJECUCION = PASJOB.ID_EJECUCION AND "
				+ "PAS.ID_SOFTWARE = PASJOB.ID_SOFTWARE AND "
				+ "PAS.ID_PASE = PASJOB.ID_PASE "
				+ "GROUP BY PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE) PASEJOB "
				+ "where "
				+ "PASE.ID_SISTEMA = PASEJOB.ID_SISTEMA AND "
				+ "PASE.ID_EJECUCION = PASEJOB.ID_EJECUCION AND "
				+ "PASE.ID_SOFTWARE = PASEJOB.ID_SOFTWARE AND "
				+ "PASE.ID_PASE = PASEJOB.ID_PASE AND "
				+ "PASE.ID_SOFTWARE = SOFT.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = SOFT.ID_SISTEMA AND "
				+ "PASE.ID_SOFTWARE = ESC.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = ESC.ID_SISTEMA AND "
				+ "PASE.ID_ESCENARIO = ESC.ID_ESCENARIO AND "
				+ "PASE.ID_EJECUCION = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Pase pase = jdbcTemplate.queryForObject(query, new Object[]{idEjecucion}, new RowMapper<Pase>(){
			
			@Override
			public Pase mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Pase pase = new Pase();
				
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
		return pase;
	}

	@Override
	public void update(Pase pase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id_ejecucion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pase> getAll() throws Exception {
		
		/* 
		 * Es la query tal como la saqué del APEX
		 * Hay varios atributos que no uso y probablemente se pueden eliminar
		 */
		String query = "select "
				+ "PASE.ROWID as EJEC_ROWID, " 
				+ "PASE.ID_EJECUCION, "
				+ "PASE.ID_SISTEMA, "
				+ "SOFT.DE_SOFTWARE, "
				+ "PASE.ID_SOFTWARE, "
				+ "PASE.ID_PASE, "
				+ "PASE.DE_PASE, "
				+ "PASE.ID_FECHA_INICIO, "
				+ "PASEJOB.ID_FECHA_INICIO_REAL, "
				+ "PASE.ID_FECHA_FIN_REAL, "
				+ "PASE.ID_ESTADO, "
				+ "DECODE(PASE.ID_SN_HABILITADO,'N','No','S','Sí') AS ID_SN_HABILITADO, "
				+ "PASE.ID_ANYO, "
				+ "PASE.ID_MES, "
				+ "PASE.ID_ESCENARIO, "
				+ "PASE.ID_FECHA_CREACION, "
				+ "PASE.ID_FECHA_MODIFICACION, "
				+ "PASE.ID_PID, "
				+ "ESC.DE_ESCENARIO, "
				+ "TO_CHAR(TRUNC(PASEJOB.DURACION_JOBS/3600),'FM9900') || ':' || "
				+ "TO_CHAR(TRUNC(MOD(PASEJOB.DURACION_JOBS,3600)/60),'FM00') || ':' || "
				+ "TO_CHAR(MOD(PASEJOB.DURACION_JOBS,60),'FM00') "
				+ "AS DURACION "
				+ "from LK_MET_PLA_CTRL_PASE PASE, LK_MET_IQ_ESCENARIO ESC, LK_MET_IQ_SOFTWARE SOFT, "
				+ "(SELECT PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE, MIN(PASJOB.ID_FECHA_INICIO) AS ID_FECHA_INICIO_REAL, "
				+ "SUM((PASJOB.ID_FECHA_FIN - PASJOB.ID_FECHA_INICIO)*24*60*60) AS DURACION_JOBS "
				+ "FROM " 
				+ "LK_MET_PLA_CTRL_PASE PAS, "
				+ "LK_MET_PLA_CTRL_PASE_JOB PASJOB "
				+ "WHERE " 
				+ "PAS.ID_SISTEMA = PASJOB.ID_SISTEMA AND "
				+ "PAS.ID_EJECUCION = PASJOB.ID_EJECUCION AND "
				+ "PAS.ID_SOFTWARE = PASJOB.ID_SOFTWARE AND "
				+ "PAS.ID_PASE = PASJOB.ID_PASE "
				+ "GROUP BY PASJOB.ID_SISTEMA, PASJOB.ID_EJECUCION, PASJOB.ID_SOFTWARE, PASJOB.ID_PASE) PASEJOB "
				+ "where "
				+ "PASE.ID_SISTEMA = PASEJOB.ID_SISTEMA AND "
				+ "PASE.ID_EJECUCION = PASEJOB.ID_EJECUCION AND "
				+ "PASE.ID_SOFTWARE = PASEJOB.ID_SOFTWARE AND "
				+ "PASE.ID_PASE = PASEJOB.ID_PASE AND "
				+ "PASE.ID_SOFTWARE = SOFT.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = SOFT.ID_SISTEMA AND "
				+ "PASE.ID_SOFTWARE = ESC.ID_SOFTWARE AND "
				+ "PASE.ID_SISTEMA = ESC.ID_SISTEMA AND "
				+ "PASE.ID_ESCENARIO = ESC.ID_ESCENARIO";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pase> paseList = new ArrayList<Pase>();

		List<Map<String,Object>> paseRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> paseRow : paseRows){
			
//			++contadorDebugger;
			
			Pase pase = new Pase();
			
			if (paseRow.get("id_ejecucion") != null)
				pase.setIdEjecucion(Integer.parseInt(String.valueOf(paseRow.get("id_ejecucion"))));
			else pase.setIdEjecucion(DEFAULT_NULL_INT);
			
			if (paseRow.get("de_pase") != null)
				pase.setPase(String.valueOf(paseRow.get("de_pase")));
			else pase.setPase(DEFAULT_NULL_STRING);
			
			if (paseRow.get("id_estado") != null)
				pase.setEstado(String.valueOf(paseRow.get("id_estado")));
			else pase.setEstado(DEFAULT_NULL_STRING);
			
			if (paseRow.get("id_anyo") != null && paseRow.get("id_mes") != null)
				pase.setFechaDatos(String.valueOf(paseRow.get("id_anyo"))
						+ String.valueOf(paseRow.get("id_mes")));
			else pase.setFechaDatos(DEFAULT_NULL_STRING);
			
			if (paseRow.get("id_escenario") != null)
				pase.setEscenario(String.valueOf(paseRow.get("id_escenario")));
			else pase.setEscenario(DEFAULT_NULL_STRING);
			
			if (paseRow.get("id_fecha_inicio_real") != null)
				pase.setFechaInicio(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_inicio_real"))));
			else pase.setFechaInicio(DEFAULT_NULL_DATE);
			
			if (paseRow.get("id_fecha_fin_real") != null)
				pase.setFechaFin(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_fin_real"))));
			else pase.setFechaFin(DEFAULT_NULL_DATE);
			
			if (paseRow.get("id_fecha_inicio") != null)
				pase.setFechaPlanificada(helper.auxStringToSqlDate(String.valueOf(paseRow.get("id_fecha_inicio"))));
			else pase.setFechaPlanificada(DEFAULT_NULL_DATE);
			
			if (paseRow.get("de_software") != null)
				pase.setSoftware(String.valueOf(paseRow.get("de_software")));
			else pase.setSoftware(DEFAULT_NULL_STRING);
			
			if (paseRow.get("duracion") != null)
				pase.setDuracion(String.valueOf(paseRow.get("duracion")));
			else pase.setDuracion(DEFAULT_NULL_STRING);

			paseList.add(pase);
		}
		return paseList;
	}
	
	@Override
	public List<PaseDef> getAllDefs(){
		
		// Podría prescindir de algunos campos que no se muestran
		String query = "SELECT"
				+ " VS.ID_SISTEMA, VS.ID_SOFTWARE, VS.ID_PASE, VS.DE_PASE,"
				+ " DECODE(VS.ID_SN_PASE_ATIPICO,'N','No','S','Sí') AS ID_SN_PASE_ATIPICO,"
				+ " VS.DEFPASE_ROWID,VS.ID_FECHA_CREACION,S.DE_SOFTWARE"
				+ " FROM VS_MET_PLA_DEF_PASE VS , LK_MET_IQ_SOFTWARE S"
				+ " WHERE"
				+ " VS.ID_SISTEMA = S.ID_SISTEMA AND"
				+ " VS.ID_SOFTWARE = S.ID_SOFTWARE";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<PaseDef> paseDefList = new ArrayList<PaseDef>();

		List<Map<String,Object>> paseDefRows = jdbcTemplate.queryForList(query, new Object[]{sistema.getIdSistema(), sistema.getIdSoftware()});
		for (Map<String,Object> paseDefRow : paseDefRows){
			
			PaseDef paseDef = new PaseDef();
			
			paseDef.setId(helper.filterNullInt(Integer.parseInt(String.valueOf(paseDefRow.get("ID_PASE")))));
			paseDef.setNombre(helper.filterNullString(String.valueOf(paseDefRow.get("DE_PASE"))));
			paseDef.setEsAtipico(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SN_PASE_ATIPICO"))));
			paseDef.setSistema(helper.filterNullString(String.valueOf(paseDefRow.get("ID_SISTEMA"))));
			paseDef.setSoftware(helper.filterNullString(String.valueOf(paseDefRow.get("DE_SOFTWARE"))));
			
			paseDefList.add(paseDef);
		}
		return paseDefList;
	}
	
}