package com.example.task.controller;

import com.example.task.dto.Assignment;
import com.example.task.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/assignment")
public class AssignmentController implements IAssignmentController {
    private final UserService userService;
    AssignmentController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void createAssignment(Assignment assignment) {
        this.userService.assignTask(assignment.getUserId(), assignment.getTaskId());
    }

    @Override
    public void deleteAssignment(Assignment assignment) {
        this.userService.deleteAssignment(assignment.getUserId());
    }
}
