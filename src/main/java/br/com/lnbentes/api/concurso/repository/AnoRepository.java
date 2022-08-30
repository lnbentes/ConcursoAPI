package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.Ano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnoRepository extends JpaRepository<Ano, Long> {
    Optional<Ano> findByNomeContainingIgnoreCase(String nome);
}
