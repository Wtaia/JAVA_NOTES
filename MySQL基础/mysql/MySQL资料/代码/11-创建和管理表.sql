#11-创建和管理表 --DDL

#数据库对象：表、视图、存储过程、函数、触发器、同义词、索引等

# 1.创建库
CREATE DATABASE database0419;

SHOW DATABASES; #查看所有的数据库

# 2. 使用指定的数据库
USE database0419;

SHOW TABLES; #查看指定的库下包含哪些表

USE temp;

SHOW TABLES; 

SELECT *
FROM employees;

# 3. 删除库
DROP DATABASE database0419;

# 4. 创建表
# 方式一："白手起家"的方式
CREATE TABLE emp1(
id INT,
last_name VARCHAR(15),
email VARCHAR(25),
salary DOUBLE(10,2),
hire_date DATE
);

DESC emp1;

SELECT *
FROM emp1;

#方式二：基于现有的表，创建新的表
CREATE TABLE emp2
AS
SELECT employee_id,last_name,salary
FROM employees ;

DESC emp2;
DESC employees;
#说明：使用此种方式创建表时，还可以将原有表中的数据复制到新表中。
SELECT *
FROM emp2;
#如下结构中select中列的别名，就作为新创建的表的字段名
CREATE TABLE emp3
AS
SELECT employee_id emp_id,last_name,salary AS sal
FROM employees ;

#查询失败
SELECT employee_id
FROM emp3;


#练习1：复制employees表，包含所有数据
CREATE TABLE employees_copy 
AS
SELECT *
FROM employees;

SELECT *
FROM employees_copy;

SELECT *
FROM employees;

#练习2: 复制employees表，不包含任何数据
CREATE TABLE employees_copy_blank
AS
SELECT *
FROM employees
WHERE 1 = 2;

SELECT *
FROM employees_copy_blank;


# 5. 修改表
DESC emp3;

# 5.1 增加一个列
ALTER TABLE emp3
ADD email VARCHAR(25);

SELECT *
FROM emp3;

# 5.2 删除一个列
ALTER TABLE emp3
DROP email;

ALTER TABLE emp3
DROP COLUMN sal;

# 5.3 修改字段(类型、储值范围)
DESC emp3;

ALTER TABLE emp3
MODIFY last_name VARCHAR(30);

#通常不会修改字段的类型！！
#报错
ALTER TABLE emp3
MODIFY last_name INT;


# 5.4 重命名字段
DESC emp3;

ALTER TABLE emp3
CHANGE last_name lname VARCHAR(21);


# 6. 重命名表
RENAME TABLE emp3 TO myemp3;

SELECT *
FROM myemp3;

# 7. 删除表
DROP TABLE employees_copy;


# 8. 清空表: 清空表中的数据，但是表结构保留

SELECT *
FROM myemp3;

TRUNCATE TABLE myemp3;

/*
对比TRUNCATE TABLE 和 DELETE FROM ...
结论：TRUNCATE TABLE 一旦操作，就不可以回滚数据
      DETELE FROM  支持删除表中的所有数据，可以回滚数据

测试：COMMIT 与 ROLLBACK的使用
1. COMMIT:表示提交数据。数据一旦被提交，就不可回滚。
   ROLLBACK:表示回滚数据。 回滚操作，也只能回滚到最近的一次COMMIT之后。
   
2. 默认情况下，对数据表的操作(DDL、DML),都是在执行之后，默认提交数据的。

    要想测试TRUNCATE TABLE 和 DETELE FROM的区别，需要关闭默认提交的行为：
    SET autocommit = FALSE; 

*/

CREATE TABLE myemp
AS
SELECT *
FROM employees;

SELECT *
FROM myemp;

COMMIT;

#首先测试DELETE FROM 
SET autocommit = FALSE;

DELETE FROM myemp; #删除数据

SELECT *
FROM myemp;

ROLLBACK; #回滚数据

#接着测试TRUNCATE TABLE
COMMIT;

SET autocommit = FALSE;

TRUNCATE TABLE myemp; #清空表

SELECT *
FROM myemp;

#并没有将数据回滚成功
ROLLBACK; #回滚数据

#结论：以TRUNCATE TABLE为代表的DDL操作，都会在执行完以后，自动的COMMIT提交数据。
#   而且此提交行为不受SET autocommit = FALSE;的影响。所以，ROLLBACK行为对DDL操作都失效。


# 关于COMMIT、ROLLBACK涉及到数据库事务的操作