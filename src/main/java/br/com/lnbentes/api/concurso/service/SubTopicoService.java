package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.SubTopico;
import br.com.lnbentes.api.concurso.repository.SubTopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SubTopicoService {

    @Autowired
    private SubTopicoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<SubTopico> findAll(){
        logger.info("Localizando todas os tópicos!");
        return repository.findAll();
    }

    public SubTopico findById(Long id){
        logger.info("Localizando um tópico!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public Optional<SubTopico> findByNome(String nome){
        logger.info("Localizando nome do tópico!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public SubTopico create(SubTopico subTopico) {
        logger.info("Criando um tópico!");
        return repository.save(subTopico);
    }

    public SubTopico update(SubTopico subTopico) {
        logger.info("Atualizando o tópico!");

        SubTopico entity = repository.findById(subTopico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(subTopico.getNome());
        entity.setPeso(subTopico.getPeso());
        entity.setTopico(subTopico.getTopico());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando o tópico!");
        SubTopico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
