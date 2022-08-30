package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Assunto;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.model.SubTopico;
import br.com.lnbentes.api.concurso.model.Topico;
import br.com.lnbentes.api.concurso.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    private List<Topico> topicos;
    private List<NomeModel> nomes;
    private NomeModel nome;

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

    public List<NomeModel> getAllName(){
        this.topicos = repository.findAll();
        this.nomes = new ArrayList<>();

        for (Topico topico : topicos) {
            this.nome = new NomeModel();
            this.nome.setId(topico.getId());
            this.nome.setNome(topico.getNome());
            this.nome.setPeso(topico.getPeso());
            this.nomes.add(nome);
        }

        return this.nomes;
    }

    public Optional<Topico> findByNome(String nome){
        logger.info("Localizando nome do tópico!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    /*
     * Pega o nome do topico e retorna uma lista com todos os nomes dos subTopicos relacionados.
     * */
    public List<NomeModel> getAllSubTopicosNomes(String nomeAssunto){
        Optional<Topico> topico = repository.findByNomeContainingIgnoreCase(nomeAssunto);
        this.nomes = new ArrayList<>();

        for(SubTopico subTopico : topico.get().getSubTopicos()){
            this.nome = new NomeModel();
            this.nome.setId(subTopico.getId());
            this.nome.setNome(subTopico.getNome());
            this.nome.setPeso(subTopico.getPeso());
            this.nomes.add(nome);
        }
        return this.nomes;
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
