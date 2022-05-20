package org.serratec.java2backend.projeto04.exception;

public class SystenException extends Exception{

	private static final long serialVersionUID = 1L;

	private Integer id;

	public SystenException(Integer id) {
		this.id = id;
	}

	public SystenException() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
