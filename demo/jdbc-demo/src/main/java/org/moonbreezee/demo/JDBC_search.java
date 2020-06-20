package org.qiuwww.demo;
import java.sql.*;
public class JDBC_search {
  public static void main(String[] args) throws Exception {
    Connection conn = null;
    // 加载驱动类
    Class.forName("com.mysql.cj.jdbc.Driver");
    long start =System.currentTimeMillis();

    // 建立连接
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
      "root", "911029");
    long end = System.currentTimeMillis();
    System.out.println(conn);
    System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");
    System.out.println("查操作");
    // 创建Statement对象
    Statement stmt = conn.createStatement();

    // 执行SQL语句,查
    ResultSet rs = stmt.executeQuery("select * from user");
    while (rs.next()) {
      System.out.println("name ：" + rs.getString("name") + ",age ："+ rs.getString("age"));
    }
    rs.close();
    stmt.close();
    conn.close();
  }

}
