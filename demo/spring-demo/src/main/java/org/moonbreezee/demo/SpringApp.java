package org.moonbreezee.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 主类
public class SpringApp {
  // 这里可以直接运行，当然也可以被用来处理请求
  public static void main(String[] args) {

    System.out.println("###1. 通过spring来创建类并调用方法");

    // 读取spring配置
    // FileSystemXmlApplicationContext: 通过文件路径加载bean的xml配置文件
    // ClassPathXmlApplicationContext: 通过类路径加载bean的xml配置文件
    // WebXmlApplicationContext: 通过web网址加载bean的xml配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    // 通过Spring容器获取bean
    Customer customerBean1 = (Customer) context.getBean("customerBean");
    // 调用类的方法
    customerBean1.displayInfo();
//     这里还是不太懂
//    customerBean1.log();
    // 应用结束时需要关闭容器，释放资源，容器中的所有bean也将被销毁。
    ((ClassPathXmlApplicationContext) context).close();

    System.out.println("###2. 直接通过类创建对象并调用方法");
    // 没有构造函数，所以只能通过属性赋值的形式初始化对象
    Person person2 = new Person("male");
    Customer customer2 = new Customer(person2);
    customer2.name = "customer2";
    customer2.displayInfo();
  }
}
