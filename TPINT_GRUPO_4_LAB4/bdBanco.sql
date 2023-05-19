CREATE DATABASE  IF NOT EXISTS `bdbanco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdbanco`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bdbanco
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `nombre` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','12345');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `Dni` varchar(10) NOT NULL,
  `Cuil_c` varchar(15) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Sexo` varchar(15) NOT NULL,
  `Nacionalidad` varchar(25) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Direccion` varchar(30) NOT NULL,
  `Localidad` varchar(30) NOT NULL,
  `Provincia` varchar(30) NOT NULL,
  `Mail` varchar(30) NOT NULL,
  `Telefono` varchar(30) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('35456741','20-35456741','Lucas','Galvan','Masculino','Argentina','1995-01-29','Cazon 123','Tigre','Buenaso Aires','lg@fakemail.com','1152647896','lgalvan','987456',1),('40456123','40456123','Maria','Perez','Femenino','Argentina','1985-11-21','Avellaneda 321','San Isidro','Buenaso Aires','mp@fakemail.com','1185964125','mPerez','987456',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentas` (
  `NroCuenta` varchar(10) NOT NULL,
  `Dni_C` varchar(10) NOT NULL,
  `FechaCreacion` date NOT NULL,
  `TipoCuenta` varchar(45) NOT NULL,
  `CBU` varchar(20) NOT NULL,
  `Saldo` decimal(10,0) NOT NULL,
    `estadoCuenta` tinyint(1) NOT NULL,
  PRIMARY KEY (`NroCuenta`),
  KEY `Dni_C` (`Dni_C`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`Dni_C`) REFERENCES `clientes` (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuotas`
--

DROP TABLE IF EXISTS `cuotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuotas` (
  `NroCuota_C` varchar(15) NOT NULL,
  `ImporteCuota` decimal(10,0) NOT NULL,
  `EstadoCuota` tinyint(1) NOT NULL,
  PRIMARY KEY (`NroCuota_C`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotas`
--

LOCK TABLES `cuotas` WRITE;
/*!40000 ALTER TABLE `cuotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos` (
  `Nro_Movimiento` varchar(10) NOT NULL,
  `NroCuenta_M` varchar(10) NOT NULL,
  `FechaMovimiento` date NOT NULL,
  `DetalleMovimiento` varchar(20) NOT NULL,
  `TipoMovimiento` varchar(20) NOT NULL,
  `ImporteMovimiento` decimal(10,0) NOT NULL,
    `estadoMovimiento` tinyint(1) NOT NULL,
  PRIMARY KEY (`Nro_Movimiento`),
  KEY `NroCuenta_M` (`NroCuenta_M`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`NroCuenta_M`) REFERENCES `cuentas` (`NroCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidoprestamos`
--

DROP TABLE IF EXISTS `pedidoprestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidoprestamos` (
  `NroPedido` varchar(20) NOT NULL,
  `NroCuenta` varchar(10) NOT NULL,
  `ImportePedido` decimal(10,0) NOT NULL,
  `CantCuotasPedido` int(11) NOT NULL,
  `EstadoPedido` tinyint(1) NOT NULL,
  PRIMARY KEY (`NroPedido`),
  KEY `NroCuenta` (`NroCuenta`),
  CONSTRAINT `pedidoprestamos_ibfk_1` FOREIGN KEY (`NroCuenta`) REFERENCES `cuentas` (`NroCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidoprestamos`
--

LOCK TABLES `pedidoprestamos` WRITE;
/*!40000 ALTER TABLE `pedidoprestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidoprestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamos` (
  `NroPrestamo` varchar(10) NOT NULL,
  `NroCuenta_P` varchar(10) NOT NULL,
  `FechaVencimiento` date NOT NULL,
  `ImporteaPagarInt` decimal(10,0) NOT NULL,
  `ImporteSolicitado` decimal(10,0) NOT NULL,
  `PlazoDePago` int(11) NOT NULL,
  `MontoAPagarPorMes` decimal(10,0) NOT NULL,
  `Cuotas` int(11) NOT NULL,
  `EstadoPrestamo` tinyint(1) NOT NULL,
  PRIMARY KEY (`NroPrestamo`),
  KEY `NroCuenta_P` (`NroCuenta_P`),
  CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`NroCuenta_P`) REFERENCES `cuentas` (`NroCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamosxcuota`
--

DROP TABLE IF EXISTS `prestamosxcuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamosxcuota` (
  `NroPrestamo` varchar(20) NOT NULL,
  `NroCuota` varchar(15) NOT NULL,
  PRIMARY KEY (`NroPrestamo`),
  KEY `NroCuota` (`NroCuota`),
  CONSTRAINT `prestamosxcuota_ibfk_1` FOREIGN KEY (`NroCuota`) REFERENCES `cuotas` (`NroCuota_C`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamosxcuota`
--

LOCK TABLES `prestamosxcuota` WRITE;
/*!40000 ALTER TABLE `prestamosxcuota` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamosxcuota` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `pro_id` int NOT NULL,
  `pro_nombre` varchar(35) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (001,'Buenos aires');


INSERT INTO provincias (pro_id,pro_nombre)
VALUES (002,'Catamarca');


INSERT INTO provincias (pro_id,pro_nombre)
VALUES (003,'Chaco');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (004,'Chubut');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (005,'Córdoba');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (006,'Corrientes');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (007,'Entre Ríos');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (008,'Formosa');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (009,'Jujuy');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (010,'La Pampa');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (011,'La Rioja');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (012,'Mendoza');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (013,'Misiones');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (014,'Neuquén');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (015,'Río Negro');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (016,'Salta');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (017,'San Juan');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (018,'Santa Cruz');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (019,'Santa Fe');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (020,'Santiago del Estero');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (021,'Tierra del Fuego');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (022,'Tucumán');

INSERT INTO provincias (pro_id,pro_nombre)
VALUES (023,'San Luis');



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 13:02:12
