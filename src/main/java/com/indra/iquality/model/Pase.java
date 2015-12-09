package com.indra.iquality.model;

public class Pase {

	private int id;
	private String nombre;
	private String esAtipico;
	private String sistema;
	private String software;
	
	public Pase(){
		
	};
	
	public Pase(String nombre, String sistema, String esAtipico){
		this.nombre = nombre;
		this.sistema = sistema;
		this.esAtipico = esAtipico;
	}
	
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
	public String getEsAtipico() {
		return esAtipico;
	}
	public void setEsAtipico(String esAtipico) {
		this.esAtipico = esAtipico;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
}
