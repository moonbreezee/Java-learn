package org.moonbreezee.demo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 */
public class App {
  public static void main(String args[]) throws IOException {
    System.out.println("Hello World!");

    // 读取配置文件
    Reader reader = Resources.getResourceAsReader("MybatisConfig.xml");

    // sqlSessionFactory实例生成，类型是SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    // 操作对象，这里有openSession
    SqlSession session = sqlSessionFactory.openSession();
    // System.out.println("session", session);

    System.out.println("------------ 插入数据 -----------");
    // 创建用户对象
    User user = new User("newUser100");
    // 插入新用户到数据库
    session.insert("User.insert", user);
    session.commit();
    System.out.println("数据插入成功");

    System.out.println("------------ 查询用户列表 -----------");
    // select contact all contacts
    List<User> userList = session.selectList("User.getAll");

    // 这里多条数据没法通过直接打印对象的形式打印结果
    for (User u : userList) {
      System.out.println(u.getId() + "," + u.getName());
      // System.out.println(u.getName());
    }

    System.out.println("读取用户列表成功");

    System.out.println("------------ 通过id来读取用户详情 -----------");
    // 这里使用刚才创建的插入对象的id
    User user1 = (User) session.selectOne("User.getById", user.getId());

    System.out.println(user1.getId());
    System.out.println(user1.getName());

    System.out.println("读取用户详情成功");

    System.out.println("------------ 修改用户数据 -----------");
    user1.setName("userNameUpdated");
    session.update("User.update", user1);
    session.commit();

    // 修改用户数据后再查询
    // 这里user1与user2有什么区别
    User user2 = (User) session.selectOne("User.getById", user.getId());
    System.out.println(user2.getId());
    System.out.println(user2.getName());
    System.out.println("修改用户成功");

    System.out.println("------------ 删除用户 -----------");
    // 这里删除当前这一条数据
    session.delete("User.deleteById", user.getId());
    System.out.println("删除用户成功");

    session.commit();
    session.close();
  }
}
