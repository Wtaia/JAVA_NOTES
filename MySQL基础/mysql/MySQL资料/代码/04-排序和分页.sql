#04-排序和分页

#1. 排序
# 1.1 
#按照员工的工资从高到低排序
# desc: descend,降序
# asc : ascend,升序
SELECT employee_id,salary
FROM employees
#order by salary desc; #降序
#order by salary asc; #升序
ORDER BY salary ;#如果没有显式指名asc或desc，则默认升序排列

# 1.2 使用列的别名进行排序
#别名可以在order by中使用
SELECT employee_id,last_name,salary sal
FROM employees
ORDER BY sal;

#不能在过滤条件中使用列的别名。
#如下操作报错：
SELECT employee_id,last_name,salary sal
FROM employees
WHERE sal >= 6000;


#order by要声明在where的后面
SELECT employee_id,last_name,salary sal
FROM employees
WHERE salary > 5000
ORDER BY last_name ASC; 


#1.3 二级排序
SELECT employee_id,last_name,department_id,salary
FROM employees
ORDER BY department_id,salary DESC;

#2. 分页
#每页显示20条记录，显示第1页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 0,20;


#每页显示20条记录，显示第2页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 20,20;

#每页显示20条记录，显示第3页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 40,20;

#每页显示pageSize条记录，显示第pageNo页数据：
#limit (pageNo - 1) * pageSize,pageSize

#查询工资最高的20个员工信息:top-N
SELECT employee_id,last_name,salary
FROM employees
ORDER BY salary DESC
LIMIT 0,20; #limit 要声明在order by的后面
