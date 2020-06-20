package org.qiuwww.demo.runoob;

import org.qiuwww.demo.runoob.DbUtil;
import org.qiuwww.demo.runoob.Goddess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Date;

//---------dao层--------------
public class GoddessDao {
  // 增加
  public static void addGoddess(Goddess g) throws SQLException {
    // 获取连接
    Connection conn = DbUtil.getConnection();
    // sql
    String sql = "INSERT INTO goddess(user_name, sex, age, birthday, email, mobile,"
        + "create_user, create_date, update_user, update_date, isdel)" + "values("
        + "?,?,?,?,?,?,?,CURRENT_DATE(),?,CURRENT_DATE(),?)";
    // 预编译
    PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译SQL，减少sql执行
    // 传参
    ptmt.setString(1, g.getUser_name());
    ptmt.setInt(2, g.getSex());
    ptmt.setInt(3, g.getAge());
    ptmt.setDate(4, new java.sql.Date(g.getBirthday().getTime()));
    ptmt.setString(5, g.getEmail());
    ptmt.setString(6, g.getMobile());
    ptmt.setString(7, g.getCreate_user());
    ptmt.setString(8, g.getUpdate_user());
    ptmt.setInt(9, g.getIsDel());

    System.out.println("ptmt" + ptmt);
    // 执行
    ptmt.execute();
  }

  public static void updateGoddess(Goddess g) throws SQLException {
    // 获取连接
    Connection conn = DbUtil.getConnection();
    // sql, 每行加空格
    String sql = "UPDATE goddess" + " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?,"
        + " update_user=?, update_date=CURRENT_DATE(), isdel=? " + " where id=?";
    // 预编译
    PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译SQL，减少sql执行

    // 传参
    ptmt.setString(1, g.getUser_name());
    ptmt.setInt(2, g.getSex());
    ptmt.setInt(3, g.getAge());
    ptmt.setDate(4, new java.sql.Date(g.getBirthday().getTime()));
    ptmt.setString(5, g.getEmail());
    ptmt.setString(6, g.getMobile());
    ptmt.setString(7, g.getUpdate_user());
    ptmt.setInt(8, g.getIsDel());
    ptmt.setInt(9, g.getId());

    // 执行
    ptmt.execute();
  }

  public static void delGoddess(int id) throws SQLException {
    // 获取连接
    Connection conn = DbUtil.getConnection();
    // sql, 每行加空格
    String sql = "delete from goddess where id=?";
    // 预编译SQL，减少sql执行
    PreparedStatement ptmt = conn.prepareStatement(sql);
    // 传参
    ptmt.setInt(1, id);
    // 执行
    ptmt.execute();
  }

  public static List<Goddess> query() throws SQLException {
    Connection conn = DbUtil.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM goddess");

    List<Goddess> gs = new ArrayList<Goddess>();
    Goddess g = null;
    while (rs.next()) {
      g = new Goddess();
      g.setUser_name(rs.getString("user_name"));
      g.setAge(rs.getInt("age"));

      gs.add(g);
    }
    return gs;
  }

  public static Goddess get(Integer id) throws SQLException {
    Goddess g = null;
    // 获取连接
    Connection conn = DbUtil.getConnection();
    // sql, 每行加空格
    String sql = "select * from  goddess where id=?";
    // 预编译SQL，减少sql执行
    PreparedStatement ptmt = conn.prepareStatement(sql);
    // 传参
    ptmt.setInt(1, id);
    // 执行
    ResultSet rs = ptmt.executeQuery();
    while (rs.next()) {
      g = new Goddess();
      g.setId(rs.getInt("id"));
      g.setUser_name(rs.getString("user_name"));
      g.setAge(rs.getInt("age"));
      g.setSex(rs.getInt("sex"));
      g.setBirthday(rs.getDate("birthday"));
      g.setEmail(rs.getString("email"));
      g.setMobile(rs.getString("mobile"));
      g.setCreate_date(rs.getDate("create_date"));
      g.setCreate_user(rs.getString("create_user"));
      g.setUpdate_date(rs.getDate("update_date"));
      g.setUpdate_user(rs.getString("update_user"));
      g.setIsDel(rs.getInt("isdel"));
    }
    return g;
  }
}