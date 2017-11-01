package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdCons1 {

  private static BlockingQueue<int[]> queue = new ArrayBlockingQueue<>(5);
  private static final int LIMIT = 10_000;

  public static void main(String[] args) {
    Runnable producer = () -> {
      for (int i = 0; i < LIMIT; i++) {
        try {
          int[] data = new int[2];
          data[0] = i;
          Thread.sleep(1);
          data[1] = i;
          queue.put(data);
          data = null;
        } catch (InterruptedException ex) {
          Logger.getLogger(ProdCons1.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      System.out.println("Producer finishing");
    };

    Runnable consumer = () -> {
      for (int i = 0; i < LIMIT; i++) {
        try {
          int[] data = queue.take();
          if (data[0] != i || data[1] != i) {
            System.out.println("***** ERROR!!! " + data[0] + ", " + data[1]);
          }
          if (i % 20 == 0) {
            Thread.sleep(30);
          }
        } catch (InterruptedException ex) {
        }
      }
      System.out.println("Consumer finished...");
    };

    new Thread(producer).start();
    new Thread(consumer).start();
    System.out.println("Main exiting...");
  }

}
