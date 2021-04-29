package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.repository.FormularioRepository;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository formularioRepository;

	public Formulario buscar(Long id) {
		return formularioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado " + id));
	}

	public List<Formulario> listarFormulario() {
		return formularioRepository.findAll();
	}

	public Formulario atualizarFormulario(Long formularioId, Formulario formularioRequest) {
		buscar(formularioId);
		formularioRequest.setIdFormulario(formularioId);
		return formularioRepository.save(formularioRequest);
	}
	
	public Formulario save(Formulario formularioRequest) {
		return formularioRepository.save(formularioRequest);
	}

	public void deletarFormulario(Long id) {
		buscar(id);
		formularioRepository.deleteById(id);
	}

}
