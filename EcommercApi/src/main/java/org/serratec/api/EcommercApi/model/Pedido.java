package org.serratec.api.EcommercApi.model;

import java.io.Serializable;

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
@Table(name="pedido")
public class Pedido implements Serializable{

		
	private static final long serialVersionUID = 3079328192000458464L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pedido_cd_id")
	private Integer idPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "produto_cd_id")
	@JsonIgnore
	private Produto produto;

	@Column(name="valor_total")
	private Double valorTotal;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}