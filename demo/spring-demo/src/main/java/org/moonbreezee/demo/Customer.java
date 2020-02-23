package org.moonbreezee.demo;

//创建一个Bean类
public class Customer {
  String name;
  Person person;
  // 注入对象logger 
  private Logger logger;

  // person 被注入进来
  // 构造函数注入
  Customer(Person person) {
    this.person = person;
  }

  // 通过setter方法注入服务实例
  // Spring容器根据name调用setter方法：name对应“set”关键字后面的属性名，name="mainService"对应于setMainService。
  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void displayInfo() {
    System.out.println("Hello: " + name);
    System.out.println("person.gender: " + person.gender);
  }

  // 创建初始化方法和销毁方法
  public void init() {
    System.out.println("初始化...");
  }

  public void close() {
    System.out.println("销毁...");
  }

}