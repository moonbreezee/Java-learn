package com.moonbreezee.demo.springbootsecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt/hello")
public class JwtHelloController {
  // http://localhost:8097/jwt/hello/hello1
  // {
  // status: 401,
  // message: "Unauthorized or invalid token"
  // }

  // 如果有token可以带上token就可以访问了
  // postman -> Authorization -> Bearer Token
  @RequestMapping(value = "/hello1", method = RequestMethod.GET)
  public String hello1() {

    return "Hello1!";
  }

  @RequestMapping(value = "/hello2", method = RequestMethod.GET)
  public String hello2() {

    return "Hello2!";
  }

  @RequestMapping(value = "/hello3", method = RequestMethod.GET)
  public String hello3() {

    return "Hello3!";
  }
}
