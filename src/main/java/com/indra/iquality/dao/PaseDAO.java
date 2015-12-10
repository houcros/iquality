/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;
import java.util.Map;

import com.indra.iquality.model.Pase;

// TODO: Auto-generated Javadoc
/**
 * The Interface PaseDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          The Interface PaseDAO.
 */
// CRUD operations
public interface PaseDAO {

	/**
	 * Obtiene el all defs.
	 *
	 * @return Todos las definiciones de pases del sistema y versión de software
	 *         actual
	 */
	public List<Pase> getAllDefs();

	public void newPaseDef(Pase pd, String[] jobs, Map<String, String[]> dependencias);
}
