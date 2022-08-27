package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.SubTopico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubTopicoRepository extends JpaRepository<SubTopico, Long> {
    Optional<SubTopico> findByNomeContainingIgnoreCase(String nome);
}
