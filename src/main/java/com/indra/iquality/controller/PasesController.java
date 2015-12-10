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

@Controller
@RequestMapping("/pases")
public class PasesController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PasesController.class);

	private static final String VIEW_PASES = "pases";
	private static final String VIEW_JOBS_DE_PASE = "jobs";
	private static final String VIEW_REGISTRO_DE_JOB = "registro-de-operaciones";

	@RequestMapping(method = RequestMethod.GET)
	private String showAllPases(ModelMap model) {
		logger.info("[showAllPases] : Called route");

		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		// Get the lk_met_pla_ctrl_paseDAO Bean
		// To use JdbcTemplate
		EjecucionDAO paseDAO = ctx.getBean("ejecucionDAOJDBCTemplate", EjecucionDAO.class);

		// Read
		List<Ejecucion> allPase;

		try {
			allPase = paseDAO.getAllEjecuciones();
			model.addAttribute("allTableItems", allPase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close Spring Context
		ctx.close();
		logger.info("[consola-control-ejecucion] -> DONE");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_PASES;
	}

	@RequestMapping(value = "/{idEjecucion}", method = RequestMethod.GET)
	private String showPase(@PathVariable int idEjecucion, ModelMap model) {

		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		// Get the lk_met_pla_ctrl_paseDAO Bean
		// To use JdbcTemplate
		EjecucionDAO paseDAO = ctx.getBean("ejecucionDAOJDBCTemplate", EjecucionDAO.class);

		// Read
		List<Ejecucion> unPase = new ArrayList<Ejecucion>();

		try {
			unPase.add(paseDAO.getById(idEjecucion));
			logger.info(paseDAO.getById(idEjecucion).toString());
			model.addAttribute("allTableItems", unPase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close Spring Context
		ctx.close();
		logger.info("[consola-control-ejecucion] -> DONE");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_PASES;

	}

	@RequestMapping(value = "/{idEjecucion}/jobs", method = RequestMethod.GET)
	private String getJobsdePase(@PathVariable int idEjecucion, ModelMap model) {

		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		// Get the lk_met_pla_ctrl_paseDAO Bean
		// To use JdbcTemplate
		JobDAO jobDAO = ctx.getBean("jobDAOJDBCTemplate", JobDAO.class);

		// Read
		List<Job> allJobs;

		try {
			allJobs = jobDAO.getAll(idEjecucion);
			model.addAttribute("allTableItems", allJobs);
			model.addAttribute("idEjecucion", idEjecucion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close Spring Context
		ctx.close();
		logger.info("[getJobsdePase] -> DONE");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_JOBS_DE_PASE;

	}

	@RequestMapping(value = "/{idEjecucion}/jobs/{idJob}/registro-de-operaciones", method = RequestMethod.GET)
	private String getRegistrosDeJob(@PathVariable int idEjecucion, @PathVariable String idJob, ModelMap model) {

		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		// Get the registroDeOperacionDAO Bean
		// To use JdbcTemplate
		RegistroDeOperacionDAO registroDeOperacionDAO = ctx.getBean("registroDeOperacionDAOJDBCTemplate",
				RegistroDeOperacionDAO.class);

		// Read registros de operación
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

		// Close Spring Context
		ctx.close();
		logger.info("[getRegistrosDeJob] -> DONE");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_REGISTRO_DE_JOB;

	}
}
