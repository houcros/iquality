package com.indra.iquality.singleton;

import java.sql.Date;
import java.util.List;

public class Environment {

	private static Environment instance;

	// Parámetros por defecto para sustituir por null en las queries
	// Comunes para todas las queries del sistema por consistencia
	public final static String DEFAULT_NULL_STRING = "";
	public final static int DEFAULT_NULL_INT = -1;
	public final static double DEFAULT_NULL_FLOAT = -1.0;
	public final static Date DEFAULT_NULL_DATE = new Date(1);

	// Se tiene que harcodear en la creadora, no tienen setters
	private String idSistema;
	private String descripcionSistema;

	private int idSoftware;
	private String descripcionSoftware;
	private List<String> versions;
	private Date fechaCreacion;
	private Date fechaModificacion;

	// TODO Generalizar la creación cuando llame a Sistema
	// De momento harcodeada
	private Environment() {
		idSoftware = 1;
		idSistema = "DMS";
		descripcionSoftware = "Versión inicial";
	};

	private Environment(int idSoftware, String idSistema, String descripcionSoftware) {
		this.idSoftware = idSoftware;
		this.idSistema = idSistema;
		this.descripcionSoftware = descripcionSoftware;
	}

	public static Environment getInstance() {
		if (instance == null)
			instance = new Environment();
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

	public String getSoftwareDescription() {
		return descripcionSoftware;
	}

	public String getDescripcionSistema() {
		return descripcionSistema;
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

	public static void setInstance(Environment instance) {
		Environment.instance = instance;
	}

}
