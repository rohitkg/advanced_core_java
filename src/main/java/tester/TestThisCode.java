package tester;

//@RunMe
public class TestThisCode {
//  @RunMe
  private String data;
  
  @RunMe(value=3, text="First")
  public void doStuff(String s, int i) {
    System.out.println("Interesting stuff happening now!!! " + s + ", " + i);
  }
  
  @RunMe(7)
  private void doOtherStuff(String s, int i) {
    System.out.println("More interesting stuff..." + s + ", " + i);
  }
  
  public void dontDoThisStuff() {
    System.out.println("shouldn't see this message");
  }
}
