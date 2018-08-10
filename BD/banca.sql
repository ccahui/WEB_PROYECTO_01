-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-08-2018 a las 08:37:55
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banca`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consulta` (IN `nombre` VARCHAR(50))  READS SQL DATA
SELECT * from cliente where cliente.NOMBRE=nombre$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(8) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `EMAIL` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `NOMBRE`, `EMAIL`) VALUES
('12345678', 'Kristian Ccahui Huaman', ''),
('46611630', 'kari ninacansayaa diego', 'diegoassadas@sds'),
('72295432', 'Jose Paolo Gerrero', 'paolo9@hotmail.com'),
('72295433', 'Jose Paolo Gerrero', 'paolo9@hotmail.com'),
('72295438', 'ads', ''),
('72606259', 'flores Salamanca', 'jonami.97.fs@gmail.com'),
('73032979', 'Garcia Rengifo Brayan', 'bfhab@gmail.com'),
('78490501', 'kari ninacansayaa diego', 'diegoassadas@sds');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `clientexcuenta`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `clientexcuenta` (
`DNI` varchar(8)
,`NOMBRE` varchar(50)
,`EMAIL` varchar(40)
,`NUM_CUENTA` int(8)
,`SALDO` int(11)
,`PASSWORD` varchar(16)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `NUM_CUENTA` int(8) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `SALDO` int(11) NOT NULL DEFAULT '0',
  `PASSWORD` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`NUM_CUENTA`, `DNI`, `SALDO`, `PASSWORD`) VALUES
