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

import com.indra.iquality.dao.CertificacionDeNegocioDAO;
import com.indra.iquality.dao.ValidacionTecnicaDAO;
import com.indra.iquality.model.CertificacionDeNegocio;
import com.indra.iquality.model.DetalleDeCertificacion;
import com.indra.iquality.model.DetalleDeValidacion;
import com.indra.iquality.model.ValidacionTecnica;

@Controller
@RequestMapping("/resultado-certificaciones")
public class CertificatesResultController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CertificatesResultController.class);

	private static final String VIEW_INDEX = "index";
	private static final String VIEW_BUSINESS_CERTIFICATES = "certificaciones-de-negocio";
	private static final String VIEW_BUSINESS_CERTIFICATES_DETAIL = "certificaciones-de-negocio-detalle";
	private static final String VIEW_TECHNICAL_CERTIFICATES = "validaciones-tecnicas";
	private static final String VIEW_TECHNICAL_CERTIFICATES_DETAIL = "validaciones-tecnicas-detalle";
	private static final int TAB_VAL_BUSSINESS_CERTIFICATE = 1;
	private static final int TAB_VAL_TECHNICAL_CERTIFICATE = 2;

	@RequestMapping(value = "/{tab}", method = RequestMethod.GET)
	private String getCertificates(@PathVariable int tab, ModelMap model) {

		logger.info("[getCertificates] : INIT");

		// Abro el contexto para crear un DAO que dependerá de la pestaña en la
		// que estoy
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		if (tab == TAB_VAL_BUSSINESS_CERTIFICATE) {

			// En esta pestaña muestro las certificaciones de negocio
			CertificacionDeNegocioDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate",
					CertificacionDeNegocioDAO.class);
			ctx.close();
			// Obtengo todas las certificaciones y las paso a la vista
			List<CertificacionDeNegocio> allCertificaciones = cdnDAO.getAll();
			model.addAttribute("allTableItems", allCertificaciones);

			logger.info("[getCertificates] : RETURN (from tab {})", tab);
			return VIEW_BUSINESS_CERTIFICATES;

		} else if (tab == TAB_VAL_TECHNICAL_CERTIFICATE) {

			// En esta pestaña muestro las validaciones técnicas
			ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
			ctx.close();
			// Obtengo todas las validaciones y las paso a la vista
			List<ValidacionTecnica> allValidaciones = vtDAO.getAll();
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
			CertificacionDeNegocioDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate",
					CertificacionDeNegocioDAO.class);
			ctx.close();

			// Obtengo las cabeceras que tiene la tabla de detalle de este
			// certificado. Son variables y dependen del certificado
			List<String> allHeaders = cdnDAO.getHeadersDetalles(idMetrica);
			int numDims = allHeaders.size();
			// Por completitud, agrego headers STUB para rellenar hasta el
			// número máximo, aunque es prescindible
			while (allHeaders.size() < DetalleDeCertificacion.MAX_DIMENSIONES)
				allHeaders.add("_STUB");
			// Pongo todos los headers en la vista
			int aux_count = 0;
			for (String s : allHeaders) {
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}

			// Obtengo todos valores de cada columna de la tabla de detalle y
			// los pongo en la vista
			List<DetalleDeCertificacion> allDetallesDeCert = cdnDAO.getDetallesDeCertificacion(idMes, idMetrica,
					numDims);
			model.addAttribute("allTableItems", allDetallesDeCert);
			// Suelto una cookie con el número de dimensiones para que el
			// frontend sepa qué dimensiones (columnas de la tabla) mostrar: las
			// numDim primeras
			response.addCookie(new Cookie("numDims", String.valueOf(numDims)));

			logger.info("[getDetailsOfCertificate] : RETURN (from tab {})", tab);
			return VIEW_BUSINESS_CERTIFICATES_DETAIL;

		} else if (tab == TAB_VAL_TECHNICAL_CERTIFICATE) {

			// En esta pestaña muestro los detalles de una validación técnica
			ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
			ctx.close();

			// Obtengo las cabeceras que tiene la tabla de detalle de este
			// certificado. Son variables y dependen del certificado
			List<DetalleDeValidacion> allDetallesDeVali = vtDAO.getDetallesDeValidacion(idMetrica, idMes);

			int numCols = vtDAO.getLastNumCols();
			List<String> allHeaders = vtDAO.getHeaders();

			// Pongo los headers en el jsp
			int aux_count = 0;
			for (String s : allHeaders) {
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}

			model.addAttribute("allTableItems", allDetallesDeVali);

			response.addCookie(new Cookie("numCols", String.valueOf(numCols)));
			// logger.info(allValidaciones.get(0).toString());
			return VIEW_TECHNICAL_CERTIFICATES_DETAIL;
		} else {
			ctx.close();
			return VIEW_INDEX;
		}

	}
}
