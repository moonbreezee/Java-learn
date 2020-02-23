package org.moonbreezee.demo;

import java.sql.*;
public class JDBC_update {
  public static void main(String[] args) throws Exception {
    Connection conn = null;
    // 加载驱动类
    Class.forName("com.mysql.cj.jdbc.Driver");
    long start = System.currentTimeMillis();
    // 建立连接
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "911029");
    long end = System.currentTimeMillis();
    System.out.println(conn);
    System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

    System.out.println("改操作");
    // 创建Statement对象
    Statement stmt = conn.createStatement();
    String sql = "update user set name='gagaga' where name='gaga' ";// 生成一条mysql语句
    // 执行SQL语句
    stmt.executeUpdate(sql);
    System.out.println("成功修改数据");

    stmt.close();
    conn.close();
  }
}
