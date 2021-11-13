#07-单行函数
# 1. 字符串类型
SELECT CONCAT('hello','world','hello','beijing') "details"
FROM DUAL;

#需求： xxx worked for yyy

SELECT CONCAT(emp.last_name,' worked for ', mgr.last_name) "details"
FROM employees emp JOIN employees mgr
ON emp.`manager_id` = mgr.`employee_id`;

SELECT CONCAT_WS('-','hello','world','beijing')
FROM DUAL;

SELECT CHAR_LENGTH('hello'),LENGTH('hello'),CHAR_LENGTH('中国'),LENGTH('中国')
FROM DUAL;
#sql中索引从1开始！
SELECT INSERT('helloworld',2,3,'aaaaa')
FROM DUAL;

#下面的查询中，salary会自动的转换为字符串类型，此自动转换的行为称为：隐式转换
SELECT employee_id,LPAD(salary,10,' ') "details", RPAD(last_name,10,' ')
FROM employees;

DESC employees;

# 针对于数值类型、字符串类型、日期类型存在隐式转换。
SELECT 1 + '1' 
FROM DUAL;

SELECT TRIM('aa' FROM 'aaaahelaaloa')
FROM DUAL;

SELECT REPEAT('hello',5)
FROM DUAL;

SELECT STRCMP('abc','abe')
FROM DUAL;
#索引从1 开始
SELECT SUBSTRING('hello',2,2)
FROM DUAL;

# 2. 数值类型
SELECT CEIL(123.342),FLOOR(23.999),
MOD(12,5),MOD(12,-5),MOD(-12,5),MOD(-12,-5),RAND() * 100
FROM DUAL;

SELECT ROUND(123.567),ROUND(123.567,0),ROUND(123.567,1),ROUND(123.567,-2)
FROM DUAL;

SELECT TRUNCATE(123.967,0),TRUNCATE(123.567,1),TRUNCATE(123.567,-1)
FROM DUAL;

# 3. 日期类型
SELECT employee_id,hire_date
FROM employees
WHERE hire_date = '1993-01-13';

#如何获取当前的年月日、时分秒、年月日时分秒
SELECT CURDATE(),CURRENT_DATE(),CURTIME(),CURRENT_TIME(),NOW(),SYSDATE()
FROM DUAL;

/*
insert into employees(employee_id,last_name,hire_date)
values(304,'Tom',curdate())
*/

SELECT YEAR(CURDATE()),MONTH(CURDATE()),DAY(CURDATE()),
HOUR(CURTIME()),MINUTE(CURTIME()),SECOND(CURTIME())
FROM DUAL;

SELECT DAYOFWEEK(CURDATE()),WEEKDAY(NOW()),DAYNAME(CURDATE())
FROM DUAL;


SELECT DATE_ADD(NOW(), INTERVAL 1 YEAR)
FROM DUAL;

SELECT DATE_ADD(NOW(), INTERVAL -1 YEAR);   #可以是负数

SELECT DATE_ADD(NOW(), INTERVAL '1_1' YEAR_MONTH);   #需要单引号

#显式操作
#格式化：日期 ---> 字符串
#DATE_FORMAT(datetime ,fmt)
SELECT DATE_FORMAT(NOW(),'%Y/%M/%d %h:%i:%s')
FROM DUAL;


#解析： 字符串 ---> 日期
#STR_TO_DATE(str, fmt)
SELECT STR_TO_DATE('2021/May/26 09:54:17','%Y/%M/%d %h:%i:%s')
FROM DUAL;

#隐式操作：日期类型、字符串类型、数值类型之间存在隐式的转换。



# 4. 流程控制
#结构1 ： if
SELECT employee_id,last_name,salary,IF(salary > 10000,'高工资','低工资') "details",
IF(commission_pct IS NOT NULL,commission_pct,0) "details1"
FROM employees;

#结构2： ifnull
SELECT employee_id,last_name,salary,
IF(commission_pct IS NOT NULL,commission_pct,0) "details",
IFNULL(commission_pct,0) "details1",
salary * (1 + commission_pct),salary * (1 + IFNULL(commission_pct,0))
FROM employees; 

#结构3：case when ... then ... when ... then ... else ... end 类似于if-else if - .. -else 的多选一

SELECT employee_id,last_name,salary,CASE WHEN salary > 15000 THEN '高富帅'
					 WHEN salary > 10000 THEN '潜力股'
					 WHEN salary > 5000 THEN '打工人'
					 ELSE '小屌丝' END "details"
FROM employees; 


SELECT employee_id,last_name,department_id,CASE WHEN department_id = 10 THEN '10号部门'
						WHEN department_id = 20 THEN '20号部门'
						WHEN department_id = 30 THEN '30号部门'
						END "details"
FROM employees;

#结构4：case ... when ... then ... when ... then ... else ... end 类似于switch-case
SELECT employee_id,last_name,department_id,CASE department_id WHEN 10 THEN '10号部门'
							      WHEN 20 THEN '20号部门'
							      WHEN 30 THEN '30号部门'
							      ELSE '其他部门' END "details"
FROM employees;

/*
**练习：查询部门号为 10,20, 30 的员工信息, 
若部门号为 10, 则打印其工资的 1.1 倍, 
20 号部门, 则打印其工资的 1.2 倍, 
30 号部门打印其工资的 1.3 倍数。
*/

SELECT employee_id,last_name,salary,department_id,CASE department_id WHEN 10 THEN salary * 1.1
								     WHEN 20 THEN salary * 1.2
								     WHEN 30 THEN salary * 1.3
								     END "details"
FROM employees
WHERE department_id IN (10,20,30);


# 5. 其它函数
SELECT DATABASE(),VERSION(),USER()
FROM DUAL;

SELECT PASSWORD('abcd'),MD5(MD5('abcd'))
FROM DUAL;




