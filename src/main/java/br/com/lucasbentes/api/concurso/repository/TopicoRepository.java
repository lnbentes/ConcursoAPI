package br.com.lucasbentes.api.concurso.repository;

import br.com.lucasbentes.api.concurso.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByNomeContainingIgnoreCase(String nome);
}
