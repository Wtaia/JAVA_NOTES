#07-单行函数

#1.字符串类型
-- CONCAT(S1...Sn):连接S1,S2,......,Sn为一个字符串
SELECT CONCAT('hello','world','hello','china') AS "details"
FROM DUAL

#需求：xxx work for yyy
#方式一
SELECT CONCAT(e1.last_name,' work for ',e2.last_name)AS "leader"
FROM employees e1,employees e2
WHERE e1.manager_id = e2.employee_id
#方式二
SELECT CONCAT(e1.last_name,' work for ',e2.last_name)AS "leader"
FROM employees e1 
JOIN employees e2
ON e1.manager_id = e2.employee_id

-- CONCAT_WS(s,s1,s2...):同CONCAT(s1,s2...)函数，但是每个字符串之间要加上s
SELECT CONCAT_WS('-','hello','world','hello','china')
FROM DUAL

-- CHAR_LENGTH(S):返回字符串s的字符数
-- LENGTH(S):返回字符串s的字节数，和字符集有关
SELECT CHAR_LENGTH('中国'),LENGTH('中国')
FROM DUAL

-- INSERT(str, index , len, instr):将字符串str从第index位置开始，len个字符长的子串替换为字符串instr
#在sql中索引从1开始
SELECT INSERT('helloWorld',2,3,'aaaaa')
FROM DUAL

-- LPAD(str, len, pad) 用字符串pad对str最左边进行填充，直到str的长度为len个字符
#salary自动转换为字符串类型，隐式转换
#针对于数值类型、字符串类型、日期类型存在隐式转换
SELECT employee_id,LPAD(salary,10,'*') AS "detail"
FROM employees
-- RPAD(str ,len, pad) 用字符串pad对str最右边进行填充，直到str的长度为len个字符
SELECT employee_id,RPAD(last_name,10,'*') AS "detail"
FROM employees

-- TRIM(s1 FROM s)【BOTH 】：去掉字符串s开始与结尾的s1
SELECT TRIM('aa' FROM 'aaahelloa')
FROM DUAL

-- REPEAT(str, n):返回str重复n次的结果
SELECT REPEAT('hello',5)
FROM DUAL;

-- STRCMP(s1,s2) 比较字符串s1,s2
SELECT STRCMP('hello','hi')
FROM DUAL;

-- SUBSTRING(s,index,len) 返回从字符串s的index位置其len个字符
#索引从1开始
SELECT SUBSTRING('hello',2,3)
FROM DUAL

#2.数值类型
-- ABS(x) 返回x的绝对值
-- CEIL(x) 返回大于x的最小整数值
-- FLOOR(x) 返回小于x的最大整数值
SELECT CEIL(123.342),FLOOR(23.999)
FROM DUAL
-- MOD(x,y) 返回x/y的模
#取模的符号和被模数保持一致
SELECT MOD(12,5),MOD(12,-5),MOD(-12,-5)
FROM DUAL
-- RAND() 返回0~1的随机值
SELECT RAND()
FROM DUAL
-- ROUND(x,y) 返回参数x的四舍五入的有y位的小数的值
SELECT ROUND(123.567),ROUND(123.567,0),ROUND(123.567,1),ROUND(123.567,-1)
FROM DUAL
-- TRUNCATE(x,y) 返回数字x截断为y位小数的结果
SELECT TRUNCATE(123.567,0),TRUNCATE(123.567,1),TRUNCATE(123.567,-1)
FROM DUAL
-- SQRT(x) 返回x的平方根
-- POW(x,y) 返回x的y次方

#3.日期类型
SELECT employee_id,hire_date
FROM employees
WHERE hire_date = '1993-01-13'

#格式化：日期--->字符串
#解析：字符串--->日期

#如何获取当前的年月日、时分秒、年月日时分秒
-- CURDATE() 或 CURRENT_DATE() 返回当前日期
SELECT CURDATE(),CURRENT_DATE()
FROM DUAL
-- CURTIME() 或 CURRENT_TIME() 返回当前时间
SELECT CURTIME(),CURRENT_TIME()
FROM DUAL
-- NOW() / SYSDATE() / CURRENT_TIMESTAMP() / LOCALTIME() /LOCALTIMESTAMP() 返回当前系统日期时间
SELECT NOW(),SYSDATE(),CURRENT_TIMESTAMP(),LOCALTIME(),LOCALTIMESTAMP()
FROM DUAL

