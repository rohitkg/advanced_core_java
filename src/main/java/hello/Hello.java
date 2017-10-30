package hello;

import java.util.TreeSet;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
    TreeSet<Student> s = new TreeSet<Student>(Student.getGradeComparator());
    s.add(new Student("Rohit", 4.2f, "Maths", "Science"));
    s.add(new Student("Abhi",  3.2f, "Maths", "Science", "CS"));
    s.add(new Student("Bob",  4.5f, "Science"));
    
    School sc = new School(s);
    sc.displayStudents();
  }
}
