CREATE TABLE `young`.`correct_use_index_2` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `career` varchar(32) NOT NULL,
   `first_name`  varchar(16) NOT NULL,
   `last_name`  varchar(16) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (1, 'engineer', 'qinyi', 'abcdefg');
INSERT INTO `correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (2, 'engineer', 'qinyi', 'abxyzbdf');
INSERT INTO `correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (3, 'engineer', 'qinyi', 'aerefgdgfd');
INSERT INTO `correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (4, 'engineer', 'qinyi', 'abpoijhyg');
INSERT INTO `correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (5, 'engineer', 'qinyi', 'acqasdwqer');

-- 索引选择性(没有必要为索引选择性较低的列创建索引)
select count(distinct(career))/count(*) from correct_use_index_2;

-- 想要通过 name 去查询记录, 可以考虑创建 first_name 索引, 或 first_name、last_name 联合索引 --> 看一看索引选择性
select * from correct_use_index_2 where first_name = '' and last_name = '';

-- first name 选择性较低
select count(DISTINCT(first_name))/count(*) from correct_use_index_2;
-- last name 选择性较高
select count(DISTINCT(last_name))/count(*) from correct_use_index_2;

-- 但考虑用name 查询记录 可使用 first_name 和 last_name 组成的联合索引 -> 查看联合索引唯一性

-- 选择性高 但索引长
select count(DISTINCT(CONCAT(first_name, last_name)))/count(*) from correct_use_index_2;

select count(DISTINCT(CONCAT(first_name, left(last_name, 1))))/count(*) from correct_use_index_2;

select count(DISTINCT(CONCAT(first_name, left(last_name, 2))))/count(*) from correct_use_index_2;

-- first_name, last_name 创建联合索引占据的空间会过大, 需要考虑兼顾长度和选择性
select count(DISTINCT(CONCAT(first_name, left(last_name, 3))))/count(*) from correct_use_index_2;

ALTER TABLE correct_use_index_2 ADD INDEX `idx_first_last_name_3` (first_name, last_name(3));
show index from correct_use_index_2;