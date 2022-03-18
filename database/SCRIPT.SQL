DROP DATABASE if EXISTS lapaletadb;
CREATE DATABASE lapaletadb;

USE lapaletadb;

CREATE TABLE usuario (
	usuario_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	uNombre VARCHAR(45) NOT NULL,
	uCargo VARCHAR(25) NOT NULL,
	uUsuario VARCHAR(45) NOT NULL,
	uContraseña VARCHAR(20) NOT NULL,
	uCorreoElectrónico VARCHAR(70) NOT NULL
);

INSERT INTO usuario (uNombre, uCargo, uUsuario,uContraseña, uCorreoElectrónico) 
		 VALUES ("Kevin Adrian Avelino Sánchez", "Gerente", "saakve","pr03b4","avesanke@gmail.com");

INSERT INTO usuario (uNombre, uCargo, uUsuario,uContraseña, uCorreoElectrónico)
		 VALUES ("Kevin Domínguez Aguilera", "Gerente","kevdag21","UgSKcdc#1","Kevin.dominguez2002@hotmail.com");