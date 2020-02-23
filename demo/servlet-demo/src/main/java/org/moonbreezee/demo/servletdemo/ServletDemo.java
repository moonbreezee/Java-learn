package org.moonbreezee.demo.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

/**
 * 实现Servlet 接口，因为Java Servlet一般用于web开发，所以通常都通过继承HttpServlet类创建servlet。
 */
public class ServletDemo implements Servlet {

  // 创建Servlet必须直接或间接地实现Servlet接口。
  ServletConfig config = null;

  public void init(ServletConfig config) {
    this.config = config;
//    System.out.println(config.getParameter("myParam"));
    System.out.println("这里是 init 实例化，参数config" + config);
  }

  public void destroy() {
    System.out.println("这里是destory方法");
  }

  public ServletConfig getServletConfig() {
    System.out.println("getServletconfig");
    return config;
  }

  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("这里是 service方法");
    res.setContentType("text/html");
    final PrintWriter pwriter = res.getWriter();
    pwriter.print("<html>");
    pwriter.print("<body>");
    pwriter.print("<h1>这里是ServletDemo，这是一段html文档</h1>");
    pwriter.print("</body>");
    pwriter.print("</html>");
  }

  public String getServletInfo() {
    return "返回关于servlet的信息，如作者、版本、版权等信息。";
  }

}