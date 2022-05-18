package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HelloWorldController {
	
	@RequestMapping("/teste")
	public String olaMundo() {
		return "Olá mundo";
	}
	
	@RequestMapping("/maiuscula")
	public String toUpper(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
