/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;

/**
 * The Class RegisterTrace. Represents the trace or log of a run job.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class RegisterTrace.
 */
public class RegisterTrace {

	/** The id. */
	private int id;

	/** The date id. */
	private Date dateID;

	/** The date. */
	private String date;

	/** The category. */
	private String category;

	/** The message. */
	private String message;

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
	 * Gets the date id.
	 *
	 * @return the date id
	 */
	public Date getDateID() {
		return dateID;
	}

	/**
	 * Sets the date id.
	 *
	 * @param dateID
	 *            the new date id
	 */
	public void setDateID(Date dateID) {
		this.dateID = dateID;
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
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category
	 *            the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrazaDeRegistro [idTraza=" + id + ", idFecha=" + dateID + ", fecha=" + date + ", categoria=" + category
				+ ", mensaje=" + message + "]";
	}

}
