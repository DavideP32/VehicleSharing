-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vehiclesharing
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `prenotazione_id` int NOT NULL AUTO_INCREMENT,
  `id_utente` bigint NOT NULL,
  `id_veicolo` bigint NOT NULL,
  `data_prenotazione` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`prenotazione_id`),
  KEY `id_utente` (`id_utente`),
  KEY `id_veicolo` (`id_veicolo`),
  CONSTRAINT `prenotazioni_ibfk_1` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`utente_id`) ON DELETE CASCADE,
  CONSTRAINT `prenotazioni_ibfk_2` FOREIGN KEY (`id_veicolo`) REFERENCES `veicolo` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `utente_id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) DEFAULT NULL,
  `cognome` varchar(75) DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `ruolo` enum('ADMIN','UTENTE') NOT NULL,
  PRIMARY KEY (`utente_id`),
  UNIQUE KEY `email` (`email`),
  KEY `k_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Carlo','Verdi','2001-03-19','utente@email.com','utente','UTENTE'),(2,'Paolo','Rossi','1994-06-07','admin@email.com','admin','ADMIN'),(5,'Francesco','Totti','2011-11-11','ftotti@email.com','ciao','UTENTE'),(9,'ciao','castrese','1900-12-12','ciaocas@email.it','cas','UTENTE'),(19,'Castrese','caiazzo','1990-05-13','numerone@email.com','numerone90!','UTENTE'),(20,'Paola','Votano','2011-11-11','pv@email.com','paola','UTENTE');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veicolo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria` enum('AUTO','SCOOTER','MONOPATTINO') NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `alimentazione` enum('ELETTRICO','DIESEL','BENZINA','GPL','IBRIDA') NOT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `coordinateGPS` varchar(255) DEFAULT NULL,
  `disponibilita_noleggio` tinyint(1) NOT NULL,
  `immagine_veicolo` blob,
  `CreatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES (1,'AUTO','Fiat Punto','DIESEL','ciao','12345',1,_binary '010100101','2025-01-05 11:00:06'),(3,'AUTO','Fiat Punto','GPL','Via Roma 43, Milano','6.723418, -178.054580',0,_binary '0x1095EDCD41A2C62FA673','2025-01-06 20:41:39'),(4,'AUTO','Fiat Panda','IBRIDA','Via Milano 44, Torino','-74.589143, 122.757932',0,_binary '0x3B3BA54BDA9089458070','2025-01-06 20:41:39'),(5,'SCOOTER','Piaggio Vespa','ELETTRICO','Via Napoli 19, Roma','58.763807, -77.477394',1,_binary '0x6FDDEBF357178F2C8D5E','2025-01-06 20:41:39'),(6,'MONOPATTINO','Xiaomi Mi Scooter','DIESEL','Via Firenze 14, Bologna','-33.471974, -130.054558',1,_binary '0x9A227E7A4B8DDBA2661A','2025-01-06 20:41:39'),(7,'SCOOTER','Honda SH 125','BENZINA','Via Venezia 29, Palermo','66.614070, -11.998199',0,_binary '0x0E537DDC107D70EA9E9E','2025-01-06 20:41:39'),(8,'SCOOTER','Kymco Agility','GPL','Via Verona 9, Genova','78.225604, -101.360371',1,_binary '0xDFAAF76234F8F1D75981','2025-01-06 20:41:39'),(9,'SCOOTER','Yamaha NMAX','BENZINA','Via Bari 40, Catania','65.824144, -7.287507',0,_binary '0x20115C16A6E3EFE6FD09','2025-01-06 20:41:39'),(10,'MONOPATTINO','Ninebot Segway','GPL','Via Torino 43, Venezia','-51.399554, 10.348207',1,_binary '0xEF97CA11CB6B5C797730','2025-01-06 20:41:39'),(11,'SCOOTER','Aprilia SR GT','BENZINA','Via Lecce 16, Bari','-9.901796, 57.769463',1,_binary '0xAC20644C33D39B3D39C4','2025-01-06 20:41:39'),(12,'SCOOTER','Suzuki Burgman','IBRIDA','Via Ravenna 33, Ancona','88.727907, 37.664109',0,_binary '0x4A6FDAB3488201D065C2','2025-01-06 20:41:39'),(13,'AUTO','Audi A3','BENZINA','Via Padova 50, Vicenza','41.123456, -12.654321',1,_binary '0xA1B2C3D4E5F6A7B8C9D0','2025-01-06 20:41:39'),(14,'AUTO','Volkswagen Golf','DIESEL','Via Modena 27, Ferrara','50.123654, -8.654321',1,_binary '0xB2C3D4E5F6A7B8C9D0A1','2025-01-06 20:41:39'),(15,'MONOPATTINO','Hoverboard Pro','ELETTRICO','Via Pisa 8, Lucca','-20.654123, 80.987654',0,_binary '0xC3D4E5F6A7B8C9D0A1B2','2025-01-06 20:41:39'),(16,'AUTO','Toyota Corolla','IBRIDA','Via Pescara 12, Pescara','-10.987321, 60.123456',1,_binary '0xD4E5F6A7B8C9D0A1B2C3','2025-01-06 20:41:39'),(17,'AUTO','BMW Serie 3','BENZINA','Via Reggio 34, Reggio Emilia','-30.321987, 45.654321',0,_binary '0xE5F6A7B8C9D0A1B2C3D4','2025-01-06 20:41:39'),(18,'SCOOTER','Sym Symphony','DIESEL','Via Trapani 29, Trapani','75.987321, -9.456123',1,_binary '0xF6A7B8C9D0A1B2C3D4E5','2025-01-06 20:41:39'),(19,'AUTO','Ford Focus','GPL','Via Varese 55, Varese','-55.654123, 23.123987',0,_binary '0x6A7B8C9D0A1B2C3D4E5F','2025-01-06 20:41:39'),(20,'AUTO','Renault Clio','ELETTRICO','Via Benevento 16, Benevento','12.789654, 35.654123',0,_binary '0x7B8C9D0A1B2C3D4E5F6A','2025-01-06 20:41:39'),(21,'MONOPATTINO','Bird One','ELETTRICO','Via Sassari 30, Sassari','48.321456, -7.987654',1,_binary '0x8C9D0A1B2C3D4E5F6A7B','2025-01-06 20:41:39'),(22,'MONOPATTINO','Lime Gen 4','DIESEL','Via Grosseto 21, Grosseto','-12.321987, 67.123654',0,_binary '0x9D0A1B2C3D4E5F6A7B8C','2025-01-06 20:41:39'),(23,'AUTO','Mercedes Classe A','IBRIDA','Via Trento 7, Trento','41.987654, -8.123456',1,_binary '0x1A2B3C4D5E6F7A8B9C0D','2025-01-06 21:36:13'),(24,'AUTO','Opel Astra','DIESEL','Via Trieste 19, Trieste','12.456789, 45.987123',1,_binary '0x2B3C4D5E6F7A8B9C0D1A','2025-01-06 21:36:13'),(25,'SCOOTER','Benelli TNT 125','BENZINA','Via Udine 35, Udine','-22.987321, 77.654123',0,_binary '0x3C4D5E6F7A8B9C0D1A2B','2025-01-06 21:36:13'),(26,'MONOPATTINO','Segway ES4','ELETTRICO','Via Como 45, Como','15.654123, -12.987654',1,_binary '0x4D5E6F7A8B9C0D1A2B3C','2025-01-06 21:36:13'),(27,'AUTO','Alfa Romeo Giulietta','GPL','Via Pesaro 11, Pesaro','-10.321654, 56.123987',1,_binary '0x5E6F7A8B9C0D1A2B3C4D','2025-01-06 21:36:13'),(28,'AUTO','Peugeot 208','BENZINA','Via Siena 25, Siena','30.987321, -10.654123',0,_binary '0x6F7A8B9C0D1A2B3C4D5E','2025-01-06 21:36:13'),(29,'SCOOTER','Vespa Primavera','ELETTRICO','Via Parma 31, Parma','-25.654987, 67.123654',1,_binary '0x7A8B9C0D1A2B3C4D5E6F','2025-01-06 21:36:13'),(30,'MONOPATTINO','Xiaomi Pro 2','ELETTRICO','Via Taranto 13, Taranto','42.987654, 14.123456',0,_binary '0x8B9C0D1A2B3C4D5E6F7A','2025-01-06 21:36:13'),(31,'AUTO','Chevrolet Spark','IBRIDA','Via Novara 26, Novara','-11.321456, 76.987321',1,_binary '0x9C0D1A2B3C4D5E6F7A8B','2025-01-06 21:36:13'),(32,'AUTO','Citroen C3','DIESEL','Via Lecce 38, Lecce','56.123789, -15.987654',0,_binary '0x0D1A2B3C4D5E6F7A8B9C','2025-01-06 21:36:13'),(33,'AUTO','Mazda CX-3','BENZINA','Via Messina 10, Messina','-33.123456, 23.654789',1,_binary '0x1B2C3D4E5F6A7B8C9D0A','2025-01-06 21:36:13'),(34,'AUTO','Ford Fiesta','ELETTRICO','Via Palermo 8, Palermo','18.654987, -45.123654',1,_binary '0x2C3D4E5F6A7B8C9D0A1B','2025-01-06 21:36:13'),(35,'AUTO','Honda Civic','GPL','Via Siracusa 22, Siracusa','-12.789654, 58.321987',0,_binary '0x3D4E5F6A7B8C9D0A1B2C','2025-01-06 21:36:13'),(36,'MONOPATTINO','Unagi Model One','ELETTRICO','Via Arezzo 14, Arezzo','31.654123, -9.987654',1,_binary '0x4E5F6A7B8C9D0A1B2C3D','2025-01-06 21:36:13'),(37,'MONOPATTINO','Razor E300','ELETTRICO','Via Perugia 29, Perugia','-8.321456, 70.987123',0,_binary '0x5F6A7B8C9D0A1B2C3D4E','2025-01-06 21:36:13'),(38,'AUTO','Volvo XC40','IBRIDA','Via Bolzano 33, Bolzano','50.123654, -13.654321',1,_binary '0x6A7B8C9D0A1B2C3D4E5F','2025-01-06 21:36:13'),(39,'AUTO','Tesla Model 3','ELETTRICO','Via Piacenza 16, Piacenza','44.987123, -14.123654',0,_binary '0x7B8C9D0A1B2C3D4E5F6A','2025-01-06 21:36:13'),(40,'AUTO','Nissan Qashqai','BENZINA','Via Salerno 18, Salerno','37.654987, -20.321456',1,_binary '0x8C9D0A1B2C3D4E5F6A7B','2025-01-06 21:36:13'),(41,'AUTO','Kia Sportage','GPL','Via Cagliari 21, Cagliari','29.123654, -18.654321',1,_binary '0x9D0A1B2C3D4E5F6A7B8C','2025-01-06 21:36:13'),(42,'AUTO','Jeep Renegade','DIESEL','Via Livorno 9, Livorno','-45.654987, 40.123789',0,_binary '0x0A1B2C3D4E5F6A7B8C9D','2025-01-06 21:36:13');
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-07 10:59:43
