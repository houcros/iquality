/*
 * 
 */
package com.indra.iquality.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.indra.iquality.dao.FlowDAO;
import com.indra.iquality.dao.JobDAO;
import com.indra.iquality.model.Flow;
import com.indra.iquality.model.Job;
import com.indra.iquality.singleton.Environment;

/**
 * The Class FlowManagmentController. Handles all the requests related to the
 * management (CRUD operations) of ETL flows.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 11-dic-2015
 * 
 *          The Class FlowManagmentController.
 */
@Controller
@RequestMapping(value = "/planificar-cargas")
public class FlowManagementController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FlowManagementController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	/** The Constant pointing to the view of all the flows. */
	private static final String VIEW_FLOWS = "planificar-cargas";

	/**
	 * The Constant pointing to the view of the wizard for creating a new flow.
	 */
	private static final String VIEW_WIZARD = "wizard-nuevo-pase";

	/**
	 * Handles a GET request to display all the flows for the current system and
	 * software version.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(method = RequestMethod.GET)
	private String showAllFlows(Model model) {

		logger.info("[showAllFlows] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		FlowDAO paseDAO = ctx.getBean("paseDAOJDBCTemplate", FlowDAO.class);
		ctx.close();

		// Obtengo todos los pases
		List<Flow> allPases = null;
		try {
			allPases = paseDAO.getAll(environment.getIdSistema(), environment.getIdSoftware());
			logger.debug("[showAllFlows] : Obtenidos todos los pases");
		} catch (Exception e) {
			logger.error("[showAllFlows] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso todos los pases a la vista
		model.addAttribute("allTableItems", allPases);

		logger.info("[showAllFlows] : RETURN");
		return VIEW_FLOWS;
	}

	/**
	 * Handles a GET request to display a wizard for creating a new flow.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/wizard-nuevo-pase", method = RequestMethod.GET)
	private String wizardNewFlow(Model model) {

		logger.info("[wizardNewFlow] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JobDAO jobDAO = ctx.getBean("jobDAOJDBCTemplate", JobDAO.class);
		ctx.close();

		// Obtengo todos los jobs
		List<Job> allJobs;
		try {
			allJobs = jobDAO.getAll(environment.getIdSistema(), environment.getIdSoftware());
			logger.debug("[wizardNewFlow] : Obtenidos todos los jobs");
		} catch (Exception e) {
			allJobs = new ArrayList<Job>();
			logger.error("[wizardNewFlow] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso todos los jobs a la vista
		model.addAttribute("allJobs", allJobs);

		logger.info("[wizardNewFlow] : RETURN");
		return VIEW_WIZARD;
	}

	/**
	 * Handle a POST request to create a new flow.
	 *
	 * @param jsonString
	 *            the json representation of the flow; contains a name
	 *            <i>nombrePase</i>, a boolean string <i>esAtipico</i>, an array
	 *            of job identifiers with at least one element <i>jobs</i>, and
	 *            an object containing the dependencies <i>dependencias</i> as
	 *            key-value pairs, where the values are arrays.
	 * @return the representation of the response; contains at least the key
	 *         <i>redirect</i>, which indicates the path to redirect the browser
	 *         if the insert was successful. If the handler catches an error
	 *         will return a <i>error</i> key, with the path to redirect in case
	 *         of failure.
	 */
	@RequestMapping(value = "/post-wizard", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseStatus(value = HttpStatus.OK)
	private @ResponseBody JSONObject handleNewFlowPost(@RequestBody String jsonString) {

		logger.info("[handleNewFlowPost] : INIT");
		logger.debug("[handleNewFlowPost] : jsonString : {}", jsonString);

		// Este es el JSON con la página a donde redirigir. Se puede extender
		// para devolver más cosas y página alternativa en caso de error.
		JSONObject jsonResponse = new JSONObject();

		JSONParser parser = new JSONParser();
		JSONObject json;

		// Parseo el parámetro a objetos del modelo
		try {
			json = (JSONObject) parser.parse(jsonString);

			// Parseo los jobs a un array
			JSONArray jobsJSONArray = (JSONArray) json.get("jobs");
			String[] jobs = new String[jobsJSONArray.size()];
			for (int i = 0; i < jobsJSONArray.size(); ++i) {
				jobs[i] = (String) jobsJSONArray.get(i);
			}

			// Sólo ver los jobs parseados en el nivel más alto de logging
			if (logger.isTraceEnabled()) {
				String logJobs = "";
				for (int i = 0; i < jobs.length; ++i)
					logJobs += jobs[i] + " | ";
				logger.trace("[handleNewFlowPost] : jobs parseados : {}", logJobs);
			}

			// Parseo las dependencias a un HashMap
			JSONObject estadosJSONObject = (JSONObject) json.get("estados");
			Map<String, String[]> dependencias = new HashMap<String, String[]>();
			for (int i = 0; i < jobs.length; ++i) {
				JSONArray dependenciasJSONArray = (JSONArray) estadosJSONObject.get(jobs[i]);
				String[] dependenciasDeUnJob = new String[dependenciasJSONArray.size()];
				for (int j = 0; j < dependenciasJSONArray.size(); ++j) {
					dependenciasDeUnJob[j] = (String) dependenciasJSONArray.get(j);
				}
				dependencias.put(jobs[i], dependenciasDeUnJob);
			}

			// Sólo ver las dependencias parseadas en el nivel más alto de
			// logging
			if (logger.isTraceEnabled()) {
				String logDependencias = "";
				for (Map.Entry<String, String[]> entry : dependencias.entrySet()) {
					String logDep = entry.getKey() + "->[";
					for (int k = 0; k < entry.getValue().length; ++k)
						logDep += entry.getValue()[k] + ", ";
					logDep += "]";
					logDependencias += logDep + " | ";
				}
				logger.trace("[handleNewFlowPost] : dependencias parseadas : {}", logDependencias);
			}

			// Creo el pase con los datos del JSON y lo que acabo de parsear
			Flow pase = new Flow((String) json.get("nombrePase"), (String) json.get("esAtipico"), jobs, dependencias);
			// Inserto el pase mediante el DAO
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			FlowDAO paseDAO = ctx.getBean("paseDAOJDBCTemplate", FlowDAO.class);
			ctx.close();
			paseDAO.save(pase, environment.getIdSistema(), environment.getIdSoftware());

		} catch (ParseException e) {
			logger.error("[handleNewFlowPost] : Parseando JSON string");
			logger.error("[handleNewFlowPost] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			jsonResponse.put("error", "/iQuality/server-error");
			return jsonResponse;
		} catch (Exception e) {
			logger.error("[handleNewFlowPost] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			jsonResponse.put("error", "/iQuality/server-error");
			return jsonResponse;
		}

		// Pongo la página a la cual redirigir si todo va bien
		jsonResponse.put("redirect", "/iQuality/planificar-cargas/");
		logger.info("[handleNewFlowPost] : RETURN");
		return jsonResponse;
	}

}
