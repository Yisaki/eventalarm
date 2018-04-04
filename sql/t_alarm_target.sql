/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50621
Source Host           : 192.168.3.200:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-04-01 00:51:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_alarm_target
-- ----------------------------
DROP TABLE IF EXISTS `t_alarm_target`;
CREATE TABLE `t_alarm_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `target` varchar(50) DEFAULT NULL COMMENT '目标地址',
  `target_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '目标类型 0:手机 1:邮箱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='告警目标表';

-- ----------------------------
-- Records of t_alarm_target
-- ----------------------------
INSERT INTO `t_alarm_target` VALUES ('1', '18566229031', '0', '2018-03-28 16:55:47');
