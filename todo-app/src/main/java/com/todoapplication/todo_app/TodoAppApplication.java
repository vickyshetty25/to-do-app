package com.todoapplication.todo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.todoapplication.todo_app.model.Task;
import com.todoapplication.todo_app.repository.TaskRepository;
import com.todoapplication.todo_app.service.TaskService;

@SpringBootApplication
public class TodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	// Example of a CommandLineRunner to initialize sample data
	@Bean
	public CommandLineRunner run(ApplicationContext ctx, TaskService taskService) {
		return (args) -> {
			// Initialize sample data for tasks if needed
			taskService.saveTask(new Task("Complete DSA Assignment", "DSA", "Arrays - Medium", "https://example.com", "Not Started", "Practice arrays for 1D and 2D"));
			taskService.saveTask(new Task("Build To-Do Application", "Development", "Spring Boot Setup", "N/A", "In Progress", "Start working on Spring Boot project"));

			System.out.println("Sample tasks initialized!");
		};
	}
}
