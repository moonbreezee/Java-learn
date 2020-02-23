package org.moonbreezee.demo.aop;

public class User {
  private Integer id;
  private String name;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    System.out.println("Id: " + id);
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    System.out.println("Name: " + name);
    return name;
  }

  public void printThrowException() {
    System.out.println("Exception raised");
    // 这里抛出一个错误
    throw new IllegalArgumentException();
  }
}