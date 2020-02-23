# 权限问题

## spring security 的集成

- demo/springbootsecurity-demo/src/main/java/com/moonbreezee/demo/springbootsecuritydemo/controller/HelloController.java
- demo/springbootsecurity-demo/src/main/java/com/moonbreezee/demo/springbootsecuritydemo/config/SecurityConfig.java

spring security 的实现基于 servlet 过滤器，在每个请求被 spring MVC 处理之前，先要经过 spring security 过滤器，从而实现权限控制。权限控制分两部分，**认证和授权**，**用户认证就是指登录，有些接口要用户登录后才能访问**；授权是指根据用户角色授予不同权限，有些接口要具有一定角色的用户才能访问，如管理相关的接口只限 admin 角色访问。

我们会创建几个接口，部分接口需要登录才能访问，部分接口完全放开，验证 spring security 是否成功集成。

参考项目 `springbootsecurity-demo`

### rest 接口集成 spring security(2) – JWT 配置

[jwt 开头文件。](https://www.qikegu.com/docs/2570)

JWT 本质上是一个对 JSON 对象加密后的字符串。当服务器认证用户通过后，一个包含用户信息的 json 对象被加密后返回给用户，json 对象：

```json
{
  "UserName": "老王",
  "Role": "admin",
  "Expire": "2019-01-10 20:10:00"
}
```

之后，用户访问服务器时，都要返回这个 json 对象。服务器只靠这个对象就可以识别用户身份，不需要再去查数据库。为了防止用户篡改数据，服务器在生成对象时将添加一个签名。

服务器不保存任何会话数据，也就是说，服务器变得无状态，从而更容易扩展。

参考项目 `springbootsecurity-demo`

[JWT 配置](https://www.qikegu.com/docs/2570)

JWT(Json Web Token)

- 要使用 jwt，引入 jwt jar 包

## 异常(exception)处理

spring 中处理异常可以通过 2 个注解：

- @ControllerAdvice 全局，处理所有控制器中的异常
- @ExceptionHandler 局部，只针对某个控制器中的异常

**先有 ExceptionHandler，再有 ControllerAdvice**，ExceptionHandler 不能集中处理异常，ControllerAdvice 为弥补此缺点引入，推荐使用 ControllerAdvice。

### 错误处理页面：ErrorController

ErrorController 的作用是**为 servlet 设置错误页**，默认错误页是 Whitelabel，访问不存在的页面就会显示此错误页。

通过继承 ErrorController 接口可以设置自定义的错误页。

如果 ControllerAdvice 中没有直接返回 http 响应，继续抛出异常，将会调用 ErrorController 显示错误页。

如果在 ControllerAdvice 中**捕获异常并直接返回 http 响应，就没必要配置 ErrorController 中的错误页了**。

接续 JWT 的错误处理，参考项目 `springbootsecurity-demo`。

### 过滤器异常

ContollerAdvice 不能捕获过滤器抛出的异常，对于此类异常需要特别处理。

使用 ContollerAdvice 可以实现对所有控制器异常的集中处理，下面通过一个实际项目介绍此过程。
