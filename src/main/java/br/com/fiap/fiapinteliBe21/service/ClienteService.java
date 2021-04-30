package br.com.fiap.fiapinteliBe21.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.enums.TipoCliente;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * Buscar Cliente por CnpjOuCpf
	 */
	public Cliente buscar(Long CnpjOuCpf) {
		return clienteRepository.findById(CnpjOuCpf)
				.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado CNPJ/CPF: " + CnpjOuCpf));
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
	@Transactional
	public Cliente incluir(Cliente cliente) {
		
		validarCliente(cliente);
		return clienteRepository.save(cliente);
	}

	/*
	 * Atualizar um Cliente - Id Cnpj/cpf
	 */
	@Transactional
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

	/*
	 * Validar existencia do Cliente
	 */
	private void validarCliente(Cliente cliente) {
		Optional<Cliente> objCli = clienteRepository.findById(cliente.getCnpjOuCpf());
		if (objCli.isPresent()) {
			throw new DataIntegrityException("Cliente ja cadastrado " + cliente.getCnpjOuCpf());
		}

		Cliente aux = clienteRepository.findBydescricaoEmail(cliente.getDescricaoEmail());
		if (aux != null) {
			throw new DataIntegrityException("Email ja cadastrado " + cliente.getDescricaoEmail());
		}
	}

}