package basis;

import java.util.ArrayList; // 导入ArrayList类
import java.util.Collections; // 导入Collections类

public class JavaArray {
  public static void main(String args[]) {
    JavaArray test = new JavaArray();

    test.arrayTest();
    test.multArray();
    test.arrayListTest();
  }

  public void arrayTest() {
    System.out.println("******arrayTest******");
    // 声明并赋值
    String[] vehicle = { "自行车", "电动车", "汽车", "高铁" };
    int[] myNum = { 10, 20, 30, 40 };
    // 访问数组的元素
    System.out.println(vehicle[0]);
    // 更改数组元素
    vehicle[0] = "飞机";
    System.out.println(vehicle[0]);
    // 数组长度
    System.out.println(vehicle.length);
  }

  // 多维数组
  public void multArray() {
    System.out.println("******multArray******");

    int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
    int x = myNumbers[1][2];
    System.out.println(x); // 输出 7

    for (int i = 0; i < myNumbers.length; ++i) {
      for (int j = 0; j < myNumbers[i].length; ++j) {
        System.out.println(myNumbers[i][j]);
      }
    }
  }

  public void arrayListTest() {
    System.out.println("******arrayListTest******");
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println("cars1: " + cars);

    // 修改一个项目
    cars.set(0, "Opel");
    System.out.println("cars2: " + cars);

    // 访问一个项目
    System.out.println("cars.get(0): " + cars.get(0));

    cars.remove(0);
    System.out.println("cars3: " + cars);

    System.out.println("cars.size(): " + cars.size());

    // 也可以使用for-each遍历ArrayList
    System.out.println("for-each遍历ArrayList");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }

    Collections.sort(cars); // cars数组排序
    System.out.println("cars数组排序后for-each遍历ArrayList");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
  }
}