package br.com.fiap.fiapinteliBe21.service.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import br.com.fiap.fiapinteliBe21.controller.exception.StandardError;

public class DataRecordFoundException {

	public StandardError entityDuplicate (DataIntegrityException e, Long id){
		
		StandardError err = new StandardError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setError("Recurso já cadastrado ");
		err.setMessage(e.getMessage());
		err.setPath(null);
		return err;
	}
}	