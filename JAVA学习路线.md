# JAVA WEB 学习路线

Java 是最主流的编程语言，Go 是最有前途的编程语言，Python 是学习最多的语言。

了解基础语法，还是要看书或者看视频。

## 学习路线

1. 学好 java 基础，掌握 java 核心技术；
2. 掌握 java web 技术栈，能够做一些项目；
3. java 进阶技术，网络编程、并发编程、JVM 等；
4. 后端进阶技术，分布式、缓存、消息队列等；

## 提纲

- J2EE
- Spring Boot
- Maven
- MySql
- Docker + Terraform + Ansible
- shell

### 必备技能

- 基础语法 Java
- 基本 API
- Java 面向对象（必须看透）
- 设计模式（大致看透..以后慢慢体会）
- Java SE（IO 操作之类的必会）
- MySql（必会）
- JDBC, Servlet 之类的
- Java 反射 多线程 并行编程 锁机制（框架底层，会的越多，后面越轻松）

### 框架部分

- Spring（必会）
- SpringMVC （必会）
- SpringBoot（必会）
- Mybatis.....

Struts2 早已被时代抛弃，Spring 则是当今的霸主，你需要了解 Spring 如何使用，以及 SpringMVC 如何使用，并且学会在项目中使用它。

由于 SpringBoot 最近很火，并且搭建方式比 SpringMVC 更简单，你也可以先学习 SpringBoot，以便更快速地搭建起你的第一个 Java Web 项目。

### Hibernate 和 Mybatis

当你学会了使用 sql 去查询数据，可能还不足以让你在项目中很方便地处理数据，因为我们还需要一个步骤，就是把数据库的数据转化成 Java 里的对象。

orm 框架就是为了解决这一问题而出现的，它可以让一张表和 Java 类一一对应，让数据查询变得非常方便。

Hibernate 和 Mybatis 都是 orm 框架，只不过现在**mybatis 越来越火**了。所以，你需要了解这一技术，因为它会广泛地运用到大部分 Java Web 项目中。

### Maven

编译，打包，运行单元测试等等，因为它本身就是一个构建工具。

最基本的用法就是：学会修改 pom.xml 文件。

### 其他常用组件

- 日志系统：常用的日志系统有 log4j,logging 等等，另外你还需要了解一下 slf4j。
- 单元测试：JUnit

### 需要深入理解的知识点

(理解这些知识点，能够在有提示的情况下码出代码，但不要为了一些细节钻牛角尖)

- 流程控制
- 面向对象的概念
- Java 语法，this 指针、重写和重载、final、static 等等这些基础的东西
- 集合(包括泛型)，常用的集合类
- IO 流，IO 流代码的编写

### 简单过一遍的知识

(你得知道这个知识点是干嘛用的，为什么要学这个知识点，能看懂具体的代码！)

- 异常
- 多线程
- 网络编程
- 反射机制

### JavaWeb 的路线如下

- Tomcat(简单过一下)
- XML/注解(简单过一下)
- Servlet(重点理解)
- HTTP 协议(重点理解)
- Filter 过滤器(重点理解)
- Listener 监听器(简单过一下)
- JSP(简单过一下)
- AJAX、JSON(简单过一下)

### 学习数据库

数据库这里指的是关系型数据库，一般我们以 MySQL 来入门就足够了。常用操作如下：

- 链接数据库
- 库操作
  - 创建库
  - 查看库
  - 修改库
  - 备份库中的数据
  - 删除库
- 表操作
  - 增加表
  - 查看表
  - 修改表
  - 删除表
- 表中数据的操作
  - 增加
  - 查看
  - 修改
  - 删除

Java 连接数据库(JDBC)。

JDBC 这项技术并不难呀，就是模板代码，来来去去就几个步骤：

- 导入 MySQL 或者 Oracle 驱动包
- 装载数据库驱动程序
- 获取到与数据库连接
- 获取可以执行 SQL 语句的对象
- 执行 SQL 语句
- 关闭连接

### 具体路线

- Java 基础-->流程控制-->面向对象(包括 Java 语法)-->Java 集合-->Java IO 流-->异常-->多线程-->网络编程-->反射
- JavaWeb 基础-->HTML/CSS/JavaScript/jQuery-->Tomcat-->XML/注解->Servlet-->HTTP-->Filter 过滤器和监听器-->JSP-->AJAX/JSON-->数据库(MySQL)-->JDBC 和 DbUtils
- 项目管理和框架-->Maven-->SpringBoot
- Linux 基本命令

## Java 基础知识

### 基本数据类型

- int
- double
- char
- 包装类

#### 需要了解

- 类型的使用
- 各类型所占字节数
- 包装类之间的相互转换

### 流程控制

- for 循环
- while 循环
- if...else

