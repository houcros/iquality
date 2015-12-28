/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Job. Represents an atomic operation of an ETL {@link Execution}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class Job.
 */
public class Job {

	// PK = jobID + executionID
	/** The job id. */
	private String jobID;

	/** The execution id. */
	private String executionID;

	/** The status. */
	private StatusEnum status;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The checkpoint. */
	private String checkpoint;

	/** The checkpoint last ok date. */
	private Date checkpointLastOKDate;

	/** The duration. */
	private String duration;

	/** The block id. */
	private String blockID;

	/** The block. */
	private String block;

	/** The system. */
	private String system;

	/** The software. */
	private int software;

	/** The register of operations of the job. */
	private List<RegisterOfOperation> regops;

	/** The dependencies of the job. */
	private List<Dependency> dependencies;

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	// Getters
	public String getJobID() {
		return jobID;
	}

	/**
	 * Gets the execution id.
	 *
	 * @return the execution id
	 */
	public String getExecutionID() {
		return executionID;
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
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
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
	 * Gets the checkpoint.
	 *
	 * @return the checkpoint
	 */
	public String getCheckpoint() {
		return checkpoint;
	}

	/**
	 * Gets the checkpoint last ok date.
	 *
	 * @return the checkpoint last ok date
	 */
	public Date getCheckpointLastOKDate() {
		return checkpointLastOKDate;
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
	 * Gets the block id.
	 *
	 * @return the block id
	 */
	public String getBlockID() {
		return blockID;
	}

	/**
	 * Gets the block.
	 *
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * Gets the sistema.
	 *
	 * @return the sistema
	 */
	public String getSistema() {
		return system;
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
	 * Sets the job id.
	 *
	 * @param jobID
	 *            the new job id
	 */
	// Setters
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	/**
	 * Sets the execution id.
	 *
	 * @param executionID
	 *            the new execution id
	 */
	public void setExecutionID(String executionID) {
		this.executionID = executionID;
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
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Sets the checkpoint.
	 *
	 * @param checkpoint
	 *            the new checkpoint
	 */
	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}

	/**
	 * Sets the checkpoint last ok date.
	 *
	 * @param checkpointLastOKDate
	 *            the new checkpoint last ok date
	 */
	public void setCheckpointLastOKDate(Date checkpointLastOKDate) {
		this.checkpointLastOKDate = checkpointLastOKDate;
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

	/**
	 * Sets the block id.
	 *
	 * @param blockID
	 *            the new block id
	 */
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}

	/**
	 * Sets the block.
	 *
	 * @param block
	 *            the new block
	 */
	public void setBlock(String block) {
		this.block = block;
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
	 * Sets the system.
	 *
	 * @param system
	 *            the new system
	 */
	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Job [id=" + jobID + ", estado=" + status + ", FechaInicio=" + startDate + ", FechaFin=" + endDate
				+ ", puntoDeControl=" + checkpoint + ", fechaOKPuntoDeControl=" + checkpointLastOKDate + ", duracion="
				+ duration + "]";
	}

}
