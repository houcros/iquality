package com.indra.iquality.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.model.PaseDef;

@Controller
@RequestMapping(value = "/planificar-cargas")
public class PlanificarCargasController {

	private static final String VIEW_PASES_DEF = "planificar-cargas";
	private static final String VIEW_WIZARD = "wizard-nuevo-pase";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PlanificarCargasController.class);

	@RequestMapping(method = RequestMethod.GET)
	private String getPasesDef(Model model){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PaseDAO paseDAO = ctx.getBean("paseDAOJDBCTemplate", PaseDAO.class);
		List<PaseDef> allPasesDef;
		
		try {
			allPasesDef = paseDAO.getAllDefs();
		} catch (Exception e) {
			allPasesDef = new ArrayList<PaseDef>();
			logger.error("[getPasesDef] : excepción <" + e.getMessage() + "> al intentar obtener todos los PaseDef.");
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		
		model.addAttribute("allTableItems", allPasesDef);
		logger.info("[getPasesDef] -> DONE");
		
		return VIEW_PASES_DEF;
	}
	
	@RequestMapping(value = "/wizard-nuevo-pase", method = RequestMethod.GET)
	private String wizard(Model model){
		return VIEW_WIZARD;
	}
	
}
