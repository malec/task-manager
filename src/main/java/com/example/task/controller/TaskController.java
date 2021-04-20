package com.example.task.controller;

import com.example.task.dto.Task;
import com.example.task.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController implements ITaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * @param task Create a task with task service.
     * @return
     */
    @Override
    public Task create(Task task) {
        return this.taskService.createTask(task);
    }

    /**
     * @param task Task DTO with id to delete by
     */
    @Override
    public void delete(Task task) {
        this.taskService.deleteTask(task.getId());
    }
}
