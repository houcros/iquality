/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class MasterAttributeDescription. Represents the description of an master
 * attribute element in the dictionary of concepts.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class MasterAttributeDescription.
 */
public class MasterAttributeDescription extends AttributeDescription {

	// Datos entidad maestro del atributo
	/** The history master. */
	private String historyMaster;
	/** The update period master. */
	private String updatePeriodMaster;
	/** The update type master. */
	private String updateTypeMaster;
	/** The obtention method master. */
	private String obtentionMethodMaster;

	/**
	 * Instantiates a new master attribute description from an attribute
	 * description.
	 *
	 * @param da
	 *            the attribute description
	 */
	public MasterAttributeDescription(AttributeDescription da) {
		this.name = da.getName();
		this.responsible = da.getResponsible();
		this.definition = da.getDefinition();
		this.comments = da.getComments();
		this.history = da.getHistory();
		this.obtentionMethod = da.getObtentionMethod();

		this.format = da.getFormat();
		this.updatePeriod = da.getUpdatePeriod();
		this.updateType = da.getUpdateType();
	}

	/**
	 * Instantiates a new master attribute description.
	 */
	public MasterAttributeDescription() {
		super();
	}

	/**
	 * Gets the history master.
	 *
	 * @return the history master
	 */
	public String getHistoryMaster() {
		return historyMaster;
	}

	/**
	 * Sets the history master.
	 *
	 * @param historyMaster
	 *            the new history master
	 */
	public void setHistoryMaster(String historyMaster) {
		this.historyMaster = historyMaster;
	}

	/**
	 * Gets the update period master.
	 *
	 * @return the update period master
	 */
	public String getUpdatePeriodMaster() {
		return updatePeriodMaster;
	}

	/**
	 * Sets the update period master.
	 *
	 * @param updatePeriodMaster
	 *            the new update period master
	 */
	public void setUpdatePeriodMaster(String updatePeriodMaster) {
		this.updatePeriodMaster = updatePeriodMaster;
	}

	/**
	 * Gets the update type master.
	 *
	 * @return the update type master
	 */
	public String getUpdateTypeMaster() {
		return updateTypeMaster;
	}

	/**
	 * Sets the update type master.
	 *
	 * @param updateTypeMaster
	 *            the new update type master
	 */
	public void setUpdateTypeMaster(String updateTypeMaster) {
		this.updateTypeMaster = updateTypeMaster;
	}

	/**
	 * Gets the obtention method master.
	 *
	 * @return the obtention method master
	 */
	public String getObtentionMethodMaster() {
		return obtentionMethodMaster;
	}

	/**
	 * Sets the obtention method master.
	 *
	 * @param obtentionMethodMaster
	 *            the new obtention method master
	 */
	public void setObtentionMethodMaster(String obtentionMethodMaster) {
		this.obtentionMethodMaster = obtentionMethodMaster;
	}
}
