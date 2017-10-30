package hello;

import java.util.TreeSet;

public class School {
	private TreeSet<Student> students;

	public School() {
		super();
		this.students = new TreeSet<Student>();
	}
	
	public School(TreeSet<Student> students) {
		super();
		this.students = students;
	}
	
	public void displayStudents() {
		//Collections.sort(students);
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	
}
