package com.moonbreezee.demo.springbootdemo.controller;

import com.moonbreezee.demo.springbootdemo.common.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// HelloController控制类实现一个接口，用于测试封装类Result
@RestController
public class ResultWrapController {
  // 测试请求
  // http://localhost:8096/resultWrap?bad=true
  // 这里只要放在这里就可以了？，自动配置？
  @RequestMapping(value = "/resultWrap", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<Result> hello(
      @RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad) {

    // 这里对参数bad取值RequestParam，然后赋值给了bad变量，这里有类型转换吗？
    // 结果封装类对象
    Result res = new Result(200, "ok");

    if (bad) {
      res.setStatus(400);
      res.setMessage("Bad request");

      // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
      return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
    }

    // 把结果数据放进封装类
    res.putData("words", "Hello world!");

    // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
    return ResponseEntity.ok(res);
  }
}
