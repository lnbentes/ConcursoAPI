package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
