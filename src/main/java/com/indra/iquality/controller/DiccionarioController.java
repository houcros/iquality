package com.indra.iquality.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/diccionario")
public class DiccionarioController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DiccionarioController.class);
	
	private static final String VIEW_DICCIONARIO = "diccionario";

	@RequestMapping(method = RequestMethod.GET)
	private String dict2(ModelMap model){
		logger.debug("[diccionario] : Called route");
		return VIEW_DICCIONARIO;
	}
}
