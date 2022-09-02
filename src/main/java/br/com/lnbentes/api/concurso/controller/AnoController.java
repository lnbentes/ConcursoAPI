package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.Ano;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.service.AnoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ano")
@Tag(name = "Ano", description = "Endpoints para gerenciar os anos")
public class AnoController {
    @Autowired
    private AnoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ano> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Ano findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/nome",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NomeModel> getAllNome(){
        return service.getAllName();
    }

    @RequestMapping(value = "/nome/{nome}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Ano> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ano post(@RequestBody Ano ano){
        return service.create(ano);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ano put(@RequestBody Ano ano){
        return service.update(ano);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
