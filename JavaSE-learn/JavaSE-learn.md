# JavaSE-learn

[基础语法学习](https://www.qikegu.com/docs/3107)

后续逐渐补充

## 文件结构

- test，一些测试 demo

## 运行 java 文件

### 默认需要先编译后运行

创建类 new class -> test.HelloWorld，创建 test(package)，然后在其下边添加 HelloWorld 类。

```bash
javac -d . test/HelloWorld.java
# 打包结果存放在out文件夹下
java test/HelloWorld
```

### 使用 IDEA 工具配置自动编译

设置 src 为 source 文件夹，这样就可以在其内部添加包以及 java 文件了。

### Error:java: 无效的源发行版: 13

需要切换 language level 为 8。

## 对于基础知识点的测试用例

- basis，用于基础语法
- classAndObject，用于类与对象测试

## basis

Java 可用于：

- 移动应用(特别是 Android 应用)
- 桌面应用程序
- Web 应用程序
- Web 服务器和应用程序服务器
- 游戏
- 数据库连接
- 更多

### JavaDoc

通过 IDEA 生成 Javadoc： Tools --> Generate JavaDoc -->
注意要配置编码，如果不配送为生成乱码，还需要配置 Output directory

zh-CN // 这里不能填这个？
-encoding UTF-8 -charset UTF-8

打印信息会有乱码。

#### 命令行

<!-- 这样打印的信息不会乱码 -->

`javadoc -d ../doc test/HelloWorld.java`
`javadoc -d ../doc *`

### 类型转换

Java 中，有两种类型转换:

- 扩大转换 (自动) – 将字节数较小类型转换为较大类型
  `byte -> short -> char -> int -> long -> float -> double`

- 缩小转换 (手动) – 将字节数较大类型转换为较小类型
  `double -> float -> long -> int -> char -> short -> byte`

### 修饰符

对照 JavaSE-learn/src/classAndObject/Modifier.java

#### 访问修饰符

##### 对于类，可以使用 public 或者缺省值（不指定）

- public 代码对所有类都是可访问的
- private 代码只能在本类中访问
- 缺省值（不指定） 代码只能在同一个包中访问。当不指定修饰符时，将使用此选项
- protected 代码可以在同一个包和子类中访问。

#### 非访问修饰符

##### 对于类，可以使用 final 或 abstract

- final 该类不能被其他类继承
- abstract 该类**不能用于创建对象**(要访问**抽象类**，必须使用抽象类的子类)。

##### 对于属性和方法，可以使用以下修饰符

- **final** 不能重写/修改属性和方法
- **static** 属性和方法**属于类，而不是对象**
- abstract **只能在抽象类中使用，并且只能用于方法**。抽象方法定义时没有主体，例如 abstract void run(); 抽象方法主体由抽象类的子类实现。
- transient transient 修饰的属性和方法，在对象序列化时将跳过
- synchronized 方法同时只能由一个线程访问
- volatile 属性值不是线程本地缓存的，而是始终从“主内存”中读取。

### 封装 Bean

- 将类变量/属性声明为 private(只能在本类中访问)
- 提供公共的 setter 和 getter 方法，来访问和更新私有变量的值

### package

```java
import package.name.Class; // 导入单个类
import package.name.*; // 导入整个包
```

### 抽象类

abstract 关键字是一个非访问修饰符，用于类和方法:

- 抽象类: 是一个受限制的类，**不能用于创建对象(要访问它，必须通过它的子类对象)**。
- 抽象方法: 只能在抽象类中使用，**抽象方法没有主体，主体由抽象类的子类提供**。

### Java 接口/interface

接口/interface 是一个**完全的“抽象类”**，**包含了一组没有实体的方法声明**。

要访问接口方法，接口必须由另一个类“实现”(有点像继承)。实现接口使用 implements 关键字(而不是 extends)。

接口说明:

- 与抽象类一样，接口不能用于创建对象(在上面的示例中，不能在 MyMainClass 中创建“Animal”对象)
- 接口方法**没有主体** – 主体由“实现”类提供
- 在实现接口时，必须**重写它的所有方法**
- 接口**方法默认**是 abstract 和 public 的
- 接口**属性默认**为 public、static 和 final
- 接口**不能包含构造函数**(因为它不能用于创建对象)

为什么以及何时使用接口?

1. 安全性 – 对外隐藏对象细节，只暴露必须暴露的内容（接口函数）。
2. Java 不支持“多重继承”(一个类只能继承一个父类)。**但是，一个类可以实现多个接口。**注意: 实现多个接口时，接口之间用逗号分隔(参见下面的示例)。

### Java 用户输入/Scanner

输入类型

- nextBoolean() 从用户输入中读取 1 个 boolean 值
- nextByte() 从用户输入中读取 1 个 byte 值
- nextDouble() 从用户输入中读取 1 个 double 值
- nextFloat() 从用户输入中读取 1 个 float 值
- nextInt() 从用户输入中读取 1 个 int 值
- nextLine() 从用户输入中读取 1 个 String 值
- nextLong() 从用户输入中读取 1 个 long 值
- nextShort() 从用户输入中读取 1 个 short 值

### 日期与时间

java.time 包

Java 类 描述

- LocalDate 表示日期(年、月、日(yyyy-MM-dd))
- LocalTime 表示时间(小时、分钟、秒和毫秒(HH-mm-se-zzz))
- LocalDateTime 表示日期和时间(yyyy-MM-dd-HH-mm-ss.zzz)
- DateTimeFormatter 用于显示和解析日期-时间对象的格式化类

### ArrayList 类

ArrayList 类是一个大小可变的数组类，包含在 java.util 包中。

Java 中，内置数组和 ArrayList 的区别在于，内置数组的大小不能改变(如果想在数组中添加或删除元素，必须创建一个新数组)，而 ArrayList 中，元素可以添加和删除。

### HashMap

ArrayList 把数据存储为**有序列表**，使用索引号(int 类型)访问它们。

而 HashMap 将数据存储为“键/值”对，通过键(例如：字符串，键类似索引)访问它们。

json 对象。

### 包装类

下表显示了基本类型和等价的包装类:

| 基本类型 |  包装类   |
| :------- | :-------: |
| byte     |   Byte    |
| short    |   Short   |
| int      |  Integer  |
| long     |   Long    |
| float    |   Float   |
| double   |  Double   |
| boolean  |  Boolean  |
| char     | Character |

### File

File 类有许多方法，如下表:

方法 返回值类型 描述

canRead() Boolean 测试文件是否可读
canWrite() Boolean 测试文件是否可写
createNewFile() Boolean 创建一个空文件
delete() Boolean 删除一个文件
exists() Boolean 测试文件是否存在
getName() String 返回文件的名称
getAbsolutePath() String 返回文件的绝对路径
length() Long 返回文件大小(以字节为单位)
list() String[] 返回目录中文件的数组
mkdir() Boolean 创建一个目录

## Java 类型转换

- 基本类型转换
- 引用类型转换 -> 多态

- 默认转换
- 强制转换

### 多态

多态存在的三个必要条件

- 继承
- 重写
- 父类引用指向子类对象

多态的优点

1. 消除类型之间的耦合关系
2. 可替换性
3. 可扩充性
4. 接口性
5. 灵活性
6. 简化性
