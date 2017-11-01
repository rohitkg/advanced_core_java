package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class School {
	private TreeSet<Student> students;

	public TreeSet<Student> getStudents() {
		return students;
	}

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
	
//	public static TreeSet<Student> getSmartStudents(TreeSet<Student> student, StudentCriterion sc) {
//		TreeSet<Student> newSet = new TreeSet<Student>(Student.getNameComparator());
//		for(Student s : student) {
//			if(sc.test(s)) 
//				newSet.add(s);
//		}
//		
//		return newSet;
//	}
	
	public static <E> List<E> filter(Iterable<E> in, MyCriterion<E> mc) {
		List<E> res = new ArrayList<E>();
		for(E curr : in) {
			if(mc.test(curr))
				res.add(curr);
		}
		
		return res;
	}
	
	public static <E> MyCriterion<E> inverse(MyCriterion<E> e) {
		return o -> !e.test(o);
	}
	
	public static <E> MyCriterion<E> and(MyCriterion<E> e1, MyCriterion<E> e2) {
		return e -> e1.test(e) && e2.test(e);
	}
	
	public static <E> MyCriterion<E> or(MyCriterion<E> e1, MyCriterion<E> e2) {
		return e -> e1.test(e) || e2.test(e);
	}
	
}
