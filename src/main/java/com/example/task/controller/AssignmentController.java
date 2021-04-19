package com.example.task.controller;

import com.example.task.dto.Assignment;
import org.springframework.web.bind.annotation.RestController;

@RestController("/assignment")
public class AssignmentController implements IAssignmentController {

    @Override
    public void createAssignment(Assignment assignment) {

    }

    @Override
    public void deleteAssignment(Assignment assignment) {

    }
}
