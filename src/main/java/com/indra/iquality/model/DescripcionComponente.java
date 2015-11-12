package com.indra.iquality.model;

/**
 * @author inlucero
 *
 */
public class DescripcionComponente {

	// Datos básicos comunes
	protected int id;
	protected String nombre;
	protected String responsable;
	protected String definicion;
	protected String comentarios;
	// Datos entidad comunes
	protected String historico;
	protected String metodoObtencion;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getMetodoObtencion() {
		return metodoObtencion;
	}
	public void setMetodoObtencion(String metodoObtencion) {
		this.metodoObtencion = metodoObtencion;
	}
	
}
