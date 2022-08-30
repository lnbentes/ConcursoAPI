package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "tb_assunto")
public class Assunto extends AtributosBasicos{

    @ManyToOne
    @JsonIgnoreProperties("assuntos")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "assunto", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("assunto")
    private List<Topico> topicos;

    public Assunto() {

    }
    public Assunto(Long id, String nome, double peso) {
        super.setId(id);
        super.setNome(nome);
        super.setPeso(peso);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}
