package org.qiuwww.multimodule.biz.service.impl;

import org.qiuwww.multimodule.biz.service.ModuleService;
import org.qiuwww.multimodule.dao.model.User;
import org.qiuwww.multimodule.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {
  
  @Autowired
  private UserMapper userMapper;
  
  @Override
  public String hello() {
    return "interface hello!";
  }
  
  @Override
  public String hello2() {
    int id =  1;
    // 这里请求一次就会生成一个新的对象。
    User user = userMapper.selectByPrimaryKey(id);
    
    System.out.println(user.toString());
    
    return user.getName();
//    return "interface hello!";
  }
}
