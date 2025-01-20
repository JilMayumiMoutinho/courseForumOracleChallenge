# 💬📝 Course Fórum API 💬📝 #

A Course Forum API é uma aplicação desenvolvida em Spring Boot que oferece funcionalidades de gerenciamento de tópicos em um fórum online. Os usuários podem criar, visualizar, atualizar e excluir tópicos, além de autenticar-se para acessar as funcionalidades protegidas da API. 

Projeto desenlvido para o curso: "Praticando Spring Framework: Challenge Fórum Hub" - Back End do ONE - Oracle Next Education & Alura

## 🛠Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Maven
- MySQL
- Flyway Migration
- Spring Data JPA
- Spring Security
- OAuth2 Resource Server
- JSON Web Token (JWT)

## 📝Pré-requisitos

- JDK 21 instalado
- IDE Java (como NetBeans, Eclipse ou IntelliJ IDEA)

## 💻Como rodar o projeto localmente

1. Faça um fork dsse repositório

2. Clone o seu repositório:
   ```bash
   git clone https://github.com/seu-usuario/courseForumOracleChallenge.git
   cd courseForumOracleChallenge
   ```

2. Configure o banco de dados no arquivo `application.properties`:
   ```properties
    spring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    spring.datasource.driver-class-name=
   
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    
    spring.flyway.url=jdbc:mysql://localhost/nome_do_seu_schema
    spring.flyway.user=
    spring.flyway.password=
    spring.flyway.locations=classpath:/db/migration
   
    api.security.token.secret=${JWT_SECRET:}
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Estrutura do Projeto

- `courseForum.src`:
  - `main`:
      - `java`:    
         - `config`: Contém as configurações de Cors.
         - `controller`: Contém as classes que gerenciam interações com usuário e as execuções em service.
         - `main`: Contém a classe `MainRun`, que gerencia a execução da aplicação.
         - `domain`: Contém as classes de modelo como: `User`, `Topic`, `Comment`, `Course`). As classes de serviço estão dentro de seus domains respectivas.
         - `infra`: Exceção de erro e Pasta de configurações de segurança.
      - `resources`:
        - `db.migration`: Contém os arquivos de migration para o banco de dados.
        - `application.properties`: Arquivo com as configurações da applicação. 

## 📍Endpoints Principais

- `/users`: Endpoint para criar e autenticar usuários através de token JWT.
- `/topics`: Endpoint para operações CRUD de tópicos.

## 📃Documentação
Realizada documentação de endpoints em Postman <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postman.png" alt="logo do Postman" width="30" height="30" align="center"/>

## 👩🏻‍💻 Equipe desenvolvedora
<a href="https://github.com/JilMayumiMoutinho"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/104766367?v=4" width="100px;" alt="Foto da desenvolvedora com linkque encaminha ao github pessoal"/><br /><b>Jil Mayumi Moutinho</b></a>

## ✍️Contribuição

Se você deseja contribuir para o projeto, siga os passos abaixo:

1. Clone o repositório.
2. Crie uma nova branch: `git checkout -b minha-feature`.
3. Faça suas alterações e commite-as: `git commit -m 'Minha nova feature'`.
4. Envie para o repositório original: `git push origin minha-feature`.
5. Abra um Pull Request.

---
