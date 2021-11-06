#03-过滤数据

#查询90号部门员工的信息
SELECT employee_id,last_name,salary,department_id
FROM employees

#1.使用where实现数据的过滤
#where必须紧跟在from子句的后面
WHERE department_id = 90;


SELECT employee_id,last_name,salary,department_id
FROM employees
#WHERE salary > 5000;
#<>表示不等于，相当于!=
WHERE department_id <> 90

#2.between...and...
#查询工资在6000 到 8000 之间的,包括6000和8000
SELECT employee_id,last_name,salary,department_id
FROM employees
WHERE salary BETWEEN 6000 AND 8000
#&& 和 AND 都表示与的关系
#where salary >=6000 && salary <=8000
#and前为下边界，之后为上边界
#where salary between 8000 and 6000


