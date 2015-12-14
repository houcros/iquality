/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.RegisterTrace;

// TODO: Auto-generated Javadoc
/**
 * The Interface TrazaDeRegistroDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface TrazaDeRegistroDAO.
 */
public interface TraceOfRegisterDAO {

	/**
	 * Obtiene el all.
	 *
	 * @param idOperacion the id operacion
	 * @return el all
	 * @throws Exception the exception
	 */
	public List<RegisterTrace> getAll(int idOperacion) throws Exception;
}
