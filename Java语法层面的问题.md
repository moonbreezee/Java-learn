---
title: Java 语法层面的问题
---

[TOC]

idea 的右上角搜索。

## 需要了解的 30 个基本概念

<https://blog.csdn.net/qq_26525215/article/details/51990939>

### OOP

### 类

### 封装

## 类库

### "com." 表示什么意思

### Execption，Java 的异常

堆栈跟踪。

### Throwable

- Execption
- Error

## 基础语法

### 数组声明

```java
String[] values = new String[] {"hello", "world"};

// 通过范型定义函数来生成数组

private static <T> T[] of(T... values) {
  return values;
}
// 后续定义数组
Integer[] data = of(...values: 1, 2, 3,4,5);

```

### System.out.println

不能直接输出数组。

### private | public 的区分

### static

### Diamond 语法，try...catch

### @Override

### 文件读入流

```java
FileInputStream inputStream = new FileInputStream(name: "/Users/qww/Documents/learn/Java-learn/Java语法层面的问题.md");
inputStream.read();
inputStream.close();
```

### Closeable

### Lambda 语法，注解，类型注解

## Java 的数据结构

### 原生类型

- boolean
- byte
- short
- int
- long
- float
- double

### 对象类型

- Object
- String
- Class

### 数组类型

- int[]
- Object[]
- Object...

### 集合类型

- Collection
- Stack
- Vector
- List
- Set
- Queue
- Map
- Enumeration
- Iterable
- Itertor

### jsr 是什么

## 基础知识点

### 基本数据类型

![数据类型及所占字节数大小](./imgs/数据类型及所占字节数大小.jpg)

### String 类能被继承吗

不能。在 Java 中，只要是被定义为 final 的类，也可以说是**被 final 修饰的类**，就是不能被继承的。

### String，Stringbuffer，StringBuilder 的区别

String：不可变字符序列；

Stringbuffer: 可变字符序列、效率低、线程安全；

StringBuilder: 可变字符序列、效率高、线程不安全。

### ArrayList 和 LinkedList 有什么区别

1. ArrayList 是实现了**基于动态数组的数据结构**，LinkedList **基于链表的数据结构**。（LinkedList 是双向链表，有 next 也有 previous）；
2. 对于随机访问 get 和 set，ArrayList 觉得优于 LinkedList，因为 LinkedList 要移动指针。
3. 对于新增和删除操作 add 和 remove，LinedList 比较占优势，因为 ArrayList 要移动数据。

### 类的实例化顺序

**类加载器实例化时**进行的操作步骤（加载–>连接->初始化）。

父类静态变量、 父类静态代码块、 子类静态变量、 子类静态代码块、 父类非静态变量（父类实例成员变量）、 父类构造函数、 子类非静态变量（子类实例成员变量）、 子类构造函数。

### 用过哪些 Map 类，都有什么区别

### 抽象类和接口的区别，类可以继承多个类么，接口可以继承多个接口么,类可以实现多个接口么

#### 区别

1. 抽象类和接口**都不能直接实例化**，如果要实例化，抽象类变量必须指向实现所有抽象方法的子类对象，接口变量必须指向实现所有接口方法的类对象。
2. 抽象类要被子类继承，接口要被类实现。
3. 接口只能做方法申明，抽象类中可以做方法申明，也可以做方法实现。
4. 接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。
5. **抽象类里的抽象方法必须全部被子类所实现**，如果子类不能全部实现父类抽象方法，那么该子类只能是抽象类。同样，一个实现接口的时候，如不能全部实现接口方法，那么该类也只能为抽象类。
6. **抽象方法只能申明，不能实现**。`abstract void abc();` 不能写成`abstract void abc(){}`。
7. 抽象类里可以没有抽象方法。
8. 如果一个类里有抽象方法，那么这个类只能是抽象类。
9. 抽象方法要被实现，所以不能是静态的，也不能是私有的。
10. 接口可继承接口，并可多继承接口，但类只能单根继承。

**类不能继承多个类**，java 单继承。

接口可以继承多个接口，类可以实现多个接口。

### 继承和聚合的区别在哪

**继承**指的是一个类继承另外的一个**类的功能**，并可以增加它自己的新功能的能力，**继承是类与类或者接口与接口之间最常见的关系**；在 Java 中此类关系通过关键字 extends 明确标识。

**聚合**体现的是整体与部分、拥有的关系，此时整体与部分之间是可分离的，他们可以具有各自的生命周期。（组合）
