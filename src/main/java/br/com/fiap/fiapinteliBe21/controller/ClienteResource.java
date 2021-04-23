package br.com.fiap.fiapinteliBe21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    
//    @PostMapping("cadastar")
//	public	ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
//		Cliente obj = clienteService.incluir(cliente);
//		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getCnpjOuCpf()).toUri();
//		return	ResponseEntity.created(uri).build();
//	}
//
//     @PutMapping("{id}")
//     public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Integer id) {
//    	cliente.setNumeroCliente(id);
// 		clienteService.update(cliente);
// 		return ResponseEntity.ok().body(cliente);
// 	}
//     
//    @DeleteMapping("{id}")
//	public	ResponseEntity<Void> deleteById(@PathVariable Integer id) {
//    	clienteService.delete(id);
//		return ResponseEntity.noContent().build();
//    }	
//    @GetMapping
//    public ResponseEntity<List<Cliente>> listar() {
//    	List <Cliente> list = clienteService.findAll(); 
//    	return ResponseEntity.ok().body(list);
//    }
    @GetMapping("buscarId/{id}")
    public ResponseEntity<Cliente>  buscarPorId(@PathVariable Long id) {
    	Cliente obj = clienteService.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
}