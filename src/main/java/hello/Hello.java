package hello;

import java.util.TreeSet;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
    TreeSet<Student> s = new TreeSet<>(Student.getGradeComparator());
    s.add(new Student("Rohit", 85.5f, "Maths", "Science"));
    s.add(new Student("Abhi",  78f, "Maths", "Science", "CS"));
    s.add(new Student("Bob",  91f, "Science"));
    
    School sc = new School(s);
    sc.displayStudents();
    
    //System.out.println(School.getSmartStudents(sc.getStudents(), Student.getSmartCriterion(85)));;
    //System.out.println(School.filter(sc.getStudents(), School.inverse(Student.getSmartCriterion(86))));
    
    System.out.println(School.filter(sc.getStudents(), School.and(Student.getSmartCriterion(75), Student.getCourseCriterion(1))));
  }
}
