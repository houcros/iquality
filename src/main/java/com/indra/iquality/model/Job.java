package com.indra.iquality.model;

import java.sql.Date;

public class Job {
	
	// PK = id_job + id_ejecucion
	private String idJob;
	private String idEjecucion;
	
	private String estado;
	private Date FechaInicio;
	private Date FechaFin;
	private String puntoDeControl;
	private Date fechaOKPuntoDeControl;
	private String duracion;
	
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
		return FechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return FechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
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
		return "Job [id=" + idJob + ", estado=" + estado + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin
				+ ", puntoDeControl=" + puntoDeControl + ", fechaOKPuntoDeControl=" + fechaOKPuntoDeControl
				+ ", duracion=" + duracion + "]";
	}

}
