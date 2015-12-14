/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.RegisterOfOperation;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegistroDeOperacionDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface RegistroDeOperacionDAO.
 */
public interface RegisterOfOperationsDAO {

	/**
	 * Obtiene el all.
	 *
	 * @param idEjecucion the id ejecucion
	 * @param idJob the id job
	 * @return el all
	 * @throws Exception the exception
	 */
	/*
	 * Obtener todos los registros de operaciones del job con 
	 * PK = id_job + id_ejecucion
	 * software y sistema son para el control de versiones de iQuality
	 */
	public List<RegisterOfOperation> getAll (int idEjecucion, String idJob) throws Exception;
	
}
