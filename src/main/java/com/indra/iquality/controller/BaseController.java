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
	private static final String VIEW_MY_INDEX = "my_index";
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_NOT_FOUND = "404";
	private static final String VIEW_DICCIONARIO = "diccionario";
	private static final String VIEW_CONSOLACONTROLEJECUCION = "consola_control_ejecucion";
	private static final String VIEW_JOBS_DE_PASE = "jobs";
	private static final String VIEW_REGISTRO_DE_JOB = "registro-de-operaciones";
	
	private static final String VIEW_LK_MET_PLA_CTRL_PASE = "show_lk_met_pla_ctrl_pase";
	private static final String VIEW_LK_MET_PLA_CTRL_PASE_JOB = "show_lk_met_pla_ctrl_pase_job";
	
	// TODO Hacer os paths relativos al root del servlet para que funcionen en cualquier máquina
	private static final String DICTIONARY_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/resultadoQueryDiccionario.txt";
//	private static final String DICTIONARY_JSON_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree.txt";
	private static final String DICTIONARY_JSON_CACHE_FILE = "C:/Users/inlucero/Documents/workspace-sts-3.7.0.RELEASE/iQuality/src/main/resources/jsonTree.json";
	private static boolean VALID_DICTIONARY_CACHE = true;
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

//		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_MY_INDEX;

	}
	
	// Ahora uso este modelo, pero despues tendria que usar los especificos
	// de la capa de datos???
	
	// Por que return string? Puedo retornar algo mejor o no?
	@RequestMapping(value = "/iquality", method = RequestMethod.GET)
	public String iquality(ModelMap model) {

		// Hago cosas con la BBDD
		
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
		
		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("Pankaj");
		emp.setRole("Java Developer");
		
		//Create
		employeeDAO.save(emp);
		
		//Read
		Employee emp1 = employeeDAO.getById(rand);
		System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		emp.setRole("CEO");
		employeeDAO.update(emp);
		
		//Get All
		List<Employee> empList = employeeDAO.getAll();
		System.out.println(empList);
		
		//Delete
		employeeDAO.deleteById(rand);
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
		//Fin de cosas con la BBDD
		
		model.addAttribute("insert", emp1);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_MY_INDEX;

	}
	
	@RequestMapping(value = "/lk_met_pla_ctrl_pase/{id_ejecucion}", method = RequestMethod.GET)
	public String show_lk_met_pla_ctrl_pase(@PathVariable int id_ejecucion, ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the lk_met_pla_ctrl_paseDAO Bean
		//To use JdbcTemplate
		LK_MET_PLA_CTRL_PASEDAO lk_met_pla_ctrl_paseDAO = ctx.getBean("lk_met_pla_ctrl_paseDAOJDBCTemplate", LK_MET_PLA_CTRL_PASEDAO.class);
		
		//Read
		logger.debug("[show_lk_met_pla_ctrl_pase] counter : {}, ready to getById", ++counter);
		LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase;
		try {
			lk_met_pla_ctrl_pase = lk_met_pla_ctrl_paseDAO.getById(id_ejecucion);
			
			logger.debug("[show_lk_met_pla_ctrl_pase] counter : LK_MET_PLA_CTRL_PASE Retrieved::{}", lk_met_pla_ctrl_pase);
			
			model.addAttribute("id_sistema", lk_met_pla_ctrl_pase.getId_sistema());
			model.addAttribute("id_ejecucion", lk_met_pla_ctrl_pase.getId_ejecucion());
			model.addAttribute("id_software", lk_met_pla_ctrl_pase.getId_software());
			model.addAttribute("id_pase", lk_met_pla_ctrl_pase.getId_pase());
			model.addAttribute("de_pase", lk_met_pla_ctrl_pase.getDe_pase());
			model.addAttribute("id_fecha_inicio", lk_met_pla_ctrl_pase.getId_fecha_inicio());
			model.addAttribute("id_fecha_inicio_real", lk_met_pla_ctrl_pase.getId_fecha_inicio_real());
			model.addAttribute("id_fecha_fin_real", lk_met_pla_ctrl_pase.getId_fecha_fin_real());
			model.addAttribute("id_estado", lk_met_pla_ctrl_pase.getId_estado());
			model.addAttribute("id_sn_habilitado", lk_met_pla_ctrl_pase.getId_sn_habilitado());
			model.addAttribute("id_anyo", lk_met_pla_ctrl_pase.getId_anyo());
			model.addAttribute("id_mes", lk_met_pla_ctrl_pase.getId_mes());
			model.addAttribute("id_escenario", lk_met_pla_ctrl_pase.getId_escenario());
			model.addAttribute("id_fecha_creacion", lk_met_pla_ctrl_pase.getId_fecha_creacion());
			model.addAttribute("id_fecha_modificacion", lk_met_pla_ctrl_pase.getId_fecha_modificacion());
			model.addAttribute("id_pid", lk_met_pla_ctrl_pase.getId_pid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		logger.info("[lk_met_pla_ctrl_pase] -> DONE");
		
		logger.debug("[lk_met_pla_ctrl_pase] counter : {}", ++counter);
		return VIEW_LK_MET_PLA_CTRL_PASE;

	}
	
	@RequestMapping(value = "/lk_met_pla_ctrl_pase/api/{id_ejecucion}", method = RequestMethod.GET)
	public @ResponseBody LK_MET_PLA_CTRL_PASE get_lk_met_pla_ctrl_pase_API(@PathVariable int id_ejecucion) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the lk_met_pla_ctrl_paseDAO Bean
		//To use JdbcTemplate
		LK_MET_PLA_CTRL_PASEDAO lk_met_pla_ctrl_paseDAO = ctx.getBean("lk_met_pla_ctrl_paseDAOJDBCTemplate", LK_MET_PLA_CTRL_PASEDAO.class);
		
		//Read
		logger.debug("[show_lk_met_pla_ctrl_pase] counter : {}, ready to getById", ++counter);
		LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase;
		lk_met_pla_ctrl_pase = lk_met_pla_ctrl_paseDAO.getById(id_ejecucion);
		
		//Close Spring Context
		ctx.close();
		logger.info("[lk_met_pla_ctrl_pase] -> DONE");
		
		logger.debug("[lk_met_pla_ctrl_pase] counter : {}", ++counter);
		
		return lk_met_pla_ctrl_pase;
	}
	
	@RequestMapping(value = "/lk_met_pla_ctrl_pase_job/{id_ejecucion}/{id_job}", method = RequestMethod.GET)
	public String show_lk_met_pla_ctrl_pase_job(@PathVariable int id_ejecucion, @PathVariable String id_job, ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the lk_met_pla_ctrl_pase_jobDAO Bean
		//To use JdbcTemplate
		LK_MET_PLA_CTRL_PASE_JOBDAO lk_met_pla_ctrl_pase_jobDAO = ctx.getBean("lk_met_pla_ctrl_pase_jobDAOJDBCTemplate", LK_MET_PLA_CTRL_PASE_JOBDAO.class);
		
		//Read
		logger.debug("[show_lk_met_pla_ctrl_pase_job] counter : {}, ready to getById", ++counter);
		LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job = lk_met_pla_ctrl_pase_jobDAO.getById(id_ejecucion, id_job);
		
		if(lk_met_pla_ctrl_pase_job != null) {
			
			logger.debug("[show_lk_met_pla_ctrl_pase_job] counter : LK_MET_PLA_CTRL_PASE_JOB Retrieved::{}", lk_met_pla_ctrl_pase_job);
			
			model.addAttribute("id_sistema", lk_met_pla_ctrl_pase_job.getId_sistema());
			model.addAttribute("id_ejecucion", lk_met_pla_ctrl_pase_job.getId_ejecucion());
			model.addAttribute("id_software", lk_met_pla_ctrl_pase_job.getId_software());
			model.addAttribute("id_pase", lk_met_pla_ctrl_pase_job.getId_pase());
			model.addAttribute("id_pid", lk_met_pla_ctrl_pase_job.getId_pid());
			model.addAttribute("id_fecha_inicio", lk_met_pla_ctrl_pase_job.getId_fecha_inicio());
			model.addAttribute("id_fecha_fin", lk_met_pla_ctrl_pase_job.getId_fecha_fin());
			model.addAttribute("id_estado", lk_met_pla_ctrl_pase_job.getId_estado());
			model.addAttribute("id_fecha_creacion", lk_met_pla_ctrl_pase_job.getId_fecha_creacion());
			model.addAttribute("id_fecha_modificacion", lk_met_pla_ctrl_pase_job.getId_fecha_modificacion());
			model.addAttribute("id_sn_punto_control", lk_met_pla_ctrl_pase_job.getId_sn_punto_control());
			model.addAttribute("id_fecha_ok_punto_control", lk_met_pla_ctrl_pase_job.getId_fecha_ok_punto_control());
		} else {
			model.addAttribute("id_sistema", "NO lk_met_pla_ctrl_pase_job FOUND WITH id_ejecucion = " + String.valueOf(id_ejecucion) + " and id_job = " + id_job);
		}
		
		//Close Spring Context
		ctx.close();
		logger.info("[lk_met_pla_ctrl_pase_job] -> DONE");
		
		logger.debug("[lk_met_pla_ctrl_pase_job] counter : {}", ++counter);
		return VIEW_LK_MET_PLA_CTRL_PASE_JOB;

	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFound(ModelMap model) {

		model.addAttribute("test", "You found \"not found\"");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_NOT_FOUND;

	}
	
	@RequestMapping(value = "/my-old-index", method = RequestMethod.GET)
	public String myOldIndex(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[myOldIndex] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_MY_INDEX;

	}
	
	@RequestMapping(value = "/diccionario", method = RequestMethod.GET)
	public String diccionario(ModelMap model) {

		logger.debug("[diccionario] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_DICCIONARIO;

	}

	@RequestMapping(value = "/consola-control-ejecucion", method = RequestMethod.GET)
	public String consolaControlEjecucion(ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
				
		//Get the lk_met_pla_ctrl_paseDAO Bean
		//To use JdbcTemplate
		PaseDAO paseDAO = ctx.getBean("paseDAOJDBCTemplate", PaseDAO.class);
				
		//Read
		List<Pase> allPase;
		
		try {
			allPase = paseDAO.getAll();
			model.addAttribute("allTableItems", allPase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		logger.info("[consola-control-ejecucion] -> DONE");
		
		logger.debug("[consola-control-ejecucion] counter : {}", counter);
		
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_CONSOLACONTROLEJECUCION;

	}
	
	@RequestMapping(value = "/test-diccionario", method = RequestMethod.GET)
	public String testDictionary(ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the dictionaryOfConceptsDAO Bean
		//To use JdbcTemplate
		DictionaryOfConceptsDAO dictionaryOfConceptsDAO = ctx.getBean("dictionaryOfConceptsDAOJDBCTemplate", DictionaryOfConceptsDAO.class);
		
		//Read
		List<GenericTreeNode<DictionaryConcept>> allDictionaryConceptNodes = new ArrayList<GenericTreeNode<DictionaryConcept>>();
		
		// Hago la query sólo si la cache no es válida
		if (!VALID_DICTIONARY_CACHE) {
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
			// TODO Sería aún mejor si la query no me los deuelve, para empezar, y lo mato de raíz
			allDictionaryConceptNodes.remove(0);
			allDictionaryConceptNodes.remove(0);
			allDictionaryConceptNodes.remove(0);
			// Escribo el resultado de la query en un fichero
			// Esto será la caché más adelante
			// TODO Crear el fichero sólo si no existe y la caché está al día
			String conceptsForFile = new String();
			for (GenericTreeNode<DictionaryConcept> dictionaryConceptNode : allDictionaryConceptNodes) {
				conceptsForFile += dictionaryConceptNode.getData().getLevel() + " "
						+ dictionaryConceptNode.getData().getStatus() + " " + dictionaryConceptNode.getData().getTipo()
						+ " " + dictionaryConceptNode.getData().getConcept() + "\n";
			}
			// Guardo las filas de la query en un fichero
			// TODO Path harcodeado, sería mejor parametrizado
			File destination = new File(DICTIONARY_CACHE_FILE);
			System.out.println(destination.getAbsolutePath());
			try {
				Files.write(conceptsForFile, destination, Charset.forName("UTF-8"));
				System.out.println("Succesfully wrote to file " + DICTIONARY_CACHE_FILE);
			} catch (IOException e) {
				// Useful error handling here
			}
		}
		
		
		// Traduzco las filas de la query a un tree a partir del fichero que acabo de guardar
		// También se puede hacer directamente desde el array allDictionaryConceptNodes
		ConceptsToTreeTranslator translator = new ConceptsToTreeTranslator();
		GenericTreeNode<DictionaryConcept> tree = new GenericTreeNode<DictionaryConcept>();
		try {
			tree = translator.createTreeFromTxtFile(DICTIONARY_CACHE_FILE);
			
			tree.myPrintTree(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en BaseController.testDictionary al intentar crear el árbol.");
			e.printStackTrace();
		}
		
		// Traduzco el tree a un pretty string JSON
		TreeToJSONTranslator jsonTranslator = new TreeToJSONTranslator();
		String jsonTree = jsonTranslator.createPrettyJSONStringFromTree(tree);
		
		// Y guardo el JSON en un fichero caché
		File jsonTreeFile = new File(DICTIONARY_JSON_CACHE_FILE);
		try {
		    Files.write(jsonTree, jsonTreeFile, Charset.forName("UTF-8"));
		    System.out.println("Succesfully wrote to file " + DICTIONARY_JSON_CACHE_FILE);
//			System.out.println(prettyJsonString);
		} catch (IOException e) {
		    // Useful error handling here
		}

		// Para visualizar (y quizás trampear la comunicación con el JS?)
		model.addAttribute("jsonTree", jsonTree);
		
		//Close Spring Context
		ctx.close();
		logger.info("[testDictionary] -> DONE");
		
		return VIEW_DICCIONARIO;

	}
	
	@RequestMapping(value = "/api/jsonTree", method = RequestMethod.GET)
	// Descomentar para la opción 1
	public @ResponseBody JSONObject getJSONTree() {
	// Descomentar para la opción 3
//	public @ResponseBody String getJSONTree() {
		
		// Si la cache no es válida la actualizo
		if(!VALID_DICTIONARY_CACHE) auxiliaryUpdateDictionaryCache();
			
		///////////////////////////////////////////////////////////////////////////////////////
		// Opción 1 para leer el fichero json a un JSONObject
		// Creo que es más lenta que la opción 2 porque parsea el json
		JSONParser parser = new JSONParser();
		JSONObject jsonTree = new JSONObject();
		try {
			jsonTree = (JSONObject) parser.parse(new FileReader(DICTIONARY_JSON_CACHE_FILE));
		} catch (FileNotFoundException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		} catch (IOException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		} catch (ParseException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
		}
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Opción 2 para leer el fichero json a un JSONObject
		// Creo que es más rápida que la opción 1 porque obtiene el String directamente
		// Aunque qiuzás el overhead aquí esté al transformar el String a un JSONObject
		/*
		File sourceFile = new File(DICTIONARY_JSON_CACHE_FILE);
		// Tengo que usar esta dependencia en el pom -> org.json.JSONObject
		// O hacerlo con GSON -> JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
		org.json.JSONObject jsonTree;
		try {
			String jsonTreeString = Files.toString(sourceFile, Charsets.UTF_8);
			jsonTree = new JSONObject(jsonTreeString);
		} catch (IOException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
			jsonTree = new JSONObject();
		}
		*/
		
		///////////////////////////////////////////////////////////////////////////////////////
		// Opción 3 para leer el fichero json a un JSONObject
		// Qué tal si leo el string del fichero y retorno directamente un String
		// en vez de parsearlo a un JSON?
		// No funciona pero no descarto que se pueda apañar
		/*
		File sourceFile = new File(DICTIONARY_JSON_CACHE_FILE);
		String jsonTreeString;
		try {
			jsonTreeString = Files.toString(sourceFile, Charsets.UTF_8);
		} catch (IOException e) {
			logger.error("[getJsonTree] -> Error al leer el fichero JSON que hace de caché -> " + e.getMessage());
			jsonTreeString = new String();
		}
		*/
		
		
//		logger.debug(jsonTree.toJSONString());
		logger.info("[getJSONTree] -> DONE");
		
		// Descomentar para la opción 1
		return jsonTree;
		// Descomentar para la opción 3
//		return jsonTreeString;
	}
	
	@RequestMapping(value = "/api/updateDictionaryCache", method = RequestMethod.GET)
	public String updateDictionaryCache(ModelMap model) {
		
		auxiliaryUpdateDictionaryCache();
		return VIEW_INDEX;
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
			logger.info("[getJSONTree] : Generado tree a partir de fichero json.");
			//					tree.myPrintTree(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en BaseController.getJSONTree al intentar crear el árbol.");
			e.printStackTrace();
		}

		///////////////////////////////////////////////////////////////////////////////////////
		// Traduzco el tree JSON
		// NO PRETTY! (se puede si se quiere con jsonTranslator.createPrettyJSONStringFromTree
		TreeToJSONTranslator jsonTranslator = new TreeToJSONTranslator();
		JSONObject jsonTree = jsonTranslator.createJSONFromTree(dictionaryTree);

		
		///////////////////////////////////////////////////////////////////////////////////////
		// Y guardo el JSON en un fichero caché
		File jsonTreeFile = new File(DICTIONARY_JSON_CACHE_FILE);
		try {
			Files.write(jsonTree.toString(), jsonTreeFile, Charset.forName("UTF-8"));
			logger.info("[getJSONTree] : Succesfully wrote to file " + DICTIONARY_JSON_CACHE_FILE);
			//										System.out.println(prettyJsonString);
		} catch (IOException e) {
			System.out.println("ERROR al intentar escribir en " + DICTIONARY_JSON_CACHE_FILE + "\n" + e.getMessage());
		}


		///////////////////////////////////////////////////////////////////////////////////////
		//Close Spring Context
		ctx.close();

		logger.info("[auxiliaryUpdateDictionaryCache] -> DONE");
		return true;

	}
	
	@RequestMapping(value = "/pases/{idEjecucion}/jobs", method = RequestMethod.GET)
	public String getJobsdePase(@PathVariable int idEjecucion, ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
				
		//Get the lk_met_pla_ctrl_paseDAO Bean
		//To use JdbcTemplate
		JobDAO jobDAO = ctx.getBean("jobDAOJDBCTemplate", JobDAO.class);
				
		//Read
		List<Job> allJobs;
		
		try {
			allJobs = jobDAO.getAll(idEjecucion);
			model.addAttribute("allTableItems", allJobs);
			model.addAttribute("idEjecucion", idEjecucion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		logger.info("[getJobsdePase] -> DONE");
		
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_JOBS_DE_PASE;

	}
	
	@RequestMapping(value = "/pases/{idEjecucion}/jobs/{idJob}/registro-de-operaciones", method = RequestMethod.GET)
	public String getRegistrosDeJob(@PathVariable int idEjecucion, @PathVariable String idJob, ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
				
		//Get the registroDeOperacionDAO Bean
		//To use JdbcTemplate
		RegistroDeOperacionDAO registroDeOperacionDAO = ctx.getBean("registroDeOperacionDAOJDBCTemplate", RegistroDeOperacionDAO.class);
				
		//Read registros de operación
		List<RegistroDeOperacion> allRegistroDeOperacion;
		
		try {
			allRegistroDeOperacion = registroDeOperacionDAO.getAll(idEjecucion, idJob);
			model.addAttribute("allTableItems", allRegistroDeOperacion);
			model.addAttribute("idEjecucion", idEjecucion);
			model.addAttribute("idJob", idJob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		logger.info("[getRegistrosDeJob] -> DONE");
		
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_REGISTRO_DE_JOB;

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
	
}