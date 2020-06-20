package org.qiuwww.multimodule.web.controller;

import org.qiuwww.multimodule.biz.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qww
 * @date 2020/1/3
 */

@RestController
@RequestMapping("web")
public class ModuleController {

  @Autowired
  private ModuleService moduleService;

  // module-dao/application.properties???????8096
  // http://localhost:8096/web/hello
  @GetMapping("hello")
  public String hello() {
    // return "Hello World!";
    return moduleService.hello2();
  }
  @GetMapping("hello2")
  public String hello2() {
    // return "Hello World!";
    return moduleService.hello2();
  }
}
