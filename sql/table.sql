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
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `role` (
    `id` int NOT NULL AUTO_INCREMENT,
    `status` tinyint NOT NULL,
    `name` varchar(50) NOT NULL,
    `description` varchar(512) NOT NULL,
    `permission_id_list` varchar(1024) NOT NULL,
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user_role_rel` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `status` tinyint NOT NULL,
    `user_id` char(15) NOT NULL,
    `role_id` int NOT NULL,
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `permission` (
    `id` int NOT NULL AUTO_INCREMENT,
    `status` tinyint NOT NULL,
    `name` varchar(50) NOT NULL,
    `description` varchar(512) NOT NULL,
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
    `id` char(15) NOT NULL,
    `status` tinyint NOT NULL,
    `nickname` varchar(50) NOT NULL,
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `access_token` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `user_id` char(15) DEFAULT NULL,
   `status` tinyint NOT NULL,
   `access_token` char(32) NOT NULL,
   `permissions` varchar(1024) NOT NULL,
   `expires_at` datetime NOT NULL,
   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `token_unique` (`access_token`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
