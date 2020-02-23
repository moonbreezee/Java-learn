package com.moonbreezee.demo.springbootdemo.model;

import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 用户注册时，要求输入手机号、密码、昵称，创建RegisterRequest类来接受前端传过来的数据，同时校验数据，校验都是通过注解的方式实现。
public class RegisterRequest {
  @SuppressWarnings("unused")
  private static final org.slf4j.Logger log = LoggerFactory.getLogger(RegisterRequest.class);
  // NotNull 表示必填
  @NotNull(message = "手机号必须填")
  // Pattern 输入字符串必须匹配正则表达式
  @Pattern(regexp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$", message = "账号请输入11位手机号") // 手机号
  private String mobile;

  @NotNull(message = "昵称必须填")
  // Size 字符串长度必须符合指定范围
  @Size(min = 1, max = 20, message = "昵称1~20个字")
  private String nickname;

  @NotNull(message = "密码必须填")
  @Size(min = 6, max = 16, message = "密码6~16位")
  private String password;

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
