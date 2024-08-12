# Sistema de Gerenciamento de Vendas 

## Descrição

Este projeto é um sistema de gerenciamento de vendas desenvolvido para uma loja de roupas. O objetivo é criar uma aplicação que permita o cadastro, alteração, deleção e consulta de clientes, funcionários, produtos e vendas.

### Funcionalidades

- **Clientes**: Cadastro de clientes com informações como nome, email, telefone, idade e endereço.
- **Funcionários**: Cadastro de funcionários com nome, email, telefone, idade, endereço e função.
- **Produtos**: Cadastro de produtos com nome, descrição e preço.
- **Vendas**: Cadastro de vendas que vincula um cliente e um funcionário a vários produtos. O valor total da venda é calculado automaticamente com base no preço dos produtos associados.

### Requisitos do Sistema

- **Cadastro de Entidades**:
  - **Clientes**: Nome, email, telefone, idade e endereço.
  - **Funcionários**: Nome, email, telefone, idade, endereço e função.
  - **Produtos**: Nome, descrição e preço.
  - **Vendas**: Cliente, funcionário, produtos vendidos, observações e valor total calculado internamente.

- **Consultas**:
  - Listagem de vendas filtradas por parte do nome do cliente.
  - Listagem de vendas filtradas por parte do nome do funcionário.
  - Listagem dos 10 produtos mais caros.
  - Listagem dos clientes com idade entre 18 e 35 anos.
  - Listagem das 10 vendas com totais mais altos.

### Tecnologias Utilizadas

- **Spring Boot**: Para desenvolvimento de APIs RESTful.
- **Hibernate / JPA**: Para mapeamento objeto-relacional e manipulação do banco de dados.
- **MySQL**: Banco de dados relacional para armazenamento das informações.
- **Postman**: Para teste dos endpoints da API.
