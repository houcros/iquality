package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE;

//CRUD operations
public interface LK_MET_PLA_CTRL_PASEDAO {
	
	//Create
	public void save(LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase);
	//Read
	public LK_MET_PLA_CTRL_PASE getById(int id_ejecucion);
	//Update
	public void update(LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase);
	//Delete
	public void deleteById(int id_ejecucion);
	//Get All
	public List<LK_MET_PLA_CTRL_PASE> getAll();
}
