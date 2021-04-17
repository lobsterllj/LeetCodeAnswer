![image-20210326143610545](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210326143610545.png)





# Leetcode 题解







## 查询



### 简单查询

#### [176. 第二高的薪水](https://leetcode-cn.com/problems/second-highest-salary/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416225252044.png" alt="image-20210416225252044" style="zoom:67%;" />

```mysql
SELECT (
SELECT DISTINCT Salary
FROM Employee 
ORDER BY Salary DESC LIMIT 1,1) 
AS SecondHighestSalary;
```



#### [595. 大的国家](https://leetcode-cn.com/problems/big-countries/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150830011.png" alt="image-20210417150830011" style="zoom:67%;" />

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150844608.png" alt="image-20210417150844608" style="zoom:67%;" />



```mysql
SELECT name,population,area 
FROM World
WHERE population > 25000000 or area > 3000000;
```







### 连接查询

#### [1777. 每家商店的产品价格](https://leetcode-cn.com/problems/products-price-for-each-store/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416195824168.png" alt="image-20210416195824168" style="zoom:50%;" />

```mysql
SELECT distinct p.product_id, a.price AS store1, b.price AS store2, c.price AS store3
FROM Products p
LEFT JOIN Products a on p.product_id = a.product_id AND a.store = 'store1'
LEFT JOIN Products b on p.product_id = b.product_id AND b.store = 'store2'
LEFT JOIN Products c on p.product_id = c.product_id AND c.store = 'store3'
```



#### [175. 组合两个表](https://leetcode-cn.com/problems/combine-two-tables/)

![image-20210416224421787](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416224421787.png)![image-20210416224431130](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416224431130.png)

![image-20210416224511008](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416224511008.png)

```mysql
select p.FirstName, p.LastName, a.City, a.State 
from Person as p left join Address as a on p.PersonId = a.PersonId;
```







#### [180. 连续出现的数字](https://leetcode-cn.com/problems/consecutive-numbers/)

笛卡尔积，多表查询

![image-20210417150302935](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150302935.png)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150312865.png" alt="image-20210417150312865" style="zoom:67%;" />

```mysql
SELECT DISTINCT a.Num AS ConsecutiveNums
FROM Logs AS a, Logs AS b, Logs AS c
WHERE a.Num = b.Num AND b.Num = c.Num AND a.Id = b.Id - 1 AND b.Id = c.Id - 1
```





#### [181. 超过经理收入的员工](https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/)

笛卡尔积，多表查询

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150631356.png" alt="image-20210417150631356" style="zoom:67%;" />

```mysql
SELECT e4.Name AS 'Employee' FROM Employee AS e4 ,Employee AS e3
WHERE e4.ManagerId = e3.id AND e4.Salary > e3.Salary
```













### 函数查询

#### [178. 分数排名](https://leetcode-cn.com/problems/rank-scores/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150518144.png" alt="image-20210417150518144" style="zoom:67%;" />



```mysql
SELECT 
Score,
DENSE_RANK() over (ORDER BY Score DESC) 'Rank'
FROM
Scores
```









#### [177. 第N高的薪水](https://leetcode-cn.com/problems/nth-highest-salary/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416230316037.png" alt="image-20210416230316037" style="zoom:67%;" />

```mysql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary FROM Employee Order By Salary DESC LIMIT N,1
  );
END
```





#### [184. 部门工资最高的员工](https://leetcode-cn.com/problems/department-highest-salary/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417142627381.png" alt="image-20210417142627381" style="zoom:67%;" />



```mysql
SELECT Department, Employee, Salary FROM(
SELECT d.Name as Department, e.Name as Employee, Salary, rank() over (
PARTITION BY DepartmentId ORDER BY Salary DESC) ranknum 
FROM Employee as e JOIN Department as d where e.DepartmentId = d.Id 
)as t where t.ranknum = 1
```





拓展一下，如果只使用Employee表，查询每个部门工资最高的员工对应的 Id, salary 和 department Id

