-- MySQL dump 10.13  Distrib 5.7.20, for osx10.13 (x86_64)
--
-- Host: localhost    Database: entity_test
-- ------------------------------------------------------
-- Server version	5.6.38

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
-- Table structure for table `cli_checklist`
--

DROP TABLE IF EXISTS `cli_checklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cli_checklist` (
  `id` varchar(39) NOT NULL,
  `version` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `something_else` varchar(255) NOT NULL,
  `date_created` datetime NOT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cli_checklist`
--

LOCK TABLES `cli_checklist` WRITE;
/*!40000 ALTER TABLE `cli_checklist` DISABLE KEYS */;
/*!40000 ALTER TABLE `cli_checklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cli_checklist_cli_checklist_labels`
--

DROP TABLE IF EXISTS `cli_checklist_cli_checklist_labels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cli_checklist_cli_checklist_labels` (
  `checklist_ent_labels_id` varchar(39) DEFAULT NULL,
  `checklist_label_ent_id` varchar(255) DEFAULT NULL,
  KEY `FKAEF261EF69C3AB86` (`checklist_label_ent_id`),
  KEY `FKAEF261EFBB0F7FFD` (`checklist_ent_labels_id`),
  CONSTRAINT `FKAEF261EF69C3AB86` FOREIGN KEY (`checklist_label_ent_id`) REFERENCES `cli_checklist_labels` (`id`),
  CONSTRAINT `FKAEF261EFBB0F7FFD` FOREIGN KEY (`checklist_ent_labels_id`) REFERENCES `cli_checklist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cli_checklist_cli_checklist_labels`
--

LOCK TABLES `cli_checklist_cli_checklist_labels` WRITE;
/*!40000 ALTER TABLE `cli_checklist_cli_checklist_labels` DISABLE KEYS */;
/*!40000 ALTER TABLE `cli_checklist_cli_checklist_labels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cli_checklist_labels`
--

DROP TABLE IF EXISTS `cli_checklist_labels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cli_checklist_labels` (
  `id` varchar(255) NOT NULL,
  `version` bigint(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cli_checklist_labels`
--

LOCK TABLES `cli_checklist_labels` WRITE;
/*!40000 ALTER TABLE `cli_checklist_labels` DISABLE KEYS */;
/*!40000 ALTER TABLE `cli_checklist_labels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` varchar(39) NOT NULL,
  `owner_id` varchar(39) NOT NULL,
  `status_id` varchar(39) NOT NULL,
  `reason_id` varchar(39) DEFAULT NULL,
  `transaction_id` varchar(39) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-19 11:29:34
