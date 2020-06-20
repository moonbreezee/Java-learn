package org.qiuwww.multimodule.dao.repository;

import org.qiuwww.multimodule.dao.model.User;

public interface UserMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}