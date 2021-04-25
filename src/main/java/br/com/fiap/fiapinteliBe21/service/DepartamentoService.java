package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.Departamento;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.repository.DepartamentoRepository;
import br.com.fiap.fiapinteliBe21.service.exception.EntityNotFoundException;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * Buscar Departamento por Id
	 */
	public Departamento buscar(Long id) {
		return departamentoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id Depto não encontrado " + id));
	}
	/*
	 * Buscar Departamento por Id
	 */
	public Cliente buscarCliente(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id Cliente não encontrado " + id));
	}

	/*
	 * Listar Departamento
	 */
	public List<Departamento> listar() {
		return departamentoRepository.findAll();
	}

	/*
	 * Incluir um Departamento
	 */
	@Transactional
	public Departamento incluir(Departamento departamento) {
    	System.out.println("SVc Cliente = " + departamento);

		Cliente obj = buscarCliente(departamento.getCnpjOuCpf());
		departamento.setCliente(obj);
		return departamentoRepository.save(departamento);
	}

	/*
	 * Atualizar um Departamento
	 */
	public Departamento atualizar(Departamento departamento) {
		buscar(departamento.getIdDepto());
		Cliente obj = buscarCliente(departamento.getCnpjOuCpf());
		departamento.setCliente(obj);
		return departamentoRepository.save(departamento);
	}

	/*
	 * Deletar um Departamento
	 */
	public void deletar(Long id) {
		buscar(id);
		departamentoRepository.deleteById(id);
	}
}