DROP DATABASE if EXISTS lapaletadb;
CREATE DATABASE lapaletadb;

USE lapaletadb;

CREATE TABLE usuario (
	usuario_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	uNombre VARCHAR(60) NOT NULL,
	uCargo VARCHAR(25) NOT NULL,
	uUsuario VARCHAR(45) NOT NULL,
	uContraseña VARCHAR(20) NOT NULL,
	uCorreoElectrónico VARCHAR(70) NOT NULL
);

INSERT INTO usuario (uNombre, uCargo, uUsuario,uContraseña, uCorreoElectrónico) 
		 VALUES ("Kevin Adrian Avelino Sánchez", "Gerente", "saakve","1234","avesanke@gmail.com");

INSERT INTO usuario (uNombre, uCargo, uUsuario,uContraseña, uCorreoElectrónico)
		 VALUES ("Kevin Domínguez Aguilera", "Gerente","kevdag21","1234","Kevin.dominguez2002@hotmail.com");

CREATE TABLE producto (
	producto_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ptNombre VARCHAR(60) NOT NULL,
	ptPrecio DECIMAL(10,4) NOT NULL,
	ptAlias VARCHAR(15) NOT NULL,
	inventario_id INT(20) NOT NULL,
	categoria_id INT(20) NOT NULL
);

insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Arrayán', 24, 'PtArr', 1, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Ensalada', 22, 'PtEns', 2, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Fresa', 40, 'PtFre', 3, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Fresa con Banano', 31, 'PtFreBan', 4, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Fresa con Naranja', 12, 'PtFreNar', 5, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Fresa con Limón', 20, 'PtFreLim', 6, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Fresa con Cerezas Negras', 20, 'PtFreCerNeg', 7, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Banano', 40, 'PtBan', 8, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Jamaica', 19, 'PtJam', 9, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Jocote', 29, 'PtJoc', 10, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Coco con limón', 32, 'PtCoclim', 11, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Tamarindo', 26, 'PtTam', 12, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Limonada Rosada', 40, 'PtLim', 13, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Limón con Hierba Buena', 34, 'PtLimHieBue', 14, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Limón', 19, 'PtLim', 15, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mamey', 20, 'PtMam', 16, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mango Maduro', 32, 'PtMan', 17, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mango Verde', 36, 'PtMan', 18, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mango', 12, 'PtMan', 19, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Pasión', 17, 'PtPas', 20, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Maracuyá', 13, 'PtMar', 21, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Maracuyá con limón', 38, 'PtMarlim', 22, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Marañon', 29, 'PtMar', 23, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Melón', 25, 'PtMel', 24, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Tutifruti', 12, 'PtTut', 25, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Sandía con Hierba buena', 24, 'PtSanHiebue', 26, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Piña con albahaca', 38, 'PtPiñalb', 27, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mora', 38, 'PtMor', 28, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Nance', 14, 'PtNan', 29, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Naranja', 30, 'PtNar', 30, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Naranja con apio', 20, 'PtNarapi', 31, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Naranja con limón', 19, 'PtNarlim', 32, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Piña', 40, 'PtPiñ', 33, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Piña con jengibre', 13, 'PtPiñjen', 34, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Piña pasión pink', 34, 'PtPiñpin', 35, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Melón', 18, 'PtMel', 36, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Sandía', 12, 'PtSan', 37, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Mango con coco', 17, 'PtMancoc', 38, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Piña con albahaca', 14, 'PtPiñalb', 39, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Paleta de Sandía con menta', 18, 'PtSanmen', 40, 1);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Americana', 70, 'CreAme', 41, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Banana plit', 67, 'CreBanpli', 42, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Frutilla a la crema', 48, 'CreFrualacre', 43, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Mascarpone con frutos rojos', 20, 'CreMasfruroj', 44, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Mascarpone con nutella', 32, 'CreMasnut', 45, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Menta granizada', 61, 'CreMengra', 46, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Pistaccio', 76, 'CrePis', 47, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema SambayÓn', 41, 'CreSam', 48, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Super sambayÓn', 66, 'CreSupsam', 49, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Granizado', 47, 'CreGra', 50, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Crema Tramontana oreo', 43, 'CreTraore', 51, 2);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Limón', 80, 'NieLim', 52, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Fresa', 32, 'NieFre', 53, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Tamarindo', 48, 'NieTam', 54, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Mango maduro', 61, 'NieManMad', 55, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Mango con chile', 46, 'NieManConChi', 56, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Arrayán', 35, 'NieArr', 57, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Jocote', 71, 'NieJoc', 58, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Mora y piña', 61, 'NieMorYPiñ', 59, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Limón', 87, 'NieLim', 60, 3);
insert into producto (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) values ('Nieve de Tamarindo', 33, 'NieTam', 62, 3);

