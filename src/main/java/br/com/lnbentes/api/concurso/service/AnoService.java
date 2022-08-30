package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Ano;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.AnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AnoService {
    @Autowired
    private AnoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Ano> findAll(){
        logger.info("Localizando todas os anos!");
        return repository.findAll();
    }

    public Ano findById(Long id){
        logger.info("Localizando um ano!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        logger.info("Localizando todas os nomes dos anos!");
        List<Ano> anos = repository.findAll();
        List<NomeModel> nomes = new ArrayList<>();

        for (Ano ano : anos) {
            NomeModel nome = new NomeModel();
            nome.setId(ano.getId());
            nome.setNome(ano.getNome());
            nome.setPeso(ano.getPeso());
            nomes.add(nome);
        }

        return nomes;
    }

    public Optional<Ano> findByNome(String nome){
        logger.info("Localizando nome do ano!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Ano create(Ano ano) {
        logger.info("Criando um ano!");
        return repository.save(ano);
    }

    public Ano update(Ano ano) {
        logger.info("Atualizando um ano!");

        Ano entity = repository.findById(ano.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(ano.getNome());
        entity.setPeso(ano.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando um ano!");
        Ano entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
