package com.example.task.controller;

import com.example.task.dto.Assignment;
import com.example.task.dto.Task;
import com.example.task.service.TaskService;
import com.example.task.service.UserService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssignmentControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private AssignmentController assignmentController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assignmentController).build();
    }

    @Test
    public void createAssignmentShouldCreateAndReturnOk() throws Exception {
        mockMvc.perform(post("/assignment").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(new Assignment("userId", "task1")))).andExpect(status().isOk());
        Mockito.verify(userService).assignTask("userId", "task1");
    }

    @Test
    public void deleteAssignment() throws Exception {
        mockMvc.perform(delete("/assignment").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(new Assignment("userId", null)))).andExpect(status().isOk());
        Mockito.verify(userService).deleteAssignment("userId");
    }
}