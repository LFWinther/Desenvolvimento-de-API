package org.serratec.backend.banckProject.exception;

public class InsufficientFunds extends Exception{

	private static final long serialVersionUID = 3983969313305540923L;

	public InsufficientFunds() {
		super();
	}

	public InsufficientFunds(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsufficientFunds(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientFunds(String message) {
		super(message);
	}

	public InsufficientFunds(Throwable cause) {
		super(cause);
	}
	
}
