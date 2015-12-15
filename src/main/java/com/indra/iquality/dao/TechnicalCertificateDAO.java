/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DetailOfValidation;
import com.indra.iquality.model.TechnicalCertificate;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValidacionTecnicaDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          La Interface ValidacionTecnicaDAO.
 */
public interface TechnicalCertificateDAO {

	/**
	 * Obtiene el all.
	 *
	 * @return el all
	 */
	public List<TechnicalCertificate> getAll(String sistema, int software);

	/**
	 * Obtiene el detalles de validacion.
	 *
	 * @param idMetrica
	 *            the id metrica
	 * @param idMes
	 *            the id mes
	 * @return el detalles de validacion
	 */
	public List<DetailOfValidation> getDetallesDeValidacion(String idMetrica, String idMes);

	/**
	 * Obtiene el last num cols.
	 *
	 * @return el last num cols
	 */
	public int getLastNumCols();

	/**
	 * Obtiene el headers.
	 *
	 * @return el headers
	 */
	public List<String> getHeaders();
}
