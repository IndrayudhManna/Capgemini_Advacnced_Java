package org.example;

import jakarta.persistence.*;

/**
 * JPA Entity class representing a Task in the database
 * Maps to the "Task" table in the database
 */
@Entity
@Table(name = "tasks123") // Optional: specify table name if different from class name
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-increment primary key
    private Long id;

    @Column(name = "task", nullable = false) // Column mapping with constraints
    private String task;

    @Column(name = "description") // Additional field for task description
    private String description;

    // Default constructor (required by JPA)
    public Task() {
    }

    // Parameterized constructor for convenience
    public Task(String task, String description) {
        this.task = task;
        this.description = description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    // Setters - each with proper parameters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}