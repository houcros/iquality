/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class Certificate. Abstract representation with the fields that a
 * certificate must have.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class Certificate.
 */
public abstract class Certificate {

	/** The metric. */
	protected String metric;

	/** The month. */
	protected String month;

	/** The date. */
	protected String date;

	/** The section. */
	protected String section;

	/** The subsection. */
	protected String subsection;

	/** The entity. */
	protected String entity;

	/** The certificate. */
	protected String certificate;

	/** The certificate description. */
	protected String certificateDescription;

	/** The status. */
	protected StatusEnum status;

	/**
	 * Gets the metric.
	 *
	 * @return the metric
	 */
	public String getMetric() {
		return metric;
	}

	/**
	 * Sets the id metrica.
	 *
	 * @param metric
	 *            the new id metrica
	 */
	public void setIdMetrica(String metric) {
		this.metric = metric;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Sets the month.
	 *
	 * @param month
	 *            the new month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the section.
	 *
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets the section.
	 *
	 * @param section
	 *            the new section
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * Gets the subsection.
	 *
	 * @return the subsection
	 */
	public String getSubsection() {
		return subsection;
	}

	/**
	 * Sets the subsection.
	 *
	 * @param subsection
	 *            the new subsection
	 */
	public void setSubsection(String subsection) {
		this.subsection = subsection;
	}

	/**
	 * Gets the entity.
	 *
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * Sets the entity.
	 *
	 * @param entity
	 *            the new entity
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * Gets the certificate.
	 *
	 * @return the certificate
	 */
	public String getCertificate() {
		return certificate;
	}

	/**
	 * Sets the certificate.
	 *
	 * @param certificate
	 *            the new certificate
	 */
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	/**
	 * Gets the certificate description.
	 *
	 * @return the certificate description
	 */
	public String getCertificateDescription() {
		return certificateDescription;
	}

	/**
	 * Sets the certificate description.
	 *
	 * @param certificateDescription
	 *            the new certificate description
	 */
	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status.toString();
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = StatusEnum.valueOf(status);
	}
}
