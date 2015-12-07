package com.fms.exception;

@SuppressWarnings("serial")
public class FMSGenericException extends RuntimeException {
	
	private String errorMessage;
	
	public FMSGenericException(String errorMessage){
		
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
