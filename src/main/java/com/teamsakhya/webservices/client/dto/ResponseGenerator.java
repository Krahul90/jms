package com.teamsakhya.webservices.client.dto;


public class ResponseGenerator{

	private int statusCode;
	private String message;
	private String description;


	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ResponseGenerator [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ "]";
	}


}
