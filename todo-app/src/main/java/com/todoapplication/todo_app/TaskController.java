package com.todoapplication.todo_app;

import com.todoapplication.todo_app.service.TaskService;
import com.todoapplication.todo_app.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(@RequestParam(defaultValue = "Development") String type, Model model) {
        System.out.println("Accessing /tasks URL");
        model.addAttribute("tasks", taskService.getTasksByType(type));  // Fetch tasks by type
        model.addAttribute("task", new Task());  // Add an empty task object for the form
        model.addAttribute("type", type);  // Pass the type to the view
        return "task-list";  // Return to the Thymeleaf template
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task) {
        taskService.saveTask(task);  // Save task through service layer
        return "redirect:/tasks?type=" + task.getType();  // Redirect to the task list with type as query param
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, @RequestParam String type) {
        taskService.deleteTask(id);  // Delete the task by id
        return "redirect:/tasks?type=" + type;  // Redirect to the task list of the same type
    }
}

