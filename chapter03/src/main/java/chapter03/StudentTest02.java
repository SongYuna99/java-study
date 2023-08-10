package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		// upcasting(암시적, Implicity)
		Person p = s1;
		// downcasting(명시적, Explicity)
		Student s2 = (Student)p;
		
	}

}
