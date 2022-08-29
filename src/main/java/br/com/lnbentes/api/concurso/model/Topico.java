package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_topico")
public class Topico{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private double peso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("topico")
    @Column(name = "sub_topico")
    private List<SubTopico> subTopicos;

    public Topico() {
    }

    public Topico(Long id, String nome, double peso) {
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

    public List<SubTopico> getSubTopicos() {
        return subTopicos;
    }

    public void setSubTopicos(List<SubTopico> subTopicos) {
        this.subTopicos = subTopicos;
    }
}
