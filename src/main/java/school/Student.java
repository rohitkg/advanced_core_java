package school;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Student {

  private String name;
  private int averageGrade;
  private List<String> courses;

  private Student() {
  }
  
  public static Student ofNameGradeCourses(String name, int averageGrade, String ... courses) {
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

  
}
