package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.AreaDeConhecimento;
import br.com.lnbentes.api.concurso.model.Disciplina;
import br.com.lnbentes.api.concurso.model.Questao;
import br.com.lnbentes.api.concurso.repository.AreaDeConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<AreaDeConhecimento> findByNome(String nome){
        logger.info("Localizando nome da área de Conhecimento!");
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    /*
    * A partir de um nome de uma area de conhecimento, pega todas as questões
    * relacionadas a essa area e seleciona um número pre determinado dessas questões para ser mostradas.
    * @author Lucas Bentes
    * @param String - nome da area de interesse.
    * @return List<> - questões selecionada pelo algoritimo.
    * */
    public List<Questao> EscolhendoCincoQuestoes(String nome){
        logger.info("Localizando nome da área de Conhecimento!");

        AreaDeConhecimento entity = repository.findByNomeContainingIgnoreCase(nome)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));;

        List<Questao> listaBanco = entity.getQuestao();
        List<Questao> listaSelecionada = null;

        for(int i = 0; i < listaBanco.size(); i++){
            double peso = listaBanco.get(i).getPeso();

            listaSelecionada.add(listaBanco.get(i));
        }

        return listaSelecionada;
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
