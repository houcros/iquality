/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class ComponentDescription. Represents the fields that any component
 * description of a dictionary element should have.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class ComponentDescription.
 */
public abstract class ComponentDescription {

	/** The id. */
	// Datos básicos comunes
	protected int id;

	/** The name. */
	protected String name;

	/** The responsible. */
	protected String responsible;

	/** The definition. */
	protected String definition;

	/** The comments. */
	protected String comments;

	/** The history. */
	// Datos entidad comunes
	protected String history;

	/** The obtention method. */
	protected String obtentionMethod;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the responsible.
	 *
	 * @return the responsible
	 */
	public String getResponsible() {
		return responsible;
	}

	/**
	 * Sets the responsible.
	 *
	 * @param responsible
	 *            the new responsible
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	/**
	 * Gets the definition.
	 *
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * Sets the definition.
	 *
	 * @param definition
	 *            the new definition
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments
	 *            the new comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Gets the history.
	 *
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * Sets the history.
	 *
	 * @param history
	 *            the new history
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	/**
	 * Gets the obtention method.
	 *
	 * @return the obtention method
	 */
	public String getObtentionMethod() {
		return obtentionMethod;
	}

	/**
	 * Sets the obtention method.
	 *
	 * @param obtentionMethod
	 *            the new obtention method
	 */
	public void setObtentionMethod(String obtentionMethod) {
		this.obtentionMethod = obtentionMethod;
	}

}
