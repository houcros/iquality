package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Job;

//CRUD operations
public interface JobDAO {
	
	//Create
	public void save(Job job);
	//Read
	/*
	 * id_ejecucion y id_job son la PK
	 * software y sistema son para el control de versiones de iQuality
	 */
	public Job getById(int id_ejecucion, String id_job);
	//Update
	public void update(Job job);
	//Delete
	/*
	 * id_ejecucion y id_job son la PK
	 * software y sistema son para el control de versiones de iQuality
	 */
	public void deleteById(int id_ejecucion, String id_job);
	//Get All
	public List<Job> getAll () throws Exception;
	/*
	 * Obtener todos los jobs del pase con PK = id_ejecucion
	 * software y sistema son para el control de versiones de iQuality
	 */
	public List<Job> getAll (int id_ejecucion) throws Exception;
}
