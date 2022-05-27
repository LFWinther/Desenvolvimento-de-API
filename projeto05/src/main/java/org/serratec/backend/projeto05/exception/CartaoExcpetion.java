package org.serratec.backend.projeto05.exception;

public class CartaoExcpetion extends Exception {

	private static final long serialVersionUID=1L ;
	
	public CartaoExcpetion() {
		super();
	}
	
	public CartaoExcpetion(String message) {
		super(message);
	}
	

	public CartaoExcpetion(String message, Exception cause) {
		super(message, cause);
	}
	
	public CartaoExcpetion(Exception e) {
		super(e);
	}
}
