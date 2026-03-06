package aStreams;
import java.util.*;
public class Student5 {
//Students1 implementation is in Student4 file
	public static void main(String[] args) {
		  List<Students1> students = Arrays.asList(
	                new Students1(1, "Alice", 20),
	                new Students1(2, "Bob", 17),
	                new Students1(3, "Charlie", 19),
	                new Students1(4, "David", 16),
	                new Students1(5, "Eve", 21)
	        );
		  
		  
		//Get all names
		List <String> names = students.stream()
							.map(s -> s.getName())
							.toList();
		for(String s:names) {								
			System.out.println(s);
		}
		
		
		
		//Count adults
		Long adultsCount= students.stream()
				.filter(s -> s.getAge()>=18)
				.count();
		System.out.println("Number of adults "+adultsCount);
		
		
		
		//age between 18 and 40, double the age and store as a student object
		List<Students1> doubleAge = students.stream()
									.filter(s -> (s.getAge()>18 && s.getAge()<40))
									.map(s -> new Students1(s.getId(),s.getName(), s.getAge()*2))
									.toList();
		for(Students1 s:doubleAge) {								
			System.out.println("Id: "+s.getId()+ "  Name:"+ s.getName()+ "  Double Age: "+s.getAge());
		}
		
		
		//first minor student
		Students1 firstKid = students.stream()
						.filter(s -> s.getAge()<18)
						.findFirst()
						.orElse(null);				//for .findFirst() -> use orElse(null/0) at the end cuz it returns Optional
													
					System.out.println("First Minor: "+firstKid);
		

					
		//Sum of age of all adults
			Integer sumOfAges = students.stream()
										.filter(s -> s.getAge()>=18)
										.map(s -> s.getAge())
										.reduce((a,b) -> a+b)
										.orElse(0);       //for .reduce() -> use orElse(null/0) at the end cuz it returns Optional
				System.out.println("Total age of adults is: "+sumOfAges);
				
				
		//if all are adult
			Boolean ifAdult = students.stream()
							.allMatch(s -> s.getAge()>=18)
							;
			
			System.out.println("Are all adults? "+ifAdult);
	
	
	
	}
		
	}


