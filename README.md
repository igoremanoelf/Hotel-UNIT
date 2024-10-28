
🏨 **Hotel - UNIT**

Um sistema para reservas de hotel que possibilita aos usuários criar, visualizar, atualizar e cancelar reservas. Este projeto é desenvolvido com Spring Boot e adota uma arquitetura modular, o que facilita sua manutenção e escalabilidade.

## Funcionalidades

- **✍️ Criar Reserva**: Os usuários podem fazer uma nova reserva informando nome, gênero, e-mail, data de chegada, número de noites, quantidade de hóspedes e uma mensagem especial.
- **📜 Listar Reservas**: Permite a visualização de todas as reservas registradas.
- **📧 Buscar Reservas por E-mail**: Usuários têm a opção de encontrar reservas específicas através de seu e-mail.
- **🔄 Atualizar Reserva**: Possibilita a modificação de dados de uma reserva já existente.
- **❌ Cancelar Reserva**: Permite que os usuários excluam uma reserva específica.

## Tecnologias Utilizadas

- **Backend**: 
  - [Spring Boot](https://spring.io/projects/spring-boot) - Framework para desenvolvimento de aplicações em Java.
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Facilita a implementação de repositórios para acesso a dados.
  - [MySQL](https://www.mysql.com/) - Sistema de gerenciamento de banco de dados relacional.
  - [Lombok](https://projectlombok.org/) - Biblioteca que reduz o código repetitivo em Java.
  - [Swagger](https://swagger.io/) - Ferramenta para documentação da API e interface de testes.

## Estrutura do Projeto

O projeto é organizado de forma modular, facilitando a manutenção e a escalabilidade. A estrutura de diretórios é a seguinte:

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

- **📦 dtos**: Contém classes de Transferência de Dados utilizadas para a comunicação entre cliente e servidor.
- **🛠️ infra**: Abrange a infraestrutura da aplicação, incluindo controladores, entidades JPA e repositórios.
  - **🚦 controllers**: Define os endpoints da API para gerenciar reservas.
  - **🗃️ jpa**: Inclui as entidades JPA e repositórios que se conectam ao banco de dados.
    - **📋 entities**: Representações das tabelas no banco de dados.
- **🔍 repositories**: Interfaces que estendem `JpaRepository` para operações CRUD.
- **⚙️ services**: Contém a lógica de negócio para o gerenciamento de reservas.

## Configuração do Swagger

O Swagger está configurado para documentar a API. Para acessá-lo, inicie a aplicação e vá para:

```
http://localhost:8080/swagger-ui/index.html
```
