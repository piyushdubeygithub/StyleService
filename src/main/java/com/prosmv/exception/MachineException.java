package com.prosmv.exception;

public class MachineException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5828623487841772865L;

	public MachineException() {
		super();
	}

	public MachineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MachineException(String message, Throwable cause) {
		super(message, cause);
	}

	public MachineException(String message) {
		super(message);
	}

	public MachineException(Throwable cause) {
		super(cause);
	}

}
