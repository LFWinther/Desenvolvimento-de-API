package org.serratec.backend.projeto05.DTO;

import java.io.Serializable;
import java.time.LocalDate;


public class CartaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
private Integer id;
	
	private Double limiteCartao;
	private String numero;
	private String nomeTitular;
	private LocalDate dataValidade;
	private Integer idCliente;

	public CartaoDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLimiteCartao() {
		return limiteCartao;
	}
	public void setLimiteCartao(Double limiteCartao) {
		this.limiteCartao = limiteCartao;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
