package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_disciplina")
public class Disciplina extends AtributosBasicos {

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("disciplina")
    private List<Assunto> assuntos;

    public Disciplina() {

    }

    public Disciplina(Long id, String nome, double peso) {
        super.setId(id);
        super.setNome(nome);
        super.setPeso(peso);
    }

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }
}
