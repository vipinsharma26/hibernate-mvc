package com.mindtree.propertytaxapplication.exception.custom;

import com.mindtree.propertytaxapplication.exception.service.PropertyTaxServiceException;

public class NoUserException extends PropertyTaxServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUserException() {
		super();
	}

	public NoUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoUserException(String message) {
		super(message);
	}

	public NoUserException(Throwable cause) {
		super(cause);
	}

}
