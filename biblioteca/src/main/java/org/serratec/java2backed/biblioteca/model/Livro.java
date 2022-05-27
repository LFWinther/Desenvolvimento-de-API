package org.serratec.java2backed.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "livro")
public class Livro {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_id")
	private Integer idLivro;

	@Column(name = "livro_tx_titlulo")
	@NotNull
	@Size(min=5, max=30)
	private String titulo;

	@Column(name = "livro_tx_tipo")
	@NotNull
	@Size(min=3, max=20)
	private String tipo;

	@Column(name = "livro_tx_autor")
	@NotNull
	@Size(min=10, max=40)
	private String autor;

	@Column(name = "livro_dt_dataPublicação")
	private LocalDate dataPublicacao;

	public Livro() {
	}

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