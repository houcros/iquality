/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface JobDAO.
 */
//CRUD operations
public interface JobDAO {
	
	/**
	 * Save.
	 *
	 * @param job the job
	 */
	//Create
	public void save(Job job);
	//Read
	/**
	 * Obtiene el by id.
	 *
	 * @param id_ejecucion the id_ejecucion
	 * @param id_job the id_job
	 * @return el by id
	 */
	/*
	 * id_ejecucion y id_job son la PK
	 * software y sistema son para el control de versiones de iQuality
	 */
	public Job getById(int id_ejecucion, String id_job);
	
	/**
	 * Update.
	 *
	 * @param job the job
	 */
	//Update
	public void update(Job job);
	//Delete
	/**
	 * Delete by id.
	 *
	 * @param id_ejecucion the id_ejecucion
	 * @param id_job the id_job
	 */
	/*
	 * id_ejecucion y id_job son la PK
	 * software y sistema son para el control de versiones de iQuality
	 */
	public void deleteById(int id_ejecucion, String id_job);
	
	/**
	 * Obtiene el all.
	 *
	 * @return el all
	 * @throws Exception the exception
	 */
	//Get All
	public List<Job> getAll () throws Exception;
	
	/**
	 * Obtiene el all.
	 *
	 * @param id_ejecucion the id_ejecucion
	 * @return el all
	 * @throws Exception the exception
	 */
	/*
	 * Obtener todos los jobs del pase con PK = id_ejecucion
	 * software y sistema son para el control de versiones de iQuality
	 */
	public List<Job> getAll (int id_ejecucion) throws Exception;
}
