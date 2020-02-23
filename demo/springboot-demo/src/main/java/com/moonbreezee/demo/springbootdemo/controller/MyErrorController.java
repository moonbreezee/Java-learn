package com.moonbreezee.demo.springbootdemo.controller;

// 通过继承ErrorController接口可以设置自定义的错误页。
// 这里用来替换默认的ErrorController

import com.moonbreezee.demo.springbootdemo.common.util.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {
  // 测试访问不存在的页面 http://localhost:8096/aaaa
  @RequestMapping(value = "/error")
  public ResponseEntity<Result> error() {
    Result res = new Result(404, "页面未找到");
    return new ResponseEntity<Result>(res, HttpStatus.NOT_FOUND);
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
