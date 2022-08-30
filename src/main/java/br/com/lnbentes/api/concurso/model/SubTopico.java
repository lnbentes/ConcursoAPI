package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_sub_topico")
public class SubTopico  extends AtributosBasicos {

    @ManyToOne
    @JsonIgnoreProperties("subTopicos")
    private Topico topico;

    @OneToMany(mappedBy = "subTopico", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("subTopico")
    private List<Questao> questao;

    public SubTopico() {
    }

    public SubTopico(Long id, String nome, double peso) {
        super.setId(id);
        super.setNome(nome);
        super.setPeso(peso);
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public List<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(List<Questao> questao) {
        this.questao = questao;
    }
}
