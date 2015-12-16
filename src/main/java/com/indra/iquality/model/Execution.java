/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;

/**
 * The Class Execution. Represent an instance of an ETL {@link Flow} for a given
 * date.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class Execution.
 */
public class Execution {

	/** The id. */
	private int id;

	/** The flow. */
	private String flow;

	/** The status. */
	private String status;

	/** The date of data. */
	private String dataDate;

	/** The scenario. */
	private String scenario;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The planned date. */
	private Date plannedDate;

	/** The software. */
	private String software;

	/** The duration. */
	private String duration;

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
	 * Gets the flow.
	 *
	 * @return the flow
	 */
	public String getFlow() {
		return flow;
	}

	/**
	 * Sets the flow.
	 *
	 * @param flow
	 *            the new flow
	 */
	public void setFlow(String flow) {
		this.flow = flow;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the date of data.
	 *
	 * @return the date of data
	 */
	public String getDataDate() {
		return dataDate;
	}

	/**
	 * Sets the date of data.
	 *
	 * @param dataDate
	 *            the new date of data
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	public String getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario
	 *            the new scenario
	 */
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the planned date.
	 *
	 * @return the planned date
	 */
	public Date getPlannedDate() {
		return plannedDate;
	}

	/**
	 * Sets the planned date.
	 *
	 * @param plannedDate
	 *            the new planned date
	 */
	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	/**
	 * Gets the software.
	 *
	 * @return the software
	 */
	public String getSoftware() {
		return software;
	}

	/**
	 * Sets the software.
	 *
	 * @param software
	 *            the new software
	 */
	public void setSoftware(String software) {
		this.software = software;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration
	 *            the new duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pase [idEjecucion=" + id + ", pase=" + flow + ", estado=" + status + ", fechaDatos=" + dataDate
				+ ", escenario=" + scenario + ", fechaInicio=" + startDate + ", fechaFin=" + endDate
				+ ", fechaPlanificada=" + plannedDate + ", software=" + software + ", duracion=" + duration + "]";
	}

}