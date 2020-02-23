---
title: servlet-demo
---

[TOC]

## 配置 Tomcat 容器

[参考文章](https://blog.rxliuli.com/p/3dde13/)

[添加 tomcat 的三种方式](https://blog.csdn.net/it_lihongmin/article/details/80783583)

- 使用插件依赖，tomcat7-maven-plugin
- spring boot
- idea 集成 tomcat

## 本地部署 tomcat

首先要下载安装 tomcat，安装在`/Library/apache-tomcat`。

运行 tomcat：`sudo sh startup.sh`;
关闭 tomcat：`sudo sh shutdown.sh`

这里配置就相当于使用 ide 来调用打开与关闭的命令。

run -> run/Debug Configurations -> 左上+，add new Configurations -> tomcat server -> local -> 填写配置信息。

对应打开与关闭操作

- run
- stop

整个工程通过`demo/servlet-demo/src/main/webapp/WEB-INF/web.xml`文件来建立映射关系。

### 出现的问题

运行的时候提示

> mac Intellij Idea Tmocat 启动报 Error running Tomcat: /conf/Catalina

主要是文件夹权限的问题，修改文件夹权限，读和写，然后运用到所有的子文件夹。

每次新增处理函数，需要重启服务。

## web 项目配置文件

- web.xml：Web 项目所需要的一个配置文件。主要用来配置 Servlet, Filter, Listene。
- index.jsp：Maven webapp 原型自带的一个初始的 jsp 首页

## SERVLET 教程

[参考文章](https://www.qikegu.com/docs/1345)

Java servlet 是 Java 中实现 web 服务的一种技术。它是 Java 的第一个 web 技术，虽然后来出现许多新的 web 技术，**Java servlet 仍然牢牢占据主流**。Java servlet 是 Java Enterprise Edition (Java EE)的一部分，**需要运行在 servlet 容器（tomcat）中**。

**二八原则（80%的场景只会用到 20%的技术**，也就是说大多数场景只会用少最常用的技术）

### servlet 概念

servlet 实现的三种方式对比（servlet 和 GenericServlet 和 HttpServlet）

第一种：实现 Servlet 接口
第二种：继承 GenericServlet
第三种：继承 HttpServlet （开发中使用）

通过查看 api 文档发现他们三个(servlet 和 GenericServlet 和 HttpServlet)的关系是

- Servlet 是一个接口，其中含有很多方法如：init（），service（），destory（）方法。
- GenericServlet 是一个实现了 Servlet 接口的实现类，他可以使用 Servlet 中的方法。
- HttpServlet 是 GenericServlet 的实现类（儿子），也就是说间接的实现了 Servlet 接口，
  - 他可以使用 Servlet 的所有方法，和 GenericServlet 的所有的方法（GenericServlet 中没有私有方法,私有方法是继承不来的）,
  - 除此之外，HttpServlet 还自己有了许多方法，如：doGet, doPost, doDelete, doPut, doTrace 等方法对应处理 http 协议里的命令的请求响应过程。
  - 所以，HttpServlet 中拥有最多的方法，想用谁的什么方法就用什么方法（Servlet 接口和 GenericServlet 的方法），所以我们使用的时候是继承这个
    HttpServlet 方法来使用 Servlet。

Java web 服务器：处理客户端发送的 HTTP 请求，然后把 http 响应返回给客户端的**应用软件**

- web 容器：也称为 Servlet 容器或 Servlet 引擎，是 Web 服务器中处理 servlet 交互、管理 servlet 生命周期的软件模块，有时不严格区分服务器与容器，**如 tomcat 可以说是容器也可说是 web 服务器**
- web 应用(webapp)：一个 web 应用程序，如新闻网站，一个 web 应用可以包含多个 servlet

Java Servlet **是处理 HTTP 请求的 Java 对象**，它在 web 容器中运行，web 容器包含在 web 服务器中。

Javaweb 服务器可以同时运行多个 Java Web 应用程序，Java Web 应用程序可以**包含多个 Servlet**。

Java web 应用程序也可以包含 servlet 之外的其他组件，如 Java Server Pages (**JSP**)。

#### HTTP Request 与 HTTP Response

浏览器向 Java web 服务器发送一个 HTTP 请求，**web 服务器检查请求是否指向某个 servlet**，如果是，servlet 容器将找出目标 servlet，然后将请求传递给目标 servlet 处理。**容器通过调用 servlet.service()方法处理请求**，并生成响应返回给浏览器。

### servlet 遵循一定的生命周期，由 servlet 容器管理。生命周期包含以下过程

1. 加载 Servlet 类
2. 创建 Servlet 实例
3. 调用 servlet init()方法
4. 调用 servlet service()方法
5. 调用 servlet destroy()方法

步骤 1、2、3 只在 servlet **初始加载时执行一次**。**默认情况下，servlet 在没有收到请求时不会加载**。但也可以在容器启动时强制加载 servlet，后续内容会有说明。

步骤 4 会被多次执行 —— servlet 每处理一个 HTTP 请求，都会执行一次 service()。
步骤 5 在 servlet 容器卸载 servlet 时执行。

可以在 web.xml 文件中为 servlet 指定初始化参数。

#### 调用 servlet service()方法

对于收到的每个 HTTP 请求，**容器都会调用 servlet service()方法处理请求**。对于 HttpServlet 子类，**通常调用 doGet()、doPost()等方法**。

### API

创建 Servlet 需要使用 Servlet API，Servlet API 相关类包含在 2 个包里：

- javax.servlet – 通用 servlet 相关类的包，**协议无关**
- javax.servlet.http http servlet 相关类的包，跟 http 协议相关

#### GenericServlet

如前所述，**通用 Servlet** 必须继承 javax.servlet.GenericServlet 类，子类通过**重写 GenericServlet 类的抽象函数 service()处理请求、返回响应给客户端**。

#### HttpServlet

方法调用:

- doGet() – 处理 HTTP GET 请求
- doPost() – 处理 HTTP POST 请求，用于将信息发布到服务器
- doPut() – 处理 HTTP POST 请求
- doDelete() – 处理 HTTP DELETE 请求，从服务器删除文档、网页或信息
- init() 与 destroy() – 用于在 servlet 生命周期中保留/释放资源
- getServletInfo() – 返回关于 servlet 的信息，如作者、版本和版权
  当 http 请求到达时，service()会调用相应的方法处理，例如，Http GET 请求会调用 doGet()处理。

## Java web 应用目录结构(WAR 包）

为了让 Java web 服务器（Tomcat, Jetty）运行 Java web 应用程序，需按照标准目录结构打包 Java web 应用程序的资源(servlet、JSP 等)。

下面是一个 web 应用程序标准目录结构:

- MyWebApp (webapp 目录)
  - WEB-INF (目录)
    - web.xml
    - classes (目录)
    - lib (目录)
  - index.jsp

根目录下（这里是 webapp），**除了 WEB-INF 目录**，其他所有目录和文件都是开放访问的。例如，如果你的 web 应用程序被映射到网址

WEB-INF 目录是一个特殊目录，存放 java class 文件，库文件及配置文件，目录中的文件不能从外部浏览器直接访问，而是会被 web 容器运行。

web.xml 文件包含 web 应用的配置信息，web 容器使用这些配置信息来正确部署和执行 web 应用程序。例如，可在 web.xml 中配置 servlet 的 URL。后续会有对 web.xml 详细介绍。

## Context 参数

context 参数的作用范围是整个 web 应用，web 应用内的所有 servlet 都可以访问。

## Servlet 线程安全

多个用户**会同时访问一个页面**，所以 Java web 服务器通常是多线程的。对于某个 servlet，同时有多个请求时，该 Servlet 会在多个线程中被执行，必须考虑线程安全。

Servlet 线程安全要注意的地方：

- servlet service()方法通常应避免使用成员变量、静态变量，如要使用需作互斥
- 局部变量一般是线程安全的，但要注意局部变量指向同一个对象的情况

请求（HttpServletRequest）和响应（HttpServletResponse）对象是线程安全的，每次请求都会创建新实例。

## javaweb 项目的机构

附一个 javaweb 项目的目录结构

```
├── pom.xml //maven的配置文件
└── src
    ├── main
    │   ├── java //java代码的目录
    │   │   └── mygroup
    │   │       ├── controller
    │   │       │   ├── HomeController.java
    │   │       │   └── PersonController.java
    │   │       ├── dao
    │   │       │   └── PersonDao.java
    │   │       └── model
    │   │           └── Person.java
    │   ├── resources //静态资源目录
    │   │   ├── db.properties
    │   │   ├── log4j.xml
    │   │   └── META-INF
    │   │       └── persistence.xml
    │   └── webapp //web应用部署根目录
    │       ├── index.html //因为是静态html文件，不用放到WEB-INF目录下
    │       ├── META-INF
    │       │   ├── context.xml
    │       │   └── MANIFEST.MF
    │       ├── resources //css，js等静态资源是不能放到WEB-INF目录下的，因为WEB-INF下的资源，客户端无法直接访问
    │       │   └── css
    │       │       └── screen.css
    │       └── WEB-INF //jsp都会放到这里，以保证用户无法直接访问jsp，而是通过controller这个目录下的所有内容客户端都无法直接访问，所以不要放静态文件
    │           ├── spring
    │           │   ├── app
    │           │   │   ├── controllers.xml
    │           │   │   └── servlet-context.xml
    │           │   ├── db.xml
    │           │   └── root-context.xml
    │           ├── views
    │           │   ├── edit.jsp
    │           │   ├── home.jsp
    │           │   └── list.jsp
    │           └── web.xml
    └── test
        ├── java
        │   └── mygroup
        │       ├── controller
        │       │   ├── DataInitializer.java
        │       │   ├── HomeControllerTest.java
        │       │   └── PersonControllerTest.java
        │       └── dao
        │           └── PersonDaoTest.java
        └── resources
            ├── db.properties
            ├── log4j.xml
            ├── test-context.xml
            └── test-db.xml
```

### war 与 war exploded

- war 模式这种可以称之为是发布模式，看名字也知道，这是先打成 war 包，再发布；

- war exploded 模式是直接把文件夹、jsp 页面 、classes 等等移到 Tomcat 部署文件夹里面，进行加载部署。因此这种方式支持热部署，一般在开发的时候也是用这种方式。

在平时开发的时候，使用热部署的话，应该对 Tomcat 进行相应的设置，这样的话修改的 jsp 界面什么的东西才可以及时的显示出来。

