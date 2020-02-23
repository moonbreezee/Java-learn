package classAndObject;

// 接口/interface 是一个**完全的“抽象类”**，**包含了一组没有实体的方法声明**。
// Interface
interface Animal3 {
  public void animalSound(); // interface 方法 (没有实体)

  public void sleep(); // interface 方法 (没有实体)
}

// Pig "implements" Animal 接口
class Pig3 implements Animal3 {
  public void animalSound() {
    // 这里提供了animalSound()方法的实体
    System.out.println("小猪说: 呜呜");
  }

  public void sleep() {
    // sleep()方法的实体
    System.out.println("Zzz");
  }
}

interface FirstInterface {
  public void myMethod(); // interface 方法
}

interface SecondInterface {
  public void myOtherMethod(); // interface 方法
}

// DemoClass实现(implements)了FirstInterface和SecondInterface接口
class DemoClass implements FirstInterface, SecondInterface {
  public void myMethod() {
    System.out.println("Some text..");
  }

  public void myOtherMethod() {
    System.out.println("Some other text...");
  }
}

public class InterfaceTest {
  public static void main(String[] args) {
    Pig3 myPig = new Pig3(); // 创建Pig对象
    myPig.animalSound();
    myPig.sleep();

    DemoClass myObj = new DemoClass();
    myObj.myMethod();
    myObj.myOtherMethod();
  }
}
