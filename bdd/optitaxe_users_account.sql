CREATE DATABASE  IF NOT EXISTS `optitaxe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `optitaxe`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: optitaxe
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `users_account`
--

DROP TABLE IF EXISTS `users_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_account` (
  `account_ID` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `users_accountcol` varchar(45) DEFAULT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_ID`),
  UNIQUE KEY `account_ID_UNIQUE` (`account_ID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_account`
--

LOCK TABLES `users_account` WRITE;
/*!40000 ALTER TABLE `users_account` DISABLE KEYS */;
INSERT INTO `users_account` VALUES (9,'Fladi','Issam','llizuna2001ll','izuna2001','Propriétaire',NULL,'2021-05-22 00:17:22'),(19,'Hayaoui','Zakariya','broly','1234','Propriétaire',NULL,'2021-05-26 07:33:54'),(20,'rehab','rehab','rehab','hhhh','Personnel',NULL,'2021-05-26 07:57:34'),(26,'rehab','essa','rhp','hhh','Personnel',NULL,'2021-05-26 07:59:37'),(27,'Errami','Rihab','rihabrihab','123456','Propriétaire',NULL,'2021-05-26 10:22:26'),(28,'Badr','Idhmida','badrbadr','123456','Propriétaire',NULL,'2021-06-01 08:18:25'),(29,'swilam','salm','salmsalm','123456','null',NULL,'2021-06-20 16:47:38'),(30,'salem','','','','null',NULL,'2021-06-20 16:48:32'),(31,'rhafour','salma','rhafrhaf','123456','Propriétaire',NULL,'2021-06-22 12:30:53'),(32,'test','test','personne','123456','Propriétaire',NULL,'2021-06-22 13:24:24'),(33,'test123','test123','test123','123456','Propriétaire',NULL,'2021-06-22 13:25:17'),(34,'RHAFOUR','SALMA','salmarha','salmaasus','Personnel',NULL,'2021-07-08 18:04:32'),(36,'Fladi','Issam','izuna2001','123456','Propriétaire',NULL,'2023-06-06 15:53:42');
/*!40000 ALTER TABLE `users_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06 17:02:37
