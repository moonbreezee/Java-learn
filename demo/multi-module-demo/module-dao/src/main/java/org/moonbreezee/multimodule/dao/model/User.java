package org.moonbreezee.multimodule.dao.model;

public class User {
  private Integer id;

  private String name;

  public User(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public User() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  // 重写toString() 方法
  @Override
  public String toString() {
    return "{name ==" + name + ", id == " + id + "}";
  }
}