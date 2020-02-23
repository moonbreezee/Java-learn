package basis;

public class ForAndForEach {
  public static void main(String args[]) {
    ForAndForEach test = new ForAndForEach();
    test.forTest();
    test.forEachTest();
    test.forContinueTest();
    test.forBreakTest();
  }

  public void forTest() {
    System.out.println("******forTest******");

    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }
  }

  public void forEachTest() {
    System.out.println("******forEachTest******");

    String[] vehicle = { "自行车", "电动车", "汽车", "高铁" };
    for (String i : vehicle) {
      System.out.println(i);
    }
  }

  public void forBreakTest() {
    System.out.println("******forBreakTest******");

    for (int i = 0; i < 10; i++) {
      if (i == 4) {
        System.out.println("break结束循环");
        break;
      }
      System.out.println(i);
    }
  }

  public void forContinueTest() {
    System.out.println("******forContinueTest******");

    for (int i = 0; i < 10; i++) {
      if (i == 4) {
        System.out.println("continue跳过本次循环的后边的代码");
        continue;
      }
      System.out.println(i);
    }
  }

}
