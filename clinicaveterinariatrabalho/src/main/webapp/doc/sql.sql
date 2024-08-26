DROP database dbvetcare;

CREATE DATABASE IF NOT EXISTS dbvetcare character set utf8mb4 collate utf8mb4_bin;
use dbvetcare;

create table tutor( id bigint primary key not null auto_increment, nome varchar(50), telefone varchar (11), endereco varchar (60));

create table animal( id bigint primary key not null auto_increment, nome varchar(45), especie varchar(45), raca varchar(45), peso float, idade int, genero varchar(1), idtutor bigint, foreign key(idtutor) references tutor(id));

create table agendamento( id bigint primary key not null auto_increment, data date, hora time, idanimal bigint, foreign key(idanimal) references animal(id));

create table consulta( id bigint primary key not null auto_increment, tipo varchar(30), valor float, valorDesconto float);

create table medicamento( id bigint primary key not null auto_increment, concentracao float, idconsulta bigint, foreign key(idconsulta) references consulta(id));

INSERT INTO tutor (nome, telefone, endereco) VALUES
('João', '123456789', 'Rua A, 123'),
('Maria', '987654321', 'Avenida B, 456');


INSERT INTO animal (nome, especie, raca, peso, idade, genero, idtutor) 
VALUES ('Rex', 'Cachorro', 'Vira-lata', 10.5, 3, 'M', 1),
       ('Mel', 'Gato', 'Persa', 5.2, 2, 'F', 2);

-- (corrigido com idanimal)
INSERT INTO agendamento (data, hora, idanimal) 
VALUES ('2024-04-23', '09:00:00', 1), -- Associado ao animal com ID 1
       ('2024-04-25', '10:30:00', 2); -- Associado ao animal com ID 2

INSERT INTO consulta (tipo, valor, valorDesconto) 
VALUES ('Rotina', 50.0, 0.0), 
       ('Vacinação', 80.0, 10.0);

-- (corrigido com idconsulta)
INSERT INTO medicamento (concentracao, idconsulta) 
VALUES (2.5, 1), -- Associado à consulta com ID 1
       (5.0, 2); -- Associado à consulta com ID 2