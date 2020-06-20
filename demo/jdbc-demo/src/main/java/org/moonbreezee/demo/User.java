package org.qiuwww.demo;

public class User {
  public int id;
  public String name;
  public int age;
  public User(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public String toString()
  {
    // 这里可以不需要this，直接使用属性值
   return "" + name + " " + age;
  }

  public String getUser_name() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
