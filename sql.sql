CREATE DATABASE _01__jdbc;

CREATE TABLE coder(
	id int auto_increment primary key,
    name varchar(40) not null,
    age int not null,
    clan varchar(40) not null
);

INSERT INTO coder (name,age,clan) VALUES("Juan Manuel Tellez", 25, "Meta"),
("Carlos Alberto Villamizar", 22, "Lovelace");

SELECT * FROM coder;