先按照不同部门partition，按照salary进行排序编号，具体sql如下：

```mysql
SELECT e.DepartmentId, e.Name as Employee, Salary, rank() over (
PARTITION BY DepartmentId ORDER BY Salary DESC) ranknum
FROM Employee e 
```

```mysql
{"headers": ["DepartmentId", "Employee", "Salary", "ranknum"], "values": 
[[1, "Jim", 90000, 1], 
 [1, "Max", 90000, 1], 
 [1, "Joe", 70000, 3], 
 [2, "Henry", 80000, 1], 
 [2, "Sam", 60000, 2]]}
```



更具第一步查询的结果，按照ranknum字段进行筛选，完整sql如下：

```mysql
SELECT r.DepartmentId, r.Employee, r.Salary FROM(
SELECT e.DepartmentId, e.Name as Employee, Salary, rank() over (
PARTITION BY DepartmentId ORDER BY Salary DESC) ranknum
FROM Employee e 
) AS r where r.ranknum = 1
```

```mysql
{"headers": ["DepartmentId", "Employee", "Salary"], "values": 
[[1, "Jim", 90000], 
 [1, "Max", 90000], 
 [2, "Henry", 80000]]}
```





#### [185. 部门工资前三高的所有员工](https://leetcode-cn.com/problems/department-top-three-salaries/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417145942539.png" alt="image-20210417145942539" style="zoom:67%;" />

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417150007952.png" alt="image-20210417150007952" style="zoom:67%;" />



```mysql
SELECT d.Name AS Department, Employee, Salary FROM(
    SELECT e.Name AS Employee, e.Salary, e.DepartmentId FROM(
        SELECT DepartmentId, Name, Salary, dense_rank() over(
            PARTITION BY DepartmentId ORDER BY Salary DESC
            -- 按照不同的DepartmentId分别降序排名
        ) as rankn FROM Employee AS f
        -- 给不同的工资水平编号 dense_rank() eg: 90 90 80 对应 1 1 2
    )e WHERE e.rankn < 4
    -- 每一个子表最好都取一个别名
)AS e1 JOIN Department AS d ON e1.DepartmentId = d.Id
```







#### [1112. 每位学生的最高成绩](https://leetcode-cn.com/problems/highest-grade-for-each-student/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210417151047521.png" alt="image-20210417151047521" style="zoom:67%;" />

```mysql
SELECT ee.student_id, ee.course_id,ee.grade FROM(
SELECT e.student_id, e.course_id, e.grade,
rank() over (
    PARTITION BY student_id 
    ORDER BY grade DESC,course_id ASC
) rn 
FROM Enrollments as e
) as ee
WHERE ee.rn = 1;
```













## 删除





### [196. 删除重复的电子邮箱](https://leetcode-cn.com/problems/delete-duplicate-emails/)

<img src="mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416191451712.png" alt="image-20210416191451712" style="zoom:50%;" />

多表删除，把 p1 大于 p2 的ID删除了

```mysql
DELETE p1 FROM Person p1, Person p2
-- 这里FROM Person p1, Person p2 相当于 p1 与 p2 的笛卡尔积，笛卡尔积语法就是select * from a，b；
WHERE p1.Email = p2.Email AND p1.Id > p2.Id
```

![image-20210416190844353](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416190844353.png)



如果把 p2 和 p1 对调

```mysql
DELETE p2 FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id
```

![image-20210416191129202](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416191129202.png)







![image-20210416223327782](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416223327782.png)













# 关键字









## DISTINCT

去重





## LIMIT

LIMIT x    显示前x条

LIMIT x,y     跳过x，显示y条

```mysql
SELECT * FROM table1;
```

![image-20210416230035726](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416230035726.png)

```mysql
SELECT * FROM table1 limit 1;
```

![image-20210416230117218](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416230117218.png)

```mysql
SELECT * FROM table1 limit 1, 1;
```

![image-20210416230142793](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210416230142793.png)







# 函数





