package com.indra.iquality.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.iquality.model.ConceptTypeEnum;

public class CustomHelper {

	/*
	 * Pasa un string que representa un timestamp a una SQLDate
	 */
	public Date auxStringToSqlDate(String tmstmp) throws ParseException{
		
		DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Timestamp timestamp = Timestamp.valueOf(tmstmp);
		java.util.Date util_date = dateFormat.parse(dateFormat.format(timestamp));
		Date sql_date = new Date(util_date.getTime());
		
		return sql_date;
	}
	
	public ConceptTypeEnum conceptTypeStringToEnum(String type) throws Exception{
		
		switch(type){
			case "SEC":
			case "SECCION":
				return ConceptTypeEnum.SECCION;
			case "SUB":
			case "SUBSECCION":
				return ConceptTypeEnum.SUBSECCION;
			case "TAB":
			case "ENTIDAD":
				return ConceptTypeEnum.ENTIDAD;
			case "D":
			case "DIMENSION":
				return ConceptTypeEnum.DIMENSION;
			case "J":
			case "JERARQUIA":
				return ConceptTypeEnum.JERARQUIA;
			case "S":
			case "ATRIBUTO_MAESTRO":
				return ConceptTypeEnum.ATRIBUTO_MAESTRO;
			case "A":
			case "ATRIBUTO":
				return ConceptTypeEnum.ATRIBUTO;
			case "I":
			case "INDICADOR":
				return ConceptTypeEnum.INDICADOR;
			case "L":
			case "LITERAL":
				return ConceptTypeEnum.LITERAL;
			default:
				return ConceptTypeEnum.UNKNOWN;
//				throw new Exception("El tipo pasado no es ninguno de los aceptados: SEC, SUB, TAB, D, J, S, A");
		}
	}
}
