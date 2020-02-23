---
title: 疯狂讲义学习过程中的记录
date: 2019-12-02
tags:
  - JAVA
---

[TOC]

## 解释性语言与解释性语言

编程：机器码 -> 汇编语言 -> 自然语言编程

### 编译型程序执行

自然语言编程（集中一次编译）-> 机器指令集-> 机器指令 -> 机器

性能更好，无法跨平台

### 解释型程序执行

自然语言编程（逐条编译）-> 机器指令 -> 机器

性能略差，跨平台

## Java 的运行机制

Java 需要经过编译 -> **生成与平台无关的字节码文件** -> 使用 java 解释器(JVM)执行

字节码文件，也就是.class 文件，**二进制(bit)文件**。

Byte = 8bit，一个字节等于 8 位。

10Mbps = 1.25M，用在宽带带宽度量。

Java 不彻底的编译，每次运行的时候需要将字节码文件解释成对应平台的机器指令。

所以 Java 性能很好且可以跨平台。

## JVM 与 JRE、JDK

JRE(Java Runtime Enviroment) = JVM(Java Virtual Machine) + 各种基础的类库 + Java 类库(String/System)

SDK(Software Developing Kit)，Java 的 SDK 简称 JDK(Java Developing Kit)，JDK 包括 JRE 及相关的指令。

## 查看当前 Java 的版本

MAC 下输入: `/usr/libexec/java_home -V`，可以查看已安装的 jdk 版本及其安装目录。

查看编译器版本: `javac -version`
查看 JDK 版本: `java -version`， 通过修改 JAVA_HOME 变量，来修改使用版本。

[JDK 下载网站](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

### 命令行打开 html

```bash
open README.html
```

## 编译和运行一段 Java 程序

```shell
# 编译
# javac -d destdir srcFile
# 运行
# java Java类名

# 编译和运行Hello World类
javac -d . HelloWorld.java && java HelloWorld
```

main 方法是 java 程序的入口，几乎固定的写法如下：

```java
public static void main(String[] args) {}
```

## Java交互式工具

jshell，java控制台。
