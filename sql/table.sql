CREATE TABLE `identification` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `user_id` char(15) NOT NULL,
   `status` tinyint NOT NULL,
   `username` varchar(50) NOT NULL,
   `password` varchar(512) NOT NULL,
   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `username_UNIQUE` (`username`),
   UNIQUE KEY `user_id_UNIQUE` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3