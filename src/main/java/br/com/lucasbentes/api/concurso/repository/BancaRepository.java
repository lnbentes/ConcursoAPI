package br.com.lucasbentes.api.concurso.repository;

import br.com.lucasbentes.api.concurso.model.Banca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BancaRepository extends JpaRepository<Banca, Long> {

    Optional<Banca> findByNomeContainingIgnoreCase(String nome);
}
