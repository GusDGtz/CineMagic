DESCRIBE pelicula;
INSERT INTO pelicula VALUES (1, 'Interestellar', 'Christopher Nollan', 'En un futuro donde la Tierra se vuelve inhabitable, 
un grupo de astronautas viaja por un agujero de gusano en busca de un nuevo hogar para la humanidad.', 0);

INSERT INTO pelicula VALUES (2, 'Cars 2', 'John Lasseter', 'Rayo McQueen y Mate viajan por el mundo para competir en el Grand Prix Mundial,
 pero Mate se ve envuelto en una misión de espionaje internacional.', 0);

INSERT INTO pelicula VALUES (3, 'Todo en todas partes al mismo tiempo', 'Daniel Kwan y Daniel Scheinert', 'Evelyn, una mujer agotada, descubre que
 puede acceder a versiones alternativas de sí misma para salvar el multiverso de una amenaza caótica.', 0);
INSERT INTO pelicula VALUES (4, 'LEGO Movie', 'Phil Lord y Christopher Miller', 'Emmet, una figura LEGO común, es confundido con el “Elegido” y se 
une a un grupo de héroes para detener a un tirano que quiere congelar el universo LEGO.', 0);
INSERT INTO pelicula VALUES (5, 'Flow', 'Gints Zilbalodis', 'En un mundo postapocalíptico cubierto por agua, un gato gris oscuro emprende un viaje en velero junto a otros animales.
 Sin diálogo, la película narra su travesía para sobrevivir, explorar y encontrar esperanza en medio del desastre', 0);
INSERT INTO pelicula VALUES (6, 'Jojo Rabbit', 'Taika Waititi', 'Jojo, un niño alemán con un amigo imaginario que es Hitler, descubre que su madre esconde a una joven judía,
 lo que lo lleva a cuestionar sus creencias nazis.', 0);
INSERT INTO pelicula VALUES (7 , 'Oppenheimer', 'Christopher Nolan', 'Retrato del físico J. Robert Oppenheimer y su papel en el desarrollo
 de la bomba atómica durante la Segunda Guerra Mundial, enfrentando dilemas éticos y personales', 0);
 SELECT * FROM pelicula;
 
DESCRIBE sala;
INSERT INTO Sala VALUES(1, 1, 70);
INSERT INTO Sala VALUES(2, 2, 70);
INSERT INTO Sala VALUES(3, 3, 70);
INSERT INTO Sala VALUES(4, 4, 50);
INSERT INTO Sala VALUES(5, 5, 30);
SELECT * FROM sala;

DESCRIBE Funcion;
INSERT INTO Funcion VALUES  (1,'13:30', '2025-08-15', 2, 3);
INSERT INTO Funcion VALUES  (2,'18:10', '2025-08-17', 3, 2);
INSERT INTO Funcion VALUES  (3,'17:50', '2025-09-01', 4, 1);
INSERT INTO Funcion VALUES  (4,'12:00', '2025-08-05', 5, 5);
INSERT INTO Funcion VALUES  (5,'22:00', '2025-09-12', 1, 4);
INSERT INTO Funcion VALUES  (6,'23:00', '2025-08-16', 1, 6);
INSERT INTO Funcion VALUES  (7,'16:30', '2025-08-12', 2, 7);
INSERT INTO Funcion VALUES  (8,'17:20', '2025-09-01', 3, 7);
INSERT INTO Funcion VALUES  (9,'13:50', '2025-08-30', 4, 6);
INSERT INTO Funcion VALUES (10,'17:50', '2025-08-23', 5, 5);
INSERT INTO Funcion VALUES (11,'13:10', '2025-09-15', 1, 4);
INSERT INTO Funcion VALUES (12,'16:40', '2025-08-08', 2, 3);
INSERT INTO Funcion VALUES (13,'18:00', '2025-09-23', 3, 2);
INSERT INTO Funcion VALUES (14,'21:20', '2025-08-11', 4, 1);

DESCRIBE rol;
INSERT INTO Rol VALUES (1,'Espectador');
INSERT INTO Rol VALUES (2, 'Administrador de Cine');
UPDATE rol SET nombre_rol = 'ROLE_USER' WHERE id_rol = 1;
UPDATE rol SET nombre_rol = 'ROLE_ADMIN' WHERE id_rol = 2;

DESCRIBE USUARIO;
INSERT INTO Usuario(id_rol, nombre_usuario, correo_usuario, contrasenia) VALUES (2, 'Gustavo Dominguez', 'gustavo@metaphorce.com', 'contraseniasupersupersegura');
INSERT INTO Usuario(id_rol, nombre_usuario, correo_usuario, contrasenia) VALUES (1, 'Hector Armando', 'hector@gmail.com', 'contraseniasegura');
SELECT * FROM USUARIO; 