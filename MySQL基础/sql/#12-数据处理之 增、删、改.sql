#12-数据处理之 增、删、改

#1.增/添加：INSERT

#方式一：一条一条的添加
DESC emp1;

SELECT *
FROM emp1;

INSERT INTO emp1
VALUES(1,'Tom','tom@126.com',3000,CURDATE());

INSERT INTO emp1
VALUES(2,'Tom1','tom1@126.com',NULL,CURDATE());

#进化一步：
INSERT INTO emp1(id,last_name,salary,hire_date,email)
VALUES(3,'Tom2',5000,'2000-10-12','tom2@126.com');
#没有声明的字段，在添加操作之后，值为null
INSERT INTO emp1(id,last_name,email)
VALUES(3,'Tom3','tom3@126.com');

#方式二：基于现有的表

INSERT INTO emp1(id,last_name)
SELECT employee_id,last_name
FROM employees
WHERE department_id IN (10,20,30)

SELECT *
FROM emp1;

DESC emp1;
DESC employees;

#2.删除数据:delete from 。。。 where。。。
DELETE FROM emp1
WHERE id = 1;

#3.修改数据：update。。。set。。。where。。。

UPDATE emp1
SET salary = 6000
WHERE id = 200;

SELECT *
FROM emp1;

UPDATE emp1
SET salary = 8000,hire_date = CURDATE()
WHERE id = 200;
















