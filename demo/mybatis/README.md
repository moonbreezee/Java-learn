# mybatis-demo

熟悉 MyBatis 的使用

[参考文章](https://juejin.im/post/5b0f71e96fb9a00a031dfec1)

[使用 MYBATIS 实现增、删、改、查](https://www.qikegu.com/docs/1870)

MyBatis 核心特性：

- 通过动态 SQL 与参数绑定，避免复杂的 SQL 语句拼接
- 结果集自动映射成 Java 对象返回

## 创建项目

```xml
  <groupId>org.qiuwww.demo</groupId>
  <artifactId>mybatis</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.15</version>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.1</version>
  </dependency>
```

## steps

### 创建项目模板：maven+quickstart

new Project -> Maven -> SDK -> create from archetype -> maven-archetype-quickstart -> set Properites -> finish

### 在 pom.xml 文件内添加 Mysql 驱动和 Mybatis 依赖，然后点击右下角的 import

右键 -> Generate -> Dependency -> 搜索安装 -> reImport(mavon)

- mybatis
- mysql-connector-java

### 创建文件夹，创建 Resources 文件夹，并设置为 Resources Root

右键 -> new Directory -> 右键 -> make Directory as -> Resources Root

Resources Root，让外面的 java 文件能够访问到里面的资源

通过这个类指定一个文件夹，你告诉 IntelliJ IDEA，这个文件夹及其子文件夹中包含的源代码，可以编译为构建过程的一部分。

### 创建文件，resource 文件夹里面创建两个 xml 文件

右键 -> new File

## be careful

1. 创建项目名不要有破折号，不然会导致之后文件内创建不了 Class 类）

## Error

### Exception in thread "main" java.lang.NullPointerException

这里 c 是一个 null，控对象，所以调用方法会出错。

**Java 空指针异常（java.lang.NullPointerException）**，顾名思义，即对象没有进行实例化便进行了使用。实例化的意义，就是将对象实例的地址赋值给对象符号。

### java 项目名称不能随意改变，会出问题

一般问题`Error:java: 找不到目录: /target/generated-sources/annotations`

## 基本逻辑

[基本逻辑](https://www.qikegu.com/docs/2387)：App.java -> 读取配置文件，生成操作 session 对象 -> 增删改查(insert | delete | update | selectOne);

[映射文件](https://www.qikegu.com/docs/2388)： UserMapper.xml <-> User.java

## MyBatis 和 Hibernate

MyBatis 和 Hibernate 之间有很大的区别，**Hibernate 以 Java 对象为中心**，是一种 ORM，**MyBatis 以 sql 为中心，是加强版 sql**，两者适用场景不一样。

MyBatis 的使用场景：

- 希望直接优化维护 sql
- 系统由关系数据模型驱动
- 必须处理现有数据或复杂数据
