-- MySQL dump 10.16  Distrib 10.2.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: aquascore
-- ------------------------------------------------------
-- Server version	10.2.12-MariaDB-10.2.12+maria~zesty

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
-- Table structure for table `hibernate_sequence`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(8,1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'steven@aquascore.com','Steven','Oud','$2a$12$mv/957q/Ut1bSQferFn/0u82iC8CuDb4Eur64CNqg6NzeZf5v8tc.'),(2,'yannick@aquascore.com','Yannick','de Graaff','$2a$12$uXhfin7jvRAmNnq9m7KRmuR2YegnNHuZgmm0raoxvp3uPqeTcKkMa'),(3,'yessin@aquascore.com','Yessin','el Khaldi','$2a$12$I19H.0Zcgsa5gvTXWaKnJ.n8RCYAQnaMAtJ5oy8UsaSpHPq9zASM6'),(4,'gabriel@aquascore.com','Gabriel','Takyie','$2a$12$PADBBTEEa83uuhQIViu4CuV5DRhzwM0ktj9O.ZWl1TcEygwEVb5Uu'),(5,'leon@aquascore.com','Leon','Timmerman','$2a$12$jOs4Bg21ggoThAPuqBpEj.v2nJ92ouoX/et9krbT4ZuyT7iqCGNhW');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `pool` WRITE;
/*!40000 ALTER TABLE `pool` DISABLE KEYS */;
INSERT INTO `pool` VALUES (6,'Besties',5,NULL),(7,'Max Fan Club',1,NULL);
/*!40000 ALTER TABLE `pool` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-29 12:41:29
