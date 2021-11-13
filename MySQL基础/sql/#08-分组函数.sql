#08-分组函数

#上篇：常见的组函数:avg() / sum() / min() / max() / count()

#1.avg() / sum()：只适用于字符类型
#计算非数值型时无意义，不报错
SELECT AVG(salary),SUM(salary),AVG(last_name),SUM(last_name)
FROM employees

#2.min() / max() :适用于数值类型、字符串类型、日期类型的字段
SELECT MIN(salary),MAX(salary),MIN(employee_id),MIN(last_name),MAX(hire_date)
FROM employees

#3.count()：计数时，不考虑空值
SELECT COUNT(salary),COUNT(last_name),COUNT(hire_date),
COUNT(commission_pct) #35，不为空的个数，空值不参与计算
FROM employees

#需求：查询员工表中员工的个数
SELECT COUNT(employee_id),COUNT(last_name),COUNT(1),COUNT(*)
FROM employees;

DESC employees;

#count 与 avg\sum 三者的关系:avg = sum / count
SELECT AVG(salary),SUM(salary)/COUNT(salary),
AVG(commission_pct),SUM(commission_pct)/COUNT(commission_pct),
SUM(commission_pct)/107
FROM employees

#查询员工的平均奖金级别？
SELECT SUM(commission_pct)/COUNT(IFNULL(commission_pct,0))
FROM employees


#下篇：group by / having

#1.group by

#查询公司的平均工资
SELECT AVG(salary)
FROM employees

#查询各个部门的平均工资
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id

#查询各个工种的平均工资
SELECT job_id,AVG(salary)
FROM employees
GROUP BY job_id

#查询各个部门各个工种的平均工资
SELECT department_id,job_id,AVG(salary)
FROM employees
GROUP BY department_id,job_id
#与上一个操作结果一样
SELECT job_id,department_id,AVG(salary)
FROM employees
GROUP BY job_id,department_id

###
#如下的语句是正确的
SELECT AVG(salary)
FROM employees
GROUP BY department_id

#出现组函数字段和非子函数字段，报错
SELECT department_id,AVG(salary)
FROM employees

#结论：select中出现组函数和非组函数字段，那么非组函数的字段一定要声明在group by中
#反之：声明在group by 中的字段，可以不声明在select中

SELECT department_id,job_id,AVG(salary)
FROM employees
GROUP BY department_id,job_id

#2.having

#需求：查询部门最高工资比10000高的部门及其最高工资
#错误的
SELECT department_id,MAX(salary)
FROM employees
WHERE MAX(salary) > 10000
GROUP BY department_id 
#结论：如果过滤条件中出现组函数，则需要使用having替换where实现过滤，且having必须跟在组函数后面
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id 
HAVING MAX(salary) > 10000

#需求：查询10，20，30，40号部门中，部门最高工资比10000高的部门及其最高工资
#结论：如果过滤条件中出现了组函数，那么将过滤条件1声明在having中；
#      如果过滤条件中没有出现组函数，那么推荐将过滤条件2声明在where中。

#写法一：推荐，优于解法二，效率高
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IN(10,20,30,40)
GROUP BY department_id 
HAVING MAX(salary) > 10000

#写法二：
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id 
HAVING MAX(salary) > 10000
AND department_id IN(10,20,30,40)

/*
小结：
#查询语句的结构1：

select
from
where 多表的连接条件 and 非组函数的过滤条件
group by 
having 组函数的过滤条件
order by asc/desc
limit

#查询语句的结构2：
#序号为执行顺序
select -- 7
from --1
（left outer/right outer）join on -- 3，2
（left outer/right outer）join on 
where 非组函数的过滤条件 -- 4
group by -- 5
having 组函数的过滤条件 -- 6
order by asc/desc -- 8
limit
*/










