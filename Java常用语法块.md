# java 常用语法块

## 日期初始化及格式化

[参考文档](https://www.runoob.com/java/java-date-time.html)

```java
import  java.util.*;
import java.text.*;

public class DateDemo {
   public static void main(String args[]) {
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
      System.out.println("当前时间为: " + ft.format(dNow));
   }
}
```
