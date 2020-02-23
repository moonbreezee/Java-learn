package basis;

/**
 * Description: 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * 
 * @author qiu@...
 * @version 5.0
 */
public class JavaDoc {
  /**
   * 简单测试成员变量
   */
  protected String name;

  /**
   * 主方法，程序的入口
   * @param args 默认无参数
   */
  public static void main(String[] args) {
    // 这是一行简单的注释
    System.out.println("Hello World!");
    // System.out.println("这行代码被注释了，将不会被编译、执行!");
  }

  /**
   * 一个得到打招呼字符串的方法。
   * @param name 该参数指定向谁打招呼。
   * @return 返回打招呼的字符串。
   */
  public String hello(String name) {
    return name + "，你好！";
  }
}
