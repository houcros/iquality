/*
 * 
 */
package com.indra.iquality.model;

import java.util.Map;

import com.indra.iquality.singleton.Entorno;

/**
 * The Class Pase. Represents an ETL flow for a system and software version. A
 * flow can't (shouldn't) get any of its fields modified after it's been
 * executed as an {@link Ejecucion}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 10-dic-2015
 * 
 *          The Class Pase.
 */
public class Pase {

	// Instance variables
	/** The unique immutable identifier. */
	private int id;

	/** The descriptive name of the flow. */
	private String nombre;

	/**
	 * Indicates if the flow is typical or atypical. Can me either 'S' or 'N',
	 * corresponding to typical and atypical.
	 */
	private String esAtipico;

	/** The system on which the flow will be executed. */
	private String sistema;

	/** The software version of the system. */
	// TODO refactor: mejor si esto es un int id
	private String software;

	/**
	 * The identifiers of the jobs that will run on this flow. See {@link Job}
	 */
	private String[] jobs;

	/**
	 * The dependencies among the jobs of this flow. The key is the identifier
	 * of a job j, the values are the identifiers of the jobs that must finish
	 * successfully before j can be executed. See {@link Dependencia}
	 */
	private Map<String, String[]> dependencias;

	// Constructors
	/**
	 * Instantiates a new empty flow.
	 */
	public Pase() {

	};

	/**
	 * Instantiates a new flow with a given name, typicality, list of jobs and
	 * list of dependencies. System and software will be set to those active in
	 * the current environment. See {@link com.indra.iquality.singleton.Entorno}
	 * .
	 *
	 * @param nombre
	 *            the name of the flow
	 * @param esAtipico
	 *            the typicality
	 * @param jobs
	 *            the list of jobs
	 * @param dependencias
	 *            the dependencies of the jobs
	 */
	public Pase(String nombre, String esAtipico, String[] jobs, Map<String, String[]> dependencias) {
		this.nombre = nombre;
		this.esAtipico = esAtipico;
		this.jobs = jobs;
		this.dependencias = dependencias;
		this.sistema = Entorno.getInstance().getIdSistema();
		this.software = Entorno.getInstance().getDescripcionSoftware();
	}

	// Getters
	/**
	 * Gets the unique identifier.
	 *
	 * @return the unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name of the flow.
	 *
	 * @return the name of the flow
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the typicality of the flow.
	 *
	 * @return the typicality
	 */
	public String getEsAtipico() {
		return esAtipico;
	}

	/**
	 * Gets the system where the flow is defined.
	 *
	 * @return the system
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * Gets the software version of the system.
	 *
	 * @return the software version
	 */
	public String getSoftware() {
		return software;
	}

	/**
	 * Gets the identifiers of the jobs of this flow.
	 *
	 * @return the identifiers of the jobs
	 */
	public String[] getJobs() {
		return jobs;
	}

	/**
	 * Gets the dependencies of the jobs of associated to this flow.
	 *
	 * @return a map with the dependencies
	 */
	public Map<String, String[]> getDependencias() {
		return dependencias;
	}

	// Setters
	/**
	 * Sets the unique identifier. Can't (shouldn't) be set more than once.
	 *
	 * @param id
	 *            the new unique identifier
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the name of the flow.
	 *
	 * @param nombre
	 *            the name of the flow
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Sets the typicality of the flow.
	 *
	 * @param esAtipico
	 *            the typicality
	 */
	public void setEsAtipico(String esAtipico) {
		this.esAtipico = esAtipico;
	}

	/**
	 * Sets the system on which the flow will run.
	 *
	 * @param sistema
	 *            the system
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/**
	 * Sets the software version for a new flow.
	 *
	 * @param software
	 *            the software version
	 */
	public void setSoftware(String software) {
		this.software = software;
	}

	/**
	 * Sets the identifiers of the jobs of this flow.
	 *
	 * @param jobs
	 *            an array containing the identifiers of the jobs
	 */
	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}

	/**
	 * Sets the dependencies of the jobs associated to this flow.
	 *
	 * @param dependencias
	 *            a map whose key is the identifier of a job and the value is an
	 *            array with the identifiers of the jobs on which that depends
	 */
	public void setDependencias(Map<String, String[]> dependencias) {
		this.dependencias = dependencias;
	}

}
