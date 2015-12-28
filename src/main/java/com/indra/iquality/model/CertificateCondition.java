package com.indra.iquality.model;

public class CertificateCondition {

	private String errorCode;
	private String errorDescription;
	private String condition;
	private String table;
	private String field;
	private String boolValidate;
	private String boolErrorCondition;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getCondition() {
		return condition;
	}

	public String getTable() {
		return table;
	}

	public String getField() {
		return field;
	}

	public String getBoolValidate() {
		return boolValidate;
	}

	public String getBoolErrorCondition() {
		return boolErrorCondition;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setBoolValidate(String boolValidate) {
		this.boolValidate = boolValidate;
	}

	public void setBoolErrorCondition(String boolErrorCondition) {
		this.boolErrorCondition = boolErrorCondition;
	}

}
