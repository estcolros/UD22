
CREATE DATABASE IF NOT EXISTS `UD22EX3`;
USE `UD22EX3`;

CREATE TABLE Cientificos (
	DNI VARCHAR(8),
    NomApels NVARCHAR (255),
	PRIMARY KEY (DNI)
);

CREATE TABLE Proyecto (
	Id CHAR(4),
    Nombre NVARCHAR (255),
    Horas INT,
	PRIMARY KEY (Id)
);

CREATE TABLE AsignadoA (
Cientifico VARCHAR(8) NOT NULL,
Proyecto CHAR (4) NOT NULL,
primary key (Cientifico, Proyecto),
key indx_Cientifico (Cientifico),
key indx_Proyecto (Proyecto),
constraint Cientificos_fk foreign key (Cientifico) references Cientificos(DNI) ON UPDATE CASCADE,
constraint Proyecto_fk foreign key (Proyecto) references Proyecto(Id) ON UPDATE CASCADE
);

