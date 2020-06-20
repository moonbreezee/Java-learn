package com.qiuwww.demo.springbootdemo.service;

import com.qiuwww.demo.springbootdemo.model.User;

import java.util.List;

// 服务接口类
public interface UserService {

  public User getUserById(long userId);

  // UserService.java新增一个接口
  public List<User> listUser(int page, int pageSize);

  // 测试redis缓存的接口
  public User getUserById2(long userId);

  public User updateUserNickname(long userId, String nickname);

}
