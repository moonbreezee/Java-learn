# demo

[TOC]

## 创建一个普通 java 项目并运行

参看 demo：firstjavaproject

- file -> new -> project
- java && project SDK
- 创建一个文件包: src —> new —> package
- 在包下面创建 java 类文件，点击包名 —> New —> Java Class
- 运行 java 文件，点击 Run —> Run...
- 在下部分查看运行结果

## 创建一个 Maven 项目，搭建一个 web 服务

参看 demo：MavenWebServer

[参考实例](https://zhuanlan.zhihu.com/p/25987991)

Maven 项目是以 pom 文件引入各项 jar 包的。

找到主函数，然后左侧运行。

pom.xml 就相当于 package.json，保存项目的配置及依赖。

### Maven 配置

- GroupID: 是项目组织唯一的标识符，实际对应 JAVA 的包的结构，是 main 目录里 java 的目录结构。一般 GroupID 就是填 com.leafive.test 这样子。
- ArtifactID: 就是项目的唯一的标识符，实际对应项目的名称，就是**项目根目录的名称**。

Maven 更像是一个预设的脚手架，包括一些特定的设置，并且可以通过后续的 cli 指令来进行项目管理。

maven 是一个出色的**java 构建工具**，我们通过 maven 来构建 springboot 的 jar 包与依赖，maven 用法非常简单。

### 通过 maven 构建 SpringBoot 的 jar 包与依赖包

SpringBoot 是通过 main 方法直接将内置的 tomcat 启动的。

#### 重新导入依赖，应该是依据 pom.xml 来更新的

1. 右键单击项目；
2. 在弹出菜单中选择 Maven -> Reimport 菜单项。

### 启动服务

- 编码完毕，添加 controller，添加 main 函数
- 我们要启动一个 web 服务了，启动的方法可以通过 gradle 或者 maven 命令，
- 直接通过 jar 命令的方式启动，对于 IEDA 来说，直接 run 这个 Application 类就 Ok 了。
- 访问接口: `http://localhost:8080/string`
- Application 最好和 controller 放在同一目录下，要不只能启动，但是不能访问

## 创建一个工程，使用 JDBC，可以操作链接数据库，并通过接口实现增删改查

[参考实例](https://www.runoob.com/w3cnote/jdbc-use-guide.html)

## 在 MavenWebServer 工程的基础上，添加后段页面输出，增删改查接口的实现

本地数据路信息

创建数据库: DATABASE: "jdbcDB",
USERNAME: "root",
PASSWORD: "911029",
connectionLimit: 10,
PORT: "3306",
HOST: "127.0.0.1"

```sql
create database jdbcDB;
show databases;
use jdbcDB;
show tables;

CREATE TABLE IF NOT EXISTS `user`(
  `id` INT UNSIGNED AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `age` INT(10) NOT NULL,
  PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user
    (id, name, age)
    VALUES
    (1, "hahaha", 12);
INSERT INTO user
    (id, name, age)
    VALUES
    (2, "dididi", 19);

SELECT * FROM `user`;

UPDATE `user` SET name='titititt' WHERE id=1;

DELETE FROM `user` WHERE id = 2;
```
