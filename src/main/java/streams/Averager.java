package streams;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;

class Average {
  private long count;
  private double sum;
  
  public void include(double d) {
    sum += d;
    count++;
  }
  
  public void merge(Average other) {
    sum += other.sum;
    count += other.count;
  }
  
  public double get() {
    return sum / count;
  }
  
  public void use(Consumer<Average> op) {
    op.accept(this);
  }
}

public class Averager {
  public static void main(String[] args) {
    long start = System.nanoTime();
    DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
        .limit(100_000_000)
//        .parallel()
//        .unordered()
        .map(x -> Math.sin(x))
        .collect(Average::new, Average::include, Average::merge)
//        .collect(() -> new Average(), (b, d) -> b.include(d), (b1, b2) -> b1.merge(b2))
        .use(a -> System.out.println(a.get()));
    long end = System.nanoTime();
    System.out.println("Time was " + (end - start) / 1_000_000);
//        .forEach(x -> System.out.println(x));
  }
}
