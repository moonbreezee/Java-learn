package classAndObject;

/**
 * 修饰符
 */

// public 任何其他类都可以访问该类
// 添加了public的类必须与文件名同
public class Modifier {
  /**
   * 成员变量
   */
  // 如果希望属性值是不可变的，将属性声明为final
  final int x = 10;
  final double PI = 3.14;

  // Main 方法
  public static void main(String[] args) {
    Modifier myObj = new Modifier();
    // Cannot assign a value to final variable 'x'
    // myObj.x = 50; // 将生成一个错误: 无法为最终变量赋值
    // myObj.PI = 25; // 将生成一个错误: 无法为最终变量赋值
    System.out.println(myObj.x);

    myStaticMethod(); // 调用静态方法
    // myPublicMethod(); 这将报错

    Modifier myObj2 = new Modifier(); // 创建MyClass的对象
    myObj2.myPublicMethod(); // 调用公共方法
  }

  /**
   * Static 方法
   */

  // 不需要创建类的对象，就可以访问静态方法或属性
  static void myStaticMethod() {
    System.out.println("调用静态方法无需创建对象");
  }

  // Public 方法
  public void myPublicMethod() {
    System.out.println("调用公共方法需创建对象");
  }
}
