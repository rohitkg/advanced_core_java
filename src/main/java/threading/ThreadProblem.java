package threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyJob implements Callable<String> {
  private int i = 0;
  @Override
  public String call() throws Exception {
    System.out.println("Job starting...");
    
    for (; i < 10_000; i++) {
      System.out.println(Thread.currentThread().getName() + " i is " + i);
    }
    
    System.out.println("Job ending...");
    return "Done";
  }
  
}

public class ThreadProblem {
  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(4);
    Callable<String> myCallable = new MyJob();
    es.submit(myCallable);
    es.submit(myCallable);
    es.shutdown();
    System.out.println("Job sumbitted");
    System.out.println(Thread.currentThread().getName() + " exiting....");
  }
}
