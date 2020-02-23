package org.moonbreezee.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 这个类就会被当成Controller
@Controller
// 访问路径的注解@RequestMapping("/home")
@RequestMapping("/home")
public class HomeController {
  // 在HomeController内创建一个hello方法，在方法上注解@RequestMapping("/hello")，这样当访问http://localhost:8080/spring-helloworld/home/hello的时候，就会执行这个方法
  @RequestMapping("/hello")
  public String hello() {
    // 最后return "hello"，这样执行完hello方法后会跳转到hello.jsp（hello.jsp需要建在WEB-INF-views下）
    return "hello";
  }
}
