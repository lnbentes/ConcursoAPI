package br.com.lnbentes.api.concurso.service;

import br.com.lnbentes.api.concurso.exceptions.ResourceNotFoundException;
import br.com.lnbentes.api.concurso.model.Questao;
import br.com.lnbentes.api.concurso.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository repository;

    private List<Questao> questoes;
    private List<Questao> NovaListaQuestoes;
    private Random numeroRandom;
    private int numero;
    private List<Integer> numerosSorteados;

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

    /*
     * Recebe a quantidade de questões de deseja que seja selecionada e depois devolve essa quantidade randomizada.
     * @author Lucas Bentes
     * @param int - nome da area de interesse.
     * @return List<> - questões randomizada.
     * */
    public List<Questao> sortearNQuestoes(int numeroVezes){
        this.questoes = this.findAll();
        this.numerosSorteados = new ArrayList<>();
        this.NovaListaQuestoes = new ArrayList<>();
        this.numerosSorteados.add(0);
        this.numeroRandom = new Random();

        for(int i = 0; i < numeroVezes; i++){
            this.numero = this.numeroRandom.nextInt(this.questoes.size());

            while (true){
                if(this.numerosSorteados.contains(this.numero)){
                    this.numero = this.numeroRandom.nextInt(this.questoes.size());
                }else {
                    break;
                }
            }

            this.NovaListaQuestoes.add(this.questoes.get(this.numero));
            this.numerosSorteados.add(this.numero);
        }
        return this.NovaListaQuestoes;
    }

    public List<Questao> sortearCincoQuestoes(){
        return this.sortearNQuestoes(5);
    }

    public Questao create(Questao questao) {
        logger.info("Criando a questão!");
        return repository.save(questao);
    }

    public Questao update(Questao questao) {
        logger.info("Atualizando a questão!");

        Questao entity = repository.findById(questao.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        entity.setTitulo(questao.getTitulo());
        entity.setDescricao(questao.getDescricao());
        entity.setResposta (questao.isResposta());
        entity.setExplicacao(questao.getExplicacao());
        entity.setPeso(questao.getPeso());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando a questão!");
        Questao entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não localizado"));

        repository.delete(entity);
    }
}
