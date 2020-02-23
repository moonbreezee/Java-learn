package classAndObject;

import java.util.Scanner;

// Scanner类可用于获取用户输入，Scanner类包含在java.util包中。
// 要使用Scanner类，创建该类的对象，然后调用该类的方法。在我们的例子中，使用nextLine()方法，读取整行文本，回车结束
class ScannerClass {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);

    System.out.println("输入： 名字, 年龄, 薪资");

    // 依次获取不同类型的参数
    // 字符串输入
    String name = myObj.nextLine();
    // 数值输入
    int age = myObj.nextInt();
    double salary = myObj.nextDouble();

    // 打印用户输入
    System.out.println("名字: " + name);
    System.out.println("年龄: " + age);
    System.out.println("薪资: " + salary);
  }
}
