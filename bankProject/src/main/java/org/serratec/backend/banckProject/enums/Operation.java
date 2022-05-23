package org.serratec.backend.banckProject.enums;

public enum Operation {

	DEBITO("debito"), CREDITO("credito");
	private final String tipoOperacao;

	private Operation(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}
	
	
}
