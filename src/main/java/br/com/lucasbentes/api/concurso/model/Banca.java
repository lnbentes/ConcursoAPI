package br.com.lucasbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_banca")
public class Banca{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private double peso;

    @OneToMany(mappedBy = "banca", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("banca")
    private List<Questao> questao;

    public Banca() {
    }

    public Banca(Long id, String nome, double peso) {
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

    public List<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(List<Questao> questao) {
        this.questao = questao;
    }
}
