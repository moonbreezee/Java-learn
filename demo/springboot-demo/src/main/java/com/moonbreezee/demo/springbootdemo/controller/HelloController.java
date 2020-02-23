package com.moonbreezee.demo.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  // http://localhost:8096/hello
  // 访问/hello接口打印当前环境名称。
  // 当前环境配置名称
  @Value("${profile.name}") // 读取当前环境配置名称，取值profile.name然后赋值给profileName
  private String profileName;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String index() {

    String sql = "SELECT mobile FROM user WHERE id = ?";

    // 通过jdbcTemplate查询数据库
    String mobile = (String) jdbcTemplate.queryForObject(sql, new Object[] { 1 }, String.class);

    return "Hello " + mobile + ", 当前的环境变量的值： " + profileName;
  }
}
