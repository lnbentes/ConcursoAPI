package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Assunto;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.model.Topico;
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

    private List<Assunto> assuntos;
    private List<NomeModel> nomes;
    private NomeModel nome;

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

    /*
     * Retorna uma lista com todos os nomes de assuntos registrados.
     * */
    public List<NomeModel> getAllName(){
        this.assuntos = repository.findAll();
        this.nomes = new ArrayList<>();

        for (Assunto assunto : assuntos) {
            this.nome = new NomeModel();
            this.nome.setId(assunto.getId());
            this.nome.setNome(assunto.getNome());
            this.nome.setPeso(assunto.getPeso());
            this.nomes.add(nome);
        }
        return this.nomes;
    }

    public Optional<Assunto> findByNome(String nome){
        logger.info("Localizando nome do assunto!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    /*
     * Pega o nome do assunto e retorna uma lista com todos os nomes dos topicos relacionados.
     * */
    public List<NomeModel> getAllTopicosNomes(String nomeAssunto){
        Optional<Assunto> assunto = repository.findByNomeContainingIgnoreCase(nomeAssunto);
        this.nomes = new ArrayList<>();

        for(Topico topico : assunto.get().getTopicos()){
            this.nome = new NomeModel();
            this.nome.setId(topico.getId());
            this.nome.setNome(topico.getNome());
            this.nome.setPeso(topico.getPeso());
            this.nomes.add(nome);
        }
        return this.nomes;
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
