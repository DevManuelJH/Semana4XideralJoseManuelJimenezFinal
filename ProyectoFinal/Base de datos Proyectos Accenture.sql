CREATE DATABASE  IF NOT EXISTS `Desarrolladores_Accenture`;
USE `Desarrolladores_Accenture`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `desarrollador`;

CREATE TABLE `desarrollador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `proyecto` varchar(100) DEFAULT NULL,
  `puesto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `desarrollador` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com', 'BBVA', 'Dev Frontend'),
	(2,'Emma','Baumgarten','emma@luv2code.com', 'CAT', 'Tester'),
	(3,'Avani','Gupta','avani@luv2code.com', 'Santander', 'Dev Backend'),
	(4,'Yuri','Petrov','yuri@luv2code.com', 'UBER', 'Lider Tecnico'),
	(5,'Juan','Vega','juan@luv2code.com', 'Disney', 'SCRUM manager');