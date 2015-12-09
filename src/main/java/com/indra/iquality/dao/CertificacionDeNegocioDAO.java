/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.CertificacionDeNegocio;
import com.indra.iquality.model.DetalleDeCertificacion;

// TODO: Auto-generated Javadoc
/**
 * The Interface to interact with the persistent representations of business
 * certifications. See {@link com.indra.iquality.model.CertificacionDeNegocio}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 */
public interface CertificacionDeNegocioDAO {

	/**
	 * Gets all the records of business certifications.
	 * 
	 * @return all the business certifications for the current system and
	 *         software version
	 * 
	 */
	public List<CertificacionDeNegocio> getAll();

	/**
	 * Gets the headers of the required fields to represent a detailed view of a
	 * CertificacionDeNegocio. Headers are dynamic, i.e., their content and
	 * amount may vary for different instances of CertificacionDeNegocio.
	 *
	 * @param idMetrica
	 *            the identifier for an instance of CertificacionDeNegocio
	 * @return a list of headers for the detailed view
	 */
	public List<String> getHeadersDetalles(String idMetrica);

	/**
	 * Gets the details for an instance of CertificacionDeNegocio.
	 *
	 * @param idMes
	 *            the month for which we want the details
	 * @param idMetrica
	 *            the identifier for an instance of CertificacionDeNegocio
	 * @param qttHeaders
	 *            the amount of fields the detailed view has; see
	 *            {@link #getHeadersDetalles(String idMetrica)}
	 * 
	 * @return a list of all the details of a business certification
	 */
	public List<DetalleDeCertificacion> getDetallesDeCertificacion(String idMes, String idMetrica, int qttHeaders);
}
