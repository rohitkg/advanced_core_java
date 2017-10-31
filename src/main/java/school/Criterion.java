package school;

@FunctionalInterface
public interface Criterion<E> {

  public static <E> Criterion<E> inverse(Criterion<E> crit) {
    return e -> !crit.test(e);
  }

  public default Criterion<E> inverse() {
    return e -> !this.test(e);
  }

  public default Criterion<E> and(Criterion<E> other) {
    return e -> this.test(e) && other.test(e);
  }

  public default Criterion<E> or(Criterion<E> other) {
    return e -> this.test(e) || other.test(e);
  }

  boolean test(E e);
//  void doStuff();
}
