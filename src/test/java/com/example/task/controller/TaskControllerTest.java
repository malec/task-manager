package com.example.task.controller;

import com.example.task.dto.TaskDto;
import com.example.task.model.Task;
import com.example.task.service.TaskService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TaskControllerTest {
    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void createTaskShouldCreateAndReturnOk() throws Exception {
        TaskDto task = new TaskDto();
        task.setTask("write tests");
        Mockito.doAnswer(x -> {
            TaskDto taskArg = (TaskDto) x.getArguments()[0];
            taskArg.setId(1L);
            return taskArg;
        }).when(taskService).createTask(task);
        mockMvc.perform(MockMvcRequestBuilders.post("/task")
                .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(task))).andExpect(status().isOk()).andExpect(jsonPath("task", is("write tests"))).andExpect(jsonPath("id", is(1)));
    }

    @Test
    public void deleteTaskShouldCallServiceToDelete() throws Exception {
        TaskDto task = new TaskDto(1L, "write tests");
        mockMvc.perform(MockMvcRequestBuilders.post("/task")
                .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(task))).andExpect(status().isOk());
        Mockito.verify(taskService).createTask(task);
    }
}