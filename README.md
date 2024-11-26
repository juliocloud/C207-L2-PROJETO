# Esquema de Banco de Dados Integracao

## Visão Geral

Este esquema representa um sistema de gerenciamento de concessionárias com as seguintes entidades:
- Concessionárias
- Funcionários
- Carros
- Clientes
- Negociações
- CRLV (Carta de Registro e Licenciamento Veicular)

## Tabelas

### Concessionaria
- Chave primária: id
- Armazena informações sobre locais de concessionárias

### Funcionario
- Chave primária: id
- Representa funcionários que trabalham em concessionárias

### Carro
- Chave primária: id
- Contém detalhes sobre carros disponíveis para venda

### Cliente
- Chave primária: cpf
- Armazena informações dos clientes

### Cliente_has_Concessionaria
- Chave primária composta: (Cliente_cpf, Concessionaria_id)
- Representa relação muito-a-muito entre clientes e concessionárias

### Negociacao
- Chave primária: id
- Armazena detalhes de negociações incluindo cliente, concessionária, funcionário, carro e método de pagamento

### CRLV
- Chave primária composta: (Carro_id, Cliente_cpf)
- Representa detalhes do Cartão de Registro e Licenciamento Veicular para clientes

## Relacionamentos

- Uma concessionária pode ter vários funcionários
- Um funcionário trabalha apenas em uma concessionária
- Um carro está associado a uma concessionária
- Um cliente pode estar registrado em várias concessionárias
- Uma negociação envolve um cliente, uma concessionária, um funcionário e um carro
- Um CRLV está associado a um carro e um cliente

## Views

- vw_NegociacaoDetalhada fornece uma visualização detalhada das negociações incluindo informações relacionadas ao cliente, carro, concessionária e funcionário