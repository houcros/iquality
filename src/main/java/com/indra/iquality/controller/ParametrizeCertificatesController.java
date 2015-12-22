package com.indra.iquality.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iquality.dao.BusinessCertificateDAO;
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
}
