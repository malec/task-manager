package com.example.task.controller;

import com.example.task.dto.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/task")
public interface ITaskController {
    @PostMapping()
    Task create(@RequestBody Task user);
    @DeleteMapping()
    void delete(@RequestBody Task user);
}
