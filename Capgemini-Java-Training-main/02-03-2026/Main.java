package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;  // Add this

/**
 * Main application class to test JPA configuration and database connection
 */
public class Main {
    // ... rest of your code

private static void testCreateTaskForUser() {
    System.out.println("\n=== TESTING CREATE TASK FOR USER ===");

    TaskDAO taskDAO = new TaskDAO();
    UserDAO userDAO = new UserDAO();

    try {
        // First create a user
        User user = new User("Alice", "alice@example.com");
        UserDTO savedUser = userDAO.create(user);

        if (savedUser != null) {
            // Create a task for this user
            Task task = new Task();
            task.setTask("Complete project");
            task.setDescription("Finish the JPA implementation");

            TaskDTO savedTask = taskDAO.create(savedUser.getId(), task);
            System.out.println("Task created for user: " + savedTask);

            // Find all tasks for this user
            List<TaskDTO> userTasks = taskDAO.findByUserId(savedUser.getId());
            System.out.println("All tasks for user " + savedUser.getName() + ":");
            userTasks.forEach(System.out::println);
        }

    } finally {
        taskDAO.close();
        userDAO.close();
    }
}}