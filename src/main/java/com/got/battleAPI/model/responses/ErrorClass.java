package com.got.battleAPI.model.responses;

public class ErrorClass {
	
	Integer statusCode;
	
	String message;

	public ErrorClass() {
	}

	public ErrorClass(Integer statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
