#  InfoNote - Sistema de Gerenciamento de Reparo de Notebooks

**InfoNote** é um sistema corporativo simples desenvolvido como estudo de caso da disciplina **Desenvolvimento de Sistemas Corporativos** (UERN - Sistemas para Internet).  
O sistema segue a arquitetura **MVC** e foi implementado utilizando **Spring Boot**, **MariaDB** e o padrão **Spring Security** para autenticação.

---

## Tecnologias Utilizadas

-  **Java 17**
-  **Spring Boot 3.1.6**
  - Spring Web
  - Spring Data JPA
  - Spring Security
-  **MariaDB**
- **Maven**
-  **Hibernate ORM**
-  **HTML + CSS + JS (Front-end simples)**

---

## Estrutura do Projeto

src/
└── main/
├── java/br/com/infonote/
│ ├── config/ → Configuração do Spring Security
│ ├── controller/ → Controladores (Autenticação, Módulos)
│ ├── model/ → Entidades JPA (Usuario, OrdemServico, etc)
│ ├── repository/ → Interfaces Repository (JPA)
│ ├── service/ → Regras de negócio
│ └── InfoNoteApplication.java
└── resources/
├── static/ → HTML, CSS, JS
├── templates/ → (opcional, se usar Thymeleaf)
└── application.properties

---

## Autenticação

O sistema utiliza **Spring Security** com **BCrypt** para armazenamento seguro de senhas.  
Um usuário **admin** é criado automaticamente no primeiro início do sistema:

| Usuário | Senha      | Função        |
|----------|-------------|---------------|
| admin    | admin123    | ROLE_ADMIN    |

---

## Configuração do Banco de Dados (MariaDB)

### Criar banco e usuário

Execute no console SQL ou HeidiSQL:

```sql
CREATE DATABASE infonote CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE USER 'infonote_user'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON infonote.* TO 'infonote_user'@'localhost';
FLUSH PRIVILEGES;

Arquivo application.properties
spring.datasource.url=jdbc:mariadb://localhost:3306/infonote
spring.datasource.username=infonote_user
spring.datasource.password=123456
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect

server.port=8080

 Executando o Projeto

Clone o repositório:

git clone https://github.com/FlavioFernades/infonote-spring-mariadb.git


Abra no Eclipse ou IntelliJ

Execute a classe:

br.com.infonote.InfoNoteApplication

Acesse:

http://localhost:8080/login.html
Funcionalidades Principais

Login seguro com autenticação via Spring Security

CRUD de Usuários e Ordens de Serviço (em desenvolvimento)

Persistência de dados via JPA/Hibernate

Arquitetura MVC com boas práticas

Conexão MariaDB configurável

Estrutura de Telas
Tela	Descrição
login.html	Tela de autenticação de usuário
index.html	Painel principal do sistema (após login)
teste.html	Tela auxiliar de teste de acesso
logout	Encerra a sessão atual

Desenvolvido por

Flávio Fernades
Disciplina: Desenvolvimento de Sistemas Corporativos
Curso: Sistemas para Internet - UERN
Professor: Francisco Chagas de Lima Júnior
Semestre: 2025.2



