-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: Insurance
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mob_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (137,'Vijay nagar','delhi','1997-12-28','nikita@gmail.com','9874561231','Nikita','$2a$10$bdKR9fiIj.rk7FL7yXnpke.vNSFpFMhVUw4qRyLZ3xodYdkMExgdO','MP',3),(138,'Vijay Nagar','Indore','1996-08-28','divyansh@gmail.com','9874563210','Divyansh','$2a$10$wF8FyEief2X2fiMhl.FWRenXZVimz8jFWzgaSB7gS4aLGIgZHhH2S','MP',2),(139,'Triveni nagar','Indore','1995-03-19','ram@gmail.com','8974563215','Ram','$2a$10$VnHiZOb3LsmK29seBvwtc.F/j71ngmnqeiSPrzKRYfS1I8yjEAdCa','MP',1),(141,'anapurna','Indore','1997-06-05','aman@gmail.com','9587968756','Aman','$2a$10$yijsIWvN3g7eTFetnqndueLO1hY48rlpOCzgWyFxYht4mgQwBtNjS','MP',3),(161,'Sarthak nagar','Ujjain','1999-02-09','nikitajaiswalmit@gmail.com','9399402655','nikita','$2a$10$oyzMTKYMxO.ysbmyTSVXDOcKp3Syr9KPl4IjqOEYQ5G9YwT2Wy2sW','MP',3),(168,'22, mangalmurti','Indore','1990-09-15','omprakash.soni@impetus.co.in','7509739503','Om Prakash Soni','$2a$10$bvKUN0o8hGTCsO8LnrXHzeGeaVsuCt.Jap6NuiX7cUJ1GJCk4/W.i','MP',3),(189,'bypas','indore','1997-01-05','rahul@gmail.com','5689749812','rahul','$2a$10$GM86AnndWmWWh0F3hiRTpOZ7cH2QpuRAbRJIa9SEXShTSDFFqyn0u\n','MP',3),(194,'triveni colony','indore','1998-06-05','ravi@gmail.com','7894561230','ravi','$2a$10$JopSnhJviqnE/iXrtkwau.q4SOO97kfzaIls/TA7MU0tw9knmXwZm','MP',3),(199,'123rfgfgd','qwerty','2005-12-31','qwerty@q.com','4559565656','Qwerty','$2a$10$3fQqxhk.6StdPc10S0RsLOcYpBUFEhfwnMW2bMLh8nz1ZWvsPfRES','qwerty',3),(211,'triveni ','Indore','1997-09-07','rahul1@gmail.com','9584567497','Rahul','$2a$10$oY0nhOynmfOP3RWjpGclkO5B7SqmZC3DdS32xwgekUlpIa8teGdl2','Mp',3),(331,'ujaain main road','ujjain','1998-09-07','ravipatidar@gmail.com','8989968754','ravi','$2a$10$PxdD3TREpdtoNVrfmhaXvelsTSvyjrnXHfkKGElOr3A1gCV4q/lL.','MP',3),(348,'bank colony','indore','1997-07-09','neeraj@gmail.com','9893237753','Neeraj vyas','$2a$10$C2lBPcnkI43jOa.5Lifr3OhJFKChn0dOZdi20bJ.lj1NJ3uEU8oYO','MP',3),(354,'mahu naka','indore','1997-09-07','patidar@gmail.com','9584567497','patidar','$2a$10$1IRp07zQUWYpIfU6MXAQ5uiJbkdbOZ4YWVxBIQM9fpTKlf./2XMti','Mp',3),(358,'kalani nagar','indore','1998-08-07','yash@gmail.com','9584567497','yash','$2a$10$Tqup/XoUkJtGs.Lys.5SSOtIooVXuiuMHZryo.ORX6c2SuOdGrA4O','MP',3);
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

-- Dump completed on 2019-08-08 12:48:38
