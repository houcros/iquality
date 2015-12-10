package com.indra.iquality.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.indra.iquality.dao.DependenciaDeJobDAO;
import com.indra.iquality.dao.DescripcionAtributoDAO;
import com.indra.iquality.dao.DescripcionAtributoMaestroDAO;
import com.indra.iquality.dao.DescripcionIndicadorDAO;
import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.dao.TrazaDeRegistroDAO;
import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.model.Dependencia;
import com.indra.iquality.model.DescripcionAtributo;
import com.indra.iquality.model.DescripcionComponente;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.model.TrazaDeRegistro;
import com.indra.iquality.translator.ConceptsToTreeTranslator;
import com.indra.iquality.translator.TreeToJSONTranslator;
import com.indra.iquality.tree.GenericTreeNode;

@Controller
@RequestMapping("/api")
public class APIController {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(APIController.class);

	private static final String DICTIONARY_CACHE_FILE = System.getProperty("user.home") + File.separator + ".resultadoQueryDiccionario.txt"; 
	private static final String DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE = System.getProperty("user.home") + File.separator + ".jsonTree_para_jsTree.json";
	
	@RequestMapping(value = "/jsonTree-para-jsTree", method = RequestMethod.GET)
	private @ResponseBody JSONObject getJSONTreeParajsTree() {

		///////////////////////////////////////////////////////////////////////////////////////
		// Opción 1 para leer el fichero json a un JSONObject
		// Creo que es más lenta que la opción 2 porque parsea el json
		JSONParser parser = new JSONParser();
		JSONObject jsonTree = new JSONObject();
		try {
			jsonTree = (JSONObject) parser.parse(new FileReader(DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE));
		} catch (FileNotFoundException e) {
			logger.error("[getJSONTreeParajsTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		} catch (IOException e) {
			logger.error("[getJSONTreeParajsTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		} catch (ParseException e) {
			logger.error("[getJSONTreeParajsTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		}
		
		logger.info("[getJSONTree] -> DONE");
		
		return jsonTree;
	}
	
	@RequestMapping(value = "/traza-de-operacion/{idOperacion}", method = RequestMethod.GET)
	private @ResponseBody JSONArray getTrazaDeOperacion(@PathVariable int idOperacion, ModelMap model) {
		
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the trazaDeRegistroDAO Bean
		//To use JdbcTemplate
		TrazaDeRegistroDAO trazaDeRegistroDAO = ctx.getBean("trazaDeRegistroDAOJDBCTemplate", TrazaDeRegistroDAO.class);
		
		//Read trazas
		List<TrazaDeRegistro> allTrazaDeRegistro = null;
		
		try {
			allTrazaDeRegistro = trazaDeRegistroDAO.getAll(idOperacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		
		// TODO Quizás esto lo puedo encapsular luego en otro método auxiliar privado o en el helper
		// O en el translator (?)
		
//		JsonElement element = new Gson().toJsonTree(allTrazaDeRegistro, new TypeToken<List<TrazaDeRegistro>>() {}.getType());
//		JsonArray jsonArray = element.getAsJsonArray();
		
		JSONArray jsonArray = new JSONArray();
		for (TrazaDeRegistro trazaDeRegistro : allTrazaDeRegistro){
		
			logger.debug("[getTrazaDeOperacion] -> " + trazaDeRegistro.toString());			
			jsonArray.add(trazaDeRegistro);
			
		}
		
		logger.info("[getTrazaDeOperacion] -> DONE");
		return jsonArray;
	}
	
	@RequestMapping(value = "/pases/{idEjecucion}/jobs/{idJob}/dependencias", method = RequestMethod.GET)
	private @ResponseBody JSONArray getDependenciasDeJob(@PathVariable int idEjecucion, @PathVariable String idJob, ModelMap model) {
		
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		
		//Get the trazaDeRegistroDAO Bean
		//To use JdbcTemplate
		DependenciaDeJobDAO dependenciaDeJobDAO = ctx.getBean("dependenciaDeJobDAOJDBCTemplate", DependenciaDeJobDAO.class);
		
		//Read trazas
		List<Dependencia> allDependencias = null;
		
		try {
			allDependencias = dependenciaDeJobDAO.getAll(idEjecucion, idJob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		
		// TODO Quizás esto lo puedo encapsular luego en otro método auxiliar privado o en el helper
		// O en el translator (?)
		
		JSONArray jsonArray = new JSONArray();
		for (Dependencia dependencia : allDependencias){
		
			logger.debug("[getDependenciasDeJob] -> " + dependencia.getIdPase() + " | " + dependencia.getEstado());			
			jsonArray.add(dependencia);
			
		}
		
		logger.info("[getDependenciasDeJob] -> DONE");
		return jsonArray;
	}
	
	@RequestMapping(value = "/updateDictionaryCache", method = RequestMethod.GET)
	private String updateDictionaryCache(ModelMap model) {
		
		new Thread(new Runnable(){
			public void run(){
				auxiliaryUpdateDictionaryCache();
			}
		}, "updateDictCacheThread").start();

		return "redirect:/";
	}
	
	private boolean auxiliaryUpdateDictionaryCache(){

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		//Get the dictionaryOfConceptsDAO Bean
		//To use JdbcTemplate
		DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate", DictionaryOfConceptsDAO.class);

		//Read
		List<GenericTreeNode<DictionaryConcept>> allDictionaryConceptNodes = new ArrayList<GenericTreeNode<DictionaryConcept>>();
		
		///////////////////////////////////////////////////////////////////////////////////////
		// QUERY de todos los nodos
		try {
			allDictionaryConceptNodes = dictionaryOfConceptsDAO.getAll();
			//			model.addAttribute("allTableItems", allDictionaryConceptsNodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// IMPORTANTE
		// Sólo saco los 3 primeros porque no van en el árbol
		// TODO Sería aún mejor si la query no me los devuelve, para empezar, y lo mato de raíz
		allDictionaryConceptNodes.remove(0);
		allDictionaryConceptNodes.remove(0);
		allDictionaryConceptNodes.remove(0);

		// Si quiero guardo el resultado de la query en un fichero de texto
		//auxiliaryWriteQueryResultToTextFile(allDictionaryConceptNodes, DICTIONARY_CACHE_FILE);
		
		// Traduzco las filas de la query a un tree a partir de los nodos de la query
		ConceptsToTreeTranslator translator = new ConceptsToTreeTranslator();
		GenericTreeNode<DictionaryConcept> dictionaryTree = new GenericTreeNode<DictionaryConcept>();

		try {
			dictionaryTree = translator.createTreeFromConceptList(allDictionaryConceptNodes);
			logger.info("[auxiliaryUpdateDictionaryCache] : Generado tree a partir de fichero de texto.");
			//					tree.myPrintTree(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("[auxiliaryUpdateDictionaryCache] : Excepción en BaseController.getJSONTree al intentar crear el árbol.");
			e.printStackTrace();
		}

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Traduzco el tree JSON
		// TODO Investigar, por alguna razón si el JSON no es pretty no funciona, curioso
		TreeToJSONTranslator jsonTranslator = new TreeToJSONTranslator();
		String jsonTree = jsonTranslator.createPrettyJSONStringFromTreeForjsTree(dictionaryTree);

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Y guardo el JSON en un fichero caché
		File jsonTreeFile = new File(DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE);
		try {
			Files.write(jsonTree, jsonTreeFile, Charset.forName("UTF-8"));
			logger.info("[diccionario-2] : Succesfully wrote to file " + DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE);
			//										System.out.println(prettyJsonString);
		} catch (IOException e) {
			System.out.println("ERROR al intentar escribir en " + DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE + "\n" + e.getMessage());
		}


		///////////////////////////////////////////////////////////////////////////////////////
		//Close Spring Context
		ctx.close();

		logger.info("[auxiliaryUpdateDictionaryCache] -> DONE");
		return true;

	}

	
	private boolean auxiliaryWriteQueryResultToTextFile(List<GenericTreeNode<DictionaryConcept>> conceptNodes, String sourcePath){

		String conceptsForFile = new String();
		for (GenericTreeNode<DictionaryConcept> dictionaryConceptNode : conceptNodes) {
			conceptsForFile += dictionaryConceptNode.getData().getCompRowID() + "&"
					+ dictionaryConceptNode.getData().getCtRowID() + "&" 
					+ dictionaryConceptNode.getData().getLevel() + "&"
					+ dictionaryConceptNode.getData().getStatus() + "&"
					+ dictionaryConceptNode.getData().getTipo() + "&"
					+ dictionaryConceptNode.getData().getConcept() + "\n";
		}

		// Guardo las filas de la query en un fichero
		File destination = new File(sourcePath);
		logger.info("[auxiliaryUpdateDictionaryCache] : destination path -> " + destination.getAbsolutePath());
		try {
			Files.write(conceptsForFile, destination, Charset.forName("UTF-8"));
			logger.info("[auxiliaryUpdateDictionaryCache] : Succesfully wrote to file " + destination.getAbsolutePath());
		} catch (IOException e) {
			// Useful error handling here
			logger.error("[auxiliaryUpdateDictionaryCache] : Error on writting to file " + destination.getAbsolutePath());
		}

		return true;
	}
	
	@RequestMapping(value = "/descripcionComponente/{type}/{idComponente}", method = RequestMethod.GET)
	private @ResponseBody JSONObject getDescripcionDeComponente(@PathVariable String type, @PathVariable String idComponente){

		logger.info(("[getDescripcionDeComponente] : called route"));
		String[] s = idComponente.split("&");
		String compRowID = s[0].split(":")[1];
		String ctRowID = s[1].split(":")[1];

		//		logger.info("id: " + idConcepto);
		//		logger.info("compRowID: " + compRowID + ", ctRowID: " + ctRowID);

		if(type.equalsIgnoreCase((ConceptTypeEnum.ATRIBUTO).toString()) || type.equalsIgnoreCase((ConceptTypeEnum.LITERAL).toString())){

			logger.info(("[getDescripcionDeComponente] : Procesando un " + type));
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DescripcionAtributoDAO descripcionAtributoDAO = ctx.getBean("descripcionAtributoDAOJDBCTemplate", DescripcionAtributoDAO.class);
			DescripcionAtributo da = descripcionAtributoDAO.getById(compRowID, ctRowID);
			ctx.close();

			// Todo esto para pasar de objeto a JSONObject
			// No hace falta, puedo devolver el objeto directamente y me lo traduce

			logger.info(("[getDescripcionDeComponente] : Ready to parse " + type + " to a JSONObject."));
			String jsonString = new Gson().toJson(da);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionAtributo = new JSONObject();
			try {
				jsonDescripcionAtributo = (JSONObject) parser.parse(jsonString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info(jsonDescripcionAtributo.toString());
			return jsonDescripcionAtributo;
		}

		else if(type.equalsIgnoreCase((ConceptTypeEnum.ATRIBUTO_MAESTRO).toString())){
			
			logger.info(("[getDescripcionDeComponente] : Procesando un " + type));

			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DescripcionAtributoMaestroDAO descripcionAtributoMaestroDAO = ctx.getBean("descripcionAtributoMaestroDAOJDBCTemplate", DescripcionAtributoMaestroDAO.class);
			DescripcionAtributo da = descripcionAtributoMaestroDAO.getById(compRowID, ctRowID);
			ctx.close();

			// Todo esto para pasar de objeto a JSONObject
			// No hace falta, puedo devolver el objeto directamente y me lo traduce

			logger.info(("[getDescripcionDeComponente] : Ready to parse " + type + " to a JSONObject."));
			String jsonString = new Gson().toJson(da);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionAtributo = new JSONObject();
			try {
				jsonDescripcionAtributo = (JSONObject) parser.parse(jsonString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info(jsonDescripcionAtributo.toString());
			return jsonDescripcionAtributo;
		}

		else if (type.equalsIgnoreCase((ConceptTypeEnum.INDICADOR).toString())){
			
			logger.info(("[getDescripcionDeComponente] : Procesando un " + type));
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DescripcionIndicadorDAO descripcionIndicadorDAO = ctx.getBean("descripcionIndicadorDAOJDBCTemplate", DescripcionIndicadorDAO.class);
			DescripcionIndicador di = descripcionIndicadorDAO.getById(compRowID, ctRowID);
			ctx.close();

			// Todo esto para pasar de objeto a JSONObject
			// No hace falta, puedo devolver el objeto directamente y me lo traduce

			logger.info(("[getDescripcionDeComponente] : Ready to parse " + type + " to a JSONObject."));
			String jsonString = new Gson().toJson(di);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionIndicador = new JSONObject();
			try {
				jsonDescripcionIndicador = (JSONObject) parser.parse(jsonString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}

			logger.info(jsonDescripcionIndicador.toString());
			return jsonDescripcionIndicador;
		}

		else{
			String jsonString = "{\"error\" : \"Este componente no es ni un literal, ni un atributo ni un indicador.\"}";
			JSONObject mssg = new JSONObject();
			try {
				mssg = (JSONObject) new JSONParser().parse(jsonString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mssg;
		}

	}

}
