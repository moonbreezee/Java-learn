# Maven

`mvn -version`

[参考文章](https://www.qikegu.com/docs/2457)
[Maven 项目的结构](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

apache Maven。Maven 是一个强大的 Java 项目构建工具，基于 POM(项目对象模型)文件，可用于项目构建、依赖模块管理和 Javadoc 生成等。

## 创建项目模板：maven+quickstart

new Project -> Maven -> SDK -> create from archetype -> maven-archetype-quickstart(多种可选) -> set Properites -> finish

## 在 pom.xml 文件内添加依赖，然后点击右下角的 import

右键 -> Generate -> Dependency -> 搜索安装 -> reImport(mavon)

## 在 Maven 中如何查看类的方法

## 构建工具

构建工具是软件构建过程自动化的一种工具。一个软件项目的构建通常包含以下几部分：

- 生成源代码(如果项目使用了自动生成部分源代码)
- 从源代码生成文档(如 javadoc)
- 编译源代码
- 将编译好的代码打包到 ZIP 包或 JAR 包中
- 把打包好的文件部署到服务器或存储库

## 工作原理

Maven 以 POM 文件(项目对象模型)为中心，POM 文件是 xml 格式，是自动构建的配置文件，位于项目的根目录下。

## 存储库

Maven Repository/存储库，顾名思义是一个存储 JAR 文件的仓库，Maven 根据项目中 pom.xml 文件中提供的 jar 包依赖信息，从存储库中查找并获取需要的 jar 包。

Maven Repository 有 3 种类型:

- Local Repository – 本地库，maven 本地存储库是%USER_HOME%/.m2 目录
- Central Repository – 中央库，Maven 中央库主要放置公共 jar 包，是由 apache maven 社区创建的。
- Remote Repository – 远程库

Maven 搜索依赖项时，会按照：**本地库、中央库和远程库**的顺序进行。

### 远程库

Maven 远程库也是位于网络上的存储库。例如一个公司可能有很多共享的 jar 包文件，就可以搭建一个公司内部的远程库，供众多开发人员使用；**中央库可以认为是一个特殊的远程库**。

## pom.xml 配置内容

[参考文档](https://blog.csdn.net/u012152619/article/details/51485297)

[参考文档](https://www.qikegu.com/docs/2478)

pom.xml 文件中包含了依赖关系、构建目录、源目录、测试源目录、插件、目标等项目信息和配置信息。Maven 读取 pom.xml 文件，然后执行构建目标。

- project pom 文件根元素，表示一个项目
- modelVersion project 元素的子元素，指定 modelVersion 版本号，应该设置为 4.0.0
- groupId project **元素的子元素，指定项目所属的 group**
- artifactId project 元素的子元素，**项目交付件 ID**，项目交付件是指项目的最终交付文件，如 jar、zip、war 等
- version project 元素的子元素，**项目（交付件）的版本号**

一个典型的 pom.xml 文件配置如下：

```xml
<project
  xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0http://maven.apache.org/xsd/maven-4.0.0.xsd"
>
  <!-- 模型版本。maven2.0必须是这样写，现在是maven2唯一支持的版本 -->
  <modelVersion>4.0.0</modelVersion>

  <!-- 公司或者组织的唯一标志，并且配置时生成的路径也是由此生成， 如com.winner.trade，maven会将该项目打成的jar包放本地路径：/com/winner/trade -->
  <groupId>com.winner.trade</groupId>

  <!-- 本项目的唯一ID，一个groupId下面可能多个项目，就是靠artifactId来区分的 -->
  <artifactId>trade-core</artifactId>

  <!-- 本项目目前所处的版本号 -->
  <version>1.0.0-SNAPSHOT</version>

  <!-- 打包的机制，如pom,jar, maven-plugin, ejb, war, ear, rar, par，默认为jar -->
  <packaging>jar</packaging>

  <!-- 帮助定义构件输出的一些附属构件,附属构件与主构件对应，有时候需要加上classifier才能唯一的确定该构件 不能直接定义项目的classifer,因为附属构件不是项目直接默认生成的，而是由附加的插件帮助生成的 -->
  <classifier>...</classifier>

  <!-- 定义本项目的依赖关系 -->
  <dependencies>
    <!-- 每个dependency都对应这一个jar包 -->
    <dependency>
      <!--一般情况下，maven是通过groupId、artifactId、version这三个元素值（俗称坐标）来检索该构件， 然后引入你的工程。如果别人想引用你现在开发的这个项目（前提是已开发完毕并发布到了远程仓库），-->
      <!--就需要在他的pom文件中新建一个dependency节点，将本项目的groupId、artifactId、version写入， maven就会把你上传的jar包下载到他的本地 -->
      <groupId>com.winner.trade</groupId>
      <artifactId>trade-test</artifactId>
      <version>1.0.0-SNAPSHOT</version>

      <!-- maven认为，程序对外部的依赖会随着程序的所处阶段和应用场景而变化，所以maven中的依赖关系有作用域(scope)的限制。 -->
      <!--scope包含如下的取值：compile（编译范围）、provided（已提供范围）、runtime（运行时范围）、test（测试范围）、system（系统范围） -->
      <scope>test</scope>

      <!-- 设置指依赖是否可选，默认为false,即子项目默认都继承:为true,则子项目必需显示的引入，与dependencyManagement里定义的依赖类似  -->
      <optional>false</optional>

      <!-- 屏蔽依赖关系。 比如项目中使用的libA依赖某个库的1.0版，libB依赖某个库的2.0版，现在想统一使用2.0版，就应该屏蔽掉对1.0版的依赖 -->
      <exclusions>
        <exclusion>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-api</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
  </dependencies>

  <!-- 为pom定义一些常量，在pom中的其它地方可以直接引用 使用方式 如下 ：${file.encoding} -->
  <properties>
    <file.encoding>UTF-8</file.encoding>
    <java.source.version>1.5</java.source.version>
    <java.target.version>1.5</java.target.version>
  </properties>
  ...
</project>
```

一般来说，上面的几个配置项对任何项目都是必不可少的，定义了项目的基本属性。

不太常用的属性 classifier 做一下解释，因为有时候引用某个 jar 包，classifier 不写的话会报错。

classifier 元素用来帮助**定义构件输出的一些附属构件**。

附属构件与主构件对应，比如主构件是 kimi-app-2.0.0.jar，该项目可能还会通过使用一些插件生成 如 kimi-app-2.0.0-javadoc.jar （Java 文档）、 kimi-app-2.0.0-sources.jar（Java 源代码） 这样两个附属构件。这时候，javadoc、sources 就是这两个附属构件的 classifier，这样附属构件也就拥有了自己唯一的坐标。

### classifier 的用途在于

1. maven download  javadoc / sources jar 包的时候，需要借助 classifier 指明要下载那个附属构件。

```xml
<dependency>
  <groupId>net.sf.json-lib</groupId>
  <artifactId>json-lib</artifactId>
  <version>2.4</version>
  <classifier>jdk15</classifier>
</dependency>
```

2. groupid 和 artifactId

groupid 和 artifactId 被统称为“**坐标**”是为了**保证项目唯一性而提出的**，如果你要把你项目弄到 maven 本地仓库去，你想要找到你的项目就必须根据这两个 id 去查找。

groupId 一般分为多个段，这里我只说两段，**第一段为域，第二段为公司名称**。域又分为 org、com、cn 等等许多，
其中 **org 为非营利组织**，
**com 为商业组织**。
举个 apache 公司的 tomcat 项目例子：这个项目的 groupId 是 org.apache，它的域是 org（因为 tomcat 是非营利项目），公司名称是 apache，artifactId 是 tomcat。

比如我创建一个项目，我一般会将 groupId 设置为 cn.snowin，cn 表示域为中国，snowin 是我个人姓名缩写，artifactId 设置为 testProj，表示你这个**项目的名称**是 testProj，依照这个设置，你的包结构最好是 cn.snowin.testProj 打头的，如果有个 StudentDao，它的全路径就是 cn.snowin.testProj.dao.StudentDao

3. 引入依赖的时候，有时候仅凭 groupId、artifactId、version 无法唯一的确定某个构件，需要借助 classifier 来进一步明确目标。

### movan 项目添加依赖，如何在 IDEA 中的 Maven 项目中 添加第三方的 Jar 依赖

右键 -> Generate -> Dependency -> 搜索安装 -> reImport(mavon)

### Maven 项目的目录结构

Maven 项目有标准的目录结构。如果遵循该目录结构，就不需要在 POM 文件中指定源代码、测试代码等目录。

```
- src       源代码和测试代码的根目录
  - main    main目录是项目源代码（不含测试目录）的根目录
    - java
    - resources
  - test    test目录包含测试源代码
    - java
    - resources
- target    包含 Maven 生成的所有已编译类、JAR 文件等
```

如果项目是**web 应用程序，则 webapp 目录包含 Java web 应用程序，所以应该在 webapp 中创建包及相关的类**。webapp 目录将成为 web 应用程序的根目录，包含 WEB-INF 目录等。

target 目标目录由 Maven 创建，包含 Maven 生成的所有已编译类、JAR 文件等。在执行 clean 构建阶段时，目标目录会被清除。

## 依赖管理

[Maven – 依赖管理](https://www.qikegu.com/docs/2479)

### 手动下载依赖到目标地址

有时中央库也没有需要的依赖项，如一些第三方 jar 包，开发人员可以自己手动下载，然后放到本地库中。本地库的 jar 包目录必须匹配`<dependency>`中的配置，目录格式是：

`groupId/artifactId/version`

groupId 中**如果有点(.)替换成斜杠(/)**，如上面 jsoup.jar**包所在的目录是**：

```xml
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.11.3</version>
</dependency>

MAVEN_REPOSITORY_ROOT/org/jsoup/jsoup/1.11.3
```

### 外部依赖

外部依赖是指在 maven 中央库，本地库，远程库都不存在的 jar 包，如本地硬盘中的 jar 包。

可通过如下方式配置外部依赖项。

```xml
<dependency>
  <groupId>com.qikegu.com</groupId>
  <artifactId>mydependency</artifactId>
  <scope>system</scope>
  <version>1.0</version>
  <systemPath>${basedir}\war\WEB-INF\lib\mydependency.jar</systemPath>
</dependency>
```

groupId 和 artifactId 都设置为依赖项的名称，scope 元素值被设置为 system。systemPath 元素被设置为指向包含依赖项的 JAR 文件的位置，\${basedir}指向 POM 所在的目录，路径的其余部分与该目录相对应。

## Maven 插件

Maven 实际上是一个插件执行框架，Maven 中的所有任务都是由插件完成的。
