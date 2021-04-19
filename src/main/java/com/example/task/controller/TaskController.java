package com.example.task.controller;

import com.example.task.dto.Task;
import org.springframework.web.bind.annotation.RestController;

@RestController("/task")
public class TaskController implements ITaskController {
    @Override
    public void create(Task user) {

    }

    @Override
    public void delete(Task user) {

    }
}
