package basis;

public class WhileDo {
  public static void main(String args[]) {
    WhileDo test = new WhileDo();
    test.whileDo();
  }

  public void whileDo() {
    int i = 0;
    do {
      System.out.println(i);
      i++;
    } while (i < 5);

  }
}
