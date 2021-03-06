package co.com.nuvu.user.services.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionErrorInfo implements Serializable{

	private static final long serialVersionUID = -7379874768930527552L;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("uri")
	private String uriRequested;

	public ExceptionErrorInfo(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

}
