package org.moonbreezee.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.moonbreezee.demo.User;
//这里是一个接口
public interface UserMapper {

  final String getAll = "SELECT * FROM user";
  final String getById = "SELECT * FROM user WHERE id = #{id}";
  final String deleteById = "DELETE from user WHERE id = #{id}";
  final String insert = "INSERT INTO user (name) VALUES (#{name})";
  final String update = "UPDATE user SET name = #{name} WHERE id = #{id}";

  @Select(getAll)
  @Results(value = {
    @Result(property = "id", column = "id"),
    @Result(property = "name", column = "name")
  })
  List<User> getAll();

  @Select(getById)
  @Results(value = {
    @Result(property = "id", column = "ID"),
    @Result(property = "name", column = "NAME")
  })
  User getById(long id);

  @Update(update)
  void update(User user);

  @Delete(deleteById)
  void delete(long id);

  @Insert(insert)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(User user);
}


