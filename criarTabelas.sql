drop database if exists integracao;
create database integracao;
use integracao;

create table carro(
	id int not null auto_increment primary key,
    nome varchar(45) not null,
    valor float not null,
    modelo varchar(45) not null,
    ano int not null,
    marca varchar(45) not null
);

select * from carro;


