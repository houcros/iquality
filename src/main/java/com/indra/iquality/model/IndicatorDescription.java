/*
 * 
 */
package com.indra.iquality.model;

import java.util.List;

/**
 * The Class IndicatorDescription. Represents the description of an indicator
 * element in the dictionary of concepts.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class IndicatorDescription.
 */
public class IndicatorDescription extends ComponentDescription {

	// Datos básicos indicador
	/** The measure units. */
	private String measureUnits;
	/** The acummulated period. */
	private String acummulatedPeriod;

	/** The certificates. */
	// Datos certificacion indicador
	private List<String> certificates;

	/**
	 * Gets the measure unit.
	 *
	 * @return the measure unit
	 */
	public String getMeasureUnit() {
		return measureUnits;
	}

	/**
	 * Sets the measure unit.
	 *
	 * @param measureUnits
	 *            the new measure unit
	 */
	public void setMeasureUnit(String measureUnits) {
		this.measureUnits = measureUnits;
	}

	/**
	 * Gets the acummulated period.
	 *
	 * @return the acummulated period
	 */
	public String getAcummulatedPeriod() {
		return acummulatedPeriod;
	}

	/**
	 * Sets the acummulated period.
	 *
	 * @param acummulatedPeriod
	 *            the new acummulated period
	 */
	public void setAcummulatedPeriod(String acummulatedPeriod) {
		this.acummulatedPeriod = acummulatedPeriod;
	}

	/**
	 * Gets the certificates.
	 *
	 * @return the certificates
	 */
	public List<String> getCertificates() {
		return certificates;
	}

	/**
	 * Sets the certificates.
	 *
	 * @param certificates
	 *            the new certificates
	 */
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}

}
