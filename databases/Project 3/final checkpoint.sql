CREATE DATABASE  IF NOT EXISTS `my_hospital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `my_hospital`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: my_hospital
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `Admission`
--

DROP TABLE IF EXISTS `Admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admission` (
  `admit_id` int NOT NULL,
  `patient_id` int DEFAULT NULL,
  `admit_date` date DEFAULT NULL,
  `diagnosis` varchar(50) DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `discharge_date` date DEFAULT NULL,
  PRIMARY KEY (`admit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admission`
--

LOCK TABLES `Admission` WRITE;
/*!40000 ALTER TABLE `Admission` DISABLE KEYS */;
INSERT INTO `Admission` VALUES (1,1,'2020-06-15','Sickness',1,'2020-06-17'),(2,1,'2020-07-14','Chicken Pox',1,'2020-08-22'),(3,1,'2020-09-14','Flu',1,'2020-09-21'),(4,1,'2020-10-29','Pneumonia',1,'2020-11-05'),(5,3,'2021-05-30','Cold',8,NULL),(6,4,'2021-06-27','Flu',8,NULL),(7,5,'2021-07-08','Pneumonia',8,NULL),(8,6,'2021-08-24','Cold',3,NULL);
/*!40000 ALTER TABLE `Admission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `emp_id` int NOT NULL,
  `emp_name` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `emp_lvl` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Thompson, Catherine',24,'Nurse'),(2,'Roberson, Katy',26,'Staff'),(3,'Manfred, Rob',27,'Nurse'),(4,'Christensen, Luke',28,'Admin'),(5,'Routzong, Katherine',30,'Dr'),(6,'Waters, Steve',35,'Nurse'),(7,'Peters, Julia',29,'Admin'),(8,'Barrett, Jackie',29,'Dr');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `patient_id` int NOT NULL,
  `patient_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (1,'John'),(2,'Steve'),(3,'JD'),(4,'Joy'),(5,'Luke'),(6,'Leroy'),(7,'Marcus'),(8,'Rebecca'),(9,'Jonathan'),(10,'Adam');
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_doctor`
--

DROP TABLE IF EXISTS `patient_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_doctor` (
  `visit_id` int NOT NULL,
  `patient_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `admission_id` int DEFAULT NULL,
  `is_primary` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`visit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_doctor`
--

LOCK TABLES `patient_doctor` WRITE;
/*!40000 ALTER TABLE `patient_doctor` DISABLE KEYS */;
INSERT INTO `patient_doctor` VALUES (1,1,5,1,1),(2,2,8,4,1),(3,1,9,2,0),(4,1,8,3,0);
/*!40000 ALTER TABLE `patient_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Room` (
  `room_id` int NOT NULL,
  `patient_id` int DEFAULT NULL,
  `admit_id` int DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` VALUES (1,1,3),(2,2,4),(3,3,5),(4,4,6),(5,5,7),(6,6,8),(7,0,NULL),(8,0,NULL),(9,0,NULL),(10,0,NULL),(11,0,NULL),(12,0,NULL),(13,0,NULL),(14,0,NULL),(15,0,NULL),(16,0,NULL),(17,0,NULL),(18,0,NULL),(19,0,NULL),(20,0,NULL);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Treatment`
--

DROP TABLE IF EXISTS `Treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Treatment` (
  `treatment_id` int NOT NULL,
  `admit_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `medication` varchar(50) DEFAULT NULL,
  `medical_procedure` varchar(50) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  PRIMARY KEY (`treatment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Treatment`
--

LOCK TABLES `Treatment` WRITE;
/*!40000 ALTER TABLE `Treatment` DISABLE KEYS */;
INSERT INTO `Treatment` VALUES (1,1,5,1,'Prednasone','Antibacterial ','2020-06-15 15:00:00'),(2,1,5,1,'Meloxicam','AntiInflammatory','2020-06-15 15:00:00'),(3,2,5,1,'Prednasone','Antibacterial','2020-07-27 15:00:00'),(4,3,5,3,'Prednasone','Antibacterial','2021-02-14 15:00:00'),(5,3,5,3,'Meloxicam','Antiinflammatory','2021-02-14 15:00:00'),(6,3,4,3,'Tylenol','AntiInflammatory','2021-02-14 15:00:00');
/*!40000 ALTER TABLE `Treatment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-30 17:12:57
