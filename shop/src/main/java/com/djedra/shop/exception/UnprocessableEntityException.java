package com.djedra.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

	private static final long serialVersionUID = 1695693473565906617L;

	public UnprocessableEntityException(Throwable cause) {
		super(cause);
	}

}
