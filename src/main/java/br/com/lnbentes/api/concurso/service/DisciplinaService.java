package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Assunto;
import br.com.lnbentes.api.concurso.model.Disciplina;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    private List<Disciplina> disciplinas;
    private List<NomeModel> nomes;
    private NomeModel nome;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());


    public List<Disciplina> findAll(){
        logger.info("Localizando todas as disciplina!");
        return repository.findAll();
    }

    public Disciplina findById(Long id){
        logger.info("Localizando uma disciplina!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        disciplinas = repository.findAll();
        nomes = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            this.nome = new NomeModel();
            this.nome.setId(disciplina.getId());
            this.nome.setNome(disciplina.getNome());
            this.nome.setPeso(disciplina.getPeso());
            this.nomes.add(nome);
        }

        return this.nomes;
    }

    public Optional<Disciplina> findByNome(String nome){
        logger.info("Localizando nome da disciplina!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    /*
     * Pega o nome de uma Disciplina e retorna uma lista com todos os nomes dos assuntos relacionados.
     * */
    public List<NomeModel> getAllAssuntosNomes(String nomeAssunto){
        Optional<Disciplina> disciplina = repository.findByNomeContainingIgnoreCase(nomeAssunto);
        this.nomes = new ArrayList<>();

        for(Assunto assunto : disciplina.get().getAssuntos()){
            this.nome = new NomeModel();
            this.nome.setId(assunto.getId());
            this.nome.setNome(assunto.getNome());
            this.nome.setPeso(assunto.getPeso());
            this.nomes.add(nome);
        }
        return this.nomes;
    }

    public Disciplina create(Disciplina disciplina) {
        logger.info("Criando uma área de Conhecimento!");
        return repository.save(disciplina);
    }

    public Disciplina update(Disciplina disciplina) {
        logger.info("Atualizando uma disciplina!");

        Disciplina entity = repository.findById(disciplina.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(disciplina.getNome());
        entity.setPeso(disciplina.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando uma disciplina!");
        Disciplina entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }

}