#对日期的具体操作
-- YEAR(date) / MONTH(date) / DAY(date) / HOUR(time) /MINUTE(time) / SECOND(time) 返回具体的时间值
SELECT YEAR(NOW()),MONTH(NOW()),DAY(NOW()),HOUR(NOW()),MINUTE(NOW()),SECOND(NOW())
FROM DUAL  
-- WEEK(date) / WEEKOFYEAR(date) 返回一年中的第几周
-- DAYOFWEEK(date) 返回周几，注意：周日是1，周一是2，。。。周六是7
SELECT DAYOFWEEK(NOW())
FROM DUAL
-- WEEKDAY(date) 返回周几，注意，周1是0，周2是1，。。。周日是6
SELECT WEEKDAY(NOW())
FROM DUAL
-- DAYNAME(date) 返回星期：MONDAY,TUESDAY.....SUNDAY
-- MONTHNAME(date) 返回月份：January，。。。。。
-- DATEDIFF(date1,date2) / TIMEDIFF(time1, time2) 返回date1 - date2的日期间隔 / 返回time1 - time2的时间间隔
-- DATE_ADD(datetime, INTERVAL expr type)返回与给定日期时间相差INTERVAL时间段的日期时间
SELECT DATE_ADD(NOW(), INTERVAL 1 YEAR);
SELECT DATE_ADD(NOW(), INTERVAL -1 YEAR); #可以是负数
SELECT DATE_ADD(NOW(), INTERVAL '1_1' YEAR_MONTH); #需要单引号


#显式操作
#格式化：日期-->字符串
-- DATE_FORMAT(datetime ,fmt) 按照字符串fmt格式化日期datetime值
SELECT DATE_FORMAT(NOW(),'%Y/%m/%d %h:%i:%s')
FROM DUAL
#解析：字符串--->日期
-- STR_TO_DATE(str, fmt) 按照字符串fmt对str进行解析，解析为一个日期
SELECT STR_TO_DATE('2021/11/08 10:00:53','%Y/%m/%d %h:%i:%s')
FROM DUAL
#隐式操作：日期类型、字符串类型、日期类型存在隐式转换

#4.流程控制
-- IF(value,t ,f) 如果value是真，返回t，否则返回f
SELECT employee_id,last_name,salary,IF(salary > 10000,'高工资','低工资') "details",
IF(commission_pct IS NOT NULL,commission_pct,0) "details1"
FROM employees

-- IFNULL(value1, value2) 如果value1不为空，返回value1，否则返回value2
SELECT employee_id,last_name,salary,
IF(commission_pct IS NOT NULL,commission_pct,0) "details",
IFNULL(commission_pct,0) "details1"
FROM employees

-- CASE WHEN 条件1 THEN result1 WHEN 条件2 THEN result2 ....[ELSE resultn] END 相当于Java的if...else if...else...
#else 可省略
SELECT employee_id,last_name,salary,CASE WHEN salary > 15000 THEN '高富帅'
					 WHEN salary > 10000 THEN '潜力股'
					 WHEN salary > 5000 THEN '打工人'
					 ELSE '屌丝' END AS "details"
FROM employees;

SELECT employee_id,last_name,department_id,CASE WHEN department_id = 10 THEN '10号部门'
						WHEN department_id = 20 THEN '20号部门'
						WHEN department_id = 30 THEN '30号部门'
						ELSE '其他部门' END AS "details"
FROM employees;

-- CASE expr WHEN 常量值1 THEN 值1 WHEN 常量值1 THEN 值1.... [ELSE 值n] END相当于Java的switch...case...
SELECT employee_id,last_name,department_id,CASE department_id WHEN 10 THEN '10号部门'
							      WHEN 20 THEN '20号部门'
							      WHEN 30 THEN '30号部门'
							      ELSE '其他部门' END AS "details"
FROM employees;

/*
练习：查询部门号为 10,20, 30 的员工信息, 若部门号为 10, 则打印其工资的 1.1 倍, 
20 号部门, 则打印其工资的 1.2倍, 30 号部门打印其工资的 1.3 倍数。
*/
SELECT employee_id,last_name,salary,department_id,CASE department_id WHEN 10 THEN salary * 1.1
								     WHEN 20 THEN salary * 1.2
								     WHEN 30 THEN salary * 1.3
								     END AS "salary_new"
FROM employees
WHERE department_id IN (10,20,30);

#5.其他函数
-- database() 返回当前数据库名
-- version() 返回当前数据库版本
-- user() 返回当前登录用户名
SELECT DATABASE(),VERSION(),USER()
FROM DUAL

-- password(str) 返回字符串str的加密版本，41位长的字符串
-- md5(str) 返回字符串str的md5值，也是一种加密方式
SELECT PASSWORD('abcd'),MD5('abcd')
FROM DUAL




































