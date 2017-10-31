package superiterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import school.Student;

public class SuperIterable<E> implements Iterable<E> {

  private Iterable<E> self;

  private SuperIterable(Iterable<E> target) {
    self = target;
  }

  public static <E> SuperIterable<E> of(Iterable<E> target) {
    return new SuperIterable<>(target);
  }

  public SuperIterable<E> filter(Predicate<E> pred) {
    List<E> rv = new ArrayList<>();
    self.forEach(e -> {
      if (pred.test(e)) {
        rv.add(e);
      }
    });
    return new SuperIterable<>(rv);
  }
  
  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    List<F> rv = new ArrayList<>();
    self.forEach(e -> op.apply(e).forEach(f -> rv.add(f)));
    return new SuperIterable<>(rv);
  }
  
  public <F> SuperIterable<F> map(Function<E,F> op) {
    List<F> rv = new ArrayList<>();
    self.forEach(e -> rv.add(op.apply(e)));
    return new SuperIterable<>(rv);
  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }

  public SuperIterable<E> distinct() {
    List<E> rv = new ArrayList<>();
    Set<E> seen = new HashSet<>();
    self.forEach(s -> {if (seen.add(s)) rv.add(s);});
    return new SuperIterable<>(rv);
  }
  
  public SuperIterable<E> peek(Consumer<E> cons) {
    self.forEach(cons);
    return this;
  }
  public long count() {
    long rv = 0;
    Iterator<E> it = self.iterator();
    while (it.hasNext()) {
      rv++;
      it.next();
    }
    return rv;
  }
  
  public static void main(String[] args) {
    List<Student> schoolList = Arrays.asList(
        Student.ofNameGradeCourses("Fred", 68, "Maths", "Physics"),
        Student.ofNameGradeCourses("Jim", 59, "Art", "History", "Journalism"),
        Student.ofNameGradeCourses("Sheila", 88, "Maths", "Physics",
            "Astrophysics", "Quantum Physics"),
        Student.ofNameGradeCourses("Mary", 72, "Electronics")
    );
    SuperIterable<Student> school = SuperIterable.of(schoolList);
    
    school.forEach(s-> System.out.println("> " + s));
    System.out.println("----------------------------------");
//    school
      schoolList.stream()
        .parallel()
        .unordered()
        .filter(s -> s.getAverageGrade() > 60)
        .flatMap(s -> s.getCourses().stream())
//        .flatMap(s -> SuperIterable.of(s.getCourses()))
        .peek(s-> System.out.println("before: " + s))
        .distinct()
        .peek(s-> System.out.println("after: " + s))
        .map(s -> s.toUpperCase())
//        .forEach(s-> System.out.println("> " + s))
        ;
  }
}
