/*
 * 
 */
package com.indra.iquality.dao;

import com.indra.iquality.model.DescripcionIndicador;

// TODO: Auto-generated Javadoc
/**
 * The Interface DescripcionIndicadorDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface DescripcionIndicadorDAO.
 */
public interface DescripcionIndicadorDAO {

	/**
	 * Obtiene el by id.
	 *
	 * @param compRowID the comp row id
	 * @param ctRowID the ct row id
	 * @return el by id
	 */
	public DescripcionIndicador getById(String compRowID, String ctRowID);
}
