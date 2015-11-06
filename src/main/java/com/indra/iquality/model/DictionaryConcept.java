package com.indra.iquality.model;

public class DictionaryConcept {

	private String concept;
	private int level;
	private int status;
	private ConceptTypeEnum tipo;
	private String compRowID;
	private String ctRowID;
	
	
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
		this.compRowID = "NULL";
		this.ctRowID = "NULL";
	}
	
	public DictionaryConcept(String concept, int level, int status, ConceptTypeEnum tipo, String compRowID, String ctRowID) {
		this.concept = concept;
		this.level = level;
		this.status = status;
		this.tipo = tipo;
		this.compRowID = compRowID;
		this.ctRowID = ctRowID;
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
	
	public String getCompRowID() {
		return compRowID;
	}

	public void setCompRowID(String compRowID) {
		this.compRowID = compRowID;
	}

	public String getCtRowID() {
		return ctRowID;
	}

	public void setCtRowID(String ctRowID) {
		this.ctRowID = ctRowID;
	}

	@Override
	public String toString() {
		return "DictionaryConcept [concept=" + concept + ", level=" + level + ", status=" + status + ", tipo=" + tipo
				+ "]";
	}

}
