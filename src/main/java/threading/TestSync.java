package threading;

public class TestSync {
  public static void main(String[] args) {
    Object x = null;
    synchronized(x) {
      System.out.println("Really?");
    }
  }
}
