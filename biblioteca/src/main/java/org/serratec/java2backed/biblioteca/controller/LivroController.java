package org.serratec.java2backed.biblioteca.controller;

import java.util.List;

import org.serratec.java2backed.biblioteca.DTO.LivroDTO;
import org.serratec.java2backed.biblioteca.exception.LivroException;
import org.serratec.java2backed.biblioteca.model.Livro;
import org.serratec.java2backed.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody LivroDTO livroDTO){
		return ResponseEntity.ok(livroService.salvar(livroDTO));
	}
	
	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Integer idLivro) throws LivroException{
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody LivroDTO livroDTO) {
		return ResponseEntity.ok(livroService.atualizar(idLivro, livroDTO));
	}
	
	@DeleteMapping("/delete/{idLivro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idLivro) {
		livroService.delete(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<LivroDTO>> todosLivros(){
		return ResponseEntity.ok(livroService.todosLivros());
	}

	@GetMapping("/listaDesc")
	public ResponseEntity<List<LivroDTO>> todosLivrosDesc(){
		return ResponseEntity.ok(livroService.todosLivrosDesc());
	}
	
}
