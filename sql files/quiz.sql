-- MySQL dump 10.15  Distrib 10.0.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	10.0.23-MariaDB-0ubuntu0.15.04.1

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
-- Table structure for table `2016_10_11__PPL_Mid`
--

DROP TABLE IF EXISTS `2016_10_11__PPL_Mid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2016_10_11__PPL_Mid` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2016_10_11__PPL_Mid`
--

LOCK TABLES `2016_10_11__PPL_Mid` WRITE;
/*!40000 ALTER TABLE `2016_10_11__PPL_Mid` DISABLE KEYS */;
INSERT INTO `2016_10_11__PPL_Mid` VALUES (1,'kjnfdgnjdnjnj','njnjnj','nnjnj','nnjnj','nnjnj','1'),(2,'ndfnfnnkdfnkn','nnnknknk','knnnknkn','nknknnknk','nknkknnk','2');
/*!40000 ALTER TABLE `2016_10_11__PPL_Mid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_04_28__newww_End`
--

DROP TABLE IF EXISTS `2017_04_28__newww_End`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_04_28__newww_End` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_04_28__newww_End`
--

LOCK TABLES `2017_04_28__newww_End` WRITE;
/*!40000 ALTER TABLE `2017_04_28__newww_End` DISABLE KEYS */;
INSERT INTO `2017_04_28__newww_End` VALUES (1,'ksdksjj','nnjn','njnj','nnj','nnj','1'),(2,'dsfvnfdn','nknknkk','nklnklnklnkl','knnknkn','nknkn','2');
/*!40000 ALTER TABLE `2017_04_28__newww_End` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_04_30__DAA_Quiz_2`
--

DROP TABLE IF EXISTS `2017_04_30__DAA_Quiz_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_04_30__DAA_Quiz_2` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_04_30__DAA_Quiz_2`
--

LOCK TABLES `2017_04_30__DAA_Quiz_2` WRITE;
/*!40000 ALTER TABLE `2017_04_30__DAA_Quiz_2` DISABLE KEYS */;
INSERT INTO `2017_04_30__DAA_Quiz_2` VALUES (1,'worst case time of radix sort ?','O(n2)','O(1)','O(n.log(n))','o(n3)','3'),(2,'best algo for tiling problem..','greedy algo','branch and bound','greedy','dynamic programming','3'),(3,'complexity','kndskjfsd','dsfknsjs9e4wu92u3938958534853','u4324879328723','3435645756ergeff','1'),(4,'sdkjsdfhsdkhds','kjjjkknjnnklnioooi','ihoijiuijnjnnn','uytut87y8io','7tt77t8868989','3'),(5,'kjfdshuf8uo','oihhsdihfheihiohi','ihoihohoideihofiho','huhhiohioh','ihohiohiohio','3'),(6,'fdsjkjdfdfkj','hkjllkjdfkl','nllnlnknk','nnnj','nlnlnl','3');
/*!40000 ALTER TABLE `2017_04_30__DAA_Quiz_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_04_30__DBMS_End`
--

DROP TABLE IF EXISTS `2017_04_30__DBMS_End`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_04_30__DBMS_End` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_04_30__DBMS_End`
--

LOCK TABLES `2017_04_30__DBMS_End` WRITE;
/*!40000 ALTER TABLE `2017_04_30__DBMS_End` DISABLE KEYS */;
INSERT INTO `2017_04_30__DBMS_End` VALUES (1,'sndshfdsfhshfdhhsdhfdshhsddhshnjnndnjghdsgh','sndshfdsf','shhsddhshjghdsgh','dshhsddhshjghdsgh','dshhsddhshjghdsgh','1');
/*!40000 ALTER TABLE `2017_04_30__DBMS_End` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_04_30__PPL_Mid`
--

