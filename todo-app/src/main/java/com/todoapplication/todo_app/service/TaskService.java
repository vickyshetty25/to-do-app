package com.todoapplication.todo_app.service;

import com.todoapplication.todo_app.model.Task;
import com.todoapplication.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByType(String type) {
        return taskRepository.findByType(type);
    }
}
