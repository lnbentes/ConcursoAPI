package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.Cargo;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.service.CargoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargo")
@Tag(name = "Cargo", description = "Endpoints para gerenciar os cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cargo> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargo findById(@PathVariable(value = "id") Long id){
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
    public Optional<Cargo> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }


    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cargo post(@RequestBody Cargo cargo){
        return service.create(cargo);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cargo put(@RequestBody Cargo cargo){
        return service.update(cargo);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
