package br.com.lnbentes.api.concurso.controller;

import br.com.lnbentes.api.concurso.model.AreaDeConhecimento;
import br.com.lnbentes.api.concurso.model.NomeModel;
import br.com.lnbentes.api.concurso.service.AreaDeConhecimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conhecimento")
@Tag(name = "Área de Conhecimento", description = "Endpoints para gerenciar as áreas de Conhecimento")
public class AreaDeConhecimentoController {

    @Autowired
    private AreaDeConhecimentoService service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AreaDeConhecimento> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AreaDeConhecimento findById(@PathVariable(value = "id") Long id){
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
    public Optional<AreaDeConhecimento> findByNome(@PathVariable(value = "nome") String nome){
        return service.findByNome(nome);
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AreaDeConhecimento post(@RequestBody AreaDeConhecimento areaDeConhecimento){
        return service.create(areaDeConhecimento);
    }

    @RequestMapping(method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AreaDeConhecimento put(@RequestBody AreaDeConhecimento areaDeConhecimento){
        return service.update(areaDeConhecimento);
    }

    @RequestMapping(value = "/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
