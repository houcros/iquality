package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.ValidacionTecnica;

public interface ValidacionTecnicaDAO {

	public List<ValidacionTecnica> getAll();

	String getQuery(String idMetrica, String idMes);
}
