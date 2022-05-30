package org.serratec.api.borracharia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {

	@ExceptionHandler(value 
		      = {ClienteException.class})
	protected ResponseEntity<Object> naoEncontrado(ClienteException ex) {		
	       APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
	       return buildResponseEntity(apiError);
	   }

	@ExceptionHandler(value 
			= {CarroException.class})
	protected ResponseEntity<Object> naoEncontrado(CarroException ex) {		
		APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ex.getLocalizedMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(value 
			= {ServicoException.class})
	protected ResponseEntity<Object> naoEncontrado(ServicoException ex) {		
		APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ex.getLocalizedMessage());
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
}
