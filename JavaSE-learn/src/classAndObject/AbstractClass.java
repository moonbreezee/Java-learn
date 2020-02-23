package classAndObject;

// 数据抽象是隐藏某些细节，只向用户显示基本信息的过程。
// 抽象可以通过抽象类或接口来实现

// 抽象类
abstract class Animal2 {
  // 抽象方法(没有主体)
  public abstract void animalSound();
  // 常规方法
  public void sleep() {
    System.out.println("Zzz");
  }
}

// 子类(继承Animal)
class Pig2 extends Animal2 {
  public void animalSound() {
    // 这里提供了animalSound()的主体
    System.out.println("小猪说: 呜呜");
  }
}

public class AbstractClass {
  public static void main(String[] args) {
    Pig2 myPig = new Pig2(); // 创建一个Pig对象
    myPig.animalSound();
    myPig.sleep();
  }
}
