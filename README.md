# Fórum Hub API #

A ForumHub API é uma aplicação desenvolvida em Spring Boot que oferece funcionalidades de gerenciamento de tópicos em um fórum online. Os usuários podem criar, visualizar, atualizar e excluir tópicos, além de autenticar-se para acessar as funcionalidades protegidas da API. 

Projeto desenlvido para o curso: "Praticando Spring Framework: Challenge Fórum Hub" - Back End do ONE - Oracle Next Education & Alura

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Maven
- MySQL
- Flyway Migration
- Spring Data JPA
- Spring Security
- OAuth2 Resource Server
- JSON Web Token (JWT)
- SpringFox Swagger

## Pré-requisitos

- JDK 21 instalado
- IDE Java (como NetBeans, Eclipse ou IntelliJ IDEA)

## Gerar a chave pública e privada do token JWT

1. No terminal, digitar o seguinte comando na pasta raiz do projeto:
   ```
   cd src\main\resources
   ```
2. No terminal, dentro da pasta "src\main\resources" digitar o seguinte comando para gerar a chave privada:
   ```
   opensssl genrsa > app.key
   ```
3. No terminal, dentro da pasta "src\main\resources" digitar o seguinte comando para gerar a chave pública:
   ```
   openssl rsa -in app.key -pubout -out app.pub
   ```

## Endpoints Principais

- `/topics`: Endpoint para operações CRUD de tópicos.
- `/users`: Endpoint para criar e autenticar usuários através de token JWT.
- `/swagger-ui.html`: Interface gráfica do Swagger para visualizar e testar os endpoints da API.

## Como Executar
