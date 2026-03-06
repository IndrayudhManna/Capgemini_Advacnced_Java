package org.example;

/**
 * Data Transfer Object for Task entity
 * Used to transfer data between layers without exposing entity directly
 * DTOs are useful for:
 * - Reducing network traffic (only send needed data)
 * - Decoupling internal entity structure from API
 * - Adding/removing fields without affecting database schema
 */
public class TaskDTO {

    // Using Long to match entity ID type (consistency is better)
    private Long id;

    private String task;

    private String description;

    // Default Constructor
    public TaskDTO() {
    }

    // Parameterized constructor with all fields
    public TaskDTO(Long id, String task, String description) {
        this.id = id;
        this.task = task;
        this.description = description;
    }

    // Constructor without ID (for new tasks)
    public TaskDTO(String task, String description) {
        this.task = task;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}