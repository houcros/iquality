package com.indra.iquality.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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

import com.indra.iquality.dao.DependenciaDeJobDAO;
import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.dao.EmployeeDAO;
import com.indra.iquality.dao.JobDAO;
import com.indra.iquality.model.DependenciaDeJob;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.model.Employee;
import com.indra.iquality.model.Job;
import com.indra.iquality.dao.LK_MET_PLA_CTRL_PASEDAO;
import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE;
import com.indra.iquality.dao.LK_MET_PLA_CTRL_PASE_JOBDAO;
import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.dao.RegistroDeOperacionDAO;
import com.indra.iquality.dao.TrazaDeRegistroDAO;
import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE_JOB;
import com.indra.iquality.model.Pase;
import com.indra.iquality.model.RegistroDeOperacion;
import com.indra.iquality.model.TrazaDeRegistro;
import com.indra.iquality.singleton.Sistema;
import com.indra.iquality.translator.ConceptsToTreeTranslator;
import com.indra.iquality.translator.TreeToJSONTranslator;
import com.indra.iquality.tree.GenericTreeNode;
import com.google.common.base.Charsets;
import com.google.common.base.Utf8;
import com.google.common.io.Files;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
//TODO @RequestMapping("/algun/path/que/englobe/varios")
public class BaseController {

//	private Sistema sistema = Sistema.getInstance();
	
	/*
	 * Esto puede ser útil en algún momento
	 *      <p>The context path is: ${pageContext.request.contextPath}.</p>
            <p>The context path is: ${pageContext.servletContext.contextPath}.</p>
	 */
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_DICCIONARIO = "diccionario";
	
	
	// TODO Hacer los paths relativos al root del servlet para que funcionen en cualquier máquina
	private static final String DICTIONARY_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/resultadoQueryDiccionario.txt";
	private static final String DICTIONARY_JSON_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree.json";
	private static final String DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree_para_jsTree.json";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		logger.debug("[index] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.debug("[login] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/api/jsonTree", method = RequestMethod.GET)
	// Descomentar para la opción 1
	public @ResponseBody JSONObject getJSONTree() {
	// Descomentar para la opción 3
//	public @ResponseBody String getJSONTree() {
		
		// Si la cache no es válida la actualizo
//		if(!VALID_DICTIONARY_CACHE){
//			auxiliaryUpdateDictionaryCache();
//			VALID_DICTIONARY_CACHE = true;
//		}
			
		///////////////////////////////////////////////////////////////////////////////////////
		// Opción 1 para leer el fichero json a un JSONObject
		// Creo que es más lenta que la opción 2 porque parsea el json
		JSONParser parser = new JSONParser();
		JSONObject jsonTree = new JSONObject();
		try {
			jsonTree = (JSONObject) parser.parse(new FileReader(DICTIONARY_JSON_CACHE_FILE));
		} catch (FileNotFoundException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + "FileNotFoundException, " + e.getCause() + ": " + e.getMessage());
		} catch (IOException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + "IOException, " + e.getCause() + ": " + e.getMessage());
		} catch (ParseException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + "ParseException, " + e.getCause() + ": " + e.getMessage());
		}
		
		logger.info("[getJSONTree] -> DONE");
		
		// Descomentar para la opción 1
		return jsonTree;
		// Descomentar para la opción 3
//		return jsonTreeString;
	}
	
	@RequestMapping(value = "/api/jsonTree-para-jsTree", method = RequestMethod.GET)
	public @ResponseBody JSONObject getJSONTreeParajsTree() {

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
		
		// Descomentar para la opción 1
		return jsonTree;
		// Descomentar para la opción 3
//		return jsonTreeString;
	}
	
	@RequestMapping(value = "/api/updateDictionaryCache", method = RequestMethod.GET)
	public String updateDictionaryCache(ModelMap model) {
		
		new Thread(new Runnable(){
			public void run(){
				auxiliaryUpdateDictionaryCache();
			}
		}, "updateDictCacheThread").start();

		return "redirect:/index";
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

		///////////////////////////////////////////////////////////////////////////////////////
		// Escribo el resultado de la query en un fichero
		// Esto será la caché más adelante
		// TODO Crear el fichero sólo si no existe y la caché está al día
		// TODO Quizás (?) sería mejor guardar un .json en vez de un .txt (mejor estructura)
		// Pero para eso tendría que crear otro método del translator que sea createTreeFromJSONFile
		// en vez del que uso ahora (createTreeFromTxtFile)
		String conceptsForFile = new String();
		for (GenericTreeNode<DictionaryConcept> dictionaryConceptNode : allDictionaryConceptNodes) {
			conceptsForFile += dictionaryConceptNode.getData().getLevel() + " "
					+ dictionaryConceptNode.getData().getStatus() + " " + dictionaryConceptNode.getData().getTipo()
					+ " " + dictionaryConceptNode.getData().getConcept() + "\n";
		}

		// Guardo las filas de la query en un fichero
		// TODO Path harcodeado, sería mejor parametrizado
		File destination = new File(DICTIONARY_CACHE_FILE);
		logger.info("[auxiliaryUpdateDictionaryCache] : destination path -> " + destination.getAbsolutePath());
		try {
			Files.write(conceptsForFile, destination, Charset.forName("UTF-8"));
			logger.info("[auxiliaryUpdateDictionaryCache] : Succesfully wrote to file " + DICTIONARY_CACHE_FILE);
		} catch (IOException e) {
			// Useful error handling here
		}


		///////////////////////////////////////////////////////////////////////////////////////
		// Traduzco las filas de la query a un tree a partir del fichero que acabo de guardar
		// También se puede hacer directamente desde el array allDictionaryConceptNodes
		ConceptsToTreeTranslator translator = new ConceptsToTreeTranslator();
		GenericTreeNode<DictionaryConcept> dictionaryTree = new GenericTreeNode<DictionaryConcept>();

		try {
			dictionaryTree = translator.createTreeFromTxtFile(DICTIONARY_CACHE_FILE);
			logger.info("[auxiliaryUpdateDictionaryCache] : Generado tree a partir de fichero json.");
			//					tree.myPrintTree(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("[auxiliaryUpdateDictionaryCache] : Excepción en BaseController.getJSONTree al intentar crear el árbol.");
			e.printStackTrace();
		}

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Traduzco el tree JSON
		// NO PRETTY! (se puede si se quiere con jsonTranslator.createPrettyJSONStringFromTree
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
	
	@RequestMapping(value = "/api/traza-de-operacion/{idOperacion}", method = RequestMethod.GET)
	public @ResponseBody JSONArray getTrazaDeOperacion(@PathVariable int idOperacion, ModelMap model) {
		
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
	
	@RequestMapping(value = "api/pases/{idEjecucion}/jobs/{idJob}/dependencias", method = RequestMethod.GET)
	public @ResponseBody JSONArray getDependenciasDeJob(@PathVariable int idEjecucion, @PathVariable String idJob, ModelMap model) {
		
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		
		//Get the trazaDeRegistroDAO Bean
		//To use JdbcTemplate
		DependenciaDeJobDAO dependenciaDeJobDAO = ctx.getBean("dependenciaDeJobDAOJDBCTemplate", DependenciaDeJobDAO.class);
		
		//Read trazas
		List<DependenciaDeJob> allDependencias = null;
		
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
		for (DependenciaDeJob dependencia : allDependencias){
		
			logger.debug("[getDependenciasDeJob] -> " + dependencia.getIdPase() + " | " + dependencia.getEstado());			
			jsonArray.add(dependencia);
			
		}
		
		logger.info("[getDependenciasDeJob] -> DONE");
		return jsonArray;
	}
	
	@RequestMapping(value = "/diccionario", method = RequestMethod.GET)
	public String dict2(ModelMap model){
		logger.debug("[diccionario] : Called route");
		return VIEW_DICCIONARIO;
	}
	
}