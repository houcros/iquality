/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;
import java.util.List;

/**
 * The Class RegisterOfOperation. Represents the register of operation of a
 * {@link Job}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class RegisterOfOperation.
 */
public class RegisterOfOperation {

	/** The operation row id. */
	private String operationRowID;

	/** The final row id. */
	private String finalRowID;

	/** The operation id. */
	private int operationID;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The data date. */
	private Date dataDate;

	/** The duration fc. */
	private double durationFC;

	/** The operation type. */
	private String operationType;

	/** The fc rows loaded. */
	private int fcRowsLoaded;

	/** The fc rows updated. */
	private int fcRowsUpdated;

	/** The fc rows read. */
	private int fcRowsRead;

	/** The fc rows rejected. */
	private int fcRowsRejected;

	/** The fc rows dismissed. */
	private int fcRowsDismissed;

	/** The status. */
	private StatusEnum status;

	/** The trace of actions done by the operation. */
	private List<OperationTrace> opTrace;

	/**
	 * Gets the operation row id.
	 *
	 * @return the operation row id
	 */
	public String getOperationRowID() {
		return operationRowID;
	}

	/**
	 * Gets the final row id.
	 *
	 * @return the final row id
	 */
	public String getFinalRowID() {
		return finalRowID;
	}

	/**
	 * Gets the operation id.
	 *
	 * @return the operation id
	 */
	public int getOperationID() {
		return operationID;
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
	 * Gets the data date.
	 *
	 * @return the end date
	 */
	public Date getDataDate() {
		return dataDate;
	}

	/**
	 * Gets the duration fc.
	 *
	 * @return the duration fc
	 */
	public double getDurationFC() {
		return durationFC;
	}

	/**
	 * Gets the operation type.
	 *
	 * @return the operation type
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * Gets the fc rows loaded.
	 *
	 * @return the fc rows loaded
	 */
	public int getFcRowsLoaded() {
		return fcRowsLoaded;
	}

	/**
	 * Gets the fc rows updated.
	 *
	 * @return the fc rows updated
	 */
	public int getFcRowsUpdated() {
		return fcRowsUpdated;
	}

	/**
	 * Gets the fc rows read.
	 *
	 * @return the fc rows read
	 */
	public int getFcRowsRead() {
		return fcRowsRead;
	}

	/**
	 * Gets the fc rows rejected.
	 *
	 * @return the fc rows rejected
	 */
	public int getFcRowsRejected() {
		return fcRowsRejected;
	}

	/**
	 * Gets the fc rows dismissed.
	 *
	 * @return the fc rows dismissed
	 */
	public int getFcRowsDismissed() {
		return fcRowsDismissed;
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
	 * Sets the operation row id.
	 *
	 * @param operationRowID
	 *            the new operation row id
	 */
	public void setOperationRowID(String operationRowID) {
		this.operationRowID = operationRowID;
	}

	/**
	 * Sets the final row id.
	 *
	 * @param finalRowID
	 *            the new final row id
	 */
	public void setFinalRowID(String finalRowID) {
		this.finalRowID = finalRowID;
	}

	/**
	 * Sets the operation id.
	 *
	 * @param operationID
	 *            the new operation id
	 */
	public void setOperationID(int operationID) {
		this.operationID = operationID;
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
	 * Sets the data date.
	 *
	 * @param dataDate
	 *            the new data date
	 */
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	/**
	 * Sets the duration fc.
	 *
	 * @param durationFC
	 *            the new duration fc
	 */
	public void setDurationFC(double durationFC) {
		this.durationFC = durationFC;
	}

	/**
	 * Sets the operation type.
	 *
	 * @param operationType
	 *            the new operation type
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	/**
	 * Sets the fc rows loaded.
	 *
	 * @param fcRowsLoaded
	 *            the new fc rows loaded
	 */
	public void setFcRowsLoaded(int fcRowsLoaded) {
		this.fcRowsLoaded = fcRowsLoaded;
	}

	/**
	 * Sets the fc rows updated.
	 *
	 * @param fcRowsUpdated
	 *            the new fc rows updated
	 */
	public void setFcRowsUpdated(int fcRowsUpdated) {
		this.fcRowsUpdated = fcRowsUpdated;
	}

	/**
	 * Sets the fc rows read.
	 *
	 * @param fcRowsRead
	 *            the new fc rows read
	 */
	public void setFcRowsRead(int fcRowsRead) {
		this.fcRowsRead = fcRowsRead;
	}

	/**
	 * Sets the fc rows rejected.
	 *
	 * @param fcRowsRejected
	 *            the new fc rows rejected
	 */
	public void setFcRowsRejected(int fcRowsRejected) {
		this.fcRowsRejected = fcRowsRejected;
	}

	/**
	 * Sets the fc rows dismissed.
	 *
	 * @param fcRowsDismissed
	 *            the new fc rows dismissed
	 */
	public void setFcRowsDismissed(int fcRowsDismissed) {
		this.fcRowsDismissed = fcRowsDismissed;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterOfOperation [operationRowID=" + operationRowID + ", finalRowID=" + finalRowID + ", operationID="
				+ operationID + ", startDate=" + startDate + ", durationFC=" + durationFC + ", operationType="
				+ operationType + ", fcRowsLoaded=" + fcRowsLoaded + ", fcRowsUpdated=" + fcRowsUpdated
				+ ", fcRowsRead=" + fcRowsRead + ", fcRowsRejected=" + fcRowsRejected + ", fcRowsDismissed="
				+ fcRowsDismissed + ", status=" + status + "]";
	}

}
