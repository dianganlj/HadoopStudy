/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : testlj

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-19 14:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `Acctno` int(11) NOT NULL COMMENT '账号',
  `Custno` varchar(255) DEFAULT NULL COMMENT '账账户对应客户号',
  `Amt` double DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`Acctno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('6222012', 'ST04', '234.7');
INSERT INTO `account` VALUES ('6222014', 'ST03', '123');
INSERT INTO `account` VALUES ('6222015', 'ST02', '8765.3');
INSERT INTO `account` VALUES ('6222016', 'ST01', '5432.5');
INSERT INTO `account` VALUES ('6222017', 'CT02', '1234.2');
INSERT INTO `account` VALUES ('6222018', 'CT01', '543.12');
INSERT INTO `account` VALUES ('6222019', 'CT03', '11111');
