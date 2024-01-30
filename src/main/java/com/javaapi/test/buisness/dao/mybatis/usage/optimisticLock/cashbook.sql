-- test.cash_book definition

CREATE TABLE `cash_book` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `account_id` bigint NOT NULL DEFAULT '0',
                             `balance` int NOT NULL DEFAULT '0',
                             `version` int NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;