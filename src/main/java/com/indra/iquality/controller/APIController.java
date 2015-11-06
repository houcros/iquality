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
import com.indra.iquality.dao.DependenciaDeJobDAO;
import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.dao.TrazaDeRegistroDAO;
import com.indra.iquality.model.DependenciaDeJob;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.model.TrazaDeRegistro;
import com.indra.iquality.translator.ConceptsToTreeTranslator;
import com.indra.iquality.translator.TreeToJSONTranslator;
import com.indra.iquality.tree.GenericTreeNode;

@Controller
@RequestMapping("/api")
public class APIController {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(APIController.class);

	// TODO Hacer los paths relativos al root del servlet para que funcionen en cualquier máquina
	private static final String DICTIONARY_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/resultadoQueryDiccionario.txt";
	private static final String DICTIONARY_JSON_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree.json";
	private static final String DICTIONARY_JSON_CACHE_FILE_FOR_JSTREE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree_para_jsTree.json";

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
}
