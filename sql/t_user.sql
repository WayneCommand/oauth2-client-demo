/*
 Navicat MySQL Data Transfer

 Source Server         : 10.68.165.163_mariadb_3306
 Source Server Type    : MariaDB
 Source Server Version : 100406
 Source Host           : 10.68.165.163:3306
 Source Schema         : oauth_client_demo

 Target Server Type    : MariaDB
 Target Server Version : 100406
 File Encoding         : 65001

 Date: 28/06/2019 10:52:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '从授权服务器拉取的用户名',
  `at_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户设定的系统内At的ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = Aria CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Page;

SET FOREIGN_KEY_CHECKS = 1;
