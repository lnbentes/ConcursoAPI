package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.model.SubTopico;
import br.com.lnbentes.api.concurso.service.SubTopicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subTopico")
@Tag(name = "SubTópico", description = "Endpoints para gerenciar os subTópico")
public class SubTopicoController {

    @Autowired
    private SubTopicoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubTopico> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SubTopico findById(@PathVariable(value = "id") Long id){
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
    public Optional<SubTopico> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }


    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SubTopico post(@RequestBody SubTopico subTopico){
        return service.create(subTopico);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SubTopico put(@RequestBody SubTopico subTopico){
        return service.update(subTopico);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