DROP TABLE IF EXISTS `2017_04_30__PPL_Mid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_04_30__PPL_Mid` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_04_30__PPL_Mid`
--

LOCK TABLES `2017_04_30__PPL_Mid` WRITE;
/*!40000 ALTER TABLE `2017_04_30__PPL_Mid` DISABLE KEYS */;
INSERT INTO `2017_04_30__PPL_Mid` VALUES (1,'kmkdfkghntrn','knnnn','njnjnjn','njnnj','njnj','1'),(2,'kkdfknlnbfknnl','knnknlnnn','knnknklnklnkl','knnnklnklnk','knnnknk','3'),(3,'lm;ythtoyhotmhmm','mmmkmkmk','kmkmkmkmkkm','kmmmkmkmkkmmk','kmkmmm','3'),(4,'kjtgjrtjhijrtji','ijjojojpojpo','jopjjpojojijj','jojojopjopjpjojpojo','jojjojojpo','2');
/*!40000 ALTER TABLE `2017_04_30__PPL_Mid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_05_30__java_java`
--

DROP TABLE IF EXISTS `2017_05_30__java_java`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_05_30__java_java` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_05_30__java_java`
--

LOCK TABLES `2017_05_30__java_java` WRITE;
/*!40000 ALTER TABLE `2017_05_30__java_java` DISABLE KEYS */;
INSERT INTO `2017_05_30__java_java` VALUES (1,'kdsnfdsnnsdn','knndsnkvknn','knlnknknkn','knknlnknk','nknnknknknk','3'),(2,'dsnmndsnvndsn','kdsnvsdnvnkdskn','nkndsknvdknvknds','nkn','sss','3'),(3,'complexity','0(n2)','0()','0(1)','o(sfs)','2'),(4,'sjbdsbvkbkbqwfhewfvwvhfvewhbvfwevkfvwkevfwevkv','vfbvesvfsdvfvhs','jbsdbvf','wvfv','vv','4'),(5,'sds','sddsdsdgsdjsdjsdbkjbkj','bjbjbbjbkjbjbkjbkjbkj','bbbjb','bjbbjbjbjbjbjb','1'),(6,'bjksdbvbkjdsbkjvdbskjbjdsbvdbsbvdsbjvdbsjbjsdbsdsduvsduvsdbvdbvdbsb','888s78sd8sdy8','y8yyugagssa56e','yuguhh89y8797897h','1e56235656erad','2'),(7,'nbsdbvvdvs','vhvhvhvhjsfhsfyu','ttttggghg','hgiugttttiu','7t7t69698689689689','1'),(8,' @   DS',' ','  ',' ',' ','1');
/*!40000 ALTER TABLE `2017_05_30__java_java` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2017_06_24__PPL_End`
--

DROP TABLE IF EXISTS `2017_06_24__PPL_End`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2017_06_24__PPL_End` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2017_06_24__PPL_End`
--

