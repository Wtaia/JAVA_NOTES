#13-约束（constraint)

DESC employees;
/*
1. 约束，针对表中的数据，在添加、删除、修改的过程中，进行的限制。

2. 约束的分类:
角度一（从声明的位置上）：列级约束  vs 表级约束
角度二（从作用的列的数量上）：单列约束  vs 多列约束
角度三（从功能上区分）：
			not null :非空约束
			unique: 唯一性约束
			primary key:主键约束
			foreign key:外键约束
			check : 检查约束
			default : 默认值约束
		
3. 设置约束的时机：情况1：在CREATE TABLE 的同时，给表的字段添加上约束。
	           情况2：通过 ALTER TABLE 的方式添加、删除约束
*/

# 1. not null :非空约束
# 创建表的同时，添加约束
CREATE TABLE  emp3(
id INT NOT NULL,
last_name VARCHAR(15) NOT NULL,
email VARCHAR(25),
hire_date DATE
);

DESC emp3;
#添加成功
INSERT INTO emp3(id,last_name,email,hire_date)
VALUES(1,'Tom','tom@126.com',CURDATE());

SELECT * FROM emp3;

#添加失败
INSERT INTO emp3(last_name,email,hire_date)
VALUES('Tom','tom@126.com',CURDATE());

#添加失败
INSERT INTO emp3(id,last_name,email,hire_date)
VALUES(2,NULL,'tom@126.com',CURDATE());


#在ALTER TABLE时，删除非空约束
ALTER TABLE emp3
MODIFY last_name VARCHAR(15) NULL;

DESC emp3;

#添加成功
INSERT INTO emp3(id,last_name,email,hire_date)
VALUES(2,NULL,'tom@126.com',CURDATE());

SELECT *
FROM emp3;

#在ALTER TABLE时，添加非空约束
ALTER TABLE emp3
MODIFY hire_date DATE NOT NULL;

#2. unique: 唯一性约束
# 创建表的同时，添加约束
CREATE TABLE  emp4(
id INT UNIQUE, #列级约束
last_name VARCHAR(15),
email VARCHAR(25),
hire_date DATE,
#表级约束
CONSTRAINT emp4_email_uk UNIQUE(email)
);

DESC emp4;
#添加成功
INSERT INTO emp4(id,last_name,email,hire_date)
VALUES(1,'Tom','tom@126.com',CURDATE());

SELECT * FROM emp4;


#添加失败
INSERT INTO emp4(id,last_name,email,hire_date)
VALUES(1,'Tom','tom@126.com',CURDATE());


#添加失败
INSERT INTO emp4(id,last_name,email,hire_date)
VALUES(2,'Tom','tom@126.com',CURDATE());

#添加成功
INSERT INTO emp4(id,last_name,email,hire_date)
VALUES(2,'Tom1',NULL,CURDATE());

#添加成功
INSERT INTO emp4(id,last_name,email,hire_date)
VALUES(3,'Tom1',NULL,CURDATE());
#结论：声明为unique约束的字段，在添加或修改数据时，允许多次设置为null.

/*
在修改表的时候，如何删除约束？

1. 在创建唯一约束的时候，如果不给唯一约束名称，就默认和列名相同
2. MySQL会给唯一约束的列上默认创建一个唯一索引
3. 删除唯一约束只能通过删除唯一索引的方式删除
4. 删除时需要指定唯一索引名，唯一索引名就和唯一约束名一样。
5. 如果创建唯一约束时未指定名称，如果是单列，就默认和列名相同，如果是组合列，那么默认和()中排在第一个的列名相同。也可以自定义唯一性约束名。
*/

DESC emp4;
#删除索引，进而删除了唯一性约束
ALTER TABLE emp4
DROP INDEX emp4_email_uk;

ALTER TABLE emp4
DROP INDEX id;

#添加唯一性约束
ALTER TABLE emp4
ADD CONSTRAINT emp4_id_uk UNIQUE(id);

