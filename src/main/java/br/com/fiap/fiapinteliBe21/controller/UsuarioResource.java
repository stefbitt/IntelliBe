package br.com.fiap.fiapinteliBe21.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{email}/{senha}")
	public ResponseEntity<Usuario> buscar(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		
//		boolean resp = false;
		System.out.println("===========  chamou usuario = " + email + senha); 
		
		Usuario usuario = usuarioService.buscarEmailEsenha(email, senha);
		
		/*
		 * if (usuario != null){ resp = true; }
		 */
		System.out.println(usuario);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
    
	public	ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
		
		Usuario obj = usuarioService.insert(usuario);
		
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
		
		return	ResponseEntity.created(uri).build();
	}
}