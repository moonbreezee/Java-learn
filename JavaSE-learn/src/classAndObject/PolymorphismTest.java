package classAndObject;

class Animal {
  public void animalSound() {
    System.out.println("动物发出声音");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("小猪说: 呜呜");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("狗说: 旺旺");
  }
}

// 多态
public class PolymorphismTest {
  public static void main(String[] args) {
    Animal myAnimal = new Animal(); // 创建一个动物对象
    // 类型声明是Animal，实际赋值是Pig，表现是Pig
    Animal myPig = new Pig(); // 创建一个Pig对象
    Animal myDog = new Dog(); // 创建一个Dog对象

    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}
