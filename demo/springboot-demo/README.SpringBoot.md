# Spring Boot

[Spring Boot 集成教程](https://www.qikegu.com/docs/2523)

## 创建项目， Spring Boot Maven 多模块项目的过程

[Maven 多模块项目搭建](https://symonlin.github.io/2019/01/15/springboot-1/)

new Project -> Spring Initializr -> {mysql、Spring web、data jdbc、mybatis Framework、data redis} -> next -> done

删除无用的 .mvn 目录、 src 目录、 mvnw 及 mvnw.cmd 文件，最终只留 .gitignore 和 pom.xml

## why

Spring Boot 是一个**基于 spring 框架的项目模板**(umi)，用于简化 Spring 应用开发。开发 spring 应用时，总有很多**繁琐的配置**要做，spring boot 把这部分工作替我们做了。

### Spring boot 的优点

- 简化繁琐的 spring 配置（xml/java 配置）；
- 提供**内嵌的 http 服务器**（tomcat/jetty），每个 spring boot 应用都是独立的 web 服务，简化部署（这点特别适用于微服务）；
- 简化 maven 依赖配置；
- 提供运行监测工具；

### Spring boot 的模块

Spring boot 有 4 个主要模块：

- Spring Boot 启动模板(Starter)
- Spring Boot 自动配置器(AutoConfigurator)
- Spring Boot 命令行工具(cli)
- Spring Boot 执行器(Actuator)

另外还有常用的工具模块：

- Spring Initilizr
- Spring Initilizr 用于生成 spring boot 项目

spring 常被人诟病的一点是配置很繁琐，有 n 多 xml 配置文件要写，Spring Boot AutoConfigurator 的作用就是简化繁琐的 spring 配置。spring boot AutoConfigurator 通过**合理推测**会自动生成 spring 配置文件。

## web 服务

依靠 spring-boot-starter-web

## 连接 Mysql

### JDBC

Java 应用通过 JDBC 接口访问数据库，**JDBC（Java DataBase Connectivity/Java 数据库连接）为各种数据库，如 mysql、oracle 等，提供一个统一的接口，应用程序通过 JDBC 执行各种 SQL 操作**，如 select、insert 等等。在本文中，我们会通过 JDBC 访问数据库，验证数据库是否正常连接。

### JPA

JPA（Java Persistence API/Java**持久层接口**），是**ORM（Object Relational Mapping/对象关系映射**）的一个标准，**ORM 的作用是在数据库表与 Java 对象之间建立映射**，理论上来说有 ORM 就无需直接通过 SQL 操作数据库了，通过 Java 对象即可，这样会方便很多，Hibernate 是实现 JPA 标准的一个有名例子。JPA 建立在 JDBC 之上，也是通过 JDBC 访问数据库。

### Mybatis

ORM 有一些缺点，如过于笨重，比如在**多表联合查询时相当繁琐**，**但直接使用原始的 JDBC 操作数据库过于低效**，mybatis 是现在互联网项目使用比较多的一个 Java 持久层库。虽然 mybatis 经常被和 Hibernate 比较，**但 mybatis 不是 JPA 的一个实现**，mybatis 可以理解为加强版的 SQL，实现了诸如动态 SQL、结果集映射等，高效又不失灵活，个人倾向使用 mybatis。同样的，mybatis 建立在 JDBC 之上，通过 JDBC 访问数据库。后面的教程将对 mybatis 做详细介绍。

## 修改默认线程链接池

spring boot 现在的默认连接池是 Hikari，号称是性能最好的连接池，不过国内使用较多的是阿里开源的 druid 连接池，在阿里的诸多项目中经过实践验证，本文介绍怎样在 spring boot 中集成 druid。

```xml
<dependency>
   <groupId>com.alibaba</groupId>
   <artifactId>druid-spring-boot-starter</artifactId>
   <version>1.1.10</version>
</dependency>
```

## mybatis

src/main/java/com/qikegu/demo 文件夹下添加目录：

- common – 公用代码
- config – spring java 配置文件
- controller – 控制层
- model – 对象层
- repository – 数据库访问层，保存 mybatis 的映射类
- service – 服务层

src/main/resources 文件夹下添加目录：

- mapper – mybatis sql 映射 xml 文件

### 主要步骤

1. 添加 mvc 文件架构
2. application.properties 配置映射文件
3. @MapperScan 的作用是指定要扫描的 mybatis 映射类的路径，放在应用类的前面，指定路径

### 调用过程

用户访问 > UserController > UserService > UserMapper.java > UserMapper.xml > 数据库，返回 User 对象

## 使用 pagehelper 实现分页

pagehelper-spring-boot-starter

[添加 springboot 中的配置](https://www.qikegu.com/docs/2558#%E9%A1%B9%E7%9B%AE%E9%85%8D%E7%BD%AE)

## mybatis generator 配置

MyBatis Generator 是一个代码生成器，可以为 mybatis 自动生成对应数据库表结构的实体类、mapper 接口以及对应 mapper.xml，大大减少这些繁琐重复的劳动，很方便。

MyBatis Generator 被设计为可以多次运行，生成代码时，java 文件一般会被覆盖，xml 文件新旧代码会合并。

MyBatis Generator 有三种用法：命令行、eclipse 插件、maven 插件。我们这里介绍最方便的 maven 插件用法。

### 添加依赖

在 pom.xml 的 build > plugins 下添加依赖

配置文件 generatorConfig.xml

自动生成文件，位于

- model
- repository
- mapper

右侧 maven -> Plugins -> generate -> run

## 接口返回值封装

在实际项目中，一般会把结果放在一个封装类中，封装类中包含 http 状态值，状态消息，以及实际的数据。

- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/controller/ResultWrapController.java
- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/common/util/Result.java

## 输入数据校验(validation)

- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/controller/AuthController.java
- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/model/RegisterRequest.java
- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/common/util/Result.java
- demo/springboot-demo/src/main/java/com/qiuwww/demo/springbootdemo/common/util/MiscUtil.java

## 环境配置（profile）切换

spring boot 项目中，application.properties 是配置文件，实际上我们还可以引入不同环境的配置文件，如：application-dev.properties，application-prod.properties，通过指定 spring.profiles.active 的值切换配置文件。

application-dev.properties – 开发环境配置
application-prod.properties – 生产环境配置
application-test.properties – 测试环境配置

可以通过@Value 注解读取 profile.name，赋给 profileName。

## redis 缓存（cache）集成

redis 是一个开源的内存 NOSQL 数据库，在 web 开发中主要被用于数据缓存。**一般在高并发的情况下，web 服务器接受访问时**，**直接从数据库加载是慢的，需要把常用数据缓存到 redis 中，提高加载速度和并发能力**。

- 需要用到 commons-pool2 库。

在 application.properties 文件中配置 redis 服务器的连接。

### 常用的缓存注解

@Cacheable – **表明对应方法的返回结果可以被缓存**，首次调用后，下次就从缓存中读取结果，方法不会再被执行了。
@CachePut – **更新缓存，方法每次都会执行**
@CacheEvict – 清除缓存，方法每次都会执行

因为主要的业务逻辑在服务层实现，一般会把缓存注解加在服务层的方法上。

## Redis

使用 Homebrew 安装 redis，默认安装 redis 最新稳定版

```shell
brew install redis
```

安装完毕后,会在 `/usr/local/etc` 路径下有 redis.conf 文件，该文件就是 redis 的配置文件。

### 为了方便开发者的使用，我们需要修改几个配置，如下

daemonize 的默认配置是 no，将其改为 yes。这个配置项意思是 Redis 的守护模式是否开启。no：不开启，那这意味着 redis 要必须保持命令终端开启而不能 后台启动，改为 yes 则代表开启守护模式，这样一来就可以后台启动 redis 不需要一直停留在终端启动窗口，提高开发使用效率。

port 是 redis 的端口属性，默认是 6379，一般来说在开发环境下很少去改动这个默认的端口配置，如果需要修改则改成自己想设置的即可。

loglevel 是日志的级别，默认是 notice。将其设置为 debug，如此一来的设置对于开发者是很友好的，看到更多和开发相关的信息。

logfile 是 redis 日志文件的保存位置，默认是空的，需要自行添加一个日志保存路径，这里建议把保存 redis 日志文件创建在无需 sudo 命令就能够打开执行的位置，否则 redis 启动时加载日志时显示没有足够权限访问，那么就会启动失败，所以这里建议用户设置为不需要 sudo 权限就可以读写的位置中去，【建议在 Users 路径下创建目录来进行保存日志】。

### 启动

使用的时候，必须要打开啊。

```shell
# redis-server [配置文件所在的路径]/redis.conf
redis-server /usr/local/etc/redis.conf
```

### 操作

```shell
redis-cli
127.0.0.1:6379> keys \*
(empty list or set)
127.0.0.1:6379> SHUTDOWN
not connected> exit
```

基本指令：

- keys \* 查看所有 key 的内容
- exists key 查看 key 是否存在
- set key value 设置 key 的内容
- get key 获取 key 的内容
- flushall 清空所有

### 关闭

找到 redis 对应的 pid 服务 `kill -9 Pid` 杀死服务进程即可

### 图形管理工具

这里使用，electron 的管理工具：`https://github.com/qishibo/AnotherRedisDesktopManager/`。

fork 一下，还可以学习一下 electron 的代码。
