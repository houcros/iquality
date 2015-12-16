/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class AttributeDescription. Represents the description of an attribute
 * element in the dictionary of concepts.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class AttributeDescription.
 */
public class AttributeDescription extends ComponentDescription {

	// Datos básicos atributo
	/** The format. */
	protected String format;

	// Datos entidad atributo
	/** The update period. */
	protected String updatePeriod;
	/** The update type. */
	protected String updateType;

	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format
	 *            the new format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Gets the update period.
	 *
	 * @return the update period
	 */
	public String getUpdatePeriod() {
		return updatePeriod;
	}

	/**
	 * Sets the uodate period.
	 *
	 * @param updatePeriod
	 *            the new uodate period
	 */
	public void setUodatePeriod(String updatePeriod) {
		this.updatePeriod = updatePeriod;
	}

	/**
	 * Gets the update type.
	 *
	 * @return the update type
	 */
	public String getUpdateType() {
		return updateType;
	}

	/**
	 * Sets the update type.
	 *
	 * @param updateType
	 *            the new update type
	 */
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
}
