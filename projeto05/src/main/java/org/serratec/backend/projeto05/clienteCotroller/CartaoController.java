package org.serratec.backend.projeto05.clienteCotroller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.clienteService.CartaoService;
import org.serratec.backend.projeto05.exception.CartaoExcpetion;
import org.serratec.backend.projeto05.exception.EmailException;
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
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	CartaoService cartaoService;
	
	@GetMapping("/leitor")
	public ResponseEntity<Void> leitor() throws IOException{
		cartaoService.leitor();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CartaoDTO cartaoDTO) throws EmailException, MessagingException, CartaoExcpetion{
		return ResponseEntity.ok(cartaoService.salvar(cartaoDTO));
	}
	
	@GetMapping("/buscar/{idCartao}")
	public ResponseEntity<CartaoDTO> buscarPorId(@PathVariable Integer idCartao) throws CartaoExcpetion{
		return ResponseEntity.ok(cartaoService.buscarPorId(idCartao));
	}
	
	@PutMapping("/aualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @io.swagger.v3.oas.annotations.parameters.RequestBody CartaoDTO cartaoDTO) throws CartaoExcpetion {
		return ResponseEntity.ok(cartaoService.atualizar(idLivro, cartaoDTO));
	}
	
	@DeleteMapping("delete/{idCartao}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCartao) throws CartaoExcpetion{
		cartaoService.deletar(idCartao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<CartaoDTO>> listarTodos(){
		return ResponseEntity.ok(cartaoService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CartaoDTO> listaCartaoDTO){
		cartaoService.salvarListaCartao(listaCartaoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
