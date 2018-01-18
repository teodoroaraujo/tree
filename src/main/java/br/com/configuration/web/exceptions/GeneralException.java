package br.com.configuration.web.exceptions;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private HttpStatus errorCode;
	private String errorMessage;
	private String message;

	public GeneralException(HttpStatus errorCode, String errorMessage, String message) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.message = message;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
