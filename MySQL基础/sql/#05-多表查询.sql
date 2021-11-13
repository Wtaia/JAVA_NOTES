#05-多表查询
DESC employees
DESC departments

#出现了笛卡尔积的错误
SELECT employee_id,last_name,department_name
FROM employees,departments;#共查询出2889行数据

SELECT 2889/107
FROM DUAL;-- 伪表，虚拟表

SELECT *
FROM departments

#正确的写法:多表的查询一定要有连接条件
SELECT employee_id,last_name,department_name
FROM employees,departments
#多表的连接条件
WHERE employees.`department_id` = departments.`department_id`

#进一步:如果查询的字段在多个表中存在，则需要指出来自哪个表
#Column 'department_id' in field list is ambiguous
#department_id 在两张表中都存在

SELECT employee_id,last_name,department_name,departments.`department_id`
FROM employees,departments
WHERE employees.`department_id` = departments.`department_id`
#建议开发中多表查询时，查询的字段都指明来自于哪个表 ---》sql优化
SELECT employees.employee_id,employees.last_name,department_name,departments.`department_id`
FROM employees,departments
WHERE employees.`department_id` = departments.`department_id`

#表的别名的使用
#表的别名在查询和过滤中都可以使用
SELECT e.employee_id,e.last_name,d.department_name,d.`department_id`
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`

#需求
SELECT e.employee_id,e.last_name,d.department_name,l.city
FROM employees e,departments d,locations l
#连接条件：如果实现n个表的查询，则至少需要n-1个连接条件
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id;


##################################################

/*
多表查询的分类：
1.等值连接	vs	不等值连接
2.自连接	vs	非自连接
3.内连接	vs	外连接
*/

#不等值连接
SELECT employee_id,salary,grade_level
FROM employees e,job_grades j
#where e.`salary` >= j.`lowest_sal`and e.`salary` <= j.`highest_sal`;
WHERE e.`salary` BETWEEN j.`lowest_sal` AND j.`highest_sal`;

#自连接
#查询员工的employee_id，last_name及其管理者的employee_id,last_name
SELECT emp.employee_id,emp.last_name,mgr.employee_id AS "manager id",mgr.last_name AS "manager name"
FROM employees emp,employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;

#############################################
/*
内连接：合并具有同一列的两个以上的表的行, 结果集中不包含一个表与另一个表不匹配的行
外连接：分为左外连接 和 右外连接 
	左外连接：两个表在连接过程中除了返回满足连接条件的行以外还返回左表中不满足条件的行
	右外连接：两个表在连接过程中除了返回满足连接条件的行以外还返回右表中不满足条件的行
	没有匹配的行时, 结果表中相应的列为空(NULL)。
*/
#内连接的例子
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`

#要想实现外连接，需要使用sql99语法中的相关结构
#oracle中可以这么写，mysql报错
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`（+）

############################################################

#sql-99语法实现内连接
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
#inner可省略
INNER JOIN departments d
ON e.`department_id` = d.`department_id`;

SELECT e.employee_id,e.last_name,d.department_name,city
FROM employees e 
JOIN departments d 
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`;

#左外连接
#需求：查询所有员工的employee_id,last_name,department_name
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
#outer可省略
LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#实际开发通常用左外连接，只需调整表的顺序即可

#右外连接
#需求：查询所有的部门对应的员工的employee_id,last_name
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
#outer可省略
RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#满外连接：两个表在连接过程中除了返回满足连接条件的行以外还返回左表和右表中不满足条件的行
#mysql 不支持full join
#以下执行报错
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
FULL JOIN departments d
ON e.`department_id` = d.`department_id`;


















