package com.indra.iquality.model;

public abstract class Certificacion {

	protected String fecha;
	protected String seccion;
	protected String subseccion;
	protected String entidad;
	protected String certificacion;
	// ID_ERROR hace falta? Para validacion quizas?
	protected String estado;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getSubseccion() {
		return subseccion;
	}
	public void setSubseccion(String subseccion) {
		this.subseccion = subseccion;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getCertificacion() {
		return certificacion;
	}
	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
