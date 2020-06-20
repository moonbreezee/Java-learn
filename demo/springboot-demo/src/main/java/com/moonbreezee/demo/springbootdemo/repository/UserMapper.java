package com.qiuwww.demo.springbootdemo.repository;

import com.qiuwww.demo.springbootdemo.model.User;

import java.util.List;

//UserMapper.java – mybatis映射类，数据库访问层
public interface UserMapper {

  // 对应xml映射文件元素的ID
  User selectByPrimaryKey(long id);
  // UserMapper.java 新增接口
  // 列出用户，对应xml映射文件元素的ID
  List<User> selectUser();
}