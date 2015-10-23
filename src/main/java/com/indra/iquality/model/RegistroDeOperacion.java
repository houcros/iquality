package com.indra.iquality.model;

import java.sql.Date;

public class RegistroDeOperacion {

	private Date duracion;
	private String opRowId;
	private String finalRowId;
	private int idOperacion;
	private String sistema;
	private int software;
	private String descripcionBloque;
	private String idJob;
	private String descripcionEscenario;
	private int idEjecucion;
	private Date fechaInicio;
	private Date fechaFin;
	private int fcDuracion;
	private String tipoDeOperacion;
	private int fcFilasCargadas;
	private int fcFilasActualizadas;
	private int fcFilasLeidas;
	private int fcFilasRechazadas;
	private int fcFilasDescartadas;
	private String descripcionSoftware;
	private String descripcionOperacion;
	private String estado;
	private Date fecha;
	
	public Date getDuracion() {
		return duracion;
	}
	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}
	public String getOpRowId() {
		return opRowId;
	}
	public void setOpRowId(String opRowId) {
		this.opRowId = opRowId;
	}
	public String getFinalRowId() {
		return finalRowId;
	}
	public void setFinalRowId(String finalRowId) {
		this.finalRowId = finalRowId;
	}
	public int getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public int getSoftware() {
		return software;
	}
	public void setSoftware(int software) {
		this.software = software;
	}
	public String getDescripcionBloque() {
		return descripcionBloque;
	}
	public void setDescripcionBloque(String descripcionBloque) {
		this.descripcionBloque = descripcionBloque;
	}
	public String getIdJob() {
		return idJob;
	}
	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}
	public String getDescripcionEscenario() {
		return descripcionEscenario;
	}
	public void setDescripcionEscenario(String descripcionEscenario) {
		this.descripcionEscenario = descripcionEscenario;
	}
	public int getIdEjecucion() {
		return idEjecucion;
	}
	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
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
	public int getFcDuracion() {
		return fcDuracion;
	}
	public void setFcDuracion(int fcDuracion) {
		this.fcDuracion = fcDuracion;
	}
	public String getTipoDeOperacion() {
		return tipoDeOperacion;
	}
	public void setTipoDeOperacion(String tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	public int getFcFilasCargadas() {
		return fcFilasCargadas;
	}
	public void setFcFilasCargadas(int fcFilasCargadas) {
		this.fcFilasCargadas = fcFilasCargadas;
	}
	public int getFcFilasActualizadas() {
		return fcFilasActualizadas;
	}
	public void setFcFilasActualizadas(int fcFilasActualizadas) {
		this.fcFilasActualizadas = fcFilasActualizadas;
	}
	public int getFcFilasLeidas() {
		return fcFilasLeidas;
	}
	public void setFcFilasLeidas(int fcFilasLeidas) {
		this.fcFilasLeidas = fcFilasLeidas;
	}
	public int getFcFilasRechazadas() {
		return fcFilasRechazadas;
	}
	public void setFcFilasRechazadas(int fcFilasRechazadas) {
		this.fcFilasRechazadas = fcFilasRechazadas;
	}
	public int getFcFilasDescartadas() {
		return fcFilasDescartadas;
	}
	public void setFcFilasDescartadas(int fcFilasDescartadas) {
		this.fcFilasDescartadas = fcFilasDescartadas;
	}
	public String getDescripcionSoftware() {
		return descripcionSoftware;
	}
	public void setDescripcionSoftware(String descripcionSoftware) {
		this.descripcionSoftware = descripcionSoftware;
	}
	public String getDescripcionOperacion() {
		return descripcionOperacion;
	}
	public void setDescripcionOperacion(String descripcionOperacion) {
		this.descripcionOperacion = descripcionOperacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "RegistroDeOperacion [duracion=" + duracion + ", rowID=" + opRowId + ", finalRowID=" + finalRowId
				+ ", idOperacion=" + idOperacion + ", sistema=" + sistema + ", software=" + software
				+ ", descripcionBloque=" + descripcionBloque + ", idJob=" + idJob + ", descripcionEscenario="
				+ descripcionEscenario + ", idEjecucion=" + idEjecucion + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", fcDuracion=" + fcDuracion + ", tipoDeOperacion=" + tipoDeOperacion
				+ ", fcFilasCargadas=" + fcFilasCargadas + ", fcFilasActualizadas=" + fcFilasActualizadas
				+ ", fcFilasLeidas=" + fcFilasLeidas + ", fcFilasRechazadas=" + fcFilasRechazadas
				+ ", fcFilasDescartadas=" + fcFilasDescartadas + ", descripcionSoftware=" + descripcionSoftware
				+ ", descripcionOperacion=" + descripcionOperacion + ", estado=" + estado + ", fecha=" + fecha + "]";
	}
	
}
