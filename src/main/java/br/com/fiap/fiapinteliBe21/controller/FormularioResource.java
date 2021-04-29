package br.com.fiap.fiapinteliBe21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapinteliBe21.domain.FormItem;
import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.service.FormItemService;
import br.com.fiap.fiapinteliBe21.service.FormularioService;

@RestController
@RequestMapping("/form")
public class FormularioResource {

	@Autowired
	private FormularioService formularioService;

	@Autowired
	private FormItemService formItemService;

	@GetMapping
	public ResponseEntity<List<Formulario>> getFormulario() {
		return ResponseEntity.ok(formularioService.listarFormulario());
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Formulario> saveFormulario(@RequestBody Formulario formularioRequest) {
		return ResponseEntity.ok(formularioService.save(formularioRequest));
	}

	@PutMapping("/{formularioId}")
	public ResponseEntity<Formulario> updateFormulario(@PathVariable("formularioId") Long formularioId,
			@RequestBody Formulario formularioRequest) {
		return ResponseEntity.ok(formularioService.atualizarFormulario(formularioId, formularioRequest));
	}
	
	@DeleteMapping("/{formularioId}")
	public	ResponseEntity<Void> deletarFormularioId(@PathVariable Long formularioId) throws Exception {
		try{
			formularioService.deletarFormulario(formularioId);
		} catch(DataIntegrityViolationException ex) {
			throw new Exception("Não pode remover com itens filhos associados");
		}
    	
		return ResponseEntity.noContent().build();
    }

	@PostMapping("/{formularioId}/pergunta")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<FormItem> savePerguntaFormulario(@PathVariable("formularioId") Long formularioId,
			@RequestBody FormItem perguntaRequest) {
		return ResponseEntity.ok(formItemService.save(formularioId, perguntaRequest));
	}
	
	@PutMapping("/{formularioId}/pergunta/{formIdItem}")
	public ResponseEntity<FormItem> updatePerguntaFormulario(@PathVariable("formIdItem") Long formIdItem,
			@RequestBody FormItem formularioPerguntaRequest) {
		return ResponseEntity.ok(formItemService.atualizarItem(formularioPerguntaRequest));
	}
	
	@DeleteMapping("/{formularioId}/pergunta/{formIdItem}")
	public	ResponseEntity<Void> deletarFormularioPerguntaId(@PathVariable Long formIdItem) {
    	formItemService.deletarItem(formIdItem);
		return ResponseEntity.noContent().build();
    }
	
	

}
