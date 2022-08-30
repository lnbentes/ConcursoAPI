package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_orgao")
public class Orgao extends AtributosBasicos {

    @OneToMany(mappedBy = "orgao", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("orgao")
    private List<Questao> questao;

    public Orgao() {
    }

    public Orgao(Long id, String nome, double peso) {
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
