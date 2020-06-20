package com.qiuwww.demo.springbootsecuritydemo.controller;

import com.qiuwww.demo.springbootsecuritydemo.common.util.JwtMiscUtil;
import com.qiuwww.demo.springbootsecuritydemo.common.util.JwtResult;
import com.qiuwww.demo.springbootsecuritydemo.model.JwtLoginRequest;
import com.qiuwww.demo.springbootsecuritydemo.service.JwtAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

// login – 用户提供账号密码，如果密码正确，返回token，否则返回账号或密码错误提示；
// refresh 输入一个合法的旧token，返回新token

// 用户信息
@RestController
@RequestMapping("/jwt/auth")
public class JwtAuthController {

  @Autowired
  private JwtAuthService authService;

  /**
   * login
   * 
   * @param authRequest
   * @param bindingResult
   * @return ResponseEntity<JwtResult>
   */
  // 登录获取token
  // post http://localhost:8097/jwt/auth/login
  // {
  // "account": "15968106523",
  // "password": "123456"
  // }
  
  // {
  // "status": 200,
  // "message": "ok",
  // "data": {
  // "token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTk2ODEwNjUyMyIsInJvbGUiOiJ1c2VyIiwiZXhwIjoxNTc3NjIzMDcwLCJpYXQiOjE1Nzc2MjEyNzB9.C7PUux3XkhjiSmE-k4fGVPX5SZXPRzBxRl5P714WFY3YCjcXvvsljLfT2aqB0Vx64sJP7uYCSQWTHoXY4tBFfg"
  // }
  // }
  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<JwtResult> login(@Valid @RequestBody JwtLoginRequest authRequest, BindingResult bindingResult)
      throws AuthenticationException {

    if (bindingResult.hasErrors()) {
      JwtResult res = JwtMiscUtil.getValidateError(bindingResult);
      return new ResponseEntity<JwtResult>(res, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    final String token = authService.login(authRequest.getAccount(), authRequest.getPassword());

    // Return the token
    JwtResult res = new JwtResult(200, "ok");
    res.putData("token", token);
    return ResponseEntity.ok(res);
  }

  /**
   * refresh
   * 
   * @param request
   * @return ResponseEntity<JwtResult>
   */
  @RequestMapping(value = "/refresh", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<JwtResult> refresh(HttpServletRequest request, @RequestParam String token)
      throws AuthenticationException {

    JwtResult res = new JwtResult(200, "ok");

    String refreshedToken = authService.refresh(token);

    if (refreshedToken == null) {
      res.setStatus(400);
      res.setMessage("无效token");
      return new ResponseEntity<JwtResult>(res, HttpStatus.BAD_REQUEST);
    }

    res.putData("token", token);
    return ResponseEntity.ok(res);
  }

}
