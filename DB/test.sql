/*
Navicat MySQL Data Transfer

Source Server         : 172.28.2.19
Source Server Version : 50719
Source Host           : 172.28.2.19:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-09-21 16:59:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for om_menu
-- ----------------------------
DROP TABLE IF EXISTS `om_menu`;
CREATE TABLE `om_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) NOT NULL COMMENT '上一级菜单id',
  `menu_text` varchar(256) NOT NULL COMMENT '菜单文本',
  `menu_url` varchar(256) NOT NULL COMMENT '菜单url',
  `permis_id` int(11) NOT NULL COMMENT '权限id',
  `enable_flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '启用标示,1、启用，2、禁用',
  `icon` varchar(50) DEFAULT NULL,
  `menu_order` int(11) NOT NULL DEFAULT '0' COMMENT '菜单顺序. 通常一级菜单才需要设置',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of om_menu
-- ----------------------------
INSERT INTO `om_menu` VALUES ('1', '0', '人事部', 'menu/personnel_department', '1', '1', 'icon-sys', '1', '2018-09-21 14:10:03', '2018-09-21 16:08:23');
INSERT INTO `om_menu` VALUES ('2', '0', '财务部', 'menu/accounting_department', '2', '1', 'icon-sys', '2', '2018-09-21 14:10:03', '2018-09-21 16:20:32');
INSERT INTO `om_menu` VALUES ('3', '0', '行政部', 'menu/administrative_department', '3', '1', 'icon-sys', '3', '2018-09-21 14:10:03', '2018-09-21 16:20:33');
INSERT INTO `om_menu` VALUES ('4', '0', '运维部', 'menu/operation_department', '4', '1', 'icon-sys', '4', '2018-09-21 14:10:04', '2018-09-21 16:20:34');
INSERT INTO `om_menu` VALUES ('5', '0', '测试部', 'menu/test_department', '5', '1', 'icon-sys', '5', '2018-09-21 14:10:04', '2018-09-21 16:20:35');
INSERT INTO `om_menu` VALUES ('6', '0', '市场部', 'menu/marketing_department', '6', '1', 'icon-sys', '6', '2018-09-21 14:10:04', '2018-09-21 16:20:36');
INSERT INTO `om_menu` VALUES ('7', '1', '人事考勤', 'menu/person_kaoqin', '7', '1', 'icon-users', '1', '2018-09-21 15:41:07', '2018-09-21 16:08:38');

-- ----------------------------
-- Table structure for om_permis
-- ----------------------------
DROP TABLE IF EXISTS `om_permis`;
CREATE TABLE `om_permis` (
  `permis_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `parent_permis_id` int(11) NOT NULL,
  `permis_name` varchar(80) NOT NULL COMMENT '权限名称',
  `menu_permis_flag` tinyint(4) NOT NULL COMMENT '1:菜单权限\n2:功能权限',
  `permis_code` varchar(100) NOT NULL COMMENT '权限code',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `permis_order` int(11) NOT NULL DEFAULT '0' COMMENT '权限顺序, 通常一级权限才需要设置',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`permis_id`),
  UNIQUE KEY `permis_code_UNIQUE` (`permis_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of om_permis
-- ----------------------------
INSERT INTO `om_permis` VALUES ('1', '0', '人事部', '1', 'personnel_department', '', '1', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('2', '0', '财务部', '1', 'accounting_department', '', '2', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('3', '0', '行政部', '1', 'administrative_department', '', '3', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('4', '0', '运维部', '1', 'operation_department', '', '4', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('5', '0', '测试部', '1', 'test_department', '', '5', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('6', '0', '市场部', '1', 'marketing_department', '', '6', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_permis` VALUES ('7', '1', '人事考勤', '1', 'person_kaoqin', '', '1', '2018-09-21 15:40:36', '2018-09-21 15:40:40');

-- ----------------------------
-- Table structure for om_role
-- ----------------------------
DROP TABLE IF EXISTS `om_role`;
CREATE TABLE `om_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_code` varchar(20) NOT NULL COMMENT '角色code',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `type` tinyint(4) NOT NULL COMMENT '1、系统管理员\n2、一般运营角色',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of om_role
-- ----------------------------
INSERT INTO `om_role` VALUES ('1', 'super_admin_role', '超级管理员权限', '超级管理员权限', '1', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_role` VALUES ('2', 'middle_admin_role', '中级管理员权限', '中级管理员权限', '1', '2018-09-21 12:20:09', '2018-09-21 12:20:09');
INSERT INTO `om_role` VALUES ('3', 'common_admin_role', '普通管理员权限', '普通管理员权限', '1', '2018-09-21 12:20:09', '2018-09-21 12:20:09');

-- ----------------------------
-- Table structure for om_user
-- ----------------------------
DROP TABLE IF EXISTS `om_user`;
CREATE TABLE `om_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NOT NULL COMMENT '用户状态：1、启用，2、禁用\n',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of om_user
-- ----------------------------
INSERT INTO `om_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '10000000000', '1', '超级管理员', '2018-09-21 12:20:08', '2018-09-21 12:43:50');
INSERT INTO `om_user` VALUES ('2', 'middle_admin', 'e10adc3949ba59abbe56e057f20f883e', '20000000000', '1', '中级管理员', '2018-09-21 12:20:08', '2018-09-21 12:20:08');
INSERT INTO `om_user` VALUES ('3', 'common_admin', 'e10adc3949ba59abbe56e057f20f883e', '30000000000', '1', '普通管理员', '2018-09-21 12:20:09', '2018-09-21 12:20:09');

-- ----------------------------
-- Table structure for role_permis
-- ----------------------------
DROP TABLE IF EXISTS `role_permis`;
CREATE TABLE `role_permis` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permis_id` int(11) NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_permis_UNIQUE` (`role_id`,`permis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of role_permis
-- ----------------------------
INSERT INTO `role_permis` VALUES ('1', '1', '1', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('2', '1', '2', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('3', '1', '3', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('4', '1', '4', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('5', '1', '5', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('6', '1', '6', '2018-09-21 14:11:32', '2018-09-21 14:11:32');
INSERT INTO `role_permis` VALUES ('7', '2', '3', '2018-09-21 14:11:36', '2018-09-21 14:11:36');
INSERT INTO `role_permis` VALUES ('8', '2', '4', '2018-09-21 14:11:36', '2018-09-21 14:11:36');
INSERT INTO `role_permis` VALUES ('9', '2', '5', '2018-09-21 14:11:36', '2018-09-21 14:11:36');
INSERT INTO `role_permis` VALUES ('10', '2', '6', '2018-09-21 14:11:36', '2018-09-21 14:11:36');
INSERT INTO `role_permis` VALUES ('11', '3', '4', '2018-09-21 14:11:40', '2018-09-21 14:11:40');
INSERT INTO `role_permis` VALUES ('12', '3', '5', '2018-09-21 14:11:40', '2018-09-21 14:11:40');
INSERT INTO `role_permis` VALUES ('13', '1', '7', '2018-09-21 15:44:26', '2018-09-21 15:44:29');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_user_UNIQUE` (`role_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2018-09-21 14:11:43', '2018-09-21 14:11:43');
INSERT INTO `user_role` VALUES ('2', '2', '2', '2018-09-21 14:11:43', '2018-09-21 14:11:43');
INSERT INTO `user_role` VALUES ('3', '3', '3', '2018-09-21 14:11:43', '2018-09-21 14:11:43');
