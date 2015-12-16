/*
 * 
 */
package com.indra.iquality.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.singleton.Environment;

/**
 * The Class DataHelper. Provides a set of auxiliary methods related to data
 * filtering and conversion needed for the DAOs.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class DataHelper.
 */
public class DataHelper {

	/**
	 * Converts a String to its equivalent representation as one of the concept
	 * type defined in the system, if possible.
	 *
	 * @param type
	 *            the type of the concept
	 * @return the concept translated to the system representation, or the
	 *         default "unknown" value if no possible translation.
	 * @see com.indra.iquality.model.ConceptTypeEnum
	 */
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

	/**
	 * Translates a String representation of a timestamp to an SQLDate.
	 *
	 * @param tmstmp
	 *            the timestamp
	 * @return the parsed date, or the default date defined in the
	 *         {@link com.indra.iquality.singleton.Environment} for a null
	 *         String
	 * @throws ParseException
	 *             if the String was not formatted as a timestamp
	 */
	public Date filterStringToSqlDate(String tmstmp) throws ParseException {

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

	/**
	 * Filters a string in case it is null.
	 *
	 * @param s
	 *            the String
	 * @return if the String is null or holds the value "null", returns the
	 *         default {@link com.indra.iquality.singleton.Environment}
	 *         definition for a null String. Otherwise, returns the input
	 *         parameter.
	 */
	public String filterNullString(String s) {
		if (s != null)
			return s;
		return Environment.DEFAULT_NULL_STRING;
	}

	/**
	 * Filters a string in case it is null an returns its representation as an
	 * integer.
	 *
	 * @param s
	 *            the String
	 * @return if the String is null or holds the value "null", returns the
	 *         default {@link com.indra.iquality.singleton.Environment}
	 *         definition for a null integer. Otherwise, returns the integer
	 *         representation of the input parameter.
	 */
	public int filterStringToInt(String s) {
		if (s == null || s == "null")
			return Environment.DEFAULT_NULL_INT;
		else
			return Integer.valueOf(s);
	}

	/**
	 * Filters a string in case it is null an returns its representation as a
	 * double.
	 *
	 * @param s
	 *            the String
	 * @return if the String is null or holds the value "null", returns the
	 *         default {@link com.indra.iquality.singleton.Environment}
	 *         definition for a null double. Otherwise, returns the double
	 *         representation of the input parameter.
	 */
	public double filterStringToDouble(String s) {
		if (s == null || s == "null")
			return Environment.DEFAULT_NULL_DOUBLE;
		else
			return Double.valueOf(s);
	}

}
