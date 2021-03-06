﻿SHOW DATABASES;
SHOW TABLES;
DESCRIBE MULTA;
DESCRIBE VEICULO;
DESCRIBE PROPRIETARIO;
DESCRIBE LOGRADOURO;

DROP DATABASE IF EXISTS GTRANSITO;
CREATE DATABASE GTRANSITO;

USE GTRANSITO;
DROP TABLE IF EXISTS MULTA;
DROP TABLE IF EXISTS VEICULO;
DROP TABLE IF EXISTS PROPRIETARIO;
DROP TABLE IF EXISTS LOGRADOURO;

CREATE TABLE PROPRIETARIO (
    codigo         INT(05) NOT NULL,
    nome           VARCHAR(40) NOT NULL,
    identidade     VARCHAR(20) NOT NULL,
    codlog         INT(05) NOT NULL,
    numero         VARCHAR(8),
    telefone       VARCHAR(10),
    email          VARCHAR(30),
    PRIMARY KEY (codigo),
    KEY (codlog)
);

CREATE TABLE LOGRADOURO (
    codlog         INT(05) NOT NULL,
    descr          VARCHAR(40) NOT NULL,
    bairro         VARCHAR(15),
    cep            VARCHAR(40),
    cidade         VARCHAR(30),
    PRIMARY KEY(codlog),
    CONSTRAINT FK_CODLOG FOREIGN KEY (codlog) REFERENCES PROPRIETARIO(codlog)
);

CREATE TABLE VEICULO (
    codigo         INT(05),
    descr          VARCHAR(40) NOT NULL,
    chassi         DOUBLE,
    codpro         INT(05),
    UNIQUE (descr),
    PRIMARY KEY (codigo)
);

CREATE TABLE MULTA (
  codpro           INT(05),
  codvei           INT(05),
  data             DATE,
  pontuacao        INT(05),
  tipo             ENUM('LEVE','LEVISSIMA','GRAVE','GRAVISSIMA','MEDIA'),
  CONSTRAINT FK_CODPRO FOREIGN KEY (codpro) REFERENCES proprietario(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_CODVEI FOREIGN KEY (codvei) REFERENCES veiculo     (codigo)
);

ALTER TABLE PROPRIETARIO CHANGE CODIGO CODIGO INT(05) NOT NULL AUTO_INCREMENT;
ALTER TABLE VEICULO      CHANGE CODIGO CODIGO INT(05) NOT NULL AUTO_INCREMENT;

ALTER TABLE MULTA      DROP FOREIGN KEY FK_CODPRO;
ALTER TABLE VEICULO    ADD CONSTRAINT FK_CODPRO FOREIGN KEY (codpro) REFERENCES PROPRIETARIO(codigo) ON DELETE RESTRICT ON UPDATE RESTRICT;
