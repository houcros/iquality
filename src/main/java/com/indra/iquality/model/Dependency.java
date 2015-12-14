package com.indra.iquality.model;

public class Dependency {

	// TODO Nuevamente creo que muchos de estos atributos sobran
	// aunque estén en la query original
	// Al fin y al cabo sólo muestro idJobHijo y estado
	private int idEjecucion;
	private String sistema;
	private int software;
	private int idPase;
	private String idJobPadre;
	private String idJobHijo;
	private String snHabilitada;
	private String estado;
	
	public int getIdEjecucion() {
		return idEjecucion;
	}
	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
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
	public int getIdPase() {
		return idPase;
	}
	public void setIdPase(int idPase) {
		this.idPase = idPase;
	}
	public String getIdJobPadre() {
		return idJobPadre;
	}
	public void setIdJobPadre(String idJobPadre) {
		this.idJobPadre = idJobPadre;
	}
	public String getIdJobHijo() {
		return idJobHijo;
	}
	public void setIdJobHijo(String idJobHijo) {
		this.idJobHijo = idJobHijo;
	}
	public String getSnHabilitada() {
		return snHabilitada;
	}
	public void setSnHabilitada(String snHabilitada) {
		this.snHabilitada = snHabilitada;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
