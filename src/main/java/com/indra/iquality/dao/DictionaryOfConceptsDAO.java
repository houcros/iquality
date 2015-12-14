/*
 * 
 */
package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.DescriptionOfAttribute;
import com.indra.iquality.model.DescripcionAtributoMaestro;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

/**
 * The Interface to interact with the persistent representations of the
 * dictionary of concepts, as well as the attributes and indicators that
 * integrate it.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Interface DictionaryOfConceptsDAO.
 */
public interface DictionaryOfConceptsDAO {

	/**
	 * Gets all the concepts of the dictionary for a given system and software
	 * version.
	 *
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return all the concepts in the dictionary
	 */
	public List<GenericTreeNode<DictionaryConcept>> getAllConcepts(String sistema, int software);

	/**
	 * Gets the description of an attribute component of the dictionary for a
	 * given system and software version.
	 *
	 * @param compRowID
	 *            the rowID of the component
	 * @param ctRowID
	 *            the rowID of the ct
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the description of the attribute
	 */
	public DescriptionOfAttribute getDescriptionOfAttribute(String compRowID, String ctRowID, String sistema,
			int software);

	/**
	 * Gets the description of a master attribute component of the dictionary
	 * for a given system and software version.
	 *
	 * @param compRowID
	 *            the rowID of the component
	 * @param ctRowID
	 *            the rowID of the ct
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the description of the master attribute
	 */
	public DescripcionAtributoMaestro getDescriptionOfMasterAttribute(String compRowID, String ctRowID, String sistema,
			int software);

	/**
	 * Gets the description of an indicator component of the dictionary for a
	 * given system and software version.
	 *
	 * @param compRowID
	 *            the rowID of the component
	 * @param ctRowID
	 *            the rowID of the ct
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the description of the indicator
	 */
	public DescripcionIndicador getDescriptionOfIndicator(String compRowID, String ctRowID, String sistema,
			int software);
}
