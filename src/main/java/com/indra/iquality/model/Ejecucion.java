/*
 * 
 */
package com.indra.iquality.model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Ejecucion. Represents an execution of an ETL flow for a given
 * system and software version on a date. See {@link Pase}.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.1, 09/12/15
 * 
 *          The Class Ejecucion.
 */
public class Ejecucion {

	/** The identifier of the execution. */
	private int idEjecucion;

	/** The pase. */
	private String pase;

	/** The estado. */
	private String estado;

	/** The fecha datos. */
	private String fechaDatos;

	/** The escenario. */
	private String escenario;

	/** The fecha inicio. */
	private Date fechaInicio;

	/** The fecha fin. */
	private Date fechaFin;

	/** The fecha planificada. */
	private Date fechaPlanificada;

	/** The software. */
	private String software;

	/** The duracion. */
	private String duracion;

	/**
	 * Gets the id ejecucion.
	 *
	 * @return the id ejecucion
	 */
	public int getIdEjecucion() {
		return idEjecucion;
	}

	/**
	 * Sets the id ejecucion.
	 *
	 * @param idEjecucion
	 *            the new id ejecucion
	 */
	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
	}

	/**
	 * Gets the pase.
	 *
	 * @return the pase
	 */
	public String getPase() {
		return pase;
	}

	/**
	 * Sets the pase.
	 *
	 * @param pase
	 *            the new pase
	 */
	public void setPase(String pase) {
		this.pase = pase;
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
	 * Sets the estado.
	 *
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the fecha datos.
	 *
	 * @return the fecha datos
	 */
	public String getFechaDatos() {
		return fechaDatos;
	}

	/**
	 * Sets the fecha datos.
	 *
	 * @param fechaDatos
	 *            the new fecha datos
	 */
	public void setFechaDatos(String fechaDatos) {
		this.fechaDatos = fechaDatos;
	}

	/**
	 * Gets the escenario.
	 *
	 * @return the escenario
	 */
	public String getEscenario() {
		return escenario;
	}

	/**
	 * Sets the escenario.
	 *
	 * @param escenario
	 *            the new escenario
	 */
	public void setEscenario(String escenario) {
		this.escenario = escenario;
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
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio
	 *            the new fecha inicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	 * Sets the fecha fin.
	 *
	 * @param fechaFin
	 *            the new fecha fin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Gets the fecha planificada.
	 *
	 * @return the fecha planificada
	 */
	public Date getFechaPlanificada() {
		return fechaPlanificada;
	}

	/**
	 * Sets the fecha planificada.
	 *
	 * @param fechaPlanificada
	 *            the new fecha planificada
	 */
	public void setFechaPlanificada(Date fechaPlanificada) {
		this.fechaPlanificada = fechaPlanificada;
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
	 * Gets the duracion.
	 *
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pase [idEjecucion=" + idEjecucion + ", pase=" + pase + ", estado=" + estado + ", fechaDatos="
				+ fechaDatos + ", escenario=" + escenario + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", fechaPlanificada=" + fechaPlanificada + ", software=" + software + ", duracion=" + duracion + "]";
	}

}