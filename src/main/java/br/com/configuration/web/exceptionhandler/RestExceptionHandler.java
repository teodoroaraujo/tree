package br.com.configuration.web.exceptionhandler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.configuration.web.exceptions.BadRequestException;
import br.com.configuration.web.exceptions.NodeNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 */
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		HttpStatus errorCode = HttpStatus.NOT_IMPLEMENTED;
		String errorMessage = HttpStatus.NOT_IMPLEMENTED.getReasonPhrase();
		String message = ex.getMessage();
		String className = ex.getClass().getName();
		
		ErrorDetail errorDetail = createErrorDetail(errorCode, errorMessage, message, className);
		
		return new ResponseEntity<>(errorDetail, errorCode);
	}

	

	@ExceptionHandler(NodeNotFoundException.class)
	public ResponseEntity<?> nodeNotFoundException(NodeNotFoundException re, HttpServletRequest request) {

		HttpStatus errorCode = re.getErrorCode();
		String errorMessage = re.getErrorMessage();
		String message = re.getMessage();
		String className = re.getClass().getName();

		ErrorDetail errorDetail = createErrorDetail(errorCode, errorMessage, message, className);

		return new ResponseEntity<>(errorDetail, errorCode);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException be, HttpServletRequest request) {

		HttpStatus errorCode = be.getErrorCode();
		String errorMessage = be.getErrorMessage();
		String message = be.getMessage();
		String className = be.getClass().getName();

		ErrorDetail errorDetail = createErrorDetail(errorCode, errorMessage, message, className);

		return new ResponseEntity<>(errorDetail, errorCode);
	}

	/**
	 * 
	 * @param errorCode
	 * @param errorMessage
	 * @param message
	 * @param name
	 * @return
	 */
	private ErrorDetail createErrorDetail(HttpStatus errorCode, String errorMessage, String message, String className) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setTimeStamp(new Date().getTime());
		errorDetail.setStatus(errorCode.value());
		errorDetail.setTitle(errorMessage);
		errorDetail.setDetail(message);
		errorDetail.setDeveloperMessage(className);
		return errorDetail;
	}
}
