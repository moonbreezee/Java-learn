# 多模块项目搭建

[参考文章](https://symonlin.github.io/2019/01/15/springboot-1/)
项目 demo

## 项目信息

```xml
<!-- 为了与其他相关的demo区分，这里最后一个选项使用artifactId拼接 -->
<groupId>org.qiuwww.multimodule</groupId>
<artifactId>multi-module</artifactId>
<!-- 次一级的 package 应该也要与这里的 id 保持一致 -->
```

每个子包的 package:

- org.qiuwww.multimodule.web
- org.qiuwww.multimodule.biz
- org.qiuwww.multimodule.common
- org.qiuwww.multimodule.dao

## 项目结构

- biz 层（业务逻辑层）
- dao 层（数据持久层）
- common 层（公用组件层）
- web 层（请求处理层）

biz 层依赖 dao 及 common 层， web 层依赖 biz 层

依赖关系图**web <- biz <- dao & common**

## 项目创建

1. 「Create New Project 」或者工具栏选择菜单「 File -> New -> Project… 」
2. 「 Spring Initializr 」，Initializr 默认选择 Default ，然后点击「 Next 」
3. 修改 Group 、 Artifact 、 Package 输入框中的值后点击「 Next 」
4. 删除无用的 .mvn 目录、 src 目录、 mvnw 及 mvnw.cmd 文件，最终只留 .gitignore 和 pom.xml

## 创建子模块

1. 选择「 New -> Module 」
2. 侧边栏选择「 Maven 」，点击「 Next 」
3. 填写 ArifactId ，点击「 Next 」
4. 修改 Module name 增加横杠提升可读性，点击「 Finish 」
5. 同理添加「 demo-dao 」、「 demo-common 」、「 demo-web 」子模块。

## 整理父 pom 文件中的内容

① 删除 dependencies 标签及其中的 spring-boot-starter 和 spring-boot-starter-test 依赖，**因为 Spring Boot 提供的父工程已包含，并且父 pom 原则上都是通过 dependencyManagement 标签管理依赖包**。

注：dependencyManagement 及 dependencies 的区别自行查阅文档

② 删除 build 标签及其中的所有内容，spring-boot-maven-plugin 插件作用是**打一个可运行的包，多模块项目仅仅需要在入口类所在的模块添加打包插件**，这里父模块不需要打包运行。而且该插件已被包含在 Spring Boot 提供的父工程中，这里删掉即可。

③ 最后整理父 pom 文件中的其余内容，按其代表含义归类。

## 配置模块间的依赖关系

通常 JAVA Web 项目会按照功能划分不同模块，模块之间通过依赖关系进行协作。

① 首先在父 pom 文件中使用「 dependencyManagement 」标签声明所有子模块依赖

② 其次在 demo-biz 层中的 pom 文件中添加 demo-dao 及 demo-common 依赖

③ 之后在 demo-web 层中的 pom 文件中添加 demo-biz 依赖

## web 请求的数据流向

(module-web)ModuleWebApplication -> ModuleWebController ->(module-biz) ModuleService -> ModuleServiceImpl

需要设置扫描包的值: `@SpringBootApplication(scanBasePackages = "org.qiuwww.multimodule")`

## 通过 mybatis-genertaor 工具生成 dao 层相关文件（ DO 、 Mapper 、 xml ）

[参考文档](https://www.qikegu.com/docs/2561)

1. 添加插件

```xml
<plugin>
  <groupId>org.mybatis.generator</groupId>
  <artifactId>mybatis-generator-maven-plugin</artifactId>
  <version>1.3.7</version>
  <configuration>
    <verbose>true</verbose>
    <overwrite>true</overwrite>
  </configuration>
  <dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.13</version>
        <scope>runtime</scope>
    </dependency>
  </dependencies>
</plugin>
```

2. 添加配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!--导入配置文件-->
    <properties resource="application.properties"></properties>

    <!-- 一个数据库一个context -->
    <context id="default">

        <!-- 注释生成设置 -->
        <commentGenerator>
            <!-- 是否生成注释代时间戳-->
            <property name="suppressDate" value="true" />
            <!-- 是否取消注释 -->
            <property name="suppressAllComments" value="true" />
        </commentGenerator>

        <!--jdbc的数据库连接-->
        <jdbcConnection driverClass="{spring.datasource.driver-class-name}"                         connectionURL="{spring.datasource.url}"
                        userId="{spring.datasource.username}"                         password="{spring.datasource.password}">
            <property name="nullCatalogMeansCurrent" value="true" />
        </jdbcConnection>

        <!-- 类型转换 -->
        <javaTypeResolver>
            <!-- 是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.） -->
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <!-- targetPackage：生成的实体类所在的包 -->
        <!-- targetProject：生成的实体类所在的硬盘位置 -->
        <javaModelGenerator targetPackage="com.qikegu.demo.model" targetProject="src/main/java">
            <!-- 是否允许子包 -->
            <property name="enableSubPackages" value="false" />
            <!-- 是否对modal添加构造函数 -->
            <property name="constructorBased" value="true" />
            <!-- 是否清理从数据库中查询出的字符串左右两边的空白字符 -->
            <property name="trimStrings" value="true" />
            <!-- 建立modal对象是否不可改变 即生成的modal对象不会有setter方法，只有构造方法 -->
            <property name="immutable" value="false" />
        </javaModelGenerator>

        <!-- targetPackage 和 targetProject：生成的  mapper xml 文件的包和位置 -->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <!-- 是否在当前路径下新加一层schema,ex：false路径com.qikegu.demo.model， com.qikegu.demo.model.[schemaName] -->
            <property name="enableSubPackages" value="false" />
            <!-- 是否针对string类型的字段在set的时候进行trim调用 -->
            <property name="trimStrings" value="true"/>
        </sqlMapGenerator>

        <!-- targetPackage 和  targetProject：生成的  java interface 文件的包和位置 -->
        <javaClientGenerator type="XMLMAPPER"
                             targetPackage="com.qikegu.demo.repository"
                             targetProject="src/main/java">
            <!-- 是否在当前路径下新加一层schema,ex：false路径com.qikegu.demo.model， com.qikegu.demo.model.[schemaName] -->
            <property name="enableSubPackages" value="false" />
        </javaClientGenerator>

        <!-- 配置表信息 -->
        <!-- schema即为数据库名 tableName为对应的数据库表 domainObjectName是要生成的实体类 enable*ByExample, 是否生成 example类   -->
        <!-- 不同的表，修改tableName和domainObjectName就可以 -->
        <table tableName="user" domainObjectName="User"
               enableCountByExample="false" enableUpdateByExample="false"
               enableDeleteByExample="false" enableSelectByExample="false"
               selectByExampleQueryId="false">
        </table>
    </context>
</generatorConfiguration>

```

3. 添加 application.properties 文件

4. 在项目根目录上点击鼠标右键弹出菜单，选择：run as -> 4.Maven build...

## 使 generator 来生成数据库操作文件

[参考项目](https://github.com/kevinhwu/spring-boot-example/blob/master/springboot-mybatis-generator-demo/src/main/resources/generatorConfig.xml)

### mapper/\*.xml

这里的文件每次会增量，所以新生成的时候需要删除。

这里的类型会根据数据库的类型来对应生成。

## Error

`Field userMapper in org.qiuwww.multimodule.biz.service.impl.ModuleServiceImpl required a bean of type 'org.qiuwww.multimodule.dao.repository.UserMapper' that could not be found.`

### private Long id

生成的 id 的类型是 long 类型。

- CHAR 0-255 字节 定长字符串
- VARCHAR 0-65535 字节 变长字符串
- BIGINT 8 字节 (-9,223,372,036,854,775,808，9 223 372 036 854 775 807) (0，18 446 744 073 709 551 615) 极大整数值
- INT 4 字节

## 外部 Tomcat 部署 war 包

1. 外部 Tomcat 部署的话，就不能依赖于入口类的 main 函数了，而是要以类似于 w**eb.xml 文件配置的方式来启动 Spring 应用上下文**。

2. 此时在 demo-web 层目录执行「 mvn clean install 」即可打出一个名为 demo.war 的包。
