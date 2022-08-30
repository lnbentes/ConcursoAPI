package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_ano")
public class Ano extends AtributosBasicos{

    @OneToMany(mappedBy = "ano", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("ano")
    private List<Questao> questao;

    public Ano() {
    }

    public Ano(Long id, String nome, double peso) {
        super.setId(id);
        super.setNome(nome);
        super.setPeso(peso);
    }

    public List<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(List<Questao> questao) {
        this.questao = questao;
    }
}
