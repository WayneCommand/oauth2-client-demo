DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int(11) NOT NULL,
                           `nickname` varchar(100) NULL DEFAULT NULL,
                           `at_id` varchar(255) NULL DEFAULT NULL ,
                           PRIMARY KEY (`id`)
);