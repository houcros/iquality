/**
 * 
 */
package com.indra.iquality.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.RegisterOfOperationsDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.RegisterOfOperation;
import com.indra.iquality.singleton.Environment;

/**
 * @author inlucero
 *
 */
public class RegisterOfOperationsDAOJDBCTemplateImpl implements RegisterOfOperationsDAO{

	private DataSource dataSource;
	private Environment sistema = Environment.getInstance();
	
	// Debugging
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterOfOperationsDAOJDBCTemplateImpl.class);
//	private int contadorDebugger = 0;
	
	private final CustomHelper helper = new CustomHelper();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<RegisterOfOperation> getAll(int idEjecucion, String idJob) throws Exception {
		
		System.out.println("[getAll] -> Inicio llamada a método");
		logger.info("[getAll] -> Inicio llamada a método");
		
		// SELECT (A.ID_FECHA_FIN-A.ID_FECHA_INICIO) as duracion,
		// duracion no se usa para nada por lo que parece
		// y hay otra duración, así que no la incluyo
		String query = "SELECT (A.ID_FECHA_FIN-A.ID_FECHA_INICIO) as duracion, "
				+ "A.ROWID AS OP_ROWID, A.ROWID AS FINAL_ROWID, A.ID_OPERACION, "
				+ "A.ID_SISTEMA,A.ID_SOFTWARE,B.DE_BLOQUE,A.ID_JOB,ESC.DE_ESCENARIO, "
				+ "A.ID_EJECUCION,A.ID_FECHA_INICIO,A.ID_FECHA_FIN,A.FC_DURACION, "
				+ "A.ID_TIPO_OPERACION, A.FC_FILAS_CARGADAS,A.FC_FILAS_ACTUALIZADAS, "
				+ "A.FC_FILAS_LEIDAS,A.FC_FILAS_RECHAZADAS,A.FC_FILAS_DESCARTADAS,S.DE_SOFTWARE, "
				+ "A.DE_OPERACION,A.ID_ESTADO,A.ID_ANYO||'-'|| "
				+ "CASE WHEN LENGTH (A.ID_MES)=1 THEN '0'||A.ID_MES ELSE to_char(A.ID_MES) END AS FECHA "
				+ "FROM BS_MET_IQ_OPERACION A "
				+ "LEFT JOIN (SELECT DISTINCT ID_OPERACION, ID_SISTEMA, ID_SOFTWARE FROM BS_MET_IQ_TRAZA) C " 
				+ "ON (A.ID_OPERACION = C.ID_OPERACION AND "
				+ "A.ID_SISTEMA = C.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = C.ID_SOFTWARE) "
				+ "LEFT JOIN LK_MET_IQ_BLOQUE B "
				+ "ON " 
				+ "(A.ID_BLOQUE = B.ID_BLOQUE AND "
				+ "A.ID_SISTEMA = B.ID_SISTEMA) "
				+ "LEFT JOIN LK_MET_IQ_ESCENARIO ESC " 
				+ "ON "
				+ "(A.ID_SISTEMA = ESC.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = ESC.ID_SOFTWARE AND "
				+ "A.ID_ESCENARIO = ESC.ID_ESCENARIO) "
				+ "LEFT JOIN LK_MET_IQ_SOFTWARE S "
				+ "ON "
				+ "(A.ID_SISTEMA = S.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = S.ID_SOFTWARE) "
				+ "WHERE " 
				+ "A.ID_EJECUCION = ? AND " 
				+ "A.ID_JOB = ? AND " 
				+ "A.ID_SISTEMA = ? AND "
				+ "A.ID_SOFTWARE = ? ";

		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<RegisterOfOperation> registroList = new ArrayList<RegisterOfOperation>();

		List<Map<String,Object>> registrosRows = jdbcTemplate.queryForList(query, new Object[]{ idEjecucion, idJob, sistema.getIdSistema(), sistema.getIdSoftware() });
		
		System.out.println("[getAll] -> registroRows.size() = " + registrosRows.size());
		logger.info("[getAll] -> registroRows.size() = " + registrosRows.size());

		for(Map<String,Object> registroRow : registrosRows){
			
			RegisterOfOperation registro = new RegisterOfOperation();
			
//			if (registroRow.get("duracion") != null)
//				registro.setDuracion((helper.auxStringToSqlDate(String.valueOf(registroRow.get("duracion")))));
//			else registro.setDuracion(DEFAULT_NULL_DATE);
			
			if (registroRow.get("op_rowid") != null)
				registro.setOpRowId((String.valueOf(registroRow.get("op_rowid"))));
			else registro.setOpRowId(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("final_rowid") != null)
				registro.setFinalRowId((String.valueOf(registroRow.get("final_rowid"))));
			else registro.setFinalRowId(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("id_operacion") != null)
				registro.setIdOperacion((Integer.valueOf(String.valueOf(registroRow.get("id_operacion")))));
			else registro.setIdOperacion(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("id_sistema") != null)
				registro.setSistema((String.valueOf(registroRow.get("id_sistema"))));
			else registro.setSistema(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("id_software") != null)
				registro.setSoftware((Integer.valueOf(String.valueOf(registroRow.get("id_software")))));
			else registro.setSoftware(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("de_bloque") != null)
				registro.setDescripcionBloque((String.valueOf(registroRow.get("de_bloque"))));
			else registro.setDescripcionBloque(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("id_job") != null)
				registro.setIdJob((String.valueOf(registroRow.get("id_job"))));
			else registro.setIdJob(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("de_escenario") != null)
				registro.setDescripcionEscenario((String.valueOf(registroRow.get("de_escenario"))));
			else registro.setDescripcionEscenario(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("id_ejecucion") != null)
				registro.setIdEjecucion((Integer.valueOf(String.valueOf(registroRow.get("id_ejecucion")))));
			else registro.setIdEjecucion(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("id_fecha_inicio") != null)
				registro.setFechaInicio((helper.auxStringToSqlDate(String.valueOf(registroRow.get("id_fecha_inicio")))));
			else registro.setFechaInicio(Environment.DEFAULT_NULL_DATE);
			
			if (registroRow.get("id_fecha_fin") != null)
				registro.setFechaFin((helper.auxStringToSqlDate(String.valueOf(registroRow.get("id_fecha_fin")))));
			else registro.setFechaFin(Environment.DEFAULT_NULL_DATE);
			
			if (registroRow.get("fc_duracion") != null)
				registro.setFcDuracion((Double.valueOf(String.valueOf(registroRow.get("fc_duracion")))));
			else registro.setFcDuracion(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("id_tipo_operacion") != null)
				registro.setTipoDeOperacion((String.valueOf(registroRow.get("id_tipo_operacion"))));
			else registro.setTipoDeOperacion(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("fc_filas_cargadas") != null)
				registro.setFcFilasCargadas((Integer.valueOf(String.valueOf(registroRow.get("fc_filas_cargadas")))));
			else registro.setFcFilasCargadas(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("fc_filas_actualizadas") != null)
				registro.setFcFilasActualizadas((Integer.valueOf(String.valueOf(registroRow.get("fc_filas_actualizadas")))));
			else registro.setFcFilasActualizadas(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("fc_filas_leidas") != null)
				registro.setFcFilasLeidas((Integer.valueOf(String.valueOf(registroRow.get("fc_filas_leidas")))));
			else registro.setFcFilasLeidas(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("fc_filas_rechazadas") != null)
				registro.setFcFilasRechazadas((Integer.valueOf(String.valueOf(registroRow.get("fc_filas_rechazadas")))));
			else registro.setFcFilasRechazadas(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("fc_filas_descartadas") != null)
				registro.setFcFilasDescartadas((Integer.valueOf(String.valueOf(registroRow.get("fc_filas_descartadas")))));
			else registro.setFcFilasDescartadas(Environment.DEFAULT_NULL_INT);
			
			if (registroRow.get("de_software") != null)
				registro.setDescripcionSoftware((String.valueOf(registroRow.get("de_software"))));
			else registro.setDescripcionSoftware(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("de_operacion") != null)
				registro.setDescripcionOperacion((String.valueOf(registroRow.get("de_operacion"))));
			else registro.setDescripcionOperacion(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("id_estado") != null)
				registro.setEstado((String.valueOf(registroRow.get("id_estado"))));
			else registro.setEstado(Environment.DEFAULT_NULL_STRING);
			
			if (registroRow.get("fecha") != null)
				registro.setFechaDatos((String.valueOf(registroRow.get("fecha"))));
			else registro.setFechaDatos(Environment.DEFAULT_NULL_STRING);
			
			System.out.println("[getAll] -> " + registro.toString());
			registroList.add(registro);
		}
		
		return registroList;
	}

	
}
