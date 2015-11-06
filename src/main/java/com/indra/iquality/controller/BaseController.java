package com.indra.iquality.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
}