### 字符串类型 String 的使用

字符串类型是 Java 中很重要的类型，它不是基本数据类型，但却很常用，熟悉和实践 String 相关的 api，开始你对字符串的学习吧。

### 类和对象

Java 中最重要的两个概念：类和对象，它们有什么用呢，有什么区别和联系呢，请在代码中实践它们吧。

### 数组

数组的初始化方式有哪些，二维数组应该怎么写，把数组当成方法参数又该怎么处理。

## Java 核心技术

**知道怎么用**。最好把这些特性都实现一遍，以加深印象。

### 接口和抽象类

写一些接口，同时写一些实现类去实现这些接口，并且了解一下为什么我们需要接口，为什么子类需要实现接口里的方法。

### 继承，封装和多态

如何理解继承，子类和父类之间有什么联系呢。
封装是一种保护代码的方式，有哪些方式可以实现封装呢。
多态一般分为重载和重写，它们分别怎么使用

### 异常处理

### 集合类

集合类是我们经常需要打交道的东西，List，Map，Set 等等，赶快去熟悉 API，然后写一些测试例子吧。

### IO 输入流和输出流

IO 输入流和输出流可以操作文件，网络数据等内容，如何在 Java 代码中完成这么复杂的操作呢，其实只需要简单的几个 api 就可以了。

这部分应该与 node.js 的 fs 类似。

### 多线程

为了让系统资源最合理地分配和调度，我们需要多线程。

### 可选内容

1. 反射（了解即可，不是入门必须）
2. 枚举类型和泛型（了解即可，不是入门必须）
3. 网络通信（了解基本的 socket 使用即可，需要网络基础）
4. 数据库操作（了解基本的 JDBC 即可，需要数据库基础）

## todoList

### 视频课程

