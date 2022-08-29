package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Banca;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.BancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BancaService {
    @Autowired
    private BancaRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Banca> findAll(){
        logger.info("Localizando todas as áreas de Conhecimento!");
        return repository.findAll();
    }

    public Banca findById(Long id){
        logger.info("Localizando uma área de Conhecimento!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        List<Banca> topicos = repository.findAll();
        NomeModel nome = new NomeModel();
        List<NomeModel> nomes = new ArrayList<>();

        for (Banca banca : topicos) {
            nome.setNome(banca.getNome());
            nome.setPeso(banca.getPeso());
            nomes.add(nome);
        }

        return nomes;
    }

    public Optional<Banca> findByNome(String nome){
        logger.info("Localizando nome da área de Conhecimento!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Banca create(Banca banca) {
        logger.info("Criando uma área de Conhecimento!");
        return repository.save(banca);
    }

    public Banca update(Banca banca) {
        logger.info("Atualizando um área de Conhecimento!");

        Banca entity = repository.findById(banca.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(banca.getNome());
        entity.setPeso(banca.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando um área de Conhecimento!");
        Banca entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
