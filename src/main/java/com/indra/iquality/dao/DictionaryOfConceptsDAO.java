/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

// TODO: Auto-generated Javadoc
/**
 * The Interface DictionaryOfConceptsDAO.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 * La Interface DictionaryOfConceptsDAO.
 */
public interface DictionaryOfConceptsDAO {

	/**
	 * Obtiene el all.
	 *
	 * @return el all
	 * @throws Exception the exception
	 */
	//Get All
	public List<GenericTreeNode<DictionaryConcept>> getAll ()  throws Exception;
}
