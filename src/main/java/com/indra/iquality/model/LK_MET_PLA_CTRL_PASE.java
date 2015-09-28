package com.indra.iquality.model;

import java.sql.Date;

public class LK_MET_PLA_CTRL_PASE {

	private String id_sistema;
	private int id_ejecucion; /* Primary key*/
	private int id_software;
	private int id_pase;
	private String de_pase;
	private Date id_fecha_inicio;
	private Date id_fecha_inicio_real;
	private Date id_fecha_fin_real;
	private String id_estado;
	private String id_sn_habilitado;
	private int id_anyo;
	private int id_mes;
	private int id_escenario;
	private Date id_fecha_creacion;
	private Date id_fecha_modificacion;
	private int id_pid;
	
	public String getId_sistema() {
		return id_sistema;
	}

	public void setId_sistema(String id_sistema) {
		this.id_sistema = id_sistema;
	}

	public int getId_ejecucion() {
		return id_ejecucion;
	}

	public void setId_ejecucion(int id_ejecucion) {
		this.id_ejecucion = id_ejecucion;
	}

	public int getId_software() {
		return id_software;
	}

	public void setId_software(int id_software) {
		this.id_software = id_software;
	}

	public int getId_pase() {
		return id_pase;
	}

	public void setId_pase(int id_pase) {
		this.id_pase = id_pase;
	}

	public String getDe_pase() {
		return de_pase;
	}

	public void setDe_pase(String de_pase) {
		this.de_pase = de_pase;
	}

	public Date getId_fecha_inicio() {
		return id_fecha_inicio;
	}

	public void setId_fecha_inicio(Date id_fecha_inicio) {
		this.id_fecha_inicio = id_fecha_inicio;
	}

	public Date getId_fecha_inicio_real() {
		return id_fecha_inicio_real;
	}

	public void setId_fecha_inicio_real(Date id_fecha_inicio_real) {
		this.id_fecha_inicio_real = id_fecha_inicio_real;
	}

	public Date getId_fecha_fin_real() {
		return id_fecha_fin_real;
	}

	public void setId_fecha_fin_real(Date id_fecha_fin_real) {
		this.id_fecha_fin_real = id_fecha_fin_real;
	}

	public String getId_estado() {
		return id_estado;
	}

	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}

	public String getId_sn_habilitado() {
		return id_sn_habilitado;
	}

	public void setId_sn_habilitado(String id_sn_habilitado) {
		this.id_sn_habilitado = id_sn_habilitado;
	}

	public int getId_anyo() {
		return id_anyo;
	}

	public void setId_anyo(int id_anyo) {
		this.id_anyo = id_anyo;
	}

	public int getId_mes() {
		return id_mes;
	}

	public void setId_mes(int id_mes) {
		this.id_mes = id_mes;
	}

	public int getId_escenario() {
		return id_escenario;
	}

	public void setId_escenario(int id_escenario) {
		this.id_escenario = id_escenario;
	}

	public Date getId_fecha_creacion() {
		return id_fecha_creacion;
	}

	public void setId_fecha_creacion(Date id_fecha_creacion) {
		this.id_fecha_creacion = id_fecha_creacion;
	}

	public Date getId_fecha_modificacion() {
		return id_fecha_modificacion;
	}

	public void setId_fecha_modificacion(Date id_fecha_modificacion) {
		this.id_fecha_modificacion = id_fecha_modificacion;
	}

	public int getId_pid() {
		return id_pid;
	}

	public void setId_pid(int id_pid) {
		this.id_pid = id_pid;
	}

	@Override
	public String toString() {
		return "LK_MET_PLA_CTRL_PASE [id_sistema=" + id_sistema + ", id_ejecucion=" + id_ejecucion + ", id_software="
				+ id_software + ", id_pase=" + id_pase + ", de_pase=" + de_pase + ", id_fecha_inicio=" + id_fecha_inicio
				+ ", id_fecha_inicio_real=" + id_fecha_inicio_real + ", id_fecha_fin_real=" + id_fecha_fin_real
				+ ", id_estado=" + id_estado + ", id_sn_habilitado=" + id_sn_habilitado + ", id_anyo=" + id_anyo
				+ ", id_mes=" + id_mes + ", id_escenario=" + id_escenario + ", id_fecha_creacion=" + id_fecha_creacion
				+ ", id_fecha_modificacion=" + id_fecha_modificacion + ", id_pid=" + id_pid + "]";
	}
	
	// ID que representa la primary key
	public int getId(){
		return id_ejecucion;
	}

}
