package org.qiuwww.demo.runoob;

import org.qiuwww.demo.runoob.Goddess;
import org.qiuwww.demo.runoob.GoddessDao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 */

// 同一个包下边不能存在相同类名的类
public class RunoobApp {
  public static void main(String[] args) throws SQLException {
    System.out.println("Hello World!");
    dateConvent();

    Goddess g = new Goddess();
    g.setUser_name("lili");
    g.setSex(new Integer(1));
    g.setAge(20);
    g.setBirthday(new java.util.Date());
    g.setEmail("2222@22.com");
    g.setMobile("1234567");
    g.setCreate_date(new Date());
    g.setCreate_user("zhang");
    g.setUpdate_date(new Date());
    g.setUpdate_user("wang");
    g.setIsDel(new Integer(0));
    // 所有的方法都是使用类调用，所以声明的时候要添加static
    // 增加一个
    GoddessDao.addGoddess(g);
    // 更新
    // g.setId(1);
    // g.setUser_name("bababa");
    // GoddessDao.updateGoddess(g);
    // 查询，这里的到的list，目前还不太会操作
    // GoddessDao.query();
    // // GoddessDao.get(1);
    // GoddessDao.delGoddess(1);
  }

  public static void dateConvent() {
    // 定义当前时间
    java.util.Date now = new java.util.Date();

    // 将java.util.sql 转为 java.sql.date
    java.sql.Date sqlNow = new java.sql.Date(now.getTime());

    // 将java.sql.date 转为 java.util.date
    java.util.Date utilNow = new java.util.Date(sqlNow.getTime());

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(now);
    System.out.println(df.format(sqlNow));
    System.out.println(utilNow);
  }

}
