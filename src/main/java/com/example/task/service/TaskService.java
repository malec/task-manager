package com.example.task.service;

import com.example.task.dto.TaskDto;
import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
    TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTask(taskDto.getTask());
        var res = taskRepository.save(task);
        taskDto.setId(res.getId());
        return taskDto;
    }

    public void deleteTask(Long taskId) {
        var optTask = this.taskRepository.findById(taskId);
        optTask.ifPresent(task -> this.taskRepository.delete(task));
    }
}
