# Spring

[参考文档](https://www.qikegu.com/docs/1468)

Spring 框架是 Java EE 开发中最流行的框架，已经成为 JEE 事实上的标准，全世界的开发人员都在使用 Spring 框架开发各种应用。随着 Spring boot，Spring cloud 新版本的不断推出，以及微服务的流行，Spring 已经成为 JEE 开发“必修”项目。

Spring 是一个 JEE 开发框架，开源，轻量级，功能强大。

JEE – `Java Enterprise Edition` / Java 企业版
主要用于开发企业软件的 Java 版本。企业软件例子：会计软件、帐单管理、业务流程管理、CMS、CRM、ERP 等。

## Spring 框架

Spring 框架大概由 20 来个模块组成。这些模块可以分成几个大的层次：核心容器、数据访问/集成、Web、AOP(面向切面编程)、工具和测试等，如下图所示。开发者可以根据需要选择其中的模块使用，由于是模块化的结构，所以很容易与其他框架一起集成使用。

### 核心容器

核心容器层是 spring 框架的基础，其他层都依赖于这一层，核心容器这一层包含以下 4 个模块:

- Spring Core：这个模块是 Spring 框架的核心，提供**控制反转/依赖注入**功能
- Spring Bean：这个模块**实现 Bean 的工厂模式**，**Bean 可以理解为组件**，是 JEE 中**基本的代码组织单位**，**Spring 中 Bean 形式是普通 Java 类**
- Spring Context：此模块表示 Spring**应用的环境**，通过此模块可访问任意 Bean，ApplicationContext 接口是模块的关键组成
- Spring 表达式语言(SpEL)：这个模块**提供对表达式语言(SpEL)支持**

### Spring 数据访问/集成

**数据访问**相关，由以下 5 个模块组成:

- JDBC：对 Java JDBC 接口**再次包装**，让 Spring 应用中使用 JDBC 更简单
- ORM: ORM 代表**对象关系映射**，该模块提供对 ORM 的支持
- OXM: OXM **代表对象 XML 映射器**，该模块提供对 OXM 的支持
- JMS: JMS 代表 Java **消息传递服务**，该模块提供对 JMS 的支持
- 事务: 该模块提供数据库事务的支持

### Spring Web

**Web 层包**括以下模块:

- Web：提供基本的 Web 功能，如文件下载、rest 接口支持等
- web-servlet：实现 MVC（Model-View-Controller）功能
- web socket：提供对 web socket 的支持
- web portlet：提供对 web portlet 的支持

### 其他模块

- AOP 提供对**面向切面编程**的支持
- Aspects 提供与 AspectJ 集成，AspectJ 是另一个面向切面编程的框架
- Instrumentation 提供在某些应用服务器中使用的类加载实现
- Messaging 提供对 STOMP(Simple (or Streaming) Text Oriented Message Protocol )的支持
- Test 支持 JUnit 或 TestNG 框架测试 Spring 组件

## 创建一个简单的 Spring 应用

[IDEA 创建 Maven 项目 Spring](https://www.cnblogs.com/Sinte-Beuve/p/5730553.html)

创建 Spring 应用步骤：

- 创建一个 maven 项目，选中 maven-archetype-webapp 这个 archetype
- 配置 tomcat
- 添加 spring 库依赖，spring-web & spring-webmvc
- 创建 Bean 类
- 添加 Bean 的 xml 装配文件
- 创建主类
- 运行应用程序

### 项目结构

项目目录说明：

- src – 源码目录
  - main – 代码
    - java – Java 代码目录
      - package
        - controller - 控制器
        - dao - 数据访问
        - pojo - 实体类
        - service - 业务逻辑
    - resources – 配置文件等资源目录
    - webapp
      - WEB-INF
        - static - css/js
        - view - 视图
        - web.xml - web 配置文件
  - test – 测试代码
    - java
- target – 编译后的输出目录

项目根目录下的 pom.xml 文件就是 maven 的依赖包配置文件。

#### 文件夹类型

- Sources 一般用于**标注类似 src 这种可编译目录**。有时候我们不单单项目的 src 目录要可编译，还有其他一些特别的目录也许我们也要作为可编译的目录，就需要对该目录进行此标注。只有 Sources 这种可编译目录才可以新建 Java 类和包，这一点需要牢记。
- Tests 一般用于标注**可编译的单元测试目录**。在规范的 maven 项目结构中，顶级目录是 src，maven 的 src 我们是不会设置为 Sources 的，而是在其子目录 main 目录下的 java 目录，我们会设置为 Sources。而单元测试的目录是 **src - test - java**，这里的 java 目录我们就会设置为 Tests，表示该目录是作为可编译的单元测试目录。一般这个和后面几个我们都是在 maven 项目下进行配置的，但是我这里还是会先说说。从这一点我们也可以看出 IntelliJ IDEA 对 maven 项目的支持是比较彻底的。
- Resources 一般用于**标注资源文件目录**。在 maven 项目下，资源目录是单独划分出来的，其目录为：**src - main -resources**，这里的 resources 目录我们就会设置为 Resources，表示该目录是作为资源目录。资源目录下的文件是会被编译到输出目录下的。
- Test Resources 一般用于标注单元测试的资源文件目录。在 maven 项目下，单元测试的资源目录是单独划分出来的，其目录为：**src - test -resources**，这里的 resources 目录我们就会设置为 Test Resources，表示该目录是作为单元测试的资源目录。资源目录下的文件是会被编译到输出目录下的。
- Excluded 一般用于标注**排除目录**。被排除的目录不会被 IntelliJ IDEA 创建索引，相当于被 IntelliJ IDEA 废弃，该目录下的代码文件是不具备代码检查和智能提示等常规代码功能。

通过上面的介绍，我们知道对于非 maven 项目我们只要会设置 src 即可。
（引用自`http://wiki.jikexueyuan.com/project/intellij-idea-tutorial/eclipse-java-web-project-introduce.html`）

### 配置访问路径与视图

- 创建一个类命名 HomeController，并注解@Controller，这个类就会被当成 Controller
- 再加上访问路径的注解@RequestMapping("/home")
- 在 HomeController 内创建一个 hello 方法，在方法上注解@RequestMapping("/hello")，这样当访问`http://localhost:8080/spring-helloworld/home/hello`的时候，就会执行这个方法
- 最后 return "hello"，这样执行完 hello 方法后会跳转到 hello.jsp（hello.jsp 需要建在 WEB-INF-views 下）

### IOC

IoC（Inversion of Control ）代表控制反转，Spring 框架本质上是一个 IoC 容器。

控制反转(Inversion of Control / IoC)与依赖注入（Dependency Injection / DI）就是为解决这个问题。

#### 问题

Java 程序中，Java 类是基本的代码组织单位。**当某个类要使用另一个类时，自然的做法是创建另一个类的对象，然后调用该对象的方法**。这样做在程序规模较小时没什么问题，但当程序规模很大时这些类之间**过于紧密的耦合会导致后续开发维护困难**。例如要替换其中某个类，就不得不修改所有涉及这个类的代码。

上面提到**类里面创建另外一个类实例会造成耦合太紧**，Spring 框架就**把创建类实例的行为从类中拿出来放到 Spring 框架里去做**，类与类之间创建关系就没有了。类似于状态控制器 redux。

本来由类控制其所依赖的另一个类的实例创建，现在**把创建动作放到 Spring 框架里了**，由框架控制所有类的实例创建，这就是“控制反转”（抽离状态 store）。

框架创建了类所依赖的对象，**然后把这些对象传给（注入）类**，这就是“依赖注入”（connect）。

Spring 框架中控制反转(Inversion of Control / IoC)与依赖注入（Dependency Injection / DI）实际上讲的是同一个事情，只是角度不同。

#### IoC 容器执行的主要任务

- 创建 bean 实例(new ...)
- 根据配置文件装配 bean(applicationContext.xml)
- 为 bean 设置初始化参数(bean 的 property)
- 管理 bean 的生命周期

#### 什么是 Bean

Bean 是 Java 中**基本的代码重用单位**，是遵守一定约定的 Java 类。(前端中的组件)

在 Spring 中，Bean 就是普通的 Java 类，由 Spring IoC(redux) 容器实例化、组装、管理。

##### bean 配置方式有 3 种

- XML 配置 – 使用 XML 文件来配置 bean
- 注解配置 – 使用@Service 或@Component 注解配置 bean
- Java 配置 – 从 Spring 3.0 开始，可以使用 java 程序配置 bean，java 配置用到的主要注解是：@Configuration、@ComponentScan 和@Bean

#### Spring 容器负责管理 Bean 的生命周期，如下所示

- 创建 bean 实例
- 设置 bean 的属性值
- 调用初始化回调方法
- 使用 Bean
- 调用销毁回调方法
- 销毁 Bean

#### Bean 之间的依赖关系

xml 配置文件中，在 bean 的定义中可配置该 bean 的依赖项，通常使用的配置方式有 2 种：

- 构造函数注入
- Setter 方法注入

### Spring 容器

前面教程提到过有 2 种容器：

- ApplicationContext
- BeanFactory

ApplicationContext 基于 BeanFactory，比 BeanFactory 功能更强，更常用。

### Spring 面向切面编程（AOP）(高阶函数，可以直接配置插入位置的函数)

面向切面编程的主要作用是，在**不修改源代码的情况下，可以给目标类打补丁**，让其执行补丁中的代码。

例如，用户类中有个登录方法，现在**需要加用户登录日志**。使用 AOP 就不需要修改用户登录方法，**只需把日志代码注入到用户登录方法前后，让其执行**。日志代码就是“切面”，插入代码的地方（用户类的登录方法）就是“连接点”。

#### 面向切面编程概念

先介绍一些 AOP 的概念

- 切面(Aspect) – 一些横跨多个类的**公共模块**，如日志、安全、事务等。简单地说，日志模块就是一个切面。
- 连接点(Joint Point) – 目标类中**插入代码的地方**。连接点可以是方法、异常、字段，连接点处的切面代码会在方法执行、异常抛出、字段修改时触发执行。
- 建议(Advice) – **在连接点插入的实际代码(即切面的方法)**，有 5 种不同类型（后面介绍）。
- 切点(Pointcut) – 定义了**连接点的条件**，一般通过正则表达式。例如，可以定义所有以 loadUser 开头的方法作为连接点，插入日志代码。

建议类型

- before – 在方法之前运行建议（插入的代码）
- after – 不管方法是否成功执行，在方法之后运行插入建议（插入的代码）
- after-returning – 当方法执行成功，在方法之后运行建议（插入的代码）
- after-throwing – 仅在方法抛出异常后运行建议（插入的代码）
- around – 在方法被调用之前和之后运行建议（插入的代码）
