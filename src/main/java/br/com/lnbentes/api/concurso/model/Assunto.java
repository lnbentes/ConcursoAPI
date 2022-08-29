package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_assunto")
public class Assunto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private double peso;

    @ManyToOne
    @JsonIgnoreProperties("assuntos")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "assunto", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("assunto")
    @Column(name = "assunto")
    private List<Topico> topicos;

    public Assunto() {

    }
    public Assunto(Long id, String nome, double peso) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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
