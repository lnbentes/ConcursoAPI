package br.com.lnbentes.api.concurso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tb_questao")
public class Questao{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotNull
   private String titulo;
   @NotNull
   private String descricao;
   @NotNull
   private boolean resposta;
   @NotNull
   private String explicacao;

   @NotNull
   private double peso;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Banca banca;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private SubTopico subTopico;


   @ManyToOne
   @JsonIgnoreProperties("questao")
   private AreaDeConhecimento areaDeConhecimento;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Orgao orgao;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Cargo cargo;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Ano ano;


   public Questao() {
   }

   public Questao(Long id, String descricao, boolean resposta, String explicacao) {
      this.id = id;
      this.descricao = descricao;
      this.resposta = resposta;
      this.explicacao = explicacao;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public boolean isResposta() {
      return resposta;
   }

   public void setResposta(boolean resposta) {
      this.resposta = resposta;
   }

   public String getExplicacao() {
      return explicacao;
   }

   public void setExplicacao(String explicacao) {
      this.explicacao = explicacao;
   }

   public double getPeso() {
      return peso;
   }

   public void setPeso(double peso) {
      this.peso = peso;
   }

   public Banca getBanca() {
      return banca;
   }

   public void setBanca(Banca banca) {
      this.banca = banca;
   }

   public SubTopico getSubTopico() {
      return subTopico;
   }

   public void setSubTopico(SubTopico subTopico) {
      this.subTopico = subTopico;
   }

   public AreaDeConhecimento getAreaDeConhecimento() {
      return areaDeConhecimento;
   }

   public void setAreaDeConhecimento(AreaDeConhecimento areaDeConhecimento) {
      this.areaDeConhecimento = areaDeConhecimento;
   }

   public Orgao getOrgao() {
      return orgao;
   }

   public void setOrgao(Orgao orgao) {
      this.orgao = orgao;
   }

   public Cargo getCargo() {
      return cargo;
   }

   public void setCargo(Cargo cargo) {
      this.cargo = cargo;
   }

   public Ano getAno() {
      return ano;
   }

   public void setAno(Ano ano) {
      this.ano = ano;
   }
}
