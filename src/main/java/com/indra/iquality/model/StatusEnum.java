/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Enum StatusEnum. Holds all the possible values for the status of an
 * execution or job.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Enum StatusEnum.
 */
public enum StatusEnum {

	/** If the execution passed. */
	OK,

	/** If the execution failed. */
	KO,

	/** If the execution needs to be checked. */
	CHECK,

	/** If the execution is waiting to be run. */
	PDTE,

	/** If the execution was canceled. */
	CANCEL
}
