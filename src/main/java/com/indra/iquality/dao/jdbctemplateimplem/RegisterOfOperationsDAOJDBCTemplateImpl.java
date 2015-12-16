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

import com.indra.iquality.dao.RegisterOfOperationsDAO;
import com.indra.iquality.model.RegisterOfOperation;

/**
 * Implementation of {@link com.indra.iquality.dao.RegisterOfOperationsDAO}
 * using JDBC to connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class RegisterOfOperationsDAOJDBCTemplateImpl.
 */
public class RegisterOfOperationsDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl
		implements RegisterOfOperationsDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(RegisterOfOperationsDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.RegisterOfOperationsDAO#getAll(int,
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<RegisterOfOperation> getAll(int idEjecucion, String idJob, String sistema, int software)
			throws ParseException {

		logger.info("[getAll] : INIT");

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
				+ "ON (A.ID_OPERACION = C.ID_OPERACION AND " + "A.ID_SISTEMA = C.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = C.ID_SOFTWARE) " + "LEFT JOIN LK_MET_IQ_BLOQUE B " + "ON "
				+ "(A.ID_BLOQUE = B.ID_BLOQUE AND " + "A.ID_SISTEMA = B.ID_SISTEMA) "
				+ "LEFT JOIN LK_MET_IQ_ESCENARIO ESC " + "ON " + "(A.ID_SISTEMA = ESC.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = ESC.ID_SOFTWARE AND " + "A.ID_ESCENARIO = ESC.ID_ESCENARIO) "
				+ "LEFT JOIN LK_MET_IQ_SOFTWARE S " + "ON " + "(A.ID_SISTEMA = S.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE = S.ID_SOFTWARE) " + "WHERE " + "A.ID_EJECUCION = ? AND " + "A.ID_JOB = ? AND "
				+ "A.ID_SISTEMA = ? AND " + "A.ID_SOFTWARE = ? ";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<RegisterOfOperation> registroList = new ArrayList<RegisterOfOperation>();
		List<Map<String, Object>> registrosRows = jdbcTemplate.queryForList(query,
				new Object[] { idEjecucion, idJob, sistema, software });

		// Mapeo a una lista
		for (Map<String, Object> registroRow : registrosRows) {

			RegisterOfOperation registro = new RegisterOfOperation();

			registro.setOpRowId(helper.filterNullString((String.valueOf(registroRow.get("op_rowid")))));
			registro.setFinalRowId(helper.filterNullString((String.valueOf(registroRow.get("final_rowid")))));
			registro.setIdOperacion(helper.filterStringToInt(String.valueOf(registroRow.get("id_operacion"))));
			registro.setSistema(helper.filterNullString((String.valueOf(registroRow.get("id_sistema")))));
			registro.setSoftware(helper.filterStringToInt(String.valueOf(registroRow.get("id_software"))));
			registro.setDescripcionBloque(helper.filterNullString((String.valueOf(registroRow.get("de_bloque")))));
			registro.setIdJob(helper.filterNullString((String.valueOf(registroRow.get("id_job")))));
			registro.setDescripcionEscenario(
					helper.filterNullString((String.valueOf(registroRow.get("de_escenario")))));
			registro.setIdEjecucion(helper.filterStringToInt(String.valueOf(registroRow.get("id_ejecucion"))));
			registro.setFechaInicio(helper.auxStringToSqlDate(String.valueOf(registroRow.get("id_fecha_inicio"))));
			registro.setFechaFin((helper.auxStringToSqlDate(String.valueOf(registroRow.get("id_fecha_fin")))));
			registro.setFcDuracion(helper.filterStringToDouble(String.valueOf(registroRow.get("fc_duracion"))));
			registro.setTipoDeOperacion(
					helper.filterNullString((String.valueOf(registroRow.get("id_tipo_operacion")))));
			registro.setFcFilasCargadas(helper.filterStringToInt(String.valueOf(registroRow.get("fc_filas_cargadas"))));
			registro.setFcFilasActualizadas(
					helper.filterStringToInt(String.valueOf(registroRow.get("fc_filas_actualizadas"))));
			registro.setFcFilasLeidas(helper.filterStringToInt(String.valueOf(registroRow.get("fc_filas_leidas"))));
			registro.setFcFilasRechazadas(
					helper.filterStringToInt(String.valueOf(registroRow.get("fc_filas_rechazadas"))));
			registro.setFcFilasDescartadas(
					helper.filterStringToInt(String.valueOf(registroRow.get("fc_filas_descartadas"))));
			registro.setDescripcionSoftware(helper.filterNullString((String.valueOf(registroRow.get("de_software")))));
			registro.setDescripcionOperacion(
					helper.filterNullString((String.valueOf(registroRow.get("de_operacion")))));
			registro.setEstado(helper.filterNullString((String.valueOf(registroRow.get("id_estado")))));
			registro.setFechaDatos(helper.filterNullString((String.valueOf(registroRow.get("fecha")))));

			registroList.add(registro);
		}

		logger.info("[getAll] : RETURN");
		return registroList;
	}

}
