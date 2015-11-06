package com.indra.iquality.dao;

import com.indra.iquality.model.DescripcionComponente;

public interface DescripcionComponenteDAO {

	//Read
	public DescripcionComponente getById(String compRowID, String ctRowID);
}
