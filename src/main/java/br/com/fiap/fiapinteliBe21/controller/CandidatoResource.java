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
import br.com.fiap.fiapinteliBe21.domain.Candidato;
import br.com.fiap.fiapinteliBe21.service.CandidatoService;

@RestController
@RequestMapping("candidato")
public class CandidatoResource {

	@Autowired
	private CandidatoService candidatoService;

	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Candidato candidato) {

		Candidato obj = candidatoService.incluir(candidato);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCandidato()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("{id}")

	public ResponseEntity<Candidato> atualizarPorId(@Valid @RequestBody Candidato candidato, @PathVariable Long id) {
		candidato.setIdCandidato(id);
		candidatoService.atualizar(candidato);
		return ResponseEntity.ok().body(candidato);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
		candidatoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Candidato>> buscarListar() {
		List<Candidato> list = candidatoService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
		Candidato obj = candidatoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}