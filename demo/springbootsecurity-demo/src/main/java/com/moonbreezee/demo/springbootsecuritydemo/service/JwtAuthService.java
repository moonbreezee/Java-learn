package com.qiuwww.demo.springbootsecuritydemo.service;

import com.qiuwww.demo.springbootsecuritydemo.model.JwtUser;

public interface JwtAuthService {
  JwtUser register(JwtUser userToAdd);
  String login(String username, String password);
  String refresh(String oldToken);
}
