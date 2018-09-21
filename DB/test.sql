-- -----------------------------------------------------
-- 用户表  用户角色权限多对多,权限菜单一对一
-- -----------------------------------------------------
CREATE TABLE `om_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `user_name` VARCHAR(50) NULL COMMENT '员工姓名',
  `password` VARCHAR(100) NULL COMMENT '登录密码',
  `mobile` VARCHAR(20) NULL COMMENT '手机号',
  `status` TINYINT NOT NULL COMMENT '用户状态：1、启用，2、禁用\n',
  `remark` VARCHAR(500) NULL DEFAULT '' COMMENT '备注',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`))
   ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '用户表';


-- -----------------------------------------------------
-- 角色表
-- -----------------------------------------------------
CREATE TABLE  `om_role` (
  `role_id` INT NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_code` VARCHAR(20) NOT NULL COMMENT '角色code',
  `role_name` VARCHAR(30) NOT NULL COMMENT '角色名称',
  `remark` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '备注',
  `type` TINYINT NOT NULL COMMENT '1、系统管理员\n2、一般运营角色',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '角色表';


-- -----------------------------------------------------
-- 权限表
-- -----------------------------------------------------
CREATE TABLE  `om_permis` (
  `permis_id` INT NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `parent_permis_id` INT NOT NULL,
  `permis_name` VARCHAR(80) NOT NULL COMMENT '权限名称',
  `menu_permis_flag` TINYINT NOT NULL COMMENT '1:菜单权限\n2:功能权限',
  `permis_code` VARCHAR(100) NOT NULL COMMENT '权限code',
  `remark` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '备注',
  `permis_order` INT NOT NULL DEFAULT 0 COMMENT '权限顺序, 通常一级权限才需要设置',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`permis_id`),
  UNIQUE INDEX `permis_code_UNIQUE` (`permis_code` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '权限表';


-- -----------------------------------------------------
-- 角色-权限表
-- -----------------------------------------------------
CREATE TABLE  `role_permis` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` INT NOT NULL COMMENT '角色id',
  `permis_id` INT NOT NULL COMMENT '权限id',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_permis_UNIQUE` (`role_id`, `permis_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '角色权限关联表';


-- -----------------------------------------------------
-- 用户角色关联表
-- -----------------------------------------------------
CREATE TABLE  `user_role` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` INT NOT NULL COMMENT '角色id',
  `user_id` INT NOT NULL COMMENT '用户id',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_user_UNIQUE`  (`role_id`, `user_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '用户角色关联表';


-- -----------------------------------------------------
-- Table `om_menu`
-- -----------------------------------------------------
CREATE TABLE  `om_menu` (
  `menu_id` INT NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` INT NOT NULL COMMENT '上一级菜单id',
  `menu_text` VARCHAR(256) NOT NULL COMMENT '菜单文本',
  `menu_url` VARCHAR(256) NOT NULL COMMENT '菜单url',
  `permis_id` INT NOT NULL COMMENT '权限id',
  `enable_flag` TINYINT NOT NULL DEFAULT 1 COMMENT '启用标示,1、启用，2、禁用',
  `menu_order` INT NOT NULL DEFAULT 0 COMMENT '菜单顺序. 通常一级菜单才需要设置',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '菜单表';
  
insert into om_user (user_name, password, mobile, status, remark, create_time) values ('super_admin', 'e10adc3949ba59abbe56e057f20f883e', '10000000000', 1, '超级管理员', now());
insert into om_user (user_name, password, mobile, status, remark, create_time) values ('middle_admin', 'e10adc3949ba59abbe56e057f20f883e', '20000000000', 1, '中级管理员', now());
insert into om_user (user_name, password, mobile, status, remark, create_time) values ('common_admin', 'e10adc3949ba59abbe56e057f20f883e', '30000000000', 1, '普通管理员', now());


insert into om_role (role_code, role_name, remark, type, create_time) values ('super_admin_role', '超级管理员权限', '超级管理员权限', 1, now());
insert into om_role (role_code, role_name, remark, type, create_time) values ('middle_admin_role', '中级管理员权限', '中级管理员权限', 1, now());
insert into om_role (role_code, role_name, remark, type, create_time) values ('common_admin_role', '普通管理员权限', '普通管理员权限', 1, now());


insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '人事部', 1, 'personnel_department', '', 1, now());
insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '财务部', 1, 'accounting_department', '', 2, now());
insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '行政部', 1, 'administrative_department', '', 3, now());
insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '运维部', 1, 'operation_department', '', 4, now());
insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '测试部', 1, 'test_department', '', 5, now());
insert into om_permis (parent_permis_id, permis_name, menu_permis_flag, permis_code, remark, permis_order, create_time) values (0, '市场部', 1, 'marketing_department', '', 6, now());


--超级管理员拥有所有的权限
insert into role_permis (role_id, permis_id, create_time) values (1, 1, now());
insert into role_permis (role_id, permis_id, create_time) values (1, 2, now());
insert into role_permis (role_id, permis_id, create_time) values (1, 3, now());
insert into role_permis (role_id, permis_id, create_time) values (1, 4, now());
insert into role_permis (role_id, permis_id, create_time) values (1, 5, now());
insert into role_permis (role_id, permis_id, create_time) values (1, 6, now());

--中级管理员拥有的权限
insert into role_permis (role_id, permis_id, create_time) values (2, 3, now());
insert into role_permis (role_id, permis_id, create_time) values (2, 4, now());
insert into role_permis (role_id, permis_id, create_time) values (2, 5, now());
insert into role_permis (role_id, permis_id, create_time) values (2, 6, now());

--普通管理员拥有的权限
insert into role_permis (role_id, permis_id, create_time) values (3, 4, now());
insert into role_permis (role_id, permis_id, create_time) values (3, 5, now());


--给用户分配角色
insert into user_role (role_id, user_id, create_time) values (1, 1, now());
insert into user_role (role_id, user_id, create_time) values (2, 2, now());
insert into user_role (role_id, user_id, create_time) values (3, 3, now());


insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '人事部', 'menu/personnel_department', 1, 1, 1, now());
insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '财务部', 'menu/accounting_department', 2, 1, 1, now());
insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '行政部', 'menu/administrative_department', 3, 1, 1, now());
insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '运维部', 'menu/operation_department', 4, 1, 1, now());
insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '测试部', 'menu/test_department', 5, 1, 1, now());
insert into om_menu (parent_id, menu_text, menu_url, permis_id, enable_flag, menu_order, create_time) values (0, '市场部', 'menu/marketing_department', 6, 1, 1, now());