#3. primary key:主键约束
# 一个表中只能声明一个主键约束
# 主键约束，既满足唯一性，也满足非空性。
# 通过声明有主键约束的字段，可以确定表中的唯一的一条记录。
# 通常，在创建表的同时，都需要指名一个主键约束。

CREATE TABLE emp5(
id INT PRIMARY KEY, #列级约束
last_name VARCHAR(15),
email VARCHAR(25),
hire_date DATE,
salary DOUBLE(10,2)
);

DESC emp5;
#添加成功
INSERT INTO emp5(id,last_name,email,salary)
VALUES(1,'Tom','tom@126.com',2000);

SELECT *
FROM emp5;

#添加失败
INSERT INTO emp5(id,last_name,email,salary)
VALUES(1,'Tom','tom@126.com',2000);

#添加失败
INSERT INTO emp5(id,last_name,email,salary)
VALUES(NULL,'Tom','tom@126.com',2000);

#开发中常见的声明方式：
CREATE TABLE emp6(
id INT AUTO_INCREMENT,
last_name VARCHAR(15),
email VARCHAR(25),
hire_date DATE,
salary DOUBLE(10,2),
#表级约束
CONSTRAINT emp6_id_pk PRIMARY KEY(id)
);


INSERT INTO emp6(last_name,email,salary)
VALUES('Tom','tom@126.com',2000);

SELECT *
FROM emp6;

#如何删除主键
ALTER TABLE emp5
DROP PRIMARY KEY;

DESC emp5;

#添加主键约束
ALTER TABLE emp5
ADD CONSTRAINT emp5_id_pk PRIMARY KEY(id);


#4. foreign key:外键约束
#作用：在表A的字段a上声明有一个外键约束，与表B中的字段b相关联。则字段a在insert等操作时，
#     其赋的值一定是字段b中出现过的数据。

#要求：要想能关联成功，必须要求字段b声音有主键约束或唯一性约束

CREATE TABLE dept7(
dept_id INT,
dept_name VARCHAR(10)
);

#添加外键约束失败
CREATE TABLE emp7(
id INT,
last_name VARCHAR(15),
dept_id INT,

#声明外键:表级约束
CONSTRAINT emp7_dept_id_fk FOREIGN KEY(dept_id) REFERENCES dept7(dept_id)
);

#补救措施：
ALTER TABLE dept7
ADD CONSTRAINT dept7_dept_id_pk PRIMARY KEY(dept_id);

DESC dept7;

#添加外键约束成功
CREATE TABLE emp7(
id INT,
last_name VARCHAR(15),
dept_id INT,

#声明外键:表级约束
CONSTRAINT emp7_dept_id_fk FOREIGN KEY(dept_id) REFERENCES dept7(dept_id)
);
#添加失败
INSERT INTO emp7(id,last_name,dept_id)
VALUES(1,'Tom',10);

#
INSERT INTO dept7(dept_id,dept_name)
VALUES(10,'IT');

#添加成功
INSERT INTO emp7(id,last_name,dept_id)
VALUES(1,'Tom',10);

SELECT *
FROM emp7;

#结论：在实际开发中，不建议在创建表时使用外键约束。

#5. 检查约束(check)
# 对mysql失效

CREATE TABLE emp8(
id INT,
last_name VARCHAR(15),
salary DOUBLE(10,2) CHECK(salary > 3000)

);

DESC emp8;

INSERT INTO emp8
VALUES(1,'Tom',4000);
#添加成功
INSERT INTO emp8
VALUES(2,'Tom1',2000);

SELECT *
FROM emp8;

#6.默认值约束（default）

CREATE TABLE emp9(
id INT,
last_name VARCHAR(15),
salary DOUBLE(10,2) DEFAULT 2500

);

DESC emp9;

INSERT INTO emp9
VALUES(1,'Tom',5000);

INSERT INTO emp9(id,last_name)
VALUES(1,'Tom');

SELECT *
FROM emp9;