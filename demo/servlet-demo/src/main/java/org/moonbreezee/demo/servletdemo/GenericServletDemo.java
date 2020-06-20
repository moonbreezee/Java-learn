package org.qiuwww.demo.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 继承GenericServlet类
 * GenericServlet是一个与具体协议无关的通用servlet，继承GenericServlet的子类通过重写service()方法来处理客户端请求。service()方法接受2个参数ServletRequest和ServletResponse。ServletRequest表示客户端发出的请求，ServletResponse表示返回给客户端的响应。
 */
// 这里是继承
public class GenericServletDemo extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setCharacterEncoding("utf-8");
    res.setContentType("text/html;charset=utf-8");
    // 获取查询参数
    // http://localhost:8082/servlet_demo_war_exploded/GenericServletDemo?param=yes
    String yesOrNoParam = req.getParameter("param");
    System.out.println("yesOrNoParam" + yesOrNoParam);
    if ("yes".equals(yesOrNoParam)) {
      res.getWriter().write("<html><body>yes!</body></html>");
    } else if ("no".equals(yesOrNoParam)) {
      res.getWriter().write("<html><body>no!</body></html>");
    } else {
      res.getWriter().write("<html><body>请传递参数，如<a href='./GenericServletDemo?param=yes'>?param=yes</a></body></html>");
    }
  }

}