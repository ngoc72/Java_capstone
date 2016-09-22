CREATE DATABASE  IF NOT EXISTS `beauty_supply` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `beauty_supply`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: beauty_supply
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `InvoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `InvoiceDate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TotalAmount` float NOT NULL DEFAULT '0',
  `IsProcessed` enum('y','n') DEFAULT NULL,
  PRIMARY KEY (`InvoiceId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,23,'2016-08-17 13:28:18',6,'n'),(2,23,'2016-08-17 13:35:48',10,'n'),(3,23,'2016-08-17 13:41:20',6,'n'),(6,26,'2016-08-17 19:03:52',50,'n'),(13,28,'2016-08-23 11:33:52',10,'n'),(15,29,'2016-08-27 08:31:35',41,'n'),(16,32,'2016-08-27 19:59:09',92,'y'),(17,36,'2016-08-30 21:04:51',6,'y'),(18,37,'2016-08-31 16:35:03',44,'y'),(19,37,'2016-08-31 17:18:51',31,'y'),(20,38,'2016-08-31 19:00:29',44,'y'),(21,38,'2016-09-06 08:48:46',17,'y'),(22,38,'2016-09-06 08:56:29',71,'y'),(23,46,'2016-09-08 13:43:22',61,'n'),(24,49,'2016-09-09 17:50:20',34,'n'),(25,49,'2016-09-10 10:04:35',58,'n'),(26,55,'2016-09-12 13:05:52',56,'n'),(27,56,'2016-09-12 13:17:05',15,'n'),(28,66,'2016-09-12 20:43:40',76,'n'),(29,59,'2016-09-14 19:01:27',43.47,'n'),(30,68,'2016-09-17 09:45:56',18,'n'),(31,69,'2016-09-17 09:49:53',78,'n'),(32,59,'2016-09-17 09:59:38',12.5,'n'),(33,59,'2016-09-17 10:16:59',18,'n'),(34,59,'2016-09-17 10:18:41',18,'n'),(35,59,'2016-09-17 11:10:15',12.5,'n'),(36,59,'2016-09-17 11:15:41',90,'n'),(37,59,'2016-09-17 11:17:56',9.99,'n'),(38,59,'2016-09-17 11:25:42',18,'n'),(39,59,'2016-09-17 11:27:26',9.99,'n'),(40,71,'2016-09-17 11:30:46',162,'n'),(41,74,'2016-09-17 17:52:00',42,'n'),(42,75,'2016-09-17 17:53:43',19.5,'n'),(43,76,'2016-09-18 08:12:37',94.5,'n'),(44,76,'2016-09-18 08:21:21',360,'n');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitem` (
  `LineItemId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductId` int(11) NOT NULL DEFAULT '0',
  `Quantity` int(11) NOT NULL DEFAULT '0',
  `InvoiceId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`LineItemId`),
  KEY `InvoiceId` (`InvoiceId`),
  KEY `lineitem_ibfk_2_idx` (`ProductId`),
  CONSTRAINT `lineitem_ibfk_1` FOREIGN KEY (`InvoiceId`) REFERENCES `invoice` (`InvoiceId`),
  CONSTRAINT `lineitem_ibfk_2` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
