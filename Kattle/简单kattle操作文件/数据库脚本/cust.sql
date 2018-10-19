/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : testlj

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-19 14:43:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cust
-- ----------------------------
DROP TABLE IF EXISTS `cust`;
CREATE TABLE `cust` (
  `Custno` varchar(255) NOT NULL COMMENT '客户号',
  `Custname` varchar(30) DEFAULT NULL COMMENT '客户姓名',
  `Custid` int(11) DEFAULT NULL COMMENT '客户证件号',
  `Custtype` int(11) DEFAULT NULL COMMENT '客户类型，1 为公，2为私',
  PRIMARY KEY (`Custno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cust
-- ----------------------------
INSERT INTO `cust` VALUES ('CT01', 'lijie', '1001', '1');
INSERT INTO `cust` VALUES ('CT02', 'lichao', '1002', '1');
INSERT INTO `cust` VALUES ('CT03', 'liuxu', '1003', '2');
INSERT INTO `cust` VALUES ('ST01', 'zhibo', '2001', '2');
INSERT INTO `cust` VALUES ('ST02', 'chenxin', '2002', '1');
INSERT INTO `cust` VALUES ('ST03', 'wenzhao', '2003', '1');
INSERT INTO `cust` VALUES ('ST04', 'haungqing', '2004', '2');
