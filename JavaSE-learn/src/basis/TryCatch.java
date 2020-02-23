package basis;

public class TryCatch {
  public static void main(String args[]) {
    TryCatch test = new TryCatch();
    test.tryCatchFinally();
    test.throwTest();
  }

  public void tryCatchFinally() {
    System.out.println("******tryCatchFinally******");

    try {
      int[] myNumbers = { 1, 2, 3 };
      System.out.println(myNumbers[10]);
    } catch (Exception e) {
      System.out.println("出错了");
    } finally {
      System.out.println("'try catch'结束了");
    }

  }

  public void throwTest() {
    System.out.println("******throwTest******");

    int age = 12;
    if (age < 18) {
      throw new ArithmeticException("拒绝访问 - 低于18岁");
    } else {
      System.out.println("允许访问 - 年龄合格");
    }
  }
}
