package hello;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadCheck {

    volatile ArrayBlockingQueue<String> q;

    public ThreadCheck() {
        q = new ArrayBlockingQueue<>(10);
    }

    
}
