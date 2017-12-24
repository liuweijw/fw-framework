-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                       5.6.21 - MySQL Community Server (GPL)
-- 服务器操作系统:                    Win64
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 fw_init 的数据库结构
DROP DATABASE IF EXISTS `fw_init`;
CREATE DATABASE IF NOT EXISTS `fw_init` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fw_init`;


-- 导出  表 fw_init.t_fw_version 结构
DROP TABLE IF EXISTS `t_fw_version`;
CREATE TABLE IF NOT EXISTS `t_fw_version` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT,
  `aboutinfo` varchar(255) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `cuser` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `download_url` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `min_version` int(11) DEFAULT NULL,
  `new_version` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 正在导出表  fw_init.t_fw_version 的数据：~0 rows (大约)
DELETE FROM `t_fw_version`;
/*!40000 ALTER TABLE `t_fw_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fw_version` ENABLE KEYS */;
