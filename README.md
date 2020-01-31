# Projeto Library
---
## Objetivo

Este projeto tem por objetivo o estudo de algumas tecnologias e bibliotecas como Spring Boot e o Lombok.

## Premissas do ambiente

* Java 1.8
* Maven 3.5.0

**Para o uso do Lombok deve-se**
* Baixar o *jar* do Lombok no link: **https://mvnrepository.com/artifact/org.projectlombok/lombok**
* Executar o *jar* do Lombok com o comando: **`java -jar lombok.jar`**;
* Irá abrir uma janela e deverá selecionar o local onde está a IDE e clicar em **`Install / Update`**;
* Reinicar a IDE;
* Adicionar o Lombok como dependência no seu pom.xml:
    ~~~
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.2</version>
        <scope>provided</scope>
    </dependency>
    ~~~
* Rebuild do seu projeto.


# Tecnologias e bibliotecas
---

|Nome         | Tipo
|-------------|-------------------
|Spring       |Tecnologia
|Spring Boot  |Tecnologia
|Lombok       |Biblioteca


### Spring

Framework não intrtusivo que é baseado em IoC e injeção de dependências.

### Spring Boot

Nada mais é do que um projeto da Spring que facilita a iniciação de projetos no que se refere a confiuguração e publicação.

### Lombok

Para esse projeto foi utilizado uma biblioteca chamada **Lombok**, que é uma biblioteca com o fim de evitar **Boilerplate code**(códigos que são colocados e repetidos em vários lugares com pouca ou nenhuma alteração).
