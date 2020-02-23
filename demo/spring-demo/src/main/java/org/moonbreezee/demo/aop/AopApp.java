package org.moonbreezee.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopApp {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/aopAC.xml");

    User user = (User) context.getBean("user");

    user.getName();
    // 抛出一个错误
    user.printThrowException();
  }
}