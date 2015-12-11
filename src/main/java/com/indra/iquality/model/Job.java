/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Job. Represents an atomic step in an ETL process flow.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 11-dic-2015
 * 
 *          The Class Job.
 */
public class Job {

	// Instance variables
	// PK = id_job + id_ejecucion
	/** The id job. */
	private String idJob;

	/** The id ejecucion. */
	private String idEjecucion;

	/** The estado. */
	private String estado;

	/** The fecha inicio. */
	private Date fechaInicio;

	/** The fecha fin. */
	private Date fechaFin;

	/** The punto de control. */
	private String puntoDeControl;

	/** The fecha ok punto de control. */
	private Date fechaOKPuntoDeControl;

	/** The duracion. */
	private String duracion;

	/** The id bloque. */
	private String idBloque;

	/** The bloque. */
	private String bloque;

	/** The software. */
	private int software;

	/** The sistema. */
	private String sistema;

	/**
	 * Gets the id job.
	 *
	 * @return the id job
	 */
	// Getters
	public String getIdJob() {
		return idJob;
	}

	/**
	 * Gets the id ejecucion.
	 *
	 * @return the id ejecucion
	 */
	public String getIdEjecucion() {
		return idEjecucion;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fecha inicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Gets the punto de control.
	 *
	 * @return the punto de control
	 */
	public String getPuntoDeControl() {
		return puntoDeControl;
	}

	/**
	 * Gets the fecha ok punto de control.
	 *
	 * @return the fecha ok punto de control
	 */
	public Date getFechaOKPuntoDeControl() {
		return fechaOKPuntoDeControl;
	}

	/**
	 * Gets the duracion.
	 *
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Gets the id bloque.
	 *
	 * @return the id bloque
	 */
	public String getIdBloque() {
		return idBloque;
	}

	/**
	 * Gets the bloque.
	 *
	 * @return the bloque
	 */
	public String getBloque() {
		return bloque;
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
	 * Gets the sistema.
	 *
	 * @return the sistema
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * Sets the id job.
	 *
	 * @param idJob
	 *            the new id job
	 */
	// Setters
	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}

	/**
	 * Sets the id ejecucion.
	 *
	 * @param idEjecucion
	 *            the new id ejecucion
	 */
	public void setIdEjecucion(String idEjecucion) {
		this.idEjecucion = idEjecucion;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio
	 *            the new fecha inicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin
	 *            the new fecha fin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Sets the punto de control.
	 *
	 * @param puntoDeControl
	 *            the new punto de control
	 */
	public void setPuntoDeControl(String puntoDeControl) {
		this.puntoDeControl = puntoDeControl;
	}

	/**
	 * Sets the fecha ok punto de control.
	 *
	 * @param fechaOKPuntoDeControl
	 *            the new fecha ok punto de control
	 */
	public void setFechaOKPuntoDeControl(Date fechaOKPuntoDeControl) {
		this.fechaOKPuntoDeControl = fechaOKPuntoDeControl;
	}

	/**
	 * Sets the duracion.
	 *
	 * @param duracion
	 *            the new duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Sets the id bloque.
	 *
	 * @param idBloque
	 *            the new id bloque
	 */
	public void setIdBloque(String idBloque) {
		this.idBloque = idBloque;
	}

	/**
	 * Sets the bloque.
	 *
	 * @param bloque
	 *            the new bloque
	 */
	public void setBloque(String bloque) {
		this.bloque = bloque;
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
	 * Sets the sistema.
	 *
	 * @param sistema
	 *            the new sistema
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Job [id=" + idJob + ", estado=" + estado + ", FechaInicio=" + fechaInicio + ", FechaFin=" + fechaFin
				+ ", puntoDeControl=" + puntoDeControl + ", fechaOKPuntoDeControl=" + fechaOKPuntoDeControl
				+ ", duracion=" + duracion + "]";
	}

}
