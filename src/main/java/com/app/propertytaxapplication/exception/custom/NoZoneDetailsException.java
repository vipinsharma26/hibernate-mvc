package com.app.propertytaxapplication.exception.custom;

import com.app.propertytaxapplication.exception.service.PropertyTaxServiceException;

public class NoZoneDetailsException extends PropertyTaxServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoZoneDetailsException() {
		super();
	}

	public NoZoneDetailsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoZoneDetailsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoZoneDetailsException(String message) {
		super(message);
	}

	public NoZoneDetailsException(Throwable cause) {
		super(cause);
	}

}
