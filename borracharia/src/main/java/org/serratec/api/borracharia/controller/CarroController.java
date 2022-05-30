package org.serratec.api.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.api.borracharia.DTO.CarroDTO;
import org.serratec.api.borracharia.exception.CarroException;
import org.serratec.api.borracharia.service.CarroService;
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
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CarroDTO carroDTO) throws MessagingException, CarroException{
		return ResponseEntity.ok(carroService.salvar(carroDTO));
	}
	
	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException{
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}
	
	@PutMapping("/aualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody CarroDTO carroDTO) throws CarroException {
		return ResponseEntity.ok(carroService.atualizar(idLivro, carroDTO));
	}
	
	@DeleteMapping("delete/{idCarro}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCarro) throws CarroException{
		carroService.deletar(idCarro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<CarroDTO>> listarTodos(){
		return ResponseEntity.ok(carroService.todosCarros());
	}
	
}
