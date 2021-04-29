package br.com.fiap.fiapinteliBe21.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.fiapinteliBe21.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Transactional(readOnly = true)
	Cliente findBydescricaoEmail(String email);  //vai no BD e busca cliente por email
		
}