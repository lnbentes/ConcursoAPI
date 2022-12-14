package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long> {

    Optional<Assunto> findByNomeContainingIgnoreCase(String nome);
}
