package br.com.fiap.fiapinteliBe21.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.fiap.fiapinteliBe21.controller.exception.StandardErrorMain;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.service.ClienteService;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;

@RestController
@RequestMapping("cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/cadastrar")
	public	ResponseEntity<?> cadastrar(@Valid @RequestBody Cliente cliente) {
    	try {
			Cliente obj = clienteService.incluir(cliente);
			
			java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getCnpjOuCpf()).toUri();
			return	ResponseEntity.created(uri).build();
		
		} catch (DataIntegrityException e) {
			StandardErrorMain err = new StandardErrorMain(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()); 
			return 	new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
    }	
     @PutMapping("/atualizar/{id}")
     
     public ResponseEntity<Cliente> atualizarPorId(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
    	cliente.setCnpjOuCpf(id);
 		clienteService.atualizar(cliente);
 		return ResponseEntity.ok().body(cliente);
 	}
     
    @DeleteMapping("/deletar/{id}")
	public	ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
    	clienteService.deletar(id);
		return ResponseEntity.noContent().build();
    }	
    
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> buscarListar() {
    	List <Cliente> list = clienteService.listar(); 
    	return ResponseEntity.ok().body(list);
    }
    
    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Cliente>  buscarPorId(@PathVariable Long id) {
    	Cliente obj = clienteService.buscar(id);
    	return ResponseEntity.ok().body(obj);
    }
}