package com.indra.iquality.model;

public class DescripcionComponente {

	private String nombre;
	private String formato;
	private String responsable;
	private String definicion;
	private String comentarios;
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
	@Override
	public String toString() {
		return "DescripcionConcepto [nombre=" + nombre + ", formato=" + formato + ", responsable=" + responsable
				+ ", definicion=" + definicion + ", comentarios=" + comentarios + "]";
	}
	
}
