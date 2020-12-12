/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : yh3

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-12-05 12:53:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `money` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小尚', '700');
INSERT INTO `user` VALUES ('2', '小杨', '1300');
