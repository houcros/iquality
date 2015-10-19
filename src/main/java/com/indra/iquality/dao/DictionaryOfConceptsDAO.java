package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

public interface DictionaryOfConceptsDAO {

	//Get All
	public List<GenericTreeNode<DictionaryConcept>> getAll ()  throws Exception;
}
