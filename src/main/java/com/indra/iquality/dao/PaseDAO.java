package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.Pase;
import com.indra.iquality.model.PaseDef;

//CRUD operations
public interface PaseDAO {
	
	//Create
	public void save(Pase pase);
	//Read
	public Pase getById(int id_ejecucion);
	//Update
	public void update(Pase pase);
	//Delete
	public void deleteById(int id_ejecucion);
	//Get All
	public List<Pase> getAll()  throws Exception;
	
	public List<PaseDef> getAllDefs();
}
