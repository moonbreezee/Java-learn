package classAndObject;

import java.io.File; // 导入File类
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; // 导入IOException类来处理错误
import java.util.Scanner;

// java.io包中的File类，用于处理文件。
// 使用File类，创建该类的对象，并指定文件名或目录名
public class FileClass {
  // "/Users/qww/Documents/learn/Java-learn/JavaSE-learn/sources/filename.txt"
  static String filePath = "sources/filename.txt";

  public static void main(String[] args) {
    FileClass.createFile();
    FileClass.getFileInfo();
    FileClass.writeToFile();
    FileClass.readFile();
  }

  static public void createFile() {
    System.out.println("******createFile******");
    try {
      // 会创建到与src同级
      // sources需要自己创建
      // 地址都是可以的
      File myObj = new File(filePath);
      if (myObj.createNewFile()) {
        System.out.println("创建文件: " + myObj.getName());
      } else {
        System.out.println("文件已经存在");
      }
    } catch (IOException e) {
      System.out.println("出错了");
      e.printStackTrace();
    }
  }

  static void getFileInfo() {
    System.out.println("******getFileInfo******");

    File myObj = new File(filePath);
    if (myObj.exists()) {
      System.out.println("文件名: " + myObj.getName());
      System.out.println("绝对路径: " + myObj.getAbsolutePath());
      System.out.println("可写: " + myObj.canWrite());
      System.out.println("可读: " + myObj.canRead());
      System.out.println("文件大小(字节): " + myObj.length());
    } else {
      System.out.println("文件不存在");
    }
  }

  static void writeToFile() {
    System.out.println("******writeToFile******");

    try {
      FileWriter myWriter = new FileWriter(filePath);
      myWriter.write(
          "Java API中有很多类可以用来读写文件: FileReader、BufferedReader、Files、Scanner、FileInputStream、FileWriter、BufferedWriter、FileOutputStream等，可根据需要选择。");
      myWriter.close();
      System.out.println("成功写入文件");
    } catch (IOException e) {
      System.out.println("出错了");
      e.printStackTrace();
    }
  }

  static void readFile() {
    System.out.println("******readFile******");

    try {
      File myObj = new File(filePath);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("出错了");
      e.printStackTrace();
    }
  }
}
