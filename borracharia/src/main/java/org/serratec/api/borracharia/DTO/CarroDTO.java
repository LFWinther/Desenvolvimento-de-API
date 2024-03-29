package org.serratec.api.borracharia.DTO;

import java.io.Serializable;

public class CarroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCarro;
	private String modelo;
	private String marca;
	private String ano;
	private Integer IdCliente;
	
	public CarroDTO() {
		super();
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

}
