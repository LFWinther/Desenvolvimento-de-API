package org.serratec.java2backend.projeto04.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {

	@ExceptionHandler(SystenException.class)
	public ResponseEntity<String> trataTodoNotFound(SystenException exception){
		String msg = String.format("O usuario com o ID %d nao foi encontrado", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "TODO NOT FOUND")
				.header("x-erro-value",exception.getId().toString())
				.build();
	}
}
