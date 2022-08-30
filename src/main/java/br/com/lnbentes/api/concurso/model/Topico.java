package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_topico")
public class Topico extends AtributosBasicos {

    @ManyToOne
    @JsonIgnoreProperties("topicos")
    private Assunto assunto;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("topico")
    private List<SubTopico> subTopicos;

    public Topico() {
    }

    public Topico(Long id, String nome, double peso) {
        super.setId(id);
        super.setNome(nome);
        super.setPeso(peso);
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public List<SubTopico> getSubTopicos() {
        return subTopicos;
    }

    public void setSubTopicos(List<SubTopico> subTopicos) {
        this.subTopicos = subTopicos;
    }
}
