package br.com.fiap.fiapinteliBe21.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiapinteliBe21.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.descricaoEmail = ?1"
						  + " and u.senha = ?2 ")	
	Usuario findByEmailAddress(String email, String senha);
}
