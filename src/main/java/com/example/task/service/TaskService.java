package com.example.task.service;

import com.example.task.dto.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TaskService {
    private final Map<String, Task> stringTaskMap;
    TaskService() {
        this.stringTaskMap = new HashMap<>();
    }
    public Task createTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        this.stringTaskMap.put(task.getId(), task);
        return task;
    }

    public void deleteTask(String taskId) {
        this.stringTaskMap.remove(taskId);
    }
}
