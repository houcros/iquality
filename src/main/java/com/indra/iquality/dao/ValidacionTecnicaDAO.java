package com.indra.iquality.dao;

import java.util.List;
import java.util.Map;

import com.indra.iquality.model.ValidacionTecnica;

public interface ValidacionTecnicaDAO {

	public List<ValidacionTecnica> getAll();

	public List<Map<String, Object>> getDetallesDeValidacion(String idMetrica, String idMes);
}
