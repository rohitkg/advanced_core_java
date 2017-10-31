package superiterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }

  public static void main(String[] args) {
    SuperIterable<Student> school = SuperIterable.of(Arrays.asList(
        Student.ofNameGradeCourses("Fred", 68, "Maths", "Physics"),
        Student.ofNameGradeCourses("Jim", 59, "Art", "History", "Journalism"),
        Student.ofNameGradeCourses("Sheila", 88, "Maths", "Physics",
            "Astrophysics", "Quantum Physics"),
        Student.ofNameGradeCourses("Mary", 72, "Electronics")
    ));
    
    school.forEach(s-> System.out.println("> " + s));
    System.out.println("----------------------------------");
    school
        .filter(s -> s.getAverageGrade() > 60)
        .flatMap(s -> SuperIterable.of(s.getCourses()))
        .forEach(s-> System.out.println("> " + s));
  }
}
