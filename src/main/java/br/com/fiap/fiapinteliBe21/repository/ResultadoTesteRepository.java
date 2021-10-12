package br.com.fiap.fiapinteliBe21.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fiapinteliBe21.domain.ResultadoTeste;

@Repository
public interface ResultadoTesteRepository extends JpaRepository<ResultadoTeste, Long> {

	@Transactional(readOnly = true)
	@Query("select r from ResultadoTeste r where r.cnpjOuCpf = ?1"
						  + " and r.idFormulario = ?2 "
						  + "order by r.candidatoAprovado")	
	List <ResultadoTeste> findByCnpjOuCpfAndFormulario(Long cnpjOuCpf, Long idFormulario)  ;

	@Transactional
	@Modifying
	@Query("delete  from ResultadoTeste r where r.cnpjOuCpf = ?1"
			+ " and r.idFormulario = ?2 ")
	void deleteById(Long cnpjOuCpf, Long idFormulario)  ;
}
