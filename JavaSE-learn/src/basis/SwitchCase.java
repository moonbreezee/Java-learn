package basis;

public class SwitchCase {
  // 枚举类型
  enum Level {
    LOW, MEDIUM, HIGH
  }

  public static void main(String args[]) {
    SwitchCase switchCase = new SwitchCase();
    switchCase.convert(2);
    switchCase.convert(7);
    switchCase.enumTest();
  }

  public void convert(int day) {
    switch (day) {
    case 1:
      System.out.println("周一");
      break;
    case 2:
      System.out.println("周二");
      break;
    case 3:
      System.out.println("周三");
      break;
    case 4:
      System.out.println("周四");
      break;
    case 5:
      System.out.println("周五");
      break;
    case 6:
      System.out.println("周六");
      break;
    case 7:
      System.out.println("周日");
      break;
    }
  }

  public void enumTest() {
    Level myVar = Level.MEDIUM;
    switch (myVar) {
    case LOW:
      System.out.println("低级");
      break;
    case MEDIUM:
      System.out.println("中级");
      break;
    case HIGH:
      System.out.println("高级");
      break;
    }
  }
}