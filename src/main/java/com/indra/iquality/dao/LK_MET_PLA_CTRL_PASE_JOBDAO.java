package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE_JOB;

//CRUD operations
public interface LK_MET_PLA_CTRL_PASE_JOBDAO {
	
	//Create
	public void save(LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job);
	//Read
	public LK_MET_PLA_CTRL_PASE_JOB getById(int id_ejecucion, String id_job);
	//Update
	public void update(LK_MET_PLA_CTRL_PASE_JOB lk_met_pla_ctrl_pase_job);
	//Delete
	public void deleteById(int id_ejecucion, String id_job);
	//Get All
	public List<LK_MET_PLA_CTRL_PASE_JOB> getAll();
}
