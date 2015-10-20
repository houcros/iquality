package com.indra.iquality.model;

public enum ConceptTypeEnum {
	SECCION, 			// SEC
	MODELO,				// SUB
	ENTIDAD,			// TAB
	DIMENSION,			// D
	JERARQUIA,			// J
	ATRIBUTO_MAESTRO,	// S
	ATRIBUTO,			// A
	INDICADOR,			// I
	LINEA,				// L (lo de línea me lo inventé, preguntar qué es en verdad)
	
	UNKNOWN				// Por seguridad, pero se debería eliminar en un futuro
}
