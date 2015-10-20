package com.indra.iquality.model;

public class DictionaryConcept {

	private String concept;
	private int level;
	private int status;
	private ConceptTypeEnum tipo;
	
	
	public DictionaryConcept() {
		super();
	}

	public DictionaryConcept(String concept) {
		this.concept = concept;
	}
	
	public DictionaryConcept(String concept, int level, int status, ConceptTypeEnum tipo) {
		this.concept = concept;
		this.level = level;
		this.status = status;
		this.tipo = tipo;
	}

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
	public ConceptTypeEnum getTipo() {
		return tipo;
	}
	public void setTipo(ConceptTypeEnum tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "DictionaryConcept [concept=" + concept + ", level=" + level + ", status=" + status + ", tipo=" + tipo
				+ "]";
	}

}
