# APIConcurso

API com CRUD completo para armazenar em um banco de dados questões de concurso

## Rodar a Aplicação localmente:
1. Rode o arquivo ConcursoApplication da aplicação
2. Acesse http://localhost:8080/ no seu navegador ou seu programa de requisições.

## Rodar a Aplicação remotamente:
Acesse o site: [https://bpconcurso.herokuapp.com/](https://bpconcurso.herokuapp.com/)

## Documentação no swagger
* Com a aplicação rodando localmente, acesse o [link](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)

* Com a aplicação rodando remotamente, acesse o [link](https://bpconcurso.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)

## Tabelas:
* Questões;
  * SubTópico;
    * Tópico;
      * Assunto;
        * Disciplina;
  * Banca;
  * Órgão;
  * Cargo;
  * Ano;

## End-points:
Verifique na documentação do swagger

## Tecnologias usadas:
* Java 11
* Spring boot
* Maven
* Postman
* MySQL
* PostgreSQL
* Swagger