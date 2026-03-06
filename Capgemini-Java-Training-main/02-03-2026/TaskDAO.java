//package org.example;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.persistence.TypedQuery;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Data Access Object for Task entity
// * Handles all database operations for Task objects
// */
//public class TaskDAO {
//
//    private EntityManagerFactory emf;
//    private EntityManager em;
//
//    /**
//     * Constructor - initializes EntityManagerFactory and EntityManager
//     */
//    public TaskDAO() {
//        // Use the correct persistence unit name - should match persistence.xml
//        this.emf = Persistence.createEntityManagerFactory("taskPU");
//        this.em = emf.createEntityManager();
//    }
//
//    /**
//     * Create a new task in the database
//     * @param task The Task entity to persist
//     * @return TaskDTO of the created task
//     */
//    public TaskDTO create(Task task) {
//        try {
//            // Begin transaction
//            em.getTransaction().begin();
//
//            // Persist the entity
//            em.persist(task);
//
//            // Commit transaction
//            em.getTransaction().commit();
//
//            System.out.println("Task created successfully with ID: " + task.getId());
//
//            // Convert to DTO and return
//            return convertToDTO(task);
//
//        } catch (Exception e) {
//            // Rollback if transaction is active and exception occurred
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.err.println("Error creating task: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * Find a task by its ID
//     * @param id The task ID to search for
//     * @return TaskDTO if found, null otherwise
//     */
//    public TaskDTO findById(Long id) {
//        try {
//            Task task = em.find(Task.class, id);
//            return task != null ? convertToDTO(task) : null;
//        } catch (Exception e) {
//            System.err.println("Error finding task by ID: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * Find all tasks in the database
//     * @return List of TaskDTO objects
//     */
//    public List<TaskDTO> findAll() {
//        try {
//            // Create JPQL query to get all tasks
//            TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
//            List<Task> tasks = query.getResultList();
//
//            // Convert each Task to TaskDTO
//            return tasks.stream()
//                    .map(this::convertToDTO)
//                    .collect(Collectors.toList());
//
//        } catch (Exception e) {
//            System.err.println("Error finding all tasks: " + e.getMessage());
//            e.printStackTrace();
//            return List.of(); // Return empty list on error
//        }
//    }
//
//    /**
//     * Update an existing task
//     * @param taskDTO The task data to update
//     * @return Updated TaskDTO
//     */
//    public TaskDTO update(TaskDTO taskDTO) {
//        try {
//            em.getTransaction().begin();
//
//            // Find the existing task
//            Task existingTask = em.find(Task.class, taskDTO.getId());
//
//            if (existingTask != null) {
//                // Update fields - using the corrected setter methods
//                existingTask.setTask(taskDTO.getTask());
//                existingTask.setDescription(taskDTO.getDescription());
//
//                // Merge the changes (merge is optional here as the entity is managed)
//                Task updatedTask = em.merge(existingTask);
//
//                em.getTransaction().commit();
//
//                System.out.println("Task updated successfully with ID: " + updatedTask.getId());
//                return convertToDTO(updatedTask);
//            } else {
//                em.getTransaction().rollback();
//                System.out.println("Task not found with ID: " + taskDTO.getId());
//                return null;
//            }
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.err.println("Error updating task: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * Delete a task by ID
//     * @param id The ID of the task to delete
//     * @return true if deleted successfully, false otherwise
//     */
//    public boolean delete(Long id) {
//        try {
//            em.getTransaction().begin();
//
//            Task task = em.find(Task.class, id);
//
//            if (task != null) {
//                em.remove(task);
//                em.getTransaction().commit();
//                System.out.println("Task deleted successfully with ID: " + id);
//                return true;
//            } else {
//                em.getTransaction().rollback();
//                System.out.println("Task not found with ID: " + id);
//                return false;
//            }
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.err.println("Error deleting task: " + e.getMessage());
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * Convert Task entity to TaskDTO
//     * @param task The Task entity to convert
//     * @return TaskDTO object
//     */
//    private TaskDTO convertToDTO(Task task) {
//        return new TaskDTO(
//                task.getId(),
//                task.getTask(),
//                task.getDescription()
//        );
//    }
//
//    /**
//     * Convert TaskDTO to Task entity
//     * @param taskDTO The TaskDTO to convert
//     * @return Task entity
//     */
//    private Task convertToEntity(TaskDTO taskDTO) {
//        Task task = new Task();
//        task.setId(taskDTO.getId());
//        task.setTask(taskDTO.getTask());
//        task.setDescription(taskDTO.getDescription());
//        return task;
//    }
//
//    /**
//     * Close resources - should be called when done with DAO
//     */
//    public void close() {
//        if (em != null && em.isOpen()) {
//            em.close();
//        }
//        if (emf != null && emf.isOpen()) {
//            emf.close();
//        }
//        System.out.println("DAO resources closed");
//    }
//}


package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data Access Object for Task entity
 * Handles all database operations for Task objects
 */
public class TaskDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructor - initializes EntityManagerFactory and EntityManager
     */
    public TaskDAO() {
        // Use the correct persistence unit name - should match persistence.xml
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }

    /**
     * Create a new task and assign it to a user
     * @param userId The ID of the user who owns this task
     * @param task The Task entity to persist
     * @return TaskDTO of the created task
     */
    public TaskDTO create(Long userId, Task task) {
        try {
            // Find the user first
            User user = em.find(User.class, userId);

            if (user == null) {
                System.out.println("User not found with id: " + userId);
                return null;
            }

            // Begin transaction
            em.getTransaction().begin();

            // Assign user to task
            task.setUser(user);

            // Persist the entity
            em.persist(task);

            // Commit transaction
            em.getTransaction().commit();

            System.out.println("Task Created for user: " + user.getName() +
                    " | Task id: " + task.getId());

            // Convert to DTO and return
            return convertToDTO(task);

        } catch (Exception e) {
            // Rollback if transaction is active and exception occurred
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error creating task: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Original create method (for tasks without user)
     */
    public TaskDTO create(Task task) {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
            System.out.println("Task created successfully with ID: " + task.getId());
            return convertToDTO(task);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error creating task: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find a task by its ID
     * @param id The task ID to search for
     * @return TaskDTO if found, null otherwise
     */
    public TaskDTO findById(Long id) {
        try {
            Task task = em.find(Task.class, id);
            return task != null ? convertToDTO(task) : null;
        } catch (Exception e) {
            System.err.println("Error finding task by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find all tasks in the database
     * @return List of TaskDTO objects
     */
    public List<TaskDTO> findAll() {
        try {
            TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
            List<Task> tasks = query.getResultList();

            return tasks.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.err.println("Error finding all tasks: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    /**
     * Find tasks by user ID
     * @param userId The user ID to find tasks for
     * @return List of TaskDTO objects for that user
     */
    public List<TaskDTO> findByUserId(Long userId) {
        try {
            TypedQuery<Task> query = em.createQuery(
                    "SELECT t FROM Task t WHERE t.user.id = :userId", Task.class);
            query.setParameter("userId", userId);

            List<Task> tasks = query.getResultList();

            return tasks.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.err.println("Error finding tasks by user ID: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    /**
     * Update an existing task
     * @param taskDTO The task data to update
     * @return Updated TaskDTO
     */
    public TaskDTO update(TaskDTO taskDTO) {
        try {
            em.getTransaction().begin();

            Task existingTask = em.find(Task.class, taskDTO.getId());

            if (existingTask != null) {
                existingTask.setTask(taskDTO.getTask());
                existingTask.setDescription(taskDTO.getDescription());

                Task updatedTask = em.merge(existingTask);
                em.getTransaction().commit();

                System.out.println("Task updated successfully with ID: " + updatedTask.getId());
                return convertToDTO(updatedTask);
            } else {
                em.getTransaction().rollback();
                System.out.println("Task not found with ID: " + taskDTO.getId());
                return null;
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error updating task: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reassign a task to a different user
     * @param taskId The task ID to reassign
     * @param newUserId The new user ID
     * @return Updated TaskDTO
     */
    public TaskDTO reassignTask(Long taskId, Long newUserId) {
        try {
            em.getTransaction().begin();

            Task task = em.find(Task.class, taskId);
            User newUser = em.find(User.class, newUserId);

            if (task == null) {
                em.getTransaction().rollback();
                System.out.println("Task not found with ID: " + taskId);
                return null;
            }

            if (newUser == null) {
                em.getTransaction().rollback();
                System.out.println("User not found with ID: " + newUserId);
                return null;
            }

            // Reassign the task
            task.setUser(newUser);
            Task updatedTask = em.merge(task);

            em.getTransaction().commit();

            System.out.println("Task " + taskId + " reassigned to user: " + newUser.getName());
            return convertToDTO(updatedTask);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error reassigning task: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Delete a task by ID
     * @param id The ID of the task to delete
     * @return true if deleted successfully, false otherwise
     */
    public boolean delete(Long id) {
        try {
            em.getTransaction().begin();

            Task task = em.find(Task.class, id);

            if (task != null) {
                em.remove(task);
                em.getTransaction().commit();
                System.out.println("Task deleted successfully with ID: " + id);
                return true;
            } else {
                em.getTransaction().rollback();
                System.out.println("Task not found with ID: " + id);
                return false;
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error deleting task: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete all tasks for a user
     * @param userId The user ID
     * @return number of tasks deleted
     */
    public int deleteAllUserTasks(Long userId) {
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("DELETE FROM Task t WHERE t.user.id = :userId");
            query.setParameter("userId", userId);

            int deletedCount = query.executeUpdate();

            em.getTransaction().commit();

            System.out.println("Deleted " + deletedCount + " tasks for user ID: " + userId);
            return deletedCount;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error deleting user tasks: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Convert Task entity to TaskDTO
     * @param task The Task entity to convert
     * @return TaskDTO object
     */
    private TaskDTO convertToDTO(Task task) {
        TaskDTO dto = new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getDescription()
        );

        // If you want to include user info in TaskDTO, you'd need to add userId field to TaskDTO
        // dto.setUserId(task.getUser() != null ? task.getUser().getId() : null);

        return dto;
    }

    /**
     * Convert TaskDTO to Task entity
     * @param taskDTO The TaskDTO to convert
     * @return Task entity
     */
    private Task convertToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTask(taskDTO.getTask());
        task.setDescription(taskDTO.getDescription());
        // Note: User needs to be set separately
        return task;
    }

    /**
     * Close resources - should be called when done with DAO
     */
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        System.out.println("DAO resources closed");
    }
}
