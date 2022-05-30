package org.serratec.api.borracharia.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import org.serratec.api.borracharia.model.Carro;


public class ServicoTDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idServico;
	private Double valor;
	private String servPrest;
	private LocalDate data;
	private Carro carro;
	
	public ServicoTDO() {
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
