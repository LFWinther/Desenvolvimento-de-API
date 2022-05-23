package org.serratec.backend.banckProject.exception;

public class OperationInvalid extends Exception{

	private static final long serialVersionUID = -5956569803311641641L;

	public OperationInvalid() {}

	public OperationInvalid(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OperationInvalid(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationInvalid(String message) {
		super(message);
	}

	public OperationInvalid(Throwable cause) {
		super(cause);
	}
	
	
}
