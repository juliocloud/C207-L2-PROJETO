-- Create database
DROP DATABASE IF EXISTS integracao;
CREATE DATABASE integracao;
USE integracao;

CREATE TABLE Concessionaria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    Concessionaria_id INT,
    FOREIGN KEY (Concessionaria_id) REFERENCES Concessionaria(id) ON DELETE CASCADE
);

CREATE TABLE Carro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    marca VARCHAR(50) NOT NULL,
    Concessionaria_id INT,
    FOREIGN KEY (Concessionaria_id) REFERENCES Concessionaria(id) ON DELETE CASCADE
);



CREATE TABLE CRLV (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vencimento DATE NOT NULL,
    Carro_id INT,
    FOREIGN KEY (Carro_id) REFERENCES Carro(id) ON DELETE CASCADE
);

CREATE TABLE Cliente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Cliente_has_Concessionaria (
    Cliente_cpf VARCHAR(11),
    Concessionaria_id INT,
    PRIMARY KEY (Cliente_cpf, Concessionaria_id),
    FOREIGN KEY (Cliente_cpf) REFERENCES Cliente(cpf),
    FOREIGN KEY (Concessionaria_id) REFERENCES Concessionaria(id) ON DELETE CASCADE
);

CREATE TABLE Negociacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Cliente_cpf VARCHAR(11),
    Concessionaria_id INT,
    formaPagamento VARCHAR(50) NOT NULL,
    comissao DECIMAL(10, 2) NOT NULL,
    Funcionario_id INT,
    Funcionario_Concessionaria_id INT,
    Carro_id INT,
    FOREIGN KEY (Cliente_cpf) REFERENCES Cliente(cpf),
    FOREIGN KEY (Concessionaria_id) REFERENCES Concessionaria(id) ON DELETE CASCADE,
    FOREIGN KEY (Funcionario_id) REFERENCES Funcionario(id),
    FOREIGN KEY (Carro_id) REFERENCES Carro(id) ON DELETE CASCADE
);

INSERT INTO Concessionaria (nome) VALUES ('Concessionária A');
INSERT INTO Concessionaria (nome) VALUES ('Concessionária B');

INSERT INTO Cliente (cpf, nome, telefone, email) VALUES ('12345678901', 'Cliente 1', '1234567890', 'cliente1@example.com');
INSERT INTO Cliente (cpf, nome, telefone, email) VALUES ('23456789012', 'Cliente 2', '2345678901', 'cliente2@example.com');

INSERT INTO Funcionario (nome, cargo, Concessionaria_id) VALUES ('Funcionario 1', 'Vendedor', 1);
INSERT INTO Funcionario (nome, cargo, Concessionaria_id) VALUES ('Funcionario 2', 'Gerente', 2);

INSERT INTO Carro (nome, valor, modelo, ano, marca, Concessionaria_id) VALUES ('Carro 1', 50000, 'Modelo 1', 2020, 'Marca 1', 1);
INSERT INTO Carro (nome, valor, modelo, ano, marca, Concessionaria_id) VALUES ('Carro 2', 60000, 'Modelo 2', 2021, 'Marca 2', 2);

INSERT INTO Negociacao (Cliente_cpf, Concessionaria_id, formaPagamento, comissao, Funcionario_id, Carro_id) VALUES ('12345678901', 1, 'À vista', 5000, 1, 1);
INSERT INTO Negociacao (Cliente_cpf, Concessionaria_id, formaPagamento, comissao, Funcionario_id, Carro_id) VALUES ('23456789012', 2, 'Financiamento', 6000, 2, 2);


UPDATE Concessionaria SET nome = 'Concessionária X' WHERE id = 1;

UPDATE Cliente SET telefone = '9876543210' WHERE cpf = '12345678901';

UPDATE Funcionario SET cargo = 'Supervisor' WHERE id = 1;

UPDATE Carro SET valor = 55000 WHERE id = 1;

UPDATE Negociacao SET Concessionaria_id = NULL WHERE Concessionaria_id = 2;



DELETE FROM Carro WHERE id = 2;

DELETE FROM Cliente WHERE cpf = '23456789012';

DELETE FROM Funcionario WHERE id = 2;


SELECT Carro.nome AS Carro, Carro.modelo, Carro.ano, Carro.marca, Concessionaria.nome AS Concessionaria
FROM Carro
JOIN Concessionaria ON Carro.Concessionaria_id = Concessionaria.id;

SELECT Negociacao.id, Cliente.nome AS Cliente, Carro.nome AS Carro, Negociacao.formaPagamento, Negociacao.comissao
FROM Negociacao
JOIN Cliente ON Negociacao.Cliente_cpf = Cliente.cpf
JOIN Carro ON Negociacao.Carro_id = Carro.id;

SELECT Funcionario.nome AS Funcionario, Funcionario.cargo, Concessionaria.nome AS Concessionaria
FROM Funcionario
JOIN Concessionaria ON Funcionario.Concessionaria_id = Concessionaria.id;



CREATE VIEW vw_NegociacaoDetalhada AS
SELECT Negociacao.id, Cliente.nome AS Cliente, Carro.nome AS Carro, Carro.modelo, Carro.ano, Carro.marca, Concessionaria.nome AS Concessionaria, Negociacao.formaPagamento, Negociacao.comissao, Funcionario.nome AS Funcionario
FROM Negociacao
JOIN Cliente ON Negociacao.Cliente_cpf = Cliente.cpf
JOIN Carro ON Negociacao.Carro_id = Carro.id
JOIN Concessionaria ON Negociacao.Concessionaria_id = Concessionaria.id
JOIN Funcionario ON Negociacao.Funcionario_id = Funcionario.id;

SELECT * FROM vw_NegociacaoDetalhada;


