/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.21-log : Database - ssmproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssmproject` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `ssmproject`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `phoneNum` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `member` */

insert  into `member`(`id`,`name`,`nickname`,`phoneNum`,`email`) values (1,'3333','2','88888','3306');

/*Table structure for table `order_traveller` */

DROP TABLE IF EXISTS `order_traveller`;

CREATE TABLE `order_traveller` (
  `orderId` int(11) DEFAULT NULL,
  `travellerId` int(11) DEFAULT NULL,
  KEY `orderId` (`orderId`),
  KEY `travellerId` (`travellerId`),
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `order_traveller` */

insert  into `order_traveller`(`orderId`,`travellerId`) values (1,1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `orderNum` varchar(500) NOT NULL,
  `orderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `peopleCount` int(11) DEFAULT NULL,
  `orderDesc` varchar(500) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`productId`),
  KEY `memberid` (`memberid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`memberid`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `orders` */

insert  into `orders`(`id`,`orderNum`,`orderTime`,`peopleCount`,`orderDesc`,`payType`,`orderStatus`,`productId`,`memberid`) values (1,'1','2020-02-17 20:00:13',2,'1',1,1,1,1);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `permission` */

insert  into `permission`(`id`,`permissionName`,`url`) values (1,'ADMIN','www.itcase.com');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productNum` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `DepartureTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `productPrice` double(4,2) DEFAULT NULL,
  `productDesc` varchar(500) DEFAULT NULL,
  `productStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNum` (`productNum`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values (1,'itcast-002','北京三日游','北京','2020-02-16 20:48:05',24.23,'不错的旅行',1),(2,'itcast-003','上海五日游','上海','2020-02-16 20:51:26',32.56,'魔都我来了',0),(3,'itcast-001','北京三日游','北京','2020-02-16 20:52:17',48.50,'不错的旅行',1),(4,'5','日本一日游','广州','2020-02-17 12:14:00',63.25,'',1),(5,'8','泰国游','广州','2020-02-17 12:09:00',82.50,'暂无',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`,`roleDesc`) values (1,'ADMIN','USER');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `roleId` int(11) DEFAULT NULL,
  `permissionId` int(11) DEFAULT NULL,
  KEY `roleId` (`roleId`),
  KEY `permissionId` (`permissionId`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `role_permission` */

insert  into `role_permission`(`roleId`,`permissionId`) values (1,1);

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(100) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `executionTime` double DEFAULT NULL,
  `method` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=gbk;

/*Data for the table `syslog` */

insert  into `syslog`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values (1,'2020-02-19 12:58:14','张三',NULL,'/user[Ljava.lang.String;@21171cd0',2,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(2,'2020-02-19 12:59:17','张三',NULL,'/product[Ljava.lang.String;@60acc5e3',18,'com.ping.Controller.ProductControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.ProductController.findAll()'),(3,'2020-02-19 13:02:32','张三',NULL,'/orders[Ljava.lang.String;@57ced06a',0,'com.ping.Controller.OrderControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.ProductController.findAll()'),(4,'2020-02-19 13:04:34','张三',NULL,'/orders[Ljava.lang.String;@77d6c653',132,'com.ping.Controller.OrderControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.OrderController.findAll(java.lang.Integer,java.lang.Integer)'),(5,'2020-02-19 13:09:44','张三',NULL,'/orders[Ljava.lang.String;@456bebb3',112,'com.ping.Controller.OrderControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.OrderController.findAll(java.lang.Integer,java.lang.Integer)'),(6,'2020-02-19 13:16:27','张三',NULL,'/sysLog[Ljava.lang.String;@58e62f33',30,'com.ping.Controller.SysLogControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.SysLogController.findAll() throws java.lang.Exception'),(7,'2020-02-19 13:18:11','张三',NULL,'/sysLog[Ljava.lang.String;@5da504c9',4,'com.ping.Controller.SysLogControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.SysLogController.findAll() throws java.lang.Exception'),(8,'2020-02-19 13:18:12','张三',NULL,'/sysLog[Ljava.lang.String;@54f03c02',6,'com.ping.Controller.SysLogControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.SysLogController.findAll() throws java.lang.Exception'),(9,'2020-02-19 19:01:50','张三',NULL,'/user[Ljava.lang.String;@3f193668',37,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(10,'2020-02-19 19:01:55','张三',NULL,'/user[Ljava.lang.String;@6435acd',9,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findById(java.lang.Integer)'),(11,'2020-02-19 19:01:59','张三',NULL,'/user[Ljava.lang.String;@40c46a2e',2,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(12,'2020-02-19 19:02:38','张三',NULL,'/user[Ljava.lang.String;@1f2b426e',9,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findById(java.lang.Integer)'),(13,'2020-02-19 19:02:48','张三',NULL,'/user[Ljava.lang.String;@7e421f3e',2,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(14,'2020-02-19 19:15:15','张三',NULL,'/permission[Ljava.lang.String;@7b818764',34,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findAll()'),(15,'2020-02-19 19:15:20','张三',NULL,'/permission[Ljava.lang.String;@3a95582d',1,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findById(java.lang.Integer)'),(16,'2020-02-19 19:15:25','张三',NULL,'/permission[Ljava.lang.String;@725780c9',2,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findAll()'),(17,'2020-02-19 19:15:28','张三',NULL,'/role[Ljava.lang.String;@63ddfc83',24,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(18,'2020-02-19 19:18:23','张三',NULL,'/role[Ljava.lang.String;@58918c50',32,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(19,'2020-02-19 19:20:15','张三',NULL,'/role[Ljava.lang.String;@53ab48b',32,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(20,'2020-02-19 19:23:02','张三',NULL,'/role[Ljava.lang.String;@3a95dcb3',57,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(21,'2020-02-19 19:24:05','张三',NULL,'/role[Ljava.lang.String;@35ac2df3',2,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(22,'2020-02-19 19:24:12','张三',NULL,'/role[Ljava.lang.String;@7dd4b8a9',1,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(23,'2020-02-19 19:24:16','张三',NULL,'/role[Ljava.lang.String;@273527b2',3,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(24,'2020-02-19 19:26:12','张三',NULL,'/role[Ljava.lang.String;@3a95dcb3',33,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(25,'2020-02-19 19:29:11','张三',NULL,'/role[Ljava.lang.String;@58918c50',30,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(26,'2020-02-19 19:37:49','张三',NULL,'/role[Ljava.lang.String;@5464e189',34,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(27,'2020-02-19 19:38:09','张三',NULL,'/role[Ljava.lang.String;@7725f84c',2,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(28,'2020-02-19 20:23:11','营营',NULL,'/user[Ljava.lang.String;@7d688f65',66,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(29,'2020-02-19 20:23:17','营营',NULL,'/user[Ljava.lang.String;@12330a80',9,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findById(java.lang.Integer)'),(30,'2020-02-19 20:23:21','营营',NULL,'/user[Ljava.lang.String;@1ae01874',1,'com.ping.Controller.UserControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.UserController.findAll()'),(31,'2020-02-19 20:23:25','营营',NULL,'/role[Ljava.lang.String;@3e36f1dc',17,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(32,'2020-02-19 20:23:33','营营',NULL,'/role[Ljava.lang.String;@6e39235f',1,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(33,'2020-02-19 20:23:38','营营',NULL,'/role[Ljava.lang.String;@174ffbd4',2,'com.ping.Controller.RoleControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.RoleController.findAll()'),(34,'2020-02-19 20:23:48','营营',NULL,'/permission[Ljava.lang.String;@775fa208',26,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findAll()'),(35,'2020-02-19 20:23:55','营营',NULL,'/permission[Ljava.lang.String;@441fac3d',3,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findById(java.lang.Integer)'),(36,'2020-02-19 20:23:58','营营',NULL,'/permission[Ljava.lang.String;@1bc7f8cc',1,'com.ping.Controller.PermissionControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.PermissionController.findAll()'),(37,'2020-02-19 20:24:00','营营',NULL,'/orders[Ljava.lang.String;@3d3d8a66',128,'com.ping.Controller.OrderControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.OrderController.findAll(java.lang.Integer,java.lang.Integer)'),(38,'2020-02-19 20:24:04','营营',NULL,'/product[Ljava.lang.String;@573fe0e1',20,'com.ping.Controller.ProductControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.ProductController.findAll()'),(39,'2020-02-19 20:24:11','营营',NULL,'/product[Ljava.lang.String;@2024757c',2,'com.ping.Controller.ProductControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.ProductController.findAll()'),(40,'2020-02-19 20:24:15','营营',NULL,'/orders[Ljava.lang.String;@506e2d84',5,'com.ping.Controller.OrderControllerpublic org.springframework.web.servlet.ModelAndView com.ping.Controller.OrderController.findAll(java.lang.Integer,java.lang.Integer)');

/*Table structure for table `traveller` */

DROP TABLE IF EXISTS `traveller`;

CREATE TABLE `traveller` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `phoneNum` varchar(50) DEFAULT NULL,
  `credentiaksType` int(11) DEFAULT NULL,
  `credentiaksNum` varchar(50) DEFAULT NULL,
  `traveller` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `traveller` */

insert  into `traveller`(`id`,`name`,`sex`,`phoneNum`,`credentiaksType`,`credentiaksNum`,`traveller`) values (1,'222','男','88888',5,'8888',666);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phoneNum` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `users` */

insert  into `users`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values (1,'1234','营营','$2a$10$xsWyO4TpM5mqq34TlWAkKeZHHJ8TTc5HHHoYj34ktl9V72SIlWBS6','177924',1);

/*Table structure for table `users_role` */

DROP TABLE IF EXISTS `users_role`;

CREATE TABLE `users_role` (
  `usersId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  KEY `usersId` (`usersId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`usersId`) REFERENCES `users` (`id`),
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `users_role` */

insert  into `users_role`(`usersId`,`roleId`) values (1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
