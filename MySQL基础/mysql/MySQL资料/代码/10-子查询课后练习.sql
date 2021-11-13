#10-子查询课后练习


#5.查询在部门的location_id为1700的部门工作的员工的员工号

SELECT employee_id,last_name
FROM employees
WHERE department_id IN (
			SELECT department_id
			FROM departments
			WHERE location_id = 1700
			);



#6.查询管理者是King的员工姓名和工资
#自连接
SELECT emp.last_name,emp.salary
FROM employees emp JOIN employees mgr
ON emp.`manager_id` = mgr.`employee_id`
WHERE mgr.last_name = 'King';

#子查询
SELECT last_name,salary
FROM employees
WHERE manager_id IN (
			SELECT employee_id
			FROM employees
			WHERE last_name = 'King'
			);


#8.查询平均工资最低的部门信息
#方式一：
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) = (
						SELECT MIN(avg_sal)
						FROM (
							SELECT AVG(salary) avg_sal
							FROM employees
							GROUP BY department_id
						    ) dept_avg_sal

						)
						
			)			

#方式二：
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) <= ALL(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						 ) 
		
			)

#方式三：

SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) = (
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						ORDER BY avg_sal
						LIMIT 0,1			
						)
		       )

#方式四：
SELECT d.*
FROM departments d,(
			SELECT department_id,AVG(salary) avg_sal
			FROM employees
			GROUP BY department_id
			ORDER BY avg_sal
			LIMIT 0,1
			) dept_avg_sal
WHERE d.department_id = dept_avg_sal.department_id;
			
					
#9.查询平均工资最低的部门信息和该部门的平均工资（难）
#方式一：
SELECT d.*,dept_avg_sal.avg_sal
FROM departments d,(
			SELECT department_id,AVG(salary) avg_sal
			FROM employees
			GROUP BY department_id
			ORDER BY avg_sal
			LIMIT 0,1
			) dept_avg_sal
WHERE d.department_id = dept_avg_sal.department_id;


#方式二：
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id) "avg_sal"
FROM departments d
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) <= ALL(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						 ) 
		
			)
			
			
#10.查询平均工资最高的 job 信息

#11.查询平均工资高于公司平均工资的部门有哪些?

#12.查询出公司中所有 manager 的详细信息.
	
#13.各个部门中 最高工资中最低的那个部门的 最低工资是多少?

#14.查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary

