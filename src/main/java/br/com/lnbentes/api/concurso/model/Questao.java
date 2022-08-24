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
   private Disciplina disciplina;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Assunto assunto;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private Topico topico;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private String data;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private String areaDeConhecimento;

   @ManyToOne
   @JsonIgnoreProperties("questao")
   private String orgao;


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

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
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

   public Disciplina getDisciplina() {
      return disciplina;
   }

   public void setDisciplina(Disciplina diciplina) {
      this.disciplina = diciplina;
   }

   public Assunto getAssunto() {
      return assunto;
   }

   public void setAssunto(Assunto assunto) {
      this.assunto = assunto;
   }

   public Topico getTopico() {
      return topico;
   }

   public void setTopico(Topico topico) {
      this.topico = topico;
   }

   public String getAreaDeConhecimento() {
      return areaDeConhecimento;
   }

   public void setAreaDeConhecimento(String areaDeConhecimento) {
      this.areaDeConhecimento = areaDeConhecimento;
   }

   public String getOrgao() {
      return orgao;
   }

   public void setOrgao(String orgao) {
      this.orgao = orgao;
   }
}