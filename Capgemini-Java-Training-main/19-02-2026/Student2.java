package aStreams;

import java.util.*;
//Student class is created inside StudentMain. Check there.
public class Student2 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Adam", 100, 19),
				new Student("Barry", 90, 20),
				new Student("Charles", 78, 17),
				new Student("Alex", 19, 16),
				new Student("Amanda", 99, 19)
				);
		
		List<Student> passedNew = students.stream()
			    .filter(s -> s.marks > 60)
			    .peek(s-> System.out.println("Passed student name "+s.name))
			    .filter(s -> s.name.startsWith("A"))
			    .peek(s-> System.out.println("Passed student name which start with A: "+s.name))
			    .toList();		
	}
}


