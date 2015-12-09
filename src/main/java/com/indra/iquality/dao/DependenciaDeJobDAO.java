/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DependenciaDeJob;

// TODO: Auto-generated Javadoc
/**
 * The Interface DependenciaDeJobDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface DependenciaDeJobDAO.
 */
public interface DependenciaDeJobDAO {

	/**
	 * Obtiene el all.
	 *
	 * @param idEjecucion the id ejecucion
	 * @param idJob the id job
	 * @return el all
	 */
	public List<DependenciaDeJob> getAll(int idEjecucion, String idJob);
}
