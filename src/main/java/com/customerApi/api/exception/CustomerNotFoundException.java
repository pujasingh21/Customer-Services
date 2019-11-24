package com.customerApi.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
<<<<<<< HEAD

=======
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String exception) {
		super(exception);
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
