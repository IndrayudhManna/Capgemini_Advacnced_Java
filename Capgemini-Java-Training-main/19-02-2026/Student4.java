package aStreams;

import java.util.*;

/**
 * Student class representing a student with id, name, and age
 * Note: Named Students1 to avoid conflict with another Student class
 */
class Students1 {
    private int id;
    private String name;
    private int age;

    // Constructor to initialize a new student object
    public Students1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter and Setter for id - encapsulation principle
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Override toString to print student object in readable format
    @Override
    public String toString() {
        return "Id:" + id + ", Name:" + name + ", Age:" + age + "";
    }
}

public class Student4 {
    
    // Static main method (not the standard entry point)
    static void main() {
        // Creating a list of students with sample data
        // Arrays.asList() creates a fixed-size list backed by an array
        List<Students1> students = Arrays.asList(
                new Students1(1, "Alice", 20),
                new Students1(2, "Bob", 17),
                new Students1(3, "Charlie", 19),
                new Students1(4, "David", 16),
                new Students1(5, "Eve", 22)
        );

        /**
         * 1. forEach() - Terminal Operation
         * Used to iterate through each element in the stream
         * Takes a Consumer functional interface (accepts input, returns nothing)
         * Why used: To perform an action on each element (like printing)
         */
        System.out.println("forEach - printing names:");
        students.stream()                    // Convert list to stream
                .forEach(s -> System.out.println(s.getName())); // Print each name

        /**
         * 2. count() - Terminal Operation
         * Returns the count of elements in the stream after filtering
         * Why used: To get the number of elements matching a condition
         */
        long count = students.stream()
                .filter(s -> s.getAge() > 18)  // Keep only students older than 18
                .count();                        // Count them
        System.out.println("\ncount() - Students older than 18: " + count);

        /**
         * 3. findFirst() - Short-circuiting Terminal Operation
         * Returns an Optional containing the first element that matches the filter
         * 
         * WHY OPTIONAL IS USED HERE:
         * - If no student is older than 18, findFirst() would return null
         * - Optional forces us to handle the "no value" case explicitly
         * - Prevents NullPointerException that would occur if we directly called .get()
         * - The Optional container may be EMPTY (no value) or PRESENT (has value)
         */
        Optional<Students1> first = students.stream()
                .filter(s -> s.getAge() > 18)  // Filter students older than 18				//findFirst always returns Optional.
                .findFirst();                    // Get the first match (if any)			//if we add an orElse(null/0) at the end of stream then the "Option" text will not  
        																					//appear and we can use the actual dataType at the start of first line instead of Optional
        // orElse(null) means: if Optional is empty, return null instead
        // Better practice would be to use orElse() with a default value
        System.out.println("findFirst() - First student older than 18: " + first.orElse(null));
        
        // Better way to handle Optional:
        first.ifPresentOrElse(
            student -> System.out.println("Found: " + student.getName()),
            () -> System.out.println("No student found")
        );

        /**
         * 4. anyMatch() - Short-circuiting Terminal Operation
         * Returns boolean - true if ANY element matches the condition
         * Stops processing as soon as a match is found (short-circuiting)
         * Why used: To check if at least one element satisfies a condition
         */
        boolean anyAdult = students.stream()
                .anyMatch(s -> s.getAge() > 21);  // Is anyone older than 21?
        System.out.println("anyMatch() - Any student older than 21? " + anyAdult);

        /**
         * 5. allMatch() - Short-circuiting Terminal Operation
         * Returns boolean - true if ALL elements match the condition
         * Stops processing as soon as a non-match is found
         * Why used: To verify if every element satisfies a condition
         */
        boolean allAbove15 = students.stream()
                .allMatch(s -> s.getAge() > 15);  // Is everyone older than 15?
        System.out.println("allMatch() - All students older than 15? " + allAbove15);

        /**
         * 6. noneMatch() - Short-circuiting Terminal Operation
         * Returns boolean - true if NO elements match the condition
         * Opposite of anyMatch()
         * Why used: To ensure no element satisfies a condition
         */
        boolean noneBelow16 = students.stream()
                .noneMatch(s -> s.getAge() < 16);  // Is no one younger than 16?
        System.out.println("noneMatch() - No student younger than 16? " + noneBelow16);

        /**
         * 7. reduce() - Terminal Operation
         * Combines elements into a single result using a binary operator
         * Returns an Optional because the stream might be empty
         * 
         * WHY OPTIONAL IS USED HERE:
         * - If the stream is empty, there's nothing to reduce
         * - The reduce operation might have no result
         * - Optional.empty() is returned for empty streams
         * - Using Optional prevents us from assuming a result always exists
         * 
         * In this case: (a, b) -> a + b means:
         * - Take two ages and add them
         * - Continue until all ages are summed
         * - Result: single Integer (total of all ages)
         */
        Optional<Integer> totalAge = students.stream()							 // reduce always returns Optional
                .map(Students1::getAge)  //same as .map(s -> s.getAge())         // Convert Student stream to Integer stream (ages)
                .reduce((a, b) -> a + b);         // Add all ages together		//if we add an orElse(null/0) at the end of stream then the "Option" text will not  
																				//appear and we can use the actual dataType at the start of first line instead of Optional
        
        // orElse(0) means: if Optional is empty (no students), return 0
        System.out.println("reduce() - Sum of all ages: " + totalAge.orElse(0));
        
        // Demonstrate proper Optional handling:
        totalAge.ifPresentOrElse(
            sum -> System.out.println("Total age sum: " + sum),
            () -> System.out.println("No students to sum")
        );
    }

    /**
     * Standard main method - program entry point
     * Calls our static main() method that contains the stream operations
     */
    public static void main(String[] args) {
        main(); // calling the static method
    }
}