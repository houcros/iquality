package com.indra.iquality.helper;

public class CustomXHResponse {

	private String result;
	private String textStatus;
	private String redirectUrl;

	public CustomXHResponse(String result, String textStatus, String redirectUrl) {
		this.result = result;
		this.textStatus = textStatus;
		this.redirectUrl = redirectUrl;
	}

}
