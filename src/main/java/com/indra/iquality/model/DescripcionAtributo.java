package com.indra.iquality.model;

public class DescripcionAtributo extends DescripcionComponente {

	// Datos básicos atributo
	private String formato;
	// Datos entidad atributo
	private String periodoActualizacion;
	private String tipoActualizacion;
	// Datos entidad maestro del atributo
	private String historicoMaestro;
	private String periodoActualizacionMaestro;
	private String tipoActualizacionMaestro;
	private String metodoObtencionMaestro;
	
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getPeriodoActualizacion() {
		return periodoActualizacion;
	}
	public void setPeriodoActualizacion(String periodoActualizacion) {
		this.periodoActualizacion = periodoActualizacion;
	}
	public String getTipoActualizacion() {
		return tipoActualizacion;
	}
	public void setTipoActualizacion(String tipoActualizacion) {
		this.tipoActualizacion = tipoActualizacion;
	}
	public String getHistoricoMaestro() {
		return historicoMaestro;
	}
	public void setHistoricoMaestro(String historicoMaestro) {
		this.historicoMaestro = historicoMaestro;
	}
	public String getPeriodoActualizacionMaestro() {
		return periodoActualizacionMaestro;
	}
	public void setPeriodoActualizacionMaestro(String periodoActualizacionMaestro) {
		this.periodoActualizacionMaestro = periodoActualizacionMaestro;
	}
	public String getTipoActualizacionMaestro() {
		return tipoActualizacionMaestro;
	}
	public void setTipoActualizacionMaestro(String tipoActualizacionMaestro) {
		this.tipoActualizacionMaestro = tipoActualizacionMaestro;
	}
	public String getMetodoObtencionMaestro() {
		return metodoObtencionMaestro;
	}
	public void setMetodoObtencionMaestro(String metodoObtencionMaestro) {
		this.metodoObtencionMaestro = metodoObtencionMaestro;
	}
}
