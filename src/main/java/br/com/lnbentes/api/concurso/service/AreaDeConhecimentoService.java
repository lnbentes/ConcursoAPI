package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.AreaDeConhecimento;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.repository.AreaDeConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AreaDeConhecimentoService {

    @Autowired
    private AreaDeConhecimentoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<AreaDeConhecimento> findAll(){
        logger.info("Localizando todas as áreas de Conhecimento!");
        return repository.findAll();
    }

    public AreaDeConhecimento findById(Long id){
        logger.info("Localizando uma área de Conhecimento!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public List<NomeModel> getAllName(){
        List<AreaDeConhecimento> topicos = repository.findAll();
        List<NomeModel> nomes = new ArrayList<>();

        for (AreaDeConhecimento areaDeConhecimento : topicos) {
            NomeModel nome = new NomeModel();
            nome.setId(areaDeConhecimento.getId());
            nome.setNome(areaDeConhecimento.getNome());
            nome.setPeso(areaDeConhecimento.getPeso());
            nomes.add(nome);
        }

        return nomes;
    }

    public Optional<AreaDeConhecimento> findByNome(String nome){
        logger.info("Localizando nome da área de Conhecimento!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public AreaDeConhecimento create(AreaDeConhecimento areaDeConhecimento) {
        logger.info("Criando uma área de Conhecimento!");
        return repository.save(areaDeConhecimento);
    }

    public AreaDeConhecimento update(AreaDeConhecimento areaDeConhecimento) {
        logger.info("Atualizando uma área de Conhecimento!");

        AreaDeConhecimento entity = repository.findById(areaDeConhecimento.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(areaDeConhecimento.getNome());
        entity.setPeso(areaDeConhecimento.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando uma área de Conhecimento!");
        AreaDeConhecimento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
