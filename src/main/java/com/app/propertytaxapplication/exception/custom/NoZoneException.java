package com.app.propertytaxapplication.exception.custom;

import com.app.propertytaxapplication.exception.service.PropertyTaxServiceException;

public class NoZoneException extends PropertyTaxServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoZoneException() {
		super();
	}

	public NoZoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoZoneException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoZoneException(String message) {
		super(message);
	}

	public NoZoneException(Throwable cause) {
		super(cause);
	}

}
