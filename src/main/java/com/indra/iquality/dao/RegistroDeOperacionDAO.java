package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.RegistroDeOperacion;

public interface RegistroDeOperacionDAO {

	/*
	 * Obtener todos los registros de operaciones del job con 
	 * PK = id_job + id_ejecucion
	 * software y sistema son para el control de versiones de iQuality
	 */
	public List<RegistroDeOperacion> getAll (int idEjecucion, String idJob) throws Exception;
	
}
