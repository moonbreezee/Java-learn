package classAndObject;

//Java没有内置的日期类，但可以导入java.time包，这个包中包含了许多类，可用于处理日期和时间。
import java.time.LocalDate; // 导入LocalDate类
import java.time.LocalTime; // 导入LocalTime类

public class DateAndTimeClass {
  public static void main(String[] args) {
    LocalDate myObj = LocalDate.now(); // 创建一个日期对象
    System.out.println(myObj); // 显示当前日期

    // 要显示当前时间(小时、分钟、秒和毫秒)，导入java.time.LocalTime类，使用now()方法
    LocalTime myObj2 = LocalTime.now();
    System.out.println(myObj2);
  }
}
