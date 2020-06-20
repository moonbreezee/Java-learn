package com.qiuwww.demo.springbootsecuritydemo.model;

// 第一波，对象不全
public class JwtUser {
  private Long id;

  private String nickname;

  private String mobile;

  private String password;

  private String role;

  public JwtUser(Long id, String nickname, String mobile, String password, String role) {
    this.id = id;
    this.nickname = nickname;
    this.mobile = mobile;
    this.password = password;
    this.role = role;
  }

  public JwtUser() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname == null ? null : nickname.trim();
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile == null ? null : mobile.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role == null ? null : role.trim();
  }
}