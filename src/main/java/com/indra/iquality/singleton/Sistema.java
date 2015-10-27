package com.indra.iquality.singleton;

import java.sql.Date;

public class Sistema {

	private static Sistema instance;

	// Parámetros por defecto para sustituir por null en las queries
	// Comunes para todas las queries del sistema por consistencia
	private final static String DEFAULT_NULL_STRING = "";
	private final static int DEFAULT_NULL_INT = -1;
	private final static Date DEFAULT_NULL_DATE = new Date(1);
	
	private int idSoftware;
	private String idSistema;
	private String descripcionSoftware;
	private boolean esSoftwareActual;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	// TODO Generalizar la creación cuando llame a Sistema
	// De momento harcodeada
	private Sistema(){
		idSoftware = 1;
		idSistema = "DMS";
		descripcionSoftware = "Versión inicial";
		esSoftwareActual = true;
	};

	private Sistema(int idSoft, String idSist, String descripcion, boolean actual){
		idSoftware = idSoft;
		idSistema = idSist;
		descripcionSoftware = descripcion;
		esSoftwareActual = actual;
	}
	
	public static Sistema getInstance(){
		if(instance == null)
			instance = new Sistema();
		return instance;
	}
	
	public int getIdSoftware() {
		return idSoftware;
	}

	public void setIdSoftware(int idSoftware) {
		this.idSoftware = idSoftware;
	}

	public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}

	public String getDescripcionSoftware() {
		return descripcionSoftware;
	}

	public void setDescripcionSoftware(String descripcionSoftware) {
		this.descripcionSoftware = descripcionSoftware;
	}

	public boolean isEsSoftwareActual() {
		return esSoftwareActual;
	}

	public void setEsSoftwareActual(boolean esSoftwareActual) {
		this.esSoftwareActual = esSoftwareActual;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public static void setInstance(Sistema instance) {
		Sistema.instance = instance;
	}
	
}
