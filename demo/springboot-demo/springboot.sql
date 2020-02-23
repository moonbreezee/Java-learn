CREATE DATABASE springboot_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE TABLE `springboot_demo`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` VARCHAR(50) NULL COMMENT '昵称',
  `mobile` VARCHAR(20) NULL COMMENT '手机号',
  `password` CHAR(60) NULL COMMENT '密码hash值',
  `role` VARCHAR(100) NULL DEFAULT 'user' COMMENT '角色，角色名以逗号分隔',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC))
COMMENT = '用户表';

INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc1', '13512345678', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc2', '13512345677', '123');
-- 运行sql插入多条数据
-- mysql -h localhost -u root -p
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc3', '13512345603', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc4', '13512345604', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc5', '13512345605', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc6', '13512345606', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc7', '13512345607', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc8', '13512345608', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc9', '13512345609', '123');
INSERT INTO `springboot_demo`.`user` (`nickname`, `mobile`, `password`) VALUES ('abc10', '13512345610', '123');

