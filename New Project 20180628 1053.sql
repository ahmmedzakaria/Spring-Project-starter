-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema tsp
--

CREATE DATABASE IF NOT EXISTS tsp;
USE tsp;

--
-- Definition of table `batch_info`
--

DROP TABLE IF EXISTS `batch_info`;
CREATE TABLE `batch_info` (
  `batch_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `batch_name` varchar(30) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `batch_round` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`batch_id`),
  KEY `FK_tsp_id_1` (`tsp_id`),
  CONSTRAINT `FK_tsp_id_1` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch_info`
--

/*!40000 ALTER TABLE `batch_info` DISABLE KEYS */;
INSERT INTO `batch_info` (`batch_id`,`tsp_id`,`batch_name`,`start_date`,`end_date`,`batch_round`) VALUES 
 (1,1,'Java','2018-02-02 00:00:00','2018-05-05 00:00:00',32),
 (2,1,'Php','2018-02-02 00:00:00','2018-05-05 00:00:00',33);
/*!40000 ALTER TABLE `batch_info` ENABLE KEYS */;


--
-- Definition of table `exam_marks`
--

DROP TABLE IF EXISTS `exam_marks`;
CREATE TABLE `exam_marks` (
  `marks_id` int(10) unsigned NOT NULL auto_increment,
  `exam_id` int(10) unsigned NOT NULL,
  `student_id` int(10) unsigned NOT NULL,
  `marks_obtained` double NOT NULL,
  PRIMARY KEY  (`marks_id`),
  KEY `FK_exam_marks` (`student_id`),
  KEY `FK_exam_id_1` (`exam_id`),
  CONSTRAINT `FK_exam_id_1` FOREIGN KEY (`exam_id`) REFERENCES `exam_schedule` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_marks`
--

/*!40000 ALTER TABLE `exam_marks` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_marks` ENABLE KEYS */;


--
-- Definition of table `exam_schedule`
--

DROP TABLE IF EXISTS `exam_schedule`;
CREATE TABLE `exam_schedule` (
  `exam_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `faculty_id` int(10) unsigned NOT NULL,
  `batch_id` int(10) unsigned NOT NULL,
  `exam_name` varchar(30) NOT NULL,
  `exam_date` datetime NOT NULL,
  `total_marks` double NOT NULL,
  PRIMARY KEY  (`exam_id`),
  KEY `FK_exam_schedule_1` (`tsp_id`),
  KEY `FK_exam_schedule_3` (`batch_id`),
  KEY `FK_faculty_id` (`faculty_id`),
  CONSTRAINT `FK_batch_id` FOREIGN KEY (`batch_id`) REFERENCES `batch_info` (`batch_id`),
  CONSTRAINT `FK_faculty_id` FOREIGN KEY (`faculty_id`) REFERENCES `tsp_faculty` (`faculty_id`),
  CONSTRAINT `FK_tsp_id_2` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_schedule`
--

/*!40000 ALTER TABLE `exam_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_schedule` ENABLE KEYS */;


--
-- Definition of table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `login_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  `user_name` varchar(30) default NULL,
  `user_password` varchar(20) NOT NULL,
  `status` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`login_id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `role_id` USING BTREE (`role_id`),
  KEY `tsp_id` USING BTREE (`tsp_id`),
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`),
  CONSTRAINT `FK_tsp_id_3` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_info`
--

/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;


--
-- Definition of table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`pid`,`name`,`location`) VALUES 
 (1,'Mahabub','Dhaka'),
 (2,'Bari','Dhaka');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


--
-- Definition of table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `student_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `batch_id` int(10) unsigned NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `student_address` varchar(50) NOT NULL,
  `student_email` varchar(30) NOT NULL,
  `student_phone` varchar(11) NOT NULL,
  `student_father_name` varchar(30) NOT NULL,
  `student_mother_name` varchar(30) NOT NULL,
  `student_date_of_birth` datetime NOT NULL,
  `student_nid` varchar(30) NOT NULL,
  `student_phone_link` varchar(11) NOT NULL,
  PRIMARY KEY  (`student_id`),
  KEY `FK_tsp_id_4` (`tsp_id`),
  KEY `FK_batch_id_1` (`batch_id`),
  CONSTRAINT `FK_batch_id_1` FOREIGN KEY (`batch_id`) REFERENCES `batch_info` (`batch_id`),
  CONSTRAINT `FK_tsp_id_4` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_info`
--

/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` (`student_id`,`tsp_id`,`batch_id`,`student_name`,`student_address`,`student_email`,`student_phone`,`student_father_name`,`student_mother_name`,`student_date_of_birth`,`student_nid`,`student_phone_link`) VALUES 
 (1,1,1,'Shanto','Dhaka','abc@gmail.com','01977010445','bb','abc','2018-02-02 00:00:00','156416611251212','01811201445');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;


--
-- Definition of table `student_job_status`
--

DROP TABLE IF EXISTS `student_job_status`;
CREATE TABLE `student_job_status` (
  `job_id` int(10) unsigned NOT NULL auto_increment,
  `student_id` int(10) unsigned NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `joining_date` datetime NOT NULL,
  `starting_salary` double NOT NULL,
  `job_position` varchar(30) NOT NULL,
  `company_location` varchar(45) NOT NULL,
  `resign_date` datetime NOT NULL,
  `status` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`job_id`),
  KEY `FK_student_id` (`student_id`),
  CONSTRAINT `FK_student_id` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_job_status`
--

/*!40000 ALTER TABLE `student_job_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_job_status` ENABLE KEYS */;


--
-- Definition of table `tsp_faculty`
--

DROP TABLE IF EXISTS `tsp_faculty`;
CREATE TABLE `tsp_faculty` (
  `faculty_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `faculty_code` int(10) unsigned NOT NULL,
  `faculty_name` varchar(30) NOT NULL,
  `faculty_email` varchar(30) NOT NULL,
  `faculty_phone` varchar(11) NOT NULL,
  PRIMARY KEY  USING BTREE (`faculty_id`),
  KEY `FK_tsp_faculity` (`tsp_id`),
  CONSTRAINT `FK_tsp_id_5` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tsp_faculty`
--

/*!40000 ALTER TABLE `tsp_faculty` DISABLE KEYS */;
INSERT INTO `tsp_faculty` (`faculty_id`,`tsp_id`,`faculty_code`,`faculty_name`,`faculty_email`,`faculty_phone`) VALUES 
 (1,1,1034,'Bari','eng.abari@gmail.com','01713733362'),
 (3,3,1034,'A Bari','eng.abari@gmail.com','01713733362'),
 (6,6,534,'Aaaaaaaaaa','bbbbbbbb','312312');
/*!40000 ALTER TABLE `tsp_faculty` ENABLE KEYS */;


--
-- Definition of table `tsp_info`
--

DROP TABLE IF EXISTS `tsp_info`;
CREATE TABLE `tsp_info` (
  `tsp_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_name` varchar(30) NOT NULL,
  `tsp_address` varchar(30) NOT NULL,
  `tsp_phone` varchar(11) NOT NULL,
  `tsp_email` varchar(30) NOT NULL,
  `tsp_location` varchar(50) NOT NULL,
  PRIMARY KEY  (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tsp_info`
--

/*!40000 ALTER TABLE `tsp_info` DISABLE KEYS */;
INSERT INTO `tsp_info` (`tsp_id`,`tsp_name`,`tsp_address`,`tsp_phone`,`tsp_email`,`tsp_location`) VALUES 
 (1,'Shanto','Kakrail, Dhaka','01717644454','abc@gmail.com','Khulna'),
 (2,'Shanto2','Kakrail, Dhaka','01717644454','abc@gmail.com','ert'),
 (3,'Shahid','Kakrail, Dhaka','01717644454','abc@gmail.com','Sylet'),
 (4,'Sujon','Kakrail, Dhaka','01717644454','abc@gmail.com','police'),
 (6,'TCL','Kakrile, Dhaka','8319091','test@test.com','Dhaka'),
 (7,'dsfdsf','dsfdsf','312312','asdas','dsfds'),
 (8,'aaaa','bbbbb','312312','cccccccc','dddddddd');
/*!40000 ALTER TABLE `tsp_info` ENABLE KEYS */;


--
-- Definition of table `tsp_tc`
--

DROP TABLE IF EXISTS `tsp_tc`;
CREATE TABLE `tsp_tc` (
  `tc_id` int(10) unsigned NOT NULL auto_increment,
  `tsp_id` int(10) unsigned NOT NULL,
  `tc_name` varchar(30) NOT NULL,
  `tc_email` varchar(30) NOT NULL,
  `tc_phone` varchar(11) NOT NULL,
  PRIMARY KEY  (`tc_id`),
  KEY `FK_tsp_id` (`tsp_id`),
  CONSTRAINT `FK_tsp_id` FOREIGN KEY (`tsp_id`) REFERENCES `tsp_info` (`tsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tsp_tc`
--

/*!40000 ALTER TABLE `tsp_tc` DISABLE KEYS */;
INSERT INTO `tsp_tc` (`tc_id`,`tsp_id`,`tc_name`,`tc_email`,`tc_phone`) VALUES 
 (1,1,'Abc','abc@gmail.com','01977010445');
/*!40000 ALTER TABLE `tsp_tc` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL auto_increment,
  `role_name` varchar(30) NOT NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`,`role_name`) VALUES 
 (1,'Admin');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
