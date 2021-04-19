package com.example.task.service;

import com.example.task.dto.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TaskService {
    private final Map<String, Task> stringTaskMap;
    TaskService() {
        this.stringTaskMap = new HashMap<>();
    }
    public void createTask(Task task) {
        this.stringTaskMap.put(task.getId(), task);
    }

    public void deleteTask(String taskId) {
        this.stringTaskMap.remove(taskId);
    }
}
