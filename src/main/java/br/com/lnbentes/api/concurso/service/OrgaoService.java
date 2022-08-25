package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Orgao;
import br.com.lnbentes.api.concurso.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository repository;

    private Logger logger = Logger.getLogger(QuestaoService.class.getName());

    public List<Orgao> findAll(){
        logger.info("Localizando todas os órgãos!");
        return repository.findAll();
    }

    public Orgao findById(Long id){
        logger.info("Localizando um órgão!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));
    }

    public Optional<Orgao> findByNome(String nome){
        logger.info("Localizando nome do órgão!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Orgao create(Orgao orgao) {
        logger.info("Criando um órgão!");
        return repository.save(orgao);
    }

    public Orgao update(Orgao orgao) {
        logger.info("Atualizando um órgão!");

        Orgao entity = repository.findById(orgao.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setNome(orgao.getNome());
        entity.setPeso(orgao.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando um órgão!");
        Orgao entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
