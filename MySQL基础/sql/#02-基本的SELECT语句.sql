#02-基本的SELECT语句

USE temp; #使用指定的数据库

#1. 基本使用
SELECT employee_id,last_name,EMAIL 
FROM employees;

SELECT department_id,manager_id,location_id
FROM departments;

SELECT * # * : 代表所有的字段
FROM employees;


SELECT * 
FROM countries;

#2. 列的别名
#as : alias，可以加也可以不加
#可以使用一对""，给列起别名
#可以使用一个空格，给列起别名
#mysql可以使用单引号表示别名，oracle报错
SELECT employee_id emp_id,last_name AS lname,salary "monthly salary"
FROM employees;

#3. 去除重复行
SELECT DISTINCT department_id
FROM employees;

#如下操作是错误的
#两列数据不对应，去除重复项报错
SELECT  employee_id, DISTINCT department_id
FROM employees;

#4. 空值问题
#空值，表示没有赋值，理解为null。
#空值参与运算的问题：结果也为空。 
#空值，不等同于0,'','null'
SELECT employee_id,commission_pct,salary,salary * (1 + commission_pct),
salary * (1 + IFNULL(commission_pct,0)) "real_salary"
FROM employees;

#5. 显示表结构
DESC employees;

DESCRIBE employees;


