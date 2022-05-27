package org.serratec.java2backed.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.java2backed.biblioteca.DTO.LivroDTO;
import org.serratec.java2backed.biblioteca.exception.LivroException;
import org.serratec.java2backed.biblioteca.model.Livro;
import org.serratec.java2backed.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public LivroDTO livroToLivroDTO(LivroDTO livroDTO, Livro livro) {
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataPublicacao(livro.getDataPublicacao());
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTipo(livro.getTipo());
		livroDTO.setTitulo(livro.getTitulo());
		
		return livroDTO;
	}
	
	public Livro livroDTOToLivro(LivroDTO livroDTO, Livro livro) {
		livro.setAutor(livroDTO.getAutor());
		livro.setDataPublicacao(livroDTO.getDataPublicacao());
		livro.setTipo(livroDTO.getTipo());
		livro.setTitulo(livroDTO.getTitulo());
		
		return livro;
	}
	
	public String salvar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		livroDTOToLivro(livroDTO, livro);
		livroRepository.save(livro);
		return "O livro " + livro.getTitulo() + " Foi salvo.";
	}
	
	public LivroDTO buscarPorId(Integer idLivro) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNoBanco = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		
		if(livro.isPresent()) {
			livroNoBanco = livro.get();
			livroToLivroDTO(livroDTO, livroNoBanco);
		}
		return livroDTO;
	}
	
	public String atualizar(Integer idLivro, LivroDTO livroDTO) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro novoLivro = new Livro();
		
		if(livro.isPresent()) {
			novoLivro = livro.get();
			if(livroDTO.getAutor()!=null) {
				novoLivro.setAutor(livroDTO.getAutor());
			}if(livroDTO.getDataPublicacao()!=null) {
				novoLivro.setDataPublicacao(livroDTO.getDataPublicacao());				
			}if(livroDTO.getTipo()!=null) {
				novoLivro.getTipo().equals(novoLivro.getTipo());				
			}if(livroDTO.getTitulo()!=null) {
				novoLivro.setTitulo(livroDTO.getTitulo());				
			}
			livroRepository.save(novoLivro);
		}
		return "O livro com ID " + novoLivro.getIdLivro() + " foi atualizado."; 
	}
	
	public void delete(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	public List<LivroDTO> todosLivros() {
		List<Livro> lisLivros = livroRepository.findAll();
		List<LivroDTO> livroDTOs = new ArrayList<LivroDTO>();
		for (Livro livro : lisLivros) {
			LivroDTO livroDTO = new LivroDTO();
			livroToLivroDTO(livroDTO, livro);
			livroDTOs.add(livroDTO);
			
		}
		return livroDTOs;
	}
	
	public List<LivroDTO> todosLivrosDesc() {
		List<Livro> lisLivros = livroRepository.buscarLivrosDesc();
		List<LivroDTO> livroDTOs = new ArrayList<LivroDTO>();
		for (Livro livro : lisLivros) {
			LivroDTO livroDTO = new LivroDTO();
			livroToLivroDTO(livroDTO, livro);
			livroDTOs.add(livroDTO);
			
		}
		return livroDTOs;
	}
}
