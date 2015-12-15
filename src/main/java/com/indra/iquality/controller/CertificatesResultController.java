/*
 * 
 */
package com.indra.iquality.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iquality.dao.BusinessCertificateDAO;
import com.indra.iquality.dao.TechnicalCertificateDAO;
import com.indra.iquality.model.BusinessCertificate;
import com.indra.iquality.model.DetailOfCertificate;
import com.indra.iquality.model.DetailOfValidation;
import com.indra.iquality.model.TechnicalCertificate;
import com.indra.iquality.singleton.Environment;

/**
 * The Class CertificatesResultController. Handles all the requests related to
 * the management (mainly reads) related with certificates.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class CertificatesResultController.
 */
@Controller
@RequestMapping("/resultado-certificaciones")
public class CertificatesResultController {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CertificatesResultController.class);

	/** The Constant reference to the environment. */
	private final static Environment environment = Environment.getInstance();

	/**
	 * The Constant pointing to the view of all the business certificates.
	 */
	private static final String VIEW_BUSINESS_CERTIFICATES = "certificaciones-de-negocio";

	/**
	 * The Constant pointing to a detailed view of a business certificates.
	 */
	private static final String VIEW_BUSINESS_CERTIFICATES_DETAIL = "certificaciones-de-negocio-detalle";

	/**
	 * The Constant pointing to the view of all the technical certificates.
	 */
	private static final String VIEW_TECHNICAL_CERTIFICATES = "validaciones-tecnicas";

	/**
	 * The Constant pointing to a detailed view of a technical certificates.
	 */
	private static final String VIEW_TECHNICAL_CERTIFICATES_DETAIL = "validaciones-tecnicas-detalle";

	/**
	 * The Constant to represent the first tab.
	 */
	private static final int TAB_VAL_BUSSINESS_CERTIFICATE = 1;

	/**
	 * The Constant to represent the second tab.
	 */
	private static final int TAB_VAL_TECHNICAL_CERTIFICATE = 2;

	/**
	 * Handles a GET request to display all the certificates of a given type for
	 * the current system and software version.
	 *
	 * @param tab
	 *            the type of certificates to view; currently supports
	 *            {@link #TAB_VAL_BUSSINESS_CERTIFICATE} and
	 *            {@link #TAB_VAL_TECHNICAL_CERTIFICATE}.
	 * @param model
	 *            the model to pass data to the view
	 * @return the view to display
	 */
	@RequestMapping(value = "/{tab}", method = RequestMethod.GET)
	private String getCertificates(@PathVariable int tab, ModelMap model) {

		logger.info("[getCertificates] : INIT");

		// Abro el contexto para crear un DAO que dependerá de la pestaña en la
		// que estoy
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		if (tab == TAB_VAL_BUSSINESS_CERTIFICATE) {

			// En esta pestaña muestro las certificaciones de negocio
			BusinessCertificateDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate",
					BusinessCertificateDAO.class);
			ctx.close();
			// Obtengo todas las certificaciones y las paso a la vista
			List<BusinessCertificate> allCertificaciones = cdnDAO.getAll(environment.getIdSistema(),
					environment.getIdSoftware());
			model.addAttribute("allTableItems", allCertificaciones);

			logger.info("[getCertificates] : RETURN (from tab {})", tab);
			return VIEW_BUSINESS_CERTIFICATES;

		} else if (tab == TAB_VAL_TECHNICAL_CERTIFICATE) {

			// En esta pestaña muestro las validaciones técnicas
			TechnicalCertificateDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate",
					TechnicalCertificateDAO.class);
			ctx.close();
			// Obtengo todas las validaciones y las paso a la vista
			List<TechnicalCertificate> allValidaciones = vtDAO.getAll(environment.getIdSistema(),
					environment.getIdSoftware());
			model.addAttribute("allTableItems", allValidaciones);

			logger.info("[getCertificates] : RETURN (from tab {})", tab);
			return VIEW_TECHNICAL_CERTIFICATES;

		} else {
			// Si no es ninguna de las pestañas anteriores, la página no existe
			ctx.close();
			logger.warn("[getCertificates] : El usuario ha pedido una pestaña de certificaciones que no existe : {}",
					tab);
			logger.info("[getCertificates] : RETURN (from invalid tab {})", tab);
			return "redirect:/not-found";
		}

	}

	/**
	 * Handles a GET request to display the detailed view of a certificate of a
	 * given type for the current system and software version. As the detailed
	 * tables have a variable number of columns, this method leaves a cookie in
	 * the browser so that the frontend knows how many columns to display.
	 *
	 * @param tab
	 *            the type of certificates to view; currently supports
	 *            {@link #TAB_VAL_BUSSINESS_CERTIFICATE} and
	 *            {@link #TAB_VAL_TECHNICAL_CERTIFICATE}.
	 * @param idMetrica
	 *            the metrics for which to check the certificate; submit as part
	 *            of the query string
	 * @param idMes
	 *            the month for which to check the certificate; submit as part
	 *            of the query string
	 * @param model
	 *            the model to pass data to the view
	 * @param response
	 *            needed to add cookies
	 * @return the view to display
	 */
	@RequestMapping(value = "/{tab}/detalle", method = RequestMethod.GET)
	private String getDetailsOfCertificate(@PathVariable int tab,
			@RequestParam(value = "idMet", required = true) String idMetrica,
			@RequestParam(value = "idMes", required = true) String idMes, ModelMap model,
			HttpServletResponse response) {

		logger.info("[getDetailsOfCertificate] : INIT");

		// Abro el contexto para crear un DAO que dependerá de la pestaña en la
		// que estoy
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		if (tab == TAB_VAL_BUSSINESS_CERTIFICATE) {

			// En esta pestaña muestro los detalles de una certificación de
			// negocio
			BusinessCertificateDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate",
					BusinessCertificateDAO.class);
			ctx.close();

			// Obtengo las cabeceras que tiene la tabla de detalle de este
			// certificado. Son variables y dependen del certificado
			List<String> allHeaders = cdnDAO.getDetailHeaders(idMetrica, environment.getIdSistema(),
					environment.getIdSoftware());
			int numDims = allHeaders.size();
			// Por completitud, agrego headers STUB para rellenar hasta el
			// número máximo, aunque es prescindible
			while (allHeaders.size() < DetailOfCertificate.MAX_DIMENSIONES)
				allHeaders.add("_STUB");
			// Pongo todos los headers en la vista
			int aux_count = 0;
			for (String s : allHeaders) {
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}

			// Obtengo todos valores de cada columna de la tabla de detalle y
			// los pongo en la vista
			List<DetailOfCertificate> allDetallesDeCert = cdnDAO.getCertificateDetails(idMes, idMetrica, numDims,
					environment.getIdSistema(), environment.getIdSoftware());
			model.addAttribute("allTableItems", allDetallesDeCert);
			// Suelto una cookie con el número de dimensiones para que el
			// frontend sepa qué dimensiones (columnas de la tabla) mostrar: las
			// numDim primeras
			response.addCookie(new Cookie("numDims", String.valueOf(numDims)));

			logger.info("[getDetailsOfCertificate] : RETURN (from tab {})", tab);
			return VIEW_BUSINESS_CERTIFICATES_DETAIL;

		} else if (tab == TAB_VAL_TECHNICAL_CERTIFICATE) {

			// En esta pestaña muestro los detalles de una validación técnica
			// ATENCIÓN: el orden de los métodos es inverso al de la pestaña
			// anterior
			TechnicalCertificateDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate",
					TechnicalCertificateDAO.class);
			ctx.close();

			// Obtengo las cabeceras que tiene la tabla de detalle de este
			// certificado. Son variables y dependen del certificado
			List<DetailOfValidation> allDetallesDeVali = vtDAO.getDetallesDeValidacion(idMetrica, idMes);
			// ATENCIÓN: Hay que llamar a getDetallesDeValidacion antes de estos
			// dos métodos o no funcionrá como se espera!
			List<String> allHeaders = vtDAO.getHeaders();
			int numCols = vtDAO.getLastNumCols();
			// Pongo todos los headers en la vista
			int aux_count = 0;
			for (String s : allHeaders) {
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}
			// Pongo todos los detalles en la vista
			model.addAttribute("allTableItems", allDetallesDeVali);

			// Suelto una cookie con el número de dimensiones para que el
			// frontend sepa qué dimensiones (columnas de la tabla) mostrar: las
			// numCols primeras
			response.addCookie(new Cookie("numCols", String.valueOf(numCols)));

			logger.info("[getDetailsOfCertificate] : RETURN (from tab {})", tab);
			return VIEW_TECHNICAL_CERTIFICATES_DETAIL;

		} else {
			// Si no es ninguna de las pestañas anteriores, la página no existe
			ctx.close();
			logger.warn(
					"[getDetailsOfCertificate] : El usuario ha pedido una pestaña de certificaciones que no existe : {}",
					tab);
			logger.info("[getDetailsOfCertificate] : RETURN (from invalid tab {})", tab);
			return "redirect:/not-found";
		}

	}
}
