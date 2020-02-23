package classAndObject;

/**
 * 这里创建一个Bean类 特点： 1. 私有成员变量；2. 只能使用set与get方法来访问属性；
 */
public class BeanPerson {
  private String name; // private = 限制访问

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}