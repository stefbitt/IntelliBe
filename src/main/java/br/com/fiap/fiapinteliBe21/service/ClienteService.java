package br.com.fiap.fiapinteliBe21.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;
import br.com.fiap.fiapinteliBe21.service.exception.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	/*
	 * Buscar Cliente por Id
	 */
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado " + id));
	}
	/*
	 * Listar Cliente 
	 */
	public List<Cliente> listar() {
		  return clienteRepository.findAll();
	}	
	/*
	 * Incluir um Cliente - Id Cnpj/cpf
	 */
	public Cliente incluir(Cliente cliente) {

		Optional<Cliente> obj = clienteRepository.findById(cliente.getCnpjOuCpf());
		if (!obj.isPresent()) {
			return clienteRepository.save(cliente);
		}
		throw new DataIntegrityException("Cliente = " + cliente.getCnpjOuCpf());
	}
	/*
	 * Atualizar um Cliente - Id Cnpj/cpf
	 */	
	public Cliente atualizar(Cliente cliente) {
		buscar(cliente.getCnpjOuCpf());
		return clienteRepository.save(cliente);
	}
	/*
	 * Deletar um Cliente - Id Cnpj/cpf
	 */	
	public void deletar(Long id) {
		buscar(id);
		clienteRepository.deleteById(id);
	}	
}