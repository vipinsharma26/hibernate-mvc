package com.app.propertytaxapplication.exception.service;

import com.app.propertytaxapplication.exception.PropertyTaxApplicationException;

public class PropertyTaxServiceException extends PropertyTaxApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyTaxServiceException() {
		super();
	}

	public PropertyTaxServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PropertyTaxServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyTaxServiceException(String message) {
		super(message);
	}

	public PropertyTaxServiceException(Throwable cause) {
		super(cause);
	}

}
