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
public class ResultadoCertificacionesController {

	private static final String VIEW_INDEX = "index";
	private static final String VIEW_CERTIFICACIONES_DE_NEGOCIO = "certificaciones-de-negocio";
	private static final String VIEW_CERTIFICACIONES_DE_NEGOCIO_DETALLE = "certificaciones-de-negocio-detalle";
	private static final String VIEW_VALIDACIONES_TECNICAS = "validaciones-tecnicas";
	private static final String VIEW_VALIDACIONES_TECNICAS_DETALLE = "validaciones-tecnicas-detalle";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ResultadoCertificacionesController.class);
	
	@RequestMapping(value = "/{tab}", method = RequestMethod.GET)
	private String getCertificaciones(@PathVariable int tab, ModelMap model){
		
		logger.debug("getCertificaciones : Called route");
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
//		if(tab == null || tab == 1){
		if(tab == 1){
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
			
			// DEBUG
//			for (ValidacionTecnica validacion : allValidaciones)
//				logger.debug(validacion.toString());
			
			return VIEW_VALIDACIONES_TECNICAS;
		}
		else{
			ctx.close();
			return VIEW_INDEX;
		}

	}
	
	@RequestMapping(value = "/{tab}/detalle", method = RequestMethod.GET)
	private String getDetalleCertificaciones(@PathVariable int tab, 
			@RequestParam (value = "idMet", required = true) String idMetrica, 
			@RequestParam (value = "idMes", required = true) String idMes, 
			ModelMap model, HttpServletResponse response){
		
		logger.debug("getDetalleCertificaciones : Called route");
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		if(tab == 1){
			CertificacionDeNegocioDAO cdnDAO = ctx.getBean("certificacionDeNegocioDAOJDBCTemplate", CertificacionDeNegocioDAO.class);
			List<String> allHeaders= cdnDAO.getHeadersDetalles(idMetrica);
			int numDims = allHeaders.size();
			
			// Pongo los headers que tengo
			while(allHeaders.size() < DetalleDeCertificacion.MAX_DIMENSIONES) allHeaders.add("_STUB");
			int aux_count = 0;
			for(String s : allHeaders){
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}
			
			List<DetalleDeCertificacion> allDetallesDeCert = cdnDAO.getDetallesDeCertificacion(idMes, idMetrica, numDims);
			model.addAttribute("allTableItems", allDetallesDeCert);
			ctx.close();

			response.addCookie(new Cookie("numDims", String.valueOf(numDims)));
//			logger.info(allCertificaciones.get(0).toString());
			return VIEW_CERTIFICACIONES_DE_NEGOCIO_DETALLE;
		}
		else if (tab == 2){
			
			ValidacionTecnicaDAO vtDAO = ctx.getBean("validacionTecnicaDAOJDBCTemplate", ValidacionTecnicaDAO.class);
			List<DetalleDeValidacion> allDetallesDeVali= vtDAO.getDetallesDeValidacion(idMetrica, idMes);
			ctx.close();
			
			int numCols = vtDAO.getLastNumCols();
			List<String> allHeaders = vtDAO.getHeaders();
			
			// Pongo los headers en el jsp
			int aux_count = 0;
			for(String s : allHeaders){
				String aux = "headerDim" + String.valueOf(++aux_count);
				model.addAttribute(aux, s);
			}
			
			model.addAttribute("allTableItems", allDetallesDeVali);
			
			response.addCookie(new Cookie("numCols", String.valueOf(numCols)));
//			logger.info(allValidaciones.get(0).toString());
			return VIEW_VALIDACIONES_TECNICAS_DETALLE;
		}
		else{
			ctx.close();
			return VIEW_INDEX;
		}

	}
}
