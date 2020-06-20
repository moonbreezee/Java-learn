package org.qiuwww.demo;

import java.sql.*;
import java.util.Date;
import java.text.*;

public class JDBC_insert {
  public static void main(String[] args) throws Exception {
    Connection conn = null;
    // 加载驱动类
    Class.forName("com.mysql.cj.jdbc.Driver");
    long start = System.currentTimeMillis();
    // 建立连接
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "911029");
    long end = System.currentTimeMillis();
    System.out.println(conn);
    System.out.println("建立连接耗时：" + (end - start) + "ms 毫秒");

    System.out.println("增操作");
    Date curDate = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    // 这里插入固定的参数
    // 这里的日期会自动计算，直接输出没问题
    String curDateString = ft.format(curDate).toString();
    String sql = "insert into user (name, age, create_date)" + " VALUES('kitty',10,'" + curDateString + "');";
    // 创建Statement对象
    Statement stmt = conn.createStatement();
    // 执行SQL语句,查
    stmt.execute(sql);
    System.out.println("成功执行sql" + sql);
    stmt.close();

    // // 动态sql
    String dynamicSql = "INSERT INTO user(name, age, create_date)" + " VALUES(" + "?,?,CURRENT_DATE())";
    // 预编译
    PreparedStatement ptmt = conn.prepareStatement(dynamicSql); // 预编译SQL，减少sql执行
    // 生成实例对象
    User user1 = new User("gaga", 20);
    // 打印生成的user1对象
    System.out.println("user1：" + user1.toString());
    // 传参
    ptmt.setString(1, user1.getUser_name());
    ptmt.setInt(2, user1.getAge());
    System.out.println("插入动态数据sql, " + ptmt);
    // 执行
    ptmt.execute();
    ptmt.close();

    conn.close();
  }

}