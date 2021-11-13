#09-子查询
#谁的工资比Abel的高？

#方式1：
SELECT salary
FROM employees
WHERE last_name = 'Abel';


SELECT last_name,salary
FROM employees
WHERE salary > 11000;

#方式2：自连接
SELECT e1.last_name,e1.salary
FROM employees e1 JOIN employees e2
ON e1.`salary` > e2.`salary`
WHERE e2.`last_name` = 'Abel';

#方式3：子查询
SELECT last_name,salary
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
		)

# 子查询的概念： 外层：外查询、主查询 ; 内层：内查询、子查询
# 子查询的分类： 单行子查询、 多行子查询

#1. 单行子查询
# 可以使用的比较运算符有： =   >   >=  <  <=  <>  !=

#题目：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资

SELECT last_name,job_id,salary
FROM employees 
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
		)
AND salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);

#题目：返回公司工资最少的员工的last_name,job_id和salary

SELECT last_name,job_id,salary
FROM employees
WHERE salary = (
		SELECT MIN(salary)
		FROM employees
		);



#技巧：书写子查询的方式：①从外往里写 ②从里往外写

#题目：查询最低工资大于60号部门最低工资的部门id和其最低工资

SELECT department_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING MIN(salary ) > (
			SELECT MIN(salary)
			FROM employees
			WHERE department_id = 60
			)


#空值的情况：
SELECT last_name, job_id
FROM   employees
WHERE  job_id =
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Haas');


#非法使用子查询
SELECT employee_id, last_name
FROM   employees
WHERE  salary =
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);
                 

#2. 多行子查询

#多行子查询可以使用的比较操作符有：in  all any
#in:
SELECT employee_id, last_name
FROM   employees
WHERE  salary IN
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);


#题目：返回其它job_id中比job_id为‘IT_PROG’部门任一工资低的员工的员工号、姓名、job_id 以及salary 


SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ANY(
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		)


 # 题目：返回其它job_id中比job_id为‘IT_PROG’部门所有工资都低的员工的员工号、姓名、job_id以及salary          
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ALL(
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		)      

###################################################
#题目：查询员工中工资大于公司平均工资的员工的last_name,salary和其department_id
SELECT last_name,salary,department_id
FROM employees
WHERE salary > (
		SELECT AVG(salary)
		FROM employees
		);


#题目：查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
#方式一：相关子查询
SELECT last_name,salary,department_id
FROM employees e1
WHERE salary > (
		#本部门的平均工资
		SELECT AVG(salary)
		FROM employees e2
		WHERE e2.department_id = e1.`department_id`
		);

#方式二：除了在group by 和limit 之外的位置都可以编写子查询
SELECT e.last_name,e.salary,e.department_id
FROM employees e,(
		SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id) dept_avg_sal
WHERE e.department_id = dept_avg_sal.department_id
AND e.`salary` > dept_avg_sal.avg_sal;


#另例：查询员工的employee_id,last_name,要求按照department_name从小到大排序

SELECT employee_id,last_name
FROM employees e
ORDER BY (
	  SELECT department_name
	  FROM departments d
	  WHERE e.`department_id` = d.`department_id`
	
	  ) DESC;

#EXISTS的使用
#题目：查询公司管理者的employee_id,last_name,job_id,department_id信息
#方式一：
SELECT employee_id,last_name,job_id,department_id
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees
			);

#方式二：
SELECT employee_id,last_name,job_id,department_id
FROM employees e1
WHERE EXISTS (
		SELECT 'x'
		FROM employees e2
		WHERE e1.`employee_id` = e2.manager_id
	     );

