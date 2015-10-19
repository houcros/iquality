package com.indra.iquality.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

public class DictionaryOfConceptsDAOJDBCTemplateImpl implements DictionaryOfConceptsDAO{

	private DataSource dataSource;
	// Debugging
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DictionaryOfConceptsDAOJDBCTemplateImpl.class);
	
	private final static String DEFAULT_NULL_STRING = "";
	private final static int DEFAULT_NULL_INT = -1;
		
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<GenericTreeNode<DictionaryConcept>> getAll() throws Exception {

		String query = "WITH CONSULTA "
				+ "AS "
				+ "(select ID_PADRE ,id_hijo,id_tipo,ID_SISTEMA,ID_SOFTWARE,ID_ORDEN,DESCRIPCION "
				+ "from VS_MET_FI_ARBOL_COMP VS "
				+ "), "
				+ "FILTRO as "
				+ "(SELECT DISTINCT ID_HIJO ID_HIJO_FILTRO,ID_SISTEMA,ID_SOFTWARE,ID_ORDEN,ID_TIPO FROM CONSULTA "
				+ "start with ID_TIPO IN ('A','I','L') "
				+ "connect by  NOCYCLE "
				+ "PRIOR ID_PADRE =  ID_HIJO AND "
				+ "prior ID_SOFTWARE =  ID_SOFTWARE AND "
				+ "prior ID_SISTEMA =  ID_SISTEMA ), "
				+ "FILTROHERM as "
				+ "( "
				+ "SELECT ID_HIJO_FILTRO,ID_SISTEMA,ID_SOFTWARE FROM FILTRO "
				+ "UNION "
				+ "SELECT C.ID_HIJO,C.ID_SISTEMA,C.ID_SOFTWARE FROM FILTRO F,VS_MET_FI_ARBOL_COMP C WHERE " 
				+ "F.ID_SOFTWARE=C.ID_SOFTWARE AND F.ID_SISTEMA=C.ID_SISTEMA AND F.ID_HIJO_FILTRO=C.ID_PADRE AND F.ID_TIPO='S' AND F.ID_ORDEN='1' AND C.ID_TIPO='S' AND C.ID_ORDEN<>'1' "
				+ "), "
				+ "ARBOL AS "
				+ "( "
				+ "select " 
				+ "DESCRIPCION as title, "
				+ "null as tooltip, "
				+ "link, VS.ID_PADRE, VS.ID_HIJO, VS.ID_SOFTWARE, VS.ID_SISTEMA, VS.ID_TIPO, VS.ID_ORDEN "
				+ "from VS_MET_FI_ARBOL_COMP VS "
				+ "left join "
				+ "FILTROHERM "
				+ "on (VS.ID_HIJO=FILTROHERM.ID_HIJO_FILTRO AND "
				+ "VS.ID_SOFTWARE=FILTROHERM.ID_SOFTWARE AND "
				+ "VS.ID_SISTEMA=FILTROHERM.ID_SISTEMA) "
				+ "where ((ID_PADRE NOT LIKE '%ODS%' AND VS.ID_HIJO NOT LIKE '%ODS%') OR ID_PADRE IS NULL) AND ID_SN_MAESTRA = 'N' AND DESCRIPCION NOT LIKE '%Otros valores%' " 
				+ "AND DESCRIPCION NOT LIKE '%No informado%' "
				+ ") "
				+ "select case when connect_by_isleaf = 1 then 0 "
				+ "            when level = 1             then 1 "
				+ "            else                           -1 "
				+ "      end as status, "
				+ "       level,  title, VS.ID_TIPO as tipo "
				+ "from arbol VS "
				+ "start with ID_PADRE is null "
				+ "connect by   NOCYCLE "
				+ "VS.ID_PADRE = prior VS.ID_HIJO AND "  
				+ "VS.ID_SOFTWARE =  prior VS.ID_SOFTWARE AND "  
				+ "VS.ID_SISTEMA =  prior VS.ID_SISTEMA "
				+ "ORDER SIBLINGS BY  ID_ORDEN ASC, ID_TIPO ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<GenericTreeNode<DictionaryConcept>> dictionaryConceptList = new ArrayList<GenericTreeNode<DictionaryConcept>>();

		List<Map<String,Object>> dictionaryConceptNodeRows = jdbcTemplate.queryForList(query, new Object[]{});
		
		for(Map<String,Object> dictionaryConceptNodeRow : dictionaryConceptNodeRows){
			
//			++contadorDebugger;
			
			DictionaryConcept dictionaryConcept = new DictionaryConcept();
			
			/*
			 * En principio no harían falta estas comprobaciones porque no tiene sentido
			 * que hayan NULLs en la consulta a los conceptos del diccionario.
			 * Si obtenemos NULLs probablemente sea porque hay algo mal en la query.
			 */
			
			if (dictionaryConceptNodeRow.get("status") != null)
				dictionaryConcept.setStatus((Integer.valueOf(String.valueOf(dictionaryConceptNodeRow.get("status")))));
			else dictionaryConcept.setStatus(DEFAULT_NULL_INT);
			
			if (dictionaryConceptNodeRow.get("level") != null)
				dictionaryConcept.setLevel((Integer.valueOf(String.valueOf(dictionaryConceptNodeRow.get("level")))));
			else dictionaryConcept.setLevel(DEFAULT_NULL_INT);
			
			if (dictionaryConceptNodeRow.get("title") != null)
				dictionaryConcept.setConcept((String.valueOf(dictionaryConceptNodeRow.get("title"))));
			else dictionaryConcept.setConcept(DEFAULT_NULL_STRING);
			
			if (dictionaryConceptNodeRow.get("tipo") != null)
				dictionaryConcept.setTipo((String.valueOf(dictionaryConceptNodeRow.get("tipo"))));
			else dictionaryConcept.setTipo(DEFAULT_NULL_STRING);
			
			logger.info("[dictionaryConcept] -> " + dictionaryConcept);
			
			GenericTreeNode<DictionaryConcept> dictionaryConceptNode = new GenericTreeNode<DictionaryConcept>(dictionaryConcept);
			dictionaryConceptList.add(dictionaryConceptNode);
		}
		
		return dictionaryConceptList;
		
	}

	
}
