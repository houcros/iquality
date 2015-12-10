package com.indra.iquality.singleton;

import java.sql.Date;

public class Entorno {

	private static Entorno instance;

	// Parámetros por defecto para sustituir por null en las queries
	// Comunes para todas las queries del sistema por consistencia
	public final static String DEFAULT_NULL_STRING = "";
	public final static int DEFAULT_NULL_INT = -1;
	public final static double DEFAULT_NULL_FLOAT = -1.0;
	public final static Date DEFAULT_NULL_DATE = new Date(1);
	
	private int idSoftware;
	private String idSistema;
	private String descripcionSoftware;
	private boolean esSoftwareActual;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	// TODO Generalizar la creación cuando llame a Sistema
	// De momento harcodeada
	private Entorno(){
		idSoftware = 1;
		idSistema = "DMS";
		descripcionSoftware = "Versión inicial";
		esSoftwareActual = true;
	};

	private Entorno(int idSoft, String idSist, String descripcion, boolean actual){
		idSoftware = idSoft;
		idSistema = idSist;
		descripcionSoftware = descripcion;
		esSoftwareActual = actual;
	}
	
	public static Entorno getInstance(){
		if(instance == null)
			instance = new Entorno();
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

	public static void setInstance(Entorno instance) {
		Entorno.instance = instance;
	}
	
}
