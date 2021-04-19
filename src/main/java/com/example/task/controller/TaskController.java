package com.example.task.controller;

import com.example.task.dto.Task;
import com.example.task.service.TaskService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/task")
public class TaskController implements ITaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Override
    public void create(Task task) {
        this.taskService.createTask(task);
    }

    @Override
    public void delete(Task task) {
        this.taskService.deleteTask(task.getId());
    }
}
