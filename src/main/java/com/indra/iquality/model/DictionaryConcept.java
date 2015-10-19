package com.indra.iquality.model;

public class DictionaryConcept {

	private String concept;
	private int level;
	private int status;
	private String tipo;
	
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "DictionaryConcept [concept=" + concept + ", level=" + level + ", status=" + status + ", tipo=" + tipo
				+ "]";
	}

}
