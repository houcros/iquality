package com.indra.iquality.model;

public class DescripcionAtributo extends DescripcionComponente {

	// Datos básicos atributo
	protected String formato;
	// Datos entidad atributo
	protected String periodoActualizacion;
	protected String tipoActualizacion;
	
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
}