## sql 四大排名函数（ROW_NUMBER、RANK、DENSE_RANK、NTILE）简介

https://blog.csdn.net/shaiguchun9503/article/details/82349050

```mysql
SELECT rank() over (
PARTITION BY DepartmentId ORDER BY Salary DESC) 
AS ranknum FROM Employee
```

**1.ROW_NUMBER()**

**定义**：ROW_NUMBER()函数作用就是将select查询到的数据进行排序，每一条数据加一个序号，他不能用做于学生成绩的排名，一般多用于分页查询， 
比如查询前10个 查询10-100个学生。

**2.rank()**

**rank是关键字 如果需要作为字段名需要'rank'**

定义：RANK()函数，顾名思义排名函数，可以对某一个字段进行排名，这里为什么和ROW_NUMBER()不一样那，ROW_NUMBER()是排序，当存在相同成绩的学生时，ROW_NUMBER()会依次进行排序，他们序号不相同，而Rank()则不一样出现相同的，他们的排名是一样的。下面看例子:
![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718151959229)



**3.DENSE_RANK()**

**定义**：DENSE_RANK()函数也是排名函数，和RANK()功能相似，也是对字段进行排名，那它和RANK()到底有什么不同那？看例子：

![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718153446182)

DENSE_RANK()密集的排名他和RANK()区别在于，排名的连续性，DENSE_RANK()排名是连续的，RANK()是跳跃的排名，所以一般情况下用的排名函数就是RANK()。

**4.ntile()**

定义：NTILE()函数是将有序分区中的行分发到指定数目的组中，各个组有编号，编号从1开始，就像我们说的’分区’一样 ，分为几个区，一个区会有多少个。

实例： ![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718154611387)


这里查询了3次,第一次分为1个’区’ ,所以查询结果number全是1，第二次分为2个区，查询结果为 1 1 2，意思就是 第一个 ‘区’ 为 1 1 两个编号的数据 ，第二个’区’只有2这个数据。

到这里，SQL的排名问题就说完了，下次介绍一些深层的SQL排名语句







# 常见错误



## Every derived table must have its own alias

https://blog.csdn.net/qq_32863631/article/details/83024322



```mysql
SELECT * FROM(SELECT * FROM(SELECT * FROM Employee AS A1) AS A2) AS A3
```



1. 在做多表查询，或者查询的时候产生新的表的时候会出现这个错误：Every derived table must have its own alias（每一个派生出来的表都必须有一个自己的别名）。

eg：

```mysql
delete from stock   
where (org_id,material_id,state) 
in  (SELECT * from 
(select org_id,material_id, state from stock WHERE state = 1 group by org_id,material_id,state having count(*) > 1)
) 
```


当执行这条sql语句的时候就会出现Every derived table must have its own alias；

2. 这条sql：

```mysql
(select org_id,material_id, state from stock WHERE state = 1 group by org_id,material_id,state having count(*) > 1)
```


就会产生一张新的表，和前面的表stock联合查询，但是mysql要求每一个派生出来的表都必须有一个自己的别名，那我给派生表加上别名即可；

eg：修改后的sql，直接在新生产的表中加入 他的别命名就行（“as a”或者“a”），“a”为新表的别名

```mysql
delete from stock   
where (org_id,material_id,state) in  
(SELECT * from (select org_id,material_id, state 
from stock WHERE state = 1 group by org_id,material_id,state having count(*) > 1) as a ) 
```

这样就解决了问题；





## [Error Code: 1175（执行删除更新语句）](https://www.cnblogs.com/shy1766IT/p/10749859.html)

mysql在执行删除更新语句时报这种错误，是因为在mysql在safe-updates模式中，如果你where后跟的条件不是主键id，那么就会出现这种错误。

解决方式有两种

   1、SET SQL_SAFE_UPDATES = 0;执行该命令更改mysql数据库模式。

   2、在where判断条件中跟上主键id  例如：delete from firstmysqldatabase.user where UserName='zhangsan' and ID>=0;

