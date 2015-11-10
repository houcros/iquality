package com.indra.iquality.model;

public class DescripcionIndicador extends DescripcionComponente {

	// Datos básicos indicador
	private String unidadMedida;
	private String periodoAcumulado;
	// Datos certificacion indicador
	private String[] certificaciones;
	
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String getPeriodoAcumulado() {
		return periodoAcumulado;
	}
	public void setPeriodoAcumulado(String periodoAcumulado) {
		this.periodoAcumulado = periodoAcumulado;
	}
	public String[] getCertificaciones() {
		return certificaciones;
	}
	public void setCertificaciones(String[] certificaciones) {
		this.certificaciones = certificaciones;
	}
}
