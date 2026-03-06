package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data Access Object for User entity
 */
public class UserDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDAO() {
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }

    /**
     * Create a new user
     */
    public UserDTO create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("User created successfully with ID: " + user.getId());
            return convertToDTO(user);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error creating user: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find user by ID
     */
    public UserDTO findById(Long id) {
        try {
            User user = em.find(User.class, id);
            return user != null ? convertToDTO(user) : null;
        } catch (Exception e) {
            System.err.println("Error finding user: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find user by email (unique constraint recommended)
     */
    public UserDTO findByEmail(String email) {
        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);

            User user = query.getSingleResult();
            return convertToDTO(user);
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.err.println("Error finding user by email: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find all users
     */
    public List<UserDTO> findAll() {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();

            return users.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error finding all users: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    /**
     * Update user
     */
    public UserDTO update(UserDTO userDTO) {
        try {
            em.getTransaction().begin();

            User existingUser = em.find(User.class, userDTO.getId());

            if (existingUser != null) {
                existingUser.setName(userDTO.getName());
                existingUser.setEmail(userDTO.getEmail());

                User updatedUser = em.merge(existingUser);
                em.getTransaction().commit();

                System.out.println("User updated successfully: " + updatedUser.getId());
                return convertToDTO(updatedUser);
            } else {
                em.getTransaction().rollback();
                System.out.println("User not found with ID: " + userDTO.getId());
                return null;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error updating user: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Delete user
     */
    public boolean delete(Long id) {
        try {
            em.getTransaction().begin();

            User user = em.find(User.class, id);

            if (user != null) {
                em.remove(user);
                em.getTransaction().commit();
                System.out.println("User deleted successfully: " + id);
                return true;
            } else {
                em.getTransaction().rollback();
                System.out.println("User not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error deleting user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all tasks for a user
     */
    public List<TaskDTO> getUserTasks(Long userId) {
        try {
            User user = em.find(User.class, userId);
            if (user != null && user.getTasks() != null) {
                return user.getTasks().stream()
                        .map(task -> new TaskDTO(
                                task.getId(),
                                task.getTask(),
                                task.getDescription()
                        ))
                        .collect(Collectors.toList());
            }
            return List.of();
        } catch (Exception e) {
            System.err.println("Error getting user tasks: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    /**
     * Convert User to UserDTO
     */
    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    /**
     * Convert UserDTO to User
     */
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    /**
     * Close resources
     */
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        System.out.println("UserDAO resources closed");
    }
}