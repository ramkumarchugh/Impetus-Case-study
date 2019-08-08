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
-- Table structure for table `base_plan`
--

DROP TABLE IF EXISTS `base_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_plan` (
  `baseplan_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `insurance_id` int(11) NOT NULL,
  `max_age` int(11) DEFAULT NULL,
  `max_dependents` int(11) DEFAULT NULL,
  `min_age` int(11) DEFAULT NULL,
  `max_years` int(11) DEFAULT NULL,
  `min_sum_assured` int(11) DEFAULT NULL,
  `max_sum_assured` int(11) DEFAULT NULL,
  PRIMARY KEY (`baseplan_id`),
  KEY `insurance_id_idx` (`insurance_id`),
  CONSTRAINT `insurance_id` FOREIGN KEY (`insurance_id`) REFERENCES `insurance_category` (`insurance_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_plan`
--

LOCK TABLES `base_plan` WRITE;
/*!40000 ALTER TABLE `base_plan` DISABLE KEYS */;
INSERT INTO `base_plan` VALUES (1,'life insurance',1,90,4,18,3,100000,2000000),(2,'dental',2,90,4,18,3,200000,8000000),(3,'dental and Vision',3,90,4,18,3,800000,1000000);
/*!40000 ALTER TABLE `base_plan` ENABLE KEYS */;
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
