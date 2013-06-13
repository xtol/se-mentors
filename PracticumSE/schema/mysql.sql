-- MySQL dump 10.10
--
-- Host: localhost    Database: hospitalmanagement
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt

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
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `email` varchar(30) default NULL,
  `firstName` tinyint(1) default NULL,
  `middleName` tinyint(1) default NULL,
  `lastname` tinyint(1) default NULL,
  `username` tinyint(1) default NULL,
  `gender` tinyint(1) default NULL,
  `country` tinyint(1) default NULL,
  `city` tinyint(1) default NULL,
  `pincode` tinyint(1) default NULL,
  `address` tinyint(1) default NULL,
  `ph_no` tinyint(1) default NULL,
  `date` tinyint(1) default NULL,
  `month` tinyint(1) default NULL,
  `year` tinyint(1) default NULL,
  KEY `email` (`email`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`email`) REFERENCES `reg_page2` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES ('sajja.sai.prasanna@gmail.com',1,1,1,1,1,1,1,1,1,1,1,1,1),('sajja.guna.sekhar@gmail.com',1,1,1,1,1,1,1,1,1,1,1,1,1),('chand.msit@gmail.com',1,1,1,1,1,1,1,1,1,1,1,1,1);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reg_page`
--

DROP TABLE IF EXISTS `reg_page`;
CREATE TABLE `reg_page` (
  `firstName` varchar(30) default NULL,
  `middleName` varchar(30) default NULL,
  `lastname` varchar(30) default NULL,
  `email` varchar(30) NOT NULL default '',
  `code_enter` varchar(10) default NULL,
  PRIMARY KEY  (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg_page`
--

LOCK TABLES `reg_page` WRITE;
/*!40000 ALTER TABLE `reg_page` DISABLE KEYS */;
INSERT INTO `reg_page` VALUES ('kolli','','chandrika','chand.msit@gmail.com','QL3V0'),('kolli','','chandrika','chandu.msit@gmail.com','V5WFW'),('sajja','','gunasekhar','sajja.guna.sekhar@gmail.com','VAWUT'),('sajja','','saiprasanna','sajja.sai.prasanna@gmail.com','GNG0N');
/*!40000 ALTER TABLE `reg_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reg_page2`
--

DROP TABLE IF EXISTS `reg_page2`;
CREATE TABLE `reg_page2` (
  `username` varchar(30) default NULL,
  `gender` varchar(10) default NULL,
  `country` varchar(20) default NULL,
  `city` varchar(20) default NULL,
  `pincode` varchar(10) default NULL,
  `address` text,
  `ph_no` varchar(15) default NULL,
  `date` varchar(2) default NULL,
  `month` varchar(3) default NULL,
  `year` varchar(4) default NULL,
  `password` varchar(20) default NULL,
  `email` varchar(30) default NULL,
  KEY `email` (`email`),
  CONSTRAINT `reg_page2_ibfk_1` FOREIGN KEY (`email`) REFERENCES `reg_page` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg_page2`
--

LOCK TABLES `reg_page2` WRITE;
/*!40000 ALTER TABLE `reg_page2` DISABLE KEYS */;
INSERT INTO `reg_page2` VALUES ('sajja$867','female','New Jersey','Elizabeth','22222','sssss','2222','15','FEB','1993','msit','sajja.sai.prasanna@gmail.com'),('sajjanasek$256','male','New Jersey','Newark','2222','2222','2222','03','MAR','1993','msit','sajja.guna.sekhar@gmail.com'),('chandrika','female','Pennsylvania','Allentown','3333','hfhhd','34343','03','MAR','1992','msit','chand.msit@gmail.com');
/*!40000 ALTER TABLE `reg_page2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-13 18:28:39
