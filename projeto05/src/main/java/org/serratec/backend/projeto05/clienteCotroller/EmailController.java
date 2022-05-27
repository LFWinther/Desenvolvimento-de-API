package org.serratec.backend.projeto05.clienteCotroller;

import javax.mail.MessagingException;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.clienteService.EmailService;
import org.serratec.backend.projeto05.exception.CartaoExcpetion;
import org.serratec.backend.projeto05.exception.EmailExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/email")
	public ResponseEntity<Void> enviarEmail(@PathVariable CartaoDTO cartaoDTO) throws MessagingException, EmailExecption, CartaoExcpetion{
		emailService.emailTeste(cartaoDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}