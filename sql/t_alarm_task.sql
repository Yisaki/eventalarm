/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50621
Source Host           : 192.168.3.200:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-04-01 00:51:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_alarm_task
-- ----------------------------
DROP TABLE IF EXISTS `t_alarm_task`;
CREATE TABLE `t_alarm_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alarm_time` datetime NOT NULL COMMENT '告警日期',
  `alarm_fix` int(11) DEFAULT '0' COMMENT '提前小时数',
  `alarm_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `alarm_count` tinyint(2) DEFAULT '0' COMMENT '告警次数',
  `status` tinyint(1) DEFAULT '2' COMMENT '状态 0:失败 1:成功 2:未执行',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_alarm_target_id` int(11) DEFAULT NULL COMMENT '外键 关联告警目标表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_alarm_task
-- ----------------------------
INSERT INTO `t_alarm_task` VALUES ('1', '2018-04-07 00:00:00', '3', '玲萍生日', '0', '2', '2018-03-31 17:47:19', '1');
