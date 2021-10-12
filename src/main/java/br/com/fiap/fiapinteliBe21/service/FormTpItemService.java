package br.com.fiap.fiapinteliBe21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.FormTpItem;
import br.com.fiap.fiapinteliBe21.repository.FormTpItemRepository;
import br.com.fiap.fiapinteliBe21.service.exception.ObjectNotFoundException;

@Service
public class FormTpItemService {
	
	@Autowired
	private FormTpItemRepository formTpItemRepository;
	
	public FormTpItem buscarItem(Long id) {
		return formTpItemRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado " + id));
	}

	public List<FormTpItem> listarItem() {
		return formTpItemRepository.findAll();
	}

	public FormTpItem atualizarItem(FormTpItem formTpItem) {
		buscarItem(formTpItem.getIdTipoItens());
		return formTpItemRepository.save(formTpItem);
	}

	public void deletarItem(Long id) {
		buscarItem(id);
		formTpItemRepository.deleteById(id);
	}

}
