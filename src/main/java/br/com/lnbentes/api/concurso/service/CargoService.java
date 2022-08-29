package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Cargo;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Cargo> findAll(){
        logger.info("Localizando todas os tópicos!");
        return repository.findAll();
    }

    public Cargo findById(Long id){
        logger.info("Localizando um tópico!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        List<Cargo> topicos = repository.findAll();
        NomeModel nome = new NomeModel();
        List<NomeModel> nomes = new ArrayList<>();

        for (Cargo cargo : topicos) {
            nome.setNome(cargo.getNome());
            nome.setPeso(cargo.getPeso());
            nomes.add(nome);
        }

        return nomes;
    }

    public Optional<Cargo> findByNome(String nome){
        logger.info("Localizando nome do tópico!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Cargo create(Cargo cargo) {
        logger.info("Criando um tópico!");
        return repository.save(cargo);
    }

    public Cargo update(Cargo cargo) {
        logger.info("Atualizando o tópico!");

        Cargo entity = repository.findById(cargo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(cargo.getNome());
        entity.setPeso(cargo.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando o tópico!");
        Cargo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
