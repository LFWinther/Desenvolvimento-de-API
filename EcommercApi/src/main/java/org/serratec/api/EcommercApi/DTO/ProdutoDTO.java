package org.serratec.api.EcommercApi.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class ProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Double valor;
	private LocalDate dataValidade;
	private Integer qntEstoque;
	private LocalDate periodoVld;
	private Integer idFuncionario;
	
	public ProdutoDTO() {
		super();
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getQntEstoque() {
		return qntEstoque;
	}

	public void setQntEstoque(Integer qntEstoque) {
		this.qntEstoque = qntEstoque;
	}

	public LocalDate getPeriodoVld() {
		return periodoVld;
	}

	public void setPeriodoVld(LocalDate periodoVld) {
		this.periodoVld = periodoVld;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
}
