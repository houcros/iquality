package com.indra.iquality.model;

/**
 * @author inlucero
 *
 */
public class DescripcionComponente {

	// Datos básicos
	private String nombre;
	private String formato;
	private String responsable;
	private String definicion;
	private String comentarios;
	
	// Datos entidad
	private String historicoEnt;
	private String origenEnt;
	private String caracteristicasActualizacionEnt;
	private String metodoObtencion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getDefinicion() {
		return definicion;
	}
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getHistoricoEnt() {
		return historicoEnt;
	}
	public void setHistoricoEnt(String historicoEnt) {
		this.historicoEnt = historicoEnt;
	}
	public String getOrigenEnt() {
		return origenEnt;
	}
	public void setOrigenEnt(String origenEnt) {
		this.origenEnt = origenEnt;
	}
	public String getCaracteristicasActualizacionEnt() {
		return caracteristicasActualizacionEnt;
	}
	public void setCaracteristicasActualizacionEnt(String caracteristicasActualizacionEnt) {
		this.caracteristicasActualizacionEnt = caracteristicasActualizacionEnt;
	}
	public String getMetodoObtencion() {
		return metodoObtencion;
	}
	public void setMetodoObtencion(String metodoObtencion) {
		this.metodoObtencion = metodoObtencion;
	}
	@Override
	public String toString() {
		return "DescripcionConcepto [nombre=" + nombre + ", formato=" + formato + ", responsable=" + responsable
				+ ", definicion=" + definicion + ", comentarios=" + comentarios + "]";
	}
	
}
