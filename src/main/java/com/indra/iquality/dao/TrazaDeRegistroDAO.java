/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.TrazaDeRegistro;

// TODO: Auto-generated Javadoc
/**
 * The Interface TrazaDeRegistroDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface TrazaDeRegistroDAO.
 */
public interface TrazaDeRegistroDAO {

	/**
	 * Obtiene el all.
	 *
	 * @param idOperacion the id operacion
	 * @return el all
	 * @throws Exception the exception
	 */
	public List<TrazaDeRegistro> getAll(int idOperacion) throws Exception;
}
