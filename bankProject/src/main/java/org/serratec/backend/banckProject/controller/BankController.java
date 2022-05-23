package org.serratec.backend.banckProject.controller;

import java.util.List;

import org.serratec.backend.banckProject.enums.Operation;
import org.serratec.backend.banckProject.exception.InsufficientFunds;
import org.serratec.backend.banckProject.exception.OperationInvalid;
import org.serratec.backend.banckProject.model.Conta;
import org.serratec.backend.banckProject.service.BankService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Conta conta){
		bankService.adicionar(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{numero}")
	public ResponseEntity<Conta> buscarPorNum(@PathVariable String numero){
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{numero}")
	public ResponseEntity<Void> atualizar(@PathVariable String numero, @RequestBody Conta conta){
		bankService.atualizar(numero, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{numero}")
	public ResponseEntity<Void> delete(@PathVariable String numero, @RequestBody Conta conta){
		bankService.delete(conta.getNumero());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Conta>> listaContas(){
		return ResponseEntity.ok(bankService.listaContas());
	}
	
	@PostMapping("/{numero}")
	public ResponseEntity<Void> debito(@PathVariable String numero, @RequestParam Operation operacao, @RequestParam Double valor) throws InsufficientFunds, OperationInvalid{
		bankService.operacao(operacao, numero, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
