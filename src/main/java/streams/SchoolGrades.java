package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import school.Student;

public class SchoolGrades {
  
  public static String getLetterGrade(Student s) {
    int percent = s.getAverageGrade();
    if (percent > 75) return "A";
    if (percent > 60) return "B";
    if (percent > 50) return "C";
    return "D";
  }
  public static void main(String[] args) {
    List<Student> schoolList = Arrays.asList(
        Student.ofNameGradeCourses("Fred", 68, "Maths", "Physics"),
        Student.ofNameGradeCourses("Fred", 62, "Maths", "Physics"),
        Student.ofNameGradeCourses("Fred", 48, "Maths", "Physics"),
        Student.ofNameGradeCourses("Jim", 59, "Art", "History", "Journalism"),
        Student.ofNameGradeCourses("Sheila", 88, "Maths", "Physics", 
            "Astrophysics", "Quantum Physics"),
        Student.ofNameGradeCourses("Mary", 72, "Electronics"),
        Student.ofNameGradeCourses("Mary", 74, "Electronics"),
        Student.ofNameGradeCourses("Mary", 77, "Electronics")
    );
    Map<String, Long> map = schoolList.stream()
        .collect(Collectors.groupingBy(s -> getLetterGrade(s), Collectors.counting()));
        
    map.entrySet().stream()
        .forEach(e -> System.out.println(e.getKey() + " grade achieved by " + e.getValue()));
  }
}
