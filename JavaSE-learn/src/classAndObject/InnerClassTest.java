package classAndObject;

// 也可以嵌套类(类中的类)
// 嵌套类的目的是，将属于同一类别的类放在一起，从而使代码更具可读性和可维护性。
class OuterClass {
  int x = 10;

  // 相当于一个属性
  class InnerClass {
    int y = 5;
  }

  // 与“常规”类不同，内部类可以是私有(private)的，也可以是受保护(protected)的。如果不希望外部访问内部类，将该类声明为private
  private class InnerClass2 {
    int y = 5;
  }

  // 内部类也可以是静态的，这意味着，无需创建外部类对象，就可以访问它
  static class InnerClass3 {
    int y = 5;
  }

  // 内部类的一个优点是可以访问外部类的属性和方法
  class InnerClass4 {
    public int myInnerMethod() {
      return x;
    }
  }
}

// 要访问内部类，先创建外部类的对象，再创建内部类的对象
public class InnerClassTest {
  public static void main(String[] args) {
    // 实例
    OuterClass myOuter = new OuterClass();
    // 对象属性
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x);
    // 这里实例无法访问，只能类内部调用
    // OuterClass.InnerClass2 myInner2 = myOuter.new InnerClass2();
    // System.out.println(myInner.y + myOuter.x);

    // 类调用内部类，就像静态属性和方法一样，静态内部类不能访问外部类的成员
    OuterClass.InnerClass3 myInner3 = new OuterClass.InnerClass3();
    System.out.println(myInner3.y);

    // 内部类的一个优点是可以访问外部类的属性和方法
    // myOuter.new ？
    OuterClass.InnerClass4 myInner4 = myOuter.new InnerClass4();
    System.out.println(myInner4.myInnerMethod());
  }
}
