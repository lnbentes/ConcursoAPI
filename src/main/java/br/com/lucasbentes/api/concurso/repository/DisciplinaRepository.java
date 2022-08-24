package br.com.lucasbentes.api.concurso.repository;

import br.com.lucasbentes.api.concurso.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    Optional<Disciplina> findByNomeContainingIgnoreCase(String nome);
}
