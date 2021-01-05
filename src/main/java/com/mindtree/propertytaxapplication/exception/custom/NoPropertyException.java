package com.mindtree.propertytaxapplication.exception.custom;

import com.mindtree.propertytaxapplication.exception.service.PropertyTaxServiceException;

public class NoPropertyException extends PropertyTaxServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPropertyException() {
		super();
	}

	public NoPropertyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoPropertyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoPropertyException(String message) {
		super(message);
	}

	public NoPropertyException(Throwable cause) {
		super(cause);
	}

}
