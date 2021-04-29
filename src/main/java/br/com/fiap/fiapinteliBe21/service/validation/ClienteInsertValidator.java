package br.com.fiap.fiapinteliBe21.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.fiap.fiapinteliBe21.controller.exception.FieldMessage;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.enums.TipoCliente;
import br.com.fiap.fiapinteliBe21.util.BR;

/*
 * Validator
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, Cliente> {
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	public boolean isValid(Cliente obj, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		

		if	(obj.getTipoCliente().equals(2) &&
			!BR.isValidCPF(String.valueOf (obj.getCnpjOuCpf()))) {
			
			list.add(new FieldMessage("cnpjOuCpf", "CPF invalido"));
		}
		if	(obj.getTipoCliente().equals(1) &&
			!BR.isValidCNPJ(String.valueOf (obj.getCnpjOuCpf()))) {
			
			list.add(new FieldMessage("cnpjOuCpf", "CNPJ invalido"));
		}
		
		for (FieldMessage e : list) {
			 context.disableDefaultConstraintViolation();
			 context.buildConstraintViolationWithTemplate(e.getMessage())
			 .addPropertyNode(e.getFieldName()).addConstraintViolation();
		 }
		return list.isEmpty();
	}
}
