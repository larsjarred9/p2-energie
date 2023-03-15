-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Gegenereerd op: 15 mrt 2023 om 16:16
-- Serverversie: 10.1.48-MariaDB-0ubuntu0.18.04.1
-- PHP-versie: 7.2.24-0ubuntu0.18.04.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `energy`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `deposit` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `customeruse`
--

CREATE TABLE `customeruse` (
  `id` int(32) NOT NULL,
  `customer` int(32) NOT NULL,
  `energyUsage` double NOT NULL,
  `gasUsage` double NOT NULL,
  `week` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `energy`
--

CREATE TABLE `energy` (
  `id` int(32) NOT NULL,
  `customer` int(32) NOT NULL,
  `energyUsage` double NOT NULL,
  `week` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `gas`
--

CREATE TABLE `gas` (
  `id` int(32) NOT NULL,
  `customer` int(32) DEFAULT NULL,
  `week` int(2) NOT NULL,
  `gasUsage` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `customeruse`
--
ALTER TABLE `customeruse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer` (`customer`);

--
-- Indexen voor tabel `energy`
--
ALTER TABLE `energy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer` (`customer`);

--
-- Indexen voor tabel `gas`
--
ALTER TABLE `gas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer` (`customer`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83235;
--
-- AUTO_INCREMENT voor een tabel `customeruse`
--
ALTER TABLE `customeruse`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `energy`
--
ALTER TABLE `energy`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT voor een tabel `gas`
--
ALTER TABLE `gas`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `customeruse`
--
ALTER TABLE `customeruse`
  ADD CONSTRAINT `customeruse_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `energy`
--
ALTER TABLE `energy`
  ADD CONSTRAINT `energy_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `gas`
--
ALTER TABLE `gas`
  ADD CONSTRAINT `gas_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
