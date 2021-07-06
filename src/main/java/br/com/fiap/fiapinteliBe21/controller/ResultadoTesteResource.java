package br.com.fiap.fiapinteliBe21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapinteliBe21.domain.ResultadoTeste;
import br.com.fiap.fiapinteliBe21.service.ResultadoTesteService;

@RestController
@RequestMapping("resultado")
public class ResultadoTesteResource {
    @Autowired
    private ResultadoTesteService resultadoTesteService;
    
    @GetMapping("/teste/{cnpjOuCpf}/{idFormulario}")
	public	ResponseEntity<Boolean> gerarResultadoTeste(@PathVariable Long cnpjOuCpf, @PathVariable Long idFormulario) {
 
    	Boolean gerouResultadoTeste = resultadoTesteService.gerarResultadoTeste(cnpjOuCpf, idFormulario );
		return ResponseEntity.ok().body(gerouResultadoTeste);
    }
    @GetMapping("/{cnpjOuCpf}/{idFormulario}")
    public ResponseEntity<List<ResultadoTeste>> listaResultados(@PathVariable Long cnpjOuCpf,@PathVariable Long idFormulario) {
    	List <ResultadoTeste> list = resultadoTesteService.listar(cnpjOuCpf, idFormulario );
    	return ResponseEntity.ok().body(list);
    }    
    @DeleteMapping("/{cnpjOuCpf}/{idFormulario}")
	public	ResponseEntity<Void> deletarPorId(@PathVariable Long cnpjOuCpf, @PathVariable Long idFormulario) {
    	resultadoTesteService.deletar(cnpjOuCpf,idFormulario);
		return ResponseEntity.noContent().build();
    }	
}