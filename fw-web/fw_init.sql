-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.21 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
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


-- 导出  表 fw_init.t_fw_user 结构
DROP TABLE IF EXISTS `t_fw_user`;
CREATE TABLE IF NOT EXISTS `t_fw_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  fw_init.t_fw_user 的数据：~2 rows (大约)
DELETE FROM `t_fw_user`;
/*!40000 ALTER TABLE `t_fw_user` DISABLE KEYS */;
INSERT INTO `t_fw_user` (`id`, `password`, `username`) VALUES
	(1, '$2a$10$iVOzIQNJUR4IVxDbwVw0WOHUBDHSfC/E2kmfHYOja58GLCsiRcul6', 'admin'),
	(2, '$2a$10$iVOzIQNJUR4IVxDbwVw0WOHUBDHSfC/E2kmfHYOja58GLCsiRcul6', 'test');
/*!40000 ALTER TABLE `t_fw_user` ENABLE KEYS */;


-- 导出  表 fw_init.t_fw_user_role 结构
DROP TABLE IF EXISTS `t_fw_user_role`;
CREATE TABLE IF NOT EXISTS `t_fw_user_role` (
  `role` varchar(255) NOT NULL,
  `app_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role`,`app_user_id`),
  KEY `FKorhv5sjmol4v4sjy2aj85hbwn` (`app_user_id`),
  CONSTRAINT `FKorhv5sjmol4v4sjy2aj85hbwn` FOREIGN KEY (`app_user_id`) REFERENCES `t_fw_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  fw_init.t_fw_user_role 的数据：~2 rows (大约)
DELETE FROM `t_fw_user_role`;
/*!40000 ALTER TABLE `t_fw_user_role` DISABLE KEYS */;
INSERT INTO `t_fw_user_role` (`role`, `app_user_id`) VALUES
	('ADMIN', 1),
	('AUTH', 2);
/*!40000 ALTER TABLE `t_fw_user_role` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  fw_init.t_fw_version 的数据：~0 rows (大约)
DELETE FROM `t_fw_version`;
/*!40000 ALTER TABLE `t_fw_version` DISABLE KEYS */;
INSERT INTO `t_fw_version` (`sid`, `aboutinfo`, `ctime`, `cuser`, `description`, `download_url`, `memo`, `min_version`, `new_version`, `status`, `type`) VALUES
	(1, '1', '2017-12-24 19:51:31', '1', '1', '11', '1', 1, 2, 1, 1);
/*!40000 ALTER TABLE `t_fw_version` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
