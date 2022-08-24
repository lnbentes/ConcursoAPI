package br.com.lucasbentes.api.concurso.repository;

import br.com.lucasbentes.api.concurso.model.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrgaoRepository extends JpaRepository<Orgao, Long> {

    Optional<Orgao> findByNomeContainingIgnoreCase(String nome);

}
