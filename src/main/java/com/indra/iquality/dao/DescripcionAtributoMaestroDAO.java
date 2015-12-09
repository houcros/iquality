/*
 * 
 */
package com.indra.iquality.dao;

import com.indra.iquality.model.DescripcionAtributoMaestro;

// TODO: Auto-generated Javadoc
/**
 * The Interface DescripcionAtributoMaestroDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface DescripcionAtributoMaestroDAO.
 */
public interface DescripcionAtributoMaestroDAO extends DescripcionAtributoDAO {

	/* (non-Javadoc)
	 * @see com.indra.iquality.dao.DescripcionAtributoDAO#getById(java.lang.String, java.lang.String)
	 */
	public DescripcionAtributoMaestro getById(String compRowID, String ctRowID);
}
