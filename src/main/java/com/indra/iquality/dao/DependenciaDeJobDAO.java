package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DependenciaDeJob;

public interface DependenciaDeJobDAO {

	public List<DependenciaDeJob> getAll(int idEjecucion, String idJob);
}
