package com.qiuwww.demo.springbootdemo.controller;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.qiuwww.demo.springbootdemo.model.User;
import com.qiuwww.demo.springbootdemo.service.UserService;

import java.util.List;

// UserController – 控制类
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
// http://localhost:8096/user/2
public class UserController {

  // 注入mapper类
  @Resource
  private UserService userService;

  // 这里表示一个路径参数id
  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
  public User getUser(@PathVariable long id) throws Exception {

    User user = this.userService.getUserById(id);

    return user;
  }

  // 分页操作demo
  // ?page=1&page-size=5
  // http://localhost:8096/user/list?page=2&page-size=3
  @RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
  // PageInfo PageInfo包装结果，返回更多分页相关信息
  // 方法名listUser
  public PageInfo<User> listUser(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "page-size", required = false, defaultValue = "5") int pageSize) {

    List<User> result = userService.listUser(page, pageSize);
    // PageInfo包装结果，返回更多分页相关信息
    PageInfo<User> pi = new PageInfo<User>(result);

    return pi;
  }

}
