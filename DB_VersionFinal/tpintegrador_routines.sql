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
-- Temporary view structure for view `vw_profesores`
--

DROP TABLE IF EXISTS `vw_profesores`;
/*!50001 DROP VIEW IF EXISTS `vw_profesores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_profesores` AS SELECT 
 1 AS `LEGAJO`,
 1 AS `NOMBRE`,
 1 AS `APELLIDO`,
 1 AS `MAIL`,
 1 AS `TELEFONO`,
 1 AS `DNI`,
 1 AS `DIRECCION`,
 1 AS `LOCALIDAD`,
 1 AS `PROVINCIA`,
 1 AS `EDAD`,
 1 AS `USUARIO`,
 1 AS `CONTRASEÑA`,
 1 AS `CURSOS`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_profesores`
--

/*!50001 DROP VIEW IF EXISTS `vw_profesores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_profesores` AS select `p`.`LEGAJO` AS `LEGAJO`,`p`.`NOMBRE` AS `NOMBRE`,`p`.`APELLIDO` AS `APELLIDO`,`p`.`MAIL` AS `MAIL`,`p`.`TELEFONO` AS `TELEFONO`,`p`.`DNI` AS `DNI`,`p`.`DIRECCION` AS `DIRECCION`,`l`.`DESCRIPCION` AS `LOCALIDAD`,`pr`.`DESCRIPCION` AS `PROVINCIA`,(year(curdate()) - year(`p`.`FECHA_NACIMIENTO`)) AS `EDAD`,`u`.`USUARIO` AS `USUARIO`,`u`.`CONTRASEÑA` AS `CONTRASEÑA`,(select count(`c`.`ID_CURSO`) from `cursos` `c` where (`c`.`ID_DOCENTE` = `p`.`LEGAJO`)) AS `CURSOS` from (((`personas` `p` join `usuario` `u` on((`p`.`LEGAJO` = `u`.`LEGAJO`))) join `localidad` `l` on((`l`.`ID_LOCALIDAD` = `p`.`ID_LOCALIDAD`))) join `provincia` `pr` on((`l`.`ID_PROVINCIA` = `pr`.`ID_PROVINCIA`))) where ((`p`.`ID_TIPO` = 1) and (`p`.`ID_ESTADO` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-10 14:26:04
