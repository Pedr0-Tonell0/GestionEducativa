-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: tpintegrador
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `LEGAJO` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` int(11) NOT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO` varchar(45) DEFAULT NULL,
  `MAIL` varchar(45) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL,
  `ID_TIPO` int(11) DEFAULT NULL,
  `DIRECCION` varchar(45) DEFAULT NULL,
  `ID_LOCALIDAD` int(11) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`LEGAJO`,`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (2,59595956,'Gabriel','DIlacio','dilacio@hotmail.com',1122334455,2,'Santa Rosa de lima',3,'1990-01-01',1),(3,45112112,'Santiago','Cinirella','santi@gmail.com',1555455445,2,'Mendoza 876',4,'1990-02-01',1),(4,564564698,'Marcelo','Guerrero',' marce@gmail.com',1231231234,2,' Santiago del Estero 7654',10,'1990-04-01',1),(5,65756754,'Jonatan','Perez',' jonna@gmail.com',1177689743,2,' chile 1233',1,'1998-04-05',1),(6,87643573,'Lidia','Fernandez',' lidita@gmail.com',1154578906,2,'Uruguay 3344',4,'1997-05-06',1),(7,34578964,'Bill','Gates','Billy@gmail.com',1123545756,2,' kennedy 3456',7,'1992-06-06',1),(8,57678964,'Ernesto','Sabato','Ernesti@gmail.com',1187245685,2,' Brasil 5642',9,'1999-09-09',1),(9,35679632,'Ulises','Bueno',' UliBueno@gmail.com',1164589643,2,' Ventanita florida 2468',10,'1996-03-05',1),(10,42767889,'Nestor',' En Bloque',' Bloque@gmail.com',1199456742,2,' J J Paso 776',11,'1994-07-06',1),(11,22334890,'Alejandra','Padron','Alecita@gmail.com',1145670643,2,' Las Heras 1234',15,'1994-11-01',1),(12,76345313,'Moria','Casan',' Laone@gmail.com',1134536676,2,' Canada 456',15,'1999-02-22',1),(13,35887668,'Gustavo','Napoli',' napoli@hotmail.com',1122334455,2,' saenz penia 789',9,'1992-12-04',1),(14,40361971,'Maxi',' Sar',' maxisar@gmail.com',1132515489,1,' Hipolito yrigoyen 1234',3,'2001-04-04',1),(15,40251956,'Daniel','Kloster',' kloster@utn.com',1551511511,1,' Blandengues 456',3,'1993-04-04',1),(16,39598534,'Damian','Natale',' natale@utn.com',1515548888,1,' Richieri 345',15,'1999-02-01',1),(17,45435355,' Maria Teresa',' Brizzi',' Teresa@gmail.com',1122354654,1,' Calcuta 5679',4,'1999-12-12',1),(18,34656345,'Angel','Simon',' AngelSimon@gmail.com',1134354599,1,' Cordoba 4445',1,'1993-08-08',1),(19,22455464,'Fernando','Calabuig',' Calabuig@gmail.com',1144557432,1,'  Francia 234',14,'1993-02-22',1),(20,22445453,'Cecilia','Lupani',' Lupani@gmail.com',1143634532,1,' Marco Sastres 123',2,'1996-12-09',1),(21,22343464,'Tamara','Herrera',' Herrera@gmail.com',1167554353,1,' Gelly Obes 1234',2,'2002-09-09',1),(22,40598521,'Cacho','Garay','cachogaray@gmail.com',1125631485,1,'acasusso 123',13,'1995-05-20',1),(31,35902517,'Pepe','Argento','pepe@gmail.com',15236317,1,'no se 123',1,'1990-05-05',1),(32,25169785,'Ricky','Fort','ricky@gmail.com',15236357,2,'no se 123',1,'1985-05-05',1),(35,40556677,'Jorge ','Rial','jorgito@gmail.com',154678952,1,'en la calle 135',2,'1997-05-20',1),(36,1234855,'Osvaldo','Perez','perezosvaldo@gmail.com',1566235,2,'en la calle 135',2,'1997-05-20',1),(37,4022244,'Jose','Frustachi','josecito@gmail.com',114568795,1,'boulogne 888',11,'1970-05-05',1),(38,36197852,'Ramon','Galeano','ramon@yahoo.com',15669871,2,'quirno costa 1887',15,'1991-01-01',1),(40,4236589,'Franco','Gonzalez','francog@gmail.com',112355610,2,'paraguay 123',3,'1995-05-05',1),(41,35698975,'Marcos','Allievi','marcos@live.com.ar',114568975,1,'victoria 666',7,'1998-04-20',1),(42,40647895,'Daniela','Avalos','dani@gmail.com',15632145,1,'Pacheco 128',1,'1975-05-03',1),(43,33254789,'Pablo','Perez','pablin@hotmail.com',11235450,2,'pacheco 999',1,'1999-01-01',1);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-10 14:26:03
