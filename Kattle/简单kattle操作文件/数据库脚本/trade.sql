/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : testlj

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-19 14:43:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `Tradeid` varchar(255) NOT NULL COMMENT '交易流水号',
  `Acctno` int(11) DEFAULT NULL COMMENT '交易发生账号',
  `Amt` double DEFAULT NULL COMMENT '交易金额',
  `Updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Tradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('MY201807', '6222017', '282', '2018-10-17 14:19:12');
INSERT INTO `trade` VALUES ('MY201808', '6222015', '183.5', '2018-10-17 14:19:24');
INSERT INTO `trade` VALUES ('MY201812', '6222018', '121', '2018-10-17 22:52:00');
INSERT INTO `trade` VALUES ('RMB201802', '6222018', '121', '2018-10-17 21:50:30');
INSERT INTO `trade` VALUES ('RMB201808', '6222015', '294.5', '2018-10-17 14:19:27');
INSERT INTO `trade` VALUES ('RMB201809', '6222018', '1293', '2018-10-17 14:19:31');
INSERT INTO `trade` VALUES ('YB201803', '6222018', '343', '2018-10-18 10:33:45');
