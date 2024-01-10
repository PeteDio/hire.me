-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: hiremedb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bio` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `candidate_status_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  KEY `FKapaes2hubp32u8ac63wurfek9` (`candidate_status_id`),
  CONSTRAINT `FKapaes2hubp32u8ac63wurfek9` FOREIGN KEY (`candidate_status_id`) REFERENCES `candidate_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1,'Experienced developer with expertise in Java and Python.','johndoe@example.com','John','Software Engineer','Doe',1),(2,'Skilled in data analysis and visualization tools.','janesmith@example.com','Jane','Data Analyst','Smith',2),(3,'Proven track record of leading successful projects.','bobjohnson@example.com','Bob','Project Manager','Johnson',3),(4,'Expert in front-end and back-end web development.','alicewilliams@example.com','Alice','Web Developer','Williams',2),(5,'Creative and innovative with a strong visual sense.','davidbrown@example.com','David','Designer','Brown',5),(6,'Passionate about building scalable and reliable software systems.','emilydavis@example.com','Emily','Software Engineer','Davis',3),(7,'Excellent data cleaning and analysis skills.','michaelmiller@example.com','Michael','Data Analyst','Miller',4),(8,'Experienced in Agile project management methodologies.','sarahjackson@example.com','Sarah','Project Manager','Jackson',1),(9,'Proficient in JavaScript frameworks and libraries.','williamjones@example.com','William','Web Developer','Jones',3),(10,'Strong UX and UI design skills with a focus on user experience.','elizabethgarcia@example.com','Elizabeth','Designer','Garcia',2);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_status`
--

DROP TABLE IF EXISTS `candidate_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate_status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4uihh7c2ph67ysa9hwk8pq9yk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_status`
--

LOCK TABLES `candidate_status` WRITE;
/*!40000 ALTER TABLE `candidate_status` DISABLE KEYS */;
INSERT INTO `candidate_status` VALUES (1,'Applied'),(4,'Hired'),(3,'Hiring Manager Screen'),(2,'Phone Screen'),(5,'Rejected');
/*!40000 ALTER TABLE `candidate_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interview` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datetime` datetime(6) NOT NULL,
  `notes` varchar(140) DEFAULT NULL,
  `candidate_id` bigint DEFAULT NULL,
  `employee_id` bigint DEFAULT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKjod0wwyxvbi7qyx9cmlnt8xq4` (`candidate_id`),
  KEY `FKpuh4van2kwvllyvmr1rtahq68` (`employee_id`),
  CONSTRAINT `FKjod0wwyxvbi7qyx9cmlnt8xq4` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKpuh4van2kwvllyvmr1rtahq68` FOREIGN KEY (`employee_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (1,'2024-01-09 05:44:00.000000',NULL,1,2,0),(2,'2024-01-09 05:45:00.000000',NULL,2,2,0),(3,'2024-01-09 05:46:00.000000',NULL,3,2,0),(4,'2024-01-09 05:47:00.000000',NULL,4,2,0),(5,'2024-01-09 05:48:00.000000',NULL,5,2,1),(6,'2024-01-09 05:49:00.000000',NULL,6,2,0),(7,'2024-01-09 05:50:00.000000',NULL,7,2,1),(8,'2024-01-09 05:51:00.000000',NULL,8,2,0),(9,'2024-01-09 05:52:00.000000',NULL,9,2,0),(10,'2024-01-09 05:53:00.000000',NULL,10,2,0),(11,'2024-01-09 05:54:00.000000',NULL,1,2,0),(12,'2024-01-09 05:55:00.000000',NULL,2,2,0),(13,'2024-01-09 05:56:00.000000',NULL,3,2,0),(14,'2024-01-09 05:57:00.000000',NULL,4,2,0),(15,'2024-01-09 05:58:00.000000',NULL,5,2,0),(16,'2024-01-09 05:59:00.000000',NULL,6,2,0);
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (4,'ADMIN'),(1,'coordinator'),(3,'hiringmanager'),(2,'recruiter');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_dl7g53f7lpmorjc24kx74apx8` (`role`),
  CONSTRAINT `FKl5alypubd40lwejc45vl35wjb` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin','$2a$10$D2.sG.j6ea6NPThzBrJ/x.0JtlIRX.hJvuA7PancFn3HV8gldqkgS',4),(2,'user2@example.com','User2','Doe','$2a$10$D2.sG.j6ea6NPThzBrJ/x.0JtlIRX.hJvuA7PancFn3HV8gldqkgS',1),(3,'user3@example.com','User3','Smith','$2a$10$D2.sG.j6ea6NPThzBrJ/x.0JtlIRX.hJvuA7PancFn3HV8gldqkgS',2),(4,'user4@example.com','User4','Johnson','$2a$10$D2.sG.j6ea6NPThzBrJ/x.0JtlIRX.hJvuA7PancFn3HV8gldqkgS',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-09 11:22:51
