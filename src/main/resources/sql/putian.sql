/*
 Navicat Premium Data Transfer

 Source Server         : LocalCRM
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost
 Source Database       : putian

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : utf-8

 Date: 06/03/2016 12:52:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_putian`
-- ----------------------------
DROP TABLE IF EXISTS `t_putian`;
CREATE TABLE `t_putian` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `pt_Name` varchar(100) DEFAULT NULL COMMENT '医院名称',
  `pt_city` varchar(20) DEFAULT NULL COMMENT '所在城市',
  `pt_Addree` varchar(300) DEFAULT NULL COMMENT '医院地址',
  `pt_Phone` varchar(36) DEFAULT NULL COMMENT '电话',
  `pt_WebUrl` varchar(100) DEFAULT NULL COMMENT '网站',
  `pt_contacts` varchar(30) DEFAULT NULL COMMENT '联系人',
  `pt_conPhoe` varchar(36) DEFAULT NULL COMMENT '联系人电话',
  `pt_Comment` text COMMENT '备注',
  `pt_State` char(1) DEFAULT NULL COMMENT '数据状态 0：无效，1：有效',
  `pt_CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
