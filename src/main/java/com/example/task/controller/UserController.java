package com.example.task.controller;

import com.example.task.dto.TaskDto;
import com.example.task.dto.UserDto;
import com.example.task.service.UserService;
import lombok.var;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user
     * Create a user via UserService
     */
    @Override
    public UserDto create(UserDto user) {
        return this.userService.createUser(user);
    }

    /**
     * @param user User DTO with id to delete by
     */
    @Override
    public void delete(UserDto user) {
        this.userService.deleteUser(user.getId());
    }

    @Override
    public void login(UserDto user) {
        var success = userService.login(user.getId(), user.getPassword());
    }
}
