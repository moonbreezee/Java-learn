package classAndObject;

// HashMap将数据存储为“键/值”对，通过键(例如：字符串，键类似索引)访问它们
// HashMap中的键和值实际上都是是对象。 String
// 导入HashMap类
import java.util.HashMap;

public class HashMapClass {
  public static void main(String[] args) {

    // 创建一个名为capitalCities的HashMap对象
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // 添加键和值(Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);

    // 访问
    System.out.println("capitalCities.get(): " + capitalCities.get("England"));
    // 删除
    // capitalCities.remove("England");
    // // 清空
    // capitalCities.clear();
    // size
    System.out.println("capitalCities.size(): " + capitalCities.size());

    // 遍历HashMap
    System.out.println("打印键");
    for (String i : capitalCities.keySet()) {
      System.out.println(i);
    }
    System.out.println("打印值");
    for (String i : capitalCities.values()) {
      System.out.println(i);
    }
    System.out.println("打印键和值");

    for (String i : capitalCities.keySet()) {
      System.out.println("key: " + i + " value: " + capitalCities.get(i));
    }

  }
}
