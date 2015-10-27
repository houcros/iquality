package com.indra.iquality.model;

import java.sql.Date;

public class TrazaDeRegistro {

	// No entiendo por qué hay dos fechas, y si ambas son necesarias
	private int idTraza;
	private Date idFecha;
	private String fecha;
	private String categoria;
	private String mensaje;
	
	public int getIdTraza() {
		return idTraza;
	}
	public void setIdTraza(int idTraza) {
		this.idTraza = idTraza;
	}
	public Date getIdFecha() {
		return idFecha;
	}
	public void setIdFecha(Date idFecha) {
		this.idFecha = idFecha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "TrazaDeRegistro [idTraza=" + idTraza + ", idFecha=" + idFecha + ", fecha=" + fecha + ", categoria="
				+ categoria + ", mensaje=" + mensaje + "]";
	}
	
}
