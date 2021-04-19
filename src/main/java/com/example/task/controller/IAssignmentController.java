package com.example.task.controller;

import com.example.task.dto.Assignment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAssignmentController {
    @PostMapping()
    void createAssignment(@RequestBody Assignment assignment);
    @DeleteMapping()
    void deleteAssignment(@RequestBody Assignment assignment);
}
