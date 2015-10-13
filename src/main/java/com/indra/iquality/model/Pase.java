package com.indra.iquality.model;

import java.sql.Date;

public class Pase {

	private int idEjecucion; /* Primary key*/
	private String pase;
	private String estado;
	private String fechaDatos;
	private String escenario;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaPlanificada;
	private String software;
	private String duracion;
	
	
	public int getIdEjecucion() {
		return idEjecucion;
	}
	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
	}
	public String getPase() {
		return pase;
	}
	public void setPase(String pase) {
		this.pase = pase;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaDatos() {
		return fechaDatos;
	}
	public void setFechaDatos(String fechaDatos) {
		this.fechaDatos = fechaDatos;
	}
	public String getEscenario() {
		return escenario;
	}
	public void setEscenario(String escenario) {
		this.escenario = escenario;
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
	public Date getFechaPlanificada() {
		return fechaPlanificada;
	}
	public void setFechaPlanificada(Date fechaPlanificada) {
		this.fechaPlanificada = fechaPlanificada;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "Pase [idEjecucion=" + idEjecucion + ", pase=" + pase + ", estado=" + estado + ", fechaDatos="
				+ fechaDatos + ", escenario=" + escenario + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", fechaPlanificada=" + fechaPlanificada + ", software=" + software + ", duracion=" + duracion + "]";
	}

	
}