CREATE TABLE categoria (
	categoria_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ctgNombre VARCHAR(60) NOT NULL
);

INSERT INTO categoria (ctgNombre) VALUES ("Paleta");
INSERT INTO categoria (ctgNombre) VALUES ("Crema");
INSERT INTO categoria (ctgNombre) VALUES ("Nieve");

CREATE TABLE inventarioProducto (
	inventario_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	invpCantidad INT(10) NOT NULL
);

insert into inventarioProducto (invpCantidad) values (21);
insert into inventarioProducto (invpCantidad) values (68);
insert into inventarioProducto (invpCantidad) values (99);
insert into inventarioProducto (invpCantidad) values (90);
insert into inventarioProducto (invpCantidad) values (52);
insert into inventarioProducto (invpCantidad) values (86);
insert into inventarioProducto (invpCantidad) values (53);
insert into inventarioProducto (invpCantidad) values (52);
insert into inventarioProducto (invpCantidad) values (24);
insert into inventarioProducto (invpCantidad) values (92);
insert into inventarioProducto (invpCantidad) values (22);
insert into inventarioProducto (invpCantidad) values (25);
insert into inventarioProducto (invpCantidad) values (80);
insert into inventarioProducto (invpCantidad) values (56);
insert into inventarioProducto (invpCantidad) values (54);
insert into inventarioProducto (invpCantidad) values (97);
insert into inventarioProducto (invpCantidad) values (73);
insert into inventarioProducto (invpCantidad) values (15);
insert into inventarioProducto (invpCantidad) values (67);
insert into inventarioProducto (invpCantidad) values (5);
insert into inventarioProducto (invpCantidad) values (63);
insert into inventarioProducto (invpCantidad) values (31);
insert into inventarioProducto (invpCantidad) values (19);
insert into inventarioProducto (invpCantidad) values (25);
insert into inventarioProducto (invpCantidad) values (87);
insert into inventarioProducto (invpCantidad) values (13);
insert into inventarioProducto (invpCantidad) values (85);
insert into inventarioProducto (invpCantidad) values (68);
insert into inventarioProducto (invpCantidad) values (61);
insert into inventarioProducto (invpCantidad) values (4);
insert into inventarioProducto (invpCantidad) values (33);
insert into inventarioProducto (invpCantidad) values (98);
insert into inventarioProducto (invpCantidad) values (43);
insert into inventarioProducto (invpCantidad) values (50);
insert into inventarioProducto (invpCantidad) values (80);
insert into inventarioProducto (invpCantidad) values (55);
insert into inventarioProducto (invpCantidad) values (16);
insert into inventarioProducto (invpCantidad) values (25);
insert into inventarioProducto (invpCantidad) values (6);
insert into inventarioProducto (invpCantidad) values (16);
insert into inventarioProducto (invpCantidad) values (15);
insert into inventarioProducto (invpCantidad) values (41);
insert into inventarioProducto (invpCantidad) values (94);
insert into inventarioProducto (invpCantidad) values (9);
insert into inventarioProducto (invpCantidad) values (8);
insert into inventarioProducto (invpCantidad) values (47);
insert into inventarioProducto (invpCantidad) values (36);
insert into inventarioProducto (invpCantidad) values (77);
insert into inventarioProducto (invpCantidad) values (96);
insert into inventarioProducto (invpCantidad) values (48);
insert into inventarioProducto (invpCantidad) values (98);
insert into inventarioProducto (invpCantidad) values (31);
insert into inventarioProducto (invpCantidad) values (86);
insert into inventarioProducto (invpCantidad) values (14);
insert into inventarioProducto (invpCantidad) values (75);
insert into inventarioProducto (invpCantidad) values (17);
insert into inventarioProducto (invpCantidad) values (16);
insert into inventarioProducto (invpCantidad) values (97);
insert into inventarioProducto (invpCantidad) values (80);
insert into inventarioProducto (invpCantidad) values (35);
insert into inventarioProducto (invpCantidad) values (51);
insert into inventarioProducto (invpCantidad) values (86);

ALTER TABLE producto ADD CONSTRAINT fk_inventario_id FOREIGN KEY(inventario_id) REFERENCES inventarioProducto(inventario_id);
ALTER TABLE producto ADD CONSTRAINT fk_categoria_id FOREIGN KEY(categoria_id) REFERENCES categoria(categoria_id);