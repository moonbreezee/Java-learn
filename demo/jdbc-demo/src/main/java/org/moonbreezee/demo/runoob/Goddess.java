package org.moonbreezee.demo.runoob;

// 模型

import java.util.Date;

public class Goddess {

  // Integer是int的包装类，int是java的一种基本数据类型
  private int id; // 这里的Integer是什么类型的？
  private String user_name;
  private Integer sex;
  private Integer age;
  private Date birthday; // 注意用的是java.util.Date
  private String email;
  private String mobile;
  private String create_user;
  private String update_user;
  private Date create_date;
  private Date update_date;
  private Integer isDel;

  // getter setter方法。。。
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Integer getSex() {
    return this.sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCreate_user() {
    return create_user;
  }

  public void setCreate_user(String create_user) {
    this.create_user = create_user;
  }

  public String getUpdate_user() {
    return update_user;
  }

  public void setUpdate_user(String update_user) {
    this.update_user = update_user;
  }

  public Date getCreate_date() {
    return create_date;
  }

  public void setCreate_date(Date create_date) {
    this.create_date = create_date;
  }

  public Date getUpdate_date() {
    return update_date;
  }

  public void setUpdate_date(Date update_date) {
    this.update_date = update_date;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }

}
