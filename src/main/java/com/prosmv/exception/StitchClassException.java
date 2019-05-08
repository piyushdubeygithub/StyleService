package com.prosmv.exception;

public class StitchClassException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8363570105544610793L;

	public StitchClassException() {
		super();
	}

	public StitchClassException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StitchClassException(String message, Throwable cause) {
		super(message, cause);
	}

	public StitchClassException(String message) {
		super(message);
	}

	public StitchClassException(Throwable cause) {
		super(cause);
	}

	
}
