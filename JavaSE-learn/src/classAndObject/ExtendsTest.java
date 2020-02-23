package classAndObject;

class Vehicle {
  protected String brand = "Ford"; // Vehicle 属性

  public void honk() { // Vehicle 方法
    System.out.println("滴滴!");
  }
}

// 继承
class ExtendsTest extends Vehicle {
  private String modelName = "Mondeo"; // Car 属性

  public static void main(String[] args) {

    // 创建一个myCar对象
    ExtendsTest myCar = new ExtendsTest();

    // 在myCar对象上调用honk()方法(来自Vehicle类)
    myCar.honk();

    // 显示brand属性的值(来自Vehicle类)和modelName的值(来自Car类)
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}
