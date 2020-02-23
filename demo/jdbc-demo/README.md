# jdbc 增删改查 demo

[JDBC 的使用](https://www.runoob.com/w3cnote/jdbc-use-guide.html)
[在 IDEA 中使用 JDBC](https://blog.csdn.net/qq_41089854/article/details/93787798)

## 使用 jdbc 驱动来操作数据

1、把驱动拷贝进入项目下的 lib 文件夹夹
2、加载数据库驱动
class.forName(‘com.mysql.jdbc.Driver’);
3、建立数据库连接

- url 的格式
  jdbc:mysql://localhost:3306/people_manage
  协议：子协议：//目标 IP 地址：端口/数据库
- 建立连接语句
  Connection connection = DriverManager.getConnection(
  “jdbc:mysql://localhost:3306/people_manage”, “root”,“123456”);
  4、执行查询语句
  5、释放资源，断开连接

## 使用到的包

- mysql-connector-java

## JDBC 编程步骤

获得数据库连接：

```java
DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database_name", "root", "password");
// 创建Statement\PreparedStatement对象：
conn.createStatement();
conn.prepareStatement(sql);
```

## sql 语句拼接

- 注意空格

```java
String sql = "UPDATE imooc_goddess" +
                " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?,"+
                " update_user=?, update_date=CURRENT_DATE(), isdel=? "+
                " where id=?";
```