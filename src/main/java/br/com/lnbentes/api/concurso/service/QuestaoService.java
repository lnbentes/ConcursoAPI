package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Questao;
import br.com.lnbentes.api.concurso.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Questao> findAll(){
        logger.info("Localizando todas as questões!");
        return repository.findAll();
    }

    public Questao findById(Long id){
        logger.info("Localizando uma questão!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public Questao create(Questao questao) {
        logger.info("Criando a questão!");
        return repository.save(questao);
    }

    public Questao update(Questao questao) {
        logger.info("Atualizando a questão!");

        Questao entity = repository.findById(questao.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setDescricao(questao.getDescricao());
        entity.setResposta (questao.isResposta());
        entity.setExplicacao(questao.getExplicacao());
        entity.setPeso(questao.getPeso());
        entity.setData(questao.getData());
        entity.setPesoData(questao.getPesoData());
        entity.setBanca(questao.getBanca());
        entity.setDisciplina(questao.getDisciplina());
        entity.setAssunto(questao.getAssunto());
        entity.setTopico(questao.getTopico());
        entity.setOrgao(questao.getOrgao());
        entity.setAreaDeConhecimento(questao.getAreaDeConhecimento());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando a questão!");
        Questao entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
