package org.serratec.backend.projeto05.exception;

public class EmailException extends Exception {
	
	private static final long serialVersionUID=1L ;
	
	public EmailException() {
		
	}

	public EmailException(String message) {
		super(message);
	}
	

	public EmailException(String message, Exception cause) {
		super(message, cause);
	}
	
	public EmailException(Exception e) {
		super(e);
	}
}
