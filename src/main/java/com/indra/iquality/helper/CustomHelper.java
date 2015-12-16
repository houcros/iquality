package com.indra.iquality.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.singleton.Environment;

public class CustomHelper {

	public ConceptTypeEnum conceptTypeStringToEnum(String type) {

		switch (type) {
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
		}
	}

	/*
	 * Pasa un string que representa un timestamp a una SQLDate
	 */
	public Date auxStringToSqlDate(String tmstmp) throws ParseException {

		// Acá filtro los nulls
		if (tmstmp == null)
			return Environment.DEFAULT_NULL_DATE;

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Timestamp timestamp;
		try {
			timestamp = Timestamp.valueOf(tmstmp);
		} catch (IllegalArgumentException e) {
			return Environment.DEFAULT_NULL_DATE;
		}

		java.util.Date util_date = dateFormat.parse(dateFormat.format(timestamp));
		Date sql_date = new Date(util_date.getTime());

		return sql_date;
	}

	public String filterNullString(String s) {
		if (s != null)
			return s;
		return Environment.DEFAULT_NULL_STRING;
	}

	public int filterStringToInt(String s) {
		if (s == null || s == "null")
			return Environment.DEFAULT_NULL_INT;
		else
			return Integer.valueOf(s);
	}

	public double filterStringToDouble(String s) {
		if (s == null || s == "null")
			return Environment.DEFAULT_NULL_DOUBLE;
		else
			return Double.valueOf(s);
	}

}
