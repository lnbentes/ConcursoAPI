package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.Banca;
import br.com.lnbentes.api.concurso.model.Orgao;
import br.com.lnbentes.api.concurso.service.OrgaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orgao")
@Tag(name = "Orgão", description = "Endpoints para gerenciar os orgões")
public class OrgaoController {

    @Autowired
    private OrgaoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orgao> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Orgao findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/nome/{nome}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Orgao> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Orgao post(@RequestBody Orgao orgao){
        return service.create(orgao);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Orgao put(@RequestBody Orgao orgao){
        return service.update(orgao);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
