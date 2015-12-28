/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Class Dependency. Represents a dependency among two jobs.
 * 
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class Dependency.
 */
public class Dependency {

	/** The execution id. */
	private int executionID;

	/** The system. */
	private String system;

	/** The software. */
	private int software;

	/** The flow id. */
	private int flowID;

	/** The father job id. */
	private String fatherJobID;

	/** The son job id. */
	private String sonJobID;

	/** The habilitatted sn. */
	private String habilitattedSN;

	/** The status. */
	private StatusEnum status;

	/**
	 * Gets the id ejecucion.
	 *
	 * @return the id ejecucion
	 */
	public int getIdEjecucion() {
		return executionID;
	}

	/**
	 * Sets the execution id.
	 *
	 * @param executionID
	 *            the new execution id
	 */
	public void setExecutionID(int executionID) {
		this.executionID = executionID;
	}

	/**
	 * Gets the system.
	 *
	 * @return the system
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * Sets the system.
	 *
	 * @param system
	 *            the new system
	 */
	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * Gets the software.
	 *
	 * @return the software
	 */
	public int getSoftware() {
		return software;
	}

	/**
	 * Sets the software.
	 *
	 * @param software
	 *            the new software
	 */
	public void setSoftware(int software) {
		this.software = software;
	}

	/**
	 * Gets the flow id.
	 *
	 * @return the flow id
	 */
	public int getFlowID() {
		return flowID;
	}

	/**
	 * Sets the flow id.
	 *
	 * @param flowID
	 *            the new flow id
	 */
	public void setFlowID(int flowID) {
		this.flowID = flowID;
	}

	/**
	 * Gets the father job id.
	 *
	 * @return the father job id
	 */
	public String getFatherJobID() {
		return fatherJobID;
	}

	/**
	 * Sets the father job id.
	 *
	 * @param fatherJobID
	 *            the new father job id
	 */
	public void setFatherJobID(String fatherJobID) {
		this.fatherJobID = fatherJobID;
	}

	/**
	 * Gets the son job id.
	 *
	 * @return the son job id
	 */
	public String getSonJobID() {
		return sonJobID;
	}

	/**
	 * Sets the son job id.
	 *
	 * @param sonJobID
	 *            the new son job id
	 */
	public void setSonJobID(String sonJobID) {
		this.sonJobID = sonJobID;
	}

	/**
	 * Gets the if it is habilitatted.
	 *
	 * @return the habilitatted sn
	 */
	public String getHabilitattedSN() {
		return habilitattedSN;
	}

	/**
	 * Sets the habilitatted state.
	 *
	 * @param habilitattedSN
	 *            the new habilitatted sn
	 */
	public void setHabilitattedSN(String habilitattedSN) {
		this.habilitattedSN = habilitattedSN;
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
