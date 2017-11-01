package hello;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadCheck {

    private volatile ArrayBlockingQueue<String> q;
    private final int CAPACITY =1000;
    private int counter;

    public ThreadCheck() {
        q = new ArrayBlockingQueue<>(CAPACITY, true);
        counter=0;
    }

    Runnable producer = () -> {
        System.out.println("Entered Producer");
        while(q.size() < CAPACITY) {
            q.add("Student " + counter++);
            System.out.println("Produced: Student " + (counter-1));
        }
    };

    Runnable consumer = () -> {
        System.out.println("Entered Consumer");
        while(q.size() >= 0) {
              String curr = "";
              try {
                  curr = q.take();
              } catch(InterruptedException e) {
                  e.printStackTrace();
              }

              System.out.println("Consumed: " + curr);
        }
    };

    public static void main(String[] args) {
        ThreadCheck t = new ThreadCheck();

        Thread p = new Thread(t.producer);
        Thread c =new Thread(t.consumer);

        p.start();
        c.start();

    }

}
