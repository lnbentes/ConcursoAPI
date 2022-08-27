package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.Assunto;
import br.com.lnbentes.api.concurso.model.Banca;
import br.com.lnbentes.api.concurso.service.BancaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banca")
@Tag(name = "Banca", description = "Endpoints para gerenciar as bancas")
public class BancaController {

    @Autowired
    private BancaService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Banca> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Banca findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/nome/{nome}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Banca> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Banca post(@RequestBody Banca banca){
        return service.create(banca);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Banca put(@RequestBody Banca banca){
        return service.update(banca);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
