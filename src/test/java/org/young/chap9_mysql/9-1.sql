CREATE TABLE `young`.`do_not_use_null` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `one` varchar(10) NOT NULL,
    `two` varchar(20) DEFAULT NULL,
    `three` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_one` (`one`),
    KEY `idx_two` (`two`),
    UNIQUE KEY `idx_three` (`three`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `young`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (1, '', 'a2', 'a3');
INSERT INTO `young`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (2, 'b1', NULL, 'b3');
INSERT INTO `young`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (3, 'c1', 'c2', NULL);
INSERT INTO `young`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (4, 'd1', 'd2', NULL);

SELECT * from do_not_use_null;

-- NULL的长度不是0
SELECT LENGTH(''), LENGTH(null), LENGTH(0), LENGTH('0');

-- NULL参与查询
-- 有null属性使用is null, is not null 来判断
SELECT * from do_not_use_null where two = null;
SELECT * from do_not_use_null where two != null;

SELECT * from do_not_use_null where two is null;
select * from do_not_use_null where two is not null;

-- null参与查询 two != 'xyz' 等价于 two != 'xyz' and two is not null
SELECT * from do_not_use_null where two != 'xyz';
SELECT * from do_not_use_null where two != 'xyz' and two is not null;

-- 对允许为null的列加上索引 mysql很难对索引优化
-- 以下没有使用到索引
desc select * from do_not_use_null where two != 'xyz';
-- is not null 也没有索引
explain select * from do_not_use_null where two is not null;
-- 只有该列 is null的时候,才会有索引
explain select * from do_not_use_null where two is null;

-- three列索引为唯一性索引,但three列还有插入了两个null,可以认为唯一性索引对null无效
select * from do_not_use_null;

-- null参与计算,结果都为null
select 1 + 2;
select 1 + null;
select CONCAT('x', null)

-- null参与聚合
-- count(*) 4
select count(*) from do_not_use_null dnun;
-- count(three) 结果为2 代表null 参与计算
select count(three) from do_not_use_null dnun;

-- null 参与排序
-- asc排序 null在最前
select * from do_not_use_null dnun order by three asc;
-- desc排序 null在最后
select * from do_not_use_null dnun order by three desc;