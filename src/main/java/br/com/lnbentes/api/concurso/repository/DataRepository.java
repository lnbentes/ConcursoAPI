package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataRepository  extends JpaRepository<Data, Long> {

    Optional<Data> findByNomeContainingIgnoreCase(String nome);
}
