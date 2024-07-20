-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: socialmedia
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `emailID` varchar(30) NOT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'manaswi','manaswireddy2003@gmail.com','manu@10'),(2,'rashi','rashmitha487@gmail.com','rashi@45'),(3,'jasmitha','jashmith20@gmail.com','jashu@20'),(4,'ricky','ricky07@gmail.com','ricky@144'),(5,'vamshi','vamshi83@gmail.com','vamshi134'),(6,'naveen','naveen18@gmail.com','naveen@10'),(7,'srishanth','srishanth20@gmail.com','mannnu@48'),(8,'minni','minni25@gmail.com','minni@45'),(9,'sunitha','sunitha28@gmail.com','sunii@47'),(10,'sindhu','sindhureddy23@gmail.com','chinni@35'),(11,'pranathi','pranathu47@gmail.com','pranuuu@93'),(12,'chikki','chikki45@gmail.com','chikki@824'),(13,'deekshith','deekshithreddy@gmail.com','deek@18'),(14,'sravani','sravanigoud@gmail.com','sravs@19'),(15,'sowmya','sowmyarani25@gmail.com','rani@25'),(16,'sai ram','sairam20@gmail.com','sai@18634'),(17,'raghava','raghava1@gmail.com','raghava@1'),(18,'deepthi','deepthireddy@gmail.com','deepu@11'),(19,'sunny','sunny10@gmail.com','sunny@34'),(20,'suvarna','suvarna17@gmail.com','suvarna@17'),(21,'ramadevi','ramadevi245@gmail.com','devii@95'),(22,'vedavarshan','vedaa34@gmail.com','vedhaaa@45'),(23,'archana','archana45@gmail.com','archana@97'),(24,'nikitha','nithithaa34@gmail.com','nikitha@44'),(25,'pramod','pramod34@gmail.com','pramod@795'),(26,'madhav','madhav3@gmail.com','madhav@97'),(27,'srinivas','srinivas54@gmail.com','srini@48'),(28,'prabas','prabas34@gmail.com','prabas@77'),(29,'ajith','ajith34@gmail.com','ajith@66'),(30,'sampath','sampath45657@gmail.com','sampth@55'),(31,'praveen','praveen34gmail.com','praveen@43'),(32,'vijay','vijay33@gmail.com','vijay@84'),(33,'arjun','arjun3454@gmail.com','arjun@48'),(34,'krishna','krish44@gmail.com','krishs@34'),(35,'padma','padma34@gmail.com','padma@25'),(36,'shruthi','shruthi34@gmail.com','shurith@634'),(37,'nandu','nandu35@gmail.com','nandu@1'),(38,'bharath','bharath234@gmail.com','bharath@344'),(39,'saikumar','saikumar34gmail.com','saikumar@66'),(40,'greesham','greeshma34@gmail.com','greesh@17');
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

-- Dump completed on 2024-07-20 10:48:56
