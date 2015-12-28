/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class DictionaryConcept. Represents a concept of the dictionary.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class DictionaryConcept.
 */
public class DictionaryConcept {

	/** The concept. */
	private String concept;

	/** The level. */
	private int level;

	/** The status. */
	private int status;

	/** The type. */
	private ConceptTypeEnum type;

	/** The Oracle rowID of the component. */
	private String compRowID;

	/** The Oracle rowID of the ct(?). */
	private String ctRowID;

	/**
	 * The description of the concept, if it is an attribute or an indicator.
	 */
	private ComponentDescription description;

	/**
	 * Instantiates a new dictionary concept.
	 */
	public DictionaryConcept() {
		super();
	}

	/**
	 * Instantiates a new dictionary concept.
	 *
	 * @param concept
	 *            the concept
	 */
	public DictionaryConcept(String concept) {
		this.concept = concept;
	}

	/**
	 * Instantiates a new dictionary concept.
	 *
	 * @param concept
	 *            the concept
	 * @param level
	 *            the level
	 */
	public DictionaryConcept(String concept, int level) {
		this.concept = concept;
		this.level = level;
	}

	/**
	 * Instantiates a new dictionary concept.
	 *
	 * @param concept
	 *            the concept
	 * @param level
	 *            the level
	 * @param status
	 *            the status
	 * @param tipo
	 *            the tipo
	 */
	public DictionaryConcept(String concept, int level, int status, ConceptTypeEnum tipo) {
		this.concept = concept;
		this.level = level;
		this.status = status;
		this.type = tipo;
		this.compRowID = "NULL";
		this.ctRowID = "NULL";
	}

	/**
	 * Instantiates a new dictionary concept.
	 *
	 * @param concept
	 *            the concept
	 * @param level
	 *            the level
	 * @param status
	 *            the status
	 * @param tipo
	 *            the tipo
	 * @param compRowID
	 *            the comp row id
	 * @param ctRowID
	 *            the ct row id
	 */
	public DictionaryConcept(String concept, int level, int status, ConceptTypeEnum tipo, String compRowID,
			String ctRowID) {
		this.concept = concept;
		this.level = level;
		this.status = status;
		this.type = tipo;
		this.compRowID = compRowID;
		this.ctRowID = ctRowID;
	}

	/**
	 * Gets the concept.
	 *
	 * @return the concept
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * Sets the concept.
	 *
	 * @param concept
	 *            the new concept
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ConceptTypeEnum getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(ConceptTypeEnum type) {
		this.type = type;
	}

	/**
	 * Gets the Oracle rowID of the component
	 *
	 * @return the rowID
	 */
	public String getCompRowID() {
		return compRowID;
	}

	/**
	 * Sets the Oracle rowID of the component
	 *
	 * @param compRowID
	 *            the new rowID
	 */
	public void setCompRowID(String compRowID) {
		this.compRowID = compRowID;
	}

	/**
	 * Gets the Oracle rowID of the ct(?)
	 *
	 * @return the rowID
	 */
	public String getCtRowID() {
		return ctRowID;
	}

	/**
	 * Sets the Oracle rowID of the ct(?)
	 *
	 * @param ctRowID
	 *            the new rowID
	 */
	public void setCtRowID(String ctRowID) {
		this.ctRowID = ctRowID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DictionaryConcept [concept=" + concept + ", level=" + level + ", status=" + status + ", tipo=" + type
				+ "]";
	}

}