(20170014, '73032979', 0, 'natsu123'),
(20170015, '46611630', 3715, '1234'),
(20170016, '46611630', 2000, '78545'),
(20170017, '46611630', 0, '4');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `cuentaxtransaccion`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `cuentaxtransaccion` (
`NUM_CUENTA` int(8)
,`dni` varchar(8)
,`OPERACION` varchar(10)
,`MONTO` int(11)
,`FECHA` varchar(80)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE `prueba` (
  `Atributo01` varchar(50) NOT NULL,
  `Valor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prueba`
--

INSERT INTO `prueba` (`Atributo01`, `Valor`) VALUES
('1', '8'),
('18', '80'),
('2', '8'),
('20', '18'),
('25', '18'),
('26', '18'),
('28', '18'),
('3', '8'),
('387', '898'),
('4', '8'),
('5', '8'),
('6', '8');

--
-- Disparadores `prueba`
--
DELIMITER $$
CREATE TRIGGER `aa` AFTER INSERT ON `prueba` FOR EACH ROW INSERT INTO `prueba1` (`campo`, `campo2`) VALUES (new.Atributo01,new.Valor)
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bb` BEFORE INSERT ON `prueba` FOR EACH ROW UPDATE prueba1 set campo2=new.Valor where  new.valor=prueba1.campo
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba1`
--

CREATE TABLE `prueba1` (
  `campo` varchar(50) NOT NULL,
  `campo2` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prueba1`
--

INSERT INTO `prueba1` (`campo`, `campo2`) VALUES
('1', '2018-02-01'),
('18', '0000-00-00'),
('2', '0000-00-00'),
('20', '0000-00-00'),
('25', '0000-00-00'),
('26', '0000-00-00'),
('28', '0000-00-00'),
('3', '0000-00-00'),
('387', '0000-00-00'),
('4', '0000-00-00'),
('5', '0000-00-00'),
('6', '0000-00-00');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `pruebaproyeccion`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `pruebaproyeccion` (
`Valor` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `NUM_TRAM` int(10) NOT NULL,
  `NUM_CUENTA` int(8) NOT NULL,
  `OPERACION` varchar(10) NOT NULL,
  `MONTO` int(11) NOT NULL,
  `FECHA` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`NUM_TRAM`, `NUM_CUENTA`, `OPERACION`, `MONTO`, `FECHA`) VALUES
(75, 20170015, 'RETIRO', 500, '10-10-17  01:11:26 am'),
(76, 20170015, 'DEPOSITO', 1000, '10-10-17  01:11:33 am'),
(77, 20170015, 'RETIRO', 3000, '10-10-17  01:11:44 am'),
(84, 20170014, '', 0, ''),
(86, 20170016, '', 29999, ''),
(87, 20170015, 'DEPOSITO', 800, '27/02/2018'),
(88, 20170015, 'DEPOSITO', 800, '27/02/2018'),
(89, 20170015, 'da', 0, ''),
(90, 20170015, 'RETIRO', 200, 'a'),
(92, 20170015, '400', 300, NULL),
(93, 20170015, 'DEPOSITO', 300, NULL),
(94, 20170015, 'DEPOSITO', 300, NULL),
(95, 20170015, 'DEPOSITO', 300, NULL),
(96, 20170015, 'RETIRO', 500, 'Tue Feb 27 22:09:28 COT 2018'),
(97, 20170015, 'RETIRO', 500, 'Tue Feb 27 22:10:08 COT 2018'),
(98, 20170015, 'RETIRO', 500, 'Wed Feb 28 10:52:37 COT 2018'),
(99, 20170015, 'Deposito', 500, 'Wed Feb 28 11:25:55 COT 2018'),
(100, 20170015, 'Retiro', 800, 'Wed Feb 28 11:26:16 COT 2018'),
(101, 20170015, 'DEPOSITO', 222, 'Wed Feb 28 11:28:07 COT 2018'),
(102, 20170015, 'DEPOSITO', 18, 'Wed Feb 28 11:29:15 COT 2018'),
(103, 20170015, 'DEPOSITO', 18, 'Wed Feb 28 11:33:20 COT 2018'),
(104, 20170015, 'RETIRO', 25, 'Wed Feb 28 11:33:33 COT 2018'),
(105, 20170015, 'RETIRO', 25, 'Wed Feb 28 11:34:02 COT 2018'),
(106, 20170015, 'DEPOSITO', 15, 'Wed Feb 28 11:35:11 COT 2018'),
(107, 20170015, 'DEPOSITO', 500, 'Wed Feb 28 11:35:40 COT 2018'),
(108, 20170015, 'RETIRO', 5, 'Wed Feb 28 11:39:23 COT 2018'),
(109, 20170015, 'DEPOSITO', 15, 'Wed Feb 28 11:43:28 COT 2018'),
(110, 20170015, 'RETIRO', 18, 'Wed Feb 28 11:43:37 COT 2018');

-- --------------------------------------------------------

--
-- Estructura para la vista `clientexcuenta`
--
DROP TABLE IF EXISTS `clientexcuenta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `clientexcuenta`  AS  select `cliente`.`DNI` AS `DNI`,`cliente`.`NOMBRE` AS `NOMBRE`,`cliente`.`EMAIL` AS `EMAIL`,`cuenta`.`NUM_CUENTA` AS `NUM_CUENTA`,`cuenta`.`SALDO` AS `SALDO`,`cuenta`.`PASSWORD` AS `PASSWORD` from (`cliente` join `cuenta` on((`cliente`.`DNI` = `cuenta`.`DNI`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `cuentaxtransaccion`
--
DROP TABLE IF EXISTS `cuentaxtransaccion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cuentaxtransaccion`  AS  select `transaccion`.`NUM_CUENTA` AS `NUM_CUENTA`,`cuenta`.`DNI` AS `dni`,`transaccion`.`OPERACION` AS `OPERACION`,`transaccion`.`MONTO` AS `MONTO`,`transaccion`.`FECHA` AS `FECHA` from (`transaccion` join `cuenta` on((`transaccion`.`NUM_CUENTA` = `cuenta`.`NUM_CUENTA`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `pruebaproyeccion`
--
DROP TABLE IF EXISTS `pruebaproyeccion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pruebaproyeccion`  AS  select `prueba`.`Valor` AS `Valor` from `prueba` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`) USING BTREE;

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`NUM_CUENTA`),
  ADD UNIQUE KEY `NUM_CUENTA` (`NUM_CUENTA`),
  ADD KEY `NUM_CUENTA_2` (`NUM_CUENTA`),
  ADD KEY `DNI` (`DNI`) USING BTREE;

--
-- Indices de la tabla `prueba`
--
ALTER TABLE `prueba`
  ADD PRIMARY KEY (`Atributo01`);

--
-- Indices de la tabla `prueba1`
--
ALTER TABLE `prueba1`
  ADD PRIMARY KEY (`campo`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`NUM_TRAM`),
  ADD KEY `NUM_CUENTA` (`NUM_CUENTA`),
  ADD KEY `NUM_CUENTA_2` (`NUM_CUENTA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `NUM_CUENTA` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20170018;
--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `NUM_TRAM` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `cliente` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `transaccion_ibfk_1` FOREIGN KEY (`NUM_CUENTA`) REFERENCES `cuenta` (`NUM_CUENTA`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
