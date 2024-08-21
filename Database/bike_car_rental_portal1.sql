CREATE DATABASE  IF NOT EXISTS `bike_car_rental_portal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bike_car_rental_portal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bike_car_rental_portal
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `area_id` int NOT NULL AUTO_INCREMENT,
  `area_name` varchar(100) NOT NULL,
  `city_id` int DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `area_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `starting_date` varchar(20) NOT NULL,
  `customer_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `booking_date` varchar(20) NOT NULL,
  `end_date` varchar(20) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `customer_id` (`customer_id`),
  KEY `vehicle_id` (`vehicle_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (57,'2024-08-16',10,51,'2024-08-16','2024-08-19','unconfirmed'),(58,'2024-08-16',25,61,'2024-08-15','2024-08-16','unconfirmed'),(59,'2024-08-19',26,52,'2024-08-19','2024-08-29','unconfirmed');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`brand_id`),
  KEY `FKc6x7vquyu9gw521jiltguts89` (`type_id`),
  CONSTRAINT `FKc6x7vquyu9gw521jiltguts89` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Honda',1),(2,'Toyota',1),(3,'Ford',1),(4,'Chevrolet',1),(5,'Tata',1),(6,'Suzuki',1),(7,'royal enfield',1),(8,'TVS',1),(9,'Lamborghini',2),(10,'MG',2),(11,'Subaru',2);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `deposit` int NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Two_Wheeler ',3000),(2,'Four_Wheeler ',5000);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `driving_licence_no` varchar(255) NOT NULL,
  `aadhar_number` varchar(100) NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `aadhar_number` (`aadhar_number`),
  UNIQUE KEY `driving_licence_no` (`driving_licence_no`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `login` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (9,'manish ','manish@gmail.com','4566665','3445354','4545445455',215),(10,'atharva kalokhe','atharv@gmail.com','546854968','384475','32484344',216),(11,'karan shrma','karan@gmail.com','43534455','454353454555','4546454666',219),(12,'adsdfdff','shubhamkhedekar455@gmail.com','7498112122','3454354','345545',220),(13,'f','sh@gmail.com','rrt','rtt','retr',221),(14,'r','rr@gmail.com','r','r','r',222),(15,'SHUBHAM KHEDEKAR','shubham4@gmail.com','4354545554','43354545545','434565453456',224),(16,'shubham','shubhamkhedekar2001@gmail.com','9812121212','3435455554','345345345345',225),(17,'eere','wwe@gmail.com','3434543554','4545455455','454545555554',226),(20,'SHUBHAM KHEDEKAR','Vewwere@gmail.com','4343434344','MH15 45465666655','546656567677',271),(21,'tanmay mathur','tanmaymathur@gmail.com','8888888888','MH18 33444545455','452321212232',272),(22,'SHUBHAM KHEDEKAR','shubham@gmail.com','3454454545','MH19 33444545455','456577574345',273),(23,'Sumit','sumit@gmail.com','4345454545','MH19 33444545233','435455454545',274),(24,'Manish Rathod','manishrathod@gmail.com','4534567889','MH23 33444545455','234456786543',275),(25,'Customer','customer@gmail.com','5646767687','MH23 34334443344','456577574356',285),(26,'Asdf','asd@gmail.com','4545445453','MH16 34334444565','456577545355',292);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `active_status` varchar(100) NOT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `password` (`password`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=293 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (212,'shubham@2001','knowit@2001','Active',2),(214,'saurav@101','saurav@101','Active',2),(215,'manish@123','manish@12','Active',3),(216,'atharv','knowit@123','Active',3),(217,'student1','jfdfdf','Active',2),(218,'mahesh','mahesh@123','Active',2),(219,'karan','karan','Active',3),(220,'strtrt','as','Active',3),(221,'d','fd','Active',3),(222,'r','r','Active',3),(224,'shubham','Shubam@123','Active',3),(225,'shubham','Shubham@123','Active',3),(226,'Shubham@1234','Shubham@12344','Active',3),(227,'ffffdf','Shubham@12','Active',2),(228,'shubham@2001','Shubham@1234','Active',2),(229,'shubham@2001','SHubham@2001','Active',2),(230,'shubham@2001','Shubham@002','Active',2),(231,'shubham@2001','Shuba@222','Active',2),(266,'shubham@2001','Shubam@','Active',2),(267,'student1','studenr@122','Active',2),(268,'shubham','Sjdnj@12','Active',2),(269,'shubamm','Shubham@122','Active',3),(270,'atharv12','Shubam@22','Active',3),(271,'karnaaa','Karna@123','Active',3),(272,'tanmay','Tanmay@123','Active',3),(273,'shubham@200233','Shubam@12345','Active',3),(274,'sumit@101','Sumit@101','Active',3),(275,'manish','Manish@123','Active',3),(283,'Amit@123','Amit@123','Active',2),(284,'owner','Owner@123','Active',2),(285,'Customer','Customer@123','Active',3),(292,'Asdfg','Asdfg@123','Active',3);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `model_id` int NOT NULL AUTO_INCREMENT,
  `model_name` varchar(100) NOT NULL,
  `brand_id` int DEFAULT NULL,
  `charges` int NOT NULL,
  `capacity` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `fuel_type` varchar(255) NOT NULL,
  PRIMARY KEY (`model_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `model_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'splender',1,1000,'2','https://imgd.aeplcdn.com/1280x720/n/cw/ec/15109/splendor-plus-right-side-view-2.png?isig=0','petrol'),(2,'FZ',6,1500,'2','https://www.yamaha-motor-india.com/theme/v3/image/fz-fi/color/color-07.png?v=2','petrol'),(3,'classic 350',7,2000,'2','https://www.royalenfield.com/content/dam/royal-enfield/india/motorcycles/classic-350/colors/studio-shots/dual-channel/new-dark-stealth-black/dark-stealth-black_0000.png','petrol'),(4,'Ronin',8,3000,'2','https://imgd.aeplcdn.com/1056x594/n/cw/ec/124775/ronin-right-side-view-7.png?isig=0&q=80','petrol'),(5,'Lamborghini Huracan 580',9,8000,'4','https://stimg.cardekho.com/images/carexteriorimages/630x420/Lamborghini/Huracan-EVO/10643/1690010999692/front-left-side-47.jpg','petrol'),(6,'MG Hector',10,4000,'4','https://cdni.autocarindia.com/ExtraImages/20230516020445_Hector.jpg','petrol'),(7,'Subaru WRX GT Sedan',11,4000,'4','https://cdn.motor1.com/images/mgl/G3WRBx/s3/2024-subaru-wrx-tr-first-drive-review.jpg','petrol');
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `owner_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`owner_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `owner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `login` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (5,'Shubham Khedekar','shubhamkhedekar2001@gmail.com','7498112122','Gokhalenagar,Pune 411016',212),(6,'Saurav Dutal','sauravdutal123@gmail.com','9766664256','Gokhalenagar, Pune, 411016',214),(7,'fdff','fdf@gmail.com','43535','pune',217),(8,'mahesh kale','mahesh@gmail.com','4566665ewr','Shevgaon',218),(9,'fdfdgf','dfd@gmail.com','4355455454','pune',227),(10,'fdd','w@gmail.com','4435445454','nagar',228),(11,'dfff','shubhamkhedekar455@gmail.com','4545545545','pune',229),(12,'SHUBHAM KHEDEKAR','shubhamkhedekar455@gmail.com','7498112122','Pune',230),(13,'SHUBHAM KHEDEKAR','shubhamkhedekar2001@gmail.com','7498112122','Pune',231),(14,'sdds','sh@gmail.com','7498112122','pune',266),(15,'weewwer','shubhamkhedekar455@gmail.com','4454554554','pune',267),(16,'SHUBHAM KHEDEKAR','shubhamkhedekar2001@gmail.com','3424344344','Pune',268),(18,'Amit','amit@gmail.com','4566665565','Pune',283),(19,'Onwer','owner@gmail.com','7584389790','pune',284);
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `booking_id` int DEFAULT NULL,
  `payment_date` varchar(20) NOT NULL,
  `amount` int NOT NULL,
  `payment_method` varchar(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `booking_id` (`booking_id`),
  CONSTRAINT `booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'owner'),(3,'customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Gear'),(2,'Non-Gear');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `buying_year` int NOT NULL,
  `registration_number` int NOT NULL,
  `model_id` int DEFAULT NULL,
  `owner_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE KEY `registration_number` (`registration_number`),
  KEY `model_id` (`model_id`),
  KEY `owner_id` (`owner_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `vehicle_ibfk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vehicle_ibfk_model` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vehicle_ibfk_owner` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (51,2023,22,7,5,2,'booked'),(52,2023,33,6,5,2,'booked'),(60,2023,222,1,5,1,'open'),(61,2023,900,3,19,1,'booked');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-19 10:25:23
