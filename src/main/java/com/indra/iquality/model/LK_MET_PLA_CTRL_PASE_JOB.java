package com.indra.iquality.model;

import java.sql.Date;

public class LK_MET_PLA_CTRL_PASE_JOB {

	private String id_sistema;
	private int id_ejecucion; /* Primary key*/
	private int id_software;
	private int id_pase;
	private String id_job;
	private int id_pid;
	private Date id_fecha_inicio;
	private Date id_fecha_fin;
	private String id_estado;
	private Date id_fecha_creacion;
	private Date id_fecha_modificacion;
	private String id_sn_punto_control;
	private Date id_fecha_ok_punto_control;
	

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


	public String getId_job() {
		return id_job;
	}


	public void setId_job(String id_job) {
		this.id_job = id_job;
	}


	public int getId_pid() {
		return id_pid;
	}


	public void setId_pid(int id_pid) {
		this.id_pid = id_pid;
	}


	public Date getId_fecha_inicio() {
		return id_fecha_inicio;
	}


	public void setId_fecha_inicio(Date id_fecha_inicio) {
		this.id_fecha_inicio = id_fecha_inicio;
	}


	public Date getId_fecha_fin() {
		return id_fecha_fin;
	}


	public void setId_fecha_fin(Date id_fecha_fin) {
		this.id_fecha_fin = id_fecha_fin;
	}


	public String getId_estado() {
		return id_estado;
	}


	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
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


	public String getId_sn_punto_control() {
		return id_sn_punto_control;
	}


	public void setId_sn_punto_control(String id_sn_punto_control) {
		this.id_sn_punto_control = id_sn_punto_control;
	}


	public Date getId_fecha_ok_punto_control() {
		return id_fecha_ok_punto_control;
	}


	public void setId_fecha_ok_punto_control(Date id_fecha_ok_punto_control) {
		this.id_fecha_ok_punto_control = id_fecha_ok_punto_control;
	}

	
	@Override
	public String toString() {
		return "LK_MET_PLA_CTRL_PASE_JOB [id_sistema=" + id_sistema + ", id_ejecucion=" + id_ejecucion
				+ ", id_software=" + id_software + ", id_pase=" + id_pase + ", id_job=" + id_job + ", id_pid=" + id_pid
				+ ", id_fecha_inicio=" + id_fecha_inicio + ", id_fecha_fin=" + id_fecha_fin + ", id_estado=" + id_estado
				+ ", id_fecha_creacion=" + id_fecha_creacion + ", id_fecha_modificacion=" + id_fecha_modificacion
				+ ", id_sn_punto_control=" + id_sn_punto_control + ", id_fecha_ok_punto_control="
				+ id_fecha_ok_punto_control + "]";
	}
	
	
	// ID que representa la primary key
	// PK -> {id_ejecucion, id_job}
	public String getId(){
		return String.valueOf(id_ejecucion) + id_job;
	}

}
