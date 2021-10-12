package br.com.fiap.fiapinteliBe21.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiapinteliBe21.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}