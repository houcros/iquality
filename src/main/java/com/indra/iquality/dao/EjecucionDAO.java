/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Ejecucion;

// TODO: Auto-generated Javadoc
/**
 * The Interface PaseDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          La Interface PaseDAO.
 */
// CRUD operations
public interface EjecucionDAO {

	/**
	 * Save.
	 *
	 * @param pase
	 *            the pase
	 */
	// Create
	public void save(Ejecucion pase);

	/**
	 * Obtiene el by id.
	 *
	 * @param id_ejecucion
	 *            the id_ejecucion
	 * @return el by id
	 */
	// Read
	public Ejecucion getById(int id_ejecucion);

	/**
	 * Update.
	 *
	 * @param pase
	 *            the pase
	 */
	// Update
	public void update(Ejecucion pase);

	/**
	 * Delete by id.
	 *
	 * @param id_ejecucion
	 *            the id_ejecucion
	 */
	// Delete
	public void deleteById(int id_ejecucion);

	// Get All
	/**
	 * Obtiene el all.
	 *
	 * @return Todos los pases (ejecuciones) del sistema y versión de software
	 *         actual
	 * @throws Exception
	 *             the exception
	 */
	public List<Ejecucion> getAll() throws Exception;

}
