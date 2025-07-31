CREATE DATABASE CineMagic;
USE CineMagic;

CREATE TABLE Pelicula(
	id_pelicula INT NOT NULL PRIMARY KEY,
    nombre_pelicula VARCHAR(40),
    director_pelicula VARCHAR(100),
    sinopsis_pelicula VARCHAR(500),
    boletos_vendidos INT
);
CREATE TABLE Resenia(
	id_resenia INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    valoracion INT NOT NULL,
    cuerpo_resenia VARCHAR(500),
    id_pelicula INT NOT NULL,
    FOREIGN KEY(id_pelicula) REFERENCES Pelicula(id_pelicula)
);
CREATE TABLE Sala(
	id_sala INT NOT NULL PRIMARY KEY,
    numero_sala INT NOT NULL,
    capacidad_sala INT NOT NULL
);
CREATE TABLE Funcion(
	id_funcion INT NOT NULL PRIMARY KEY,
    horario_funcion VARCHAR(40),
    fecha_funcion DATE,
    id_sala INT NOT NULL,
    id_pelicula INT NOT NULL,
    FOREIGN KEY (id_sala) REFERENCES Sala(id_sala),
    FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula)
);
CREATE TABLE Asiento (
	id_asiento INT PRIMARY KEY NOT NULL,
    fila_asiento CHAR NOT NULL,
    columna_asiento INT NOT NULL,
    id_sala INT NOT NULL,
    FOREIGN KEY (id_sala) REFERENCES Sala(id_sala)
);
CREATE TABLE Rol(
	id_rol INT PRIMARY KEY NOT NULL,
    nombre_rol VARCHAR(30)
);
CREATE TABLE Usuario(
	id_usuario INT PRIMARY KEY NOT NULL,
    id_rol INT NOT NULL DEFAULT 1,
    nombre_usuario VARCHAR(50),
    correo_usuario VARCHAR(60),
    contrasenia VARCHAR (30) NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol)
);
-- Me di cuenta que sería mas dificil pedir al usuario un id, la base de datos lo automatizará
	-- Desactiva las restricciones
	SET FOREIGN_KEY_CHECKS = 0;
	-- Modifica la columna para que sea autoincrementable
	ALTER TABLE usuario
	MODIFY COLUMN id_usuario INT NOT NULL AUTO_INCREMENT;
	-- Reactiva las restricciones
	SET FOREIGN_KEY_CHECKS = 1;
	
    -- El minimo para contrasenas encriptadas es de 60 asi que hay que aumentarlo
    ALTER TABLE Usuario
    MODIFY COLUMN contrasenia VARCHAR(100) NOT NULL;


CREATE TABLE Pago(
	id_pago INT PRIMARY KEY NOT NULL,
    total_pago INT NOT NULL,
    metodo_pago VARCHAR(30) NOT NULL,
    fecha_pago DATETIME,
    referencia_pago VARCHAR(50),
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);
CREATE TABLE Boleto(
	id_boleto INT PRIMARY KEY NOT NULL,
    id_asiento INT NOT NULL,
    id_funcion INT NOT NULL,
    id_pago INT NOT NULL,
    precio INT NOT NULL,
    FOREIGN KEY (id_asiento) REFERENCES Asiento(id_asiento),
    FOREIGN KEY (id_funcion) REFERENCES Funcion(id_funcion),
    FOREIGN KEY (id_pago) REFERENCES Pago(id_pago)
)