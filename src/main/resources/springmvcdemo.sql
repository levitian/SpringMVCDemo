/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : springmvcdemo

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-07-28 14:58:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `events`
-- ----------------------------
DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `end` datetime NOT NULL,
  `start` datetime NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of events
-- ----------------------------
INSERT INTO `events` VALUES ('1', '2015-07-29 19:07:44', '2015-07-26 19:07:51', '1');
INSERT INTO `events` VALUES ('2', '2015-07-25 15:07:33', '2015-07-22 15:07:40', '2');
INSERT INTO `events` VALUES ('3', '2015-06-18 09:32:18', '2015-06-10 09:32:26', '3');
INSERT INTO `events` VALUES ('4', '2015-08-08 10:32:55', '2015-08-08 10:31:57', '2');
INSERT INTO `events` VALUES ('12', '2015-07-17 00:00:00', '2015-07-13 00:00:00', '1');
INSERT INTO `events` VALUES ('13', '2015-07-10 00:00:00', '2015-07-10 00:00:00', '2');
INSERT INTO `events` VALUES ('15', '2015-07-04 00:00:00', '2015-07-04 00:00:00', '1');
INSERT INTO `events` VALUES ('16', '2015-07-09 00:00:00', '2015-07-09 00:00:00', '2');
INSERT INTO `events` VALUES ('17', '2015-07-01 00:00:00', '2015-07-01 00:00:00', '2');
INSERT INTO `events` VALUES ('18', '2015-07-11 00:00:00', '2015-07-11 00:00:00', '3');
INSERT INTO `events` VALUES ('23', '2015-07-30 00:00:00', '2015-07-30 00:00:00', '1');
INSERT INTO `events` VALUES ('24', '2015-07-29 00:00:00', '2015-07-29 00:00:00', '3');
INSERT INTO `events` VALUES ('25', '2015-07-02 00:00:00', '2015-07-02 00:00:00', '3');
INSERT INTO `events` VALUES ('26', '2015-07-12 00:00:00', '2015-07-12 00:00:00', '3');
INSERT INTO `events` VALUES ('27', '2015-07-17 00:00:00', '2015-07-17 00:00:00', '3');
INSERT INTO `events` VALUES ('28', '2015-07-18 00:00:00', '2015-07-18 00:00:00', '3');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWD` varchar(255) NOT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_hauxbq9sbi2c8023wchbpdd2l` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'tianl@ehualu.com', '123456', '18612081708', '田力');
INSERT INTO `users` VALUES ('2', 'linz@ehualu.com', '123456', '1111', '林智');
INSERT INTO `users` VALUES ('3', 'songchp@puyuan.com', '123456', '1112', '宋成平');
