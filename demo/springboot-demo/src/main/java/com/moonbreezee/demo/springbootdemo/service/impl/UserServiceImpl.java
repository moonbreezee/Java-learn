package com.qiuwww.demo.springbootdemo.service.impl;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qiuwww.demo.springbootdemo.model.User;
import com.qiuwww.demo.springbootdemo.repository.UserMapper;
import com.qiuwww.demo.springbootdemo.service.UserService;

import java.util.List;

// UserServiceImpl – 服务接口实现类
@Service("userService")
public class UserServiceImpl implements UserService {

  // 注入mapper类
  @Resource
  private UserMapper userMapper;

  @Override
  public User getUserById(long userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  // UserServiceImpl.java新增上面接口的实现
  @Override
  public List<User> listUser(int page, int pageSize) {
    List<User> result = null;
    try {
      // 调用pagehelper分页，采用starPage方式。starPage应放在Mapper查询函数之前
      PageHelper.startPage(page, pageSize); // 每页的大小为pageSize，查询第page页的结果
      PageHelper.orderBy("id ASC "); // 进行分页结果的排序
      result = userMapper.selectUser();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }

  // 测试缓存
  private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  private User user = new User(1l, "abc1", "13512345678", "123456", "role-user");

  // redis缓存，表明对应方法的返回结果可以被缓存，首次调用后，下次就从缓存中读取结果，方法不会再被执行了。
  // 这里只有用到的时候才会来访问
  @Cacheable(value = "user", key = "#userId")
  @Override
  public User getUserById2(long userId) {
    log.info("加载用户信息");
    return user;
  }

  // 清除缓存，方法每次都会执行
  @CacheEvict(value = "user", key = "#userId")

  @Override
  public User updateUserNickname(long userId, String nickname) {
    user.setNickname(nickname);
    return user;
  }

}
