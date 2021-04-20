package com.example.task.controller;

import com.example.task.dto.User;
import com.example.task.service.UserService;
import com.google.gson.Gson;
import lombok.var;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    /**
     * @throws Exception
     * Test to see if the controller calls the createUser method in user service with the contents in the body.
     */
    @Test
    public void createShouldCallService() throws Exception {
        var user = new User("first", "last", "id", "taskId");
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user))).andExpect(status().isOk());
        Mockito.verify(userService).createUser(user);
    }

    /**
     * @throws Exception
     * Test to see if the controller calls the deleteUser method in user service with the id in the body.
     */
    @Test
    public void deleteShouldCallService() throws Exception {
        var user = new User();
        user.setId("1");
        mockMvc.perform(delete("/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user))).andExpect(status().isOk());
        Mockito.verify(userService).deleteUser("1");
    }
}