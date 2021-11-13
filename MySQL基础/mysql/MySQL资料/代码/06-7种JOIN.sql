#06-7种JOIN
#中图：内连接   106条
SELECT employee_id,last_name,department_name
FROM employees e INNER JOIN departments d
ON e.`department_id` = d.`department_id`;

#左上图：左外连接  107条
SELECT employee_id,last_name,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#右上图：右外连接  122条
SELECT employee_id,last_name,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;

#左中图： 1条
SELECT employee_id,last_name,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL;


#右中图：
SELECT employee_id,last_name,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;


#左下图：满外连接  123条  
#方式一：左中图 + 右上图 
SELECT employee_id,last_name,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL
SELECT employee_id,last_name,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`

#方式二：左上图 + 右中图 :略

#右下图：左中图 + 右中图： 17条记录

SELECT employee_id,last_name,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL
SELECT employee_id,last_name,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;

#结论：能使用union all的场景，就不推荐使用union。因为避免去重，效率低。