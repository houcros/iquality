package com.indra.iquality.model;

import java.util.List;

public class DescripcionIndicador extends DescripcionComponente {

	// Datos básicos indicador
	private String unidadMedida;
	private String periodoAcumulado;
	// Datos certificacion indicador
	private List<String> certificaciones;
	
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
	public List<String> getCertificaciones() {
		return certificaciones;
	}
	public void setCertificaciones(List<String> certificaciones) {
		this.certificaciones = certificaciones;
	}
}
