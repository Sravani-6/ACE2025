-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: chinki
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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `postid` int NOT NULL,
  `userid` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `media_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (101,1,'Breathtaking views like these remind us of the beauty that surrounds us','Nature Photo'),(102,2,'Exploring new places, making unforgettable memories','Image capturing a scenic destination'),(103,3,'Indulge your senses with every bite','Video of a delicious dish'),(104,4,'Every drop of sweat is a step closer to your goals','Video clip showing intense workout routines'),(105,5,'Believe in yourself, trust the journey, and never give up on your dreams','image with an inspiring quote'),(106,6,'Take a moment to appreciate the wonders of nature','BeautyInNature'),(107,7,'From vibrant flavors to exquisite presentations','cooking process'),(108,12,'Keep pushing, keep growing','exercise demonstrations'),(109,13,'Unconditional love, endless joy','Video featuring adorable pets playing'),(110,14,'Creativity knows no bounds','Image showcasing artwork'),(111,17,'Express yourself through fashion, let your style tell your story','clips featuring stylish outfits'),(112,18,'Get crafty and unleash your inner artist!','Step-by-step images'),(113,19,'Witnessing the magic of dawn or dusk is a gentle reminder','Image capturing the beauty of a sunrise or sunset'),(114,20,'Escape into a world of words and imagination','showcasing favorite book recommendations'),(115,21,'Innovation at its finest. Experience the future today with cutting-edge technology','Image of smart gadgets'),(116,22,'Memories worth cherishing, moments worth reliving','memorable moment from the past'),(117,23,'Protecting our planet is a collective responsibility','Video highlighting environmental initiatives'),(118,24,'Nourish your body, nurture your soul','Infographic health tips'),(119,26,'Protecting our planet is a collective responsibility','Video highlighting environmental initiatives'),(120,27,'Diversity is our strength, unity is our power','Video showcasing multicultural celebrations');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-20 10:32:03
