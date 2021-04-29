package br.com.fiap.fiapinteliBe21.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.fiapinteliBe21.domain.Departamento;
import br.com.fiap.fiapinteliBe21.service.DepartamentoService;

@RestController
@RequestMapping("departamento")
public class DepartamentoResource {

	@Autowired
	private DepartamentoService departamentoService;

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Departamento departamento) {

		Departamento obj = departamentoService.incluir(departamento);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(obj.getIdDepto()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/atualizar/{id}")

	public ResponseEntity<Departamento> atualizarPorId	(@Valid @RequestBody Departamento departamento,
														 @PathVariable Long id) {
		departamento.setIdDepto(id);
		departamentoService.atualizar(departamento);
		return ResponseEntity.ok().body(departamento);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
		departamentoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Departamento>> buscarLista() {
		List<Departamento> list = departamentoService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/buscarId/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
		Departamento obj = departamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}