
package com.qiuwww.demo.springbootdemo.controller;

import com.qiuwww.demo.springbootdemo.model.User;
import com.qiuwww.demo.springbootdemo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/redis/user")
public class RedisUserController {

  private static final org.slf4j.Logger log = LoggerFactory.getLogger(RedisUserController.class);
  
  // 注入service类
  @Resource
  private UserService userService;

  // 注入RedisTemplate
  @Resource
  private RedisTemplate<String, Object> redis;

  // http://localhost:8096/redis/user/2
  // 这里似乎并没有从redis中读取
  // 读取用户信息，测试缓存使用：除了首次读取，接下来都应该从缓存中读取
  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
  public User getUser(@PathVariable long id) throws Exception {

    User user = this.userService.getUserById2(id);
    // 如下只要调用就会执行的，就看数据从哪里取得
    log.info("user.nickname:" + user.getNickname());
    return user;
  }

  // 修改用户信息，测试删除缓存
  // 这里更新数据，每次都会改变
  // http://localhost:8096/redis/user/2/change-nick

  @RequestMapping(value = "/{id}/change-nick", method = RequestMethod.POST, produces = "application/json")
  public User changeNickname(@PathVariable long id) throws Exception {

    String nick = "abc-" + Math.random();
    User user = this.userService.updateUserNickname(id, nick);

    return user;
  }

  // 使用RedisTemplate访问redis服务器
  @RequestMapping(value = "/redis", method = RequestMethod.GET, produces = "application/json")
  public String redis() throws Exception {

    // 设置键"project-name"，值"qikegu-springboot-redis-demo"
    redis.opsForValue().set("project-name", "qikegu-springboot-redis-demo");
    String value = (String) redis.opsForValue().get("project-name");

    return value;
  }
}
