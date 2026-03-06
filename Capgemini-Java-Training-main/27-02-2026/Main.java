package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Main application class to test JPA configuration and database connection
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting JPA...");

        // Create EntityManagerFactory using persistence unit name from persistence.xml
        // "taskPU" should match the persistence-unit name in your persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");

        System.out.println("EntityManagerFactory created successfully!");

        // Close the factory to release resources
        emf.close();

        System.out.println("Closed successfully!");

        // Optional: Test TaskDAO functionality
        testTaskDAO();
    }

    /**
     * Test method to demonstrate TaskDAO operations
     */
    private static void testTaskDAO() {
        System.out.println("\n--- Testing TaskDAO ---");

        // Create DAO instance
        TaskDAO taskDAO = new TaskDAO();

        // Create a new task
        Task newTask = new Task();
        newTask.setTask("Complete JPA assignment");
        newTask.setDescription("Finish the JPA tutorial and implement CRUD operations");

        // Save the task
        TaskDTO savedTask = taskDAO.create(newTask);
        System.out.println("Saved Task: " + savedTask);

        // Find task by ID
        TaskDTO foundTask = taskDAO.findById(1L);
        System.out.println("Found Task: " + foundTask);

        // Find all tasks
        System.out.println("\nAll Tasks:");
        taskDAO.findAll().forEach(System.out::println);

        // Update task
        if (foundTask != null) {
            foundTask.setDescription("Updated description for the task");
            TaskDTO updatedTask = taskDAO.update(foundTask);
            System.out.println("Updated Task: " + updatedTask);
        }

        // Delete task (be careful with this!)
        // taskDAO.delete(1L);

        // Close DAO resources
        taskDAO.close();
    }
}