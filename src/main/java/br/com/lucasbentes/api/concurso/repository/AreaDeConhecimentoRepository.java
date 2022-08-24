package br.com.lucasbentes.api.concurso.repository;

import br.com.lucasbentes.api.concurso.model.AreaDeConhecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaDeConhecimentoRepository extends JpaRepository<AreaDeConhecimento, Long> {

    Optional<AreaDeConhecimento> findByNomeContainingIgnoreCase(String nome);
}
