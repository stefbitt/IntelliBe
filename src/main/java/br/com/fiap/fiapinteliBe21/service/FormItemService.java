package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.FormItem;
import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.repository.FormItemRepository;
import br.com.fiap.fiapinteliBe21.service.exception.EntityNotFoundException;

@Service
public class FormItemService {

	@Autowired
	private FormItemRepository formItemRepository;
	
	@Autowired
	private FormularioService formularioService;

	public FormItem buscarItem(Long id) {
		return formItemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado " + id));
	}

	public List<FormItem> listarItem() {
		return formItemRepository.findAll();
	}

	public FormItem atualizarItem(FormItem formItem) {
		buscarItem(formItem.getIdItensForm());
		return formItemRepository.save(formItem);
	}

	public FormItem save(Long formularioId, FormItem formItem) {
		Formulario formulario = formularioService.buscar(formularioId);
		formItem.setFormulario(formulario);
		return formItemRepository.save(formItem);
	}

	public void deletarItem(Long id) {
		buscarItem(id);
		formItemRepository.deleteById(id);
	}

}
