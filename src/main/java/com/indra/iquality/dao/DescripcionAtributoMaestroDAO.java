package com.indra.iquality.dao;

import com.indra.iquality.model.DescripcionAtributoMaestro;

public interface DescripcionAtributoMaestroDAO extends DescripcionAtributoDAO {

	public DescripcionAtributoMaestro getById(String compRowID, String ctRowID);
}
