CREATE TABLE `new_table` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `LoginV` varchar(45) NOT NULL,
                           `PasswordV` varchar(45) NOT NULL,
                           `Data_OLD` time DEFAULT '00:00:00',
                           `Person` varchar(45) DEFAULT '0',
                           `Years` varchar(480000) DEFAULT '0',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `Login_UNIQUE` (`LoginV`)
) ENGINE=InnoDB AUTO_INCREMENT=8011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci