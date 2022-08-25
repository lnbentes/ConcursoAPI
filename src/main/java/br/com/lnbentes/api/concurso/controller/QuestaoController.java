package br.com.lnbentes.api.concurso.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questao")
@Tag(name = "Questão", description = "Endpoints para gerenciar as questões")
public class QuestaoController {
}
