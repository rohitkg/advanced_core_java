package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student /*implements Comparable<Student>*/ {
	private String name;
	private float averageGrade;
	private List<String> coursesEnrolled; //ideally should be enum
	
	public Student(String name) {
		super();
		this.name = name;
		this.coursesEnrolled = new ArrayList<String>();
	}

	public Student(String name, float averageGrade, String ... courses) {
		super();
		this.name = name;
		this.averageGrade = averageGrade;
		this.coursesEnrolled = Arrays.asList(courses);//new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!(name != null && name.length() >0)) {
			System.out.println("Name should not be empty"); //ideally should be raising exceptions
		}
		
		this.name = name;
	}

	public float getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(float averageGrade) {
		if(! (averageGrade >= 0.0f && averageGrade <= 100.0f )) {
			System.out.println("averageGrade is outside range (0-100): " + averageGrade);
			return;
		}
		
		this.averageGrade = averageGrade;
	}

	public List<String> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(List<String> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}
	
	public void addCourse(String courseName) {
		if(courseName !=null && courseName.length() > 0)
			this.coursesEnrolled.add(courseName);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + ", " + this.averageGrade + ", " + this.coursesEnrolled + "]";
	}
	
	//Name comparison
	private static Comparator<Student> NameComparator = (s1, s2) -> s1.name.compareTo(s2.name);
	public static Comparator<Student> getNameComparator() {
		return NameComparator;
	}
	
	private static Comparator<Student> GradeComparator = (s1, s2) -> Float.compare(s1.averageGrade, s2.averageGrade);
	public static Comparator<Student> getGradeComparator() {
		return GradeComparator;
	}

	/*@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.getName());
		
	}*/
	
	
}
