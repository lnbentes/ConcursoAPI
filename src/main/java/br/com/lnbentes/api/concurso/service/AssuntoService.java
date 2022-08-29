package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Assunto;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AssuntoService {

    @Autowired
    private AssuntoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Assunto> findAll(){
        logger.info("Localizando todas os assuntos!");
        return repository.findAll();
    }

    public Assunto findById(Long id){
        logger.info("Localizando uma assunto!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        List<Assunto> topicos = repository.findAll();
        NomeModel nome = new NomeModel();
        List<NomeModel> nomes = new ArrayList<>();

        for (Assunto assunto : topicos) {
            nome.setNome(assunto.getNome());
            nome.setPeso(assunto.getPeso());
            nomes.add(nome);
        }

        return nomes;
    }

    public Optional<Assunto> findByNome(String nome){
        logger.info("Localizando nome do assunto!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Assunto create(Assunto assunto) {
        logger.info("Criando um assunto!");
        return repository.save(assunto);
    }

    public Assunto update(Assunto assunto) {
        logger.info("Atualizando um assunto!");

        Assunto entity = repository.findById(assunto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(assunto.getNome());
        entity.setPeso(assunto.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando um áassunto!");
        Assunto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
