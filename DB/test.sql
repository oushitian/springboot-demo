/*
Navicat MySQL Data Transfer

Source Server         : 172.28.2.19
Source Server Version : 50719
Source Host           : 172.28.2.19:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-09-19 19:50:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `state` tinyint(2) NOT NULL COMMENT '0可用1禁用',
  `permission_name` varchar(255) NOT NULL COMMENT '资源名称',
  `parent_id` int(11) NOT NULL COMMENT '父id',
  `permission` varchar(255) NOT NULL COMMENT '资源权限串',
  `resource_type` varchar(50) NOT NULL COMMENT '资源类型',
  `url` varchar(255) NOT NULL COMMENT '路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '用户管理', '0', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `permission` VALUES ('2', '0', '用户添加', '1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `permission` VALUES ('3', '0', '用户删除', '1', 'userInfo:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `state` tinyint(2) NOT NULL COMMENT '0可用1禁用',
  `description` varchar(255) NOT NULL COMMENT '描述',
  `role` varchar(50) NOT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '0', '管理员', 'admin');
INSERT INTO `role` VALUES ('2', '0', 'VIP会员', 'vip');
INSERT INTO `role` VALUES ('3', '1', 'test', 'test');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色外键',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '1');
INSERT INTO `role_permission` VALUES ('3', '3', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `name` varchar(255) NOT NULL COMMENT '用户姓名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '密码的盐值',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0可用1禁用',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '管理员', 'e10adc3949ba59abbe56e057f20f883e', 'a66abb5684c45962d887564f08346e8d', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
