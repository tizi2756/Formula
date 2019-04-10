/*
Navicat MySQL Data Transfer

Source Server         : mybd
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : mathproject

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-04-10 22:23:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '3', '3');
INSERT INTO `score` VALUES ('1', '3', '3');
INSERT INTO `score` VALUES ('4', null, null);
INSERT INTO `score` VALUES ('1', '100', '3');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '100', '3');
INSERT INTO `score` VALUES ('1', '100', '2');
INSERT INTO `score` VALUES ('1', '100', '2');
INSERT INTO `score` VALUES ('5', null, null);
INSERT INTO `score` VALUES ('1', '100', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '50', '2');
INSERT INTO `score` VALUES ('1', '100', '2');
INSERT INTO `score` VALUES ('1', '0', '2');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1236', '111', '17610891910');
INSERT INTO `student` VALUES ('3', '33', '33', '17610891910');
INSERT INTO `student` VALUES ('4', '66', '66', '13011047699');
INSERT INTO `student` VALUES ('5', '5555', '555', '17610891910');
