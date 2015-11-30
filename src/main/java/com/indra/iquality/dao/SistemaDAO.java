package com.indra.iquality.dao;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public interface SistemaDAO {

	// Para no crear una clase nueva con dos campos uso un Pair<String, String>
	// donde first = id_sistema y second = de_sistema
	public List<Pair<String, String>> getSistemas();
}
