package school;

@FunctionalInterface
public interface Criterion<E> {
  boolean test(E e);
//  void doStuff();
}
