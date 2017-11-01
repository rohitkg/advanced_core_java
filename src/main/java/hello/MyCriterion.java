package hello;

@FunctionalInterface
public interface MyCriterion<E> {
	boolean test(E e);
}
