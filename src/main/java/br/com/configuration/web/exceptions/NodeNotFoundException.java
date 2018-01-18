package br.com.configuration.web.exceptions;

import org.springframework.http.HttpStatus;

public class NodeNotFoundException extends GeneralException {

	private static final long serialVersionUID = 6203666924346407316L;

	public NodeNotFoundException(HttpStatus errorCode, String errorMessage, String message) {
		super(errorCode, errorMessage, message);
	}

}
