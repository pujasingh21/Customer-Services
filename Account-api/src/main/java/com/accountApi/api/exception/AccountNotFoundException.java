package com.accountApi.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)

public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String exception) {
		super(exception);
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
