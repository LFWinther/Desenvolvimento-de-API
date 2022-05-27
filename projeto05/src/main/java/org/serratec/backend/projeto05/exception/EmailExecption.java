package org.serratec.backend.projeto05.exception;

public class EmailExecption extends Exception {
	
	private static final long serialVersionUID=1L ;
	
	public EmailExecption() {
		
	}

	public EmailExecption(String message) {
		super(message);
	}
	

	public EmailExecption(String message, Exception cause) {
		super(message, cause);
	}
	
	public EmailExecption(Exception e) {
		super(e);
	}
}
