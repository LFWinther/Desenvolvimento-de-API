package org.serratec.api.borracharia.model;

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
@Table(name = "servico")
public class Servico implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_cd_id")
	private Integer idServico;
	
	@Column(name = "servico_num_valor")
	private Double valor;
	
	@Column(name = "servico_tx_servPrestado")
	private String servPrest;
	
	@Column(name = "servico_dt_data")
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "carro_id", referencedColumnName = "carro_cd_id")
	@JsonIgnore
	private Carro carro;
	
	public Servico() {
		super();
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getServPrest() {
		return servPrest;
	}

	public void setServPrest(String servPrest) {
		this.servPrest = servPrest;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}
