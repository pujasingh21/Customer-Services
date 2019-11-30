package com.accountApi.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DataBaseConnectionException extends RuntimeException{
	
	public DataBaseConnectionException(String exception)
	{
		super(exception);
	}

	public DataBaseConnectionException(String exception, Throwable cause)
	{
		super(exception,cause);
	}

}