LOCK TABLES `2017_06_24__PPL_End` WRITE;
/*!40000 ALTER TABLE `2017_06_24__PPL_End` DISABLE KEYS */;
INSERT INTO `2017_06_24__PPL_End` VALUES (1,'jjnjnjnnbb','hjkjkkj;k','YGGKHKLKNHKNL','DTFFVVHJ','DCGVVV','2');
/*!40000 ALTER TABLE `2017_06_24__PPL_End` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `2018_05_09__SMAT_Mid`
--

DROP TABLE IF EXISTS `2018_05_09__SMAT_Mid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2018_05_09__SMAT_Mid` (
  `Q_no` int(3) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `ans` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2018_05_09__SMAT_Mid`
--

LOCK TABLES `2018_05_09__SMAT_Mid` WRITE;
/*!40000 ALTER TABLE `2018_05_09__SMAT_Mid` DISABLE KEYS */;
INSERT INTO `2018_05_09__SMAT_Mid` VALUES (1,'dsfsfnmdmfmgfmmkmgkmmkmkdmkgkmgmdfkmgmkgkmdfkmgkmfgkmdmkgmkmkgdmkgmmgdmgkdmkdmgmmmgkmfgkmmgkdkmgmkmkgdfkmgkmmkgmgrmgijerigrijijriijgijejgiejjpjfjfjsjfdsfjdjgjdjgdjfgijdfjgirjigijergijjgjiejgiijjgierjgjgjijgejeijgjeigjierjgi','nnjn','n','nn','Opt 4-','4'),(2,'nnjnjnj','njn','nnjnfkefjenhfehrfr','nnj','njnjnj','3'),(3,'lgrtkhkrtkk','lk','llmmlmm','mlmlmlml','Opt 4-','3'),(4,'sdfsdgf','sdfsndn','nnnnj','njnjnnj','njjnnjn','4');
/*!40000 ALTER TABLE `2018_05_09__SMAT_Mid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculity`
--

DROP TABLE IF EXISTS `faculity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculity` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `phone_no` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculity`
--

LOCK TABLES `faculity` WRITE;
/*!40000 ALTER TABLE `faculity` DISABLE KEYS */;
INSERT INTO `faculity` VALUES (1,'krishna','krishna',1234567890),(2,'guest','guest',987654321),(3,'kri','kri',987654321),(4,'akkn','mmvy',987654321);
/*!40000 ALTER TABLE `faculity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculity_access`
--

DROP TABLE IF EXISTS `faculity_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculity_access` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(40) NOT NULL,
  `creator` varchar(30) NOT NULL,
  `start_time` time NOT NULL,
  `ans_time` time NOT NULL,
  `rls_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `paper_name` (`paper_name`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculity_access`
--

LOCK TABLES `faculity_access` WRITE;
/*!40000 ALTER TABLE `faculity_access` DISABLE KEYS */;
INSERT INTO `faculity_access` VALUES (1,'2016_10_11__PPL_Mid','krishna','11:04:00','12:12:00','2016-10-11'),(2,'2017_04_28__newww_End','guest','01:04:00','02:12:00','2017-04-28'),(3,'2017_04_30__DAA_Quiz_2','guest','05:04:00','07:12:00','2017-04-30'),(4,'2017_05_30__java_java','krishna','22:04:00','23:12:00','2017-05-30'),(5,'2017_06_24__PPL_End','guest','22:04:00','23:12:00','2017-06-24'),(6,'2018_05_09__SMAT_Mid','kri','20:04:00','20:32:00','2018-05-09'),(7,'2017_04_30__DBMS_End','kri','07:12:00','08:12:00','2017-04-30'),(8,'2017_04_30__PPL_Mid','kri','17:12:00','18:12:00','2017-04-30');
/*!40000 ALTER TABLE `faculity_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks_list`
--

DROP TABLE IF EXISTS `marks_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks_list` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `paper` varchar(25) NOT NULL,
  `q1` int(1) NOT NULL,
  `q2` int(1) NOT NULL,
  `q3` int(1) NOT NULL,
  `q4` int(1) NOT NULL,
  `q5` int(1) NOT NULL,
  `q6` int(1) NOT NULL,
  `q7` int(1) NOT NULL,
  `q8` int(1) NOT NULL,
  `q9` int(1) NOT NULL,
  `q10` int(1) NOT NULL,
  `q11` int(1) NOT NULL,
  `q12` int(1) NOT NULL,
  `q13` int(1) NOT NULL,
  `q14` int(1) NOT NULL,
  `q15` int(1) NOT NULL,
  `q16` int(1) NOT NULL,
  `q17` int(1) NOT NULL,
  `q18` int(1) NOT NULL,
  `q19` int(1) NOT NULL,
  `q20` int(1) NOT NULL,
  `q21` int(1) NOT NULL,
  `q22` int(1) NOT NULL,
  `q23` int(1) NOT NULL,
  `q24` int(1) NOT NULL,
  `q25` int(1) NOT NULL,
  `q26` int(1) NOT NULL,
  `q27` int(1) NOT NULL,
  `q28` int(1) NOT NULL,
  `q29` int(1) NOT NULL,
  `q30` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`username`,`paper`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks_list`
--

LOCK TABLES `marks_list` WRITE;
/*!40000 ALTER TABLE `marks_list` DISABLE KEYS */;
INSERT INTO `marks_list` VALUES (11,'krishna','2017_04_30__PPL_Mid',3,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(12,'kri','2017_04_30__PPL_Mid',3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(13,'kri','2017_04_30__DBMS_End',3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(14,'kri','2017_04_30__DAA_Quiz_2',3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(22,'kri','2018_05_09__SMAT_Mid',3,0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `marks_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `phone_no` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'krishna','krishna',1234567890),(2,'guest','guest',987654321),(3,'kri','kri',987654321),(4,'akkn','mmvy',987654321);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-03 15:06:27
