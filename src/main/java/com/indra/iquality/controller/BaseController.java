package com.indra.iquality.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.indra.iquality.dao.PaseDAO;
import com.indra.iquality.model.Pase;

@Controller
public class BaseController {

	// private Sistema sistema = Sistema.getInstance();

	/*
	 * Esto puede ser útil en algún momento <p>The context path is:
	 * ${pageContext.request.contextPath}.</p> <p>The context path is:
	 * ${pageContext.servletContext.contextPath}.</p>
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

	@RequestMapping(value = "/post-test", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseStatus(value = HttpStatus.OK)
	// private @ResponseBody void handleWizardPost(@RequestBody WizardForm1 wf){
	private @ResponseBody void handleWizardPost(@RequestBody String jsonString) {

		logger.debug("[post-test] : Called route");

		JSONParser parser = new JSONParser();
		JSONObject json;
		// logger.info(jsonString);
		try {
			json = (JSONObject) parser.parse(jsonString);

			JSONArray jobsJSONArray = (JSONArray) json.get("jobs");
			String[] jobs = new String[jobsJSONArray.size()];
			for (int i = 0; i < jobsJSONArray.size(); ++i) {
				jobs[i] = (String) jobsJSONArray.get(i);
			}
			logger.info("JOBS:");
			for (int i = 0; i < jobs.length; ++i)
				logger.info(jobs[i]);

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
			logger.info("DEPENDENCIAS:");
			for (Map.Entry<String, String[]> entry : dependencias.entrySet()) {
				logger.info("job: " + entry.getKey() + ", dependencias: ");
				for (int k = 0; k < entry.getValue().length; ++k)
					logger.info(entry.getValue()[k]);
			}

			Pase pase = new Pase((String) json.get("nombrePase"), (String) json.get("esAtipico"), jobs, dependencias);

			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			PaseDAO paseDAO = ctx.getBean("paseDAOJDBCTemplate", PaseDAO.class);
			ctx.close();
			paseDAO.insertPase(pase);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// logger.info(wf.getSistema());
		// logger.info(wf.getNombrePase());
		// logger.info(wf.getEsAtipico());

		logger.debug("[post-test] : Returning");
	}
}