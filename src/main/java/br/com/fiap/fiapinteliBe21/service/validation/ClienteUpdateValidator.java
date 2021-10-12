package br.com.fiap.fiapinteliBe21.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.fiap.fiapinteliBe21.controller.exception.FieldMessage;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.util.BR;

/*
 * Validator
 */
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, Cliente> {
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	public boolean isValid(Cliente obj, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		
		String tc = String.valueOf(obj.getTipoCliente());
		if (tc.equals("PF")  &&
			!BR.isValidCPF(String.valueOf (obj.getCnpjOuCpf()))) {
			
			list.add(new FieldMessage("cnpjOuCpf", "CPF invalido"));
		}
		if (tc.equals("PJ")  &&
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
