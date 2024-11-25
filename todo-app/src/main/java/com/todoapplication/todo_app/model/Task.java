package com.todoapplication.todo_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;  // MongoDB typically uses String as the ID type (ObjectId)
    private String name;
    private String type; // "DSA" or "Development"
    private String subtask;
    private String link;
    private String status; // "Not Started", "In Progress", "Completed"
    private String notes;

    // No-argument constructor (required by MongoDB)
    public Task() {
    }

    // Constructor with arguments for initializing fields
    public Task(String name, String type, String subtask, String link, String status, String notes) {
        this.name = name;
        this.type = type;
        this.subtask = subtask;
        this.link = link;
        this.status = status;
        this.notes = notes;
    }

    // Getters and Setters for each field
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
