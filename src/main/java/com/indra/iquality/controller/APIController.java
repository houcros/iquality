/*
 * 
 */
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.indra.iquality.dao.DependencyDAO;
import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.dao.TraceOfRegisterDAO;
import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.model.Dependency;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.model.DescriptionOfAttribute;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.model.RegisterTrace;
import com.indra.iquality.singleton.Environment;
import com.indra.iquality.translator.ConceptsToTreeTranslator;
import com.indra.iquality.translator.TreeToJSONTranslator;
import com.indra.iquality.tree.GenericTreeNode;

// TODO: Auto-generated Javadoc
/**
 * The Class APIController.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class APIController.
 */
@Controller
@RequestMapping("/api")
public class APIController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(APIController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	/**
	 * The Constant representing the path where to save the verbose (extra)
	 * cache file.
	 */
	private static final String DICTIONARY_CACHE_FILE = System.getProperty("user.home") + File.separator
			+ ".resultadoQueryDiccionario.txt";

	/**
	 * The Constant representing the path where to save the necessary cache
	 * file.
	 */
	private static final String DICTIONARY_JSON_CACHE_FILE = System.getProperty("user.home") + File.separator
			+ ".jsonTree_para_jsTree.json";

	/**
	 * Sets the level of the cache to verbose or not. In verbose mode an extra
	 * cache file is saved, with the result of the query where the rows are
	 * saved as lines in the file.
	 */
	private static boolean VERBOSE_CACHE = true;

	/**
	 * Gets the JSON representation of the tree corresponding to the dictionary
	 * of concepts. The JSON is read from a cache file located at
	 * {@link #DICTIONARY_JSON_CACHE_FILE}. The format of the JSON is that
	 * expected by the <a href="https://www.jstree.com/">jsTree</a> plug-in for
	 * jQuery.
	 *
	 * @return the representation of the dictionary as JSON
	 */
	@RequestMapping(value = "/jsonTree-para-jsTree", method = RequestMethod.GET)
	private @ResponseBody JSONObject getDictionaryAsJSONTree() {

		logger.info("[getDictionaryAsJSONTree] : INIT");

		// Si no existe el fichero actualizo la cache para crearlo
		// Estamos suponiendo que no habrá un directorio con el mismo nombre
		if (!(new File(DICTIONARY_JSON_CACHE_FILE)).exists()) {
			logger.info(
					"[getDictionaryAsJSONTree] : Actualizando el diccionario porque el fichero de caché no existe.");
			auxiliaryUpdateDictionaryCache();
		}

		// Leo el fichero que guarda el árbol del diccionario de conceptos y lo
		// parseo a un JSON
		JSONParser parser = new JSONParser();
		JSONObject jsonTree = new JSONObject();
		try {
			jsonTree = (JSONObject) parser.parse(new FileReader(DICTIONARY_JSON_CACHE_FILE));
			logger.debug("[getDictionaryAsJSONTree] : Obtenido el diccionario de conceptos");
		} catch (FileNotFoundException e) {
			logger.error("[getDictionaryAsJSONTree] : No existe el fichero de caché <{}> | Ayuda: {}  \n {}",
					e.getClass(), e.getMessage(), e.getStackTrace());
			return (JSONObject) (new JSONObject()).put("error", "/iQuality/server-error");
		} catch (IOException e) {
			logger.error("[getDictionaryAsJSONTree] : Error al leer del fichero de caché <{}> | Ayuda: {}  \n {}",
					e.getClass(), e.getMessage(), e.getStackTrace());
			return (JSONObject) (new JSONObject()).put("error", "/iQuality/server-error");
		} catch (ParseException e) {
			logger.error(
					"[getDictionaryAsJSONTree] : Error al parsear el JSON del fichero de caché <{}> | Ayuda: {}  \n {}",
					e.getClass(), e.getMessage(), e.getStackTrace());
			return (JSONObject) (new JSONObject()).put("error", "/iQuality/server-error");
		}

		logger.info("[getDictionaryAsJSONTree] : RETURN");
		return jsonTree;
	}

	/**
	 * Gets the JSONArray representation of the operation trace of an operation.
	 *
	 * @param idOperacion
	 *            the identifier of the operation
	 * @return the operation trace as a JSONArray
	 */
	@RequestMapping(value = "/traza-de-operacion/{idOperacion}", method = RequestMethod.GET)
	private @ResponseBody JSONArray getOperationTrace(@PathVariable int idOperacion) {

		logger.info("[getOperationTrace] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TraceOfRegisterDAO trazaDeRegistroDAO = ctx.getBean("trazaDeRegistroDAOJDBCTemplate", TraceOfRegisterDAO.class);
		ctx.close();

		// Obtengo todas las trazas
		List<RegisterTrace> allTrazaDeRegistro = null;
		try {
			allTrazaDeRegistro = trazaDeRegistroDAO.getAll(idOperacion);
			logger.debug("[getOperationTrace] : Obtenidas todas las trazas");
		} catch (Exception e) {
			logger.error("[getOperationTrace] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
		}

		// Parseo las trazas a un JSONArray
		JSONArray jsonArray = new JSONArray();
		for (RegisterTrace trazaDeRegistro : allTrazaDeRegistro) {
			logger.debug("[getOperationTrace] : Parseando traza " + trazaDeRegistro.toString());
			jsonArray.add(trazaDeRegistro);
		}

		logger.info("[getOperationTrace] : RETURN");
		return jsonArray;
	}

	/**
	 * Gets the dependencies of a given job represented as a JSONArray.
	 *
	 * @param idEjecucion
	 *            the identifier of the execution where the job takes part
	 * @param idJob
	 *            the identifier of the job
	 * @return the dependencies of the given job
	 */
	@RequestMapping(value = "/pases/{idEjecucion}/jobs/{idJob}/dependencias", method = RequestMethod.GET)
	private @ResponseBody JSONArray getJobDependencies(@PathVariable int idEjecucion, @PathVariable String idJob) {

		logger.info("[getJobDependencies] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DependencyDAO dependenciaDeJobDAO = ctx.getBean("dependencyDAOJDBCTemplate", DependencyDAO.class);
		ctx.close();

		// Obtengo todas las dependencias
		List<Dependency> allDependencias = null;
		try {
			allDependencias = dependenciaDeJobDAO.getAll(idEjecucion, idJob, environment.getIdSistema(),
					environment.getIdSoftware());
			logger.debug("[getJobDependencies] : Obtenidas todas las dependencias del job {} para la ejecuión {}",
					idJob, idEjecucion);
		} catch (Exception e) {
			logger.error("[getJobDependencies] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
		}

		// Parseo las dependencias a un JSONArray
		JSONArray jsonArray = new JSONArray();
		for (Dependency dependencia : allDependencias) {
			logger.debug("[getJobDependencies] : Parseando dependencia " + dependencia.toString());
			jsonArray.add(dependencia);
		}

		logger.info("[getJobDependencies] : RETURN");
		return jsonArray;
	}

	/**
	 * Updates the cache representation of the dictionary. Should be called each
	 * time a change is done in the representation of the dictionary. Relies
	 * heavily on {@link #auxiliaryUpdateDictionaryCache}. When the verbose
	 * level is set and the cache gets updated, also updates the verbose cache
	 * by calling {@link #auxiliaryWriteQueryResultToTextFile}
	 *
	 * @return a redirection to the main page
	 */
	@RequestMapping(value = "/updateDictionaryCache", method = RequestMethod.GET)
	private String updateDictionaryCache() {

		logger.info("[updateDictionaryCache] : INIT");

		// Es una operación costosa así que mejor en otro thread
		// TODO Loggear cuando el thread termine
		new Thread(new Runnable() {
			@Override
			public void run() {
				auxiliaryUpdateDictionaryCache();
			}
		}, "updateDictCacheThread").start();

		logger.info("[updateDictionaryCache] : RETURN");
		return "redirect:/";
	}

	/**
	 * Auxiliary method to handle the actual update dictionary cache. Used by
	 * {@link #updateDictionaryCache}
	 *
	 * @return true, if successful
	 */
	private boolean auxiliaryUpdateDictionaryCache() {

		logger.info("[auxiliaryUpdateDictionaryCache] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate",
				DictionaryOfConceptsDAO.class);
		ctx.close();

		// Leo todos los nodos del diccionario
		List<GenericTreeNode<DictionaryConcept>> allDictionaryConceptNodes = new ArrayList<GenericTreeNode<DictionaryConcept>>();
		try {
			allDictionaryConceptNodes = dictionaryOfConceptsDAO.getAllConcepts(environment.getIdSistema(),
					environment.getIdSoftware());
			logger.debug("[auxiliaryUpdateDictionaryCache] : Obtenidos todos los nodos del diccionario.");
		} catch (Exception e) {
			logger.error("[auxiliaryUpdateDictionaryCache] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage(), e.getStackTrace());
			return false;
		}

		// ATENCIÓN: Sólo saco los 3 primeros porque la query los devuelve pero
		// no van en el árbol
		// TODO Probablemente sería mejor si la query no contiene estos tres
		// elementos
		allDictionaryConceptNodes.remove(0);
		allDictionaryConceptNodes.remove(0);
		allDictionaryConceptNodes.remove(0);

		// Si tengo un nivel verbose de cache, también guardo en un fichero de
		// texto el resultado de la query
		if (VERBOSE_CACHE)
			auxiliaryWriteQueryResultToTextFile(allDictionaryConceptNodes, DICTIONARY_CACHE_FILE);

		// Traduzco las filas de la query a un tree a partir de los nodos
		ConceptsToTreeTranslator translator = new ConceptsToTreeTranslator();
		GenericTreeNode<DictionaryConcept> dictionaryTree = new GenericTreeNode<DictionaryConcept>();
		try {
			dictionaryTree = translator.createTreeFromConceptList(allDictionaryConceptNodes);
			logger.debug("[auxiliaryUpdateDictionaryCache] : Generado tree a partir de fichero de los nodos.");
		} catch (Exception e) {
			logger.error("[auxiliaryUpdateDictionaryCache] : Error al intentar crear el árbol <{}> | Ayuda: {}  \n {}",
					e.getClass(), e.getMessage(), e.getStackTrace());
			return false;
		}

		// Ahora traduzco el tree a un JSON
		// ATENCIÓN: Por alguna razón esto no funciona si el JSON no es "pretty"
		TreeToJSONTranslator jsonTranslator = new TreeToJSONTranslator();
		String jsonTree = jsonTranslator.createPrettyJSONStringFromTreeForjsTree(dictionaryTree);

		// Y guardo el JSON en un fichero caché
		try {
			File jsonTreeFile = new File(DICTIONARY_JSON_CACHE_FILE);
			Files.write(jsonTree, jsonTreeFile, Charset.forName("UTF-8"));
			logger.info("[auxiliaryUpdateDictionaryCache] : Guardado JSON del árbol del diccionario en la caché.");
		} catch (IOException e) {
			logger.error(
					"[auxiliaryUpdateDictionaryCache] : Error al escribir en el fichero de caché <{}> | Ayuda: {}  \n {}",
					e.getClass(), e.getMessage(), e.getStackTrace());
			return false;
		} catch (Exception e) {
			logger.error("[auxiliaryUpdateDictionaryCache] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage(), e.getStackTrace());
			return false;
		}

		logger.info("[auxiliaryUpdateDictionaryCache] : RETURN");
		return true;

	}

	/**
	 * Updates the verbose cache, where each line of the file represented by
	 * sourcePath contains a record of the query.
	 *
	 * @param conceptNodes
	 *            the node representation of the nodes to store
	 * @param sourcePath
	 *            the path where to store the verbose cache
	 * @return true, if successful
	 */
	private boolean auxiliaryWriteQueryResultToTextFile(List<GenericTreeNode<DictionaryConcept>> conceptNodes,
			String sourcePath) {

		logger.info("[auxiliaryWriteQueryResultToTextFile] : INIT");

		// Parseo los nodos a un String enorme como filas
		String conceptsForFile = new String();
		for (GenericTreeNode<DictionaryConcept> dictionaryConceptNode : conceptNodes) {
			conceptsForFile += dictionaryConceptNode.getData().getCompRowID() + "&"
					+ dictionaryConceptNode.getData().getCtRowID() + "&" + dictionaryConceptNode.getData().getLevel()
					+ "&" + dictionaryConceptNode.getData().getStatus() + "&"
					+ dictionaryConceptNode.getData().getTipo() + "&" + dictionaryConceptNode.getData().getConcept()
					+ "\n";
		}

		// Y guardo el String con los nodos en un fichero
		try {
			File destination = new File(sourcePath);
			Files.write(conceptsForFile, destination, Charset.forName("UTF-8"));
			logger.info(
					"[auxiliaryWriteQueryResultToTextFile] : Guardados nodos del árbol del diccionario en la caché verbose.");
		} catch (IOException e) {
			logger.error("[auxiliaryWriteQueryResultToTextFile] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage(), e.getStackTrace());
			return false;
		}

		logger.info("[auxiliaryWriteQueryResultToTextFile] : RETURN");
		return true;
	}

	/**
	 * Gets the description of a component of the dictionary.
	 *
	 * @param type
	 *            the type of the component
	 * @param idComponente
	 *            the identifier of the component. The following format is
	 *            expected: <b>compRowID:&lt;the row id of the
	 *            component&gt;&amp;ctRowID:&lt;the row id of the ct&gt;</b>
	 * @return the JSON representation of the description of the component
	 */
	@RequestMapping(value = "/descripcionComponente/{type}/{idComponente}", method = RequestMethod.GET)
	private @ResponseBody JSONObject getComponentDescription(@PathVariable String type,
			@PathVariable String idComponente) {

		logger.info("[getComponentDescription] : INIT");

		// Por si hay que devolver un error
		JSONObject jsonError = (JSONObject) (new JSONObject()).put("error", "/iQuality/server-error");

		// Ver el Javadoc para la descripción del formato esperado para el
		// idComponente. Si no se cumple el formato se retorna un error
		String[] s = idComponente.split("&");
		if (s.length != 2) {
			logger.error("[] : El formato de idComponente no es el esperado. Ver Javadoc.");
			return jsonError;
		}
		String compRowID = s[0].split(":")[1];
		String ctRowID = s[1].split(":")[1];
		if (compRowID.equals("") || ctRowID.equals("")) {
			logger.error("[] : El formato de idComponente no es el esperado. Ver Javadoc.");
			return jsonError;
		}

		// Parsear los componentes a JSON
		// Creo que en principio no hace falta, porque la conversión deobjeto a
		// JSON la debería hacer el método automáticamente gracias el
		// ResponseBody
		if (type.equalsIgnoreCase((ConceptTypeEnum.ATRIBUTO).toString())
				|| type.equalsIgnoreCase((ConceptTypeEnum.LITERAL).toString())) {

			logger.debug(("[getComponentDescription] : Procesando un " + type));

			// Abro el contexto para el DAO
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate",
					DictionaryOfConceptsDAO.class);
			ctx.close();
			DescriptionOfAttribute da = dictionaryOfConceptsDAO.getDescriptionOfAttribute(compRowID, ctRowID,
					environment.getIdSistema(), environment.getIdSoftware());

			// Parseo (redundante?)
			String jsonString = new Gson().toJson(da);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionAtributo = new JSONObject();
			try {
				jsonDescripcionAtributo = (JSONObject) parser.parse(jsonString);
				logger.debug(("[getComponentDescription] : Parseado un " + type));
			} catch (ParseException e) {
				logger.error("[auxiliaryWriteQueryResultToTextFile] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
						e.getMessage(), e.getStackTrace());
				return jsonError;
			}

			logger.info("[getComponentDescription] : RETURN");
			return jsonDescripcionAtributo;
		}

		else if (type.equalsIgnoreCase((ConceptTypeEnum.ATRIBUTO_MAESTRO).toString())) {

			logger.debug(("[getComponentDescription] : Procesando un " + type));

			// Abro el contexto para el DAO
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate",
					DictionaryOfConceptsDAO.class);
			ctx.close();
			DescriptionOfAttribute da = dictionaryOfConceptsDAO.getDescriptionOfMasterAttribute(compRowID, ctRowID,
					environment.getIdSistema(), environment.getIdSoftware());

			// Parseo (redundante?)
			String jsonString = new Gson().toJson(da);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionAtributo = new JSONObject();
			try {
				jsonDescripcionAtributo = (JSONObject) parser.parse(jsonString);
				logger.debug(("[getComponentDescription] : Parseado un " + type));
			} catch (ParseException e) {
				logger.error("[auxiliaryWriteQueryResultToTextFile] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
						e.getMessage(), e.getStackTrace());
				return jsonError;
			}

			logger.info("[getComponentDescription] : RETURN");
			return jsonDescripcionAtributo;
		}

		else if (type.equalsIgnoreCase((ConceptTypeEnum.INDICADOR).toString())) {

			logger.info(("[getDescripcionDeComponente] : Procesando un " + type));

			// Abro el contexto para el DAO
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate",
					DictionaryOfConceptsDAO.class);
			ctx.close();
			DescripcionIndicador di = dictionaryOfConceptsDAO.getDescriptionOfIndicator(compRowID, ctRowID,
					environment.getIdSistema(), environment.getIdSoftware());

			// Parseo (redundante?)
			String jsonString = new Gson().toJson(di);
			JSONParser parser = new JSONParser();
			JSONObject jsonDescripcionIndicador = new JSONObject();
			try {
				jsonDescripcionIndicador = (JSONObject) parser.parse(jsonString);
				logger.debug(("[getComponentDescription] : Parseado un " + type));
			} catch (ParseException e) {
				logger.error("[auxiliaryWriteQueryResultToTextFile] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
						e.getMessage(), e.getStackTrace());
				return jsonError;
			}

			logger.info("[getComponentDescription] : RETURN");
			return jsonDescripcionIndicador;
		}

		else {
			logger.error("[getDescripcionDeComponente] : No se reconoce el tipo de componente.");
			return jsonError;
		}

	}

}
