package org.serratec.api.borracharia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_cd_id")
	private Integer idCliente;

	@Column(name = "cliente_tx_nome")
	private String nome;
	
	@Column(name = "cliente_tx_cpf")
	private String cpf;
	
	@Column(name = "cliente_tx_telefone")
	private String telefone;
	
	@Column(name = "cliente_ts_email")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Carro> listCarros;
	
	public Cliente() {
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
