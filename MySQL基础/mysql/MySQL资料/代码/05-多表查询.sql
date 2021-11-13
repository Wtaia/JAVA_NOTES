#05-多表查询

#出现了笛卡尔积的错误
SELECT employee_id,last_name,department_name
FROM employees,departments; #查询出2889行数据

SELECT 2889/107
FROM DUAL;

SELECT *
FROM departments;


#正确的写法:多表的查询，一定要有连接条件
SELECT employee_id,last_name,department_name
FROM employees,departments
#多表的连接条件
WHERE employees.`department_id` = departments.`department_id`


#进一步：如果查询的字段在多个表中都出现，则一定需要指明来自于哪个表。比如：department_id
SELECT employee_id,last_name,department_name,departments.department_id
FROM employees,departments
WHERE employees.`department_id` = departments.`department_id`

#建议开发中多表查询中，查询的字段都指明来自于哪个表。--->sql优化
SELECT employees.employee_id,employees.last_name,departments.department_name,departments.department_id
FROM employees,departments
WHERE employees.`department_id` = departments.`department_id`

#表的别名的使用。一旦给表起了别名，就可以在select中或where中使用。
SELECT e.employee_id,e.last_name,d.department_name,d.department_id
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`

#需求：
SELECT e.employee_id,e.last_name,d.department_name,l.city
FROM employees e,departments d,locations l
#连接条件
WHERE e.department_id = d.department_id 
AND d.location_id = l.location_id;

#结论：如果实现n个表的多表查询，则至少需要n - 1个连接条件。 

##############################################
/*
多表查询的分类：
1. 等值连接  vs  不等值连接
2. 自连接    vs  非自连接
3. 内连接    vs  外连接

*/

#不等值连接
SELECT employee_id,salary,grade_level
FROM employees e,job_grades j
#where e.`salary` >= j.`lowest_sal` and e.`salary` <= j.`highest_sal`;
WHERE e.`salary` BETWEEN j.`lowest_sal` AND j.`highest_sal`;

#自连接
#查询员工的employee_id,last_name及其管理者的employee_id,last_name
SELECT emp.employee_id,emp.last_name,mgr.employee_id,mgr.last_name
FROM employees emp,employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;


########################################################
/*
内连接：合并具有同一列的两个以上的表的行, 结果集中不包含一个表与另一个表不匹配的行
外连接：分为左外连接 和 右外连接
   左外连接：两个表在连接过程中除了返回满足连接条件的行以外，还返回左表中不满足条件的行
              这种连接称为左外连接。
   右外连接：两个表在连接过程中除了返回满足连接条件的行以外，还返回右表中不满足条件的行
              这种连接称为右外连接。
*/
#内连接的例子：
SELECT employee_id,last_name,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`

# 要想实现外连接，需要使用sql-99语法中的相关结构。

####################################################

#sql-99语法实现内连接：举例1
SELECT employee_id,last_name,department_name
FROM employees e INNER JOIN departments d
ON e.`department_id` = d.`department_id`;
#举例2：
SELECT employee_id,last_name,department_name,city
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`;


#左外连接：
#需求：查询所有员工的employee_id,last_name,department_name
SELECT employee_id,last_name,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;


#右外连接：
SELECT employee_id,last_name,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;

#与上一个select是相同的需求。
SELECT employee_id,last_name,department_name
FROM departments d LEFT JOIN employees e
ON e.`department_id` = d.`department_id`;


# 满外连接：两个表在连接过程中除了返回满足连接条件的行以外，还返回左表和右表中不满足条件的行
             #这种连接称为满外连接。
# mysql 不支持full join             
SELECT employee_id,last_name,department_name
FROM employees e FULL JOIN departments d
ON e.`department_id` = d.`department_id`;


#课后练习

# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT e.job_id,d.location_id
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.department_id = 90;

# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name , d.department_name , d.location_id , l.city
FROM employees e LEFT JOIN departments d 
ON e.`department_id` = d.`department_id`
LEFT JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE e.`commission_pct` IS NOT NULL;


# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name 
SELECT last_name , job_id , e.department_id , department_name
FROM employees e
JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON l.`location_id` = d.`location_id`
WHERE l.`city` = 'Toronto';


# 5.选择所有员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
employees	Emp#	manager	Mgr#
kochhar		101	king	100

SELECT emp.last_name employees, emp.employee_id "Emp#", mgr.last_name manager, mgr.employee_id "Mgr#"
FROM employees emp 
LEFT JOIN employees mgr
ON emp.manager_id = mgr.employee_id;
