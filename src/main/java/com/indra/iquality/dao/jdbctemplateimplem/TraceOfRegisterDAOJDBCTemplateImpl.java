/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.TraceOfRegisterDAO;
import com.indra.iquality.model.RegisterTrace;

/**
 * Implementation of {@link com.indra.iquality.dao.TraceOfRegisterDAO} using
 * JDBC to connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 15-dic-2015
 * 
 *          The Class TraceOfRegisterDAOJDBCTemplateImpl.
 */
public class TraceOfRegisterDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl implements TraceOfRegisterDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TraceOfRegisterDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.TraceOfRegisterDAO#getAll(int,
	 * java.lang.String, int)
	 */
	@Override
	public List<RegisterTrace> getAll(int idOperacion, String sistema, int software) throws Exception {

		logger.info("[getAll] : INIT");

		String query = "SELECT C.ID_FECHA,C.ID_TRAZA, " + "C.ID_ANYO||'-'|| " + "CASE WHEN LENGTH (C.ID_MES)=1 "
				+ "THEN '0'||C.ID_MES ELSE to_char(C.ID_MES) " + "END AS FECHA, " + "C.ID_CATEGORIA, " + "C.DE_MENSAJE "
				+ "FROM BS_MET_IQ_OPERACION A, " + "BS_MET_IQ_TRAZA C " + "WHERE "
				+ "A.ID_OPERACION=C.ID_OPERACION AND " + "A.ID_SISTEMA=C.ID_SISTEMA AND "
				+ "A.ID_SOFTWARE=C.ID_SOFTWARE  AND " + "A.ID_OPERACION = ? AND " + "A.ID_SISTEMA = ? AND "
				+ "A.ID_SOFTWARE = ? ";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<RegisterTrace> trazaList = new ArrayList<RegisterTrace>();
		List<Map<String, Object>> trazaRows = jdbcTemplate.queryForList(query,
				new Object[] { idOperacion, sistema, software });

		// Mapeo
		for (Map<String, Object> trazaRow : trazaRows) {

			RegisterTrace traza = new RegisterTrace();

			traza.setIdTraza(helper.filterStringToInt(String.valueOf(trazaRow.get("id_traza"))));
			traza.setIdFecha((helper.filterStringToSqlDate(String.valueOf(trazaRow.get("id_fecha")))));
			traza.setFecha(helper.filterNullString((String.valueOf(trazaRow.get("fecha")))));
			traza.setCategoria(helper.filterNullString((String.valueOf(trazaRow.get("id_categoria")))));
			traza.setMensaje(helper.filterNullString((String.valueOf(trazaRow.get("de_mensaje")))));

			trazaList.add(traza);
		}

		logger.info("[getAll] : RETURN");
		return trazaList;
	}

}
