package org.serratec.api.EcommercApi.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_cd_id")
	private Integer idProduto;
	
	@Column(name = "produto_tx_nome")
	private String nome;
	
	@Column(name = "produto_tx_descricao")
	private String descricao;
	
	@Column(name = "produto_nu_valor")
	private Double valor;
	
	@Column(name = "produto_dt_dataValidade")
	private LocalDate dataValidade;
	
	@Column(name = "produto_nu_qntEstoque")
	private Integer qntEstoque;
	
	@Column(name = "produto_dt_periodoValidade")
	private LocalDate periodoVld;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_cd_id")
	@JsonIgnore
	private Funcionario funcionario;
	
	public Produto() {
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
