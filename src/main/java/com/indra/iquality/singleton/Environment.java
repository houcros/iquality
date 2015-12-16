/*
 * 
 */
package com.indra.iquality.singleton;

import java.sql.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Singleton Environment. Defines the shared environment settings for all
 * the modules of the application. Provides consistency across the application.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class Environment.
 */
public class Environment {

	/** The unique instance of the environment. */
	private static Environment instance;

	/** The default value to substitute when a null String is found. */
	public final static String DEFAULT_NULL_STRING = "";

	/** The default value to substitute when a null integer is found. */
	public final static int DEFAULT_NULL_INT = -1;

	/** The default value to substitute when a null double is found. */
	public final static double DEFAULT_NULL_DOUBLE = -1.0;

	/** The default value to substitute when a null Date is found. */
	public final static Date DEFAULT_NULL_DATE = new Date(1);

	/** The identifier of the underlying system. */
	private String systemID;

	/** A short description of the underlying system. */
	private String systemDescription;

	/** The identifier of the current software version running in the system. */
	private int currentSoftwareID;

	/** A short description of the current software version. */
	private String currentSoftwareDescription;

	/** Other software versions of the system. */
	private List<String> softwareVersions;

	/**
	 * Instantiates a new environment with the default values for the system and
	 * software.
	 */
	private Environment() {
		currentSoftwareID = 1;
		systemID = "DMS";
		currentSoftwareDescription = "Versión inicial";
	};

	/**
	 * Instantiates a new environment for a given system and first software
	 * version.
	 *
	 * @param systemID
	 *            the identifier of the system
	 * @param systemDescription
	 *            a short description of the system
	 * @param firstSoftwareVersion
	 *            the identifier of the first software version to run in the
	 *            system
	 */
	private Environment(String systemID, String systemDescription, int firstSoftwareVersion) {
		this.systemID = systemID;
		this.systemDescription = systemDescription;
		this.currentSoftwareID = firstSoftwareVersion;
	}

	/**
	 * Gets the single instance of the Environment. If it still doesn't exist,
	 * creates a new instance with the default values.
	 *
	 * @return single instance of the Environment
	 */
	public static Environment getInstance() {
		if (instance == null)
			instance = new Environment();
		return instance;
	}

	/**
	 * Gets the system identifier.
	 *
	 * @return the system
	 */
	public String getSystem() {
		return systemID;
	}

	/**
	 * Gets the system description.
	 *
	 * @return the system description
	 */
	public String getSystemDescription() {
		return systemDescription;
	}

	/**
	 * Gets the current software in the system.
	 *
	 * @return the current software
	 */
	public int getCurrentSoftware() {
		return currentSoftwareID;
	}

	/**
	 * Sets a new current software in the system.
	 *
	 * @param softwareID
	 *            the identifier of the new current software
	 */
	public void setCurrentSoftware(int softwareID) {
		this.currentSoftwareID = softwareID;
	}

	/**
	 * Gets the description of the current software.
	 *
	 * @return the description of the current software
	 */
	public String getCurrentSoftwareDescription() {
		return currentSoftwareDescription;
	}

}
