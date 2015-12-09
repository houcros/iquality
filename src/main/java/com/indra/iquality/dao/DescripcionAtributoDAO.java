/*
 * 
 */
package com.indra.iquality.dao;

import com.indra.iquality.model.DescripcionAtributo;

// TODO: Auto-generated Javadoc
/**
 * The Interface DescripcionAtributoDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface DescripcionAtributoDAO.
 */
public interface DescripcionAtributoDAO {

	/**
	 * Obtiene el by id.
	 *
	 * @param compRowID the comp row id
	 * @param ctRowID the ct row id
	 * @return el by id
	 */
	public DescripcionAtributo getById(String compRowID, String ctRowID);
}
