CREATE TABLE `bill_detail`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `bill_id`     bigint       NOT NULL,
    `create_user` varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



CREATE TABLE `bill_detail_ext`
(
    `id`      bigint       NOT NULL AUTO_INCREMENT,
    `bill_id` bigint       NOT NULL,
    `key`     varchar(128) NOT NULL,
    `value`   varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

