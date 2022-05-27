package org.serratec.java2backed.biblioteca.DTO;

import java.time.LocalDate;

public class LivroDTO {
	
	private static final long serialVersionUID = 1L;

	private Integer idLivro;
	public String titulo;
	public String tipo;
	public String autor;
	public LocalDate dataPublicacao;
	
	public LivroDTO() {}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
