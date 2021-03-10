# 导包

不要忘记写分号

```java
// 常用的数据类型包都在 util下 如 Collection Map Scanner等
import java.util.*;
// 另外，Math 包在 lang 下 
import java.lang.Math;
// 有时用io流导入大量数据
import java.io.BufferedInputStream;

// 操作大数
import java.math.BigInteger; //操作大整数
import java.math.BigDecimal; //操作大小数
```

# 主类和主方法

```java
public class Main{
    public static void main(String[] args){
        // 接收传递来的量
        Scanner s = new Scanner(System.in);
        // 读入数据多的时候
        Scanner s = new Scanner (new BufferedInputStream(System.in))
        ... ... 
        // 关闭
        s.close();
       	// 方法主体 / 调用方法
        ... ...
        // 输出结果
        String res = "result";
        System.out.println(res);
    }
}
```

## Scanner 的使用

+ Scanner 接收基本类型

```java
scan.hasNext();
String s = scan.next();  // String 类型
char a= input.next().charAt(0); // char 类型

scan.hasNextInt();
int i = scan.nextInt(); // Int 类型

scan.hasNextDouble();
int i = scan.nextDoulble(); // Double 类型
```

+ Scanner 接收大数类型和大数语法

```java
public class Main
{
    public static void main(String []args)
    {    
        BigInteger a, b, ans;
        Scanner scan = new Scanner(System.in);
        a = scan.nextBigInteger();
        b = scan.nextBigInteger();
        ans = a.add(b); // ans = a + b;
        ans = a.subtract(b);// ans = a - b
        ans = a.mod(b); // ans = a % b
        ans = a.divide(b); // ans = a / b
        ans = a.max(b);
        ans = a.min(b);
        ans = a.multiply(b);
    }
}
```

+ Scanner 的 `.next()` 和 `.nextLine()`

```java
//  next()
//  一定要读取到有效字符后才可以结束输入。
//  对输入有效字符之前遇到的空白，next()方法会自动将其去掉。
//  只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
//  next() 不能得到带有空格的字符串。

// nextLine()读取到回车结束 也就是“\r”.
scan.hasNext();
scan.next();
scan.hasNextLine();
scan.nextLine();
```

## 常用输入格式

+  输入第一行包括一个数据组数 t (1 <= t <= 100)
  接下来每行包括两个正整数 a,b (1 <= a, b <= 10^9)

```java
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
		while(n>0){
            int a= scanner.nextInt();
            int b= scanner.nextInt();
            System.out.println(a+b);
            n--;
        }
    }
}
```
+ 输入 0 时结束

```java
import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int a=input.nextInt();
            int b=input.nextInt();
            if(a==0&&b==0) return;
            System.out.println(a+b);
        }
    }
}
```

+ 输入数据包括多组。
  每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
  接下来n个正整数,即需要求和的每个正整数。

```java
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            if(n == 0) break;
            
            int i = 0;
            int sum = 0;
            String[] cg = scanner.nextLine().trim().split(" "); // 一行除了第一个取出的元素剩下的部分，默认前面会有一个空格，所以trim() 掉
            
            while(n>0){
                sum += Integer.parseInt(cg[i]);
                i++;
                n--;
            }
            System.out.println(sum);
        }
    }
}
```

+ 输入数据有多组, 每行表示一组输入数据。

  每行不定有n个整数，空格隔开。(1 <= n <= 100)。

```java
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        
        while(scanner.hasNextLine()){

            int sum = 0;
            String[] cg = scanner.nextLine().trim().split(" "); // 一行除了第一个取出的元素剩下的部分，默认前面会有一个空格，所以trim() 掉
            
            for(String s : cg){
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
```

+ 对输入的字符串进行排序后输出

```java
import java.util.*;
 
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String row = scan.nextLine();
        String[] line = scan.nextLine().trim().split(" ");
        Arrays.sort(line);
        for(String s : line){
            System.out.print(s + " ");
        }
    }
}
```

+ 多个测试用例，每个测试用例一行。

  每行通过空格隔开，有n个字符，n＜100

```java
import java.util.*;
 
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] line = scan.nextLine().trim().split(" ");
            Arrays.sort(line);
            for(String s : line){
                System.out.print(s + " ");
            }  
            System.out.println();
        }
    }
}
```

+ 对输入的字符串进行排序后输出

```java
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] line = scan.nextLine().trim().split(",");
            Arrays.sort(line);
            for(int i = 0; i < line.length; i++){
                if( i == line.length - 1){
                    System.out.print(line[i]);
                }else
                    System.out.print(line[i] + ',');
            }  
            System.out.println();
        }
    }
}
```



## 结果输出

一般是让输出出来，所以就是带换行的 `println`

```java
        for(int i = 0; i < T; i++){
            System.out.println(helper(arr[i]));
        }
```



# 方法主体

```java
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        s.close();
        ... ...
    }
    // 因为主方法是静态的，所以我们必须把主体方法也设置成静态
    public static void helper(int n){
        
    }
}
```

