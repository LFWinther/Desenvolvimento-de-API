package org.serratec.api.borracharia.controller;

import javax.mail.MessagingException;

import org.serratec.api.borracharia.DTO.ServicoTDO;
import org.serratec.api.borracharia.exception.EmailException;
import org.serratec.api.borracharia.exception.ServicoException;
import org.serratec.api.borracharia.service.EmailService;
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
	public ResponseEntity<Void> enviarEmail(@PathVariable ServicoTDO serviceDTO) throws MessagingException, EmailException, ServicoException{
		emailService.emailTeste(serviceDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
