/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.5.8 : Database - spring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring`;

/*Table structure for table `korisnici` */

DROP TABLE IF EXISTS `korisnici`;

CREATE TABLE `korisnici` (
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `korisnici` */

insert  into `korisnici`(`id`,`ime`,`prezime`,`username`,`password`,`datum_unosa`,`datum_promjene`,`status`,`ip_adresa`) values 
(1,'','','admin','admin123!','2017-09-20 21:45:34','2017-09-20 21:45:50',1,NULL),
(2,'pero','peric','kor1','kor123','2017-09-20 21:47:32','2017-09-20 21:47:38',1,NULL),
(3,'jozo','bozo','kor2','kor123','0001-01-01 00:00:00','0001-01-01 00:00:00',1,NULL),
(4,'','','kor3','kor123','0001-01-01 00:00:00','0001-01-01 00:00:00',0,NULL),
(5,NULL,NULL,NULL,NULL,'0001-01-01 00:00:00','0001-01-01 00:00:00',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
