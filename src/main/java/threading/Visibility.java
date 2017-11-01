package threading;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Visibility {
  // without the "happens-before" relationship created by the write
  // of the volatile variable followed by the read in another thread,
  // this code never stops!
  private volatile boolean stop = false;
  
  Runnable myJob = () -> {
    System.out.println("Job starting...");
    while (! stop)
      ;
    System.out.println("Job ending...");
  };
  
  public void go() {
    new Thread(myJob).start();
    try {;      Thread.sleep(1_000);
    } catch (InterruptedException ex) { }
    System.out.println("Setting stop to true");
    stop = true;
    System.out.println("go exiting...");
  }
  
  public static void main(String[] args) {
    new Visibility().go();
  }
}
