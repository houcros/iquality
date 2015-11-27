package com.indra.iquality.model;

import java.sql.Date;

public class Job {
	
	// PK = id_job + id_ejecucion
	private String idJob;
	private String idEjecucion;
	
	private String estado;
	private Date fechaInicio;
	private Date fechaFin;
	private String puntoDeControl;
	private Date fechaOKPuntoDeControl;
	private String duracion;
	
	private String idBloque;
	private String bloque;
	
	private int software;
	private String sistema;

	
	public String getIdJob() {
		return idJob;
	}


	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}


	public String getIdEjecucion() {
		return idEjecucion;
	}


	public void setIdEjecucion(String idEjecucion) {
		this.idEjecucion = idEjecucion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getPuntoDeControl() {
		return puntoDeControl;
	}


	public void setPuntoDeControl(String puntoDeControl) {
		this.puntoDeControl = puntoDeControl;
	}


	public Date getFechaOKPuntoDeControl() {
		return fechaOKPuntoDeControl;
	}


	public void setFechaOKPuntoDeControl(Date fechaOKPuntoDeControl) {
		this.fechaOKPuntoDeControl = fechaOKPuntoDeControl;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public String getIdBloque() {
		return idBloque;
	}


	public void setIdBloque(String idBloque) {
		this.idBloque = idBloque;
	}


	public String getBloque() {
		return bloque;
	}


	public void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public int getSoftware() {
		return software;
	}


	public void setSoftware(int software) {
		this.software = software;
	}


	public String getSistema() {
		return sistema;
	}


	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	@Override
	public String toString() {
		return "Job [id=" + idJob + ", estado=" + estado + ", FechaInicio=" + fechaInicio + ", FechaFin=" + fechaFin
				+ ", puntoDeControl=" + puntoDeControl + ", fechaOKPuntoDeControl=" + fechaOKPuntoDeControl
				+ ", duracion=" + duracion + "]";
	}

}
