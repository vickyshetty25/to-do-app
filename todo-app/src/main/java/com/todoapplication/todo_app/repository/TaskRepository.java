package com.todoapplication.todo_app.repository;

import com.todoapplication.todo_app.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByType(String type);  // Example query method to find tasks by type
}
