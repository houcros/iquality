package com.indra.iquality.translator;

import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

public class ParIntNodo {
	
	private int level;
	private GenericTreeNode<DictionaryConcept> nodo;
	
	public ParIntNodo(int posicion, GenericTreeNode<DictionaryConcept> nodo) {
		this.level = posicion;
		this.nodo = nodo;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public GenericTreeNode<DictionaryConcept> getNodo() {
		return nodo;
	}
	public void setNodo(GenericTreeNode<DictionaryConcept> nodo) {
		this.nodo = nodo;
	}
	@Override
	public String toString() {
		return "ParIntNodo [posicion=" + level + ", nodo=" + nodo + "]";
	}
}
