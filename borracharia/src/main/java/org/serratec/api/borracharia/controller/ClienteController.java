package org.serratec.api.borracharia.controller;

import java.util.List;

import org.serratec.api.borracharia.DTO.ClienteDTO;
import org.serratec.api.borracharia.exception.ClienteException;
import org.serratec.api.borracharia.model.Cliente;
import org.serratec.api.borracharia.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO){
		clienteService.salvar(clienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer idCliente) throws ClienteException {
		clienteService.buscarPorId(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCliente}") 
    public ResponseEntity<Void> atualizar(@PathVariable Integer idCliente,@RequestBody ClienteDTO clienteDTO) {
        clienteService.atualizar(idCliente, clienteDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{idCliente}")
	public ResponseEntity<Void> delete(@PathVariable Integer idCliente) {
		clienteService.delete(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> listaTodos() {
		return ResponseEntity.ok(clienteService.listaCliente());
	}
}

