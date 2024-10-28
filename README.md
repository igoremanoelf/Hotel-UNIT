
# 🏨 Hotel Reservation System

Um sistema de reservas de hotel que permite aos usuários criar, listar, atualizar e excluir reservas. O projeto é construído com Spring Boot e utiliza uma arquitetura modular para facilitar a manutenção e a escalabilidade.

## Funcionalidades

- **✍️ Criar Reserva**: Permite que os usuários criem uma nova reserva com informações como nome, gênero, email, data de chegada, número de noites, número de hóspedes e mensagem especial.
- **📜 Listar Reservas**: Permite que os usuários vejam todas as reservas cadastradas.
- **📧 Listar Reservas por Email**: Usuários podem buscar reservas específicas utilizando seu email.
- **🔄 Atualizar Reserva**: Possibilita a atualização de informações de uma reserva existente.
- **❌ Excluir Reserva**: Permite que os usuários excluam uma reserva específica.

## Tecnologias Utilizadas

- **Backend**: 
  - [Spring Boot](https://spring.io/projects/spring-boot) - Framework para desenvolvimento de aplicações Java.
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Simplifica a implementação de repositórios de acesso a dados.
  - [MySQL](https://www.mysql.com/) - Sistema de gerenciamento de banco de dados relacional.
  - [Lombok](https://projectlombok.org/) - Biblioteca que ajuda a reduzir o código boilerplate em Java.
  - [Swagger](https://swagger.io/) - Documentação da API e interface de teste.

## Arquitetura do Projeto

O projeto é estruturado de maneira modular, facilitando a manutenção e a escalabilidade. A estrutura de pastas é a seguinte:

```
config (SwaggerUI)
modules
└── reservations (Tabela)
    ├── dtos
    ├── infra
    │   ├── controllers
    │   ├── jpa
    │       └── entities
    ├─ repositories
    └─ services
```

### Módulos

- **📦 dtos**: Contém as classes Data Transfer Object que são usadas para transferir dados entre o cliente e o servidor.
- **🛠️ infra**: Contém a infraestrutura da aplicação, incluindo controladores, entidades JPA e repositórios.
  - **🚦 controllers**: Define os endpoints da API para manipulação de reservas.
  - **🗃️ jpa**: Contém as entidades JPA e repositórios que interagem com o banco de dados.
    - **📋 entities**: Representações das tabelas do banco de dados.
- **🔍 repositories**: Interfaces que estendem `JpaRepository` para operações CRUD.
- **⚙️ services**: Contém a lógica de negócio para manipulação das reservas.

## Configuração do Swagger

O Swagger está configurado para documentar a API. Para acessá-lo, inicie a aplicação e navegue até:

```
http://localhost:8080/swagger-ui/index.html
```

## Instruções de Execução

### Pré-requisitos

- Java 17 ou superior ☕
- Maven 🛠️
- MySQL 📊

1. Execute o projeto usando Maven:

```bash
mvn spring-boot:run
```

2. Acesse a API no endpoint:

```
http://localhost:8080
```