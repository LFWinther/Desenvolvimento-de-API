package org.serratec.api.borracharia.DTO;

import java.util.List;

import org.serratec.api.borracharia.model.Carro;

public class ClienteDTO {

	private Integer idCliente;

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private List<Carro> listCarros;
	
	public ClienteDTO() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Carro> getListCarros() {
		return listCarros;
	}

	public void setListCarros(List<Carro> listCarros) {
		this.listCarros = listCarros;
	}
	
}
