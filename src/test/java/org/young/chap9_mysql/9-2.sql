CREATE TABLE `young`.`suitable_data_type` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `name` varchar(32) NOT NULL,
                                              `gender` ENUM('male', 'female') NOT NULL,
                                              `grade` ENUM('0', '1', '2') NOT NULL,
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入一条正确的数据(枚举值都是自己定义的)
insert into `suitable_data_type` (`id`, `name`, `gender`, `grade`) values (1, 'young', 'male', '1');
insert into `suitable_data_type` (`name`, `gender`, `grade`) values ('cool', 'female', '2');
-- 如果插入的值不在枚举中，则会报错
insert into `suitable_data_type` (`id`, `name`, `gender`, `grade`) values (1, 'young', 'fmale', '3');

-- 查看枚举值对应的索引
-- male 索引1, female 索引2, grade, '1' 索引2, '2' 索引3
select name, gender + 0, grade + 0 from suitable_data_type;

-- 枚举使用聚合函数 sum() avg() 聚合函数参与计算的需要是整数类型,但此处枚举是字符串所以使用他的索引值
select avg(gender) from suitable_data_type;
select sum(gender) from suitable_data_type;

-- 枚举参与排序
-- enum类型存储的枚举值的内部索引，索引enum根据其索引进行排序
select * from suitable_data_type order by gender;
-- 将gender转换为char 则正常排序了
select * from suitable_data_type order by cast(gender as char);
-- 变更字符串也可正常排序
select * from suitable_data_type order by concat(gender);

-- 下面几条语句插入的数据是什么 ? (ENUM 字面量的处理)
-- grade类型是字符串,但插入的是整数类型的， 所以当作是索引2 那么值就是1
INSERT INTO `suitable_data_type`(`name`, `gender`, `grade`) VALUES ('young', 'male', 2);
-- 正常插入
INSERT INTO `suitable_data_type`(`name`, `gender`, `grade`) VALUES ('young', 'male', '2');
-- 插入时，先看值是否在索引中，如果不存在则将其转换成索引 此时索引3 对应的值为2 所以插入成功
INSERT INTO `suitable_data_type`(`name`, `gender`, `grade`) VALUES ('young', 'male', '3');
-- 插入失败
INSERT INTO `suitable_data_type`(`name`, `gender`, `grade`) VALUES ('young', 'male', '4');
