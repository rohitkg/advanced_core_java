package school;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Student {

  private String name;
  private int averageGrade;
  private List<String> courses;

  private Student() {
  }

  public static Student ofNameGradeCourses(String name, int averageGrade, String... courses) {
    Student self = new Student();
    self.name = name;
    self.averageGrade = averageGrade;
    self.courses = Arrays.asList(courses);
    return self;
  }

  public String getName() {
    return name;
  }

  public int getAverageGrade() {
    return averageGrade;
  }

  public List<String> getCourses() {
    return Collections.unmodifiableList(courses);
  }

  @Override
  public String toString() {
    return "Student{" + "name=" + name + ", averageGrade=" + averageGrade + ", courses=" + courses + '}';
  }

  private static final Comparator<Student> gradeComparator = (o1, o2) -> {
    return o1.getAverageGrade() - o2.getAverageGrade();
  };

  // derivation of lambda comparator
//  private static final Comparator<Student> gradeComparator = /*new Comparator<Student>() {*/
////    @Override
//    /*public int compare*/(Student o1, Student o2) -> {
//      System.out.println("running lambda comparator...");
//      return o1.getAverageGrade() - o2.getAverageGrade();
//    }
//  /*}*/;
//  
  // anonymous inner class...
//  private static final Comparator<Student> gradeComparator = new /*GradeComparator();
//  private static class GradeComparator implements */Comparator<Student>() {
//
//    @Override
//    public int compare(Student o1, Student o2) {
//      return o1.getAverageGrade() - o2.getAverageGrade();
//    }
//  };
//  
//  private static final Comparator<Student> gradeComparator = new GradeComparator();
//  private static class GradeComparator implements Comparator<Student> {
//
//    @Override
//    public int compare(Student o1, Student o2) {
//      return o1.getAverageGrade() - o2.getAverageGrade();
//    }
//  }
  public static Comparator<Student> getGradeComparator() {
    return gradeComparator;
  }

}
