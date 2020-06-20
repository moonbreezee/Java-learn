# Java 知识体系

[TOC]

可以了解一下大神的思考，思想。

## Java 的白皮书为我们提出了 Java 语言的 11 个关键特性

1. Easy：Java 的语法比 C++的相对简单，另一个方面就是 Java 能使软件在很小的机器上运行，基础解释其和类库的支持的大小约为 40kb，增加基本的标准库和线程支持的内存需要增加 125kb。
2. 分布式：Java 带有很强大的 TCP/IP 协议族的例程库，Java 应用程序能够通过 URL 来穿过网络来访问远程对象，由于 servlet 机制的出现，使 Java 编程非常的高效，现在许多的大的 web server 都支持 servlet。
3. OO：面向对象设计是把重点放在对象及对象的接口上的一个编程技术。其面向对象和 C++有很多不同，在与多重继承的处理及 Java 的原类模型。
4. 健壮特性：Java 采取了一个安全指针模型，能减小重写内存和数据崩溃的可能型。
5. 安全：Java 用来设计网路和分布系统，这带来了新的安全问题，Java 可以用来构建防病毒和防攻击的 System。事实证明 Java 在防毒这一方面做的比较好。
6. 中立体系结构：Java 编译其生成体系结构中立的目标文件格式可以在很多处理器上执行，编译器产生的指令字节码(Javabytecode)实现此特性，此字节码可以在任何机器上解释执行。
7. 可移植性：Java 中对基本数据结构类型的大小和算法都有严格的规定所以可移植性很好。
8. 多线程：Java 处理多线程的过程很简单，Java 把多线程实现交给底下操作系统或线程程序完成。所以多线程是 Java 作为服务器端开发语言的流行原因之一。
9. Applet 和 servlet：能够在网页上执行的程序叫 Applet，需要支持 Java 的浏览器很多，而 applet 支持动态的网页，这是很多其他语言所不能做到的。

## Spring Boot

Spring Boot 便是一个社区反馈推动的项目. Spring Boot 可以说是至少近 5 年来 Spring 乃至整个 Java 社区最有影响力的项目之一。Spring Boot 主要包含以下特性：直接嵌入 Tomcat, Jetty 或者 Undertow 作为 Servlet container。从此之后再也不用将应用程序打包成 war 然后上传到 application server 里面了。 提供了 starter POM, 能够非常方便的进行包管理, 很大程度上减少了 jar hell 或者 dependency hell 自动进行 Spring 框架的配置，节省程序员大量的时间和精力，能够让程序员专注在业务逻辑代码的编写上 不需要任何第三方系统，更不需要用 xml 来进行框架的配置，所以 SpringBoot 让 java 应用变的更简单。

SpringBoot 令人振奋的地方，**约定大于配置（类似于 umi）**，**大大简化了配置成本**，在后面的文章中我会逐步介绍它更多的特性与原理。

### 执行流程

- 连接数据源，如：数据库
- 为数据库传递查询和更新指令
- 处理数据库响应并返回的结果

### JDBC 架构

分为双层架构和三层架构。

三层架构多出一层，中间层服务。

## Java 虚拟机

Java 程序最为常见的执行方式，是预先编译为一种名为 **Java 字节码**的中间代码格式。这种代码格式无法直接运行在 CPU 之上，而是需要**借助 JVM 来执行**。换句话说，只要某个平台提供了合乎 JVM 规范的实现，它便能执行这份 Java 字节码。这也就是我们经常说的“一次编写，到处运行”。

## jdk

jdk 是 java 的**开发工具包**，jdk 不分 javaME, javaSE 和 javaEE。

开发 java 必备的 jar 包。

网络上普遍认为

- javaME 就是用来开发嵌入式的，
- javaSE 就是用来开发桌面的，
- javaEE 就是用来开发企业端的。

