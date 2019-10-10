-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-10-2019 a las 05:41:20
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gasolineria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_venta`
--

DROP TABLE IF EXISTS `datos_venta`;
CREATE TABLE IF NOT EXISTS `datos_venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardNumber` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gasStation` varchar(100) DEFAULT NULL,
  `calleStation` varchar(100) DEFAULT NULL,
  `dato2` varchar(100) NOT NULL,
  `dato3` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos_venta`
--

INSERT INTO `datos_venta` (`id`, `cardNumber`, `email`, `gasStation`, `calleStation`, `dato2`, `dato3`) VALUES
(1, '4242424242424242', 'info@srpago.com', '587fbd68edfe99480a072f15', 'Ricardo Flores Magon No. 950  Col. Huentitan el Alto  Guadalajara', 'COMBU-EXPRESS  S.A. DE C.V.', 'CEX9809213U5'),
(2, '4242424242424242', 'info@srpago.com', '587fbd68edfe99480a072f15', 'Ricardo Flores Magon No. 950  Col. Huentitan el Alto  Guadalajara', 'COMBU-EXPRESS  S.A. DE C.V.', 'CEX9809213U5');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
