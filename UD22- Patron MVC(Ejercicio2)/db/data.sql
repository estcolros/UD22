
CREATE DATABASE IF NOT EXISTS `UD22`;
USE `UD22`;

CREATE TABLE `Cliente` (
  `id` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `profesion` varchar(30) DEFAULT NULL,
  `telefono` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `Videos` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`title` varchar(250) DEFAULT NULL,
	`director` varchar(250) DEFAULT NULL,
    `cli_id` int(11) DEFAULT NULL,
	PRIMARY KEY (`id`),
    CONSTRAINT `Videos_fk` FOREIGN KEY (`Cli_id`) REFERENCES Cliente (`id`)
);


