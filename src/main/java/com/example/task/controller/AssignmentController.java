package com.example.task.controller;

import com.example.task.dto.Assignment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AssignmentController {
    @PostMapping()
    public void createAssignment(@RequestBody Assignment assignment);
    @DeleteMapping()
    public void deleteAssignment(@RequestBody Assignment assignment);
}
