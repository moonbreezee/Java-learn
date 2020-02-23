package classAndObject;

// 导入单个类
import java.util.Scanner;

// 导入整个包
import java.util.*;

import basis.WhileDo;

class PackageTest {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("输入用户名");

    String userName = myObj.nextLine();
    System.out.println("用户名: " + userName);

    WhileDo test = new WhileDo();
    test.whileDo();
  }
}