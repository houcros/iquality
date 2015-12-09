/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DetalleDeValidacion;
import com.indra.iquality.model.ValidacionTecnica;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValidacionTecnicaDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface ValidacionTecnicaDAO.
 */
public interface ValidacionTecnicaDAO {

	/**
	 * Obtiene el all.
	 *
	 * @return el all
	 */
	public List<ValidacionTecnica> getAll();

	/**
	 * Obtiene el detalles de validacion.
	 *
	 * @param idMetrica the id metrica
	 * @param idMes the id mes
	 * @return el detalles de validacion
	 */
	public List<DetalleDeValidacion> getDetallesDeValidacion(String idMetrica, String idMes);

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
