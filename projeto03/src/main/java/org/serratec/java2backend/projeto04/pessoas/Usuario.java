package org.serratec.java2backend.projeto04.pessoas;

public class Usuario {
	
	private Integer idUsuario;
	private Integer idConta;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario(Integer idUsuario, Integer idConta, String nome, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.idConta = idConta;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
