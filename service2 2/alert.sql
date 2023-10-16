/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26 : Database - alert
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`alert` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `alert`;

/*Table structure for table `alert` */

DROP TABLE IF EXISTS `alert`;

CREATE TABLE `alert` (
  `alert_id` varchar(32) NOT NULL,
  `service_id` varchar(32) DEFAULT NULL,
  `service_name` varchar(32) DEFAULT NULL,
  `model` varchar(32) DEFAULT NULL,
  `alert_type` varchar(32) DEFAULT NULL,
  `alert_ts` int(10) DEFAULT NULL,
  `severity` varchar(32) DEFAULT NULL,
  `team_slack` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`alert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `alert` */

LOCK TABLES `alert` WRITE;

insert  into `alert`(`alert_id`,`service_id`,`service_name`,`model`,`alert_type`,`alert_ts`,`severity`,`team_slack`) values ('1',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('11','11','11','11','11',1111111111,'11','11'),('12','11','11','11','11',1111111111,'11','11'),('2',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('4',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('44','11','11','11','11',1111111111,'11','11'),('5',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('55','11','11','11','11',1111111111,'11','11'),('56','11','11','11','11',1111111111,'11','11'),('6',NULL,NULL,NULL,NULL,0,NULL,NULL),('7',NULL,NULL,NULL,NULL,0,NULL,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
