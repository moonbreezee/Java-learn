---
title: Spring、SpringMVC、Spring Boot、Spring Cloud 概念关系及区别
---

## Spring

主要是基于 IOC 反转 Beans 管理 Bean 类，主要依存于 SSH 框架（Struts+Spring+Hibernate）这个 MVC 框架，所以定位很明确，Struts 主要负责表示层的显示，**Spring 利用它的 IOC 和 AOP 来处理控制业务（负责对数据库的操作）**，Hibernate 主要作用是**数据的持久化到数据库**。

一个轻量级的**控制反转**（IoC）和**面向切面**（AOP）的容器,Java 开发框架。

## SpringMVC

是基于 Spring 的一个 MVC 框架，用以替代初期的 SSH 框架;(spring Framework 本身没有 Web 功能，Spring MVC 使用 WebApplicationContext 类扩展 ApplicationContext，使得拥有 web 功能)。

MVC 为现代 web 项目开发的一种很常见的模式，**简言之 C（控制器）将 V（视图、用户客户端）与 M（模块，业务）分开构成了 MVC** ，业内常见的 mvc 模式的开发框架有 Struts1，Struts2 等。

spring 作为专业的开发 web 项目的开源框架，springMVC 为内部的一个模块环节，同样采取 mvc 设计模式。 所以在使用 spring 开发 web 项目时，作为核心环节的 MVC 可以使用 struts1/struts2/springMVC。

## Spring Boot

是基于 Spring4 的条件注册的一套快速开发**整合包**。

**把以前的手动配置的过程自动化封装了，提供默认的配置**，特点就是：

- 简单易用，初学者和大牛都可以轻松上手，其中的注解会给使用者提供方便；
- Spring boot 对第三方技术进行了很好的**封装和整合**，提供了大量第三方接口；
- 可以通过依赖自动配置，不需要 XML 等配置文件；
- 还提供了安全等特性姑且先不做理会。

跟 umi 类似功能，封装常用的组件及功能库，提供常用配置。

## Spring Clound

spring-colud 是一种**云端分布式架构解决方案**，基于 spring boot,在 spring boot 做较少的配置，便可成为 spring cloud 中的一个微服务。

## 三者的发展与联系

Spring 最初利用“工厂模式”（ DI ）和“代理模式”（ AOP ）**解耦应用组件**。大家觉得挺好用，于是按照这种模式搞了一个 MVC 框架（一些用 Spring 解耦的组件），用来开发 web 应用（ SpringMVC ）。

然后有发现**每次开发都要搞很多依赖，写很多样板代码很麻烦**，于是搞了一些**懒人整合包**（ starter ），这套就是 Spring Boot 。

升级云-Spring Cloud：现在是大数据、云时代，上云是必然选择，那么 Spring Cloud 应运而生。
