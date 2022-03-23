CREATE SCHEMA IF NOT EXISTS GERAL;
CREATE SCHEMA IF NOT EXISTS CLIENTE_1;
CREATE SCHEMA IF NOT EXISTS CLIENTE_2;

CREATE TABLE IF NOT EXISTS GERAL.CLIENTES_DO_SISTEMA(
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NOME VARCHAR(255),
    EMPRESA VARCHAR(255),
    SCHEMA_ASSOCIADO VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS CLIENTE_1.PERSON (
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS CLIENTE_1.PRODUTO (
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NOME VARCHAR(50) NOT NULL,
    PRECO DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS CLIENTE_2.PERSON (
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS CLIENTE_2.PRODUTO (
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NOME VARCHAR(50) NOT NULL,
    PRECO DECIMAL(10,2) NOT NULL
);


