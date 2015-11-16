package com.indra.iquality.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iquality.dao.CertificacionDeNegocioDAO;
import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.CertificacionDeNegocio;
import com.indra.iquality.model.ValidacionTecnica;

@Controller
public class BaseController {

//	private Sistema sistema = Sistema.getInstance();
	
	/*
	 * Esto puede ser útil en algún momento
	 *      <p>The context path is: ${pageContext.request.contextPath}.</p>
            <p>The context path is: ${pageContext.servletContext.contextPath}.</p>
	 */
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_CERTIFICACIONES_DE_NEGOCIO = "certificaciones-de-negocio";
	private static final String VIEW_VALIDACIONES_TECNICAS = "validaciones-tecnicas";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String index(ModelMap model) {
		logger.debug("[index] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login(ModelMap model) {
		logger.debug("[login] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/resultado-certificaciones", method = RequestMethod.GET)
	private String getValidaciones(@RequestParam(value="tab", required=false) Integer tab, ModelMap model){
		logger.debug("getValidaciones : Called route");
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		if(tab == null || tab == 1){
			CertificacionDeNegocioDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate", CertificacionDeNegocioDAO.class);
			List<CertificacionDeNegocio> allCertificaciones= cdnDAO.getAll();
			model.addAttribute("allTableItems", allCertificaciones);
			ctx.close();
			
			logger.info(allCertificaciones.get(0).toString());
			return VIEW_CERTIFICACIONES_DE_NEGOCIO;
		}
		else if (tab == 2){
			ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
			List<ValidacionTecnica> allValidaciones= vtDAO.getAll();
			model.addAttribute("allTableItems", allValidaciones);
			ctx.close();
			
			logger.info(allValidaciones.get(0).toString());
			return VIEW_VALIDACIONES_TECNICAS;
		}
		else{
			ctx.close();
			return VIEW_INDEX;
		}

	}
	
}