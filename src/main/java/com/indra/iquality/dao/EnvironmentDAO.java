/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

// TODO: Auto-generated Javadoc
/**
 * The Interface SistemaDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface SistemaDAO.
 */
public interface EnvironmentDAO {

	// Para no crear una clase nueva con dos campos uso un Pair<String, String>
	/**
	 * Obtiene el sistemas.
	 *
	 * @return el sistemas
	 */
	// donde first = id_sistema y second = de_sistema
	public List<Pair<String, String>> getSistemas();
}
