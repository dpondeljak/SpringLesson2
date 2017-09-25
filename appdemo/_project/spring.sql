-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.8 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table spring.korisnici
DROP TABLE IF EXISTS `korisnici`;
CREATE TABLE IF NOT EXISTS `korisnici` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ime` varchar(40) DEFAULT NULL,
  `prezime` varchar(40) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `datum_unosa` datetime DEFAULT '0001-01-01 00:00:00',
  `datum_promjene` datetime DEFAULT '0001-01-01 00:00:00',
  `status` int(1) DEFAULT '0',
  `ip_adresa` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table spring.korisnici: ~7 rows (approximately)
/*!40000 ALTER TABLE `korisnici` DISABLE KEYS */;
INSERT INTO `korisnici` (`id`, `ime`, `prezime`, `username`, `password`, `datum_unosa`, `datum_promjene`, `status`, `ip_adresa`) VALUES
	(1, '', '', 'admin', 'admin123!', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45'),
	(2, 'Pero', 'Peric', 'kor1', 'kor123', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45'),
	(3, 'Jozo', 'Bozo', 'kor2', 'kor123', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45'),
	(4, 'Korisnik', 'Korisni', 'kor3', 'kor123', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 0, '10.0.45.45'),
	(6, 'James', 'Bond', 'kor4', 'kor123', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45'),
	(7, 'Pero', 'Dragić', 'kor6', 'kor123!', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45'),
	(8, 'Drago', 'Perić', 'kor5', 'kor123', '2017-09-21 15:47:20', '2017-09-21 15:47:20', 1, '10.0.45.45');
/*!40000 ALTER TABLE `korisnici` ENABLE KEYS */;

-- Dumping structure for table spring.porta
DROP TABLE IF EXISTS `porta`;
CREATE TABLE IF NOT EXISTS `porta` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `korisnicko_ime` varchar(40) NOT NULL DEFAULT '0',
  `lozinka` varchar(32) NOT NULL DEFAULT '0',
  `zakljucan` int(1) NOT NULL DEFAULT '0',
  `prijavljen` int(1) NOT NULL DEFAULT '0',
  `zadnji_pristup` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring.porta: ~0 rows (approximately)
/*!40000 ALTER TABLE `porta` DISABLE KEYS */;
/*!40000 ALTER TABLE `porta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
