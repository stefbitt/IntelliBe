package br.com.fiap.fiapinteliBe21.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErrorMain> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){
		StandardErrorMain err = new StandardErrorMain(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()); 
		
		return 	ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardErrorMain> DataIntegrity (DataIntegrityException e, HttpServletRequest request){
		StandardErrorMain err = new StandardErrorMain(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()); 
		
		return 	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrorMain> validation (MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis()); 
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		} 
		return 	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
