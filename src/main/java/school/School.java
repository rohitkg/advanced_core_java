package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

interface Banana {
  boolean peel(Student s);
}

public class School {
  
  public static List<Student> getStudentsByCriterion(Iterable<Student> in, StudentCriterion criterion) {
    List<Student> rv = new ArrayList<>();
    
    for (Student s : in) {
      if (criterion.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }
  
//  public static List<Student> getSmartStudents(Iterable<Student> in, int threshold) {
//    List<Student> rv = new ArrayList<>();
//    
//    for (Student s : in) {
//      if (s.getAverageGrade() > threshold) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }
//  
//  public static List<Student> getEnthusiasticStudents(Iterable<Student> in, int threshold) {
//    List<Student> rv = new ArrayList<>();
//    
//    for (Student s : in) {
//      if (s.getCourses().size() > threshold) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }
//  
  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------------------");
  }
  
  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.ofNameGradeCourses("Fred", 68, "Maths", "Physics"),
        Student.ofNameGradeCourses("Jim", 59, "Art", "History", "Journalism"),
        Student.ofNameGradeCourses("Sheila", 88, "Maths", "Physics", 
            "Astrophysics", "Quantum Physics"),
        Student.ofNameGradeCourses("Mary", 72, "Electronics")
    );
    
    System.out.println("> " + school);
    
    school.sort(Student.getGradeComparator());
    showAll(school);
    
    showAll(getStudentsByCriterion(school, Student.getSmartnessCriterion(70)));
    showAll(getStudentsByCriterion(school, (s) -> s.getAverageGrade() > 80));
//    showAll(getSmartStudents(school, 65));
//    showAll(getEnthusiasticStudents(school, 2));

//    boolean x = ((Banana)((s) -> s.getAverageGrade() > 80)).peel(Student.ofNameGradeCourses("Mary", 72, "Electronics"));
  }
}
