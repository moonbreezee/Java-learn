package org.moonbreezee.demo;

// 创建一个类可以让Customer调用，但是不通过直接示例化的形式，使用Bean的机制来实现
public class Person {
  String gender;

  public Person(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void displayGender() {
    System.out.println("gender: " + gender);
  }
}
