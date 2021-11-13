#06-7种JOIN
#中图：内连接	106条
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`

#左上图：左外连接	107条
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#右上图：右外连接	122条
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#左中图：	1条
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL;

#右中图：	16条
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.department_id IS NULL

#如何求并集：
/*
union：返回两个查询的结果集的并集。
union all：返回两个查询的结果集的并集。对于两个结果集的重复部分，不去重。
*/

#左下图：满外连接	123条
#方式一：左上图 + 右中图
#方式二：左中图 + 右上图
#结论：如果两个集合没有重复部分，推荐使用union all
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL	
UNION ALL
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#右下图：	17条
#左中图 + 右中图
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e 
RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.department_id IS NULL





















