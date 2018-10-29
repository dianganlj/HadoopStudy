/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : testlj

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-19 14:43:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trade_all
-- ----------------------------
DROP TABLE IF EXISTS `trade_all`;
CREATE TABLE `trade_all` (
  `Tradeid` varchar(255) NOT NULL COMMENT '交易流水号',
  `Acctno` int(11) DEFAULT NULL COMMENT '账号',
  `Amt` double NOT NULL COMMENT '交易金额',
  `Custno` varchar(255) DEFAULT NULL COMMENT '客户号',
  `Custname` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `Custid` int(11) DEFAULT NULL COMMENT '客户证件号',
  `Custtype_cn` varchar(255) DEFAULT NULL COMMENT '客户类型',
  `Value_` varchar(255) DEFAULT NULL COMMENT '交易说明（对公：这是对公可的交易，对私：这是对私客户的交易）',
  `Updatetime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_all
-- ----------------------------
INSERT INTO `trade_all` VALUES ('MY201807', '6222017', '282', 'CT02', 'lichao', '1002', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 14:19:12');
INSERT INTO `trade_all` VALUES ('MY201808', '6222015', '183.5', 'ST02', 'chenxin', '2002', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 14:19:24');
INSERT INTO `trade_all` VALUES ('MY201812', '6222018', '121', 'CT01', 'lijie', '1001', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 22:52:00');
INSERT INTO `trade_all` VALUES ('RMB201802', '6222018', '121', 'CT01', 'lijie', '1001', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 21:50:30');
INSERT INTO `trade_all` VALUES ('RMB201808', '6222015', '294.5', 'ST02', 'chenxin', '2002', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 14:19:27');
INSERT INTO `trade_all` VALUES ('RMB201809', '6222018', '1293', 'CT01', 'lijie', '1001', '对私客户交易', '这是一笔对私客户的交易', '2018-10-17 14:19:31');
INSERT INTO `trade_all` VALUES ('YB201803', '6222018', '343', 'CT01', 'lijie', '1001', '对私客户交易', '这是一笔对私客户的交易', '2018-10-18 10:33:45');
