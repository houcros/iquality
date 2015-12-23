package com.indra.iquality.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.indra.iquality.dao.BusinessCertificateDAO;
import com.indra.iquality.dao.EnvironmentDAO;
import com.indra.iquality.dao.TechnicalCertificateDAO;
import com.indra.iquality.model.certificate.CertificateCondition;
import com.indra.iquality.singleton.Environment;

@Controller
@RequestMapping("/parametrizar-certificaciones")
public class ParametrizeCertificatesController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CertificatesResultController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	/**
	 * The Constant pointing to the view to parametrize all the business
	 * certificates.
	 */
	private static final String VIEW_PARAM_BUSINESS_CERTIFICATES = "param-certificaciones-de-negocio";

	/**
	 * The Constant pointing to the view to parametrize the technical
	 * certificates.
	 */
	private static final String VIEW_PARAM_TECHNICAL_CERTIFICATES = "param-validaciones-tecnicas";

	/**
	 * The Constant pointing to the view to parametrize the technical
	 * certificates.
	 */
	private static final String VIEW_WIZARD = "wizard-nueva-certificacion";

	/**
	 * The Constant to represent the first tab.
	 */
	private static final int TAB_VAL_BUSSINESS_CERTIFICATE = 1;

	/**
	 * The Constant to represent the second tab.
	 */
	private static final int TAB_VAL_TECHNICAL_CERTIFICATE = 2;

	@RequestMapping(value = "/{tab}", method = RequestMethod.GET)
	private String getParamCertificates(@PathVariable int tab, ModelMap model) {

		logger.info("[getParamCertificates] : INIT");

		// Abro el contexto para crear un DAO que dependerá de la pestaña en la
		// que estoy
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		if (tab == TAB_VAL_BUSSINESS_CERTIFICATE) {

			// En esta pestaña muestro las certificaciones de negocio
			BusinessCertificateDAO cdnDAO = ctx.getBean("businessCertificateDAOJDBCTemplate",
					BusinessCertificateDAO.class);
			ctx.close();
			// Obtengo todos las condiciones de certificaciones y las paso a la
			// vista
			List<CertificateCondition> allCertConditions = cdnDAO.getCertificateConditions(environment.getSystem(),
					environment.getCurrentSoftware());
			model.addAttribute("allTableItems", allCertConditions);

			logger.info("[getParamCertificates] : RETURN (from tab {})", tab);
			return VIEW_PARAM_BUSINESS_CERTIFICATES;

		} else if (tab == TAB_VAL_TECHNICAL_CERTIFICATE) {

			// En esta pestaña muestro las validaciones técnicas
			TechnicalCertificateDAO vtDAO = ctx.getBean("technicalCertificateDAOJDBCTemplate",
					TechnicalCertificateDAO.class);
			ctx.close();
			// Obtengo todas las validaciones y las paso a la vista
			List<CertificateCondition> allValiConditions = vtDAO.getValidationConditions(environment.getSystem(),
					environment.getCurrentSoftware());
			model.addAttribute("allTableItems", allValiConditions);

			logger.info("[getCertificates] : RETURN (from tab {})", tab);
			return VIEW_PARAM_TECHNICAL_CERTIFICATES;

		} else {
			// Si no es ninguna de las pestañas anteriores, la página no existe
			ctx.close();
			logger.warn(
					"[getParamCertificates] : El usuario ha pedido una pestaña de certificaciones que no existe : {}",
					tab);
			logger.info("[getParamCertificates] : RETURN (from invalid tab {})", tab);
			return "redirect:/not-found";
		}

	}

	@RequestMapping(value = "/wizard-nueva-certificacion", method = RequestMethod.GET)
	private String wizardNewCertificate(Model model) {

		logger.info("[wizardNewCertificate] : INIT");

		// Abro el contexto para crear un DAO
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EnvironmentDAO envDAO = ctx.getBean("environmentDAOJDBCTemplate", EnvironmentDAO.class);
		ctx.close();

		// Obtengo todas las tablas
		List<Pair<String, String>> allTables;
		try {
			allTables = envDAO.getAllTables(environment.getSystem());
			logger.debug("[wizardNewCertificate] : Obtenidas todas las tablas");
		} catch (Exception e) {
			allTables = new ArrayList<Pair<String, String>>();
			logger.error("[wizardNewCertificate] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage(),
					e.getStackTrace());
			return "redirect:/server-error";
		}

		// Paso todas las tablas a la vista
		model.addAttribute("allTables", allTables);

		logger.info("[wizardNewCertificate] : RETURN");
		return VIEW_WIZARD;
	}

	@RequestMapping(value = "/post-wizard", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseStatus(value = HttpStatus.OK)
	private @ResponseBody JSONObject handleNewCertificatePost(@RequestBody String jsonString) {

		// TODO No olvidar usar el sistema al insertar pq no está en el wizard!
		// TODO TODO Para obtener periodos de tabla
		// select column_name d, column_name r from all_tab_columns where
		// table_name = 'AG_MET_IQ_CERTIF_GENERAL'
		logger.info("[handleNewCertificatePost] : INIT");
		logger.debug("[handleNewCertificatePost] : jsonString : {}", jsonString);

		// Este es el JSON con la página a donde redirigir. Se puede extender
		// para devolver más cosas y página alternativa en caso de error.

		JSONObject jsonResponse = new JSONObject();
		/*
		 * JSONParser parser = new JSONParser(); JSONObject json;
		 * 
		 * // Parseo el parámetro a objetos del modelo try { json = (JSONObject)
		 * parser.parse(jsonString);
		 * 
		 * // Parseo los jobs a un array JSONArray jobsJSONArray = (JSONArray)
		 * json.get("jobs"); String[] jobs = new String[jobsJSONArray.size()];
		 * for (int i = 0; i < jobsJSONArray.size(); ++i) { jobs[i] = (String)
		 * jobsJSONArray.get(i); }
		 * 
		 * // Sólo ver los jobs parseados en el nivel más alto de logging if
		 * (logger.isTraceEnabled()) { String logJobs = ""; for (int i = 0; i <
		 * jobs.length; ++i) logJobs += jobs[i] + " | "; logger.trace(
		 * "[handleNewCertificatePost] : jobs parseados : {}", logJobs); }
		 * 
		 * // Parseo las dependencias a un HashMap JSONObject estadosJSONObject
		 * = (JSONObject) json.get("estados"); Map<String, String[]>
		 * dependencias = new HashMap<String, String[]>(); for (int i = 0; i <
		 * jobs.length; ++i) { JSONArray dependenciasJSONArray = (JSONArray)
		 * estadosJSONObject.get(jobs[i]); String[] dependenciasDeUnJob = new
		 * String[dependenciasJSONArray.size()]; for (int j = 0; j <
		 * dependenciasJSONArray.size(); ++j) { dependenciasDeUnJob[j] =
		 * (String) dependenciasJSONArray.get(j); } dependencias.put(jobs[i],
		 * dependenciasDeUnJob); }
		 * 
		 * // Sólo ver las dependencias parseadas en el nivel más alto de //
		 * logging if (logger.isTraceEnabled()) { String logDependencias = "";
		 * for (Map.Entry<String, String[]> entry : dependencias.entrySet()) {
		 * String logDep = entry.getKey() + "->["; for (int k = 0; k <
		 * entry.getValue().length; ++k) logDep += entry.getValue()[k] + ", ";
		 * logDep += "]"; logDependencias += logDep + " | "; } logger.trace(
		 * "[handleNewFlowPost] : dependencias parseadas : {}",
		 * logDependencias); }
		 * 
		 * // Creo el pase con los datos del JSON y lo que acabo de parsear Flow
		 * pase = new Flow((String) json.get("nombrePase"), (String)
		 * json.get("esAtipico"), jobs, dependencias); // Inserto el pase
		 * mediante el DAO ClassPathXmlApplicationContext ctx = new
		 * ClassPathXmlApplicationContext("spring.xml"); FlowDAO paseDAO =
		 * ctx.getBean("flowDAOJDBCTemplate", FlowDAO.class); ctx.close();
		 * paseDAO.save(pase, environment.getSystem(),
		 * environment.getCurrentSoftware());
		 * 
		 * } catch (ParseException e) { logger.error(
		 * "[handleNewFlowPost] : Parseando JSON string"); logger.error(
		 * "[handleNewFlowPost] : Excepción <{}> | Ayuda: {}  \n {}",
		 * e.getClass(), e.getMessage(), e.getStackTrace());
		 * jsonResponse.put("error", "/iQuality/server-error"); return
		 * jsonResponse; } catch (Exception e) { logger.error(
		 * "[handleNewFlowPost] : Excepción <{}> | Ayuda: {}  \n {}",
		 * e.getClass(), e.getMessage(), e.getStackTrace());
		 * jsonResponse.put("error", "/iQuality/server-error"); return
		 * jsonResponse; }
		 */
		// Pongo la página a la cual redirigir si todo va bien
		jsonResponse.put("redirect", "/iQuality/parametrizar-certificaciones/1");
		logger.info("[handleNewCertificatePost] : RETURN");
		return jsonResponse;
	}

}
