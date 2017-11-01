package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static threading.ProdCons2.LIMIT;

class MyConsumer implements Runnable {

  private BlockingQueue<int[]> queue;
  private BlockingQueue<Boolean> sdQueue;
  public int[] counts = new int[ProdCons2.LIMIT];

  public MyConsumer(BlockingQueue<int[]> queue, BlockingQueue<Boolean> sdQueue) {
    this.queue = queue;
    this.sdQueue = sdQueue;
  }

  public void run() {
    while (sdQueue.size() == 0 || queue.size() != 0) {
      try {
        int[] data = queue.poll(5, TimeUnit.SECONDS);
        if (data == null) {
          continue;
        }
        if (data[0] != data[1]) {
          System.out.println("***** ERROR!!! " + data[0] + ", " + data[1]);
        } else {
          counts[data[0]]++;
        }
      } catch (InterruptedException ex) {
      }
    }
    System.out.println("Consumer finished...");
  }
}

class MyProducer implements Runnable {

  private BlockingQueue<int[]> queue;

  public MyProducer(BlockingQueue<int[]> queue) {
    this.queue = queue;
  }

  public void run() {
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
  }
}

public class ProdCons2 {

  private static BlockingQueue<int[]> queue = new ArrayBlockingQueue<>(5);
  private static BlockingQueue<Boolean> sdQueue = new ArrayBlockingQueue<>(10);
  public static final int LIMIT = 10_000;

  public static void main(String[] args) {

    Runnable prod1 = new MyProducer(queue);
    Runnable prod2 = new MyProducer(queue);
    Runnable prod3 = new MyProducer(queue);
    Runnable prod4 = new MyProducer(queue);
    Thread tp1 = new Thread(prod1);
    Thread tp2 = new Thread(prod2);
    Thread tp3 = new Thread(prod3);
    Thread tp4 = new Thread(prod4);

    tp1.start();
    tp2.start();
    tp3.start();
    tp4.start();

    MyConsumer mc1 = new MyConsumer(queue, sdQueue);
    MyConsumer mc2 = new MyConsumer(queue, sdQueue);
    MyConsumer mc3 = new MyConsumer(queue, sdQueue);
    Thread tc1 = new Thread(mc1);
    Thread tc2 = new Thread(mc2);
    Thread tc3 = new Thread(mc3);
    tc1.start();
    tc2.start();
    tc3.start();

    try {
      queue.put(new int[]{7,7});
      queue.put(new int[]{22,11});
      tp1.join();
      tp2.join();
      tp3.join();
      tp4.join();
      sdQueue.put(Boolean.TRUE);
      sdQueue.put(Boolean.TRUE);
      sdQueue.put(Boolean.TRUE);
      sdQueue.put(Boolean.TRUE);
      sdQueue.put(Boolean.TRUE);
      sdQueue.put(Boolean.TRUE);
      tc1.join();
      tc2.join();
      tc3.join();
      int[] data = new int[LIMIT];
      for (int i = 0; i < LIMIT; i++) {
        data[i] = mc1.counts[i];
      }
      for (int i = 0; i < LIMIT; i++) {
        data[i] += mc2.counts[i];
      }
      for (int i = 0; i < LIMIT; i++) {
        data[i] += mc3.counts[i];
      }
      for (int i = 0; i < LIMIT; i++) {
        if (data[i] != 4) {
          System.out.println("ERROR Count " + i + " was " + data[i]);
        }
      }
    } catch (InterruptedException ex) {
    }

    System.out.println("Main exiting...");
  }
}
