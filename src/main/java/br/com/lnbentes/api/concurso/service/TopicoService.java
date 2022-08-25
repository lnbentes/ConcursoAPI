package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Topico;
import br.com.lnbentes.api.concurso.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Topico> findAll(){
        logger.info("Localizando todas os tópicos!");
        return repository.findAll();
    }

    public Topico findById(Long id){
        logger.info("Localizando um tópico!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public Optional<Topico> findByNome(String nome){
        logger.info("Localizando nome do tópico!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Topico create(Topico topico) {
        logger.info("Criando um tópico!");
        return repository.save(topico);
    }

    public Topico update(Topico topico) {
        logger.info("Atualizando o tópico!");

        Topico entity = repository.findById(topico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(topico.getNome());
        entity.setPeso(topico.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando o tópico!");
        Topico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
