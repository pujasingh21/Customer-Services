package com.customerApi.api.exception;

import java.util.Date;

import org.hibernate.exception.JDBCConnectionException;
<<<<<<< HEAD
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
=======
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

<<<<<<< HEAD
	@ExceptionHandler(CannotCreateTransactionException.class)
	public final ResponseEntity<ErrorDetails> handleDatabaseExceptions(CannotCreateTransactionException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public final ResponseEntity<ErrorDetails> handleDatabaseExceptions(EmptyResultDataAccessException ex, WebRequest request) {
=======
	@ExceptionHandler(JDBCConnectionException.class)
	public final ResponseEntity<ErrorDetails> handleDatabaseExceptions(JDBCConnectionException ex, WebRequest request) {
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getLocalizedMessage(), request.getDescription(true));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(),
				request.getDescription(true));
		return new ResponseEntity<ErrorDetails>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
