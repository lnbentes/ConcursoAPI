package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.Questao;
import br.com.lnbentes.api.concurso.service.QuestaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao")
@Tag(name = "Questão", description = "Endpoints para gerenciar as questões")
public class QuestaoController {

    @Autowired
    private QuestaoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questao> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Questao findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/sortear",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questao> cincoQuestoes(){
        return service.sortearCincoQuestoes();
    }

    @RequestMapping(value = "/sortear/{numero}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Questao> sortearNVezes(@PathVariable(value = "numero") int numero){
        return service.sortearNQuestoes(numero);
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Questao post(@RequestBody Questao questao){
        return service.create(questao);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Questao put(@RequestBody Questao questao){
        return service.update(questao);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
