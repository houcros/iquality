package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.TrazaDeRegistro;

public interface TrazaDeRegistroDAO {

	public List<TrazaDeRegistro> getAll(int idOperacion) throws Exception;
}
