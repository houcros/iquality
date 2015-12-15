package com.indra.iquality.dao.jdbctemplateimplem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.EnvironmentDAO;

public class EnvironmentDAOJDBCTemplateImpl implements EnvironmentDAO {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Pair<String, String>> getSistemas() {
		
		String query = "select id_sistema, de_sistema" 
				+ " from   LK_MET_IQ_SISTEMA"
				+ " where id_sistema != 'PLA'"
				+ " order by 1";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Pair<String, String>> nombresSistemasList = new ArrayList<Pair<String, String>>();
		
		List<Map<String,Object>> nombresSistemasRows = jdbcTemplate.queryForList(query);
		for (Map<String,Object> nombresSistemasRow : nombresSistemasRows){
			Pair<String, String> p = new MutablePair<String, String>(
					String.valueOf(nombresSistemasRow.get("id_sistema")),
					String.valueOf(nombresSistemasRow.get("de_sistema"))
			);
			nombresSistemasList.add(p);
		}
		
		return nombresSistemasList;
		
	}

}