jar 包是什么，其实就是将一堆**class 格式文件打包**，Java 中把它称为 jar 包，这些 jar 包在**编译器**中能被直接识别，让开发者使用。

### 引用外部 jar 包

对于 idea 来说，导入外部 jar 包有两种办法，

- 一种是手动导入 jar 包，
- 一种是使用 maven。

## JRE

JRE 是 Java 的运行环境组件，JVM 就属于此。

## JavaEE 完整体系架构

[参考文档](https://segmentfault.com/a/1190000007090110)

- JavaEE 是一套使用 Java 进行企业级 Web 应用开发的大家一致遵循的**工业标准**。
- JavaEE 平台提供了一个**基于组件**的方法来加快设计、开发、装配及部署企业应用程序。
- 相较于 Microsoft 的.NET，Sun 公司的 Java\*E 和一系列标准、技术及协议更接近或更满足互联网在智能化 Web 服务方面对开放性、分布性和**平台无关性**的要求。

### JavaEE 的 13 种核心技术规范

#### 1.JDBC（Java Database）数据库连接

JDBC API 允许用户访问任何形式的表格数据，尤其是存储在关系数据库中的数据。

JDBC 是一组用于执行 SQL 的 Java API ，**为访问不同的数据库提供了一种统一的途径**，几乎所有的关系型数据库厂商（DBMS）都提供了 JDBC 的服务或驱动。JDBC 对数据库的访问也具有平台无关性。

#### 2.JNDI（Java Naming and Directory Interfaces）Java 的命名和目录接口

JNDI 是命名目录服务的抽象接口集合，为企业级应用提供了统一的标准化连接，使 Java 能够无缝地获取任何可目录化的企业信息。

在 JavaEE 体系中，JNDI 用来定位各种对象，包括 EJB、数据库驱动、JDBC 数据源及消息连接等。由于 JNDI 是独立于目录协议的，因此还可以用 JNDI 访问各种特定的目录服务，如 LDAP（轻量目录访问协议）、NDS（服务器目录访问服务）。

一种标准的**Java 命名系统接口**，JNDI 提供统一的客户端 API，通过不同的访问提供者接口 JNDI 服务供应接口(SPI)的实现，由管理者将 JNDI API 映射为特定的命名服务和目录系统，使得 Java 应用程序可以和这些命名服务和目录服务之间进行交互。

[如下参考文章](https://www.cnblogs.com/study-everyday/p/6723313.html)

##### 没有 JNDI 的做法

程序员开发时，知道要开发访问 MySQL 数据库的应用，于是将一个对 MySQL JDBC **驱动程序类**的引用进行了编码，并通过使用适当的 JDBC URL 连接到数据库。

```java
Connection conn=null;
try {
    Class.forName("com.mysql.jdbc.Driver", true, Thread.currentThread().getContextClassLoader());
    conn=DriverManager.getConnection("jdbc:mysql://MyDBServer?user=qingfeng&password=mingyue");
    /* 使用conn并进行SQL操作 */
    ......
    conn.close();
}catch(Exception e) {
    e.printStackTrace();
}
finally {
  if(conn!=null) {
  try {
      conn.close();
  }catch(SQLException e) {}
 }  <br>}
```

这是传统的做法，也是以前非 Java 程序员（如 Delphi、VB 等）常见的做法。这种做法一般**在小规模的开发过程中不会产生问题**，只要程序员熟悉 Java 语言、了解 JDBC 技术和 MySQL，可以很快开发出相应的应用程序。

没有 JNDI 的做法**存在的问题**：

1、数据库服务器名称 MyDBServer 、用户名和口令都可能需要改变，由此引发 JDBC URL 需要修改；
2、数据库可能改用别的产品，如改用 DB2 或者 Oracle，引发 JDBC 驱动程序包和类名需要修改；
3、随着实际使用终端的增加，原配置的连接池参数可能需要调整；
4、......

##### 用了 JNDI 之后的做法

首先，在在 J2EE 容器中配置 JNDI 参数，定义一个数据源，也就是 **JDBC 引用参数**，给这个数据源设置一个名称；然后，在程序中，通过数据源名称引用数据源从而访问后台数据库。

修改 mysql-ds.xml 文件的内容，使之能通过 JDBC 正确访问你的 MySQL 数据库，如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<datasources>
  <local-tx-datasource>
    <jndi-name>MySqlDS</jndi-name>
    <connection-url>jdbc:mysql://localhost:3306/lw</connection-url>
    <driver-class>com.mysql.jdbc.Driver</driver-class>
    <user-name>root</user-name>
    <password>rootpassword</password>
  <exception-sorter-class-name>org.jboss.resource.adapter.jdbc.vendorMySQLExceptionSorter</exception-sorter-class-name>
    <metadata>
      <type-mapping>mySQL</type-mapping>
    </metadata>
  </local-tx-datasource>
</datasources>
```

在程序中引用数据源：

```java
Connection conn=null;
try {
  Context ctx=new InitialContext();
  Object datasourceRef=ctx.lookup("java:MySqlDS"); //引用数据源
  DataSource ds=(Datasource)datasourceRef;
  conn=ds.getConnection();
  /* 使用conn进行数据库SQL操作 */
  ......
  c.close();
}
catch(Exception e) {
  e.printStackTrace();
}
finally {
  if(conn!=null) {
    try {
      conn.close();
    } catch(SQLException e) { }
  }
}
```

在系统部署后，如果数据库的相关参数变更，只需要重新配置 mysql-ds.xml 修改其中的 JDBC 参数，只要保证数据源的名称不变，那么**程序源代码**就无需修改。

由此可见，**JNDI 避免了程序与数据库之间的紧耦合**，使应用更加**易于配置、易于部署**。

感觉就是在外部存放了一个变量，来控制链接，类似于 umirc.js 的功能。

J2EE 规范要求所有 J2EE 容器都要提供 JNDI 规范的实现。JNDI 在 J2EE 中的角色就是“交换机” —— J2EE 组件在运行时间接地查找其他组件、资源或服务的通用机制。

在 J2EE 中，JNDI 是把 J2EE 应用程序合在一起的粘合剂。

### 3.EJB（Enterprise JavaBean）

EJB 组件：JavaBean 是在编程环境（IDE）中能够被可视化处理的**可重用组件**，是实现分布式业务逻辑的 Java 组件。我们在开发的时候可以利用这些组件，像搭积木一样建立面向对象的分布式应用。

EJB 容器：是 EJB 组件的**运行环境**，为部署 EJB 组件提供服务，包括事务、安全、远程客户端的网络发布、资源管理等。

EJB 服务器：**管理 EJB 容器的高端进程或应用程序**，并提供对系统服务的访问。
调用 EJB 组件的应该称为 EJB 客户端，客户端可以运行在 Web 容器中。

EJB 是为了"服务集群"和"企业级开发"。

EJB **定义了一组可重用的组件**：Enterprise Beans。开发人员可以利用这些组件，像搭积木一样建立分布式应用。

#### EJB 的官方解释

商务软件的**核心部分是它的业务逻辑**。业务逻辑抽象了整个商务过程的流程，并使用计算机语言将他们实现。

J2EE 对于这个问题的处理方法是将业务逻辑**从客户端软件中抽取出来**，封装在一个组件中。

#### EJB 包含哪 3 种 bean

- session bean（会话 bean）
- entity bean（实体 bean）
- message bean（消息 bean）

#### EJB 的优点有哪些

- 性能优越
- 强大的容器支持

### 4.RMI（Remote Method Invoke）远程方法调用

RMI 协议能够让在某个 Java 虚拟机上的对象，像调用本地对象一样调用另一个 Java 虚拟机中的对象上的方法。

RMI 是一种被 EJB 使用的更底层的协议。

### 5.Java IDL（Interface Description Language）/CORBA（Common Object Broker Architecture）Java 接口定义语言/公用对象请求代理程序体系结构

IDL 是用来描述软件组件接口的一种计算机语言。IDL 通过一种中立的方式来描述接口，使得在不同平台上运行的对象和用不同语言编写的程序可以相互通信交流。

### 6.JSP（Java Server Pages）

JSP(Java Server Page)是一种实现普通静态 HTML 和动态页面输出混合编码的技术。

在运行时态，JSP 将会被首先转换成 Servlet，并以 Servlet 的形态编译运行，因此它的效率和功能与 Servlet 相比没有差别，一样具有很高的效率。

**JSP 页面由 HTML 代码和嵌入其中的 Java 代码所组成**。服务器在页面被客户端所请求以后对这些 Java 代码进行处理，然后将生成的 HTML 页面返回给客户端的浏览器。

JSP 可以使用 Servlet 提供的 API，一般和 JavaBean 结合使用，从而将界面表现和业务逻辑分离。

### 7.Servlet

Servlet 是一种小型的 Java 程序，它扩展了 Web 服务器的功能。

Servlet 是 Java 平台上的 CGI 技术。Servlet 在服务器端运行，动态地生成 Web 页面。

作为一种服务器端的应用，当被请求时开始执行。Servlet 提供的功能大多与 JSP 类似，不过实现的方式不同。

JSP 通常是大多数 HTML 代码中嵌入少量的 Java 代码，而 servlets 全部由 Java 写成并且生成 HTML。**这里可以理解 jsp 相当于模板文件，Servlet 就是用 js 来生成 html。**

### 8.XML（Extensible Markup Language）可扩展标记语言

它被用来在不同的商务过程中共享数据。

### 9.JMS（Java Message Service）Java 消息服务

JMS 是 Java 的消息服务，JMS 的客户端之间可以通过 JMS 服务进行异步的消息传输。
JMS 用于和面向消息的中间件相互通信的应用程序接口(API)。它既支持点对点的域，有支持发布/订阅(publish/subscribe)类型的域，并且提供对下列类型的支持：经认可的消息传递,事务型消息的传递，一致性消息和具有持久性的订阅者支持。
JMS 消息系统带来的好处：1、提供消息灵活性；2、松散耦合；3、异步性。

### 10.JTA（Java Transaction API）Java 事务 API

在 JavaEE 应用中，事务是一个不可或缺的组件模型，它保证了用户操作 ACID（即原子、一致、隔离、持久）属性。

对于那些跨数据源（例如多个数据库，或者数据库与 JMS）的大型应用，则必须使用全局事务 JTA。

### 11.JTS（Java Transaction Service）Java 事务服务

JTS 是一个组件事务监视器。JTS 是 CORBA OTS 事务监控的基本实现。JTS 规定了事务管理器的实现方式。JTS 事务管理器为应用服务器、资源管理器、独立的应用以及通信资源管理器提供了事务服务。

### 12.JavaMail

JavaMail 是**用于存取邮件服务器**的 API，它提供了一套邮件服务器的抽象类。不仅支持 SMTP 服务器，也支持 IMAP 服务器和 POP 服务器。

### 13.JAF（JavaBean Activation Framework）

JavaMail 利用 JAF 来处理 MIME 编码的邮件附件。MIME 的字节流可以被转换成 Java 对象，或者转换自 Java 对象。大多数应用都可以不需要直接使用 JAF。

## JavaEE 软件开发体系架构

### 两层架构

传统的客户服务器系统仅只简单地基于两层体系来构建，即**客户端（前台）和企业信息系统（后台）**，没有任何中间件，业务逻辑层与表示层或数据层混在一起。这种两层架构无论从开发、部署、扩展、维护来说，综其只有一个特点——成本高。

### 三层架构

三层架构自上而下将系统分为表示层、逻辑层、持久层。
表示层由处理用户交互的客户端组件及其容器所组成；
业务逻辑层由解决业务问题的组件组成；
数据层由一个或多个数据库组成，并可包含存储过程。

## 描述 J2EE 框架的多层结构，并简要说明各层的作用

### 1. Presentation layer（表示层）

a.表示逻辑（生成界面代码）
b.接收请求
c.处理业务层抛出的异常
d.负责规则验证（数据格式，数据非空等）
e.流程控制

### 2. Service layer（服务层/业务层）

a.封装业务逻辑处理，并且对外暴露接口
b.负责事务，安全等服务

### 3. Persistence layer（持久层）

a 封装数据访问的逻辑，暴露接口
b.提供方便的数据访问的方案（查询语言，API，映射机制等）

### 4. Domain layer（域层）

a.业务对象以及业务关系的表示
b.处理简单的业务逻辑
c.域层的对象可以穿越表示层，业务层，持久层

软件分层结构使得代码维护非常方便，设计明确，各层独立，专注自己擅长的领域。

## Tomcat

### Tomcat 服务器的默认端口是多少，怎样修改 tomcat 的端口

默认端口为 8080，可以通过 service.xml 的 Connector 元素的 port 属性来修改端口。

## MVC

在 MVC 模式中，应用程序被划分为模型层（Model）、视图层（View）、控制层（Controller）三部分。

Servlet(model)+JSP(view)+JavaBean(controller)（MVC）这种模式比较适合开发复杂的 web 应用，在这种模式下，Servlet 负责处理用户请求，JSP 负责数据显示，JavaBean 负责封装数据。

### 基于 JavaEE 架构模式下的 MVC

图片参考：J2EE 的 MVC

在这种架构模式下，模型层（Model）定义了数据模型和业务逻辑。为了将数据访问与业务逻辑分离，降低代码之间的耦合，提高业务精度，模型层又具体划分为了 DAO 层和业务层，DAO 即 Data Access Object，其主要职能是将访问数据库的代码封装起来，让这些代码不会在其它层出现或者暴露出来给其它层；业务层是整个系统最核心也是最具有价值的一层，该层封装应用程序的业务逻辑，处理数据，关注客户需求，在业务处理过程中会访问原始数据或产生新数据，DAO 层提供的 DAO 类能很好地帮助业务层完成数据处理，业务层本身侧重于对客户需求的理解和业务规则的适应，总体说来，DAO 层不处理业务逻辑，只为业务层提供辅助，完成获取原始数据或持久层数据等操作。

JSP：JSP 被用来产生 Web 的动态内容。这层把应用数据以网页的形式呈现给浏览器，然后数据按照在 JSP 中开发的预定的方式表示出来，这层也可以称之为**布局层**。

Servlet：JSP 建立在 Servlet 之上，Servlet 是 J2EE 的重要组成部分。Servlet **负责处理用户请求**，Java Web 项目的所有配置都写在了 web.xml 配置文件里，**当项目运行的时候，web.xml 会将 http 请求映射给对应的 Servlet 类。**

JavaBean：由一些**具有私有属性的 Java 类组成**，对外提供 get 和 set 方法。
JavaBean 负责数据，负责处理视图层和业务逻辑之间的通信。

Service：**业务处理类**，对数据进行一些预处理。

DAO：**数据访问层**，JDBC 调用存储过程，从数据库（DataBase）那里获取到数据，再封装到 Model 实体类中去。

- Dao 层是专门负责和数据库交互，数据处理的代码层
- Dao 是接口，DaoImpl 是 Dao 接口的实现类

### protected

### 怎么把堆中的对象输出出来

### List

### @Override

### archetype， 项目圆原型

## JDK管理及切换

jdk11
jdk8

## 堆中的对象地址转为字符串的实体

比如：org.qiuwww.multimodule.dao.model.User@40c286e8

### ans

1. 采用 Object.toString()方法，重写类的toString方法。
