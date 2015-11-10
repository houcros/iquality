package com.indra.iquality.model;

public class DescripcionAtributoMaestro extends DescripcionAtributo {

	// Datos entidad maestro del atributo
	private String historicoMaestro;
	private String periodoActualizacionMaestro;
	private String tipoActualizacionMaestro;
	private String metodoObtencionMaestro;
	
	
	public DescripcionAtributoMaestro(DescripcionAtributo da) {
		this.formato = da.getFormato();
		this.periodoActualizacion = da.getPeriodoActualizacion();
		this.tipoActualizacion = da.getTipoActualizacion();
	}
	public DescripcionAtributoMaestro() {
		super();
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
