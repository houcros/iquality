/*
 * 
 */
package com.indra.iquality.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iquality.dao.EjecucionDAO;
import com.indra.iquality.dao.JobDAO;
import com.indra.iquality.dao.RegistroDeOperacionDAO;
import com.indra.iquality.model.Ejecucion;
import com.indra.iquality.model.Job;
import com.indra.iquality.model.RegistroDeOperacion;

/**
 * The Class ExecutionManagementController. Handles all the requests related to
 * the management (mainly reads) related with executions of ETL flows, as well
 * as its corresponding jobs and register of operations.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 11-dic-2015
 * 
 *          The Class ExecutionManagementController.
 */
@Controller
@RequestMapping("/pases")
public class ExecutionManagementController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExecutionManagementController.class);

	/** The Constant pointing to the view of all the executions. */
	private static final String VIEW_EXECUTIONS = "pases";

	/** The Constant pointing to the view of all the jobs of an execution. */
	private static final String VIEW_JOBS = "jobs";

	/**
	 * The Constant pointing to the view of the register of operations of a job.
	 */
	private static final String VIEW_REGOPS = "registro-de-operaciones";

	/**
	 * Handles a GET request to display all the executions for the current
	 * system and software version.
	 *
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(method = RequestMethod.GET)
	private String showAllExecutions(ModelMap model) {

		logger.info("[showAllExecutions] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EjecucionDAO ejecucionDAO = ctx.getBean("ejecucionDAOJDBCTemplate", EjecucionDAO.class);
		ctx.close();

		// Obtengo todas la ejecuciones
		List<Ejecucion> allEjecuciones = null;
		try {
			allEjecuciones = ejecucionDAO.getAllEjecuciones();
			logger.debug("[showAllExecutions] : Obtenidos todas las ejecuciones");
		} catch (Exception e) {
			logger.error("[showAllExecutions] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso todas las ejecuciones a la vista
		model.addAttribute("allTableItems", allEjecuciones);

		logger.info("[showAllExecutions] : RETURN");
		return VIEW_EXECUTIONS;
	}

	/**
	 * Handles a GET request to display a single given execution for the current
	 * system and software version.
	 *
	 * @param idEjecucion
	 *            the unique identifier of the execution to display
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/{idEjecucion}", method = RequestMethod.GET)
	private String showExecution(@PathVariable int idEjecucion, ModelMap model) {

		logger.info("[showExecution] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EjecucionDAO ejecucionDAO = ctx.getBean("ejecucionDAOJDBCTemplate", EjecucionDAO.class);
		ctx.close();

		// Obtengo una ejecución. Será una lista de un elemento en vez de una
		// Execution para aprovechar la misma vista
		List<Ejecucion> unaEjecucion = new ArrayList<Ejecucion>();
		try {
			unaEjecucion.add(ejecucionDAO.getById(idEjecucion));
			logger.debug("[showExecution] : Obtenida la ejecución con id {}", idEjecucion);
		} catch (Exception e) {
			logger.error("[showExecution] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso la ejecución a la vista
		model.addAttribute("allTableItems", unaEjecucion);

		logger.info("[showExecution] : RETURN");
		return VIEW_EXECUTIONS;
	}

	/**
	 * Handles a GET request to display all the jobs of a given execution for
	 * the current system and software version.
	 *
	 * @param idEjecucion
	 *            the unique identifier of the execution for which to display
	 *            the jobs
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/{idEjecucion}/jobs", method = RequestMethod.GET)
	private String getJobsOfExecution(@PathVariable int idEjecucion, ModelMap model) {

		logger.info("[getJobsOfExecution] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JobDAO jobDAO = ctx.getBean("jobDAOJDBCTemplate", JobDAO.class);
		ctx.close();

		// Obtengo todos los jobs de la ejecución
		List<Job> allJobs = null;
		try {
			allJobs = jobDAO.getAll(idEjecucion);
			logger.debug("[getJobsOfExecution] : Obtenidos los jobs de la ejecución con id {}", idEjecucion);
		} catch (Exception e) {
			logger.error("[getJobsOfExecution] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso los jobs de la ejecución a la vista y el id de la ejecución
		model.addAttribute("allTableItems", allJobs);
		model.addAttribute("idEjecucion", idEjecucion);

		logger.info("[getJobsOfExecution] : RETURN");
		return VIEW_JOBS;
	}

	/**
	 * Handles a GET request to display the register of operations of a given
	 * job, which in turn is part of a given execution, for the current system
	 * and software version.
	 *
	 * @param idEjecucion
	 *            the unique identifier of the execution to which the job
	 *            belongs
	 * @param idJob
	 *            the unique identifier of the for which to display the register
	 *            of operations
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/{idEjecucion}/jobs/{idJob}/registro-de-operaciones", method = RequestMethod.GET)
	private String getRegopsOfJob(@PathVariable int idEjecucion, @PathVariable String idJob, ModelMap model) {

		logger.info("[getRegopsOfJob] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		RegistroDeOperacionDAO registroDeOperacionDAO = ctx.getBean("registroDeOperacionDAOJDBCTemplate",
				RegistroDeOperacionDAO.class);
		ctx.close();

		// Obtengo todos los registros de operaciones del job
		List<RegistroDeOperacion> registroDeOperaciones = null;
		try {
			registroDeOperaciones = registroDeOperacionDAO.getAll(idEjecucion, idJob);
			logger.debug(
					"[getRegopsOfJob] : Obtenidos los registros de operaciones del job con id {} de la ejecuciçon {}",
					idJob, idEjecucion);
		} catch (Exception e) {
			logger.error("[getRegopsOfJob] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso los registros de operaciones a la vista, así como id de la
		// ejecución y del job
		model.addAttribute("allTableItems", registroDeOperaciones);
		model.addAttribute("idEjecucion", idEjecucion);
		model.addAttribute("idJob", idJob);

		logger.info("[getRegopsOfJob] : RETURN");
		return VIEW_REGOPS;
	}
}
