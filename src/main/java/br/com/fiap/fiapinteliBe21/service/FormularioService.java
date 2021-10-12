package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.repository.FormularioRepository;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository formularioRepository;
//	@Autowired
//	private ClienteService clienteService;

	public Formulario buscar(Long id) {
		return formularioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado " + id));
	}

	public List<Formulario> listarFormulario(Long cnpjOuCpf) {
		
//		Cliente cliente = clienteService.buscar(cnpjOuCpf);
//		if (cliente == null) {
//			throw new DataIntegrityException(
//					"Não encontrou Cliente: " + cnpjOuCpf);
//		}		

		List<Formulario> listas = formularioRepository.findByCnpjOuCpf(cnpjOuCpf);

		if (listas.isEmpty()) {
			throw new DataIntegrityException(
					"Não encontrou formulário do cliente: " + cnpjOuCpf);
		}
		return listas;
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
