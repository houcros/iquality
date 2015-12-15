package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.TraceOfRegisterDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.RegisterOfOperation;
import com.indra.iquality.model.RegisterTrace;
import com.indra.iquality.singleton.Environment;

public class TraceOfRegisterDAOJDBCTemplateImpl implements TraceOfRegisterDAO{

	private DataSource dataSource;
	private Environment sistema = Environment.getInstance();
	private final CustomHelper helper = new CustomHelper();
	
	// Debugging
//	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
//	private int contadorDebugger = 0;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<RegisterTrace> getAll(int idOperacion) throws Exception {
		
		String query = "SELECT C.ID_FECHA,C.ID_TRAZA, "
						+ "C.ID_ANYO||'-'|| "
						+ "CASE WHEN LENGTH (C.ID_MES)=1 " 
						+ "THEN '0'||C.ID_MES ELSE to_char(C.ID_MES) " 
						+ "END AS FECHA, "
						+ "C.ID_CATEGORIA, "
						+ "C.DE_MENSAJE "
						+ "FROM BS_MET_IQ_OPERACION A, "
						+ "BS_MET_IQ_TRAZA C "
						+ "WHERE " 
						+ "A.ID_OPERACION=C.ID_OPERACION AND "
						+ "A.ID_SISTEMA=C.ID_SISTEMA AND "
						+ "A.ID_SOFTWARE=C.ID_SOFTWARE  AND "
						+ "A.ID_OPERACION = ? AND "
						+ "A.ID_SISTEMA = ? AND "
						+ "A.ID_SOFTWARE = ? ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<RegisterTrace> trazaList = new ArrayList<RegisterTrace>();

		List<Map<String,Object>> trazaRows = jdbcTemplate.queryForList(query, new Object[]{ idOperacion, sistema.getIdSistema(), sistema.getIdSoftware() });
		
		for(Map<String,Object> trazaRow : trazaRows){
			
			RegisterTrace traza = new RegisterTrace();
			
			if (trazaRow.get("id_traza") != null)
				traza.setIdTraza((Integer.valueOf(String.valueOf(trazaRow.get("id_traza")))));
			else traza.setIdTraza(Environment.DEFAULT_NULL_INT);
			
			if (trazaRow.get("id_fecha") != null)
				traza.setIdFecha((helper.auxStringToSqlDate(String.valueOf(trazaRow.get("id_fecha")))));
			else traza.setIdFecha(Environment.DEFAULT_NULL_DATE);
			
			if (trazaRow.get("fecha") != null)
				traza.setFecha((String.valueOf(trazaRow.get("fecha"))));
			else traza.setFecha(Environment.DEFAULT_NULL_STRING);
			
			if (trazaRow.get("id_categoria") != null)
				traza.setCategoria((String.valueOf(trazaRow.get("id_categoria"))));
			else traza.setCategoria(Environment.DEFAULT_NULL_STRING);
			
			if (trazaRow.get("de_mensaje") != null)
				traza.setMensaje((String.valueOf(trazaRow.get("de_mensaje"))));
			else traza.setMensaje(Environment.DEFAULT_NULL_STRING);
			
			trazaList.add(traza);
		}
		
		return trazaList;
	}

	
}
