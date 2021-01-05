package com.mindtree.propertytaxapplication.exception;

public class PropertyTaxApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyTaxApplicationException() {
		super();
	}

	public PropertyTaxApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PropertyTaxApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyTaxApplicationException(String message) {
		super(message);
	}

	public PropertyTaxApplicationException(Throwable cause) {
		super(cause);
	}

}
