package com.indra.iquality.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
