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

#3.in(set):
SELECT employee_id,department_id
FROM employees
#where department_id = 30 or department_id = 40 or department_id = 50;
WHERE department_id IN (30,40,50);

#4.like:模糊查询
#精准查询
SELECT employee_id,last_name
FROM employees
#where last_name = 'King';-- 字符串需要一对单引号来表示 
WHERE hire_date = '1993-01-13'; -- 日期类型需要使用一对单引号来表示

#模糊查询姓名中包含‘a'的员工
#% 表示0、1、多个字符-通配符
SELECT employee_id,last_name
FROM employees
WHERE last_name LIKE '%a%';


#查询姓名中包含字符’a‘且包含字符’e'的员工

#方式一
SELECT employee_id,last_name
FROM employees
#where last_name like'%a%e%' or last_name LIKE '%e%a%';
#方式二
WHERE last_name LIKE'%a%' AND last_name LIKE '%e%';

#查询姓名中第二个字符是a的员工
#_ 表示一个不确定的字符
SELECT employee_id,last_name
FROM employees
WHERE last_name LIKE'__a%';

#查询姓名中第二个字符是_且第三个字符是a的员工

SELECT employee_id,last_name
FROM employees
#WHERE last_name LIKE'_\_a%';#转义字符：\
WHERE last_name LIKE'_#_a%' ESCAPE '#'; -- 把#定义为转义字符

#5.is null：为空值
SELECT last_name,commission_pct
FROM employees
#where commission_pct is null;
#where !(commission_pct is null);
WHERE commission_pct IS NOT NULL -- 不为空


#6.逻辑异或 XOR:或且非
SELECT last_name,department_id,salary
FROM employees
WHERE department_id IN (10,20) XOR salary > 8000;

#6.算数运算符
SELECT last_name,department_id,salary
FROM employees
WHERE department_id MOD 20 = 0;



