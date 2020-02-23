package basis;

// - 基本类型转换
// - 引用类型转换 -> 多态

// - 默认转换
// - 强制转换

/**
 * 基本类型转换
 * 
 * 自动转换按从低到高的顺序转换。不同类型数据间的优先关系如下：
 * 
 * 低-->高
 * 
 * byte,short,char-> int -> long -> float -> double
 */

class BasicTypeConvert {
  public static void main(String[] args) {

    autoConversion();
    autoPromote();
    forceConversion();
    narrowConversion();
    primitiveAndString();
    randomStr();
  }

  // 对于
  static void autoConversion() {
    System.out.println("******autoConversion******");

    int a = 6;
    // int可以自动转换为float类型
    float f = a;
    // 下面将输出6.0
    System.out.println(f);
    // 定义一个byte类型的整数变量
    byte b = 9;
    // 下面代码将出错，byte型不能自动类型转换为char型
    // char c = b;
    // 下面是byte型变量可以自动类型转换为double型
    double d = b;
    // 下面将输出9.0
    System.out.println(d);
  }

  static void autoPromote() {
    System.out.println("******autoPromote******");

    // 定义一个short类型变量
    short sValue = 5;
    // 下面代码将出错：表达式中的sValue将自动提升到int类型，
    // 则右边的表达式类型为int，将一个int类型赋给short类型的变量将发生错误。
    // sValue = sValue - 2;
    byte b = 40;
    var c = 'a';
    var i = 23;
    var d = .314;
    // 右边表达式中在最高等级操作数为d（double型）
    // 则右边表达式的类型为double型,故赋给一个double型变量
    double result = b + c + i * d;
    // 将输出144.222
    System.out.println(result);
    var val = 3;
    // 右边表达式中2个操作数都是int，故右边表达式的类型为int
    // 因此，虽然23/3不能除尽，依然得到一个int整数
    int intResult = 23 / val;
    System.out.println(intResult); // 将输出7
    // 输出字符串Hello!a7
    System.out.println("Hello!" + 'a' + 7);
    // 输出字符串104Hello!
    System.out.println('a' + 7 + "Hello!");
  }

  static void forceConversion() {
    System.out.println("******forceConversion******");

    int x;
    double y;
    x = (int) 34.56 + (int) 11.2; // 丢失精度
    y = (double) x + (double) 10 + 1; // 提高精度
    System.out.println("x=" + x);
    System.out.println("y=" + y);

  }

  static void narrowConversion() {
    System.out.println("******narrowConversion******");

    // 默认int
    var iValue = 233;
    // 强制把一个int类型的值转换为byte类型的值
    byte bValue = (byte) iValue;
    // 将输出-23
    System.out.println(bValue);
    var dValue = 3.98;
    // 强制把一个double类型的值转换为int
    int tol = (int) dValue;
    // 将输出3
    System.out.println(tol);
  }

  static void primitiveAndString() {
    System.out.println("******primitiveAndString******");
    // 下面代码是错的，因为5是一个整数，不能直接赋给一个字符串
    // String str1 = 5;
    // 一个基本类型值和字符串进行连接运算时，基本类型值自动转换为字符串
    String str2 = 3.5f + "";
    // 下面输出3.5
    System.out.println(str2);
    // 下面语句输出7Hello!
    System.out.println(3 + 4 + "Hello！");
    // 下面语句输出Hello!34，因为Hello! + 3会把3当成字符串处理，
    // 而后再把4当成字符串处理
    System.out.println("Hello！" + 3 + 4);
  }

  static void randomStr() {
    System.out.println("******randomStr******");
    // 定义一个空字符串
    var result = "";
    // 进行6次循环
    for (var i = 0; i < 6; i++) {
      // 生成一个97～122的int型的整数
      var intVal = (int) (Math.random() * 26 + 97);
      // 将intValue强制转换为char后连接到result后面
      result = result + (char) intVal;
    }
    // 输出随机字符串
    System.out.println(result);
  }
}

/**
 * 引用类型转换 也就是多态，只有有继承关系的类创建的对象才能转换
 */

abstract class Animal {
  abstract void eat();
}

class Cat extends Animal {
  public void eat() {
    System.out.println("吃鱼");
  }

  public void work() {
    System.out.println("抓老鼠");
  }
}

class Dog extends Animal {
  public void eat() {
    System.out.println("吃骨头");
  }

  public void work() {
    System.out.println("看家");
  }
}

class ReferenceType {

  public static void main(String[] args) {
    show(new Cat()); // 以 Cat 对象调用 show 方法
    show(new Dog()); // 以 Dog 对象调用 show 方法

    Animal a = new Cat(); // 向上转型
    a.eat(); // 调用的是 Cat 的 eat

    Cat c = (Cat) a; // 向下转型
    c.work(); // 调用的是 Cat 的 work
  }

  public static void show(Animal a) {
    a.eat();
    // 类型判断
    if (a instanceof Cat) { // 猫做的事情
      Cat c = (Cat) a;
      c.work();
    } else if (a instanceof Dog) { // 狗做的事情
      Dog c = (Dog) a;
      c.work();
    }
  }

  public void autoConversion() {

  }

  public void forceConversion() {

  }

}

public class DataTypeConversion {
  public static void main(String[] args) {

  }
}