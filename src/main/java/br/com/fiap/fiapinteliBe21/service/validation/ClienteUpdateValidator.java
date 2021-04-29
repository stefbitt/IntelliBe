package br.com.fiap.fiapinteliBe21.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.fiap.fiapinteliBe21.controller.exception.FieldMessage;
import br.com.fiap.fiapinteliBe21.domain.Cliente;

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
		
//		if	(obj.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) &&
//			!BR.isValidCPF(obj.getCpfOuCnpj())) {
//			
//			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
//		}
//		if	(obj.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) &&
//				!BR.isValidCNPJ(obj.getCpfOuCnpj())) {
//			
//			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
//		}
//		Optional<Cliente> objAux = repo.findById(obj.getCnpjOuCpf());
//		if (!obj.isPresent()) {
//			return clienteRepository.save(cliente);
//		}
//		

		
		for (FieldMessage e : list) {
			 context.disableDefaultConstraintViolation();
			 context.buildConstraintViolationWithTemplate(e.getMessage())
			 .addPropertyNode(e.getFieldName()).addConstraintViolation();
		 }
		return list.isEmpty();
	}
}
