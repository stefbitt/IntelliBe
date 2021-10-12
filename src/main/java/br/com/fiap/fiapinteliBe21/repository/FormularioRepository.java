package br.com.fiap.fiapinteliBe21.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import br.com.fiap.fiapinteliBe21.domain.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
	@Transactional(readOnly = true)
	@Query("select u from Formulario u where u.cliente.cnpjOuCpf = ?1")
				
	List <Formulario> findByCnpjOuCpf(Long cnpjOuCpf)  ;
}
