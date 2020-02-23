package com.moonbreezee.demo.springbootsecuritydemo.service;

import com.moonbreezee.demo.springbootsecuritydemo.model.JwtUser;

public interface JwtAuthService {
  JwtUser register(JwtUser userToAdd);
  String login(String username, String password);
  String refresh(String oldToken);
}
