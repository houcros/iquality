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
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_LOGIN = "login";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		logger.debug("[index] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.debug("[login] : Called route");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_LOGIN;
	}
	
	
}