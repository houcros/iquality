/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;
import java.util.Map;

import com.indra.iquality.model.Pase;
import com.indra.iquality.model.PaseDef;

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
public interface PaseDAO {

	/**
	 * Save.
	 *
	 * @param pase
	 *            the pase
	 */
	// Create
	public void save(Pase pase);

	/**
	 * New pase def.
	 *
	 * @param pd
	 *            the pd
	 * @param jobs
	 *            the jobs
	 * @param dependencias
	 *            the dependencias
	 */
	public void newPaseDef(PaseDef pd, String[] jobs, Map<String, String[]> dependencias);

	/**
	 * Obtiene el by id.
	 *
	 * @param id_ejecucion
	 *            the id_ejecucion
	 * @return el by id
	 */
	// Read
	public Pase getById(int id_ejecucion);

	/**
	 * Update.
	 *
	 * @param pase
	 *            the pase
	 */
	// Update
	public void update(Pase pase);

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
	public List<Pase> getAll() throws Exception;

	/**
	 * Obtiene el all defs.
	 *
	 * @return Todos las definiciones de pases del sistema y versión de software
	 *         actual
	 */
	public List<PaseDef> getAllDefs();
}
