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

 Date: 28/06/2019 10:50:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_auth_record
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_record`;
CREATE TABLE `t_auth_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_server_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'oauth2的来源服务名',
  `auth_user_id` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'oauth2来源的用户唯一ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '系统内的用户id',
  `accesss_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `expired_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = Aria CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Page;

SET FOREIGN_KEY_CHECKS = 1;
