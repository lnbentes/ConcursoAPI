package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_area_de_conhecimento")
public class AreaDeConhecimento extends AtributosBasicos {

    @OneToMany(mappedBy = "areaDeConhecimento", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("areaDeConhecimento")
    private List<Questao> questao;

    public AreaDeConhecimento() {
    }

    public AreaDeConhecimento(Long id, String nome, double peso) {
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
