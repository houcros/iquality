package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DetalleDeValidacion;
import com.indra.iquality.model.ValidacionTecnica;

public interface ValidacionTecnicaDAO {

	public List<ValidacionTecnica> getAll();

	public List<DetalleDeValidacion> getDetallesDeValidacion(String idMetrica, String idMes);

	public int getLastNumCols();

	public List<String> getHeaders();
}
