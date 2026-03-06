package aStreams;
import java.util.*;
public class Student1 {

	public static void main(String[] args) {
		List<Student> students = List.of(
				new Student("A", 100, 19),
				new Student("B", 90, 20),
				new Student("C", 78, 17),
				new Student("D", 19, 16)
				);
		List <Student> adult= students.stream()			//creates a list adult and adds the adult students in it.
							.filter(s -> s.age>=18)
							.toList();
		for(Student s:adult) {							//prints the name of students who are adult.
			System.out.println(s.name+" is an adult");
		}
		
		
		
		
		List<Student> passed = students.stream()				//creates a list passed and adds students with marks higher than 60.
								.filter(s -> s.marks > 60)
								.toList();
		System.out.println("Passed students count: "+passed.size());   //prints the count of passed students.
		
		
		
		
		
		List<Student> passedNew = students.stream()
			    .filter(s -> s.marks > 60)
			    .peek(s-> System.out.println("Passed student name "+s.name)) //.peek does a task. Here it is printing a String.
			    											//To print you have to mention the object as 's->'.
			    .peek(s -> s.setMarks(s.marks*2))			//Here it is doubling the marks and setting it to s.marks.
			    .peek(s -> s.marks=s.marks*3)       		//If marks isn't private no setMarks() is needed. You have to mention 's.marks='.
			    											//NOTE : peek permanently changes the value.
			    											//You have to mention 's.marks='. Only .peek(s -> s.marks*2) won't work.
			    .map(s -> new Student(s.name, s.marks * 4, s.age))  // Create new Student with doubled marks.
			    .peek(System.out::println)				//Prints the object address. You can override it with toString inside the Student class. 
			    .toList();								// If you do .map(s -> s.marks*2) it will only save the INTEGER value of the marks and not the entire object.
			    
		for(Student s:passedNew) {								//prints the *2*3*4 of students' marks who have passed.
			System.out.println(s.name+" has passed and 24 times of his marks is: "+s.marks);
		}
		
	
	}

}

class Student{
	public String name;
	public int marks;
	public int age;
	
	public Student(String name, int marks, int age) {
		this.name = name;
		this.marks = marks;
		this.age = age;
	}
	@Override
	public String toString() {
		return name+" has "+marks+" marks and is "+age+" years old.";
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
