#03-过滤数据
#查询90号部门员工的信息

SELECT employee_id,last_name,department_id,salary
FROM employees
# 使用where实现数据的过滤
# where 必须紧跟在from子句的后面
WHERE department_id = 90;


SELECT employee_id,last_name,department_id,salary
FROM employees
#where salary > 5000;
WHERE department_id <> 90;

# 2. between 下边界 and 上边界 (包含边界)
#查询工资大于等于6000 且小于等于 8000之间的员工信息
SELECT employee_id,salary
FROM employees
WHERE salary >= 6000 AND salary <= 8000;
#where salary between 6000 and 8000;
#WHERE salary BETWEEN 8000 AND 6000;


#3. in(set):
SELECT employee_id,department_id,salary
FROM employees
#where department_id = 30 or department_id = 40 or department_id = 50;
#where department_id in (30,40,50);
WHERE salary IN (6000,7000,8000);

#4. like ： 模糊查询

#精确查询
SELECT employee_id,LAST_NAME
FROM employees
WHERE last_name = 'King';  #字符串、日期需要使用一对''表示。注意，不要使用""
#where hire_date = '1993-01-13'; 


#查询姓名中包含字符'a'的员工
# % : 表示0个，1个或多个字符
SELECT employee_id,LAST_NAME
FROM employees
WHERE last_name LIKE '%a%';

# 查询姓名中包含字符'a'且包含字符'e'的员工

SELECT employee_id,LAST_NAME
FROM employees
#WHERE last_name LIKE '%a%e%' or last_name LIKE '%e%a%';
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';

# 查询姓名中第3个字符是a的员工
# _ : 表示一个不确定的字符
SELECT employee_id,LAST_NAME
FROM employees
WHERE last_name LIKE '__a%';


# 查询姓名中第2个字符是_且第3个字符是a的员工
SELECT employee_id,LAST_NAME
FROM employees
#WHERE last_name LIKE '_\_a%';  #  sout("林辉很\"帅\"");
WHERE last_name LIKE '_#_a%' ESCAPE '#';

# 5. is null:空值

SELECT last_name,commission_pct
FROM employees
WHERE commission_pct IS NULL;


SELECT last_name,commission_pct
FROM employees
#WHERE !(commission_pct IS NULL);
WHERE commission_pct IS NOT NULL;


# 6. 算术运算符
SELECT employee_id,salary,department_id
FROM employees
WHERE department_id MOD 20 = 0;


#选择工资不在5000到12000的员工的姓名和工资
SELECT last_name,salary
FROM employees
#where salary < 5000 or salary > 12000;
WHERE salary NOT BETWEEN 5000 AND 12000;
#where !(salary >= 5000 and salary <= 12000);

#选择公司中没有管理者的员工姓名及job_id
SELECT last_name,job_id
FROM employees
WHERE manager_id IS NULL;
