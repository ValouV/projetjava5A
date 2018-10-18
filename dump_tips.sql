-- MySQL dump 10.13  Distrib 8.0.12, for osx10.13 (x86_64)
--
-- Host: localhost    Database: tips
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `aide` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (8,'Entrez ici vos commentaires sur la ville dans sa globalité.','Général'),(9,'Entrez dans titre le nom du restaurant que vous souhaitez tipser.','Restaurant'),(10,'Entrez dans titre le nom d\'un hôtel que vous souhaitez tipser.','Hotel'),(11,'Entrez dans titre le nom d\'une boîte de nuit que vous souhaitez tipser.','Boite de Nuit'),(12,'Entrez dans titre le nom d\'un musée restaurant que vous souhaitez tipser.','Musée'),(13,'Entrez dans titre le nom d\'un parc ou espace vert que vous souhaitez tipser.','Parc');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30),(30),(30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `note` (
  `id` int(11) NOT NULL,
  `note` int(11) DEFAULT NULL,
  `tips_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ufkmqwmbtvtrtj03v7rqylay` (`tips_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (9,1,7);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tips`
--

DROP TABLE IF EXISTS `tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tips` (
  `id` int(11) NOT NULL,
  `auteur` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `noteg` float DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `note_tips` int(11) DEFAULT NULL,
  `categorie_id` int(11) DEFAULT NULL,
  `ville_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1qoe41ecw7dlvva8vd1e9v0ek` (`categorie_id`),
  KEY `FKo3j5pjubijsf1y2pkytx5ffoo` (`ville_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tips`
--

LOCK TABLES `tips` WRITE;
/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
INSERT INTO `tips` VALUES (14,'Valentin','Paris est une ville magnifique j\'ai jamais vu ça.',5,'Paris ville de l\'amour',8,8,1),(15,'Paul','Vraiment on en fait tout un foin de Paris alors que Guingamp c\'est quand même vachement mieux.',3.1,'Surcoté',1,8,1),(16,'Tom','Qui a tué le beau Paris des années 60? C\'était mieux avant.',0.4,'Nul / 20',-4,8,1),(17,'Fan2Foot','Paris est magique. Marseille est tragique',5,'Paaaaaaaris est magique',3,8,1),(18,'Mario','Des pizzas de malade mental mec, on s\'en est tapés une bien bonne avec Michel',4.2,'Pizzeria Latino',-1,9,1),(19,'Paul','Du jamais vu, on s\'en met plein la pense à Guingamp alors qu\'a Paris...',2.1,'OBonGrec',5,9,1),(20,'Jenniffer','Je descend beaucoup dans cet hotel qui me le rend bien.',4.1,'Mariott',8,10,1),(21,'Corentin Killer','Un maximum de son on se croirait à IBIZAAAAAA',4.3,'La Cave de mon père',3,11,1),(22,'ChinoisFragile','J\'adore tout, on est là posé devant la Joconde.',3.9,'Louvres',-4,12,1),(23,'PomIer','On est là à côte de Paris, posé sous jack dans mon bendo.',2.1,'Sceaux',4,13,1),(24,'Manu','Mieux que Paris, d\'ailleurs je soutient l\'équipe d\'Espagne. Cheh',4,'Ville de mon coeur',14,8,2),(25,'Elisabeth','Brexit ou pas on reste meilleur que tous les autres',5,'Nice',3,8,3),(26,'Angela','Mein belle ville n\'est pas zehr bien fréquentée dezormais',3.1,'Arh',1,8,4),(27,'Tintin','On vient pour les frites et les gaufres puis on repart',0.2,'Une fois (pas plus)',0,8,5),(28,'RastaRocket','On est posé sur la place mais on vole mec',4.2,'Je plane man',0,8,6),(29,'Vladimir','J\'aimerais que cette capitale m\'appartienne',3.33,'Da da da',1,8,7);
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ville` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ville`
--

LOCK TABLES `ville` WRITE;
/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
INSERT INTO `ville` VALUES (1,'paris.png','Paris','France'),(2,'barcelone.png','Barcelone','Espagne'),(3,'londres.png','Londres','Angleterre'),(4,'berlin.png','Berlin','Allemagne'),(5,'bruxelles.png','Bruxelles','Belgique'),(6,'amsterdam.png','Amsterdam','Pays Bas'),(7,'prague.png','Prague','Republique Tchèque');
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 21:57:14
