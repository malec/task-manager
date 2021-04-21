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

    /**
     * @param taskDto task dto to be created
     * @return task dto with id created.
     */
    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTask(taskDto.getTask());
        var res = taskRepository.save(task);
        taskDto.setId(res.getId());
        return taskDto;
    }

    /**
     * @param taskId task id to delete
     */
    public void deleteTask(Long taskId) {
        var optTask = this.taskRepository.findById(taskId);
        optTask.ifPresent(task -> this.taskRepository.delete(task));
    }
}
