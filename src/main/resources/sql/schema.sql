CREATE TABLE IF NOT EXISTS `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(100) NULL DEFAULT NULL COMMENT '从授权服务器拉取的用户名',
  `at_id` varchar(255) NULL DEFAULT NULL COMMENT '用户设定的系统内At的ID',
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `t_auth_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_server_name` varchar(150) NOT NULL COMMENT 'oauth2的来源服务名',
  `auth_user_id` varchar(150) NOT NULL COMMENT 'oauth2来源的用户唯一ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '系统内的用户id',
  `access_token` varchar(255)  NULL DEFAULT NULL,
  `expired_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);