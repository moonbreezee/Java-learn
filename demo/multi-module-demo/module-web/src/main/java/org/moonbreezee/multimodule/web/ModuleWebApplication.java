package org.qiuwww.multimodule.web;

  import org.mybatis.spring.annotation.MapperScan;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author qiu
 * @date 2020/1/3
 */
@SpringBootApplication(scanBasePackages = {"org.qiuwww.multimodule"})
@MapperScan("org.qiuwww.multimodule.dao.repository")
public class ModuleWebApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(ModuleWebApplication.class, args);
  }
}