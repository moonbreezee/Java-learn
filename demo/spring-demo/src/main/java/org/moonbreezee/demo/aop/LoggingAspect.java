package org.qiuwww.demo.aop;

public class LoggingAspect {
  public void beforeAdvice() {
    System.out.println("Before Advice");
  }

  public void afterAdvice() {
    System.out.println("After Advice");
  }

  public void afterReturningAdvice(Object retVal) {
    System.out.println("当方法执行成功，在方法之后运行建议（插入的代码）: After Advice Executed Successfully ... Returning: " + retVal.toString());
  }

  public void AfterThrowingAdvice(IllegalArgumentException ex) {
    System.out.println("仅在方法抛出异常后运行建议（插入的代码）: There has been an exception when executing the advice: " + ex.toString());
  }
}