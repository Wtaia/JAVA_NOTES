#04-排序和分页

#1.排序
#1.1
#按照员工的工资从高到低
#order by 按照。。排序
#desc：descend，降序
#asc：asend，升序
SELECT employee_id,salary
FROM employees
ORDER BY salary DESC;-- 降序
#order by salary -- 默认升序
#order by salary asc -- 升序

#1.2使用列的别名进行排序
#别名可以在order by中使用
SELECT employee_id,last_name,salary AS sal
FROM employees
ORDER BY sal DESC;

#不能在过滤条件中使用列的别名
#如下操作会报错
SELECT employee_id,last_name,salary AS sal
FROM employees
WHERE sal > 6000;

#where要紧跟在from后面，要求order by要声明在where之后
SELECT employee_id,last_name,salary AS sal
FROM employees
WHERE salary > 5000
ORDER BY last_name ASC;#字符串排序按照首字母


#1.3二级排序
#先按照department_id排序，再按照salary从高到低排序
SELECT employee_id,last_name,department_id,salary
FROM employees
ORDER BY department_id,salary DESC;


#2.分页
#每页显示20行，显示第1页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 0,20;
#每页显示20行，显示第2页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 20,20;
#每页显示20行，显示第3页数据：
SELECT employee_id,last_name,salary
FROM employees
LIMIT 40,20;
#每页显示pagesSize条数据，显示第pageNo页数据：
#Limit (pageNo - 1) * pageSize,pageSize

#查询工资最高的20个员工的信息:top-N
SELECT employee_id,last_name,salary
FROM employees
ORDER BY salary DESC
LIMIT 0,20;#limit 要声明在order by之后

























