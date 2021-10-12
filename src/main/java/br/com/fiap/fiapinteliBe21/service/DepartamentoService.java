package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.Departamento;
import br.com.fiap.fiapinteliBe21.repository.DepartamentoRepository;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private ClienteService clienteService;

	/*
	 * Buscar Departamento por Id
	 */
	public Departamento buscar(Long id) {
		return departamentoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id Depto não encontrado " + id));
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

		Cliente obj = clienteService.buscar(departamento.getCnpjOuCpf());
		departamento.setCliente(obj);
		return departamentoRepository.save(departamento);
	}
	/*
	 * Atualizar um Departamento
	 */
	@Transactional
	public Departamento atualizar(Departamento departamento) {
		buscar(departamento.getIdDepto());
		
		Cliente obj;
		try {
			obj = clienteService.buscar(departamento.getCnpjOuCpf());
		} catch (Exception e) {
			throw new ObjectNotFoundException("Cnpj/cpf Cliente não encontrado " + departamento.getCnpjOuCpf());
		}
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