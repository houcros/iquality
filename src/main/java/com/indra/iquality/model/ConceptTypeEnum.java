/*
 * 
 */
package com.indra.iquality.model;

/**
 * The Enum ConceptTypeEnum. Holds the possible types of the concepts in the
 * dictionary of concepts.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Enum ConceptTypeEnum.
 */
public enum ConceptTypeEnum {

	/** The section. */
	SECCION, // SEC
	/** The subsection. */
	SUBSECCION, // SUB
	/** The entity. */
	ENTIDAD, // TAB
	/** The dimension. */
	DIMENSION, // D
	/** The hierarchy. */
	JERARQUIA, // J
	/** The master attribute. */
	ATRIBUTO_MAESTRO, // S
	/** The attribute. */
	ATRIBUTO, // A
	/** The indicator. */
	INDICADOR, // I
	/** The literal. */
	LITERAL, // L
	/** For safety, unknown if not any of the above. */
	UNKNOWN // Por seguridad, pero se debería eliminar en un futuro
}
