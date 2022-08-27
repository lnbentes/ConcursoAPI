package br.com.lnbentes.api.concurso.repository;

import br.com.lnbentes.api.concurso.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Optional<Cargo> findByNomeContainingIgnoreCase(String nome);
}
