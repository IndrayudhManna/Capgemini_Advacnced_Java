package aStreams;

import java.util.*;
//Student class is created inside StudentMain. Check there.
public class Student3 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Adam", 100, 19),
				new Student("Barry", 90, 20),
				new Student("Charles", 78, 17),
				new Student("Alex", 100, 16),
				new Student("Amanda", 99, 19),
				new Student("Adam", 100, 15),
				new Student("Ashton", 100, 26)
				);
		
		List<Student> sortedStudents = students.stream()
		        .sorted(Comparator									//.sorted() without comparator sorts normally but won't work for objects.
		                .comparingInt((Student s) -> s.marks)		//for int .comparingInt or thenComparingInt
		                											//only need to mention (Student s) for the first comparing
		                .thenComparing(s -> s.name, Comparator.reverseOrder())		//.reversed() reverses the order			
		                .thenComparingInt(s -> s.age)				//for String only .comparing or .thenComparing
		        		)
		        .toList();
		for(Student s:sortedStudents) {								
			System.out.println("Name:"+s.name+"  Marks:"+s.marks+"  Age:"+s.age);
			//sorted list in order of marks then reverse order of name then age.
		}
	}
		
}

