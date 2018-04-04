/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50621
Source Host           : 192.168.3.200:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-04-01 00:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_event
-- ----------------------------
DROP TABLE IF EXISTS `t_event`;
CREATE TABLE `t_event` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `event_type` tinyint(2) NOT NULL COMMENT '事件类型 0:大姨妈来 1:大姨妈走 99:其他',
  `correct_scale` decimal(3,2) DEFAULT '1.00' COMMENT '准确度 百分比 eg:0.25',
  `predict_type` tinyint(1) DEFAULT '0' COMMENT '0:真实数据 1:预测数据',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_event
-- ----------------------------
INSERT INTO `t_event` VALUES ('1', '2017-11-05 21:00:00', '1', '1.00', '0', '2018-03-18 10:32:28');
INSERT INTO `t_event` VALUES ('2', '2017-11-09 22:00:00', '2', '0.25', '0', '2018-03-18 10:45:00');
INSERT INTO `t_event` VALUES ('3', '2018-01-19 08:00:00', '1', '1.00', '0', '2018-03-18 10:57:18');
INSERT INTO `t_event` VALUES ('4', '2018-01-23 08:00:00', '2', '1.00', '0', '2018-03-18 10:57:39');
INSERT INTO `t_event` VALUES ('5', '2018-02-19 16:00:00', '1', '1.00', '0', '2018-03-18 10:58:24');
INSERT INTO `t_event` VALUES ('6', '2018-02-23 10:58:44', '2', '1.00', '0', '2018-03-18 10:58:39');
INSERT INTO `t_event` VALUES ('7', '2017-12-11 11:09:42', '1', '0.25', '0', '2018-03-18 11:10:03');
INSERT INTO `t_event` VALUES ('8', '2017-12-17 11:11:14', '2', '0.25', '0', '2018-03-18 11:12:43');