INSERT INTO `lineitem` VALUES (1,2,1,1),(2,4,1,2),(3,2,1,3),(8,4,5,6),(18,4,1,13),(21,3,1,15),(22,4,3,15),(23,2,7,16),(24,4,5,16),(25,2,1,17),(26,2,1,18),(27,8,2,18),(28,3,1,19),(29,7,5,19),(30,3,1,20),(31,10,3,20),(32,2,1,21),(33,3,1,21),(34,8,2,22),(35,12,1,22),(36,2,1,23),(37,10,5,23),(38,4,1,24),(39,23,2,24),(40,3,5,25),(41,11,1,25),(42,10,1,26),(43,11,5,26),(44,3,1,26),(45,8,1,26),(46,7,1,27),(47,10,1,27),(48,3,4,28),(49,13,1,28),(50,8,1,29),(51,32,3,29),(52,4,1,30),(53,8,8,31),(54,4,1,31),(55,8,1,32),(56,12,1,32),(57,4,1,33),(58,4,1,34),(59,3,1,35),(60,4,5,36),(61,2,1,37),(62,4,1,38),(63,2,1,39),(64,4,9,40),(65,10,1,41),(66,9,1,41),(67,4,1,41),(68,29,1,41),(69,11,1,42),(70,3,1,42),(71,3,7,43),(72,11,1,43),(73,4,20,44);
/*!40000 ALTER TABLE `lineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ProductId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(50) NOT NULL DEFAULT '',
  `ProductCode` varchar(20) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  `brand` varchar(50) NOT NULL DEFAULT '',
  `category` varchar(50) NOT NULL DEFAULT '',
  `price` decimal(7,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'SALLY HANSEN','GE01','Miracle Gel','SALLY','Gel',9.99),(3,'OPI RED','GN01','Infinity Shine 2 Icons Nails Lacquer','OPI','Nail polish',12.50),(4,'BUTTER LONDON','LG01','Pattern Shine 10X Lacquer','NKK','Nail polish',18.00),(7,'ULTA','PL01','Salon Formular Nail Lacquer','ULTA','Nail polish',6.00),(8,'CHINA GLAZE','PL02','Nails Lacquer with Hardeners','GLAZE','Nail polish',7.50),(9,' SHADES','PL03','Soft Shades Nails Lacquers','OPI','Nail polish',10.00),(10,'OPI NAILS LACQUERS','PL04','New Orlearns Nails Lacquers Collection','OPI','Nail polish',10.00),(11,'NUNAL CO','PL05','Lovely Nails Lacquers','CNU','Nail polish',7.00),(12,'SUN NEON','PL06','Miracle Nails Lacquers','CNN','Nail polish',5.00),(13,'FHYTO PL','PL07','Pink, Lovely Nails Lacquers','NKKN','Nail polish',8.50),(23,'GEL LOVE','PL09','Shine Flower Miracle Gel','GELISH','Gel',15.00),(29,'CAVA','GN02','Sweet Honey Polish','UV','Nail polish',4.00),(31,'LIVING PROOF','HS01','No Frizz Nourishing Stylish ','CCNK','Hair Cream',30.00),(32,'LO\'REAL','HS02','Hair Expertise EverCurl Cleansing Balm','LO\'REAL','Hair Expertise',11.99),(33,'PHYTO','HC01','Phyto 7 Hydrating day Cream','PHTO','Hair Cream',29.00),(34,'REDKEN','HS03','Frizz Dissmiss Conditioner','HENSEN','Hair Conditioner',21.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Company` varchar(50) DEFAULT NULL,
  `Address1` varchar(50) DEFAULT NULL,
  `Address2` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `Zip` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `CreditCardType` varchar(20) DEFAULT NULL,
  `CreditCardNumber` varchar(50) DEFAULT NULL,
  `CreditCardExpirationDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Thanh','Nguyen','thanhnguyem@gmail.com','456','Mancom',NULL,'8617 Spicewood rd','Austin','TX','78759','America',NULL,NULL,NULL),(3,'anh','nguyen','anhnguyen@gmail,com','789',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'aaa','bbb','a@b','111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'ugkuk','ytt','wwjt@dcc','333',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'Nguyen','Hoang','aaa@bbb','','abc','123 Cone dr','','Austin','Tx','12345','US','','',''),(21,'Luu','vuong','luuvuong@gmail.com','12345','MM','232 Monne ln','','Phoenix','AZ','56542','US','','',''),(22,'Duong','Hoang','dhoang@yahoo.com','1q11','MMMMMM','333 Lavey ln','nnnnnn','Oranghe','UA','444444','US','','',''),(23,'nguyen','Nhi','nhibgueyn@www','2222','MMM','234 Blue st','','Danny','SD','3344','VN','Mastercart','77777','032016'),(24,'Minh','Hoang','mhoang@gmail.com','3344','Anne','234 Conner st','','Huna','GG','22222','TA','','',''),(25,'Evan','Nguyen','evan12@gmail.com','23456','Star','234 lano pl','','Ama','Umo','45555','MB','Visa','6767989','04/2020'),(26,'Natalie','Quach','naquach@dell.com','23456','Dell','7800 blue lilly dr','','Sata','tx','78720','US','AmericanExpress','213232323142','03/2018'),(27,'aaa','aaa','aaa@a','111','aaa','mmmmm','nnnnnn','wsed','wdd','1234','ws','Visa','1234','01/2016'),(28,'ef','dsd','dsd@de','dd','cff','dsd','xs','ddef','xc','cdfef','ddef','Visa','cvfvfv','01/2016'),(29,'cxdvd','vvbgbgb','cvcvfbv','vcvbfb','vcbvbg  ',' cc c','',' cv cv',' c c c c c',' x xcx','cdcd','Visa','fgththt','01/2016'),(30,'dcrvfrv','fvfvgf','cfvfv','vfv','fv  ','frfrfv','','cfvv','vfgvg','cfv','vfv','','',''),(31,'gbhnbhn','gbhb','gghyh@gtg','gtby','gbgb','vgbvgb','','vgv','gbb','1313','gbgbg','','',''),(32,'rftrftg','cfvfvgvt','xdcf@vvg','cfcf','cfvfgvgtv','cfcfvg','vgvbg','ftgtg','gbyb','vghb','gvbgb','Visa','456677','03/2019'),(33,'vfvfbbfbf',' cvcmvmcv','mv,vf@','mkmcdc','','','','','','','','','',''),(34,'vfvfbbfbf',' cvcmvmcv','mv,vf@','cx d d','','','','','','','','','',''),(35,'fvfvfv','vfvfvf','dvdv@ndnckd','mckcmfk','mdmcl','cldcl','mdmcl','mdlmcl','mcflcvml','mclcm',',lf,vflvf','','',''),(36,'vfvfbbfbf',' cvcmvmcv','mvvf@fvf','mkmcdc','mvcfkvmf','vmmvkfmv','vfvfjvhfujvhi','jfrjrfrf','kfkforfkr','fkorkfor',NULL,'Visa','3434545','01/2016'),(37,'Nguyen','Minh','mnguyen@gmail.com','123456','Parron','675 Tree dr','','Phoenix','AZ','78523',NULL,'Visa','4444444','01/2018'),(38,'mkdlkvlfkv','mdlkvf','kjfkj@mmfl','1111','nfkvmlfg;l','frggg','','hyhjy','ghhy','4545',NULL,'Visa','454566','01/2018'),(43,'cdcvv','vfvfvtb','vfgttt@nkjdc','123','','','','','','','','','',''),(45,'ngoc','hoang','hoangthithanhngoc@yahoo.com','123','','','','','','','','','',''),(46,'thanh','ndnc','cmcm@ndcn','123',';l;l\';l','edr5ftg','','tgyhgy','gyhyuh','tgyg','gyhyh','Visa','6878','01/2016'),(47,'hmkd','lcdlc','mdcmdkc@mcldc','123','','','','','','','','','',''),(48,'Nameo','Tom','tom@gmail.com','222','','','','','','','','','',''),(49,'Minh','Nguyen','minh@gmail.com','111','BBB','2900 Tree oak Pl','','Round Rock','TX','45644','US','Visa','1234345454242','01/2016'),(50,'mmmm','mmmm','m@m','be0cdb7610bd67dd94a82e6e1bba61ae51eb1545f83ff7dbefd5dbc7c6acfe68','','','','','','','','','',''),(51,'a','a','a@a','33cff17efcd8b4e2745e8dfcfbacc431e62c087a70b4ec420a2668d6ed43e92e','','','','','','','','','',''),(52,'b','b','b@b','09682456fce7f76469cd4d3ad786ed74c21f297c87dc5f5fa587f4952a555e73','','','','','','','','','',''),(53,'c','c','c@c','64daa44ad493ff28a96effab6e77f1732a3d97d83241581b37dbd70a7a4900fe','','','','','','','','','',''),(54,'Tom','cat','tom@gmail.com','91a73fd806ab2c005c13b4dc19130a884e909dea3f72d46e30266fe1a1f588d8','','','','','','','','','',''),(55,'Tom','Cat','tomcat@yahoo.com','555','TOM','456 Cat st ','','Meme','ME','65676','CAT','Visa','7779995','01/2017'),(56,'Tom','Cat','tomcat@yahoo.com','77af778b51abd4a3c51c5ddd97204a9c3ae614ebccb75a606c3b6865aed6744e','TOM','456 Cat st ','','Meme','ME','65676','CAT','Visa','90000000','01/2016'),(57,'Alex','De','elex@gmail..com','282b91e08fd50a38f030dbbdee7898d36dd523605d94d9dd6e50b298e47844be','','','','','','','','','',''),(58,'Alex','De','elex@gmail.com','3d6030c189590fa83873a5aca56b13e03888ac686e9ecb198fd0db0f97faed90','MTA','889 Moon Pl','','Namy','USta','77777','US','','',''),(59,'g;blg;nb','bv,b;vb,','u@u','3e744b9dc39389baf0c5a0660589b8402f3dbb49b89b3e75f2c9355852a3c677','AAA','2900 Tree oak Pl','bb','Round Rock','TX','45644','United States','Visa','6767678','01/2016'),(61,'iii','iii','i@i','f5557d4fcf727a981a3c315aca733eefa2996f7c7cdae1fa7e0de28522820bb0','','','','','','','','','',''),(62,'g;blg;nb','bv,b;vb,','vkvjfvkf@mxsm','78e93c1bfb980b912e14070a1a8ca5327af70ba76dbf74470033554b5c02149d','gglgh','h;ghlhl','bb',',gg;;','hgh','hjhj','United States','','',''),(63,'Rall','Dole','n@n','e8702ecd939e3ace89e85e0df11878c76de38bc8c4ed42f1d842abb05e9b511a','CCC','184 Red Oak dr','','Satse','MM','90904','MN','','',''),(64,'Tommy','Deniel','tomdeniel@gmail.com','b3a8e0e1f9ab1bfe3a36f231f676f78bb30a519d2b21e6c530c0eee8ebb4a5d0','','','','','','','','','',''),(65,'Tommy','Deniel','tomdeniel@gmail.com','7b569eacfdec67064506c43b931fed2e9ee6edf9e9c1240005f9ad1e0fc37cc9','NN','Suzana street','','Loona','JL','7950950','KL','','',''),(66,'Tommy','Deniel','tomdeniel@gmail.com','078a10472946aba535fd4fbdfd21f7a3215a789b5972efe4cb2ea2d12655df8a','NN','Suzana street','','Loona','JL','7950950','KL','Visa','89958656033','10/2017'),(67,'g;blg;nb','bv,b;vb,','u@u','82db0aadc9dd0f9f487c6236bfc66ae293204ccc3e486130254cdc4b26ef51d4','AAA','2900 Tree oak Pl','bb','Round Rock','TX','45644','United States','Visa','7883948304304','01/2016'),(68,'Minh','Rolda','minh@yahoo.com','e8702ecd939e3ace89e85e0df11878c76de38bc8c4ed42f1d842abb05e9b511a','MMMM','666 Mouse Dr','','Obaka','UT','99999','United States','Visa','99999999','11/2017'),(69,'David','Koley','david@gmail.com','730f75dafd73e047b86acb2dbd74e75dcb93272fa084a9082848f2341aa1abb6','SPA PRO','7867 Research St','bb','Santo','Luma','89800','United States','Mastercart','740596585','10/2016'),(70,'Anna','Okale','anna@ddd','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','AAA','123 Coco Pl ','bb','Umma','Ustu','78779','United States','','',''),(71,'ooo','ooo','ooo@o','2ac9a6746aca543af8dff39894cfe8173afba21eb01c6fae33d52947222855ef','BBB','454 Camal St','','Mily','ML','56577','United States','Visa','90974857496','01/2016'),(72,'Ngoc','Hoang','hhh@h','24d166cd6c8b826c779040b49d5b6708d649b236558e8744339dfee6afe11999','','','','','','','','','',''),(73,'jjj','jjj','jjj@j','b2fca9af31aae6953124439df5bc300c1ef11fb8be938aeb570767c5b6bfdaaf','','','','','','','','','',''),(74,'kkk','kkk','kkk@k','96efbc43a462ab9d9c6a8173e5b322e17f218b56eb3a05a4bbc53221adebc7b3','yuoupo','orgpr','irpgr','kphpt','kppt','69090',';lh[','Visa','4069-56-','01/2016'),(75,'kdlgr','plrypypo','jgot@kgl','3538a1ef2e113da64249eea7bd068b585ec7ce5df73b2d1e319d8c9bf47eb314','riutorto','2900 Tree oak Pl','bb','Round Rock','TX','45644','United States','Visa','97-679','01/2016'),(76,'Ngoc','Hoang','ngochoang@yahoo.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','Spa Pronails','34566 Research Blvd ','','Austin','Texas','78759','United States','AmericanExpress','6485459068056','12/2017');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpass`
--

DROP TABLE IF EXISTS `userpass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userpass` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpass`
--

LOCK TABLES `userpass` WRITE;
/*!40000 ALTER TABLE `userpass` DISABLE KEYS */;
INSERT INTO `userpass` VALUES ('Anh','123'),('Ngoc','123'),('Thanh','123');
/*!40000 ALTER TABLE `userpass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `Username` varchar(20) NOT NULL,
  `Rolename` varchar(20) NOT NULL,
  PRIMARY KEY (`Username`,`Rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES ('Anh','service'),('Ngoc','programmer'),('Thanh','administrator');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-18 10:31:30
