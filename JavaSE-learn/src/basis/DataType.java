package basis;

import java.util.ArrayList;

public class DataType {

  public static void main(String[] args) {
    DataType test = new DataType();
    test.booleanTest();
    test.charTest();
    test.floatTest();
    test.integerValTest();
    test.underscoreTest();
    test.varTest();
    test.wrapperClassTest();
  }

  public void booleanTest() {
    System.out.println("******booleanTest******");
    boolean b1 = true;
    boolean b2 = false;
    // 使用boolean和字符串进行连接运算，boolean会自动转换成字符串
    String str = true + "";
    // 下面将输出true
    System.out.println(str);
  }

  public void charTest() {
    System.out.println("******charTest******");
    // 直接指定单个字符作为字符值
    char aChar = 'a';
    // 使用转义字符来作为字符值
    char enterChar = '\r';
    // 使用Unicode编码值来指定字符值
    char ch = '\u9999';
    // 将输出一个'香'字符
    System.out.println(ch);
    // 定义一个'疯'字符值
    char zhong = '疯';
    // 直接将一个char变量当成int类型变量使用
    int zhongValue = zhong;
    System.out.println(zhongValue);
    // 直接把一个0～65535范围内的int整数赋给一个char变量
    char c = 97;
    System.out.println(c);
  }

  public void floatTest() {
    System.out.println("******floatTest******");
    float af = 5.2345556f;
    // 下面将看到af的值已经发生了改变
    System.out.println(af);
    double a = 0.0;
    double c = Double.NEGATIVE_INFINITY;
    float d = Float.NEGATIVE_INFINITY;
    // 看到float和double的负无穷大是相等的。
    System.out.println(c == d);
    // 0.0除以0.0将出现非数
    System.out.println(a / a);
    // 两个非数之间是不相等的
    System.out.println(a / a == Float.NaN);
    // 所有正无穷大都是相等的
    System.out.println(6.0 / 0 == 555.0 / 0);
    // 负数除以0.0得到负无穷大
    System.out.println(-8 / a);
    // 下面代码将抛出除以0的异常
    // System.out.println(0 / 0);
  }

  public void integerValTest() {
    System.out.println("******integerValTest******");

    // 下面代码是正确的，系统会自动把56当成byte类型处理
    byte a = 56;
    /*
     * 下面代码是错的，系统不会把9999999999999当成long类型处理， 所以超出int的表数范围，从而引起错误
     */
    // long bigValue = 9999999999999;
    // 下面代码是正确的，在巨大的整数值后使用L后缀，强制使用long类型
    long bigValue2 = 9223372036854775807L;

    // 以0开头的整数值是8进制的整数
    int octalValue = 013;
    System.out.println(octalValue);
    // 以0x或0X开头的整数值是16进制的整数
    int hexValue1 = 0x13;
    int hexValue2 = 0XaF;

    System.out.println(hexValue1);
    System.out.println(hexValue2);

    // 定义二个8位的二进制数
    int binVal1 = 0b11010100;
    byte binVal2 = 0B01101001;
    // 定义一个32位的二进制数,最高位是符号位。
    int binVal3 = 0B10000000000000000000000000000011;
    System.out.println(binVal1); // 输出212
    System.out.println(binVal2); // 输出105
    System.out.println(binVal3); // 输出-2147483645
    /*
     * 定义一个8位的二进制，该数值默认占32位，因此它是一个正数。 只是强制类型转换成byte时产生了溢出，最终导致binVal4变成了-23
     */
    byte binVal4 = (byte) 0b11101001;
    /*
     * 定义一个32位的二进制数,最高位是1。 但由于数值后添加了L后缀，因此该整数的实际占64位，第32位的1不是符号位。
     * 因此binVal5的值等于2的31次方 + 2 + 1
     */
    long binVal5 = 0B10000000000000000000000000000011L;
    System.out.println(binVal4); // 输出-23
    System.out.println(binVal5); // 输出2147483651
  }

  public void underscoreTest() {
    System.out.println("******underscoreTest******");
    // 定义一个32位的二进制数,最高位是符号位。
    int binVal = 0B1000_0000_0000_0000_0000_0000_0000_0011;
    double pi = 3.14_15_92_65_36;
    System.out.println(binVal);
    System.out.println(pi);
    double height = 8_8_4_8.23;
    System.out.println(height);
  }

  public void varTest() {
    System.out.println("******varTest******");
    // 这里还是8版本，还不能使用var
    // var a = 20; // 被赋的值为20，因此a的类型是int
    int a = 20; // 被赋的值为20，因此a的类型是int
    System.out.println(a);
    // a = 1.6; // 这行代码会报错：不兼容的类型
    float b = 3.4f; // 被赋的值为3.4，因此b的类型是float
    System.out.println(b);
    byte c = (byte) 13;
    System.out.println(c);
    // c = a; // 这行代码会报错：不兼容的类型
    // var d; // 这行代码报错：无法推断局部变量 d 的类型

    String st = "Hello"; // 被赋值为"Hello"，因此st的类型是String
    // st = 5; // 这行代码会报错：不兼容的类型
  }

  public void wrapperClassTest() {
    System.out.println("******wrapperClassTest******");
    // 有时候必须使用包装类，例如，ArrayList不能存储基本类型(只能存储对象)
    // ArrayList<int> myNumbers = new ArrayList<int>(); // 无效
    ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // 有效

    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt);
    System.out.println(myDouble);
    System.out.println(myChar);

    // 包装类型中，通过${type}Value来获取值
    System.out.println(myInt.intValue());
    System.out.println(myDouble.doubleValue());
    System.out.println(myChar.charValue());

    // 另一个有用的方法是toString()方法，可将包装类对象转换为字符串。
    String myString = myInt.toString();
    System.out.println(myString + "   " + myString.length());
  }

}
