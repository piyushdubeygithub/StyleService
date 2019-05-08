package com.prosmv.exception;

public class StyleException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5889739244443385358L;

	public StyleException() {
		super();
	}

	public StyleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StyleException(String message, Throwable cause) {
		super(message, cause);
	}

	public StyleException(String message) {
		super(message);
	}

	public StyleException(Throwable cause) {
		super(cause);
	}

}
