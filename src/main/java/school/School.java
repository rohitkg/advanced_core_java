package school;

import java.util.Arrays;
import java.util.List;

public class School {
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
    
  }
}
