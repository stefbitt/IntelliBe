package br.com.fiap.fiapinteliBe21.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Candidato;
import br.com.fiap.fiapinteliBe21.repository.CandidatoRepository;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class CandidatoService {
	@Autowired
	private CandidatoRepository candidatoRepository;

	/*
	 * Buscar Candidato por Id
	 */
	public Candidato buscar(Long id) {
		return candidatoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Candidato não encontrado Id: " + id));
	}
	/*
	 * Listar Candidato
	 */
	public List<Candidato> listar() {
		return candidatoRepository.findAll();
	}
	/*
	 * Incluir um Candidato - Id Cnpj/cpf
	 */

	public Candidato incluir(Candidato candidato) {
		
		return candidatoRepository.save(candidato);
	}
	/*
	 * Atualizar um Candidato - Id Cnpj/cpf
	 */

	public Candidato atualizar(Candidato candidato) {
		buscar(candidato.getIdCandidato());
		return candidatoRepository.save(candidato);
	}
	/*
	 * Deletar um Candidato - Id Cnpj/cpf
	 */
	public void deletar(Long id) {
		buscar(id);
		candidatoRepository.deleteById(id);
	}
}