package com.example.task.controller;

import com.example.task.dto.Assignment;
import com.example.task.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignment")
public class AssignmentController implements IAssignmentController {
    private final UserService userService;
    AssignmentController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param assignment DTO to create by user id and task id
     */
    @Override
    public void createAssignment(Assignment assignment) {
        this.userService.assignTask(assignment.getUserId(), assignment.getTaskId());
    }

    /**
     * @param assignment DTO to delete by user id
     */
    @Override
    public void deleteAssignment(Assignment assignment) {
        this.userService.deleteAssignment(assignment.getUserId());
    }
}
