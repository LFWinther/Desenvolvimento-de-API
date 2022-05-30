package org.serratec.api.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.api.borracharia.DTO.ServicoTDO;
import org.serratec.api.borracharia.exception.ServicoException;
import org.serratec.api.borracharia.service.ServicoService;
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
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ServicoTDO servicoDTO) throws MessagingException, ServicoException{
		return ResponseEntity.ok(servicoService.salvar(servicoDTO));
	}
	
	@GetMapping("/buscar/{idServico}")
	public ResponseEntity<ServicoTDO> buscarPorId(@PathVariable Integer idServico) throws ServicoException{
		return ResponseEntity.ok(servicoService.buscarPorId(idServico));
	}
	
	@PutMapping("/aualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody ServicoTDO servicoDTO) throws ServicoException {
		return ResponseEntity.ok(servicoService.atualizar(idLivro, servicoDTO));
	}
	
	@DeleteMapping("delete/{idServico}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idServico) throws ServicoException{
		servicoService.deletar(idServico);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ServicoTDO>> listarTodos(){
		return ResponseEntity.ok(servicoService.todosServicos());
	}
}
