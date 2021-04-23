package br.com.fiap.fiapinteliBe21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.service.exception.EntityNotFoundException;


@Service
public class ClienteService {
//	@Autowired
//	private DepartamentoRepository departamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
   
    public Cliente 	findById(Long id) {
   		return	clienteRepository.findById(id).orElseThrow(
    				() -> new EntityNotFoundException("Id não encontrado " + id));
   	}

//	public Cliente insert(Cliente cliente) {
//		cliente.setIdCliente(null);
//		cliente.setSenha(criptografarSenha(cliente.getSenha()));
//		return clienteRepository.save(cliente);
//	}
//	
//	public String criptografarSenha(String senha) {
//		try {
//			return CriptografiaUtils.criptografar(senha);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}	
}
