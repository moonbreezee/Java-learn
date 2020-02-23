# java projects

fork 别人的代码，来学习基本的项目开发。

## 后端技术

### MyBatis

MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

[推荐文档](https://mybatis.org/mybatis-3/zh/getting-started.html)

MyBatis 的强大特性之一便是它的**动态 SQL**。如果你有使用 JDBC 或其它类似框架的经验，你就能体会到根据不同条件拼接 SQL 语句的痛苦。例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL 这一特性可以彻底摆脱这种痛苦。

## mall，网上商城项目

[仓库地址](https://github.com/macrozheng/mall)

mall 项目致力于打造一个完整的电商系统，采用现阶段流行技术实现。

前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块。

后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等模块。

主要包括：

1. 后台后端：SpringBoot+MyBatis
2. 后台前端：Vue
3. 前台前端项目：

```lua
-- 项目结构
mall
  ├── mall-common -- 工具类及通用代码
  ├── mall-mbg -- MyBatisGenerator生成的数据库操作代码
  ├── mall-security -- SpringSecurity封装公用模块
  ├── mall-admin -- 后台商城管理系统接口
  ├── mall-search -- 基于Elasticsearch的商品搜索系统
  ├── mall-portal -- 前台商城系统接口
  └── mall-demo -- 框架搭建时的测试代码
```

### 后台项目 mall-master

后台项目使用 IDEA 打开，直接下载依赖。

#### 手动导包

```bash
mvn install:install-file
 -Dfile=/Users/qww/Downloads/mysql-connector-java-8.0.15.jar
 -DgroupId=mysql-DartifactId=mysql-connector-java
 -Dversion=8.0.15
 -Dpackaging=jar
```

#### 数据库链接

java 一般操作的逻辑

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/jdbcDB";
    public static final String USER = "root";
    public static final String PASSWORD = "911029";

    public static void main(String[] args) throws Exception {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, age FROM user");
        // 如果有数据，rs.next()返回true
        while (rs.next()) {
            System.out.println(rs.getString("name") + " 年龄：" + rs.getInt("age"));
        }
    }
}
```

先要打开 mysql 数据库。

然后本项目，使用 MyBatis3，`mall-mbg -- MyBatisGenerator生成的数据库操作代码`，具体的配置文件在`/Users/qww/Documents/learn/Java-learn/projects/mall/mall-master/mall-mbg/src/main/resources/generator.properties`文件内定义用户名与 id。

#### 导入数据库

创建数据库 mall，运行 sql 文件。
文件地址：Java-learn/projects/mall/mall-master/document/sql/mall.sql

## 遇到的问题

### java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)

密码错误，修改密码。

## module 的概念

## 多模块项目搭建

[参考文章](https://symonlin.github.io/2019/01/15/springboot-1/)
项目demo

