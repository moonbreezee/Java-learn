package classAndObject;

public class TestClass {
  public static void main(String args[]) {
    BeanPerson myObj = new BeanPerson();
    myObj.setName("Kevin"); // 将name变量的值设置为“Kevin”
    System.out.println(myObj.getName());
  }
}
