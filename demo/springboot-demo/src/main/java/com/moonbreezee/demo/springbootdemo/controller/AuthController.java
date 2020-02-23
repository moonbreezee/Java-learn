package com.moonbreezee.demo.springbootdemo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moonbreezee.demo.springbootdemo.common.util.MiscUtil;
import com.moonbreezee.demo.springbootdemo.common.util.Result;
import com.moonbreezee.demo.springbootdemo.model.RegisterRequest;

// 创建AuthController控制器类，实现一个用户注册的接口
@RestController
@RequestMapping("/auth")
public class AuthController {
  // 需要使用postman，发送post请求：
  // 地址: http://localhost:8096/auth/register
  // 参数: 这里还必须双引号
  // {
  // "mobile":"15968106523",
  // "password":"123456",
  // "nickname":"qiu"
  // }
  // JSON(application/json)
  @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<Result> register(
      // @Valid @RequestBody RegisterRequest register @RequestBody
      // 表明输入来自请求body，@Valid表明在绑定输入时作校验
      @Valid @RequestBody RegisterRequest register,
      // BindingResult bindingResult 这个参数存放校验结果
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {

      // rfc4918 - 11.2. 422: Unprocessable Entity
      // res.setStatus(422);
      // res.setMessage("输入错误");
      // res.putData("fieldErrors", bindingResult.getFieldErrors());

      Result res1 = MiscUtil.getValidateError(bindingResult);

      return new ResponseEntity<Result>(res1, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    Result res = new Result(200, "ok");
    return ResponseEntity.ok(res);
  }
}
