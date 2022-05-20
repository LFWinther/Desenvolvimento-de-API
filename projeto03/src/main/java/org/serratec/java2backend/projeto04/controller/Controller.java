package org.serratec.java2backend.projeto04.controller;
import java.util.List;

import org.serratec.java2backend.projeto04.exception.SystenException;
import org.serratec.java2backend.projeto04.pessoas.Usuario;
import org.serratec.java2backend.projeto04.service.SystenService;
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
@RequestMapping("/todo")
public class Controller {

	@Autowired
	SystenService systenService;
	
	@GetMapping("/lista")
	public List<Usuario> getUsuario() {
		return systenService.usuarios;
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Usuario usuario) {
		systenService.adicionar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<Usuario> buscarPorIdUsuario(@PathVariable Integer idUsuario) throws SystenException{
		return ResponseEntity.ok(systenService.buscarPorIdUsuario(idUsuario));
	}
	
	@PutMapping("/atualizar/{idUsuario}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idUsuario, @RequestBody Usuario usuariosApi) {
		systenService.atualizar(idUsuario, usuariosApi);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{idUsuario}")
	public ResponseEntity<Void> deletar (@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
