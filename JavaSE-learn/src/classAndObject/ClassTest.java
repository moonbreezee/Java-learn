package classAndObject;

// 类的五大成员
// 1. 成员变量
// 2. 方法
// 3. 构造器
// 4. 内部类
// 5. 初始化块
public class ClassTest {
  /**
   * 成员变量
   */
  // 对象成员变量
  String fname = "qiu";
  String lname = "wei";
  int age = 25;
  // 类成员变量
  static int num = 1;

  // 如果希望属性值是不可变的，将属性声明为final
  // final 不能重写/修改属性和方法
  final double PI = 3.14;

  /**
   * 方法
   */
  // 可执行入口
  public static void main(final String[] args) {
    // 类访问
    // 类方法访问直接调用myMethod，这里省略了ClassTest类名
    staticMethod();
    // 类成员变量访问
    System.out.println("num: " + ClassTest.num);

    // 对象访问
    // 获取属性，需要先实例化对象
    // 当设置构造函数的时候，就需要对应添加参数了
    final ClassTest myObj = new ClassTest();
    // 访问对象的属性
    System.out.println("Name: " + myObj.fname + " " + myObj.lname + "\nage: " + myObj.age);
    // 对象方法访问
    myObj.objectMethod();
    final ClassTest myObj2 = new ClassTest("pan", "shi", 18);
    System.out.println("Name: " + myObj2.fname + " " + myObj2.lname + "\nage: " + myObj2.age);

  }

  // 静态方法，可以在静态方法中调用
  // 类方法
  static void staticMethod() {
    // Cannot make a static reference to the non-static method objectMethod() from
    // the type ClassTest
    // objectMethod();
    System.out.println("******staticMethod run!******");
  }

  // 公共方法
  public void objectMethod() {

    System.out.println("******objectMethod run!******");
  }

  /**
   * 构造函数
   */
  // 为MyClass类创建一个构造函数
  // 无参数构造器

  public ClassTest() {

  }

  // 重载
  public ClassTest(String fname, String lname) {
    this.fname = fname;
    this.lname = lname;
  }

  // 构造函数重载
  public ClassTest(String fname, String lname, int age) {
    // this调用指定参数类型的构造函数
    this(fname, lname);
    this.age = age;
  }

}
