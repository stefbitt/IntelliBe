package br.com.fiap.fiapinteliBe21.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fiapinteliBe21.domain.RespostaTeste;

@Repository
public interface RespostaTesteRepository extends JpaRepository<RespostaTeste, Long> {
	@Transactional(readOnly = true)
	@Query("select u from RespostaTeste u where u.cnpjOuCpf = ?1"
						  + " and u.formulario.idFormulario = ?2 "
						  + "order by u.candidato.idCandidato")	
	List <RespostaTeste> findByCnpjOuCpfAndFormulario(Long cnpjOuCpf, Long idFormulario)  ;
}

