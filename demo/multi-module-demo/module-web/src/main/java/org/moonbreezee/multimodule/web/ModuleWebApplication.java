package org.moonbreezee.multimodule.web;

  import org.mybatis.spring.annotation.MapperScan;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author qiu
 * @date 2020/1/3
 */
@SpringBootApplication(scanBasePackages = {"org.moonbreezee.multimodule"})
@MapperScan("org.moonbreezee.multimodule.dao.repository")
public class ModuleWebApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(ModuleWebApplication.class, args);
  }
}