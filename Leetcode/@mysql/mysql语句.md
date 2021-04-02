![image-20210326143610545](mysql%E8%AF%AD%E5%8F%A5.assets/image-20210326143610545.png)







## sql 四大排名函数（ROW_NUMBER、RANK、DENSE_RANK、NTILE）简介

https://blog.csdn.net/shaiguchun9503/article/details/82349050

**1.ROW_NUMBER()**

**定义**：ROW_NUMBER()函数作用就是将select查询到的数据进行排序，每一条数据加一个序号，他不能用做于学生成绩的排名，一般多用于分页查询， 
比如查询前10个 查询10-100个学生。

**2.RANK()**

定义：RANK()函数，顾名思义排名函数，可以对某一个字段进行排名，这里为什么和ROW_NUMBER()不一样那，ROW_NUMBER()是排序，当存在相同成绩的学生时，ROW_NUMBER()会依次进行排序，他们序号不相同，而Rank()则不一样出现相同的，他们的排名是一样的。下面看例子:
![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718151959229)



**3.DENSE_RANK()**

**定义**：DENSE_RANK()函数也是排名函数，和RANK()功能相似，也是对字段进行排名，那它和RANK()到底有什么不同那？看例子：

![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718153446182)

DENSE_RANK()密集的排名他和RANK()区别在于，排名的连续性，DENSE_RANK()排名是连续的，RANK()是跳跃的排名，所以一般情况下用的排名函数就是RANK()。

**4.NTILE()**

定义：NTILE()函数是将有序分区中的行分发到指定数目的组中，各个组有编号，编号从1开始，就像我们说的’分区’一样 ，分为几个区，一个区会有多少个。

实例： ![这里写图片描述](mysql%E8%AF%AD%E5%8F%A5.assets/20150718154611387)


这里查询了3次,第一次分为1个’区’ ,所以查询结果number全是1，第二次分为2个区，查询结果为 1 1 2，意思就是 第一个 ‘区’ 为 1 1 两个编号的数据 ，第二个’区’只有2这个数据。

到这里，SQL的排名问题就说完了，下次介绍一些深层的SQL排名语句






## Every derived table must have its own alias（sql语句错误解决方法）

https://blog.csdn.net/qq_32863631/article/details/83024322

-- SELECT * FROM(SELECT * FROM(SELECT * FROM Employee AS A1) AS A2) AS A3

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



