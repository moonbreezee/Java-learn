package classAndObject;

// 抽象类
// 抽象方法属于抽象类，它没有主体。主体由子类提供
// 需要子类实现之后才可以使用

abstract class Person {
  public String fname = "Kevin";
  public int age = 35;

  public abstract void study(); // 抽象方法
}

// 子类(从Person继承)

class Student extends Person {
  public int graduationYear = 2008;

  public void study() { // 这里提供了抽象方法的主体
    System.out.println("整天学习");
  }
}

// Code from filename: MyClass.java
public class ObstractClassTest {
  public static void main(String[] args) {
    // 创建Student类的对象(它继承Person的属性和方法)
    Student myObj = new Student();

    System.out.println("Name: " + myObj.fname);
    System.out.println("Age: " + myObj.age);
    System.out.println("Graduation Year: " + myObj.graduationYear);
    myObj.study(); // 调用抽象方法
  }
}