[Java 从编程语言到编程思想](https://www.imooc.com/learn/1154)
[JAVA 零基础入门视频教程(第一季)-慕课网](https://www.imooc.com/learn/85)
[JAVA 面向对象编程基础视频教程(第二季)-慕课网](https://www.imooc.com/learn/124)
[java 异常处理/集合框架/常用类视频教程(第三季)-慕课网](https://www.imooc.com/learn/110)

### 看一下保存的书签，整理出 Java 的知识体系，画出图示。确定学习的优先级

### 研究一下 Java 开发手册

## IDEA

免费版本不支持 Application Servers 也不支持 Tomcat，所以此时更换旗舰版本是可以解决这个问题的。

本人刚开始安装Community版本，Spring-Boot yml配置文件始终无法正常显示使用，浪费大量时间查找原因，配置。后来不得已改为旗舰版，问题解决）

看来社区版真的可能会引起很多问题啊。

56ZS5PQ1RF-eyJsaWNlbnNlSWQiOiI1NlpTNVBRMVJGIiwibGljZW5zZWVOYW1lIjoi5q2j54mI5o6I5p2DIC4iLCJhc3NpZ25lZU5hbWUiOiIiLCJhc3NpZ25lZUVtYWlsIjoiIiwibGljZW5zZVJlc3RyaWN0aW9uIjoiRm9yIGVkdWNhdGlvbmFsIHVzZSBvbmx5IiwiY2hlY2tDb25jdXJyZW50VXNlIjpmYWxzZSwicHJvZHVjdHMiOlt7ImNvZGUiOiJJSSIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9LHsiY29kZSI6IkFDIiwicGFpZFVwVG8iOiIyMDIwLTAzLTEwIn0seyJjb2RlIjoiRFBOIiwicGFpZFVwVG8iOiIyMDIwLTAzLTEwIn0seyJjb2RlIjoiUFMiLCJwYWlkVXBUbyI6IjIwMjAtMDMtMTAifSx7ImNvZGUiOiJHTyIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9LHsiY29kZSI6IkRNIiwicGFpZFVwVG8iOiIyMDIwLTAzLTEwIn0seyJjb2RlIjoiQ0wiLCJwYWlkVXBUbyI6IjIwMjAtMDMtMTAifSx7ImNvZGUiOiJSUzAiLCJwYWlkVXBUbyI6IjIwMjAtMDMtMTAifSx7ImNvZGUiOiJSQyIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9LHsiY29kZSI6IlJEIiwicGFpZFVwVG8iOiIyMDIwLTAzLTEwIn0seyJjb2RlIjoiUEMiLCJwYWlkVXBUbyI6IjIwMjAtMDMtMTAifSx7ImNvZGUiOiJSTSIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9LHsiY29kZSI6IldTIiwicGFpZFVwVG8iOiIyMDIwLTAzLTEwIn0seyJjb2RlIjoiREIiLCJwYWlkVXBUbyI6IjIwMjAtMDMtMTAifSx7ImNvZGUiOiJEQyIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9LHsiY29kZSI6IlJTVSIsInBhaWRVcFRvIjoiMjAyMC0wMy0xMCJ9XSwiaGFzaCI6IjEyMjkxNDk4LzAiLCJncmFjZVBlcmlvZERheXMiOjAsImF1dG9Qcm9sb25nYXRlZCI6ZmFsc2UsImlzQXV0b1Byb2xvbmdhdGVkIjpmYWxzZX0=-SYSsDcgL1WJmHnsiGaHUWbaZLPIe2oI3QiIneDtaIbh/SZOqu63G7RGudSjf3ssPb1zxroMti/bK9II1ugHz/nTjw31Uah7D0HqeaCO7Zc0q9BeHysiWmBZ+8bABs5vr25GgIa5pO7CJhL7RitXQbWpAajrMBAeZ2En3wCgNwT6D6hNmiMlhXsWgwkw2OKnyHZ2dl8yEL+oV5SW14t7bdjYGKQrYjSd4+2zc4FnaX88yLnGNO9B3U6G+BuM37pxS5MjHrkHqMTK8W3I66mIj6IB6dYXD5nvKKO1OZREBAr6LV0BqRYSbuJKFhZ8nd6YDG20GvW6leimv0rHVBFmA0w==-MIIElTCCAn2gAwIBAgIBCTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTE4MTEwMTEyMjk0NloXDTIwMTEwMjEyMjk0NlowaDELMAkGA1UEBhMCQ1oxDjAMBgNVBAgMBU51c2xlMQ8wDQYDVQQHDAZQcmFndWUxGTAXBgNVBAoMEEpldEJyYWlucyBzLnIuby4xHTAbBgNVBAMMFHByb2QzeS1mcm9tLTIwMTgxMTAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxcQkq+zdxlR2mmRYBPzGbUNdMN6OaXiXzxIWtMEkrJMO/5oUfQJbLLuMSMK0QHFmaI37WShyxZcfRCidwXjot4zmNBKnlyHodDij/78TmVqFl8nOeD5+07B8VEaIu7c3E1N+e1doC6wht4I4+IEmtsPAdoaj5WCQVQbrI8KeT8M9VcBIWX7fD0fhexfg3ZRt0xqwMcXGNp3DdJHiO0rCdU+Itv7EmtnSVq9jBG1usMSFvMowR25mju2JcPFp1+I4ZI+FqgR8gyG8oiNDyNEoAbsR3lOpI7grUYSvkB/xVy/VoklPCK2h0f0GJxFjnye8NT1PAywoyl7RmiAVRE/EKwIDAQABo4GZMIGWMAkGA1UdEwQCMAAwHQYDVR0OBBYEFGEpG9oZGcfLMGNBkY7SgHiMGgTcMEgGA1UdIwRBMD+AFKOetkhnQhI2Qb1t4Lm0oFKLl/GzoRykGjAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBggkA0myxg7KDeeEwEwYDVR0lBAwwCgYIKwYBBQUHAwEwCwYDVR0PBAQDAgWgMA0GCSqGSIb3DQEBCwUAA4ICAQAF8uc+YJOHHwOFcPzmbjcxNDuGoOUIP+2h1R75Lecswb7ru2LWWSUMtXVKQzChLNPn/72W0k+oI056tgiwuG7M49LXp4zQVlQnFmWU1wwGvVhq5R63Rpjx1zjGUhcXgayu7+9zMUW596Lbomsg8qVve6euqsrFicYkIIuUu4zYPndJwfe0YkS5nY72SHnNdbPhEnN8wcB2Kz+OIG0lih3yz5EqFhld03bGp222ZQCIghCTVL6QBNadGsiN/lWLl4JdR3lJkZzlpFdiHijoVRdWeSWqM4y0t23c92HXKrgppoSV18XMxrWVdoSM3nuMHwxGhFyde05OdDtLpCv+jlWf5REAHHA201pAU6bJSZINyHDUTB+Beo28rRXSwSh3OUIvYwKNVeoBY+KwOJ7WnuTCUq1meE6GkKc4D/cXmgpOyW/1SmBz3XjVIi/zprZ0zf3qH5mkphtg6ksjKgKjmx1cXfZAAX6wcDBNaCL+Ortep1Dh8xDUbqbBVNBL4jbiL3i3xsfNiyJgaZ5sX7i8tmStEpLbPwvHcByuf59qJhV/bZOl8KqJBETCDJcY6O2aqhTUy+9x93ThKs1GKrRPePrWPluud7ttlgtRveit/pcBrnQcXOl1rHq7ByB8CFAxNotRUYL9IF5n3wJOgkPojMy6jetQA5Ogc8Sm7RG6vg1yow==
