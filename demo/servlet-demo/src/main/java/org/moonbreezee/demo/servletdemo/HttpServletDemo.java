package org.qiuwww.demo.servletdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpServletDemo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // @Override
  // public void service(ServletRequest req, ServletResponse res) throws
  // ServletException, IOException {
  //
  // }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 这里参数怎么获取？params | body | query
    // 参数处理，读取参数
    String param1 = request.getParameter("param1");
    String param2 = request.getParameter("param2");
    // 请求头的信息
    String contentLength = request.getHeader("Content-Length");
    // 在HttpServlet子类中访问Context参数
    String myContextParam = request.getSession().getServletContext().getInitParameter("webmaster");

    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    // if (name != null && ！name.equals("")) {
    // //do something
    // }
    final PrintWriter out = response.getWriter();

    if (param1 == null || param2 == null) {
      out.println(
          "<a href='./HttpServletDemo?param1=hello&param2=world'>参数不存在，请传递参数尝试，如./HttpServletDemo?param1=hello&param2=world</a>");
      return;
    }
    out.println("这里是HttpServletDemo, GET响应" + "参数param1: " + param1 + "，参数param2: " + param2 + " contentLength: "
        + contentLength);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 要访问HTTP POST的请求体，可通过从HttpRequest中获得InputStream，从中读取请求体数据:
    // body
    InputStream requestBodyInput = request.getInputStream();
    HttpSession session = request.getSession();
    session.setAttribute("userName", "老吴");
    // 可以从HttpRequest中访问ServletContext对象。ServletContext包含关于web应用程序的元信息。
    // 上下文信息
    ServletContext context = request.getSession().getServletContext();
    System.out.println("context" + context);
    // 注意:
    // 此方法必须在调用getParameter()之前调用。原因是调用getParameter()方法将导致servlet引擎解析请求体以获取参数，一旦被解析，就不能以原始字节流的形式访问请求体了。
    response.getWriter().write("<html><body>POST响应: requestBodyInput" + requestBodyInput.toString() + " session: "
        + session + " context： " + context + "</body></html>");
  }

}